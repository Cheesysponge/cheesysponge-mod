package name.cheesysponge.block.custom;

import name.cheesysponge.block.entity.CheeseBlasterBlockEntity;
import name.cheesysponge.block.entity.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class CheeseBlasterBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public CheeseBlasterBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(-1, 3, 1, 0, 17, 15),
            Block.createCuboidShape(16, 3, 1, 17, 17, 15),
            Block.createCuboidShape(1, 3, 16, 15, 17, 17),
            Block.createCuboidShape(1, 3, -1, 15, 17, 0),
            Block.createCuboidShape(1, 17, 1, 15, 18, 15),
            Block.createCuboidShape(1, 2, 1, 15, 3, 15),
            Block.createCuboidShape(5, 8, 5, 11, 13, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(-1, 3, 1, 0, 17, 15),
            Block.createCuboidShape(16, 3, 1, 17, 17, 15),
            Block.createCuboidShape(1, 3, 16, 15, 17, 17),
            Block.createCuboidShape(1, 3, -1, 15, 17, 0),
            Block.createCuboidShape(1, 17, 1, 15, 18, 15),
            Block.createCuboidShape(1, 2, 1, 15, 3, 15),
            Block.createCuboidShape(5, 8, 5, 11, 13, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(-1, 3, 1, 0, 17, 15),
            Block.createCuboidShape(16, 3, 1, 17, 17, 15),
            Block.createCuboidShape(1, 3, 16, 15, 17, 17),
            Block.createCuboidShape(1, 3, -1, 15, 17, 0),
            Block.createCuboidShape(1, 17, 1, 15, 18, 15),
            Block.createCuboidShape(1, 2, 1, 15, 3, 15),
            Block.createCuboidShape(5, 8, 5, 11, 13, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(-1, 3, 1, 0, 17, 15),
            Block.createCuboidShape(16, 3, 1, 17, 17, 15),
            Block.createCuboidShape(1, 3, 16, 15, 17, 17),
            Block.createCuboidShape(1, 3, -1, 15, 17, 0),
            Block.createCuboidShape(1, 17, 1, 15, 18, 15),
            Block.createCuboidShape(1, 2, 1, 15, 3, 15),
            Block.createCuboidShape(5, 8, 5, 11, 13, 11)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }


    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate((mirror.getRotation(state.get(FACING))));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    //Block Entity v

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CheeseBlasterBlockEntity) {
                ItemScatterer.spawn(world, pos, (CheeseBlasterBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CheeseBlasterBlockEntity(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.CHEESE_BLASTER, CheeseBlasterBlockEntity::tick);
    }
}