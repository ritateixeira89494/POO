public class Utilizador {

    private String nickname;
    private String nome;
    private double longitude;
    private double latitude;

    public Utilizador()
    {
        this.nickname = new String();
        this.nome = new String();
        this.latitude = 0;
        this.longitude = 0;
    }

    public Utilizador( String nickname, String nome, double latitude, double longitude)
    {
        this.nickname = nickname;
        this.nome = nome;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Utilizador ( Utilizador uti)
    {
        this.nickname = uti.getNickname();
        this.nome = uti.getNome();
        this.latitude = uti.getLatitude();
        this.longitude = uti.getLongitude();
    }

    public String getNickname()
    {
        return this.nickname;
    }

    public String getNome() {
        return this.nome;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Utilizador clone()
    {
        return new Utilizador(this);
    }
}


