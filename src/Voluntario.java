import java.time.LocalDateTime;

public class Voluntario
{
    private String cod;
    private String nome;
    private Ponto gps;
    private double raio;
    private boolean livre;
    private LocalDateTime time;
    private String encomenda;

    public Voluntario() // construtor por omissao
    {
        this.nome = new String();
        this.cod = new String();
        this.raio = 0;
        this.gps = new Ponto();
        this.livre = true;
        this.time = LocalDateTime.now();
        this.encomenda = new String();
    }

    public Voluntario(String nome, String cod,double latitude, double longitude, boolean bool, LocalDateTime time, String encomenda) // construtor parametrizado
    {
        this.nome = nome;
        this.cod = cod;
        this.raio = raio;
        this.gps = new Ponto(latitude,longitude);
        this.livre = bool;
        this.time = time;
        this.encomenda = encomenda;
    }

    public Voluntario(Voluntario vol) //construtor por copia
    {
        this.nome = vol.getNome();
        this.cod = vol.getCod();
        this.raio = vol.getRaio();
        this.gps = new Ponto(vol.getGPS().getX(),vol.getGPS().getY());
        this.livre = vol.getLivre();
        this.time = vol.getTime();
        this.encomenda = vol.getEncomenda();
    }

    public Voluntario(String nome, String cod, double raio,double latitude, double longitude) // construtor para leitura
    {
        this.nome = nome;
        this.cod = cod;
        this.raio = raio;
        this.gps = new Ponto(latitude,longitude);
        this.livre = true;
        this.time = LocalDateTime.now();
        this.encomenda = new String();
    }

    public String getNome()
    {
        return this.nome;
    }

    public String getEncomenda()
    {
        return this.encomenda;
    }

    public String getCod()
    {
        return this.cod;
    }

    public double getRaio()
    {
        return this.raio;
    }

    public Ponto getGPS() {
        return this.gps;
    }

    public boolean getLivre()
    {
        return this.livre;
    }

    public LocalDateTime getTime()
    {
        return this.time;
    }

    public Voluntario clone()
    {
        return new Voluntario(this);
    }

    public void ocupado() // torna um voluntario ocupado
    {
        this.livre = false;
    }

    public void atribuiEncomenda(String encomenda)
    {
        this.encomenda = encomenda;
    }
}
