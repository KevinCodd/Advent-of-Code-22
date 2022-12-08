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
        boolean [][] saw = new boolean [grid.length][grid[0].length];

        int count = 0;

        for(int i = 0; i<grid[0].length; i++){
            saw[0][i] = true;
            saw[grid.length-1][i]=true;
            count+=2;

        }
        for(int i = 1; i<grid.length-1; i++){
            saw[i][0]=true;
            saw[i][grid[i].length-1] = true;
            count+=2;
        }
        //left -> right
        for(int i= 1; i<grid.length-1; i++){
            int highest = grid[i][0];
            for(int j=1; j<grid[i].length-1; j++) {
                if(grid[i][j]>highest){
                    highest = grid[i][j];
                    if(!saw[i][j]){
                        saw[i][j]=true;
                        count++;
                    }
                }
            }
        }
        //right --> left
        for(int i= 1; i<grid.length-1; i++){
            int highest = grid[i][grid[i].length-1];
            for(int j=grid[i].length-2; j>0; j--) {
                if(grid[i][j]>highest){
                    highest = grid[i][j];
                    if(!saw[i][j]){
                        saw[i][j]=true;
                        count++;
                    }
                }
            }
        }
        //up -> down
        for(int j= 1; j<grid[0].length-1; j++){
            int highest = grid[0][j];
            for(int i=1; i<grid.length-1; i++) {
                if(grid[i][j]>highest){
                    highest = grid[i][j];
                    if(!saw[i][j]){
                        saw[i][j]=true;
                        count++;
                    }
                }
            }
        }
        //down -> up
        for(int j= 1; j<grid[0].length-1; j++){
            int highest = grid[grid.length-1][j];
            for(int i=grid.length-2; i>0; i--) {
                if(grid[i][j]>highest){
                    highest = grid[i][j];
                    if(!saw[i][j]){
                        saw[i][j]=true;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
