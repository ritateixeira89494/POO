import java.util.List;
import java.util.ArrayList;

public class LinhaEncomenda extends Main
{
    private List<Encomenda> encomendas;

    LinhaEncomenda ()
    {
        this.encomendas= new ArrayList<>();
    }

    public LinhaEncomenda(List<Encomenda> encomendas) // construtor parametrizado
    {
        setEncomendas(encomendas); // de modo a permitir o encapsulamento de dados
    }

    public LinhaEncomenda(LinhaEncomenda encomenda)
    {
        setEncomendas(encomenda.getEncomendas());
    }

    public void setEncomendas(List<Encomenda> encomendas) //construtor por copia
    {
        this.encomendas= new ArrayList<>();
        for (Encomenda encomenda: encomendas)
            this.encomendas.add(encomenda.clone());
    }

    public List<Encomenda> getEncomendas()
    {
        List<Encomenda> aux = new ArrayList<>(); // temos de criar uma copia por causa do encapsulamento
        for (Encomenda encomenda: this.encomendas)
            aux.add(encomenda.clone());
        return aux;
    }

    public void adicionaEncomendas(Encomenda encomenda)
    {
        this.encomendas.add(encomenda);
    }


    public LinhaEncomenda clone()
    {
        return new LinhaEncomenda(this);
    }
}


