import java.io.Serializable;

public class Utilizador implements Serializable {

    private String nickname;
    private String nome;
    private Ponto coordsU;

    public Utilizador()
    {
        this.nickname = new String();
        this.nome = new String();
        this.coordsU = new Ponto();
    }

    public Utilizador( String nickname, String nome, double latitude, double longitude)
    {
        this.nickname = nickname;
        this.nome = nome;
        this.coordsU = new Ponto(latitude,longitude);
    }

    public Utilizador ( Utilizador uti)
    {
        this.nickname = uti.getNickname();
        this.nome = uti.getNome();
        this.coordsU = new Ponto(uti.getCoords().getX(),uti.getCoords().getY());
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Utilizador clone()
    {
        return new Utilizador(this);
    }
}


