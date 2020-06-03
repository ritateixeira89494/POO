import java.io.Serializable;

public class Utilizador implements Serializable {

    private String nickname;
    private String nome;
    private Ponto coordsU;
    private String email;
    private String pass;

    public Utilizador()
    {
        this.nickname = new String();
        this.nome = new String();
        this.coordsU = new Ponto();
        this.email = new String();
        this.pass = new String();
    }

    public Utilizador( String nickname, String nome, double latitude, double longitude)
    {
        this.nickname = nickname;
        this.nome = nome;
        this.coordsU = new Ponto(latitude,longitude);
        this.email = nickname + "@poo20.pt";
        this.pass= nickname + primeiroNome(nome);
    }

    public Utilizador ( Utilizador uti)
    {
        this.nickname = uti.getNickname();
        this.nome = uti.getNome();
        this.coordsU = new Ponto(uti.getCoords().getX(),uti.getCoords().getY());
        this.email = uti.getEmail();
        this.pass = uti.getPass();
    }

    /** Getter das coordenadas. */
    public Ponto getCoords() {
        return coordsU;
    }
    /** Setter das coordenadas. */
    public void setCoords(Ponto coordsU) {
        this.coordsU = coordsU;
    }

    public String getNickname()
    {
        return this.nickname;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPass() {
        return this.pass;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String toString()
    {
        return "Utilizador " + this.nickname+ ","
              +  " Nome: " + this.nome +" " + ","
        + this.coordsU.toString() +"\n" + "mail " +
                this.email + " pass " + this.pass +"\n";
    }

    public String primeiroNome(String nome)
    {
        String textoSplit[] = nome.split(" ");
        return textoSplit[0];
    }
    public Utilizador clone()
    {
        return new Utilizador(this);
    }
}


