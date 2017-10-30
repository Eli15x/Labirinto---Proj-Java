/**
 *
 * @author @u15164 @17171  @17165
 * Cria o labirinto instanciando as vari?veis realizando as verifica??es necess?rias
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
 * Faz as verifica??es necess?rias para os caracteres do labirinto
 * Encontra E (inicio) e S (fim) no percurso
 * @return - Returna true caso encontre, lan?a excessao caso n?o
 * @throws Exception - Caso n?o encontre pede para o usu?rio verificar o arquivo escrito novamente.
 */

public boolean ConferirCaracteres() throws Exception{

	boolean AchouE = false;
	boolean AchouS = false;
	int Contador = 0;
	int aux = 2;

	while(aux != 0){

		if(Contador == this.TotalLinha-1) //se for a segunda vez.... pois de uma linha com coluna s? irei consultar a primeira linha e a ultima
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
      		 Contador = this.TotalLinha-1; 	  //ele estar? pegando a ultima linha que existe no labirinto -1 que ? a ultima linha da minha matriz
      						  //pois minha matriz inicia com 0
 }

		aux = 2;       //voltando o aux para 0
		Contador = 0;  //voltando Contador para 0 para ser usado no pr?ximo while... que ser? usado para conferir
		               //as laterais da minha matriz.
	  while(aux != 0){

		if(Contador == this.TotalColuna-1) //se for a segunda vez.... pois  s? irei consultar a primeira coluna e a ultima... que s?o
					           //minhas laterais onde posso encontrar E e S.
		aux = 0;

    		for(int linha = 0; linha <= this.TotalLinha-1; linha++){
			if((this.labirinto[linha][Contador] == 'E')||(this.labirinto[linha][Contador] == 'e')){

			this.posicaoLinhaInicial = linha;
			this.posicaoColunaInicial = Contador;
			this.linhaAtual  = this.posicaoLinhaInicial;
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
   		   Contador = this.TotalColuna-1; //ele estar? pegando a ultima Coluna que existe no labirinto -1 que ? a ultima linha da minha matriz
	        				  //pois minha matriz inicia com 0
   }
    if((AchouS)&&(AchouE))
    	return true;

    else{
	    throw new Exception ("N?o foi encontrado O caracter E ou S em seu Arquivo,porfavor certifique-se se seu arquivo est? digitado corretamente");
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
   		throw new Exception ("Erro linha inv?lida");
   	this.linha = linha;

   }

   public void setColuna(int coluna)throws Exception
   {
   	if((coluna < 0 )||(coluna >= this.TotalColuna))
   		throw new Exception ("Erro coluna inv?lida");

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
	//int linha2;
	//int coluna2;
boolean colocouPasso = false;
//adicionarPath(linha,coluna); //os valores passado como parametro que ? a posicao inicial...

System.out.println("Linha Path :"+this.pathLinha);
System.out.println("Coluna Path :"+this.pathColuna);
if(inicio()){
   System.out.println("INICIOOOO ");
	//COMO ? A PRIMEIRA VEZ NAO ? NESCESSARIO CONFERIR O PATH pois ele ainda nao existe.
	System.out.println("Valor this.Linha :" +this.linha);
	System.out.println("Valor this.Coluna :" +this.coluna);

	System.out.println("Valor Linha :" + linha);
	System.out.println("Valor Coluna :" +coluna);
	System.out.println("entrou");


if(linha == 0)//&& (coluna == 0)){
{

if(coluna < this.TotalColuna-1)
	if(conferirEValidarPosicaoDireita(linha,coluna)){//&& )
		try{

			colocarPasso();
			//adicionarPath(linha,coluna);
			colocouPasso = true;
			this.linhaAtual = this.linha;
			this.colunaAtual = this.coluna;

		}
		catch(Exception err){
			System.out.println(err);
		}
	}//else{

			//this.linha  = this.linha; //voltando para o valor normal.
			//this.coluna = this.coluna;

		//}

	if(conferirEValidarPosicaoABaixo(linha,coluna)){  //como linha ? 0 em qualquer valor para coluna ser? possivel verificar a posicao abaixo
    	if(!(colocouPasso)){
        	try{
				colocarPasso();
				//adicionarPath(linha,coluna);
				colocouPasso = true;
				this.linhaAtual = this.linha;
				this.colunaAtual = this.coluna;
				}
				catch(Exception err){
					System.out.println(err);
			    }
		}else  //se o passo foi colocado e ? valido
		{

           //AdicionarPosicaoValida(this.linha,this.coluna)

		}
	}
if(coluna == this.TotalColuna-1){
	if(conferirEValidarPosicaoEsquerda(linha,coluna))
		if(!(colocouPasso)){
		try{
			colocarPasso();
			//adicionarPath(linha,coluna);
			colocouPasso = true;
			this.linhaAtual  = this.linha;
			this.colunaAtual = this.coluna;

			}
			catch(Exception err){
				System.out.println(err);
			}
		}else  //se o passo foi colocado e ? valido
		{

           //AdicionarPosicaoValida(this.linha,this.coluna)

		}
		//else{

		//		this.linha  = this.linha; //voltando para o valor normal.
		//		this.coluna = this.coluna;

	  //  }


}
	//else{

		//this.linha  = this.linha; //voltando para o valor normal.
		//this.coluna = this.coluna;

		//}
}
else if(linha == this.TotalLinha-1)
{

//&&(coluna == this.TotalColuna-1)){

	if(coluna == this.TotalColuna-1){
		if(conferirEValidarPosicaoEsquerda(linha,coluna)){
		try{
			colocarPasso();
			//adicionarPath(linha,coluna);
			colocouPasso = true;
			this.linhaAtual = this.linha;
			this.colunaAtual = this.coluna;

	   }
	  catch(Exception err){
	  	System.out.println(err);
	   }
   }else{
		this.linha  = linha; //voltando para o valor normal. pois quanco conferirEValidarPosicoABaixo ele altera a posicao this.linha e this.coluna
    	this.coluna = coluna;
	}

   }
  if(coluna < this.TotalColuna-1){
  	if(conferirEValidarPosicaoDireita(linha,coluna)){
    	if(!(colocouPasso)){
			try{

				colocarPasso();
				//adicionarPath(linha,coluna);
				colocouPasso = true;
				this.linhaAtual  = this.linha;
				this.colunaAtual = this.coluna;

	   		}
	   		catch(Exception err){
	   			System.out.println(err);
		}

   }else  //se o passo foi colocado e E valido
		{

           //AdicionarPosicaoValida(this.linha,this.coluna)

		}
	}
	else{
			this.linha  = linha; //voltando para o valor normal. pois quanco conferirEValidarPosicoABaixo ele altera a posicao this.linha e this.coluna
    		this.coluna = coluna;
		}




  }

	if(conferirEValidarPosicaoAcima(linha,coluna)){ //todas as posicoes para coluna com linha == linha-1  nao afetaram a posicao de cima existir
       	if(!(colocouPasso)){
        	try{
				colocarPasso();
				//adicionarPath(linha,coluna);
		  	    colocouPasso = true;
	    	    this.linhaAtual = this.linha;
			    this.colunaAtual = this.coluna;

			}
			catch(Exception err){
				System.out.println(err);
			}

		}
		else  //se o passo foi colocado e E valido
		{

           //AdicionarPosicaoValida(this.linha,this.coluna)

		}


	} //FALTANDO O NORMAL CASO ESTEJA ENTRE ... QUE SER? < QUE COLUNA-1

	else{

			this.linha  = linha; //voltando para o valor normal.
			this.coluna = coluna;

		}

}   //FALTA PARA A COLUNA DE 0 E COLUNA DE -1 NORMALLLL.
else if(coluna == 0){

  // System.out.println("Coluna == 0 Lin 418");
  // System.out.println("Colocou Passo"+ colocouPasso);

	if(conferirEValidarPosicaoDireita(linha,coluna)){
    	if(!(colocouPasso)){
			try{
                System.out.println("entrou no !ColocouPasso");
				colocarPasso();
				//adicionarPath(linha,coluna);
				colocouPasso = true;
				this.linhaAtual  = this.linha;
				this.colunaAtual = this.coluna;

	   		}
	   		catch(Exception err){
	   			System.out.println(err);
		}

   }else  //se o passo foi colocado e E valido
		{

           //AdicionarPosicaoValida(this.linha,this.coluna)

		}
	}

else{
		this.linha  = linha; //voltando para o valor normal. pois quanco conferirEValidarPosicoABaixo ele altera a posicao this.linha e this.coluna
		this.coluna = coluna;
	}




	if(conferirEValidarPosicaoAcima(linha,coluna)){ //todas as posicoes para coluna com linha == linha-1  nao afetaram a posicao de cima existir
       	if(!(colocouPasso)){
        	try{
				colocarPasso();
				//adicionarPath(linha,coluna);
		  	    colocouPasso = true;
	    	    this.linhaAtual = this.linha;
			    this.colunaAtual = this.coluna;

			}
			catch(Exception err){
				System.out.println(err);
			}

		}else  //se o passo foi colocado e E valido
		{

           //AdicionarPosicaoValida(this.linha,this.coluna)

		}

}else{
		this.linha  = linha; //voltando para o valor normal. pois quanco conferirEValidarPosicoABaixo ele altera a posicao this.linha e this.coluna
    	this.coluna = coluna;
	}


if(conferirEValidarPosicaoABaixo(linha,coluna)){  //como linha ? 0 em qualquer valor para coluna ser? possivel verificar a posicao abaixo
    	if(!(colocouPasso)){
        	try{
				colocarPasso();
				//adicionarPath(linha,coluna);
				colocouPasso = true;
				this.linhaAtual = this.linha;
				this.colunaAtual = this.coluna;
				}
				catch(Exception err){
					System.out.println(err);
			    }
		}else  //se o passo foi colocado e E valido
		{

           //AdicionarPosicaoValida(this.linha,this.coluna)

		}
  }
  else{
  		this.linha  = linha; //voltando para o valor normal. pois quanco conferirEValidarPosicoABaixo ele altera a posicao this.linha e this.coluna
      	this.coluna = coluna;
  	}

 }
 else if(coluna == this.TotalColuna-1){

	if(conferirEValidarPosicaoEsquerda(linha,coluna)){
    	if(!(colocouPasso)){

			try{

				colocarPasso();
				//adicionarPath(linha,coluna);
				colocouPasso = true;
				this.linhaAtual  = this.linha;
				this.colunaAtual = this.coluna;

	   		}
	   		catch(Exception err){
	   			System.out.println(err);

     }
   }else  //se o passo foi colocado e E valido
		{

           //AdicionarPosicaoValida(this.linha,this.coluna)

		}
}else{
		this.linha  = linha; //voltando para o valor normal. pois quanco conferirEValidarPosicoABaixo ele altera a posicao this.linha e this.coluna
    	this.coluna = coluna;
	}




	if(conferirEValidarPosicaoAcima(linha,coluna)){ //todas as posicoes para coluna com linha == linha-1  nao afetaram a posicao de cima existir
       	if(!(colocouPasso)){

        	try{
				colocarPasso();
				//adicionarPath(linha,coluna);
		  	    colocouPasso = true;
	    	    this.linhaAtual = this.linha;
			    this.colunaAtual = this.coluna;
			    //adicionarPath(linha,coluna);

			}
			catch(Exception err){
				System.out.println(err);
			}


		}else  //se o passo foi colocado e E valido
		{

           //AdicionarPosicaoValida(this.linha,this.coluna)

		}

}
else{
		this.linha  = linha; //voltando para o valor normal. pois quanco conferirEValidarPosicoABaixo ele altera a posicao this.linha e this.coluna
    	this.coluna = coluna;
	}


if(conferirEValidarPosicaoABaixo(linha,coluna)){  //como linha ? 0 em qualquer valor para coluna ser? possivel verificar a posicao abaixo
    	if(!(colocouPasso)){
        	try{
				colocarPasso();
			//	adicionarPath(linha,coluna);
				colocouPasso = true;
				this.linhaAtual = this.linha;
				this.colunaAtual = this.coluna;
				//adicionarPath(linha,coluna);
				}
				catch(Exception err){
					System.out.println(err);
			    }

		}else  //se o passo foi colocado e E valido
		{

           //AdicionarPosicaoValida(this.linha,this.coluna)


	}
	}else{
		this.linha  = linha; //voltando para o valor normal. pois quanco conferirEValidarPosicoABaixo ele altera a posicao this.linha e this.coluna
    	this.coluna = coluna;
	}



}
//adicionarPath(linha,coluna);



}//if(!(inicio))/////////////////////////////////////////////

else{
	System.out.println("else do if inicio");

//if((linha >= 0)&&(coluna >= 0)&&(linha != this.TotalLinha)&&(this.TotalColuna != coluna)){

if(conferirEValidarPosicaoDireita(linha,coluna)){  //como ? a primeira vez que confiro nao preciso conferir colocouPasso pois ser? false
	if(!(posicaoAnterior())){
		//if(!(posicaoAoRedorSaida(linha,coluna))){
		try{
			colocarPasso();
			//adicionarPath(linha,coluna);
			colocouPasso = true;
			this.linhaAtual  = this.linha;
			this.colunaAtual = this.coluna;
			//adicionarPath(linha,coluna);
			//this.linha  = linha; //voltando para o valor normal. para conferir outras posicoes ao redor da posicao antiga... para valida-las
		    //this.coluna = coluna;
        }
		catch(Exception err){
			System.out.println(err);
	    }
	  //}
	}
	else{
            this.linha  = linha; //voltando para o valor normal.
			this.coluna = coluna;
			// se for o path tratar ...
		 }



    }
//}
	else{
			this.linha  = linha; //voltando para o valor normal.
			this.coluna = coluna;
    }



if(conferirEValidarPosicaoEsquerda(linha,coluna)){
	if(!(colocouPasso)){
		if(!(posicaoAnterior())){
			//if(!(posicaoAoRedorSaida(linha,coluna))){
			try{

				colocarPasso();
			    colocouPasso = true;
			   // adicionarPath(linha,coluna);
				this.linhaAtual  = this.linha;
				this.colunaAtual = this.coluna;
				//this.linha  = linha; //voltando para o valor normal. NOVO COMENT
				//this.coluna = coluna;

				}
				catch(Exception err){
					System.out.println(err);
				}
		 // }
	  }
		  else{
               this.linha  = linha; //voltando para o valor normal.
			   this.coluna = coluna;
			// se for o path tratar ...
		  }

	  }
	  else  //se o passo foi colocado e E valido
	  {
            this.linha  = linha; //voltando para o valor normal.
			this.coluna = coluna;
           //AdicionarPosicaoValida(this.linha,this.coluna)

	  }
}
//}
else{

	this.linha  = linha; //voltando para o valor normal.
    this.coluna = coluna;
 }

 System.out.println("valor da linha e coluna ates de entrar no conferirEValidarPosicaoAcima " + linha + " col: "+ coluna);
 System.out.println("valor do path :" + this.pathLinha + " col path:" + this.pathColuna);
if(conferirEValidarPosicaoAcima(linha,coluna)){
	System.out.println("conferirEValidarPosicaoAcima valores linha :"+ this.linha + " col :" + this.coluna);
	System.out.println("conferirEValidarPosicaoAcima Entrou");
	if(!(colocouPasso)){
		if(!(posicaoAnterior())){
			System.out.println("entrou em not posicaoAnterior");
			//if(!(posicaoAoRedorSaida(linha,coluna))){
			try{

				System.out.println("entrou em cima ");
				colocarPasso();
				System.out.println("Linha e Coluna antes do adicionarPath :"+linha+"   " + coluna);
				colocouPasso = true;
				this.linhaAtual  = this.linha;
				this.colunaAtual = this.coluna;
				//adicionarPath(linha,coluna);
				//System.out.println("Linha path e coluna path em posicao ACIMA " + this.pathLinha + " " + this.)
				//this.linha  = linha; //voltando para o valor normal.
				//this.coluna = coluna;

				}
				catch(Exception err){
					System.out.println(err);
				}
          //}
	  }
          else{
              this.linha  = linha; //voltando para o valor normal.
			  this.coluna = coluna;
			// se for o path tratar ...
		  }
    }
    else  //se o passo foi colocado e E valido
		{
            this.linha  = linha; //voltando para o valor normal.
			this.coluna = coluna;
           //AdicionarPosicaoValida(this.linha,this.coluna)

		}
 }
    else{

	this.linha  = linha; //voltando para o valor normal.
	this.coluna = coluna;
   }
   if(conferirEValidarPosicaoABaixo(linha,coluna)){
   	if(!(colocouPasso)){
   		if(!(posicaoAnterior())){
   			//if(!(posicaoAoRedorSaida(linha,coluna))){
   		try{
   			colocarPasso();
   			colocouPasso = true;
   	    	this.linhaAtual  = this.linha;
   	    	this.colunaAtual = this.coluna;
   	    	//adicionarPath(linha,coluna);
   	    	this.linha  = linha; //voltando para o valor normal.
   	    	this.coluna = coluna;
   		}
   		catch(Exception err){
   			System.out.println(err);
   		}
   	  // }
   	  }
   	   else{
            this.linha  = linha; //voltando para o valor normal.
			this.coluna = coluna;
   			// se for o path tratar ...
   		  }
   	}
   	else  //se o passo foi colocado e E valido
   		{
        	this.linha  = linha; //voltando para o valor normal.
			this.coluna = coluna;
              //AdicionarPosicaoValida(this.linha,this.coluna)

   		}

   		}
   //}
   else{
   		this.linha  = linha; //voltando para o valor normal. pois quanco conferirEValidarPosicoABaixo ele altera a posicao this.linha e this.coluna
       	this.coluna = coluna;
	}


    }

}

/**
 * verifica se esta no inincio
 * @return true caso esteja 
 */
public boolean inicio(){

	System.out.println("inicio");
	if((this.posicaoColunaInicial == this.colunaAtual)&&(this.posicaoLinhaInicial == this.linhaAtual))
		return true;



 return false;

}

/*public void conferirPosicoes(int linha,int coluna){

boolean colocouPasso = false;

if((linha >= 0)&&(coluna >= 0)&&(linha < this.TotalLinha)&&(this.TotalColuna < coluna)){

    if(conferirEValidarPosicaoDireita(linha,coluna))
    	if((this.linha != this.pathLinha)&&(this.coluna != this.pathColuna)){
			try{
	     		colocarPasso();
					//adicionarPath(linha,coluna);
				colocouPasso = true;
				this.linhaAtual  = this.linha;
				this.colunaAtual = this.coluna;
				this.linha  = linha; //voltando para o valor normal.
			    this.coluna = coluna;

			}
		    catch(Exception err){
				System.out.println(err);
			}


        }

	if(conferirEValidarPosicaoABaixo(linha,coluna)){
		if(!(colocouPasso))
			if((this.linha != this.pathLinha)&&(this.coluna != this.pathColuna)){
		   		try{

					colocarPasso();
					//adicionarPath(linha,coluna);
				    colocouPasso = true;
				    this.linhaAtual  = this.linha;
				    this.colunaAtual = this.coluna;
				    this.linha  = linha; //voltando para o valor normal.
			        this.coluna = coluna;

				}
				catch(Exception err){
					System.out.println(err);
				}

			}
		}
		else{

			this.linha  = linha; //voltando para o valor normal.
		    this.coluna = coluna;

		}
	if(conferirEValidarPosicaoEsquerda(linha,coluna)){
		if(!(colocouPasso))
	    	if((this.linha != this.pathLinha)&&(this.coluna != this.pathColuna)){
				try{

					colocarPasso();
					//adicionarPath(linha,coluna);
				    colocouPasso = true;
				    this.linhaAtual  = this.linha;
				    this.colunaAtual = this.coluna;
				    this.linha  = linha; //voltando para o valor normal.
			        this.coluna = coluna;
				}
				catch(Exception err){
					System.out.println(err);
				}

			}
		 }
		 else{

			this.linha  = linha; //voltando para o valor normal.
			this.coluna = coluna;

		 }
	if(conferirEValidarPosicaoAcima(linha,coluna)){
		if(!(colocouPasso))
			if((this.linha != this.pathLinha)&&(this.coluna != this.pathColuna)){
		   		try{
					colocarPasso();
					//adicionarPath(linha,coluna);
				    colocouPasso = true;
				    this.linhaAtual  = this.linha;
				    this.colunaAtual = this.coluna;
				    this.linha  = linha; //voltando para o valor normal.
			        this.coluna = coluna;
				}
				catch(Exception err){
					System.out.println(err);
				}

			}
		}
		else{

			this.linha  = linha; //voltando para o valor normal.
			this.coluna = coluna;

		}




	   }








}*/

public boolean PosicaoAtualFinal(int linha,int coluna)
{
	//if(this)





	return false;

}
/**
 * Confere caso seja valida da posicao direita
 * @param linha recebe linha para verificar
 * @param coluna recebe coluna para verificar
 * @return caso seja valida retorna true
 */
public boolean conferirEValidarPosicaoDireita(int linha,int coluna){

	if(this.TotalColuna-1 == coluna)
    	conferirEValidarPosicaoEsquerda(linha,coluna);
    else
		this.coluna = coluna+1;

		this.linha = linha;

	//System.out.println("Coluna :"+ this.coluna);
	//System.out.println("Linha: " + this.linha);

	//if((this.coluna == this.pathColuna)&& (this.linha == this.pathColuna))
			//this.coluna = coluna-1;

	try{
		if(posicaoValida())
			return true;

	}catch(Exception err){
    	System.out.println(err +" Aquiii ");
     }

	return false;
}
/**
 * Confere caso seja valida da posicao esquerda
 * @param linha recebe linha para verificar
 * @param coluna recebe coluna para verificar
 * @return caso seja valida retorna true
 */
public boolean conferirEValidarPosicaoEsquerda(int linha,int coluna){

	if(0 == this.coluna) //primeira posicao
		conferirEValidarPosicaoDireita(linha,coluna);
	else
    	this.coluna = coluna--;
    	this.linha = linha;

   try{
   		if(posicaoValida())
    		return true;
   }
   catch(Exception err){
   System.out.println(err);

	}

    return false;
}
/**
 * Confere caso seja valida da posicao de cima
 * @param linha recebe linha para verificar
 * @param coluna recebe coluna para verificar
 * @return caso seja valida retorna true
 */
public boolean conferirEValidarPosicaoAcima(int linha,int coluna){

	//if(0 == linha)
	//	conferirEValidarPosicaoABaixo(linha,coluna);
	//else
		this.linha= linha-1;

		this.coluna = coluna;

		System.out.println("conferirEValidarPosicaoAcima : Linha : "+this.linha + "  Coluna: "+ this.coluna);

	try{
   		if(posicaoValida())
    		return true;
   	}
   	catch(Exception err){
   		System.out.println(err);

   	}

return false;

}
/**
 * Confere caso seja valida da posicao de baixo
 * @param linha recebe linha para verificar
 * @param coluna recebe coluna para verificar
 * @return caso seja valida retorna true
 */
public boolean conferirEValidarPosicaoABaixo(int linha,int coluna){

	if(this.TotalLinha-1 == linha)
		conferirEValidarPosicaoAcima(linha,coluna);
	else
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




/*public void posicoes(int aux)
{
		//int inicioLinha ;//variavel para controlar um possivel erro que pode ocorrer quando tiver um labirinto em que esta a letra "E"
		//esta a 2 linhas encima do LinhaFinal.
    if(aux == 0 ){

        	if(this.TotalColuna-1 == this.coluna){

            	System.out.println("entrou no totalcoluna-1 == this.coluna");
				this.coluna--;
			    System.out.println("Valor da linha :" + this.linha + " E valor coluna " + this.coluna);

            	if((this.coluna == this.pathColuna)&&(this.linha == this.pathLinha)){

		  			aux = 1;
		  	    	this.coluna++;



            	}
		    }
			else{
         		System.out.println("nao entrou");
				this.coluna++;

				if((this.coluna == this.pathColuna)&& (this.linha == this.pathColuna)){
					aux = 1;
			    	this.coluna--;
			    	System.out.println("path entrou 0");
	            }
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

			if(this.comecoLinhaUltimaLinha) //TotalLinha-1 pois ele subtrai um em aux ==1.
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


	}*/
/**
 * Verifica caso esteja na posicao final
 * @param linha recebe linha para a verificacao
 * @param coluna recebe coluna para a verificacao
 * @return true caso esteja na posicao final
 * @throws Exception caso a posicao seja invalida, lança-se a excessao
 */
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
/**
 * Coloca * por onde passou pelo labirinto
 * @throws Exception caso o passo seja onde esta ou a linha seja invalida, lança a excessao
 */
   public void colocarPasso() throws Exception
   {
	   	if((this.linha == this.pathLinha)&& (this.coluna == this.pathColuna))
	   		throw new Exception ("posicao para colocar o passo ? igual ao path");
		if((this.linha < 0 )|| (this.linha > this.TotalLinha-1))
			throw new Exception("Linha passada nao e valida ColocarPasso()");

		if((this.coluna < 0 )|| (this.coluna > this.TotalColuna-1))
			throw new Exception("Coluna passada nao e valida ColocarPasso()");

       System.out.println("colocarPasso() entrou e passou das throws");
		this.labirinto[this.linha][this.coluna] = '*';
		System.out.println("Linha  ColocarPasso() : " + this.linha +" coluna : "+ this.coluna);


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
/**
 * Verifica se a posicao é valida
 * @return retorna true caso seja
 * @throws Exception caso nao seja valida, excessao lançada
 */
  public boolean posicaoValida() throws Exception
  {
      System.out.println("Valor posicaoValida() Coluna :" + this.coluna);
	  System.out.println("Valor posicaoValida() Linha :" + this.linha);
	  if((this.linha < 0 )||  (this.linha > this.TotalLinha-1))
	  	throw new Exception("Linha passada nao e valida");

	  if((this.coluna < 0) || (this.coluna > this.TotalColuna-1))
	  	throw new Exception("Coluna passada nao e valida");

	  boolean Evalida = false;

	  if((labirinto[this.linha][this.coluna] == '#')||(labirinto[this.linha][this.coluna] == '*'))
	  {
	    Evalida = false;
      }
	  else
	  {
	  	Evalida = true;
	  }

	 return Evalida;
  }
/**
 * Metodo para auxiliar na exibicao dos elementos
 * @return retorna ret que será a exibicao em si
 */
  public String toString(){

  String ret = "{";

  for(int i = 0 ; i <this.TotalLinha;i++)
  	for(int j = 0;j <this.TotalColuna;j++)
  		ret += this.labirinto[i][j];


  ret += "}";
  return ret;
 }
  /**
  *Printa na tela o labirinto 
  */
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