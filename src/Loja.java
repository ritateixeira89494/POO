import java.nio.file.LinkOption;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.io.Serializable;

public class Loja implements Serializable {
    private String nome;
    private String cod;
    private List<LinhaEncomenda> produtos;
    private double tempoEspera; // em min, bla bla bla, aleatorio
    private LocalDateTime tempoProcessamento;
    private List<String> pessoasEspera;
    private Ponto coordsL;
    private boolean existeEncomenda;
    private int encomendasConcluidas;


    public Loja() {
        this.nome = new String();
        this.cod = new String();
        this.produtos = new ArrayList<>();
        this.tempoEspera = 7;
        this.tempoProcessamento = LocalDateTime.now();
        this.pessoasEspera = new ArrayList<>();
        this.coordsL = new Ponto();
        this.existeEncomenda = false;
        this.encomendasConcluidas = 0;
    }

    public Loja(String nome, String cod, List<LinhaEncomenda> produtos, LocalDateTime tempoProcessamento, int pessoasEspera, double latitude, double longitude, boolean bool, int nmr) {
        this.nome = nome;
        this.cod = cod;
        this.produtos = produtos;
        this.tempoEspera = 7;
        this.tempoProcessamento = tempoProcessamento;
        this.pessoasEspera = new ArrayList<>();
        this.coordsL = new Ponto(latitude, longitude);
        this.existeEncomenda = bool;
        this.encomendasConcluidas = nmr;
    }

    public Loja(String cod, String nome, double latitude, double longitude) {
        this.nome = nome;
        this.cod = cod;
        this.produtos = new ArrayList<>();
        this.tempoEspera = 7;
        this.tempoProcessamento = LocalDateTime.now();
        this.pessoasEspera = new ArrayList<>();
        this.coordsL = new Ponto(latitude, longitude);
        this.existeEncomenda = false;
        this.encomendasConcluidas = 0;

    }

    public Loja(Loja loja) {
        this.nome = loja.getNome();
        this.cod = loja.getCodigo();
        setProdutos(loja.getProdutos());
        this.tempoEspera = 7;
        this.tempoProcessamento = loja.getTempo();
        this.pessoasEspera = new ArrayList<>();
        this.coordsL = new Ponto(loja.getCoords().getX(), loja.getCoords().getY());
        this.existeEncomenda = loja.getExisteEncomenda();
        this.encomendasConcluidas = loja.getEncomendas();
    }

    public void setProdutos(List<LinhaEncomenda> produtos) //construtor por copia
    {
        this.produtos = new ArrayList<>();
        for (LinhaEncomenda prod : produtos)
            this.produtos.add(prod.clone());
    }

    public List<LinhaEncomenda> getProdutos() {
        List<LinhaEncomenda> aux = new ArrayList<>(); // temos de criar uma copia por causa do encapsulamento
        for (LinhaEncomenda prod : this.produtos)
            aux.add(prod.clone());
        return aux;
    }

    public boolean getExisteEncomenda() {
        return this.existeEncomenda;
    }

    public int getEncomendas() {
        return this.encomendasConcluidas;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCodigo() {
        return this.cod;
    }

    /**
     * Getter das coordenadas.
     */
    public Ponto getCoords() {
        return coordsL;
    }

    /**
     * Setter das coordenadas.
     */
    public void setCoords(Ponto coordsL) {
        this.coordsL = coordsL;
    }


    public LocalDateTime getTempo() {
        return this.tempoProcessamento;
    }

    public String toString() {
        return "Utilizador -> " + "Código: " + this.cod + ","
                + " Nome: " + this.nome + " " + ","
                + this.coordsL.toString() + "\n";
    }

    public ArrayList<String> getListaEspera() {
        ArrayList<String> aux = new ArrayList<>();
        for (String s : this.pessoasEspera)

            aux.add(s);///          .clone();
        return aux;
    }

    public void adicionaPessoaEspera(String user) {
        this.pessoasEspera.add(user); //clone? // como add insere na cauda, o ultimo elemento inserido é o ultimo do array
    }

    public int pessoasFrente() {
        return this.pessoasEspera.size() + 1; // Mais 1 pq as pessoas só entram na lista enquanto existe uma encomenda a ser processada
    }


    public int procuraElemento(String user) {  //MELHORAR ISTO
        int j=0;
        for (int i = 0; i < pessoasEspera.size(); i++)
            if (pessoasEspera.get(i).equals("user"))
                 j=i;
            return j;
    }

    public double tempoEsperaTotal(Encomenda e) {
        return procuraElemento(e.getComprador()) * e.getTempoProcessamento();

    }

   public void removePessoadaFila() { // remove a 1 pessoa da fila
    int tam = this.pessoasEspera.size();
       List<String> pessoasEspera2 = new ArrayList<>();

    for(int i=1;i<tam;i++)
    {
       pessoasEspera2.add(pessoasEspera.get(i));
    }
         this.pessoasEspera = pessoasEspera2;
    }

        public Loja clone ()
        {
            return new Loja(this);
        }

        public void sinalizaEncomenda ()
        {
            this.existeEncomenda = true;
        }


        public void concluiuEncomenda ()
        {
            this.existeEncomenda = false;
        }

        public void adicionaEncomendaConcluida ()
        {
            this.encomendasConcluidas += 1;
        }
    }

