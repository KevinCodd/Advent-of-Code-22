import java.util.Scanner;
public class Day2pt2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int total = 0;
        while(sc.hasNextLine()){
            String [] line = sc.nextLine().split(" ");
            String opp = line[0];
            String me = line[1];
            if(me.equals("X")){
                if(opp.equals("A")) total+=3;
                else if(opp.equals("B")) total+=1;
                else if(opp.equals("C")) total+=2;
            }
            if(me.equals("Y")){
                total+=3;
                if(opp.equals("A")) total+=1;
                else if(opp.equals("B")) total+=2;
                else if(opp.equals("C")) total+=3;
            }
            if(me.equals("Z")){
                total+=6;
                if(opp.equals("A")) total+=2;
                else if(opp.equals("B")) total+=3;
                else if(opp.equals("C")) total+=1;
            }
        }
        System.out.println(total);

    }
}
