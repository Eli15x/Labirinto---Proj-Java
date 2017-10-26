package labirintoprograma.labirinto;

import java.io.*;
import labirintoprograma.labirinto.coordenada.Coordenada;
import labirintoprograma.labirinto.pilha.*;
import labirintoprograma.labirinto.fila.*;

public class labirinto
{
    protected char[][] labirinto;
    protected int TotalLinha;
    protected int TotalColuna;
    Pilha<Coordenada> caminho ;
    Coordenada atual;



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
		//this.atual = new Coordenada(this.TotalColuna,this.TotalLinha);


		while(aux != 0) //percorrer a primeira e a ultima linha
		{
 			if(Contador == this.TotalLinha-1) //se for a segunda vez.... pois de uma linha com coluna s? irei consultar a primeira linha e a ultima
				aux = 0;

                for(int coluna = 0; coluna < this.TotalColuna;coluna++)
                {
                        if((this.labirinto[Contador][coluna] == 'E')||(this.labirinto[Contador][coluna] == 'e'))
                        {
                                AchouE = true;
                                this.atual = new Coordenada(coluna,Contador);                              
                                System.out.println(atual.getLinha());
                                System.out.println(atual.getColuna());

                        }

                        if((this.labirinto[Contador][coluna] == 'S')||(this.labirinto[Contador][coluna] == 's')){
                                AchouS = true;
                         }

    		}

    		Contador = this.TotalLinha-1;      //ele estar? pegando a ultima linha que existe no labirinto -1 que ? a ultima linha da minha matriz
      									      //pois minha matriz inicia com 0
 		}

		aux = 2;       //voltando o aux para 0
		Contador = 0;  //voltando Contador para 0 para ser usado no pr?ximo while... que ser? usado para conferir
		          	   //as laterais da minha matriz.
 		while(aux != 0)
 		 {

			if(Contador == this.TotalColuna-1)  //se for a segunda vez.... pois  s? irei consultar a primeira coluna e a ultima... que s?o
				aux = 0;						//minhas laterais onde posso encontrar E e S.


    		for(int linha = 0; linha < this.TotalLinha; linha++)
    		{
				if((this.labirinto[linha][Contador] == 'E')||(this.labirinto[linha][Contador] == 'e')){

					AchouE = true;
					this.atual = new Coordenada(Contador,linha);
                                        System.out.println(atual.getLinha());
					System.out.println(atual.getColuna());					

				}

				if((this.labirinto[linha][Contador] == 'S')||(this.labirinto[linha][Contador] == 's')){
					AchouS = true;

				}
       		}


       		Contador = this.TotalColuna-1; //ele estar? pegando a ultima Coluna que existe no labirinto -1 que ? a ultima linha da minha matriz
	        							       //pois minha matriz inicia com 0
  		 }

   		if((AchouS)&&(AchouE)){
		  System.out.println("Labirinto contem os devidos caracteres");
    		return true;
		}
   		else
   		 {
	   		throw new Exception ("N?o foi encontrado O caracter E ou S em seu Arquivo, por favor certifique-se se seu arquivo esta digitado corretamente");
		 }

        }

public boolean validaPosicao(int linha, int coluna)
{
        boolean posicaoEValida = false; //inicializando com false

        linha =  linha - 1; //linha anterior a passada no parametro, mas na mesma coluna
        if(this.labirinto[linha][coluna] == '#')
        {
                System.out.println(linha+", "+coluna+" : Ha parede");
        }

        if(this.labirinto[linha][coluna] == ' ')
        {
                System.out.println(-linha+", "+coluna+" : Ha espaco");
              //  this.linhaValida  = linha;
              //  this.colunaValida = coluna;

        }
        coluna = coluna +1;
        linha  = linha  +1; //eu tinha subtraido por isso

        if(this.labirinto[linha][coluna] == '#')
        {
                System.out.println(linha+", "+coluna+" : Ha parede");
        }

        if(this.labirinto[linha][coluna] == ' ')
        {
                System.out.println(linha+", "+coluna+" : Ha espaco");
               // this.linhaValida2   = linha;
               // this.colunaValida2  = coluna;
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
		//   this.linhaValida3  = linha;
		 //  this.colunaValida3 = coluna;
	   }

	   return posicaoEValida;
}

   public void colocarPasso()
   {
	this.labirinto[atual.getLinha()][atual.getColuna()] = '*';


	for(int l = 0; l < this.TotalLinha; l++)
	{
            for(int c = 0; c < this.TotalColuna; c++)
            {
               System.out.print(this.labirinto[l][c]);
            }

		System.out.println("");
	}
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

public boolean ESaida(int linha, int coluna) throws Exception
{
	if(labirinto[linha][coluna] == 'S' || labirinto[linha][coluna] == 's' )
	   return true;

	else
          return false;

}

public boolean vazia()
{
	boolean empty = true;

	for (Object ob : labirinto) {
	  if (ob != null) {
	    empty = false;
	    break;
	  }
	  else
	  	empty = true;
   }

    System.out.println(empty);

   return empty;

}
}