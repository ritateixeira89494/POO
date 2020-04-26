import java.util.List;
import java.util.ArrayList;

public class Lojas
{
    private List<Loja> lojas;

    public Lojas()  // construtor por omissao
    {
        this.lojas = new ArrayList<>();
    }

    public Lojas ( ArrayList<Loja> lojas) // construtor parametrizado
    {
        setLojas(lojas); // de modo a permitir o encapsulamento de dados
    }

    public Lojas (Lojas lojas)
    {
        setLojas(lojas.getLojas());
    }

    public void setLojas(List<Loja> lojas) //construtor por copia
    {
        this.lojas = new ArrayList<>();
        for (Loja loja : lojas)
            this.lojas.add(loja.clone());
    }

    public List<Loja> getLojas()
    {
        List<Loja> aux = new ArrayList<>(); // temos de criar uma copia por causa do encapsulamento
        for (Loja loja : this.lojas)
            aux.add(loja.clone());
        return aux;
    }

    public void adicionaLoja (Loja loja)
    {
        this.lojas.add(loja);
    }


    public Lojas clone()
    {
        return new Lojas (this);
    }

}
