import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Voluntario implements Serializable
{
    private String cod;
    private String nome;
    private Ponto gps;
    private double raio;
    private boolean livre;
    private double totalFaturado;
    private LocalDateTime time;
    private String encomenda;  // NAO SEI PARA QUE QUERO ISTO, MAS SECALHAR UM MAP CM TODAS AS ENCOMENDAS REALIZADAS POR ELE ERA TOP
    private Map<String,Integer> classificacao;
    private double velocidade;  // a intenção é criar variavies aleatórias consoante tempo e hora de ponta // km/h


    public Voluntario() // construtor por omissao
    {
        this.nome = new String();
        this.cod = new String();
        this.raio = 0;
        this.gps = new Ponto();
        this.livre = true;
        this.totalFaturado = 0;
        this.time = LocalDateTime.now();
        this.encomenda = new String();
        this.classificacao = new HashMap<>();
        this.velocidade = 50;
    }

    public Voluntario(String nome, String cod,double latitude, double longitude, boolean bool, LocalDateTime time, String encomenda, Map<String,Integer> classificacao) // construtor parametrizado
    {
        this.nome = nome;
        this.cod = cod;
        this.raio = raio;
        this.gps = new Ponto(latitude,longitude);
        this.livre = bool;
        this.time = time;
        this.encomenda = encomenda;
        this.totalFaturado = 0;
        setClassificacao(classificacao);
        this.velocidade = 50;
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
        this.totalFaturado = vol.getTotalFaturado();
        setClassificacao(classificacao);
        this.velocidade = 50;
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
        this.totalFaturado = 0;
        this.velocidade = 50;
    }

    public void setClassificacao(Map<String,Integer> classificacao) {
        this.classificacao = new HashMap<>();
        this.classificacao.entrySet().forEach(e -> this.classificacao.put(e.getKey()
                , e.getValue()));//.clone());  // nao aceita clone??!!
    }

    public Map<String, Integer> getClassificacao() {
        Map<String,Integer> aux = new HashMap<>();
        for (Map.Entry<String,Integer> e : this.classificacao.entrySet())
            aux.put(e.getKey(), e.getValue());       //.clone());
        return aux;
    }

    public String getNome()
    {
        return this.nome;
    }

    public double getTotalFaturado()
    {
        return this.totalFaturado;
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

    public String toString(){
        return "Voluntario -> Código: " + this.cod
                + ", Nome: " + this.nome
                + ", Coordenadas: " + this.gps
                + ", Raio: " + this.raio + "\n";
    }

    public Voluntario clone()
    {
        return new Voluntario(this);
    }

    public void ocupado() // torna um voluntario ocupado
    {
        this.livre = false;
    }

    public void livre() // torna um voluntario ocupado
    {
        this.livre = true;
    }

    public void atribuiEncomenda(String encomenda)
    {

        this.encomenda = encomenda;
    }

    public void ganhaDinheiro(double valor)
    {
        this.totalFaturado+= valor;
    }


}
