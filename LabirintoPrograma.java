import java.io.*;

public class LabirintoPrograma{

    //public static double[][] labirinto;
	public static void main(String[] args){

    	char[][] labirinto;
    	int TotalLinha = 0;  //elas estarão contando apartir de 1...(não estará na logica do vetor... onse a posicao inicial é 0 e nela é armazenada...)
    	int TotalColuna= 0;  //elas estarão contando apartir de 1...(não estará na logica do vetor... onse a posicao inicial é 0 e nela é armazenada...)

       // LENDO O ARQUIVO.
        try {
	   			BufferedReader teclado= new BufferedReader(
	                               		new InputStreamReader(
	                                   	System.in));

	        	System.out.print ("Caminho para o arquivo? ");
	        	String caminhoParaOArquivo=teclado.readLine();

	        	BufferedReader arquivo =new BufferedReader(
	                               		new FileReader(
	                               		caminhoParaOArquivo));


           //PEGANDO VALOR DA COLUNA E LINHA

	    for(int linha = 1; linha <= 2; linha++){

			if(linha == 1){
		    		    	String Arquivo = arquivo.readLine();
		    		        TotalLinha = Integer.parseInt(Arquivo);

		    		        System.out.println(TotalLinha);
				          }

            if(linha == 2){
		                	String Arquivo = arquivo.readLine();
		    		        TotalColuna = Integer.parseInt(Arquivo);

		    		        System.out.println(TotalColuna);
			               }

        }
        	//Coord.setLinha(TotalLinha);
        	//Coord.setColuna(TotalColuna);

        	//caminho.empilhe(Coord);
        	//System.out.println("valor coord empilhe : "+caminho.toString());

        labirinto = new char[TotalLinha][TotalColuna];


        //Colocar informações na matriz e printar...
        int ContagemLinha = 0;

        while (arquivo.ready()){

	        String componente = arquivo.readLine(); //armazenando em uma var os valores da linha em questao do arquivo

	        for(int coluna = 0; coluna <= TotalColuna-1; coluna++)
	            labirinto[ContagemLinha][coluna] = componente.charAt(coluna); //pegando cada char da linha para colocar na posicao da matriz adequada.
           //ele começara com a ContagemLinha qúe é o int que declarei acima, ela funciona para saber de qual linha estou tratando...
           //para poder aramazenar os dados corretamente conforme o arquivo txt...

            for(int coluna = 0; coluna <= TotalColuna-1; coluna++)
            	System.out.print(labirinto[ContagemLinha][coluna] );
            System.out.println("");
            ContagemLinha++; //agora estou indo para próxima linha pois todos os character da linha já foram pegos.

		 }

         int qtdPosicoes = TotalLinha * TotalColuna;
         Pilha<Coordenada> caminho = new Pilha<>(qtdPosicoes,qtdPosicoes); //minha taixa vai ser igual a quantidade.
		 Pilha<Fila<Coordenada>> possibilidade = new Pilha<>();
         labirinto procedimentos = new labirinto(labirinto,TotalLinha,TotalColuna);



         if(procedimentos.ConferirCaracteres() ){ //se encontrado E e Se encontrado S

	 		Coordenada Coord = new Coordenada();
         		Coord.setLinha(procedimentos.PosicaoInicialLinha());   //recebedo a linha inicial onde está E
         		Coord.setColuna(procedimentos.PosicaoInicialColuna()); // recebendo a coluna incial onde está S
         		caminho.empilhe(Coord); //empilhará a primeira posicao
			atual.setLinha(proc.linhaInicial());
			atual.setColuna(proc.colunaInicial());

			System.out.println(atual.toString());

			Fila<Coordenada> fila = new Fila<Coordenada>(3); //esta enfileira as posicoes adjacentes a atual, direita, em cima, ou em baixo
			proc.validaPosicao(atual.getLinha(),atual.getColuna());
			//fila.enfileire(); //enfileirar a posicoes validas
		//	atual.setColuna(2);

			proc.colocarPasso(atual.getLinha(),atual.getColuna());
			//atual.setLinha(3);
			//proc.colocarPasso(atual.getLinha(),atual.getColuna());


  
	

		}


	    }

	    catch (FileNotFoundException e1){
	    	System.out.println("Não foi possivel encontrar o caminho especificado,Porfavor digite o nome correto,ou certifique-se se o arquivo existe");
        }
        catch(ArrayIndexOutOfBoundsException e2){
			System.out.println("Não foi possível realizar o procedimento de leitura com sucesso.");
			System.out.println("Confira seu Arquivo texto,ele apressenta número de linhas ou colunas errado :(");
		}
		catch(Exception e3){
			System.out.println("Erro :"+ e3);
	    }

      /* Acabamos de ler o arquivo e colocar cada posição na matriz...
       Agora iremos estanciar os objetos da classe caso possuam E e S indicando o inicio do labirinto e o fim do labirinto.
       Se não ira abortar e ira apontar o erro...
      */








    }



}
