//package labirinto;

import java.io.*;
import java.lang.*;
import classes.fila.*;
import classes.pilha.*;
import classes.coordenada.*;
import classes.*;


public class Main{


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

         Labirinto l = new Labirinto(lab,totalLinha,totalColuna);
		 l.resolverLab();
	}

	 catch(FileNotFoundException erro2)
     { System.out.println("Nao foi encontrado o arquivo.");}

     catch(Exception erro)
     { System.out.println("Labirinto errado");}

}
}
