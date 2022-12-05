import java.util.*;
public class Day3 {

    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int priority_sum = 0;
        while(sc.hasNextLine()){
            char [] items = sc.nextLine().toCharArray();
            HashSet<Character> types = new HashSet<Character>();
            for(int i = 0; i<items.length/2; i++){
                types.add(items[i]);
            }
            for(int i = items.length/2; i<items.length; i++){
                if (types.contains(items[i])) {
                    priority_sum+=priority(items[i]);
                    break;
                }
            }
        }
        System.out.println(priority_sum);
    }

    public static int priority(char c){
        if(Character.isLowerCase(c)){
            return c -'a'+1;
        }
        else if(Character.isUpperCase(c)){
            return c -'A'+27;
        }
        else return 0;
    }
}
