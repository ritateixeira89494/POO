public class Sistema extends Main{
    private String username;
    private String password;
    private Encomendas encomendas;
    private Lojas lojas;
    private Transportadoras transportadoras;
    public Utilizadores utilizadores;
    public Voluntarios voluntarios;


    public Sistema() {
      this.encomendas = new Encomendas();
      this.lojas = new Lojas();
      this.transportadoras = new Transportadoras();
      this.utilizadores = new Utilizadores();
      this.voluntarios = new Voluntarios();
    }

  public Encomendas getEncomendas()
  {
      return this.encomendas;
  }

  public Lojas getLojas()
  {
      return this.lojas;
  }

  public Transportadoras getTransportadoras()
  {
      return this.transportadoras;
  }

  public Utilizadores getUtilizadores()
  {
      return this.utilizadores;
  }

  public Voluntarios getVoluntarios()
  {
      return this.voluntarios;
  }

    String filepath = "../docs/logs_20200416.txt";
}
