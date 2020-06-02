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

    public Object[] top10utilizadores() {

            Map<Utilizador, Integer> mp = new HashMap<>();
            for (String s : this.utilizadores.keySet()) {

                        mp.putIfAbsent(this.utilizadores.get(s), this.utilizadores.get(s).getNmr());

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
    }


