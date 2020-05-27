import java.time.LocalDateTime;
import java.io.Serializable;

public class Transportadora
{
    private String codigo;
    private String nome;
    private Ponto coordsT;
    private String nif;
    private double raio;
    private double preco;
    private boolean disponibilidade;
    private LocalDateTime time;
    private double precototal;


    public Transportadora()
    {
        this.codigo= new String();
        this.nome = new String();
        this.coordsT = new Ponto();
        this.nif = new String();
        this.raio = 0;
        this.preco = 0;
        this.disponibilidade = true;
        this.time = LocalDateTime.now();
        this.precototal = 0;
    }

    public Transportadora(String codi, String nome,double latitude, double longitude, String nif, double raio, double preco, boolean bool, LocalDateTime time, double precototal)
    {
        this.codigo= codi;
        this.nome = nome;
        this.coordsT = new Ponto(latitude,longitude);
        this.nif = nif;
        this.raio = raio;
        this.preco = preco;
        this.disponibilidade = bool;
        this.time = time;
        this.precototal = precototal;
    }

    Transportadora(Transportadora trans)
    {
        this.codigo= trans.getCodigo();
        this.nome = trans.getNome();
        this.coordsT = new Ponto(trans.getCoords().getX(),trans.getCoords().getY());
        this.nif = trans.getNif();
        this.raio = trans.getRaio();
        this.preco = trans.getPreco();
        this.disponibilidade = trans.getDisponibilidade();
        this.time = trans.getTime();
        this.precototal = trans.getTotal();
    }

    public Transportadora(String cod, String nome, double latitude, double longitude,String nif, double raio, double preco)
    {
        this.codigo= cod;
        this.nome = nome;
        this.coordsT = new Ponto(latitude,longitude);
        this.nif = nif;
        this.raio = raio;
        this.preco = preco;
        this.disponibilidade = true;
        this.time = LocalDateTime.now();
        this.precototal = 0;
    }


    public LocalDateTime getTime()
    {
        return this.time;
    }

    public double getTotal()
    {
        return this.precototal;
    }
    public String getCodigo()
    {
        return this.codigo;
    }

    public String getNome()
    {
        return this.nome;
    }

    public String getNif()
    {
        return this.nif;
    }

    public Ponto getCoords() {
        return coordsT;
    }

    public void setCoords(Ponto coordsT) {
        this.coordsT = coordsT;
    }

    public double getRaio()
    {
        return this.raio;
    }

    public double getPreco()
    {
        return this.preco;
    }

    public boolean getDisponibilidade()
    {
        return this.disponibilidade;
    }

    public String toString(){
        return "Transportadora -> CódigoEmpresa: " + this.codigo
                + ", NomeEmpresa: " + this.nome
                + ", Coordenadas: " + this.coordsT
                + ", NIF: " + this.nif
                + ", Raio: " + this.raio
                + ", Preço/Km: " + this.preco + "\n";
    }

    public Transportadora clone()
    {
        return new Transportadora(this);
    }
}

