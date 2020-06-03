public class Main {
    public static void main(String[] args) throws NaoExisteUtilizadorException, ExisteUtilizadorException, ExisteEncomenda, ExisteLojaException {
        Sistema s = new Sistema();
        Read rl = new Read();
       // rl.readLog(s);
        s.registarLoja();
        s.pedidoEncomenda("taniatt");
      //s.registarUtilizador();
      // s.iniciarLogin();
       // System.out.println(s.getUtilizadores().getUtilizadores().toString());

       // s.pedidoEncomenda("user");
     //   s.getEncomendas().getEncomendas().put("e2345",)
    }
}
