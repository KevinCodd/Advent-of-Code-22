import java.util.*;
public class Day6pt2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        for(int i = 0; i<line.length()-13; i++){
            if(isUnique(line.substring(i,i+14))){
                System.out.println(i+14);
                break;
            }
        }
    }

    public static boolean isUnique(String s){
        HashSet<Character> chars = new HashSet<Character>();

        for(int i = 0; i<s.length();i++){
            chars.add(s.charAt(i));
        }
        if(chars.size()==s.length()) return true;
        else return false;
    }
}
