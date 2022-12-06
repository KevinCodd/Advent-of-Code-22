import java.util.*;
public class Day5pt2 {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        ArrayList<String> input = new ArrayList<String>();

        while(line.length()>0){
            input.add(line);
            line = sc.nextLine();
        }

        String [] stack_nums = input.get(input.size()-1).split(" ");

        int num_stacks = Integer.parseInt(stack_nums[stack_nums.length-1]);

        ArrayList<LinkedList<Character>> stacks = new ArrayList<LinkedList<Character>>();
        for(int i=0; i<num_stacks; i++){
            stacks.add(new LinkedList<Character>());
        }

        for(int i = input.size()-2;i>-1;i--){
            for(int j = 1; j<input.get(i).length(); j+=4){
                char c = input.get(i).charAt(j);

                if (Character.isAlphabetic(c)) {
                    stacks.get((j-1)/4).add(c);
                }
            }
        }

        while(sc.hasNextLine()){
            String [] linesplit = sc.nextLine().split(" ");
            int moves = Integer.parseInt(linesplit[1]);
            int from = Integer.parseInt(linesplit[3])-1;
            int to = Integer.parseInt(linesplit[5])-1;
            LinkedList<Character> moved = new LinkedList<Character>();
            for(int i = 0; i< moves; i++){
                moved.add(stacks.get(from).removeLast());
            }
            for(int i = 0; i<moves; i++){
                stacks.get(to).add(moved.removeLast());
            }
        }

        String ret = "";
        for(LinkedList<Character> stack: stacks){
            if(!stack.isEmpty())ret+=Character.toString(stack.peekLast());
        }
        System.out.println(ret);

    }
}
