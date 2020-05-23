public class Main {
    public static void main(String[] args) throws NaoExisteUtilizadorException, ExisteUtilizadorException {
        Sistema s = new Sistema();
        Read rl = new Read();
        //rl.readLog(s);
      //s.registarUtilizador();
       s.iniciarLogin();
       // System.out.println(s.getUtilizadores().getUtilizadores().toString());
    }
}
