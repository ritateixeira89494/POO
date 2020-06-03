public class LinhaEncomenda
{
    private String codigo;
    private String nome;
    private double quantidade;
    private double preco;


    public LinhaEncomenda()
    {
        this.nome = new String();
        this.codigo = new String();
        this.quantidade = 0;
        this.preco = 0;
    }

    public LinhaEncomenda (String nome, String codigo, double quantidade, double preco)
    {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade ;
        this.preco = preco;
    }

    public LinhaEncomenda (LinhaEncomenda pd)
    {
        this.nome = pd.getNome();
        this.codigo = pd.getCodigo();
        this.quantidade = pd.getQuantidade();
        this.preco = pd.getPreco();
    }

    public String getNome()
    {
        return this.nome;
    }

    public String getCodigo()
    {
        return this.codigo;
    }

    public double getQuantidade()
    {
        return this.quantidade;
    }

    public double getPreco()
    {
        return this.preco;
    }

    public LinhaEncomenda clone()
    {
        return new LinhaEncomenda(this);
    }

    public String toString()
    {
        return   this.codigo+ ","
                +  " Nome: " + this.nome +" " + ","
                + "Preco: " + this.preco + "Quatidade: " + this.quantidade + "\n";
    }
}
