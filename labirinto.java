public class labirinto<X>
{
	private char[][] labirinto;
	private int TotalLinha;
    private	int TotalColuna;
	private int espaco;
	private int passo;
    private int posicaoColunaInicial;
	private int posicaoLinhaInicial;
	private int posicaoLinhaFinal;
	private int posicaoColunaFinal;
	private int linhaValida;
	private int colunaValida;
	private int linhaValida2; //Variaveis que pegaram os devidos valor e que serao armazenados na Fila
	private int colunaValida2;
    private int linhaValida3;
	private int colunaValida3;


	public labirinto(char[][] lab,int linha,int coluna)
	{
		this.labirinto   = lab;
		this.TotalLinha  = linha;
		this.TotalColuna = coluna;

	}

	public boolean ConferirCaracteres() throws Exception
	{

		boolean AchouE = false;
		boolean AchouS = false;
		int Contador = 0;
		int aux = 2;

		while(aux != 0) //percorrer a primeira e a ultima linha
		{
 			if(Contador == this.TotalLinha-1) //se for a segunda vez.... pois de uma linha com coluna só irei consultar a primeira linha e a ultima
				aux = 0;

			for(int coluna = 0; coluna < this.TotalColuna;coluna++)
			{
				if((this.labirinto[Contador][coluna] == 'E')||(this.labirinto[Contador][coluna] == 'e')){

					AchouE = true;
					this.posicaoLinhaInicial  = Contador;
				  	this.posicaoColunaInicial = coluna;

				}

	    		if((this.labirinto[Contador][coluna] == 'S')||(this.labirinto[Contador][coluna] == 's')){

 					AchouS = true;
					this.posicaoLinhaFinal  = Contador;
					this.posicaoColunaFinal = coluna;


				}

    		}

    		Contador = this.TotalLinha-1;      //ele estará pegando a ultima linha que existe no labirinto -1 que é a ultima linha da minha matriz
      									      //pois minha matriz inicia com 0
 		}

		aux = 2;       //voltando o aux para 0
		Contador = 0;  //voltando Contador para 0 para ser usado no próximo while... que será usado para conferir
		          	   //as laterais da minha matriz.
 		while(aux != 0)
 		 {

			if(Contador == this.TotalColuna-1)  //se for a segunda vez.... pois  só irei consultar a primeira coluna e a ultima... que são
				aux = 0;						//minhas laterais onde posso encontrar E e S.


    		for(int linha = 0; linha < this.TotalLinha; linha++)
    		{
				if((this.labirinto[linha][Contador] == 'E')||(this.labirinto[linha][Contador] == 'e')){

					AchouE = true;
					this.posicaoLinhaInicial  = linha;
					this.posicaoColunaInicial = Contador;

				}

				if((this.labirinto[linha][Contador] == 'S')||(this.labirinto[linha][Contador] == 's')){

					AchouS = true;
					this.posicaoLinhaFinal  = linha;
					this.posicaoColunaFinal = Contador;
				}
       		}


       		Contador = this.TotalColuna-1; //ele estará pegando a ultima Coluna que existe no labirinto -1 que é a ultima linha da minha matriz
	        							       //pois minha matriz inicia com 0
  		 }

   		if((AchouS)&&(AchouE)){
		  System.out.println("Labirinto contem os devidos caracteres");
    		return true;
		}
   		else
   		 {
	   		throw new Exception ("Não foi encontrado O caracter E ou S em seu Arquivo, por favor certifique-se se seu arquivo esta digitado corretamente");
		 }

	}

	public int linhaInicial() throws Exception //deve retornar uma linha e uma coluna
	{
		return this.posicaoLinhaInicial;
	}

	public int colunaInicial() throws Exception
	{
		return this.posicaoColunaInicial;
	}

	public int linhaFinal() throws Exception
	{
		//atual.linha = this.posicaoLinhaFinal;
		return this.posicaoLinhaFinal;
	}

	public int colunaFinal()
	{
		//atual.coluna = this.posicaoColunaFinal;
		return this.posicaoColunaFinal;
	}

/*	public boolean posicaoValida()
	{
		boolean posicaoValida = false;//inicializando com false

		//Verificar cada posicao e ver o que se encontra nela
		for(int linha = 0; linha < this.TotalLinha; linha++)
		{
			for(int coluna = 0; coluna < this.TotalColuna; coluna++)
			{
				if(this.labirinto[linha][coluna] == '#')
				{
					posicaoValida = false;
				}
				if(this.labirinto[linha][coluna] == ' ')
				{
					posicaoValida = true;

				}
				if(this.labirinto[linha][coluna] == 'S')
				{
					posicaoValida = true;
				}

			}
		}

		return posicaoValida;

	}
	*/

	public boolean validaPosicao(int linha, int coluna)
	{
		boolean posicaoEValida = false; //inicializando com false
	//	int linhaValida  = 0; //questao de iniciacao
		//int colunaValida = 0;
		//int linhaValida2 = 0; //Variaveis que pegaram os devidos valor e que serao armazenados na Fila
		//int colunaValida2 = 0;
		//int linhaValida3  = 0;
		//int colunaValida3 = 0;

		linha =  linha - 1; //linha anterior a passada no parametro, mas na mesma coluna
		if(this.labirinto[linha][coluna] == '#')
		{
			posicaoEValida = false;
			System.out.println(linha+", "+coluna+" : Ha parede");
		}

		if(this.labirinto[linha][coluna] == ' ')
		{
			posicaoEValida = true;
			System.out.println(-linha+", "+coluna+" : Ha espaco");
			this.linhaValida  = linha;
			this.colunaValida = coluna;

  		}
		coluna = coluna +1;
		linha  = linha  +1; //eu tinha subtraido por isso

		if(this.labirinto[linha][coluna] == '#')
		{
			posicaoEValida = false;
			System.out.println(linha+", "+coluna+" : Ha parede");
		}

		if(this.labirinto[linha][coluna] == ' ')
		{
			posicaoEValida = true;
			System.out.println(linha+", "+coluna+" : Ha espaco");
			this.linhaValida2   = linha;
			this.colunaValida2  = coluna;
		}

		linha  = linha + 1;
		coluna = coluna - 1;

       if(this.labirinto[linha][coluna] == '#')
       {
		  //posicaoEValida = false;
			System.out.println(linha+", "+coluna+" : Ha parede");

	   }
	   if(this.labirinto[linha][coluna] == ' ')
	   {
		  // posicaoEValida = true;
		   System.out.println(linha+" , "+coluna+" : Ha espaco");
		   this.linhaValida3  = linha;
		   this.colunaValida3 = coluna;
	   }

	   return posicaoEValida;
	}

   public void colocarPasso(int linha, int coluna) throws Exception
   {
	   	int aux = 0;
		if(linha < 0 || linha > this.TotalLinha)
			throw new Exception("Linha passada nao e valida");

		if(coluna < 0 || coluna > this.TotalColuna)
			throw new Exception("Coluna passada nao e valida");

		this.labirinto[linha][coluna] = '*';


		for(int l = 0; l < this.TotalLinha; l++)
		{
			for(int c = 0; c < this.TotalColuna; c++)
			{
		       	System.out.print(this.labirinto[l][c]);
		    }

			System.out.println("");
		}



   }

  public int getLinhaValida1()
  {
	  return this.linhaValida;
  }

  public int getColunaValida1()
  {
	  return this.colunaValida;
  }

  public int getLinhaValida2()
  {
	  return this.linhaValida2;
  }

  public int getColunaValida2()
  {
  	  return this.colunaValida2;
  }

  public int getLinhaValida3()
  {
  	  return this.linhaValida3;
  }

  public int getColunaValida3()
  {
	 return this.colunaValida3;
  }

  public boolean posicaoValida(int linha, int coluna) throws Exception
  {
	  if(linha < 0 || linha > this.TotalLinha)
	  	throw new Exception("Linha invalida :(");

	  if(coluna < 0 || coluna > this.TotalColuna)
	  	throw new Exception("Coluna invalida :(");

	  boolean Evalida = false;

	  if(labirinto[linha][coluna] == '#')
	  {
	    Evalida = false;
      }
	  else
	  {
	  	Evalida = true;
	  }

	 return Evalida;
  }


/*  public int posicaoAtual( ) throws Exception
  {

  }
*/
}