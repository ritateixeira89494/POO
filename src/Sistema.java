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

    public void pedidoEncomenda(String user) throws ExisteEncomenda, ExisteLojaException {
        System.out.println("Pedido de Encomenda");
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código da sua encomenda ");
        String codigo = sc.nextLine();
        Map<String, LinhaEncomenda> produtos = new HashMap<>();

        try {
            if (!(existeEncomenda(codigo))) {
                System.out.println("Insira o codigo da loja da qual quer efetuar a encomenda");
                String codLoja = sc.nextLine();
                try {
                    if(existeLoja(codLoja)) {
                        System.out.println("Insira o peso da encomenda:");
                        double peso = sc.nextDouble();
                        int option = 1;

                        while (option != 0) {


                            System.out.println("Insira o que quer efetuar na sua encomenda");

                            System.out.print("Código do Produto:");
                            String codeNC = sc.next();
                            System.out.print("Descrição do Produto:");
                            String descreNC = sc.next();
                            System.out.print("Quantidade:");
                            double quant = sc.nextDouble();
                            System.out.print("Valor unitário:");
                            double val = sc.nextDouble();

                            System.out.println("CONFIRMAR LINHA DE ENCOMENDA");
                            System.out.println("Código da Produto->" + codeNC);
                            System.out.println("Descrição do Produto ->" + descreNC);
                            System.out.println("Quantidade " + quant);
                            System.out.println("Valor unitário " + val);


                            System.out.println("Inserir Linha de encomenda? S/N?");
                            String verifica = sc.next();
                            if (verifica.equals("S")) {
                                produtos.put(codeNC, new LinhaEncomenda(descreNC, codeNC, quant, val));
                            }
                            System.out.println("Acabou a encomenda?");
                            System.out.println("0-se sim  1-para continuar");
                            option = sc.nextByte();

                        }
                        encomendas.getEncomendas().put(codigo, new Encomenda(codLoja, user, codigo, peso, produtos));
                    }
                } catch (NaoExisteLojaException h) {
                    System.out.println("Nao existe loja com o código " + codLoja);
                }
                //this.voluntarios.getVoluntarios().put(codigo,new Voluntario(nome,codigo,raio, x, y));

            }
        }

        catch(ExisteEncomenda l)
        {
            System.out.println("Já existe uma encomenda com esse código " + codigo);
        }

        System.out.println(encomendas.getEncomendas().toString());
        System.out.println(produtos);
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

    public boolean existeEncomenda(String cod) throws ExisteEncomenda
    {
        if(encomendas.getEncomendas().containsKey(cod))
        {
            throw new ExisteEncomenda();
        }

        return false;

    }
    public boolean existeLoja(String cod) throws NaoExisteLojaException
    {
        if(lojas.getLojas().containsKey(cod))
        {
            return true;
        }

        throw new NaoExisteLojaException();

    }

}

