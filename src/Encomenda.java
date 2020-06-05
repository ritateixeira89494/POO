
import java.time.LocalDateTime;
import java.util.*;
import java.util.Random;

public class Encomenda
{
    Random random = new Random();
    private String vendedor;
    private String comprador;
    private String cod;
    private double peso;
    private double preco;
    private Map<String,LinhaEncomenda> produtos;
    private double kms;
    private LocalDateTime tempoInicio;
    private LocalDateTime tempoConclusao;
    private boolean aceite;
    private double precoTotal; // preco do transporte mais preço da encomenda
    private int tempoProcessamento;


    public Encomenda()
    {
        this.vendedor = new String();
        this.comprador = new String();
        this.cod = new String();
        this.peso = 0;
        this.preco = 0;                // este preco refere ao preco dos produtos
        this.produtos = new HashMap<>();
        this.kms = 0;
        this.tempoInicio = LocalDateTime.now();
        this.tempoConclusao = LocalDateTime.now();
        this.aceite = false;
        this.precoTotal = this.preco;
        this.tempoProcessamento = random.nextInt(9) + 6;

    }

    public Encomenda(String vendedor, String comprador, String cod, double peso, double preco , Map<String,LinhaEncomenda> produtos,double kms, LocalDateTime time, LocalDateTime tempo, boolean bool)
    {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.cod = cod;
        this.peso = peso;
        this.preco = preco;
        setProdutos(produtos);
        this.kms = kms; // distancia do user À loja
        this.tempoInicio = time;
        this.aceite = bool;
        this.tempoConclusao= tempo;
        this.tempoProcessamento = random.nextInt(9) + 6;

    }
    public Encomenda(String vendedor, String comprador, String cod,double preco,double kms, double peso , Map<String,LinhaEncomenda> produtos)
    {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.cod = cod;
        this.peso = peso;
        this.preco = preco;
        setProdutos(produtos);
        this.kms = kms;
        this.tempoInicio = LocalDateTime.now();
        this.tempoConclusao = LocalDateTime.now();
        this.aceite = false;
        this.precoTotal = this.preco;
        this.tempoProcessamento = random.nextInt(9) + 6;

    }

    public Encomenda(String vendedor, String comprador, String cod, double peso , Map<String,LinhaEncomenda> produtos)
    {
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.cod = cod;
        this.peso = peso;
        this.preco = preco;
        setProdutos(produtos);
        this.kms = kms;
        this.tempoInicio = LocalDateTime.now();
        this.tempoConclusao = LocalDateTime.now();
        this.aceite = false;
        this.precoTotal = this.preco;
        this.tempoProcessamento = random.nextInt(9) + 6;

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
        this.tempoInicio = enc.getTempoInicio();
        this.tempoConclusao = enc.getTempoConclusao();
        this.aceite = enc.getAceite();
        this.precoTotal = enc.getPrecoTotal();
        this.tempoProcessamento = enc.getTempoProcessamento();

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

    public LocalDateTime getTempoInicio()
    {
        return this.tempoInicio;
    }

    public LocalDateTime getTempoConclusao()
    {
        return this.tempoConclusao;
    }

    public int getTempoProcessamento()
    {
        return this.tempoProcessamento;
    }

    public void setTempoConclusao(LocalDateTime e)
    {
        this.tempoConclusao = e.now();
    }

    public void setTempoInicio(LocalDateTime e)
    {
        this.tempoInicio = e.now();
    }

    public String getCodigo() {
        return this.cod;
    }

    public boolean getAceite() {return this.aceite;}

    public void setAceite(boolean bool)
    {
        this.aceite = bool;
    }

    public void setKms(double kms)
    {
        this.kms = kms;
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
    public double getPrecoTotal()
    {
        return this.precoTotal;
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

    //public double calculaValorTotal(double distanciaUV)
   // {
     //   return this.preco + this.peso * distanciaUV * this.kms;
   // }

    public void calculaValorTotal(double precoTransporte)
    {
        this.precoTotal = this.preco + precoTransporte;
    }

}
