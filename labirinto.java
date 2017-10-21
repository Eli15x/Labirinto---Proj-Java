public class labirinto
{
	char[][] labirinto;

        int TotalLinha;
	int TotalColuna;
	char parede;
	char espaco;
	char passo;
	int posicaoInicialLinha;
	int posicaoInicialColuna;
	int posicaoFinalLinha;
	int posicaoFinalColuna;

public labirinto(char[][] lab,int linha,int coluna){

	this.labirinto   = lab;
	this.TotalLinha  = linha;
	this.TotalColuna = coluna;
	this.espaco = ' ';
	this.parede = '#';
	this.passo = '*';


}

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

			this.posicaoInicialLinha = Contador;
			this.posicaoInicialColuna = coluna;
			AchouE = true;
		}

	    	if((this.labirinto[Contador][coluna] == 'S')||(this.labirinto[Contador][coluna] == 's')){

			this.posicaoFinalLinha = Contador;
			this.posicaoFinalColuna = coluna;
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

			this.posicaoInicialLinha = linha;
			this.posicaoInicialColuna = Contador;
			AchouE = true;

	    }
		if((this.labirinto[linha][Contador] == 'S')||(this.labirinto[linha][Contador] == 's')){

			this.posicaoFinalLinha = linha;
			this.posicaoFinalColuna = Contador;
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

 public int PosicaoInicialLinha(){
 	return this.posicaoInicialLinha;
}

 public int PosicaoInicialColuna(){
 	return this.posicaoInicialColuna;
}

public int PosicaoFinalColuna(){

    return this.posicaoFinalColuna;
}

public int PosicaoFinalLinha(){

	return this.posicaoFinalLinha;
}
public boolean validaPosicao(int linha, int coluna)
{
	boolean posicaoEValida = false; //inicializando com false
	//int linhaValida  = 0; //questao de iniciacao
	//int colunaValida = 0;
	//int linhaValida2 = 0; //Variaveis que pegaram os devidos valor e que serao armazenados na Fila
	//int colunaValida2 = 0;
	//int linhaValida3  = 0;
	//int colunaValida3 = 0;

	linha =  linha - 1; //linha anterior a passada no parametro, mas na mesma coluna
	if(this.labirinto[linha][coluna] == '#')
	{
		posicaoEValida = false;
		System.out.println(linha+", "+coluna+": Ha parede");
	}

	if(this.labirinto[linha][coluna] == ' ')
	{
		posicaoEValida = true;
		System.out.println(-linha+", "+coluna+" : Ha espaco");
		//linhaValida  = linha-1;
		//colunaValida = coluna;

  	}
	coluna = coluna +1; //teremos a mesma linha da atual, mas levando em conta que a coluna e a seguinte
	linha  = linha  +1; //eu tinha subtraido agora retornando a valor da linha do parametro

	if(this.labirinto[linha][coluna] == '#')
	{
		posicaoEValida = false;
		System.out.println(linha+" , "+coluna+": Ha parede");
	}

	if(this.labirinto[linha][coluna] == ' ')
	{
		posicaoEValida = true;
		System.out.println(linha+" , "+coluna+" : Ha espaco");
		//linhaValida2   = linha;
		//colunaValida2  = coluna+1;
	}

	linha  = linha + 1;  //linha sucessora da armazena em atual
	coluna = coluna - 1; //e na coluna anterior a passada como parametro, esgotando assim as possibilades
       if(this.labirinto[linha][coluna] == '#')
       {
		posicaoEValida = false;
		System.out.println(linha+", "+coluna+" : Ha parede");
       }
       if(this.labirinto[linha][coluna] == ' ')
       {
		
		posicaEValida = true;
		System.out.println(linha+" , "+coluna+" : Ha espaco");
	        //linhaValida3  = linha+1;
 	        //colunaValida3 = coluna;	       
       }
	 return posicaoEValida;
}
   public void colocarPasso(int linha, int coluna) throws Exception
   {
	   	int aux = 0;
		if(linha < 0 || linha > this.TotalLinha)
			throw new Exception("Linha passada nao e valida");

		if(coluna < 0 || coluna > this.TotalColuna)
			throw new Exception("Coluna passa nao e valida");

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


	
}
