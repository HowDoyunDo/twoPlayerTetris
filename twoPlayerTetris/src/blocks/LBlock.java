package blocks;

import twoPlayerTetris.block;

public class LBlock extends block{
	
    public LBlock() {
        this.block = new int[][][]{
            {
                    {1, 0, 0},
                    {1, 0, 0},
                    {1, 1, 0},
            },
            {
                    {1, 1, 1},
                    {1, 0, 0},
                    {0, 0, 0},
            },
            {
                    {1, 1, 0},
                    {0, 1, 0},
                    {0, 1, 0},
            },
            {
                    {0, 0, 0},
                    {0, 0, 1},
                    {1, 1, 1},
            }
        };
        numOfBlockType = 4;
        x = 0;
        y = 4;
        r = 0;
        w = 3;
        h = 3;
        type = 3;
    }

    public int[][] getBlock() {
        return block[r];
    }
}
