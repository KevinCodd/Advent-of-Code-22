import java.util.*;
public class Day3pt2 {

    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int priority_sum = 0;
        while(sc.hasNextLine()){
            int [] groupChars = new int [52];
            for(int cnt = 0; cnt<3;cnt++){
                HashSet<Character> types = new HashSet<Character>();
                char [] items = sc.nextLine().toCharArray();
                for(int i = 0; i<items.length; i++){
                    types.add(items[i]);
                }
                for(char type: types){
                    groupChars[priority(type)-1]++;
                }
            }
            for(int i = 0; i<groupChars.length; i++){
                if(groupChars[i]==3) {
                    priority_sum+=i+1;
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
