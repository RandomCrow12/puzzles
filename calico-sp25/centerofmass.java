import java.util.*;

class Coord {
    protected int[] d = new int[2];

    public Coord(int a, int b){
        d[0] = a;
        d[1] = b;
    }
    public int getX(){
        return d[0];
    }
    public int getY(){
        return d[1];
    }
}

class Box {
    protected int X0;
    protected int Y0;
    protected int X1;
    protected int Y1;

    public Box(int a, int b, int c, int d){
        X0 = a;
        Y0 = b;
        X1 = c;
        Y1 = d;
    }

    int getX0(){return this.X0;} // between X0 & X1 is the important part
    int getX1(){return this.X1;}
    int getY0(){return this.Y0;}
    int getY1(){return this.Y1;}

    Coord getCOM(){
        int a = (X0 = X1)/2;
        int b = (Y0 + Y1)/2;

        Coord c = new Coord(a, b);
        return c;
    }

    int getMass(){
        return (X1 - X0)*(Y1 - Y0);
    }

    boolean isAbove(Box other){ // directly above meaning touching
        if (this.Y0 == other.getY1() && !(this.X0 > other.getX1()) && !(this.X1 < other.getX0())) return true;
        return false;
    }
    boolean isBelow(Box other){
        if (this.Y1 == other.getY0() && !(this.X0 > other.getX1()) && !(this.X1 < other.getX0())) return true;
        return false;
    }
    boolean isGrounded(){
        return Y0 == 0;
    }
}


public class centerofmass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        for (int x = 0; x < tc; x++) {


            int num = Integer.parseInt(sc.nextLine());
            ArrayList<Box> boxes= new ArrayList<>();

            for (int i = 0; i < num; i++) {
                String[] parts = sc.nextLine().split(" ");
                Box b = new Box(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
                boxes.add(b);

            }
            boolean stable = false;


            // start algos here




            String output = (stable) ? "Stable" : "Unstable";
            System.out.println(output);
        }
    }

    public Coord multiCent(Box[] b){
        int xN = 0;
        int yN = 0;
        int xD = 0;
        int yD = 0;

        for (int i = 0; i < b.length; i++) {
            xD = xD + b[i].getMass();
        }
        yD = xD;

        for (int i = 0; i < b.length; i++) {
            xN = xN + b[i].getMass() * b[i].getCOM().getX();
        }

        for (int i = 0; i < b.length; i++) {
            yN = yN + b[i].getMass() * b[i].getCOM().getY();
        }

        int x = xN/xD;
        int y = yN/yD;


        return new Coord(x,y);
    }

}
