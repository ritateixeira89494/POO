import java.nio.file.LinkOption;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.io.Serializable;

public class Loja implements Serializable
{
    private String nome;
    private String cod;
    private List<LinhaEncomenda> produtos;
    private LocalDateTime tempoEspera;
    private LocalDateTime tempoProcessamento;
    private int pessoasEspera;
    private Ponto coordsL;
    private boolean existeEncomenda;
    private int encomendasConcluidas;

    public Loja()
    {
        this.nome = new String();
        this.cod = new String();
        this.produtos = new ArrayList<>();
        this.tempoEspera = LocalDateTime.now();
        this.tempoProcessamento = LocalDateTime.now();
        this.pessoasEspera = 0;
        this.coordsL = new Ponto();
        this.existeEncomenda = false;
        this.encomendasConcluidas = 0;
    }

    public Loja(String nome,String cod, List<LinhaEncomenda> produtos, LocalDateTime tempoEspera, LocalDateTime tempoProcessamento, int pessoasEspera, double latitude, double longitude, boolean bool, int nmr)
    {
        this.nome = nome;
        this.cod = cod;
        this.produtos = produtos;
        this.tempoEspera = tempoEspera;
        this.tempoProcessamento = tempoProcessamento;
        this.pessoasEspera = pessoasEspera;
        this.coordsL = new Ponto(latitude,longitude);
        this.existeEncomenda = bool;
        this.encomendasConcluidas = nmr;
    }

    public Loja(String cod, String nome, double latitude, double longitude)
    {
        this.nome = nome;
        this.cod = cod;
        this.produtos =new ArrayList<>();
        this.tempoEspera = LocalDateTime.now();
        this.tempoProcessamento = LocalDateTime.now();
        this.pessoasEspera = 0;
        this.coordsL = new Ponto(latitude,longitude);
        this.existeEncomenda = false;
        this.encomendasConcluidas = 0;

    }

    public Loja(Loja loja )
    {
        this.nome = loja.getNome();
        this.cod = loja.getCodigo();
        setProdutos(loja.getProdutos());
        this.tempoEspera = loja.getTempoEspera();
        this.tempoProcessamento = loja.getTempo();
        this.pessoasEspera = loja.getPessoas();
        this.coordsL = new Ponto(loja.getCoords().getX(),loja.getCoords().getY());
        this.existeEncomenda = loja.getExisteEncomenda();
        this.encomendasConcluidas = loja.getEncomendas();
    }

    public void setProdutos(List<LinhaEncomenda> produtos) //construtor por copia
    {
        this.produtos = new ArrayList<>();
        for (LinhaEncomenda prod : produtos)
            this.produtos.add(prod.clone());
    }

    public List<LinhaEncomenda> getProdutos()
    {
        List<LinhaEncomenda> aux = new ArrayList<>(); // temos de criar uma copia por causa do encapsulamento
        for (LinhaEncomenda prod : this.produtos)
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

    public String getCodigo()
    {
        return this.cod;
    }

    /** Getter das coordenadas. */
    public Ponto getCoords() {
        return coordsL;
    }
    /** Setter das coordenadas. */
    public void setCoords(Ponto coordsL) {
        this.coordsL = coordsL;
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

    public void concluiuEncomenda()
    {
        this.existeEncomenda = false;
    }

    public void adicionaEncomendaConcluida()
    {
        this.encomendasConcluidas +=1;
    }
}
