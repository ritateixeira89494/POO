import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;


public class Loja
{
    private String nome;
    private List<Produtos> produtos;
    private LocalDateTime tempoEspera;
    private LocalDateTime tempoProcessamento;
    private int pessoasEspera;
    private double latitude;
    private double longitude;
    private boolean existeEncomenda;
    private int encomendasConcluidas;

    public Loja()
    {
        this.nome = new String();
        this.produtos = new ArrayList<>();
        this.tempoEspera = LocalDateTime.now();
        this.tempoProcessamento = LocalDateTime.now();
        this.pessoasEspera = 0;
        this.latitude = 0;
        this.longitude = 0;
        this.existeEncomenda = false;
        this.encomendasConcluidas = 0;
    }

    public Loja(String nome, List<Produtos> produtos, LocalDateTime tempoEspera, LocalDateTime tempoProcessamento, int pessoasEspera, double latitude, double longitude, boolean bool, int nmr)
    {
        this.nome = nome;
        this.produtos = produtos;
        this.tempoEspera = tempoEspera;
        this.tempoProcessamento = tempoProcessamento;
        this.pessoasEspera = pessoasEspera;
        this.latitude = latitude;
        this.longitude = longitude;
        this.existeEncomenda = bool;
        this.encomendasConcluidas = nmr;
    }

    public Loja(Loja loja )
    {
        this.nome = loja.getNome();
        setProdutos(loja.getProdutos());
        this.tempoEspera = loja.getTempoEspera();
        this.tempoProcessamento = loja.getTempo();
        this.pessoasEspera = loja.getPessoas();
        this.latitude = loja.getLatitude();
        this.longitude = loja.getLongitude();
        this.existeEncomenda = loja.getExisteEncomenda();
        this.encomendasConcluidas = loja.getEncomendas();
    }

    public void setProdutos(List<Produtos> produtos) //construtor por copia
    {
        this.produtos = new ArrayList<>();
        for (Produtos prod : produtos)
            this.produtos.add(prod.clone());
    }

    public List<Produtos> getProdutos()
    {
        List<Produtos> aux = new ArrayList<>(); // temos de criar uma copia por causa do encapsulamento
        for (Produtos prod : this.produtos)
            aux.add(prod.clone());
        return aux;
    }

    public boolean getExisteEncomenda()
    {
        return this.existeEncomenda;
    }

    public int getEncomendas()
    {
        return this.encomendasConcluidas;
    }

    public String getNome()
    {
        return this.nome;
    }

    public double getLatitude()
    {
        return this.latitude;
    }

    public double getLongitude()
    {
        return this.longitude;
    }

    public int getPessoas()
    {
        return this.pessoasEspera;
    }

    public LocalDateTime getTempoEspera()
    {
        return this.tempoEspera;
    }

    public LocalDateTime getTempo()
    {
        return this.tempoProcessamento;
    }

    public void adicionaPessoaEspera()
    {
        this.pessoasEspera +=1;
    }

    public void removePessoaEspera()
    {
        this.pessoasEspera -=1;
    }

    public Loja clone()
    {
        return new Loja(this);
    }

    public void sinalizaEncomenda()
    {
        this.existeEncomenda = true;
    }

    public void concluiuencomenda()
    {
        this.existeEncomenda = false;
    }

    public void adicionaEncomendaConcluida()
    {
        this.encomendasConcluidas +=1;
    }
}
