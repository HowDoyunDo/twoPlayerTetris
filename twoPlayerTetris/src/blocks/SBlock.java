package blocks;

import twoPlayerTetris.block;

public class SBlock extends block{
	
    public SBlock() {
        this.block = new int[][][]{
            {
                    {0, 1, 1},
                    {1, 1, 0},
                    {0, 0, 0},
            },
            {
                    {1, 0, 0},
                    {1, 1, 0},
                    {0, 1, 0},
            },
        };
        numOfBlockType = 2;
        x = 0;
        y = 4;
        r = 0;
        w = 3;
        h = 3;
        type = 6;
    }

    public int[][] getBlock() {
        return block[r];
    }
}
