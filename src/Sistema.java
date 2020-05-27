import java.util.Scanner;
import java.util.*;
import java.util.Map;
import java.lang.*;


public class Sistema extends Main{
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

  public void registarUtilizador() throws ExisteUtilizadorException
  {
      System.out.println("Inserir um Utilizador");
      Scanner sc = new Scanner(System.in);
      System.out.println("Digite nome ");
      String nome = sc.nextLine();
      System.out.println("Digite user ");
      String user = sc.nextLine();
      System.out.println("Digite x ");
      Double x = sc.nextDouble();
      System.out.println("Digite y ");
      Double y = sc.nextDouble();

      if(this.utilizadores.getUtilizadores().containsKey(user))
      {
          throw new ExisteUtilizadorException();
      }
      else {
          System.out.println("Novo utilizador criado!");
          this.utilizadores.getUtilizadores().put(user,new Utilizador(user, nome, x, y));
      }

  }

    public void registarVoluntario() throws ExisteVoluntarioException
    {
        System.out.println("Registar um voluntário");
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome ");
        String nome = sc.nextLine();
        System.out.println("Digite o código ");
        String codigo = sc.nextLine();
        System.out.println("Digite o raio ");
        Double raio = sc.nextDouble();
        System.out.println("Digite x ");
        Double x = sc.nextDouble();
        System.out.println("Digite y ");
        Double y = sc.nextDouble();

        if(this.voluntarios.getVoluntarios().containsKey(codigo))
        {
            throw new ExisteVoluntarioException();
        }
        else {
            this.voluntarios.getVoluntarios().put(codigo,new Voluntario(nome,codigo,raio, x, y));
        }

    }

    public void registarTransportadora() throws ExisteTransportadoraException
    {
        System.out.println("Registar uma transportadora");
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome ");
        String nome = sc.nextLine();
        System.out.println("Digite o código ");
        String codigo = sc.nextLine();
        System.out.println("Digite o raio ");
        Double raio = sc.nextDouble();
        System.out.println("Digite x ");
        Double x = sc.nextDouble();
        System.out.println("Digite y ");
        Double y = sc.nextDouble();
        System.out.println("Digite o NIF ");
        String nif = sc.nextLine();
        System.out.println("Digite o preço ");
        Double preco = sc.nextDouble();

        if(this.transportadoras.getTransportadoras().containsKey(codigo))
        {
           throw new ExisteTransportadoraException("Já existe uma transportadora com esse código!");
        }
        else {
            this.transportadoras.getTransportadoras().put(codigo,new Transportadora(codigo,nome, x, y,nif,raio,preco));
        }

    }

    public void registarLoja() throws ExisteLojaException
    {
        System.out.println("Registar uma Loja");
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o nome da Loja");
        String nome = sc.nextLine();
        System.out.println("Insira o codigo da Loja ");
        String codigo = sc.nextLine();
        System.out.println("Insira a coordenada em x da Loja");
        Double x = sc.nextDouble();
        System.out.println("Insira a coordenada em y da Loja");
        Double y = sc.nextDouble();

        if(this.lojas.getLojas().containsKey(codigo))
        {
           throw new ExisteLojaException();
        }
        else {
            this.lojas.getLojas().put(codigo,new Loja(codigo,nome,x,y));
        }

    }

    public void iniciarLogin() throws NaoExisteUtilizadorException, ExisteUtilizadorException {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------LOGIN-------");
        System.out.println("Insira o seu user");
        String user = sc.nextLine();
        boolean f=false;
        boolean b=false;

            try {
                if(validaUser(user)) {

                    while (b==false) {
                        System.out.println("Insira o seu email");
                        String email = sc.nextLine();
                        if (validaEmail(user, email)) {
                            b = true;
                        } else {
                            System.out.println("Email errado!");
                        }
                    }
                        while (f==false)
                        {
                            System.out.println("Insira a sua passe");
                            String passe = sc.nextLine();
                            if(validaPass(user,passe)) {
                                f=true;
                            }
                            else {
                                System.out.println("Passe errada!");
                            }

                        }

                    }


            } catch (NaoExisteUtilizadorException e) {
                System.out.println("Não existe utiliziador com user " + user);
                System.out.println("Criar um utilizador? S/N?");
                String decide = sc.nextLine();
                if (decide.equals("S"))
                    try {
                        registarUtilizador();
                    }
                catch (ExisteUtilizadorException t)
                {
                    System.out.println("Já eexiste um utilizador com esse user!");
                }

                else {
                    System.out.println("Sair da aplicação?");
                    //fazer funlão que feche
                }

            }
        }





    public boolean validaEmail(String user, String email)  {
        boolean b = false;
        for (Utilizador v : this.utilizadores.getUtilizadores().values())
            if (v.getNickname().equals(user)) {
                if (v.getEmail().equals(email)) {
                    b = true;
                } else {
                    b=false;
                }

            }
        return b;
    }

    public boolean validaPass(String user, String pass)  {
        boolean b = false;
        for (Utilizador v : this.utilizadores.getUtilizadores().values())
            if (v.getNickname().equals(user)) {
                if (v.getPass().equals(pass)) {
                    b = true;
                } else {
                    b=false;
                }

            }
        return b;
    }

    public boolean validaUser(String user) throws NaoExisteUtilizadorException
    {
        if(utilizadores.getUtilizadores().containsKey(user))
        {
            return true;
        }

            throw new NaoExisteUtilizadorException();

    }


    /** Devolve lista de voluntários disponiveis */
    public Map<String, Voluntario> voluntariosDisponiveis(Map<String, Voluntario> voluntarios) {
        Map<String, Voluntario> volDisp = new HashMap<String, Voluntario> ();
        for(String voluntario : voluntarios.keySet()) {
            if(voluntarios.get(voluntario).getLivre()) volDisp.put(voluntario, voluntarios.get(voluntario));
        }
        return volDisp;
    }

    /** Devolve lista de transportadoras disponiveis */
    public Map<String, Transportadora> transportadorasDisponiveis(Map<String, Transportadora> transportadoras) {
        Map<String, Transportadora> transDisp = new HashMap<String, Transportadora> ();
        for(String transportadora : transportadoras.keySet()) {
            if(transportadoras.get(transportadora).getDisponibilidade()) transDisp.put(transportadora, transportadoras.get(transportadora));
        }
        return transDisp;
    }

    /** Diz qual o voluntário mais proxima do utilizador user*/
    public Voluntario voluntarioMaisProx(Utilizador user, Map<String,Voluntario> voluntarios) {
        if(voluntarios.isEmpty()) return null;
        else{
            Voluntario vol = voluntarios.get(user);
            double distMin = user.getCoords().distance(voluntarios.get(user).getGPS()), distTemp;

            for(String voluntario : voluntarios.keySet()){
                distTemp = user.getCoords().distance(voluntarios.get(voluntario).getGPS());
                if( distTemp < distMin ) {
                    vol = new Voluntario(voluntarios.get(voluntario));
                    distMin = distTemp;}
            }
            return vol;
        }
    }

    /** Diz qual a transportadora mais proxima do utilizador user*/
    public Transportadora transportadoraMaisProx(Utilizador user, Map<String,Transportadora> transportadoras) {
        if(transportadoras.isEmpty()) return null;
        else{
            Transportadora trans = transportadoras.get(user);
            double distMin = user.getCoords().distance(transportadoras.get(user).getCoords()), distTemp;

            for(String transportadora : transportadoras.keySet()){
                distTemp = user.getCoords().distance(transportadoras.get(transportadora).getCoords());
                if( distTemp < distMin ) {
                    trans = new Transportadora(transportadoras.get(transportadora));
                    distMin = distTemp;}
            }
            return trans;
        }
    }

    /** Faz uma viagem com qualquer método de entrega mais proximo do destino pedido */
    /*
    public void viagemComMetodoMaisProx(Utilizador user, Map<String,Voluntario> voluntarios, Map<String,Transportadora> transportadoras, Ponto destino) {
        if(user == null) System.out.println("Tem de fazer login!");
        else {
            voluntariosDisponiveis(voluntarios);
            transportadorasDisponiveis(transportadoras);

        }
    }*/

}

