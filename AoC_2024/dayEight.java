import java.util.*;
public class dayEight {

    public static ArrayList<String> lines = new ArrayList<>();
    public static int[][] antiNotes;
   
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String input = "";
        int res = 0;
        //long res2 = 0;
        
        while (!input.equals("END")){
            input = sc.nextLine();
            if (!input.equals("END")) lines.add(input);
        }
       
        antiNotes = new int [lines.size()][lines.get(0).length()]; 
        
        

        for (int i = 0; i < lines.size(); i++){
            for (int j = 0; j < lines.get(0).length(); j++){
                if (lines.get(i).charAt(j) != '.'){
                    char selected = lines.get(i).charAt(j);
                    checkAll(i,j,selected);
                }
            }
        }

        for (int i = 0; i < antiNotes.length; i++){
            for (int j = 0; j < antiNotes[0].length; j++){
                if (antiNotes[i][j] == 1) res++;
            }
        }


        for (int k = 0; k < antiNotes.length; k++){
            System.out.println();
            for (int h = 0;  h< antiNotes[0].length; h++){
                System.out.print(antiNotes[k][h]);
            }
        }

        System.out.println();

        System.out.println(res); 
        //System.out.println(res2); 
        sc.close();
    }

    public static void checkAll(int atY, int atX, char current){
        for (int i = 0; i < lines.size(); i++){
            for (int j = 0; j < lines.get(0).length(); j++){
                
                if (i == atY && j == atX){
                    antiNotes[i][j] = 1;
                    continue;
                }
                else if(lines.get(i).charAt(j) == current) {

                    int posY = atY - (i - atY);
                    int posX = atX + (atX - j);
                    //System.out.println(posY + " " + posX);

                    int posY2 = i + (i - atY);
                    int posX2 = j - (atX - j);

                    boolean inBounds = true;
                    boolean inB2 = true;
                    int step = 0;
                    while (inBounds || inB2) {

                    try{
                        antiNotes[posY - (step * (i - atY))][posX + (step * (atX - j))] = 1;
                    }catch(Exception e){inBounds = false;}
                    try{
                        antiNotes[posY2 + (step*(i - atY))][posX2 - (step *(atX - j))] = 1;
                    }catch(Exception e){inB2 = false;}

                    step++;
                    
                }
            }


            }
        }
    }



}