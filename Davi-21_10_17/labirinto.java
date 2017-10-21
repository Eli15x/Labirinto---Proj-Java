
/**
 * 
 * @author @u15164 @17171  @17165 
 * Cria o labirinto instanciando as vari�veis realizando as verifica��es necess�rias
 */
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
	this.passo = '*';


}
/**
 * Faz as verifica��es necess�rias para os caracteres do labirinto
 * Encontra E (inicio) e S (fim) no percurso
 * @return - Returna true caso caso encontre, lan�a excessao caso n�o 
 * @throws Exception - Caso n�o encontre pede para o usu�rio verificar o arquivo escrito novamente
 */
public boolean ConferirCaracteres() throws Exception{

boolean AchouE = false;
boolean AchouS = false;
int Contador = 0;
int aux = 2;

while(aux != 0){

	if(Contador == this.TotalLinha-1) //se for a segunda vez.... pois de uma linha com coluna s� irei consultar a primeira linha e a ultima
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
       Contador = this.TotalLinha-1; //ele estar� pegando a ultima linha que existe no labirinto -1 que � a ultima linha da minha matriz
        //pois minha matriz inicia com 0
 }

	aux = 2;       //voltando o aux para 0
	Contador = 0;  //voltando Contador para 0 para ser usado no pr�ximo while... que ser� usado para conferir
		           //as laterais da minha matriz.
  while(aux != 0){

	if(Contador == this.TotalColuna-1) //se for a segunda vez.... pois  s� irei consultar a primeira coluna e a ultima... que s�o
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
      Contador = this.TotalColuna-1; //ele estar� pegando a ultima Coluna que existe no labirinto -1 que � a ultima linha da minha matriz
	        //pois minha matriz inicia com 0
   }

    if((AchouS)&&(AchouE))
    	return true;
    else{
	    throw new Exception ("N�o foi encontrado O caracter E ou S em seu Arquivo,porfavor certifique-se se seu arquivo est� digitado corretamente");
	    }




 }
/**
 * 
 * @return retorna posi��o inicial da linha
 */
 public int PosicaoInicialLinha(){
 	return this.posicaoInicialLinha;
}
/**
 * 
 * @return retorna posi��o inicial da coluna
 */
 public int PosicaoInicialColuna(){
 	return this.posicaoInicialColuna;
}
/**
 * 
 * @return retorna posi��o final da coluna
 */
public int PosicaoFinalColuna(){

    return this.posicaoFinalColuna;
}
/**
 * 
 * @return retorna posi��o final da linha
 */
public int PosicaoFinalLinha(){

	return this.posicaoFinalLinha;
}





















}