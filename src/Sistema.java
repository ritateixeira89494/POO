import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
      OutputView.print("Inserir um Utilizador");

      OutputView.print("Digite nome ");
      String nome = Input.lerString();
      OutputView.print("Digite user ");
      String user = Input.lerString();
      OutputView.print("Digite x ");
      Double x = Input.lerDouble();
      OutputView.print("Digite y ");
      Double y = Input.lerDouble();

      if(this.utilizadores.getUtilizadores().containsKey(user))
      {
          throw new ExisteUtilizadorException();
      }
      else {
          OutputView.print("Novo utilizador criado!");
          this.utilizadores.getUtilizadores().put(user,new Utilizador(user, nome, x, y));
      }

  }

    public void registarVoluntario() throws ExisteVoluntarioException
    {
        OutputView.print("Registar um voluntário");

        OutputView.print("Digite o nome ");
        String nome = Input.lerString();
        OutputView.print("Digite o código ");
        String codigo = Input.lerString();
        OutputView.print("Digite o raio ");
        Double raio = Input.lerDouble();
        OutputView.print("Digite x ");
        Double x = Input.lerDouble();
        OutputView.print("Digite y ");
        Double y = Input.lerDouble();

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
        OutputView.print("Registar uma transportadora");

        OutputView.print("Digite o nome ");
        String nome = Input.lerString();
        OutputView.print("Digite o código ");
        String codigo = Input.lerString();
        OutputView.print("Digite o raio ");
        Double raio = Input.lerDouble();
        OutputView.print("Digite x ");
        Double x = Input.lerDouble();
        OutputView.print("Digite y ");
        Double y = Input.lerDouble();
        OutputView.print("Digite o NIF ");
        String nif = Input.lerString();
        OutputView.print("Digite o preço ");
        Double preco = Input.lerDouble();

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
        OutputView.print("Registar uma Loja");

        OutputView .print("Insira o nome da Loja");
        String nome = Input.lerString();
        OutputView.print("Insira o codigo da Loja ");
        String codigo = Input.lerString();
        OutputView.print("Insira a coordenada em x da Loja");
        Double x = Input.lerDouble();
        OutputView.print("Insira a coordenada em y da Loja");
        Double y = Input.lerDouble();

        if(this.lojas.getLojas().containsKey(codigo))
        {
           throw new ExisteLojaException();
        }
        else {
            this.lojas.getLojas().put(codigo,new Loja(codigo,nome,x,y));
        }

    }

    public void pedidoEncomenda(String user) throws ExisteEncomenda, ExisteLojaException {
        OutputView.print("Pedido de Encomenda");
        OutputView.print("Digite o código da sua encomenda ");
        String codigo = Input.lerString();
        Map<String, LinhaEncomenda> produtos = new HashMap<>();

        try {
            if (!(existeEncomenda(codigo))) {
                OutputView.print("Insira o codigo da loja da qual quer efetuar a encomenda");
                String codLoja = Input.lerString();
                try {
                    if(existeLoja(codLoja)) {
                        OutputView.print("Insira o peso da encomenda:");
                        double peso = Input.lerDouble();
                        int option = 1;

                        while (option != 0) {


                            OutputView.print("Insira o que quer efetuar na sua encomenda");

                            OutputView.print("Código do Produto:");
                            String codeNC = Input.lerString();
                            OutputView.print("Descrição do Produto:");
                            String descreNC = Input.lerString();
                            OutputView.print("Quantidade:");
                            double quant = Input.lerDouble();
                            OutputView.print("Valor unitário:");
                            double val =Input.lerDouble();

                            OutputView.print("CONFIRMAR LINHA DE ENCOMENDA");
                            OutputView.print("Código da Produto->" + codeNC);
                            OutputView.print("Descrição do Produto ->" + descreNC);
                            OutputView.print("Quantidade " + quant);
                            OutputView.print("Valor unitário " + val);


                            OutputView.print("Inserir Linha de encomenda? S/N?");
                            String verifica = Input.lerString();
                            if (verifica.equals("S")) {
                                produtos.put(codeNC, new LinhaEncomenda(descreNC, codeNC, quant, val));
                            }
                            OutputView.print("Acabou a encomenda?");
                            OutputView.print("0-se sim  1-para continuar");
                            option = Input.lerInt();

                        }
                        encomendas.getEncomendas().put(codigo, new Encomenda(codLoja, user, codigo, peso, produtos));
                    }
                } catch (NaoExisteLojaException h) {
                    OutputView.print("Nao existe loja com o código " + codLoja);
                }
                //this.voluntarios.getVoluntarios().put(codigo,new Voluntario(nome,codigo,raio, x, y));

            }
        }

        catch(ExisteEncomenda l)
            {
                OutputView.print("Já existe uma encomenda com esse código " + codigo);
            }

        OutputView.print(encomendas.getEncomendas().toString());
        OutputView.printMp(produtos);
        }



    public void iniciarLogin() throws NaoExisteUtilizadorException, ExisteUtilizadorException {

        OutputView.print("-------LOGIN-------");
        OutputView.print("Insira o seu user");
        String user = Input.lerString();
        boolean f=false;
        boolean b=false;

            try {
                if(validaUser(user)) {

                    while (b==false) {
                        OutputView.print("Insira o seu email");
                        String email = Input.lerString();
                        if (validaEmail(user, email)) {
                            b = true;
                        } else {
                            OutputView.print("Email errado!");
                        }
                    }
                        while (f==false)
                        {
                            OutputView.print("Insira a sua passe");
                            String passe = Input.lerString();
                            if(validaPass(user,passe)) {
                                f=true;
                            }
                            else {
                                OutputView.print("Passe errada!");
                            }

                        }

                    }


            } catch (NaoExisteUtilizadorException e) {
                OutputView.print("Não existe utiliziador com user " + user);
                OutputView.print("Criar um utilizador? S/N?");
                String decide =Input.lerString();
                if (decide.equals("S"))
                    try {
                        registarUtilizador();
                    }
                catch (ExisteUtilizadorException t)
                {
                    OutputView.print("Já existe um utilizador com esse user!");
                }

                else {
                    OutputView.print("Sair da aplicação?");
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

