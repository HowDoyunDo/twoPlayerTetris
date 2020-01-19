package blocks;

import twoPlayerTetris.block;

public class IBlock extends block {
	
    public IBlock() {
        this.block = new int[][][]{
                {
                        {1, 0, 0, 0},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0},
                },
                {
                        {1, 1, 1, 1},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                }
        };
        numOfBlockType = 2;
        x = 0;
        y = 4;
        r = 0;
        w = 4;
        h = 4;
        type = 2;
    }

    public int[][] getBlock() {
        return block[r];
    }
}
