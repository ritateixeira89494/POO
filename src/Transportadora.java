import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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
    private double kmsTotal; // para utilizar no treeSet para o top 10 em função dos kms;
    private Map<String,Integer> classificacoes;
    private double velocidade;



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
        this.kmsTotal = 0;
        this.classificacoes = new HashMap<>();
        this.velocidade = 50;

    }

    public Transportadora(String codi, String nome,double latitude, double longitude, String nif, double raio, double preco, boolean bool, LocalDateTime time, double precototal, double kms, Map<String,Integer> avaliacoes )
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
        this.kmsTotal=kms;
        setClassificacoes(classificacoes);
        this.velocidade = 50;
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
        this.kmsTotal = trans.getKmsTotal();
        setClassificacoes(trans.getClassificacoes());
        this.velocidade= 50;
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
        this.kmsTotal=0;
        this.velocidade = 50;
    }

    public double getKmsTotal() {
        return this.kmsTotal;
    }

    public void setClassificacoes(Map<String,Integer> classificacoes) {
        this.classificacoes = new HashMap<>();
        this.classificacoes.entrySet().forEach(e -> this.classificacoes.put(e.getKey()
                , e.getValue()));//.clone());  // nao aceita clone??!!
    }

    public Map<String, Integer> getClassificacoes() {
        Map<String,Integer> aux = new HashMap<>();
        for (Map.Entry<String,Integer> e : this.classificacoes.entrySet())
            aux.put(e.getKey(), e.getValue());//.clone());
        return aux;
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

    public void indisponivel()
    {
        this.disponibilidade = false;
    }

    public void disponivel()
    {
        this.disponibilidade = true;
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

    public void adicionaKms(double km)
    {
        this.kmsTotal += km;
    }

    public void insereClassificacao(Utilizador uti, int classificacao)
    {
        this.classificacoes.put(uti.getNickname(), classificacao);
    }

    public Transportadora clone()
    {
        return new Transportadora(this);
    }

    public void setPrecototal(double preco)
    {
        this.precototal += preco;
    }
}

