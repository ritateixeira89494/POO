import java.util.*;

public class Encomendas
{
    private Map<String,Encomenda> encomendas;

    public Encomendas()
    {
        this.encomendas= new HashMap<>();
    }

    public Encomendas(Map<String,Encomenda> encomendas) // construtor parametrizado
    {
        setEncomendas(encomendas); // de modo a permitir o encapsulamento de dados
    }

    public Encomendas(Encomendas encomenda)
    {
        setEncomendas(encomenda.getEncomendas());
    }

    public void setEncomendas(Map<String,Encomenda> produtos) {
        this.encomendas = new HashMap<>();
        this.encomendas.entrySet().forEach(e -> this.encomendas.put(e.getKey()
                , e.getValue()).clone());
    }

    public Map<String,Encomenda> getEncomendas() {
        return encomendas;
    }

    public void adicionaEncomendas(Encomenda encomenda)
    {
        this.encomendas.put(encomenda.getCodigo(),encomenda.clone());
    }

    public  String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Lista:").append(this.encomendas);
        return s.toString();
    }
    public Encomendas clone()
    {
        return new Encomendas((Map<String,Encomenda>) this);
    }
}


