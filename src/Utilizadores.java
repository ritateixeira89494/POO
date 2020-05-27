import java.util.*;

public class Utilizadores {
    private Map<String, Utilizador> utilizadores;

    public Utilizadores() {
        this.utilizadores = new HashMap<>();
    }

    public Utilizadores(Map<String, Utilizador> utilizadores) {
        setUtilizadores(utilizadores);
    }

    public Utilizadores(Utilizadores utilizadores) {
        setUtilizadores(utilizadores.getUtilizadores());
    }

    public void setUtilizadores(Map<String, Utilizador> utilizadores) {
        this.utilizadores = new HashMap<>();
        this.utilizadores.entrySet().forEach(e -> this.utilizadores.put(e.getKey()
                , e.getValue()).clone());
    }

    public Map<String, Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void adicionaUtilizador(Utilizador utilizador) {
        this.utilizadores.put(utilizador.getNickname(), utilizador.clone());
    }

    public Utilizadores clone() {
        return new Utilizadores(this);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Lista:").append(this.utilizadores);
        return s.toString() + "\n";
    }
}

