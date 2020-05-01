import java.util.ArrayList;
import java.util.List;

public class Voluntarios extends Main
{
    private List<Voluntario> voluntarios;

    public Voluntarios()  // construtor por omissao
    {
        this.voluntarios = new ArrayList<>();
    }

    public Voluntarios( ArrayList<Voluntario> voluntarios) // construtor parametrizado
    {
        setVoluntarios(voluntarios); // de modo a permitir o encapsulamento de dados
    }

    public Voluntarios (Voluntarios vols)
    {
        setVoluntarios(vols.getVoluntarios());
    }

    public void setVoluntarios(List<Voluntario> voluntarios) //construtor por copia
    {
        this.voluntarios = new ArrayList<>();
        // para casa voluntario em vol, temos que o inserir em this.voluntarios
        for (Voluntario vol : voluntarios)
            this.voluntarios.add(vol.clone());
    }

    public List<Voluntario> getVoluntarios()
    {
        List<Voluntario> aux = new ArrayList<>(); // temos de criar uma copia por causa do encapsulamento
        for (Voluntario vol : this.voluntarios)
            aux.add(vol.clone());
        return aux;
    }

    public void adicionaVoluntario ( Voluntario volu)
    {
        this.voluntarios.add(volu);
    }
}
  