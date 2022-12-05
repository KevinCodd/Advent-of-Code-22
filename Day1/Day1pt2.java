import java.util.*;
public class Day1pt2 {

    public static void main (String [] args){
        
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> elves = new PriorityQueue<Integer>(Comparator.reverseOrder());
        while(sc.hasNextLine()){
            int sum = 0;
            String line = sc.nextLine();
            while(sc.hasNextLine()&&line.length()>0){
                sum+=Integer.parseInt(line);
                line = sc.nextLine();
            }
            elves.add(sum);
        }
        System.out.println(elves.poll()+elves.poll()+elves.poll());
    }
}
