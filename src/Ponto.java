import java.awt.geom.Point2D.Double;
import java.io.Serializable;

public class Ponto implements Serializable {
    private double x;
    private double y;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public Ponto() {
        this.x=0;
        this.y=0;
    }

    public Ponto(Ponto p) {
        this.x=p.getX();
        this.y=p.getY();
    }

    public Ponto(double x, double y) {
        this.x=x;
        this.y=y;
    }

    public Ponto clone(){
        return new Ponto(this.x,this.y);
    }

    public boolean equals(Ponto p){
        if((p.getX()==this.x) && (p.getY()==this.y)){
            return true;
        }
        return false;
    }

    public String toString(){
        return "Coordenadas: ("+x+","+y+")";
    }


    /** Funçao que calcula a distancia entre um certa posiçao e o destino, para isso
     * utiliza-se a formula da distancia entre dois pontos.
     */
    public double distance(Ponto destino){
        double distX = Math.abs(destino.getX()-x);
        double distY = Math.abs(destino.getY()-y);
        double distDiag = Math.sqrt(distX*distX + distY*distY);
        return distDiag;
    }

}