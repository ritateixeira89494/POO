import java.util.Map;

public class OutputView {

    static void printMenu(){
        System.out.println("---------------------------------");
        System.out.println("--------------MENU----------------");
        System.out.println("---------------------------------");
        System.out.println(" 0 - Sair");
        System.out.println(" 1 - Carregar dados dos LOGS:");
        System.out.println(" 2 - Registar um Utilizador");
        System.out.println(" 3 - Registar um Voluntário:");
        System.out.println(" 4 - Registar empresa Transportadora:");
        System.out.println(" 5 - LOGIN;");
        System.out.println(" 6 - Total faturado por uma Empresa num período:");
        System.out.println(" 7 - Obter os 10 Utilizadores que mais utilizam o Sistema:");
        System.out.println(" 8 - Obter as 10 Empresas que mais utilizam o Sistema:");
        System.out.println(" 9 - Gravar o estado da aplicação");
        System.out.println("Selecione uma opção:");
    }

    static void print(String s)
    {
        System.out.println(s);
    }

    static void printMp(Map<String, LinhaEncomenda> produtos) {

        System.out.println(produtos);
    }

}

