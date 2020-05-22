import java.util.*;

public class Utilizadores {
    private Map <String,Utilizador> utilizadores;

    public Utilizadores()
    {
        this.utilizadores = new HashMap<>();
    }

    public Utilizadores(Map<String,Utilizador> utilizadores)
    {
        setUtilizadores(utilizadores);
    }

    public Utilizadores(Utilizadores utilizadores)
    {
        setUtilizadores(utilizadores.getUtilizadores());
    }

    public void setUtilizadores(Map<String,Utilizador> utilizadores) {
        this.utilizadores = new HashMap<>();
        this.utilizadores.entrySet().forEach(e -> this.utilizadores.put(e.getKey()
                , e.getValue()).clone());
    }

    public Map<String,Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void adicionaUtilizador (Utilizador utilizador)
    {
        this.utilizadores.put(utilizador.getNickname(),utilizador.clone());
    }

    public Utilizadores clone()
    {
        return new Utilizadores(this);
    }

    public  String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Lista:").append(this.utilizadores);
        return s.toString();
    }

    public boolean validaEmail(String user, String email)
    {
        boolean b = false;
        for (Utilizador v : this.utilizadores.values())
            if(v.getNickname().equals("user"))
            {
                if(v.getEmail().equals(email))
                {
                    b = true;}
                else{System.out.println("Email errado");} // para dps ficar mais bonito utilizar Exception
            }
        else {
                System.out.println("Utilizador não existe"); // para dps ficar mais bonito utilizar Exception
            }
        return b;
    }

    public boolean validaPass(String user, String pass)
    {
        boolean b = false;
        for (Utilizador v : this.utilizadores.values())
            if(v.getNickname().equals("user"))
            {
                if(v.getPass().equals(pass))
                {
                    b = true;}
                else{System.out.println("Passe errado");} // para dps ficar mais bonito utilizar Exception
            }
            else {
                System.out.println("Utilizador não existe"); // para dps ficar mais bonito utilizar Exception
            }
        return b;
    }

}
