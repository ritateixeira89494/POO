
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Encomenda
{
    private String vendedor;
    private String comprador;
    private String cod;
    private double peso;
    private double preco;
    private List<Produtos> produtos;
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
        this.produtos = new ArrayList<>();
        this.kms = 0;
        this.time = LocalDateTime.now();
        this.aceite = false;
    }

    public Encomenda(String vendedor, String comprador, String cod, double peso, double preco , List<Produtos> produtos,double kms, LocalDateTime time, boolean bool)
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
        this.aceite = enc.getEstado();
    }

    public void setProdutos(List<Produtos> produtos) //construtor por copia
    {
        this.produtos= new ArrayList<>();
        for (Produtos produtoss: produtos)
            this.produtos.add(produtoss.clone());
    }

    public List<Produtos> getProdutos()
    {
        List<Produtos> aux = new ArrayList<>(); // temos de criar uma copia por causa do encapsulamento
        for (Produtos produtos: this.produtos)
            aux.add(produtos.clone());
        return aux;
    }

    public LocalDateTime getTime()
    {
        return this.time;
    }

    public String getCodigo() {
        return this.cod;
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

    public boolean getEstado()
    {
        return this.aceite;
    }

    public void setAceite(Boolean bool)
    {
        this.aceite = bool;
    }

    public double getPreco()
    {
        return this.preco;
    }

    public double getKms()
    {
        return this.kms;
    }

    public Encomenda clone()
    {
        return new Encomenda(this);
    }

}
