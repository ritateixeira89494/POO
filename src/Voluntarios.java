import java.util.*;

public class Voluntarios extends Main
{
    private Map<String,Voluntario> voluntarios;


    public Voluntarios()  // construtor por omissao
    {
        this.voluntarios = new HashMap<>();
    }

    public Voluntarios( Map<String,Voluntario> voluntarios) // construtor parametrizado
    {
        setVoluntarios(voluntarios); // de modo a permitir o encapsulamento de dados
    }

    public Voluntarios (Voluntarios vols)
    {
        setVoluntarios(vols.getVoluntarios());
    }

    public void setVoluntarios(Map<String,Voluntario> voluntarios) //construtor por copia
    {
        this.voluntarios = new HashMap<>();
        this.voluntarios.entrySet().forEach(e -> this.voluntarios.put(e.getKey()
                , e.getValue()).clone());
    }

    public Map<String,Voluntario> getVoluntarios()
    {
        return voluntarios;
    }

    public void adicionaVoluntario ( Voluntario volu)
    {
        this.voluntarios.put(volu.getCod(),volu.clone());
    }
}
  