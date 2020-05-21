import java.io.*;
import java.util.*;


    public class Read extends Main implements Serializable {
        public void readLog(Sistema s) {
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
                        separaInfoUtilizador(textoSplit[1], s);

                    }
                    if (textoSplit[0].equals("Voluntario")) {

                        separaInfoVoluntario(textoSplit[1], s);
                    }

                    if (textoSplit[0].equals("Transportadora")) {
                        separaTransportadora(textoSplit[1], s);
                    }

                    if (textoSplit[0].equals("Loja")) {
                        separaLoja(textoSplit[1], s);
                    }

                    if (textoSplit[0].equals("Encomenda")) {
                        separaEncomenda(textoSplit[1], s);
                    }


                    if (textoSplit[0].equals("Aceite")) {
                        verificaEstado(textoSplit[1], s);

                    }

                }

                lerArquivo.close();

            } catch (IOException e) {
                System.out.println("File not found");
            }

            System.out.println(s.getUtilizadores().getUtilizadores().toString());
            System.out.println(s.getEncomendas().getEncomendas().toString());
            System.out.println(s.getTransportadoras().getTransportadoras().toString());
            System.out.println(s.getVoluntarios().getVoluntarios().toString());
            System.out.println(s.getLojas().getLojas().toString());
        }


        public void separaInfoUtilizador(String buffer, Sistema s) {

            if (buffer.equals("<CodUtilizador>,<Nome>,<GPS>")) {
                //  System.out.println("Isto nao interessa para nd");
            } else {
                String textoSplit[] = buffer.split(","); // separa o texto pelos parametros
                s.getUtilizadores().getUtilizadores().put(textoSplit[0], new Utilizador(textoSplit[0], textoSplit[1], Double.parseDouble(textoSplit[2]), Double.parseDouble(textoSplit[3])));
                //System.out.println(s.getUtilizadores().getUtilizadores().toString());
            }
        }

        public void separaInfoVoluntario(String buffer, Sistema s) {


            if (buffer.equals("<CodVoluntÃ¡rio>, <Nome>,<GPS> ,<Raio>Â")) {
                //  System.out.println("Isto nao interessa para nd");
            } else {
                String textoSplit[] = buffer.split(","); // separa o texto pelos parametros
                s.getVoluntarios().getVoluntarios().put(textoSplit[0], new Voluntario(textoSplit[1], textoSplit[0], Double.parseDouble(textoSplit[4]), Double.parseDouble(textoSplit[2]), Double.parseDouble(textoSplit[3])));
            }
        }

        public void separaTransportadora(String buffer, Sistema s) {

            if (buffer.equals("<CodEmpresa>,<NomeEmpresa>,<GPS>,<NIF>,<raio>,<preco-por-km>")) {
                //  System.out.println("Isto nao interessa para nd"); //
            } else {
                String textoSplit[] = buffer.split(","); // separa o texto pelos parametros
                s.getTransportadoras().getTransportadoras().put(textoSplit[0], new Transportadora(textoSplit[0], textoSplit[1], Double.parseDouble(textoSplit[2]), Double.parseDouble(textoSplit[3]), textoSplit[4], Double.parseDouble(textoSplit[5]), Double.parseDouble(textoSplit[6])));
            }
        }

        public void separaLoja(String buffer, Sistema s) {

            if (buffer.equals("<CodLoja>, <NomeLoja>,<GPS>")) {
                //  System.out.println("Isto nao interessa para nd"); //
            } else {
                String textoSplit[] = buffer.split(","); // separa o texto pelos parametros
                s.getLojas().getLojas().put(textoSplit[0], new Loja(textoSplit[0], textoSplit[1], Double.parseDouble(textoSplit[2]), Double.parseDouble(textoSplit[3])));

            }
        }

        public void separaEncomenda(String buffer, Sistema s) {

            if (buffer.equals("<CodEncomenda>, <CodUtilizador>, <CodLoja>, <Peso>, <LinhaEncomenda>+")) {
                //  System.out.println("Isto nao interessa para nd"); //
            } else {
                String textoSplit[] = buffer.split(","); // separa o texto pelos parametros
                s.getEncomendas().getEncomendas().put(textoSplit[0], new Encomenda(textoSplit[2], textoSplit[1], (textoSplit[0]), Double.parseDouble(textoSplit[3]), aux(buffer)));
                // System.out.println(s.getEncomendas());

            }
        }

        public Map<String, LinhaEncomenda> aux(String buffer) {
            int i = 4;
            Map<String, LinhaEncomenda> aux = new HashMap<>();
            String textoSplit[] = buffer.split(",");
            while (i < textoSplit.length - 1) {

                aux.put(textoSplit[i], new LinhaEncomenda(textoSplit[i], textoSplit[i + 1], Double.parseDouble(textoSplit[i + 2]), Double.parseDouble(textoSplit[i + 3])));

                i += 4;
            }
            //  System.out.println(aux.get(textoSplit[4]).getPreco());
            return aux;

        }

        public void verificaEstado(String buffer, Sistema s) {

            if (buffer.equals("<CodEccomenda>")) {
               // System.out.println("Estou aqui");
            }

            for (Encomenda v : s.getEncomendas().getEncomendas().values()) {
                if (v.getCodigo().equals(buffer)) {
                    v.setAceite(true);

                }

                 //System.out.println(v.getAceite());
            }

        }


    }

