import java.util.ArrayList;
import java.util.List;

public class Utilizadores {
    private List <Utilizador> utilizadores;

    public Utilizadores()
    {
        this.utilizadores = new ArrayList<>();
    }

    public Utilizadores(List<Utilizador> utilizadores)
    {
        setUtilizadores(utilizadores);
    }

    public Utilizadores(Utilizadores utilizadores)
    {
        setUtilizadores(utilizadores.getUtilizadores());
    }

    public void setUtilizadores(List<Utilizador> utilizadores) {
        this.utilizadores = new ArrayList<>();
        for (Utilizador utilizador : utilizadores)
            this.utilizadores.add(utilizador.clone());
    }

    public List<Utilizador> getUtilizadores() {
        List<Utilizador> aux = new ArrayList<>(); // temos de criar uma copia por causa do encapsulamento
        for (Utilizador utilizador : this.utilizadores)
            aux.add(utilizador.clone());
        return aux;
    }
}
