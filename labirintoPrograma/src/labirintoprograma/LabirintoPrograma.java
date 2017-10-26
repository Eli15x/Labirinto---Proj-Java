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

    char[][] labirinto;
    int TotalLinha = 0;
    int TotalColuna= 0;

       // LENDO O ARQUIVO.
    try
    {
             BufferedReader teclado = new BufferedReader(
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
                    TotalLinha = Integer.parseInt(Arquivo);

                    System.out.println(TotalLinha);
                }

               if(linha == 2)
                {
                    String Arquivo = arquivo.readLine();
                    TotalColuna = Integer.parseInt(Arquivo);

                    System.out.println(TotalColuna);
                }

            }

            labirinto = new char[TotalLinha][TotalColuna];  //matriz de char


            int contagemLinha = 0;

                while (arquivo.ready())
                {

	      	      String componente = arquivo.readLine();

	      	      for(int coluna = 0; coluna <= TotalColuna-1; coluna++)
	      	         labirinto[contagemLinha][coluna] = componente.charAt(coluna);

          	      for(int coluna = 0; coluna <= TotalColuna-1; coluna++)
            	  	   System.out.print(labirinto[contagemLinha][coluna] );

                       System.out.println("");
                       contagemLinha++;
                }

	 try{

       labirinto proc = new labirinto(labirinto,TotalLinha,TotalColuna);

        proc.ConferirCaracteres();
      }
	catch(Exception erro)
	{
		System.out.println(erro);
	}



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


    }
}
