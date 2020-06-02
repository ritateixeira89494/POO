public class Main {
    public static void main(String[] args) throws NaoExisteUtilizadorException, ExisteUtilizadorException, ExisteLojaException, ExisteEncomenda {
        Sistema s = new Sistema();
       // Read rl = new Read();
        s.registarLoja();
        s.pedidoEncomenda("taniatt");
        //rl.readLog(s);
      //s.registarUtilizador();
       s.iniciarLogin();
       // System.out.println(s.getUtilizadores().getUtilizadores().toString());
    }
}
