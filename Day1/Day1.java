import java.util.Scanner;
public class Day1 {

    public static void main (String [] args){
        
        Scanner sc = new Scanner(System.in);
        int max = 0;
        while(sc.hasNextLine()){
            int sum = 0;
            String line = sc.nextLine();
            while(sc.hasNextLine()&&line.length()>0){
                sum+=Integer.parseInt(line);
                line = sc.nextLine();
            }
            if(sum>max) max = sum;
        }
        System.out.println(max);
    }
}
