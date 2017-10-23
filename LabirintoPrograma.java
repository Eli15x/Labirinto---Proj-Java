import java.io.*;

public class LabirintoPrograma{

    //public static double[][] labirinto;
	public static void main(String[] args)
  {

    	char[][] labirinto;
    	int TotalLinha = 0;  //elas estar�o contando apartir de 1...(n�o estar� na logica do vetor... onse a posicao inicial � 0 e nela � armazenada...)
    	int TotalColuna= 0;  //elas estar�o contando apartir de 1...(n�o estar� na logica do vetor... onse a posicao inicial � 0 e nela � armazenada...)

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
        	    //Coord.setLinha(TotalLinha);
        	    //Coord.setColuna(TotalColuna);

        	   //caminho.empilhe(Coord);
        	   //System.out.println("valor coord empilhe : "+caminho.toString());

           	labirinto = new char[TotalLinha][TotalColuna];  //matriz de char


          //Colocar informa��es na matriz e printar...
          	int contagemLinha = 0;

          	 while (arquivo.ready())
          	 {

	      	      String componente = arquivo.readLine(); //armazenando em uma var os valores da linha em questao do arquivo

	      	      for(int coluna = 0; coluna <= TotalColuna-1; coluna++) // ja percoreu a linha 0 e colunas
	      	         labirinto[contagemLinha][coluna] = componente.charAt(coluna); //pegando cada char da linha para colocar na posicao da matriz adequada.
          																	      //ele come�ara com a ContagemLinha q�e � o int que declarei acima, ela funciona para saber de qual linha estou tratando...
          																	     //para poder aramazenar os dados corretamente conforme o arquivo txt...

          	      for(int coluna = 0; coluna <= TotalColuna-1; coluna++)
            	  	   System.out.print(labirinto[contagemLinha][coluna] );
                       System.out.println("");
                       contagemLinha++; //agora estou indo para pr�xima linha pois todos os character da linha j� foram pegos.

		      }



         labirinto<Coordenada> proc = new labirinto<Coordenada>(labirinto,TotalLinha,TotalColuna);

        // System.out.println("VALORES : " + caminho.toString());

        if(proc.ConferirCaracteres())
        {
			int qtdPosicoes = TotalLinha * TotalColuna;
			Pilha<Coordenada> caminho = new Pilha<>(qtdPosicoes,qtdPosicoes);  // minha taixa vai ser igual a quantidade.
			Pilha<Fila<Coordenada>> possibilidades = new Pilha<>(qtdPosicoes); //possibilidades armazenara no maximo 40 filas de coordenadas


			//Coordenada Coord = new Coordenada();
			//Coord.setLinha(TotalLinha);
			//Coord.setColuna(TotalColuna);
         	//caminho.empilhe(Coord); //Ele empilhara somente a posicao atual


			Coordenada atual      = new Coordenada(proc.colunaInicial(),proc.linhaInicial()); //armazenar nessa variavel onde encontrou-se E(inicialmente)

			//atual.setLinha(proc.linhaInicial());
			//atual.setColuna(proc.colunaInicial());

			System.out.println(atual.toString());

			Fila<Coordenada> fila = new Fila<Coordenada>(3); //esta enfileira as posicoes adjacentes a atual, direita, em cima, ou em baixo
			proc.validaPosicao(atual.getLinha(),atual.getColuna());
			//labirinto<Coordenada> teste = new labirinto<>(labirinto,TotalLinha,TotalColuna);

			if(proc.posicaoValida(proc.getLinhaValida1(),proc.getColunaValida1()))
			{
				Coordenada unicornio  = new Coordenada(proc.getColunaValida1(),proc.getLinhaValida1());
				fila.enfileire(unicornio);
				System.out.println("{"+proc.getLinhaValida1()+ ", "+proc.getColunaValida1()+"}"+" � valida");
			}

			if(proc.posicaoValida(proc.getLinhaValida2(),proc.getColunaValida2()))
			{
				Coordenada unicornio2 = new Coordenada(proc.getColunaValida2(),proc.getLinhaValida2());
				fila.enfileire(unicornio2);
				System.out.println("{"+proc.getLinhaValida2()+", "+proc.getColunaValida2()+ "}"+" � valida");
			}
			if(proc.posicaoValida(proc.getLinhaValida3(),proc.getColunaValida3()))
			{
				Coordenada unicornio3 = new Coordenada(proc.getColunaValida3(),proc.getLinhaValida3());
				fila.enfileire(unicornio3);
				System.out.println("Colun3 � valida");
			}
			System.out.println(fila.toString());

			//fila.enfileire(); //enfileirar a posicoes validas
			proc.colocarPasso(atual.getLinha(),atual.getColuna());
			//atual.setColuna(2);
		    //proc.colocarPasso(atual.getLinha(),atual.getColuna());
			//proc.colocarPasso(atual.getLinha(),atual.getColuna());
			//atual.setLinha(3);
		    //proc.colocarPasso(atual.getLinha(),atual.getColuna());
			atual = fila.getFila();
			fila.desenfileire();
			//fila.enfileire(proc.coordValidas());
			caminho.empilhe(atual);

			//atual.setColuna(2);
			System.out.println(caminho.toString());

        }
	 }

	  catch (FileNotFoundException e1)
      {
	    	  	System.out.println("Nao foi possivel encontrar o caminho especificado, por favor digite o nome correto,ou certifique-se se o arquivo existe");
      }

      catch(ArrayIndexOutOfBoundsException e2)
      {
			   System.out.println("N�o foi poss�vel realizar o procedimento de leitura com sucesso.");
			   System.out.println("Confira seu Arquivo texto,ele apressenta n�mero de linhas ou colunas errado :(");
	  }

	  catch(Exception e3)
      {
			   System.out.println("Erro :"+ e3);
	  }

      /* Acabamos de ler o arquivo e colocar cada posi��o na matriz...
       Agora iremos estanciar os objetos da classe caso possuam E e S indicando o inicio do labirinto e o fim do labirinto.
       Se n�o ira abortar e ira apontar o erro...
      */
    }
}
