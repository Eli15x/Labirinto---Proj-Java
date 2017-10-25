/**
 *
 * @author @u15164 @17171  @17165
 * Cria o labirinto instanciando as variáveis realizando as verificações necessárias
 */
public class labirinto
{
	private char[][] labirinto;
	private char parede;
	private int  TotalLinha;
    private	int  TotalColuna;
	private char espaco;
	private char passo;
    private int  posicaoColunaInicial;
	private int  posicaoLinhaInicial;
	private int  posicaoLinhaFinal;
	private int  posicaoColunaFinal;
	private int  linha;
	private int  coluna;

	//private int linhaVali

/**
* Construtor dos atributos da classe
* @param lab    matriz que seria o labirinto em si
* @param linha  linha do labirinto
* @param coluna coluna do labirinto
 */

public labirinto(char[][] lab,int linha,int coluna){

	this.labirinto   = lab;
	this.TotalLinha  = linha;
	this.TotalColuna = coluna;
	this.espaco = ' ';
	this.parede = '#';
	this.passo  = '*';




}

/**
 * Faz as verificações necessárias para os caracteres do labirinto
 * Encontra E (inicio) e S (fim) no percurso
 * @return - Returna true caso encontre, lança excessao caso não
 * @throws Exception - Caso não encontre pede para o usuário verificar o arquivo escrito novamente.
 */

public boolean ConferirCaracteres() throws Exception{

	boolean AchouE = false;
	boolean AchouS = false;
	int Contador = 0;
	int aux = 2;

	while(aux != 0){

		if(Contador == this.TotalLinha-1) //se for a segunda vez.... pois de uma linha com coluna só irei consultar a primeira linha e a ultima
			aux = 0;

		for(int coluna = 0; coluna <= this.TotalColuna-1;coluna++){
			if((this.labirinto[Contador][coluna] == 'E')||(this.labirinto[Contador][coluna] == 'e')){

			this.posicaoLinhaInicial = Contador;
			this.posicaoColunaInicial = coluna;
			this.linha  = this.posicaoLinhaInicial;
			this.coluna = this.posicaoColunaInicial;
			AchouE = true;
		}

	    	if((this.labirinto[Contador][coluna] == 'S')||(this.labirinto[Contador][coluna] == 's')){

			this.posicaoLinhaFinal = Contador;
			this.posicaoColunaFinal = coluna;
			this.linha  = this.posicaoLinhaInicial;
			this.coluna = this.posicaoColunaInicial;
			AchouS = true;
        	}

   	 }
      		 Contador = this.TotalLinha-1; 	  //ele estará pegando a ultima linha que existe no labirinto -1 que é a ultima linha da minha matriz
      						  //pois minha matriz inicia com 0
 }

		aux = 2;       //voltando o aux para 0
		Contador = 0;  //voltando Contador para 0 para ser usado no próximo while... que será usado para conferir
		               //as laterais da minha matriz.
	  while(aux != 0){

		if(Contador == this.TotalColuna-1) //se for a segunda vez.... pois  só irei consultar a primeira coluna e a ultima... que são
					           //minhas laterais onde posso encontrar E e S.
		aux = 0;

    		for(int linha = 0; linha <= this.TotalLinha-1; linha++){
			if((this.labirinto[linha][Contador] == 'E')||(this.labirinto[linha][Contador] == 'e')){

			this.posicaoLinhaInicial = linha;
			this.posicaoColunaInicial = Contador;
			this.linha  = this.posicaoLinhaInicial;
			this.coluna = this.posicaoColunaInicial;
			AchouE = true;

	    }
		if((this.labirinto[linha][Contador] == 'S')||(this.labirinto[linha][Contador] == 's')){

			this.posicaoLinhaFinal = linha;
			this.posicaoColunaFinal = Contador;
			this.linha  = this.posicaoLinhaInicial-1;
			this.coluna = this.posicaoColunaInicial-1;
			AchouS = true;
	    }

       }
   		   Contador = this.TotalColuna-1; //ele estará pegando a ultima Coluna que existe no labirinto -1 que é a ultima linha da minha matriz
	        				  //pois minha matriz inicia com 0
   }
    if((AchouS)&&(AchouE))
    	return true;

    else{
	    throw new Exception ("Não foi encontrado O caracter E ou S em seu Arquivo,porfavor certifique-se se seu arquivo está digitado corretamente");
	}
}

    public int getLinhaInicial()  //deve retornar uma linha e uma coluna
	{
		return this.posicaoLinhaInicial;
	}

	public int getColunaInicial()
	{
		return this.posicaoColunaInicial;
	}

	public int getLinhaFinal()
	{
		//atual.linha = this.posicaoLinhaFinal;
		return this.posicaoLinhaFinal;
	}

	public int getColunaFinal()
	{
		//atual.coluna = this.posicaoColunaFinal;
		return this.posicaoColunaFinal;
	}

	public int getLinha()
	{
		return this.linha;
	}

   public int getColuna()
   {
		return this.coluna;
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

	public void posicoes(int aux)
	{
		//int inicioLinha ;//variavel para controlar um possivel erro que pode ocorrer quando tiver um labirinto em que esta a letra "E"
		//esta a 2 linhas encima do LinhaFinal.

		System.out.println("Inicio : Valor da linha :" + this.linha + " E valor coluna " + this.coluna);

    	if(aux == 0 ){

    	if(this.TotalColuna-1 == this.coluna)
    	{
			//inicioLinha = this.linha;

			System.out.println("entrou no totalcoluna-1 == this.coluna");
			this.coluna--;
			//this.linha ;// a linha nao se altera entao nao preciso conferir sua posicao...
             System.out.println("Valor da linha :" + this.linha + " E valor coluna " + this.coluna);
		}
		else{

         	System.out.println("nao entrou");
			this.coluna++;
			//this.linha;

			}
			//this.coluna = coluna;


	    }

        if(aux == 1){

			if(this.TotalLinha-1 == this.linha){
            	if(this.TotalColuna-1 == this.coluna+1)   //arrumar isso
	    			this.coluna++;
	    		else
	    			this.coluna--;

				this.linha--; //eu tinha subtraido por isso
		    }
		    else{
				if(this.TotalColuna-1 == this.coluna+1) //-1 pois sofreu alteracao no aux 0 (this.coluna = this.coluna-1;).
			    	this.coluna++;
			   else
	    			this.coluna--;

				this.linha++;

			}

	    }

        if(aux ==2){

			if(this.TotalLinha-1 == this.linha+1) //TotalLinha-1 pois ele subtrai um em aux ==1.
			{
				this.linha  = -1;
				this.coluna = -1;
				System.out.println("entrou if do aux 2");

		    }else
		    {
				System.out.println("entrou else do aux 2");
				//this.coluna = coluna-1;
				this.linha = this.linha-2;

	    	}
		}


	}

   public void colocarPasso() throws Exception
   {
	   	//int aux = 0;
		if(this.linha < 0 || this.linha > this.TotalLinha)
			throw new Exception("Linha passada nao e valida");

		if(this.coluna < 0 || this.coluna > this.TotalColuna)
			throw new Exception("Coluna passada nao e valida");

		this.labirinto[this.linha][this.coluna] = '*';


		for(int l = 0; l < this.TotalLinha; l++)
		{
			for(int c = 0; c < this.TotalColuna; c++)
			{
		      	System.out.print(this.labirinto[l][c]);
		    }

			System.out.println("");
		}



   }

 /* public int getLinhaValida1()
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
  }*/

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

  public String toString(){

  String ret = "{";

  for(int i = 0 ; i <this.TotalLinha;i++)
  	for(int j = 0;j <this.TotalColuna;j++)
  		ret += this.labirinto[i][j];


  ret += "}";
  return ret;





  }





}