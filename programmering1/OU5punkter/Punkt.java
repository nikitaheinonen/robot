import java.util.*;


public class Punkt{
    int x, y;
    String name;

    public Punkt(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getNamn(){
        return this.name;
    }

    public String toString() {
        return "("+name + " " + x + " " + y+")";
    }

    public boolean equals(Punkt p){
        if(p.getNamn() == this.getNamn()){
            return true;
        }else{
            return false;
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public  void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public double avstand(Punkt p){
        int difX = this.x - p.getX();
        int difY = this.y - p.getY();
        double avst;
        avst = Math.sqrt(Math.pow(difX, 2) + Math.pow(difY, 2));
        return avst;
    }

    public Punkt(Punkt p){
        this.name = p.getNamn();
        this.x = p.getX();
        this.y = p.getY();
    }





}