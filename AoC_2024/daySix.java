import java.util.*;

public class daySix {
    public static ArrayList<String> lines = new ArrayList<>();
    public static ArrayList<String> copy = new ArrayList<>();
    public static ArrayList<String> use = new ArrayList<>();
    public static String dir = "up";
    public static boolean out = false;
    public static int res2 = 0;
    public static int bad = 0;
    public static int x;
    public static int y;
   
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String input = "";
        //int res = 0;
        

        while (!input.equals("END")){
            input = sc.nextLine();
            if (!input.equals("END")) lines.add(input);
        }

        for (int f = 0; f < lines.size(); f++){
            copy.add(lines.get(f));
        }

        for (int f = 0; f < lines.size(); f++){
            use.add(copy.get(f));
        }

        


        int attempts = 0;
        for (int v = 0; v < lines.size(); v++) {
            for (int c = 0; c < lines.get(v).length(); c++) {
                if (lines.get(v).charAt(c) == '^') {
                    x = c;
                    y = v;
                }
            }
        }
        int storeX = x;
        int storeY = y;
        
        for (String l : use) {
            System.out.println(l);
        }
        for (int v = 0; v < lines.size(); v++){
            for (int c = 0; c < lines.get(v).length(); c++){
                useReset();
                x = storeX;
                y = storeY;
                dir = "up";

                String b4 = use.get(v);

                    if (! (use.get(v).charAt(c) == '^')){
                        
                        use.set(v, b4.substring(0,c) + "#" + b4.substring(c+1));
                    }
                attempt();
                attempts++; System.out.println(attempts);
                //use.set(v, b4);
            }
        }


        //System.out.println(res+1); // the X for leaving needs to be "added"
        System.out.println(res2);
        sc.close();
    }


    public static void attempt(){
        out = false;
        bad = 0;
        while (!out){
         
            handleNext(y,x);
            if (bad > 10000) {res2++; out = true; return;}
                
        }
    }

    public static void handleNext(int line, int pos){
        bad++;

        if (dir.equals("up")){
            if (line-1 < 0) {out = true; return;}
            if (use.get(line-1).charAt(pos) == '#') dir = "right";
            else{
                String upStore = use.get(line-1);
                String hereStore = use.get(line);

                int a = x;
                
                use.set(line, hereStore.substring(0,a) + "X" + hereStore.substring(a+1));
                use.set(line-1, upStore.substring(0,a) + "^" + upStore.substring(a+1));

                y--;
            }
        }
        else if (dir.equals("right")){
            if (pos+1 >= use.get(line).length()) {out = true; return;}
            if (use.get(line).charAt(pos+1) == '#') dir = "down";
            else{
                String hereStore = use.get(line);

                int a = x;
                
                use.set(line, hereStore.substring(0,a) + "X^" + hereStore.substring(a+2));

                x++;
            }
        }
        else if (dir.equals("left")){
            if (pos-1 < 0) {out = true; return;}
            if (use.get(line).charAt(pos-1) == '#') dir = "up";
            else{
                String hereStore = use.get(line);

                int a = x;
                
                use.set(line, hereStore.substring(0,a-1) + "^X" + hereStore.substring(a+1));

                x--;
            }
        }
        else if (dir.equals("down")){
            if (line+1 >= use.size()) {out = true; return;}
            
            if (use.get(line+1).charAt(pos) == '#') dir = "left";
            else{
                String upStore = use.get(line+1);
                String hereStore = use.get(line);

                int a = x;
                
                use.set(line, hereStore.substring(0,a) + "X" + hereStore.substring(a+1));
                use.set(line+1, upStore.substring(0,a) + "^" + upStore.substring(a+1));

                y++;
            }
        }
        
    }

    public static void useReset(){
        for (int f = 0; f < lines.size(); f++){
            use.set(f,copy.get(f));
        }
    }

}
