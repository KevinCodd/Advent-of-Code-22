import java.util.Scanner;
public class Day2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int total = 0;
        while(sc.hasNextLine()){
            String [] line = sc.nextLine().split(" ");
            String opp = line[0];
            String me = line[1];
            if(me.equals("X")){
                total+=1;
                if(opp.equals("A")) total+=3;
                else if(opp.equals("C")) total+=6;
            }
            if(me.equals("Y")){
                total+=2;
                if(opp.equals("A")) total+=6;
                else if(opp.equals("B")) total+=3;
            }
            if(me.equals("Z")){
                total+=3;
                if(opp.equals("B")) total+=6;
                else if(opp.equals("C")) total+=3;
            }
        }
        System.out.println(total);

    }
}
