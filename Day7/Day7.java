import java.util.*;
public class Day7 {
    static HashMap <String,Integer> sizes;
    static HashMap<String,ArrayList<String>> contents;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        sizes = new HashMap<String,Integer>(); //map each directory to its size
        contents = new HashMap<String,ArrayList<String>>(); //map each directory to its subdirectories
        String filepath = "";
        while(sc.hasNextLine()){
            String command = sc.nextLine();
            String [] line = command.split(" ");
            if(line[0].equals("$")){
                if(line[1].equals("cd")){
                    if(line[2].equals("..")){
                        filepath = filepath.substring(0,filepath.length()-1);
                        int idx = filepath.length()-1;
                        while(filepath.charAt(idx)!='/'){
                            idx--;
                        }
                        filepath = filepath.substring(0,idx+1);

                    }
                    else {
                        filepath+=line[2]+"/";
                        if(!contents.containsKey(filepath)){
                            contents.put(filepath, new ArrayList<String>());
                            sizes.put(filepath,0);
                        }
                    }
                }
                else if(line[1].equals("ls")){
                    continue;
                }
            }
            else {
                ArrayList<String> dircontent = contents.get(filepath);
                if(line[0].equals("dir")) {
                    String internal = filepath+line[1]+"/";
                    dircontent.add(internal);
                    if(!contents.containsKey(internal)){
                        contents.put(internal, new ArrayList<String>());
                        sizes.put(internal,0);
                    }
                }
                else {
                    sizes.put(filepath,sizes.get(filepath)+Integer.parseInt(line[0]));
                }
                contents.put(filepath,dircontent);
            }
        }

        int ret = dfs("//");
        int ans = 0;
        for(String key: sizes.keySet()){
            if(sizes.get(key)<=100000) ans+=sizes.get(key);
        }
        System.out.println(ans);

        //pt 2
        int capacity = 70000000;
        int target_unused = 30000000;
        int free_space = capacity - ret;
        int target_size = target_unused-free_space;
        int smallest = Integer.MAX_VALUE;
        for(String key: sizes.keySet()){
            int val = sizes.get(key);
            if(val>=target_size&&val<=smallest) smallest = val;
        }
        System.out.println(smallest);
    }

    public static int dfs(String filepath){
        int size = sizes.get(filepath);
        for(String s: contents.get(filepath)){
            size+=dfs(s);
        }
        sizes.put(filepath,size);
        return size;
    }
}
