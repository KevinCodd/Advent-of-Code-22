import java.util.*;
public class Day8 {

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
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(visScan(grid,i,j)) count++;
            }
        }

        System.out.println(count);
    }

    public static boolean visScan(int [][] grid, int r, int c){

        if(r==0||r==grid.length-1||c==0||c==grid[0].length-1) return true;

        //north
        for(int i = r-1; i>-1; i--){
            if(grid[i][c]<grid[r][c]) {
                if(i==0) return true;
                else continue;
            }
            else break;
        }
        //south
        for(int i = r+1; i<grid.length; i++){
            if(grid[i][c]<grid[r][c]) {
                if(i==grid.length-1) return true;
                else continue;
            }
            else break;
        }
        //east
        for(int i = c+1; i<grid[0].length; i++){
            if(grid[r][i]<grid[r][c]) {
                if(i==grid[0].length-1) return true;
                else continue;
            }
            else break;
        }
        //west
        for(int i = c-1; i>-1; i--){
            if(grid[r][i]<grid[r][c]) {
                if(i==0) return true;
                else continue;
            }
            else break;
        }
        return false;
    }
}
