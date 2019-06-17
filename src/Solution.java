class Solution {

    char[][] myGrid;
    boolean[][] visited;

    public static void main(String[] Args){

        Solution newS = new Solution();

        char[][] grid =
                {
                        {1,0,1,1,0,1,1}
                };

        char[][] grid2 =
                {
                        {1,1,0,0,1},
                        {1,1,0,0,0},
                        {0,0,1,0,0},
                        {0,1,0,1,1}
                };

        char[][] grid3 =
                {
                        {1,1,1,1,0},
                        {1,1,0,1,0},
                        {1,1,0,0,0},
                        {0,0,0,0,0}
                };

        System.out.println(newS.numIslands(grid));
        System.out.println(newS.numIslands(grid2));
        System.out.println(newS.numIslands(grid3));

    }

    public int numIslands(char[][] grid) {
        this.myGrid = grid;
        this.visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[0].length; y++){
                if(!visited[x][y] && grid[x][y] == 1){
                    DFS(x, y);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS(int x, int y){

        int rowVal[] = new int[] {-1,0,0,1};
        int colVal[] = new int[] {0,-1,1,0};

        visited[x][y] = true;

        for(int checks = 0; checks < 4; checks++){
            if(isValid(x + rowVal[checks], y + colVal[checks])){
                DFS(x + rowVal[checks], y + colVal[checks]);
            }
        }
    }

    public boolean isValid(int row, int col){
        if(0 <= row && row < myGrid.length && 0 <= col && col < myGrid[0].length){
            if(myGrid[row][col] == 1 && visited[row][col] == false){
                return true;
            }
        }
        return false;
    }
}