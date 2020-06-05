import java.util.*;

public class Lojas
{
    private Map<String,Loja> lojas;

    public Lojas()  // construtor por omissao
    {
        this.lojas = new HashMap<>();
    }

    public Lojas ( Map<String,Loja> lojas) // construtor parametrizado
    {
        setLojas(lojas); // de modo a permitir o encapsulamento de dados
    }

    public Lojas (Lojas lojas)
    {
        setLojas(lojas.getLojas());
    }

    public void setLojas(Map<String,Loja> lojas) //construtor por copia
    {
        this.lojas = new HashMap<>();
        this.lojas.entrySet().forEach(e -> this.lojas.put(e.getKey()
                , e.getValue()).clone());
    }

    public Map<String,Loja> getLojas()
    {
        return lojas;
    }

    public void adicionaLoja (Loja loja)
    {
        this.lojas.put(loja.getCodigo(),loja.clone());
    }

    public  String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Lista:").append(this.lojas);
        return s.toString() + "\n";
    }
    public Lojas clone()
    {
        return new Lojas (this);
    }

}
