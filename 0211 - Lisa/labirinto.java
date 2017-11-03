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
	private int  linhaAtual;
	private int  colunaAtual;
	private int  pathLinha;
	private int  pathColuna;
	private boolean  comecoLinhaUltimaLinha;


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
	this.comecoLinhaUltimaLinha = false;



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
			this.linhaAtual  = this.posicaoLinhaInicial;
			this.colunaAtual = this.posicaoColunaInicial;

			AchouE = true;
		}

	    	if((this.labirinto[Contador][coluna] == 'S')||(this.labirinto[Contador][coluna] == 's')){

			this.posicaoLinhaFinal = Contador;
			System.out.println("VALOR DA POSICAOLINHAFINAL : " + this.posicaoLinhaFinal);
			this.posicaoColunaFinal = coluna;
			System.out.println("VALOR DA POSICAOCOLUNAFINAL : " + this.posicaoColunaFinal);
			//this.linha  = this.posicaoLinhaInicial;
			//this.coluna = this.posicaoColunaInicial;
			AchouS = true;

			if(this.posicaoLinhaInicial == this.TotalLinha -1)
			  this.comecoLinhaUltimaLinha = true;
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
			this.linhaAtual  = this.posicaoLinhaInicial;
			System.out.println("posicaoLinhaInicial  : (linhaAtual recebe..)" + this.posicaoLinhaInicial);
			System.out.println("posicaoColunaInicial  : (COLUNAAtual recebe..)" + this.posicaoColunaInicial);
			System.out.println("LinhaAtual  pos posicaoLinhaInicial "+ this.linhaAtual);
			System.out.println("LinhaAtual  pos posicaoLinhaInicial "+ this.colunaAtual);
			this.colunaAtual = this.posicaoColunaInicial;
			AchouE = true;

	    }
		if((this.labirinto[linha][Contador] == 'S')||(this.labirinto[linha][Contador] == 's')){

			this.posicaoLinhaFinal = linha;
			this.posicaoColunaFinal = Contador;
			this.linhaAtual  = this.posicaoLinhaInicial-1;
			this.colunaAtual = this.posicaoColunaInicial-1;
			AchouS = true;

			if(this.posicaoLinhaInicial == this.TotalLinha -1)
			  this.comecoLinhaUltimaLinha = true;
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

	public int getLinhaAtual()
	{
		return this.linhaAtual;
	}

   public int getColunaAtual()
   {
		return this.colunaAtual;
   }

   public int getLinha()
   {
   		return this.linha;
   }

   public int getColuna()
   {
   		return this.coluna;
   }

   public void setLinha(int linha) throws Exception
   {
   	if((linha < 0 )||(linha >= this.TotalLinha))
   		throw new Exception ("Erro linha inválida");
   	this.linha = linha;

   }

   public void setColuna(int coluna)throws Exception
   {
   	if((coluna < 0 )||(coluna >= this.TotalColuna))
   		throw new Exception ("Erro coluna inválida");

   	this.coluna = coluna;

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

public void adicionarPath(int linha,int coluna){

	this.pathLinha  = linha;
	this.pathColuna = coluna;

}

public boolean posicaoAnterior(){

	if((this.linha == this.pathLinha)&& (this.coluna == this.pathColuna))
		return true;


	return false;
}

public boolean posicaoAoRedorSaida(int linha,int coluna){

	System.out.println("posicaoAoRedorSaida : linAtual :" + this.linhaAtual + " Col : " + this.colunaAtual );

if(conferirEValidarPosicaoDireita(linha,coluna))
	try{
		//System.out.println("posicao ao redor saida conferindo... :  Lin : " + this.linha " Col :"+  this.coluna);
	 if(ePosicaoFinal(this.linha,this.coluna))
	 	return true;
	// else{
	      this.linha  = this.pathLinha; //voltando para o valor normal.
	      this.coluna = this.pathColuna;
    // }
	 }catch(Exception err){
	 	System.out.println(err);
	 }




if(conferirEValidarPosicaoEsquerda(linha,coluna))
	try{
	//System.out.println("posicao ao redor saida conferindo... :  Lin : " + this.linha " Col :"+  this.coluna);

	if(ePosicaoFinal(this.linha,this.coluna))
		return true;
	else{
 	     this.linha  = this.pathLinha; //voltando para o valor normal.
	     this.coluna = this.pathColuna;
     }
	 }catch(Exception err){
	 	System.out.println(err);
 }





if(conferirEValidarPosicaoABaixo(linha,coluna))
	try{
	  // System.out.println("posicao ao redor saida conferindo... :  Lin : " + this.linha " Col :"+  this.coluna);

		if(ePosicaoFinal(this.linha,this.coluna))
			return true;
		else{
		  this.linha  = this.pathLinha; //voltando para o valor normal.
	      this.coluna = this.pathColuna;
        }
		 }catch(Exception err){
		 	System.out.println(err);
	 }

if(conferirEValidarPosicaoAcima(linha,coluna))
	    try{
		//System.out.println("posicao ao redor saida conferindo... :  Lin : " + this.linha " Col :"+  this.coluna);
	 	if(ePosicaoFinal(this.linha,this.coluna))
	 		return true;
	 	else{
		 	this.linha  = this.pathLinha; //voltando para o valor normal.
	      this.coluna = this.pathColuna;
        }
	 	 }catch(Exception err){
	 	 	System.out.println(err);
	 }





  return false;
}


public void conferirPosicoes(int linha,int coluna)
{

boolean colocouPasso = false;

System.out.println("else do if inicio");

if(conferirEValidarPosicaoDireita(linha,coluna)){  //como é a primeira vez que confiro nao preciso conferir colocouPasso pois será false
	//if(!(posicaoAoRedorSaida(linha,coluna))){
		try{
            System.out.println("Entrou no ConferirEValidarPosicaoDireita com linha : " + linha+ " e coluna "+ coluna);
            System.out.println("ConferirEValidarPOsicaoDireita this.linha "+ this.linha+ " this.coluna "+ this.coluna);
		    colocarPasso();
			colocouPasso = true;
			System.out.println("valor do linha e coluna pos alteracao em ConferirEValidarPOsicaoDireita linha"+ this.linha + " coluna : "+ this.coluna );
			this.linha  = linha; //voltando para o valor normal.
   	    	this.coluna = coluna;

        }
		catch(Exception err){
			System.out.println(err);
	    }

    }

	else{
			this.linha  = linha; //voltando para o valor normal.
			this.coluna = coluna;
    }

  if(conferirEValidarPosicaoAcima(linha,coluna)){
  	if(!(colocouPasso)){
 		try{
			colocarPasso();
  		    colocouPasso = true;
   		    this.linha  = linha; //voltando para o valor normal.
     	    this.coluna = coluna;

  			}
  			catch(Exception err){
  				System.out.println(err);
  			}
    } // se for valido mas já foi colocado o passo.
    else {
          //AdicionarPosicaoValida(this.linha,this.coluna);
          this.linha  = linha; //voltando para o valor normal.
  		  this.coluna = coluna;

  		}
   }
      else{

  	this.linha  = linha; //voltando para o valor normal.
  	this.coluna = coluna;
     }


  if(conferirEValidarPosicaoABaixo(linha,coluna)){
    	if(!(colocouPasso)){
    		//if(!(posicaoAnterior())){
    			//if(!(posicaoAoRedorSaida(linha,coluna))){
    		try{
 			System.out.println("Entrou no ConferirEValidarPosicaoAbaixo com linha : " + linha +" e coluna "+ coluna);
    			colocarPasso();
    			colocouPasso = true;
    			System.out.println("ConferirEValidarPOsicaoAbaixo this.linha "+ this.linha+ " this.coluna "+ this.coluna);
    	    	//adicionarPath(linha,coluna);
    	    	this.linha  = linha; //voltando para o valor normal.
    	    	this.coluna = coluna;
    	    	System.out.println("valor do linha e coluna pos alteracao em ConferirEValidarPOsicaoAbaixo linha"+ this.linha + " coluna : "+ this.coluna );
    		}
    		catch(Exception err){
    			System.out.println(err);
    		}
    	  // }


    	}
    	else  //se o passo foi colocado e E valido
    		{
         		this.linha  = linha; //voltando para o valor normal.
 				this.coluna = coluna;


    		}

    		}
    //}
    else{
    		this.linha  = linha; //voltando para o valor normal. pois quanco conferirEValidarPosicoABaixo ele altera a posicao this.linha e this.coluna
        	this.coluna = coluna;
	}
	if(conferirEValidarPosicaoEsquerda(linha,coluna)){
		System.out.println("entrou em conferirEValidarPosicaoEsquerda");
		if(!(colocouPasso)){
				//if(!(posicaoAoRedorSaida(linha,coluna))){
				try{
					System.out.println("dentro colocouPassoConferirEsquerda");
					System.out.println("Entrou no ConferirEValidarPosicaoEsquerda com linha : " + linha +" e coluna "+ coluna);
					System.out.println("entrou em conferirEValidarPosicaoEsquerda ------------");
					colocarPasso();
				    colocouPasso = true;
				    System.out.println("ConferirEValidarPOsicaoEsquerda this.linha "+ this.linha+ " this.coluna "+ this.coluna);
				    this.linha  = linha; //voltando para o valor normal.
	   	    	    this.coluna = coluna;
	   	    	    System.out.println("valor do linha e coluna pos alteracao em ConferirEValidarPOsicaoEsquerda linha"+ this.linha + " coluna : "+ this.coluna );
				  	}
					catch(Exception err){
						System.out.println(err);
					}
			 // }

		  }
		  else  //se o passo foi colocado e E valido
		  {
	            this.linha  = linha; //voltando para o valor normal.
				this.coluna = coluna;


		  }
	}
	//}
	else{

		this.linha  = linha; //voltando para o valor normal.
	    this.coluna = coluna;
 }





    //}

}


public boolean inicio(){

	System.out.println("inicio");
	if((this.posicaoColunaInicial == this.colunaAtual)&&(this.posicaoLinhaInicial == this.linhaAtual))
		return true;



 return false;

}


public boolean PosicaoAtualFinal(int linha,int coluna)
{
	//if(this)





	return false;

}



public void ConferirNovo(){

 int linha = this.linhaAtual;
 int coluna = this.colunaAtual;

 	for(int vez = 0 ; vez <= 3 ; vez++){

		if(vez == 0 ){
			linha++;
			posicaoValida();
	  }
}


}

public boolean conferirEValidarPosicaoDireita(int linha,int coluna){

this.coluna = coluna+1;
this.linha = linha;

try{
	if(posicaoValida())
		return true;

	}
	catch(Exception err){
    	System.out.println(err +" Aquiii ");
     }

return false;
}

public boolean conferirEValidarPosicaoEsquerda(int linha,int coluna){

	this.linha = linha;
	this.coluna = coluna-1;

	try{
   		if(posicaoValida())
    		return true;
   	}
   	catch(Exception err){
   		System.out.println(err);

   	}

return false;
}

public boolean conferirEValidarPosicaoAcima(int linha,int coluna){


	this.linha = linha-1;
	this.coluna = coluna;

	try{
   		if(posicaoValida())
    		return true;
   	}
   	catch(Exception err){
   		System.out.println(err);

   	}

return false;

}
public boolean conferirEValidarPosicaoABaixo(int linha,int coluna){

this.linha = linha+1;
this.coluna = coluna;

	try{
   		if(posicaoValida())
    		return true;
   	}
   	catch(Exception err){
   		System.out.println(err);

   	}

return false;

}


   public boolean ePosicaoFinal(int linha, int coluna)throws Exception
   {
      if((linha <0 )||(linha >this.TotalLinha-1))
      	throw new Exception("linha em ePosicaoFinal invalida");
      if((coluna <0 )||(coluna >this.TotalColuna-1))
      	throw new Exception("linha em ePosicaoFinal invalida");

      if((linha == this.TotalLinha-1) && (coluna == this.TotalColuna))
      	return true;

    return false;

   }

   public void colocarPasso() throws Exception
   {
	   System.out.println("entou ColocarPasso()");
	   	if((this.linha == this.pathLinha)&& (this.coluna == this.pathColuna))
	   		throw new Exception ("posicao para colocar o passo é igual ao path");
		if((this.linha < 0 )|| (this.linha > this.TotalLinha-1))
			throw new Exception("Linha passada nao e valida ColocarPasso()");

		if((this.coluna < 0 )|| (this.coluna > this.TotalColuna-1))
			throw new Exception("Coluna passada nao e valida ColocarPasso()");


		this.labirinto[this.linha][this.coluna] = '*';

        System.out.println("Valores Em ColcocarPasso() this.Linha : "+ this.linha);
        System.out.println("Valores Em ColcocarPasso() this.Linha : "+ this.coluna);
		this.linhaAtual  = this.linha;
		this.colunaAtual = this.coluna;


		for(int l = 0; l < this.TotalLinha; l++)
		{
			for(int c = 0; c < this.TotalColuna; c++)
			{
		      	System.out.print(this.labirinto[l][c]);
		    }

			System.out.println("");
		}



   }


  public boolean posicaoValida() //throws Exception
  {
      System.out.println("Valor posicaoValida() Coluna :" + this.coluna);
	  System.out.println("Valor posicaoValida() Linha :" + this.linha);
	  if((this.linha < 0 )||  (this.linha > this.TotalLinha-1))
	  	return false;
	  	//throw new Exception("Linha passada nao e valida");

	  if((this.coluna < 0) || (this.coluna > this.TotalColuna-1))
	  	return false;
	  //	throw new Exception("Coluna passada nao e valida");

	  boolean Evalida = false;

     // if(labirinto[this.linha][this.coluna] == null)
      //	return false;
      if((this.linha == this.posicaoLinhaInicial) && (this.coluna == this.posicaoColunaInicial))
      	return false;

	  if((labirinto[this.linha][this.coluna] == '#')||(labirinto[this.linha][this.coluna] == '*'))
	  {
	    Evalida = false;
      }
	  else
	  {
	  	Evalida = true;
	  }

     System.out.println(Evalida);
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
 public void Ver()
  {

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
