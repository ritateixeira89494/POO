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

    public Object[] topTransportadoras() {

        Map<Transportadora, Double> mp = new HashMap<>();
        for (String s : this.transportadoras.keySet()) {

            mp.putIfAbsent(this.transportadoras.get(s), this.transportadoras.get(s).getKmsTotal());

        }
        Object[] a = mp.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                if (((Map.Entry<String,Integer>) o1).getValue()
                        .compareTo(((Map.Entry<String,Integer>) o2).getValue()) > 0) return -1;
                else if (((Map.Entry<String, Integer>) o1).getValue()
                        .compareTo(((Map.Entry<String, Integer>) o2).getValue()) < 0) return 1;
                else return ((Map.Entry<String, Integer>) o1).getKey()
                            .compareTo(((Map.Entry<String, Integer>) o2).getKey());
            }
        });
        return a;
    }


    public Transportadoras clone()
    {
        return new Transportadoras (this);
    }
}
