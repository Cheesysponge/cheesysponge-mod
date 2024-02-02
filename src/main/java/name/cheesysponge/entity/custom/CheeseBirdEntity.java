package name.cheesysponge.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.*;


import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

public class CheeseBirdEntity extends FlyingEntity
        implements Monster, IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    CheeseBirdMovementType movementType = CheeseBirdMovementType.CIRCLE;
    Vec3d targetPosition = Vec3d.ZERO;

    BlockPos circlingCenter = BlockPos.ORIGIN;
    public CheeseBirdEntity(EntityType<? extends CheeseBirdEntity> entityType, World world) {
        super((EntityType<? extends FlyingEntity>)entityType, world);
        this.experiencePoints = 5;
        this.moveControl = new CheeseBirdMoveControl(this);
        this.lookControl = new CheeseBirdLookControl(this);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return FlyingEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 32.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 4.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8f);
    }
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(3, new PounceAtTargetGoal(this, 0.4f));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.targetSelector.add(6, new ActiveTargetGoal<>(this, AbstractSkeletonEntity.class, false));
        this.goalSelector.add(1, new StartAttackGoal());
        this.goalSelector.add(2, new SwoopMovementGoal());
        this.goalSelector.add(3, new CircleMovementGoal());
        this.targetSelector.add(1, new FindTargetGoal());

    }
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.flying", true));
            return PlayState.CONTINUE;
        }
        else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.sitting", true));
            return PlayState.CONTINUE;
        }
    }

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    class StartAttackGoal
            extends Goal {
        private int cooldown;

        StartAttackGoal() {
        }

        @Override
        public boolean canStart() {
            LivingEntity livingEntity = CheeseBirdEntity.this.getTarget();
            if (livingEntity != null) {
                return CheeseBirdEntity.this.isTarget(livingEntity, TargetPredicate.DEFAULT);
            }
            return false;
        }

        @Override
        public void start() {
            this.cooldown = this.getTickCount(10);
            CheeseBirdEntity.this.movementType = CheeseBirdMovementType.CIRCLE;
            this.startSwoop();
        }

        @Override
        public void stop() {
            CheeseBirdEntity.this.circlingCenter = CheeseBirdEntity.this.world.getTopPosition(Heightmap.Type.MOTION_BLOCKING, CheeseBirdEntity.this.circlingCenter).up(10 + CheeseBirdEntity.this.random.nextInt(20));
        }

        @Override
        public void tick() {
            if (CheeseBirdEntity.this.movementType == CheeseBirdMovementType.CIRCLE) {
                --this.cooldown;
                if (this.cooldown <= 0) {
                    CheeseBirdEntity.this.movementType = CheeseBirdMovementType.SWOOP;
                    this.startSwoop();
                    this.cooldown = this.getTickCount((8 + CheeseBirdEntity.this.random.nextInt(4)) * 20);
                    CheeseBirdEntity.this.playSound(SoundEvents.ENTITY_PHANTOM_SWOOP, 10.0f, 0.95f + CheeseBirdEntity.this.random.nextFloat() * 0.1f);
                }
            }
        }

        private void startSwoop() {
            CheeseBirdEntity.this.circlingCenter = CheeseBirdEntity.this.getTarget().getBlockPos().up(20 + CheeseBirdEntity.this.random.nextInt(20));
            if (CheeseBirdEntity.this.circlingCenter.getY() < CheeseBirdEntity.this.world.getSeaLevel()) {
                CheeseBirdEntity.this.circlingCenter = new BlockPos(CheeseBirdEntity.this.circlingCenter.getX(), CheeseBirdEntity.this.world.getSeaLevel() + 1, CheeseBirdEntity.this.circlingCenter.getZ());
            }
        }
    }

    class CheeseBirdMoveControl
            extends MoveControl {
        private float targetSpeed;

        public CheeseBirdMoveControl(MobEntity owner) {
            super(owner);
            this.targetSpeed = 0.1f;
        }

        @Override
        public void tick() {
            if (CheeseBirdEntity.this.horizontalCollision) {
                CheeseBirdEntity.this.setYaw(CheeseBirdEntity.this.getYaw() + 180.0f);
                this.targetSpeed = 0.1f;
            }
            double d = CheeseBirdEntity.this.targetPosition.x - CheeseBirdEntity.this.getX();
            double e = CheeseBirdEntity.this.targetPosition.y - CheeseBirdEntity.this.getY();
            double f = CheeseBirdEntity.this.targetPosition.z - CheeseBirdEntity.this.getZ();
            double g = Math.sqrt(d * d + f * f);
            if (Math.abs(g) > (double)1.0E-5f) {
                double h = 1.0 - Math.abs(e * (double)0.7f) / g;
                g = Math.sqrt((d *= h) * d + (f *= h) * f);
                double i = Math.sqrt(d * d + f * f + e * e);
                float j = CheeseBirdEntity.this.getYaw();
                float k = (float)MathHelper.atan2(f, d);
                float l = MathHelper.wrapDegrees(CheeseBirdEntity.this.getYaw() + 90.0f);
                float m = MathHelper.wrapDegrees(k * 57.295776f);
                CheeseBirdEntity.this.setYaw(MathHelper.stepUnwrappedAngleTowards(l, m, 4.0f) - 90.0f);
                CheeseBirdEntity.this.bodyYaw = CheeseBirdEntity.this.getYaw();
                this.targetSpeed = MathHelper.angleBetween(j, CheeseBirdEntity.this.getYaw()) < 3.0f ? MathHelper.stepTowards(this.targetSpeed, 1.8f, 0.005f * (1.8f / this.targetSpeed)) : MathHelper.stepTowards(this.targetSpeed, 0.2f, 0.025f);
                float n = (float)(-(MathHelper.atan2(-e, g) * 57.2957763671875));
                CheeseBirdEntity.this.setPitch(n);
                float o = CheeseBirdEntity.this.getYaw() + 90.0f;
                double p = (double)(this.targetSpeed * MathHelper.cos(o * ((float)Math.PI / 180))) * Math.abs(d / i);
                double q = (double)(this.targetSpeed * MathHelper.sin(o * ((float)Math.PI / 180))) * Math.abs(f / i);
                double r = (double)(this.targetSpeed * MathHelper.sin(n * ((float)Math.PI / 180))) * Math.abs(e / i);
                Vec3d vec3d = CheeseBirdEntity.this.getVelocity();
                CheeseBirdEntity.this.setVelocity(vec3d.add(new Vec3d(p, r, q).subtract(vec3d).multiply(0.2)));
            }
        }
    }
    class CheeseBirdLookControl
            extends LookControl {
        public CheeseBirdLookControl(MobEntity entity) {
            super(entity);
        }

        @Override
        public void tick() {
        }
    }

    static enum CheeseBirdMovementType {
        CIRCLE,
        SWOOP;

    }



    class CircleMovementGoal
            extends MovementGoal {
        private float angle;
        private float radius;
        private float yOffset;
        private float circlingDirection;

        CircleMovementGoal() {
        }

        @Override
        public boolean canStart() {
            return CheeseBirdEntity.this.getTarget() == null || CheeseBirdEntity.this.movementType == CheeseBirdMovementType.CIRCLE;
        }

        @Override
        public void start() {
            this.radius = 5.0f + CheeseBirdEntity.this.random.nextFloat() * 10.0f;
            this.yOffset = -4.0f + CheeseBirdEntity.this.random.nextFloat() * 9.0f;
            this.circlingDirection = CheeseBirdEntity.this.random.nextBoolean() ? 1.0f : -1.0f;
            this.adjustDirection();
        }

        @Override
        public void tick() {
            if (CheeseBirdEntity.this.random.nextInt(this.getTickCount(350)) == 0) {
                this.yOffset = -4.0f + CheeseBirdEntity.this.random.nextFloat() * 9.0f;
            }
            if (CheeseBirdEntity.this.random.nextInt(this.getTickCount(250)) == 0) {
                this.radius += 1.0f;
                if (this.radius > 15.0f) {
                    this.radius = 5.0f;
                    this.circlingDirection = -this.circlingDirection;
                }
            }
            if (CheeseBirdEntity.this.random.nextInt(this.getTickCount(450)) == 0) {
                this.angle = CheeseBirdEntity.this.random.nextFloat() * 2.0f * (float)Math.PI;
                this.adjustDirection();
            }
            if (this.isNearTarget()) {
                this.adjustDirection();
            }
            if (CheeseBirdEntity.this.targetPosition.y < CheeseBirdEntity.this.getY() && !CheeseBirdEntity.this.world.isAir(CheeseBirdEntity.this.getBlockPos().down(1))) {
                this.yOffset = Math.max(1.0f, this.yOffset);
                this.adjustDirection();
            }
            if (CheeseBirdEntity.this.targetPosition.y > CheeseBirdEntity.this.getY() && !CheeseBirdEntity.this.world.isAir(CheeseBirdEntity.this.getBlockPos().up(1))) {
                this.yOffset = Math.min(-1.0f, this.yOffset);
                this.adjustDirection();
            }
        }

        private void adjustDirection() {
            if (BlockPos.ORIGIN.equals(CheeseBirdEntity.this.circlingCenter)) {
                CheeseBirdEntity.this.circlingCenter = CheeseBirdEntity.this.getBlockPos();
            }
            this.angle += this.circlingDirection * 15.0f * ((float)Math.PI / 180);
            CheeseBirdEntity.this.targetPosition = Vec3d.of(CheeseBirdEntity.this.circlingCenter).add(this.radius * MathHelper.cos(this.angle), -4.0f + this.yOffset, this.radius * MathHelper.sin(this.angle));
        }
    }

    abstract class MovementGoal
            extends Goal {
        public MovementGoal() {
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        protected boolean isNearTarget() {
            return CheeseBirdEntity.this.targetPosition.squaredDistanceTo(CheeseBirdEntity.this.getX(), CheeseBirdEntity.this.getY(), CheeseBirdEntity.this.getZ()) < 4.0;
        }
    }
    class SwoopMovementGoal
            extends CheeseBirdEntity.MovementGoal {
        private static final int CAT_CHECK_INTERVAL = 20;
        private boolean catsNearby;
        private int nextCatCheckAge;

        SwoopMovementGoal() {
        }

        @Override
        public boolean canStart() {
            return CheeseBirdEntity.this.getTarget() != null && CheeseBirdEntity.this.movementType == CheeseBirdEntity.CheeseBirdMovementType.SWOOP;
        }

        @Override
        public boolean shouldContinue() {
            LivingEntity livingEntity = CheeseBirdEntity.this.getTarget();
            if (livingEntity == null) {
                return false;
            }
            if (!livingEntity.isAlive()) {
                return false;
            }
            if (livingEntity instanceof PlayerEntity) {
                PlayerEntity playerEntity = (PlayerEntity) livingEntity;
                if (livingEntity.isSpectator() || playerEntity.isCreative()) {
                    return false;
                }
            }
            if (!this.canStart()) {
                return false;
            }
            return true;

        }
    }

    class FindTargetGoal
            extends Goal {
        private final TargetPredicate PLAYERS_IN_RANGE_PREDICATE = TargetPredicate.createAttackable().setBaseMaxDistance(64.0);
        private int delay = CheeseBirdEntity.FindTargetGoal.toGoalTicks(20);

        FindTargetGoal() {
        }

        @Override
        public boolean canStart() {
            if (this.delay > 0) {
                --this.delay;
                return false;
            }
            this.delay = CheeseBirdEntity.FindTargetGoal.toGoalTicks(60);
            List<PlayerEntity> list = CheeseBirdEntity.this.world.getPlayers(this.PLAYERS_IN_RANGE_PREDICATE, CheeseBirdEntity.this, CheeseBirdEntity.this.getBoundingBox().expand(16.0, 64.0, 16.0));
            if (!list.isEmpty()) {
                list.sort(Comparator.comparing(Entity::getY).reversed());
                for (PlayerEntity playerEntity : list) {
                    if (!CheeseBirdEntity.this.isTarget(playerEntity, TargetPredicate.DEFAULT)) continue;
                    CheeseBirdEntity.this.setTarget(playerEntity);
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean shouldContinue() {
            LivingEntity livingEntity = CheeseBirdEntity.this.getTarget();
            if (livingEntity != null) {
                return CheeseBirdEntity.this.isTarget(livingEntity, TargetPredicate.DEFAULT);
            }
            return false;
        }
    }


}
