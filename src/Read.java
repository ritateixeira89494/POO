import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


    public class Read extends Main {
        public void readLog() {
            File caminhoDoTexto = new File("/home/tania/Desktop/projetoPPP/POO/docs/logs_20200416.txt");

            //ficheiro para ler
            try {
                FileReader lerCaminhoTexto = new FileReader(caminhoDoTexto);

                // buffer que é uma especie de readLine

                BufferedReader lerArquivo = new BufferedReader(lerCaminhoTexto);


                while (lerArquivo.ready()) { // lê enquanto nao chega ao fim do ficheiro

                    String texto = lerArquivo.readLine(); // le a linha

                    String textoSplit[] = texto.split(":"); // separa por :

                    if (textoSplit[0].equals("Utilizador")) {
                        separaInfoUtilizador(textoSplit[1]);

                    }
                    if (textoSplit[0].equals("Voluntario")) {

                        separaInfoVoluntario(textoSplit[1]);
                    }

                    if (textoSplit[0].equals("Transportadora")) {
                        separaTransportadora(textoSplit[1]);
                    }

                   if (textoSplit[0].equals("Loja")) {
                        separaLoja(textoSplit[1]);
                    }

                    /*if (textoSplit[0].equals("Aceite")) {
                        separaLoja(textoSplit[1]);
                    }
                    */



                }


                lerArquivo.close();

            } catch (IOException e) {
                System.out.println("File not found");
            }
        }


        public void separaInfoUtilizador(String buffer) {

            if (buffer.equals("<CodUtilizador>,<Nome>,<GPS>")) {
                //  System.out.println("Isto nao interessa para nd");
            } else {
                String textoSplit[] = buffer.split(","); // separa o texto pelos parametros
                Utilizador u1 = new Utilizador(textoSplit[0], textoSplit[1], Double.parseDouble(textoSplit[2]), Double.parseDouble(textoSplit[3]));
                System.out.println(u1.toString());
            }
        }

        public void separaInfoVoluntario(String buffer) {


            if (buffer.equals("<CodVoluntÃ¡rio>, <Nome>,<GPS> ,<Raio>Â")) {
                //  System.out.println("Isto nao interessa para nd");
            } else {
                String textoSplit[] = buffer.split(","); // separa o texto pelos parametros
                Voluntario u1 = new Voluntario(textoSplit[1], textoSplit[0], Double.parseDouble(textoSplit[4]), Double.parseDouble(textoSplit[2]), Double.parseDouble(textoSplit[3]));
                System.out.println(u1.getNome());
            }
        }

        public void separaTransportadora(String buffer) {

            if (buffer.equals("<CodEmpresa>,<NomeEmpresa>,<GPS>,<NIF>,<raio>,<preco-por-km>")) {
                //  System.out.println("Isto nao interessa para nd"); //
            } else {
                String textoSplit[] = buffer.split(","); // separa o texto pelos parametros
                Transportadora u1 = new Transportadora(textoSplit[0], textoSplit[1], Double.parseDouble(textoSplit[2]), Double.parseDouble(textoSplit[3]), textoSplit[4], Double.parseDouble(textoSplit[5]), Double.parseDouble(textoSplit[6]));
                System.out.println(u1.getNome());
            }
        }

        public void separaLoja(String buffer) {

            if (buffer.equals("<CodLoja>, <NomeLoja>,<GPS>")) {
                //  System.out.println("Isto nao interessa para nd"); //
            } else {
                String textoSplit[] = buffer.split(","); // separa o texto pelos parametros
                Loja u1 = new Loja(textoSplit[0],textoSplit[1],Double.parseDouble(textoSplit[2]),Double.parseDouble(textoSplit[3]));
                System.out.println(u1.getNome());
            }
        }
    }



