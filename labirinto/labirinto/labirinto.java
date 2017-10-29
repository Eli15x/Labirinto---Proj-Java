 package labirinto;

/* import fila.*;
 import pilha.*;
 import coordenada.*;*/

public class labirinto implements Cloneable
{
	protected char[][] labirinto;
	protected int TotalLinha;
    protected int TotalColuna;
    protected int posicaoColunaInicial;
	protected int posicaoLinhaInicial;
	protected int posicaoLinhaFinal;
	protected int posicaoColunaFinal;
	protected int linhaValida;
	protected int colunaValida;
	protected int linhaValida2; //Variaveis que pegaram os devidos valor e que serao armazenados na Fila
	protected int colunaValida2;
    protected int linhaValida3;
	protected int colunaValida3;


	public labirinto(char[][] lab,int linha,int coluna)
	{
		this.labirinto   = lab;
		this.TotalLinha  = linha;
		this.TotalColuna = coluna;

/*		try
		{
			this.atual = new Coordenada(0,0);
	    }
	    catch(Exception erro)
	    {}*/

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


public boolean eSaida(int linha, int coluna)
{
	if(this.labirinto[linha][coluna] == 'S')
		return true;
	else
		return false;

}

	public int linhaInicial()
	{
		return this.posicaoLinhaInicial;
	}

	public int colunaInicial()
	{
		return this.posicaoColunaInicial;
	}

	public int linhaFinal()
	{
		return this.posicaoLinhaFinal;
	}

	public int colunaFinal()
	{
		return this.posicaoColunaFinal;
	}

	public void validaPosicao(int linha, int coluna)
	{
		boolean posicaoEValida = false; //inicializando com false

		linha =  linha - 1; //linha anterior a passada no parametro, mas na mesma coluna
		if(this.labirinto[linha][coluna] == '#')
		{
			System.out.println(linha+", "+coluna+" : Ha parede");
		}

		if(this.labirinto[linha][coluna] != '#')
		{
			System.out.println(linha+", "+coluna+" : Ha espaco ou asterisco");
			this.linhaValida = linha;
			this.colunaValida = coluna;

  		}

		coluna = coluna +1;
		linha  = linha  +1; //eu tinha subtraido por isso

		if(this.labirinto[linha][coluna] == '#')
		{
			System.out.println(linha+", "+coluna+" : Ha parede");
		}

		if(this.labirinto[linha][coluna] != '#')
		{
			System.out.println(linha+", "+coluna+" : Ha espaco ou asterisco");
			this.linhaValida2   = linha;
			this.colunaValida2  = coluna;
		}

		linha  = linha + 1;
		coluna = coluna - 1;

       if(this.labirinto[linha][coluna] == '#')
       {
			System.out.println(linha+", "+coluna+" : Ha parede");

	   }
	   if(this.labirinto[linha][coluna] != '#')
	   {
		   System.out.println(linha+" , "+coluna+" : Ha espaco");
		   this.linhaValida3  = linha;
		   this.colunaValida3 = coluna;
	   }

	   //return posicaoEValida;
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

 /* public boolean eSaida(Coordenada c)
  {
		if(labirinto[c.getLinha()][c.getColuna()] == 'S')
			return true;
		else
			return false;

  }*/
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

  	public boolean equals(Object obj)
  	{
  		if(this == obj)
        		return true;

      	if(obj == null)
         		 return false;

      	if(!(obj instanceof labirinto))
        		return false;

     //	labirinto dep =(labirinto) obj;

     	//	if(this.TotalLinha != dep.total)
        	//	return false;

//      	if(this.Totalcoluna != dep.coluna)
        	//	return false;

     		return true;
  	}
public void retirarPasso(int linha, int coluna) throws Exception
{
	//Depois de dr throw...
	this.labirinto[linha][coluna] = ' ';


	for(int l = 0; l < this.TotalLinha; l++)
	{
		for(int c = 0; c < this.TotalColuna; c++)
		{
			System.out.print(this.labirinto[l][c]);
		}

		System.out.println("");
	}

}
}