package labirintoprograma.labirinto;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import labirintoprograma.labirinto.coordenada.Coordenada;
import labirintoprograma.labirinto.fila.Fila;
import labirintoprograma.labirinto.pilha.Pilha;

public class labirinto
{
    protected char[][] labirinto;
    protected int totalLinha;
    protected int totalColuna;
    protected Pilha<Coordenada> caminho;
    protected Coordenada atual;
    protected Pilha<Fila<Coordenada>> possibilidades;
    protected Fila<Coordenada> fila;


public labirinto(char[][] lab,int linha,int coluna) throws Exception
{
        this.labirinto   = lab;
        this.totalLinha  = linha;
        this.totalColuna = coluna;
        try{
            this.fila = new Fila<>(3);            
            this.possibilidades = new Pilha<>(this.totalLinha * this.totalColuna);
            this.caminho = new Pilha<>(this.totalColuna * this.totalLinha);  
            System.out.println("Instancia das classes esta ok");
            }
        catch (Exception erro){
            System.out.println("Entrou no catch da instancia das classes");//Sei que não vai dar erro
           }
}

protected boolean ConferirCaracteres()
{
    boolean AchouE = false;
    boolean AchouS = false;
    int entradas = 0;
    int saidas = 0;
    int contador = 0;
    int aux = 2;
   
    while(aux != 0) //percorrer a primeira e a ultima linha
    {
        if(contador == this.totalLinha-1) //se for a segunda vez.... pois de uma linha com coluna s? irei consultar a primeira linha e a ultima
            aux = 0;

        for(int coluna = 0; coluna < this.totalColuna;coluna++)
        {
            if((this.labirinto[contador][coluna] == 'E')||(this.labirinto[contador][coluna] == 'e')){
                AchouE = true;
                entradas++;
               // this.colocarEntrada(contador,coluna);
            }
            if((this.labirinto[contador][coluna] == 'S')||(this.labirinto[contador][coluna] == 's')){
                AchouS = true;
                saidas++;
            }
        }
        contador = this.totalLinha-1;   //ele estar? pegando a ultima linha que existe no labirinto -1 que ? a ultima linha da minha matriz
                                	 //pois minha matriz inicia com 0
    }

    aux = 2;        //voltando o aux para 0
    contador = 0;   //voltando contador para 0 para ser usado no pr?ximo while... que ser? usado para conferir
                    //as laterais da minha matriz.
    while(aux != 0)
    {
    if(contador == this.totalColuna-1)  //se for a segunda vez.... pois  s? irei consultar a primeira coluna e a ultima... que s?o
      aux = 0;                          //minhas laterais onde posso encontrar E e S.
        for(int linha = 0; linha < this.totalLinha; linha++)
        {
            if((this.labirinto[linha][contador] == 'E')||(this.labirinto[linha][contador] == 'e')){
                AchouE = true;
                entradas++;
               // this.colocarEntrada(linha,contador);
            }
            if((this.labirinto[linha][contador] == 'S')||(this.labirinto[linha][contador] == 's')){
                AchouS = true;
                saidas++;
            }
         }
            contador = this.totalColuna-1;  //ele estar? pegando a ultima Coluna que existe no labirinto -1 que ? a ultima linha da minha matriz
                                            //pois minha matriz inicia com 0
  }
    if((AchouS)&&(AchouE) && (entradas == 1) &&(saidas == 1)) {
          System.out.println("Labirinto contem os devidos caracteres");
          return true;}
    else{
         return false; 
     }
}      

protected boolean posicaoValida(int linha, int colun)
{
    boolean Evalida = false;
    if(this.labirinto[linha][colun] == '#')
        Evalida = false;
    else
        Evalida = true;

    return Evalida;
}

protected void validaPosicoes() throws Exception
{      
    int linha,coluna;
    //linha de cima, mas na mesma coluna
    linha  =  (this.atual.getLinha())-1; 
    coluna =  this.atual.getColuna();
    if(linha >= 0 ){ //Se ele nao estiver na primeira linha,logo posso subtrai-la e verifica-la  
        Coordenada c = new Coordenada(linha,coluna);  
        if(this.labirinto[linha][coluna] != '#'){
             this.fila.enfileire(c);
        }
    }
    
    //mesma linha, mas coluna da frente
    coluna = (this.atual.getColuna())+1;
    linha = this.atual.getLinha();
    if(coluna <= this.totalColuna){
        Coordenada c = new Coordenada(linha,coluna); 
        if(this.labirinto[linha][coluna] != '#'){                    
            this.fila.enfileire(c);
        }             
    }
    
    //mesma coluna, mas na linha de baixo
    
    coluna = this.atual.getColuna();
    linha  = (this.atual.getLinha())-1;
    
    if(linha >= 0 && linha != this.totalLinha-1){
        if(this.labirinto[linha][coluna] != '#'){
            Coordenada c = new Coordenada(linha,coluna);
            this.fila.enfileire(c);
       }            
    }  
    
    //mesma linha, mas na coluna anterior
    coluna = (this.atual.getColuna())-1;
    linha  = this.atual.getLinha();
    if(coluna >= 0){
        if(this.labirinto[linha][coluna] != '#'){
            Coordenada c = new Coordenada(linha,coluna);
            this.fila.enfileire(c);
        }       
    }
}  
protected void colocarPasso()
{
    this.labirinto[this.atual.getLinha()][this.atual.getColuna()] = '*';

    for(int l = 0; l < this.totalLinha; l++)
    {
        for(int c = 0; c < this.totalColuna; c++)
        {
            System.out.print(this.labirinto[l][c]);
        }

        System.out.println("");
    }    
}

protected void tirarPasso()
{
    this.labirinto[this.atual.getLinha()][this.atual.getColuna()] = ' ';
    for(int l = 0; l < this.totalLinha; l++){    
        for(int c = 0; c < this.totalColuna; c++){        
            System.out.print(this.labirinto[l][c]);
        }
        System.out.println("");
    }    
}

protected void colocarEntrada() throws Exception
{
for(int i=0; i<this.totalLinha; i++)
   for(int j=0; j<this.totalColuna; j++)
    {
        if(this.labirinto[i][j] == 'E')
        {
           this.atual = new Coordenada(i, j);               
        }          
}
}
public void resolverLab() throws Exception
{
    String situacao = "Progressiva";
    
    if(!(this.ConferirCaracteres()))
        throw new Exception("E ou S nao foi encontrado,certifique-se que seu arquivo esta digitado corretamente");
    
   // this.colocarEntrada();
   
      this.colocarEntrada();
    
    while(this.labirinto[this.atual.getLinha()][atual.getColuna()] != 'S')
    {

        this.fila = new Fila<>(3);        
        this.validaPosicoes();
        
        while(!(this.fila.vazia())){           
            this.atual = this.fila.getFila();
            this.fila.desenfileire();            
            this.colocarPasso();
            this.caminho.empilhe(this.atual);
            this.possibilidades.empilhe(this.fila);

            this.fila = new Fila<>(3); //instanciando novamente pois desenfileirei
            this.validaPosicoes();
            }      
              
      
        
        while(this.fila.vazia()){
            this.atual = this.caminho.getTopo();
            this.caminho.desempilhe();
            this.tirarPasso();
            this.fila = this.possibilidades.getTopo();
            this.possibilidades.desempilhe();                 
        } 
     }
    }   
}        


