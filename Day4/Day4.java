import java.util.*;
public class Day4 {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String [] halves = line.split(",");
            int lb1 = Integer.parseInt(halves[0].split("-")[0]);
            int ub1 = Integer.parseInt(halves[0].split("-")[1]);
            int lb2 = Integer.parseInt(halves[1].split("-")[0]);
            int ub2 = Integer.parseInt(halves[1].split("-")[1]);
            if(lb2>=lb1&&ub2<=ub1) cnt++;
            else if (lb1>=lb2&&ub1<=ub2) cnt++;
        }
        System.out.println(cnt);

    }
}
