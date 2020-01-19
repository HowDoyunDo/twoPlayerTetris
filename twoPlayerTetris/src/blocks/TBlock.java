package blocks;

import twoPlayerTetris.block;

public class TBlock extends block{

    public TBlock() {
    	this.block = new int[][][]{
            {
                    {1, 0, 0},
                    {1, 1, 0},
                    {1, 0, 0},
            },
            {
                    {1, 1, 1},
                    {0, 1, 0},
                    {0, 0, 0},
            },
            {
                    {0, 1, 0},
                    {1, 1, 0},
                    {0, 1, 0},
            },
            {
                    {0, 1, 0},
                    {1, 1, 1},
                    {0, 0, 0},
            }
    	};
        numOfBlockType = 4;
        x = 0;
        y = 4;
        r = 0;
        w = 3;
        h = 3;
        type = 5;
    }

    public int[][] getBlock() {
        return block[r];
    }
}
