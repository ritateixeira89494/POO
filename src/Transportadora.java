import java.time.LocalDateTime;

public class Transportadora
{
    private String codigo;
    private String nome;
    private double latitude;
    private double longitude;
    private String nif;
    private double raio;
    private double preco;
    private boolean disponibilidade;
    private LocalDateTime time;
    private double precototal;


    Transportadora()
    {
        this.codigo= new String();
        this.nome = new String();
        this.latitude = 0;
        this.longitude = 0;
        this.nif = new String();
        this.raio = 0;
        this.preco = 0;
        this.disponibilidade = true;
        this.time = LocalDateTime.now();
        this.precototal = 0;
    }

    Transportadora(String codi, String nome,double latitude, double longitude, String nif, double raio, double preco, boolean bool, LocalDateTime time, double precototal)
    {
        this.codigo= codi;
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
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
        this.latitude = trans.getLatitude();
        this.longitude = trans.getLongitude();
        this.nif = trans.getNif();
        this.raio = trans.getRaio();
        this.preco = trans.getPreco();
        this.disponibilidade = trans.getDisponibilidade();
        this.time = trans.getTime();
        this.precototal = trans.getTotal();
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

    public double getLatitude()
    {
        return this.latitude;
    }

    public double getLongitude()
    {
        return this.longitude;
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

    public Transportadora clone()
    {
        return new Transportadora(this);
    }
}

