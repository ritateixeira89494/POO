import java.util.List;
import java.util.ArrayList;

public class Transportadoras extends Main
{
    private List<Transportadora> transportadoras;

    Transportadoras ()
    {
        this.transportadoras = new ArrayList<>();
    }

    public Transportadoras ( ArrayList<Transportadora> transportadoras) // construtor parametrizado
    {
        setTransportadoras(transportadoras); // de modo a permitir o encapsulamento de dados
    }

    public Transportadoras (Transportadoras transportadoras)
    {
        setTransportadoras(transportadoras.getTransportadoras());
    }

    public void setTransportadoras(List<Transportadora> transportadoras) //construtor por copia
    {
        this.transportadoras = new ArrayList<>();
        for (Transportadora transportadora : transportadoras)
            this.transportadoras.add(transportadora.clone());
    }

    public List<Transportadora> getTransportadoras()
    {
        List<Transportadora> aux = new ArrayList<>(); // temos de criar uma copia por causa do encapsulamento
        for (Transportadora transportadora : this.transportadoras)
            aux.add(transportadora.clone());
        return aux;
    }

    public void adicionaTransportadora (Transportadora transportadora)
    {
        this.transportadoras.add(transportadora);
    }


    public Transportadoras clone()
    {
        return new Transportadoras (this);
    }
}
