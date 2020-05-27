
import java.time.LocalDateTime;
import java.util.*;

public class Encomenda
{
    private String vendedor;
    private String comprador;
    private String cod;
    private double peso;
    private double preco;
    private Map<String,LinhaEncomenda> produtos;
    private double kms;
    private LocalDateTime time;
    private boolean aceite;


    public Encomenda()
    {
        this.vendedor = new String();
        this.comprador = new String();
        this.cod = new String();
        this.peso = 0;
        this.preco = 0;
        this.produtos = new HashMap<>();
        this.kms = 0;
        this.time = LocalDateTime.now();
        this.aceite = false;

    }

    public Encomenda(String vendedor, String comprador, String cod, double peso, double preco , Map<String,LinhaEncomenda> produtos,double kms, LocalDateTime time, boolean bool)
    {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.cod = cod;
        this.peso = peso;
        this.preco = preco;
        setProdutos(produtos);
        this.kms = kms;
        this.time = time;
        this.aceite = bool;

    }
    public Encomenda(String vendedor, String comprador, String cod, double peso , Map<String,LinhaEncomenda> produtos)
    {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.cod = cod;
        this.peso = peso;
        this.preco = 0;
        setProdutos(produtos);
        this.kms = 0; // temos que fazer uma funcao que calcula a distancia para aqui
        this.time = LocalDateTime.now();
        this.aceite = false;

    }

    Encomenda (Encomenda enc)
    {
        this.vendedor = enc.getVendedor();
        this.comprador = enc.getComprador();
        this.cod = enc.getCodigo();
        this.peso = enc.getPeso();
        this.preco = enc.getPreco();
        setProdutos(enc.getProdutos());
        this.kms = enc.getKms();
        this.time = enc.getTime();
        this.aceite = enc.getAceite();

    }

    public void setProdutos(Map<String,LinhaEncomenda> produtos) {
        this.produtos = new HashMap<>();
        this.produtos.entrySet().forEach(e -> this.produtos.put(e.getKey()
                , e.getValue()).clone());
    }

    public Map<String, LinhaEncomenda> getProdutos() {
        Map<String,LinhaEncomenda> aux = new HashMap<>();
        for (Map.Entry<String,LinhaEncomenda> e : this.produtos.entrySet())
            aux.put(e.getKey(), e.getValue().clone());
        return aux;
    }

    public LocalDateTime getTime()
    {
        return this.time;
    }

    public String getCodigo() {
        return this.cod;
    }

    public boolean getAceite() {return this.aceite;}

    public void setAceite(boolean bool)
    {
        this.aceite = bool;
    }

    public String getVendedor()
    {
        return this.vendedor;
    }

    public String getComprador()
    {
        return this.comprador;
    }

    public double getPeso()
    {
        return this.peso;
    }

    public double getPreco()
    {
        return this.preco;
    }

    public double getKms()
    {
        return this.kms;
    }

    public String toString()
    {
        return  "Encomenda -> Código: " + this.cod
                + ", CódigoUtilizador: " + this.comprador
                + ", CódigoLoja: " + this.vendedor
                + ", Peso: " + this.peso
                + ", LinhaEncomenda: " + this.produtos
                + "Aceite" + this.aceite;
    }

    public Encomenda clone()
    {
        return new Encomenda(this);
    }

}
