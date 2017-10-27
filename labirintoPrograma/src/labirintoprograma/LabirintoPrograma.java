package labirintoprograma;

import java.io.*;
import java.lang.*;
import labirintoprograma.labirinto.labirinto;
import labirintoprograma.labirinto.fila.*;
import labirintoprograma.labirinto.pilha.*;
import labirintoprograma.labirinto.coordenada.*;


public class LabirintoPrograma{

    //public static double[][] labirinto;
public static void main(String[] args)
  {
  
     try
     {    
        //lab = new labirinto("F:\\lala.txt");
        
        char[][] lab ; 
        lab = null;
        int totalColuna = 0;
        int totalLinha = 0;
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print ("Caminho para o arquivo? ");
        String caminhoParaOArquivo=teclado.readLine();

         BufferedReader arquivo = new BufferedReader(new FileReader(caminhoParaOArquivo));
                   

       //PEGANDO VALOR DA COLUNA E LINHA
   
    for(int linha = 1; linha <= 2; linha++)
    {

        if(linha == 1)
        {
            String Arquivo = arquivo.readLine();
            totalLinha = Integer.parseInt(Arquivo);

            System.out.println(totalLinha);
        }

        if(linha == 2)
                {
                    String Arquivo = arquivo.readLine();
                    totalColuna = Integer.parseInt(Arquivo);

                    System.out.println(totalColuna);
                }

            }

            lab = new char[totalLinha][totalColuna];  //matriz de char


            int contagemLinha = 0;

                while (arquivo.ready())
                {

	      	      String componente = arquivo.readLine();

	      	      for(int coluna = 0; coluna <= totalColuna-1; coluna++)
	      	         lab[contagemLinha][coluna] = componente.charAt(coluna);

          	      for(int coluna = 0; coluna <= totalColuna-1; coluna++)
            	  	   System.out.print(lab[contagemLinha][coluna] );

                       System.out.println("");
                       contagemLinha++;
                }
         labirinto l = new labirinto(lab,totalLinha,totalColuna);
         //Fl.ConferirCaracteres();

    
       // lab.lerDados();
        
         
     }
     catch(FileNotFoundException erro2)
     { System.out.println("Não foi achado o arquivo.");}
     
     catch(Exception erro)
     { System.out.println("Labirinto errado");}
     
  }
      
    /*char[][] labirinto;
    int totalLinha = 0;
    int totalColuna= 0;

       // LENDO O ARQUIVO.
try
{
   /* BufferedReader teclado = new BufferedReader(
                                           new InputStreamReader(
                                           System.in));

         System.out.print ("Caminho para o arquivo? ");
         String caminhoParaOArquivo=teclado.readLine();

         BufferedReader arquivo = new BufferedReader(
                                        new FileReader(
                                           caminhoParaOArquivo));

       //PEGANDO VALOR DA COLUNA E LINHA

    for(int linha = 1; linha <= 2; linha++)
    {

        if(linha == 1)
        {
            String Arquivo = arquivo.readLine();
            totalLinha = Integer.parseInt(Arquivo);

            System.out.println(totalLinha);
        }

        if(linha == 2)
                {
                    String Arquivo = arquivo.readLine();
                    totalColuna = Integer.parseInt(Arquivo);

                    System.out.println(totalColuna);
                }

            }

            labirinto = new char[totalLinha][totalColuna];  //matriz de char


            int contagemLinha = 0;

                while (arquivo.ready())
                {

	      	      String componente = arquivo.readLine();

	      	      for(int coluna = 0; coluna <= totalColuna-1; coluna++)
	      	         labirinto[contagemLinha][coluna] = componente.charAt(coluna);

          	      for(int coluna = 0; coluna <= totalColuna-1; coluna++)
            	  	   System.out.print(labirinto[contagemLinha][coluna] );

                       System.out.println("");
                       contagemLinha++;
                }

	/* try{

       labirinto proc = new labirinto(labirinto,totalLinha,totalColuna);

        proc.ConferirCaracteres();
      }
	catch(Exception erro)
	{
		System.out.println(erro);
	}
*//*


    }

    catch (FileNotFoundException e1)
    {
        System.out.println("Nao foi possivel encontrar o caminho especificado, por favor digite o nome correto,ou certifique-se se o arquivo existe");
    }

    catch(ArrayIndexOutOfBoundsException e2)
    {
        System.out.println("Nao foi possivel realizar o procedimento de leitura com sucesso.");
        System.out.println("Confira seu Arquivo texto,ele apressenta n?mero de linhas ou colunas errado :(");
    }

    catch(Exception e3)
    {
        System.out.println("Erro :"+ e3);
    }


    }*/
}
