import java.util.*;

public class Transportadoras
{
    private Map<String,Transportadora> transportadoras;

    Transportadoras ()
    {
        this.transportadoras = new HashMap<>();
    }

    public Transportadoras ( Map<String,Transportadora> transportadoras) // construtor parametrizado
    {
        setTransportadoras(transportadoras); // de modo a permitir o encapsulamento de dados
    }

    public Transportadoras (Transportadoras transportadoras)
    {
        setTransportadoras(transportadoras.getTransportadoras());
    }

    public void setTransportadoras(Map<String,Transportadora> transportadoras) //construtor por copia
    {
        this.transportadoras = new HashMap<>();
        this.transportadoras.entrySet().forEach(e -> this.transportadoras.put(e.getKey()
                , e.getValue()).clone());
    }

    public Map<String,Transportadora> getTransportadoras()
    {
        return transportadoras;
    }

    public  String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Lista: ").append(this.transportadoras);
        return s.toString() + "\n";
    }

    public void adicionaTransportadora (Transportadora transportadora)
    {
        this.transportadoras.put(transportadora.getCodigo(),transportadora.clone());
    }


    public Transportadoras clone()
    {
        return new Transportadoras (this);
    }
}
