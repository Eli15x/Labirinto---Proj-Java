
import java.io.*;
import labirinto.*;
import coordenada.*;
import pilha.*;
import fila.*;

public class LabirintoPrograma{

public static void main(String[] args)
{

	char[][] labirinto;
	int TotalLinha = 0;  //elas estarão contando apartir de 1...(não estará na logica do vetor... onse a posicao inicial é 0 e nela é armazenada...)
	int TotalColuna= 0;  //elas estarão contando apartir de 1...(não estará na logica do vetor... onse a posicao inicial é 0 e nela é armazenada...)
	Fila<Coordenada> f = null;
	Coordenada c1;
	Coordenada c2;
	Coordenada c3;

     // LENDO O ARQUIVO.
  try
	{
	 BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	  System.out.print ("Caminho para o arquivo? ");
	  String caminhoParaOArquivo=teclado.readLine();

	  BufferedReader arquivo = new BufferedReader(new FileReader(caminhoParaOArquivo));
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
		labirinto = new char[TotalLinha][TotalColuna];  //matriz de char

	  	//Colocar informações na matriz e printar...
		int contagemLinha = 0;

	 while (arquivo.ready()){

		  String componente = arquivo.readLine(); //armazenando em uma var os valores da linha em questao do arquivo

		  for(int coluna = 0; coluna <= TotalColuna-1; coluna++)
			 labirinto[contagemLinha][coluna] = componente.charAt(coluna);

		  for(int coluna = 0; coluna <= TotalColuna-1; coluna++)
			   System.out.print(labirinto[contagemLinha][coluna] );
			   System.out.println("");
			   contagemLinha++;
		  }

	 labirinto proc = new labirinto(labirinto,TotalLinha, TotalColuna);

	if(proc.ConferirCaracteres())
	{
		int qtdPosicoes = TotalLinha * TotalColuna;
		Pilha<Coordenada> caminho = new Pilha<Coordenada>(qtdPosicoes,qtdPosicoes);  // minha taixa vai ser igual a quantidade.
		Pilha<Fila<Coordenada>> possibilidades = new Pilha<>(qtdPosicoes); //possibilidades armazenara no maximo 40 filas de coordenadas
		Coordenada atual = new Coordenada(proc.colunaInicial(),proc.linhaInicial());

		//Comecando o loop
		proc.colocarPasso(atual.getLinha(),atual.getColuna());
		f = new Fila<Coordenada>(3);
		String situacao = "Progressiva"; //comecando no modo progressivo

	while(!(proc.eSaida(atual.getLinha(),atual.getColuna())))
	{
		//Verificar as posicoes validas para enfileirar na fila
		if(situacao=="Progressiva")
		{
			proc.colocarPasso(atual.getLinha(),atual.getColuna());
			f = new Fila<Coordenada>(3);
			proc.validaPosicao(atual.getLinha(),atual.getColuna());

			if(proc.posicaoValida(proc.getLinhaValida1(),proc.getColunaValida1()))
			{
				c1  = new Coordenada(proc.getColunaValida1(),proc.getLinhaValida1());
				f.enfileire(c1);
				System.out.println("{"+proc.getLinhaValida1()+ ", "+proc.getColunaValida1()+"}"+" e valida");
			}
			if(proc.posicaoValida(proc.getLinhaValida2(),proc.getColunaValida2()))
			{
				c2 = new Coordenada(proc.getColunaValida2(),proc.getLinhaValida2());
				f.enfileire(c2);
				System.out.println("{"+proc.getLinhaValida2()+", "+proc.getColunaValida2()+ "}"+" e valida");
			}

			if(proc.posicaoValida(proc.getLinhaValida3(),proc.getColunaValida3()))
			{
				c3 = new Coordenada(proc.getColunaValida3(),proc.getLinhaValida3());
				f.enfileire(c3);
			}
			System.out.println(f.toString());
		}

		if(f.vazia()){
			situacao = "Regressiva";
		}

		while(situacao == "Progressiva"){

		    atual = f.getFila();
		    f.desenfileire();
			proc.colocarPasso(atual.getLinha(),atual.getColuna());
			caminho.empilhe(atual);
			System.out.println("Progressiva");
			possibilidades.empilhe(f);

			f = new Fila<Coordenada>(3);

			proc.validaPosicao(atual.getLinha(),atual.getColuna());

			if(proc.posicaoValida(proc.getLinhaValida1(),proc.getColunaValida1()))
			{
				c1  = new Coordenada(proc.getColunaValida1(),proc.getLinhaValida1());
				f.enfileire(c1);
				System.out.println("{"+proc.getLinhaValida1()+ ", "+proc.getColunaValida1()+"}"+" e valida");
			}
			if(proc.posicaoValida(proc.getLinhaValida2(),proc.getColunaValida2()))
			{
				c2 = new Coordenada(proc.getColunaValida2(),proc.getLinhaValida2());
				f.enfileire(c2);
				System.out.println("{"+proc.getLinhaValida2()+", "+proc.getColunaValida2()+ "}"+" e valida");
			}

			if(proc.posicaoValida(proc.getLinhaValida3(),proc.getColunaValida3()))
			{
				c3 = new Coordenada(proc.getColunaValida3(),proc.getLinhaValida3());
				f.enfileire(c3);
			}
		//}
			if(f.vazia()) //Quer dizer que nao ha nenhuma posicao valida
				situacao = "Regressiva";
		}

				while(situacao == "Regressiva")
				{
					atual = caminho.getTopo();
					System.out.println("Regressiva");
					caminho.desempilhe();
					proc.retirarPasso(atual.getLinha(),atual.getColuna());
					f = possibilidades.getTopo();
					possibilidades.desempilhe();

					if(!(f.vazia()))
						situacao = "Progressiva";
		}

	}
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
