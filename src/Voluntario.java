import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Voluntario
{
    private String cod;
    private String nome;
    private Ponto gps;
    private double raio;
    private boolean livre;
    private LocalDateTime time;
    private String encomenda;
    private List<String> avaliacoes;
    private int nmrClassificadores;

    public Voluntario() // construtor por omissao
    {
        this.nome = new String();
        this.cod = new String();
        this.raio = 0;
        this.gps = new Ponto();
        this.livre = true;
        this.time = LocalDateTime.now();
        this.encomenda = new String();
        this.nmrClassificadores=0;
        this.avaliacoes = new ArrayList<>();
    }

    public Voluntario(String nome, String cod,double latitude, double longitude, boolean bool, LocalDateTime time, String encomenda,int nmrClassificadores, List<String> classificacoes) // construtor parametrizado
    {
        this.nome = nome;
        this.cod = cod;
        this.raio = raio;
        this.gps = new Ponto(latitude,longitude);
        this.livre = bool;
        this.time = time;
        this.encomenda = encomenda;
        this.nmrClassificadores= 0;
        setClassificacoes(classificacoes);
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
        this.nmrClassificadores= vol.getNmr();
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

    public int getNmr()
    {
        return this.nmrClassificadores;
    }

    public List<String> getnmrClassificadores()
    {
        return this.avaliacoes;
    }

    //public double classificacaoMedia()
    //{
        //percorrer a lista das classificacoes, somar tudo e dividir pelo nmr de classificadores
    //}


    public void setClassificacoes(List<String> lps)
    {
        this.avaliacoes = new ArrayList<>();
        // para cada lampada l que esta em lps, temos de inserir em this.lampadas
        for (String l :lps)
            this.avaliacoes.add(l);
    }

    public String getEncomenda()
    {
        return this.encomenda;
    }

    public void adicionaAvaliacao(String avaliacao)
    {
        this.nmrClassificadores +=1;
        this.avaliacoes.add(avaliacao);
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
