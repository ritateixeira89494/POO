public class Produto
{
    private String nome;
    private int quantidade;
    private double preco;


    Produto()
    {
        this.nome = new String();
        this.quantidade = 0;
        this.preco = 0;
    }

    Produto (String nome, int quantidade, double preco)
    {
        this.nome = nome;
        this.quantidade = quantidade ;
        this.preco = preco;
    }

    Produto (Produto pd)
    {
        this.nome = pd.getNome();
        this.quantidade = pd.getQuantidade();
        this.preco = pd.getPreco();
    }

    public String getNome()
    {
        return this.nome;
    }

    public int getQuantidade()
    {
        return this.quantidade;
    }

    public double getPreco()
    {
        return this.preco;
    }

    public Produto clone()
    {
        return new Produto(this);
    }
}
