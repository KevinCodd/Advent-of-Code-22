import java.util.*;
public class Day8pt2 {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<String> input = new ArrayList<String>();

        while(sc.hasNextLine()){
            input.add(sc.nextLine());
        }

        int [][] grid = new int [input.size()][input.get(0).length()];
        for(int i = 0; i<grid.length; i++){
            String cur = input.get(i);
            for(int j = 0; j<grid[0].length; j++){
                grid[i][j] = Integer.parseInt(cur.substring(j,j+1));
            }
        }
        int max = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                    max = Math.max(scenicScore(grid,i,j),max);
            }
        }
        System.out.println(max);
    }

    public static int scenicScore(int [][] grid,int r, int c){
        //north
        int north = 0;
        for(int i = r-1; i>-1; i--){
                north++;
                if(grid[i][c]<grid[r][c]) continue;
                else break;
        }
        //south
        int south = 0;
        for(int i = r+1; i<grid.length; i++){
                south++;
                if(grid[i][c]<grid[r][c]) continue;
                else break;
        }
        //east
        int east = 0;
        for(int i = c+1; i<grid[0].length; i++){
                east++;
                if(grid[r][i]<grid[r][c]) continue;
                else break;
        }
        //west
        int west = 0;
        for(int i = c-1; i>-1; i--){
                west++;
                if(grid[r][i]<grid[r][c]) continue;
                else break;
        }
        return north*south*east*west;
    }
}
