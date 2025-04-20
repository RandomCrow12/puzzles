import java.util.*;

public class dayFour{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        ArrayList<String> lines = new ArrayList<>();

        String input = "";
        int res = 0;
        int res2 = 0;
        

        while (!input.equals("ENDOFINPUT")){
            input = sc.nextLine();
            if (!input.equals("ENDOFINPUT")) lines.add(input);
        }

            for (int i = 0; i < lines.size(); i++){
                // every X checks all versions and does additions
                
                for (int k = 0; k < lines.get(i).length(); k++){
                    if (lines.get(i).charAt(k) == 'X') {


                        // XMAS
                        
                        
                        try{
                            if (lines.get(i).charAt(k+1) == 'M' && lines.get(i).charAt(k+2) == 'A' && lines.get(i).charAt(k+3) == 'S') res++;
                        } catch (Exception e) {
                            
                        }
                        try{
                            if (lines.get(i).charAt(k-1) == 'M' && lines.get(i).charAt(k-2) == 'A' && lines.get(i).charAt(k-3) == 'S') res++;
                        } catch (Exception e) {
                            
                        }
                        try{
                            if (lines.get(i-1).charAt(k) == 'M' && lines.get(i-2).charAt(k) == 'A' && lines.get(i-3).charAt(k) == 'S') res++;
                        } catch (Exception e) {
                            
                        }
                        try{
                            if (lines.get(i+1).charAt(k) == 'M' && lines.get(i+2).charAt(k) == 'A' && lines.get(i+3).charAt(k) == 'S') res++;
                        } catch (Exception e) {
                            
                        }
                        try{
                            if (lines.get(i-1).charAt(k-1) == 'M' && lines.get(i-2).charAt(k-2) == 'A' && lines.get(i-3).charAt(k-3) == 'S') res++;
                        } catch (Exception e) {
                            
                        }
                        try{
                            if (lines.get(i-1).charAt(k+1) == 'M' && lines.get(i-2).charAt(k+2) == 'A' && lines.get(i-3).charAt(k+3) == 'S') res++;
                        } catch (Exception e) {
                            
                        }
                        try{
                            if (lines.get(i+1).charAt(k+1) == 'M' && lines.get(i+2).charAt(k+2) == 'A' && lines.get(i+3).charAt(k+3) == 'S') res++;
                        } catch (Exception e) {
                            
                        }
                        try{
                            if (lines.get(i+1).charAt(k-1) == 'M' && lines.get(i+2).charAt(k-2) == 'A' && lines.get(i+3).charAt(k-3) == 'S') res++;
                        } catch (Exception e) {
                            
                        }

                    }
                }


                for (int k = 0; k < lines.get(i).length(); k++){
                    if (lines.get(i).charAt(k) == 'A') {
                        int sCounter = 0;
                        int mCounter = 0;

                        try {
                        if (lines.get(i-1).charAt(k-1) == 'M') mCounter++;
                        } catch (Exception e){}
                        
                        try {
                        if (lines.get(i-1).charAt(k-1) == 'S') sCounter++;
                        } catch (Exception e){}


                        try {
                        if (lines.get(i-1).charAt(k+1) == 'M') mCounter++;
                        } catch (Exception e){}
                            
                        try {
                        if (lines.get(i-1).charAt(k+1) == 'S') sCounter++;
                        } catch (Exception e){}


                        try {
                        if (lines.get(i+1).charAt(k-1) == 'M') mCounter++;
                        } catch (Exception e){}
                            
                        try {
                        if (lines.get(i+1).charAt(k-1) == 'S') sCounter++;
                        } catch (Exception e){}

                        try {
                        if (lines.get(i+1).charAt(k+1) == 'M') mCounter++;
                        } catch (Exception e){}
                                
                        try {
                        if (lines.get(i+1).charAt(k+1) == 'S') sCounter++;
                        } catch (Exception e){}



                        if (mCounter != 2 || sCounter != 2) continue;

                        char TL = lines.get(i-1).charAt(k-1);
                        if (lines.get(i+1).charAt(k+1) == TL) continue; // if opposite is the same, problem

                        res2++;
                    }
                }


            }   

        System.out.println(res);
        System.out.println(res2);
        sc.close();
    }
}