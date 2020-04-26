import java.util.List;
import java.util.ArrayList;

public class Produtos
{
    private List<Produto> produtos;

    public Produtos()  // construtor por omissao
    {
        this.produtos = new ArrayList<>();
    }

    public Produtos( ArrayList<Produto> produtos) // construtor parametrizado
    {
        setProdutos(produtos); // de modo a permitir o encapsulamento de dados
    }

    public Produtos (Produtos prod)
    {
        setProdutos(prod.getProdutos());
    }

    public void setProdutos(List<Produto> produtos) //construtor por copia
    {
        this.produtos = new ArrayList<>();
        for (Produto prod : produtos)
            this.produtos.add(prod.clone());
    }

    public List<Produto> getProdutos()
    {
        List<Produto> aux = new ArrayList<>(); // temos de criar uma copia por causa do encapsulamento
        for (Produto prod : this.produtos)
            aux.add(prod.clone());
        return aux;
    }

    public void adicionaProduto (Produto prod)
    {
        this.produtos.add(prod);
    }

    public Produtos clone()
    {
        return new Produtos(this);
    }
}


