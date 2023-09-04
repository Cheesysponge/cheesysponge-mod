package name.cheesysponge.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class CheeseBlasterBlock extends Block {
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
}
