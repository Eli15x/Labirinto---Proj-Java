package labirintoprograma.labirinto;

import java.io.*;
import labirintoprograma.labirinto.coordenada.Coordenada;
import labirintoprograma.labirinto.pilha.*;
import labirintoprograma.labirinto.fila.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class labirinto
{
    protected char[][] labirinto;
    protected int TotalLinha;
    protected int TotalColuna;
    protected Pilha<Coordenada> caminho ;
    protected Coordenada atual;
    protected Pilha<Fila<Coordenada>> possibilidades;
    protected Fila<Coordenada> fila;
    

   public labirinto(char[][] lab,int linha,int coluna) throws Exception
    {
        this.labirinto   = lab;
        this.TotalLinha  = linha;
        this.TotalColuna = coluna;      
        try{
            fila = new Fila<Coordenada>(3);
            }
        catch (Exception erro){
        //Sei que não vai dar erro
           }
    }
   
 /*public void lerDados() throws Exception//catch(FileNotFoundException erro2)
 {
     
    try{

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        System.out.print ("Caminho para o arquivo? ");
        String caminhoParaOArquivo =teclado.readLine();

        BufferedReader arquivo = new BufferedReader(new FileReader(caminhoParaOArquivo));                        
	
         for(int linha = 1; linha <= 2; linha++){
            if(linha == 1){
                String Arquivo = arquivo.readLine();
                this.TotalLinha = Integer.parseInt(Arquivo);
                System.out.println(TotalLinha);
                       }

             if(linha == 2){
                String Arquivo = arquivo.readLine();
                this.TotalColuna = Integer.parseInt(Arquivo);
                System.out.println(TotalColuna);
                      }
    }

    this.labirinto = new char[TotalLinha][TotalColuna];  
   
    int contagemLinha = 0;

    while (arquivo.ready())
    {
        String componente = arquivo.readLine(); //armazenando em uma var os valores da linha em questao do arquivo

        for(int coluna = 0; coluna <= TotalColuna-1; coluna++) // ja percoreu a linha 0 e colunas
        this.labirinto[contagemLinha][coluna] = componente.charAt(coluna); //pegando cada char da linha para colocar na posicao da matriz adequada.
	  	          																	      //ele começara com a ContagemLinha qúe é o int que declarei acima, ela funciona para saber de qual linha estou tratando...
	  	          																	     //para poder aramazenar os dados corretamente conforme o arquivo tx
        for(int coluna = 0; coluna < TotalColuna-1; coluna++)
           // this.returnMatrizLida(contagemLinha, coluna);
            System.out.print(labirinto[contagemLinha][coluna] );
            System.out.println("");
            contagemLinha++;
       
        contagemLinha++; //agora estou indo para próxima linha pois todos os character da linha já foram pegos.

      }

    }
    catch(FileNotFoundException err)
    {
    	throw new Exception ("Arquivo nao encontrado");
    }

    }*/
  

 

private char returnMatrizLida(int linha, int coluna)
{
     return this.labirinto[linha][coluna];
}
    
    
 /*public labirinto (String nomeArquivo) throws FileNotFoundException, Exception{
        try{
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
        
        int linhas = Integer.parseInt(br.readLine());
        int colunas = Integer.parseInt(br.readLine());
        this.labirinto = new char[linhas][colunas];
        
        String linha;
        int i = 0;
        while((linha = br.readLine()) != null){ 
            this.labirinto[i] = linha.toCharArray();
            i++;            
        }
        try{
            this.caminho = new Pilha<Coordenada>(linhas * colunas);
            this.possibilidades = new Pilha<Fila<Coordenada>>(linhas * colunas);
        }
        catch(Exception erro)
        {}         
        
        if (!(this.ConferirCaracteres()))
            throw new Exception ("Labirinto possui mais ou menos de ma entrada ou saída");
        
        this.AtribuirEntrada();
        
        }
        catch (IOException erro){
            //Tratar?
        }
    
    }*/

 private boolean ConferirCaracteres() throws Exception
 {
        boolean AchouE = false;
        boolean AchouS = false;
        int entradas = 0;
        int saidas = 0;
        
        //Linha de Cima
        /*for (int i = 0; i <= this.labirinto[0].length-1; i++)
            if (this.labirinto[0][i] == 'E')
                entradas++;
            else
                if (this.labirinto[0][i] == 'S')
                    saidas++;
        
        //Linha de Baixo
        for (int i = 0; i <= this.labirinto[this.labirinto.length-1].length; i++)
            if (this.labirinto[this.labirinto.length-1][i] == 'E')
                entradas++;
            else
                if (this.labirinto[this.labirinto.length-1][i] == 'S')
                    saidas++;
        
        //Coluna da esquerda      
        for (int i = 1; i <=this.labirinto.length-2; i++)
            if (this.labirinto[i][0] == 'E')
                entradas++;
            else
                if (this.labirinto[i][0] == 'S')
                    saidas++;
        
        //Coluna da direita       
        for (int i = 1; i <=this.labirinto.length-2; i++)
            if (this.labirinto[i][this.labirinto[i].length-1] == 'E')
                entradas++;
            else
                if (this.labirinto[i][this.labirinto[i].length-1] == 'S')
                    saidas++;*/
        
        
        //return ((entradas == 1) && (saidas == 1));
            
        int contador = 0;
        int aux = 2;	


        while(aux != 0) //percorrer a primeira e a ultima linha
        {
            if(contador == this.TotalLinha-1) //se for a segunda vez.... pois de uma linha com coluna s? irei consultar a primeira linha e a ultima
                aux = 0;

            for(int coluna = 0; coluna < this.TotalColuna;coluna++)
            {
                if((this.labirinto[contador][coluna] == 'E')||(this.labirinto[contador][coluna] == 'e')){                    
                        AchouE = true; 
                        entradas++;

                }
                if((this.labirinto[contador][coluna] == 'S')||(this.labirinto[contador][coluna] == 's')){
                        AchouS = true;
                        saidas++;
                       
                }

            }

            contador = this.TotalLinha-1;      //ele estar? pegando a ultima linha que existe no labirinto -1 que ? a ultima linha da minha matriz
      									      //pois minha matriz inicia com 0
        }

        aux = 2;        //voltando o aux para 0
	contador = 0;   //voltando contador para 0 para ser usado no pr?ximo while... que ser? usado para conferir
                        //as laterais da minha matriz.
        while(aux != 0)
        {

                if(contador == this.TotalColuna-1)  //se for a segunda vez.... pois  s? irei consultar a primeira coluna e a ultima... que s?o
                        aux = 0;						//minhas laterais onde posso encontrar E e S.


                for(int linha = 0; linha < this.TotalLinha; linha++)
                {
                            if((this.labirinto[linha][contador] == 'E')||(this.labirinto[linha][contador] == 'e')){
                                    AchouE = true;                                  
                                    entradas++;	
                                    this.atribuiEntradas(linha,contador);
                                         
                            }

                            if((this.labirinto[linha][contador] == 'S')||(this.labirinto[linha][contador] == 's')){
                                    AchouS = true;
                                    saidas++;
                                   
                                   
                            }
                 }
                    contador = this.TotalColuna-1; //ele estar? pegando a ultima Coluna que existe no labirinto -1 que ? a ultima linha da minha matriz
                                    //pois minha matriz inicia com 0
      }

    if((AchouS)&&(AchouE) && (entradas == 1) &&(saidas == 1)) {
          System.out.println("Labirinto contem os devidos caracteres");        
          return true;
    }
    else{     
         throw new Exception ("N?o foi encontrado O caracter E ou S em seu Arquivo, por favor certifique-se se seu arquivo esta digitado corretamente");
     }

    }
 
 /*private void AtribuirEntrada(){
     boolean achou = false;
     int j = 0;
     //Linha de Cima
     
        for (int i = 0; i <= this.labirinto[j].length; i++)
            if (this.labirinto[j][i] == 'E'){
                try{
                    this.atual = new Coordenada (j, i);
                }
                catch (Exception e){/*N VAI DAR ERRO*/}
                //achou = true;
           // }
        
        //Linha de Baixo
     //  if (!(achou))
      // for (int i = 0; i <= this.labirinto[this.labirinto.length-1].length; i++)
          //  if (this.labirinto[this.labirinto.length-1][i] == 'E'){
          //     try{
            //        this.atual = new Coordenada (this.labirinto.length-1, i);
            //    }
             //   catch (Exception e){/*N VAI DAR ERRO*/}
          //     achou = true;
           // }
            
        
        //Coluna da esquerda
        //I é inicializado como 1 e vai até length -2 para não percorrer o mesmo espaço
        //vezes (já foram percorridos nas linhas) nos fors a cima
       /* if (!(achou))
        for (int i = 1; i <=this.labirinto.length-2; i++)
            if (this.labirinto[i][0] == 'E'){
                try{
                this.atual = new Coordenada (i, 0);
                }
                
               /* achou = true;*/
           // }
        
        //Coluna da direita
        //I é inicializado como 1 e vai até length -2 para não percorrer o mesmo espaço
        //vezes (já foram percorridos nas linhas) nos fors a cima
       /* if (!(achou))
        for (int i = 1; i <=this.labirinto.length-2; i++)
            if (this.labirinto[i][this.labirinto[i].length-1] == 'E'){
                try{
                this.atual = new Coordenada (i, 0);
                }
                catch (Exception e){/*N VAI DAR ERRO*/}
               /* achou = true;*/
            //}
 //}

/*private boolean validaPosicoes()
{
       // boolean posicaoEValida = false; //inicializando com false

       // linha =  linha - 1; //linha anterior a passada no parametro, mas na mesma coluna
       
        //Cima
        if(this.labirinto[this.atual.getLinha()-1][this.atual.getColuna()] == ' ')
        {
                System.out.println((this.atual.getLinha()-1)+", "+this.atual.getColuna()+" : Ha espaco");
               // Enfileirar essa coordenada no possibilidades   
               

        }  
        else
        if(this.labirinto[this.atual.getLinha()-1][this.atual.getColuna()] != ' ')
            System.out.println(this.atual.getLinha()-1+", "+this.atual.getColuna()+" : Ha parede ou asterisco");
        
        //Baixo
        if(this.labirinto[this.atual.getLinha()+1][this.atual.getColuna()] == ' ')
        {
                System.out.println((this.atual.getLinha()+1)+", "+this.atual.getColuna()+" : Ha espaco");
                //Enfileirar essa coordenada no possibilidades

        }
        else
        if(this.labirinto[this.atual.getLinha()+1][this.atual.getColuna()] != ' ')
            System.out.println((this.atual.getLinha()+1)+", "+this.atual.getColuna()+" : Ha parede ou asterisco");
        
        //Direito
        if(this.labirinto[this.atual.getLinha()][this.atual.getColuna()+1] == ' ')
        {
                System.out.println(this.atual.getLinha()+", "+(this.atual.getColuna()+1)+" : Ha espaco");
                //Enfileirar essa coordenada no possibilidades

        }
        else
        if(this.labirinto[this.atual.getLinha()][this.atual.getColuna()+1] != ' ')
            System.out.println(this.atual.getLinha()+", "+(this.atual.getColuna()+1)+" : Ha parede ou asterisco");
        
        //Esquerda
        if(this.labirinto[this.atual.getLinha()][this.atual.getColuna()-1] == ' ')
        {
                System.out.println(this.atual.getLinha()+", "+this.atual.getColuna()+" : Ha espaco");
                //Enfileirar essa coordenada no possibilidades

        }
        else
        if(this.labirinto[this.atual.getLinha()][this.atual.getColuna()-1] != ' ')
            System.out.println(this.atual.getLinha()+", "+this.atual.getColuna()+" : Ha parede ou asterisco");

        
        
        /*this.atual.setColuna(this.atual.getColuna() +1);
        this.atual.setLinha(this.atual.getLinha()  +1); //eu tinha subtraido por isso*/

        /*if(this.labirinto[this.atual.getLinha()][this.atual.getColuna()] == '#')
        {
                System.out.println(this.atual.getLinha()+", "+this.atual.getColuna()+" : Ha parede");
        }

        if(this.labirinto[this.atual.getLinha()][this.atual.getColuna()] == ' ')
        {
                System.out.println(this.atual.getLinha()+", "+this.atual.getColuna()+" : Ha espaco");
               // this.linhaValida2   = linha;
               // this.colunaValida2  = coluna;
        }

        this.atual.setLinha(this.atual.getLinha() + 1);
        this.atual.setColuna(this.atual.getColuna() -1);

       if(this.labirinto[this.atual.getLinha()][this.atual.getColuna()] == '#')
       {
		  //posicaoEValida = false;
			System.out.println(this.atual.getLinha()+", "+this.atual.getColuna()+" : Ha parede");

	   }
	   if(this.labirinto[this.atual.getLinha()][this.atual.getColuna()] == ' ')
	   {
		  // posicaoEValida = true;
		   System.out.println(this.atual.getLinha()+" , "+this.atual.getColuna()+" : Ha espaco");
		//   this.linhaValida3  = this.atual.getLinha();
		 //  this.colunaValida3 = coluna;
	   }*/

	   return posicaoEValida;
}*/

private void colocarPasso()
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

  private boolean posicaoValida(int linha, int coluna) throws Exception
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

//Este será o unico metodo no qual o usuario podera acessar na main, logo este estara relacionando o item 6 ao 12 do projeto
public void resolverLab() throws Exception
{
    this.fila = new Fila<Coordenada>(3);
    
    
}

/*public boolean vazia()
{
	boolean empty = true;

	for (char[] vet : labirinto)
        for (char chr : vet)
        {
	  if (chr != ) {
	    empty = false;
	    break;
	  }
	  else
	  	empty = true;
   }

    System.out.println(empty);

   return empty;

}*/
}