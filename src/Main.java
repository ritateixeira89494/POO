public class Main {
    public static void main(String[] args) throws ExisteLojaException, ExisteUtilizadorException {
        Sistema sistema = new Sistema();
        sistema.registarLoja();
        sistema.registarUtilizador();
        //sistema.pedidoEncomenda();
    }
}
