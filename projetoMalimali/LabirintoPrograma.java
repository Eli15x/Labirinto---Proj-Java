package projetoMalimali;
import java.io.*;
import coordenada.*;


public class LabirintoPrograma{

    //public static double[][] labirinto;
	public static void main(String[] args)
  {

    	char[][] labirinto;
    	int TotalLinha = 0;  //elas estarão contando apartir de 1...(não estará na logica do vetor... onse a posicao inicial é 0 e nela é armazenada...)
    	int TotalColuna= 0;  //elas estarão contando apartir de 1...(não estará na logica do vetor... onse a posicao inicial é 0 e nela é armazenada...)

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

          //Colocar informações na matriz e printar...
          	int contagemLinha = 0;

          	 while (arquivo.ready())
          	 {

	      	      String componente = arquivo.readLine(); //armazenando em uma var os valores da linha em questao do arquivo

	      	      for(int coluna = 0; coluna <= TotalColuna-1; coluna++)
	      	         labirinto[contagemLinha][coluna] = componente.charAt(coluna);

          	      for(int coluna = 0; coluna <= TotalColuna-1; coluna++)
            	  	   System.out.print(labirinto[contagemLinha][coluna] );
                       System.out.println("");
                       contagemLinha++;
		      }

         labirinto proc = new labirinto(labirinto,TotalLinha,TotalColuna);

        // System.out.println("VALORES : " + caminho.toString());

        if(proc.ConferirCaracteres())
        {
			int qtdPosicoes = TotalLinha * TotalColuna;
			Pilha<Coordenada> caminho = new Pilha<>(qtdPosicoes,qtdPosicoes);  // minha taixa vai ser igual a quantidade.
			Pilha<Fila<Coordenada>> possibilidades = new Pilha<>(qtdPosicoes); //possibilidades armazenara no maximo 40 filas de coordenadas

			Coordenada atual   = new Coordenada(proc.colunaInicial(),proc.linhaInicial()); //armazenar nessa variavel onde encontrou-se E(inicialmente)

			System.out.println(atual.toString());

			while(atual.co)

			Fila<Coordenada> fila = new Fila<Coordenada>(3); //esta enfileira as posicoes adjacentes a atual, direita, em cima, ou em baixo
			proc.validaPosicao(atual.getLinha(),atual.getColuna());
			//labirinto<Coordenada> teste = new labirinto<>(labirinto,TotalLinha,TotalColuna);

			if(proc.posicaoValida(proc.getLinhaValida1(),proc.getColunaValida1()))
			{
				Coordenada  unicornio  = new Coordenada(proc.getColunaValida1(),proc.getLinhaValida1());
				fila.enfileire(unicornio);
				System.out.println("{"+proc.getLinhaValida1()+ ", "+proc.getColunaValida1()+"}"+" e valida");
			}

			if(proc.posicaoValida(proc.getLinhaValida2(),proc.getColunaValida2()))
			{
				Coordenada unicornio2 = new Coordenada(proc.getColunaValida2(),proc.getLinhaValida2());
				fila.enfileire(unicornio2);
				System.out.println("{"+proc.getLinhaValida2()+", "+proc.getColunaValida2()+ "}"+" e valida");
			}
			if(proc.posicaoValida(proc.getLinhaValida3(),proc.getColunaValida3()))
			{
				Coordenada unicornio3 = new Coordenada(proc.getColunaValida3(),proc.getLinhaValida3());
				fila.enfileire(unicornio3);
			}

			System.out.println(fila.toString());


			proc.colocarPasso(atual.getLinha(),atual.getColuna());
		    proc.colocarPasso(atual.getLinha(),atual.getColuna());
			atual = fila.getFila();
			fila.desenfileire();
			possibilidades.empilhe(fila);


			caminho.empilhe(atual);

			System.out.println(caminho.toString());
        }
	 }

	  catch (FileNotFoundException e1)
      {
	    	  	System.out.println("Nao foi possivel encontrar o caminho especificado, por favor digite o nome correto,ou certifique-se se o arquivo existe");
      }

      catch(ArrayIndexOutOfBoundsException e2)
      {
			   System.out.println("Não foi possível realizar o procedimento de leitura com sucesso.");
			   System.out.println("Confira seu Arquivo texto,ele apressenta número de linhas ou colunas errado :(");
	  }

	  catch(Exception e3)
      {
			   System.out.println("Erro :"+ e3);
	  }

      /* Acabamos de ler o arquivo e colocar cada posição na matriz...
       Agora iremos estanciar os objetos da classe caso possuam E e S indicando o inicio do labirinto e o fim do labirinto.
       Se não ira abortar e ira apontar o erro...
      */
    }
}
