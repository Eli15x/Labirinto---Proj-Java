package projeto.pkg2;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author u15164
 */
public class Matriz {
        char[][] Matriz;

    	int TotalLinha = 0;  
    	int TotalColuna= 0;
	int posicaoInicialLinha;
	int posicaoInicialColuna;
	int posicaoFinalLinha;
	int posicaoFinalColuna;

    /**
     *
     * @return
     */
     public char[][] Leitura() throws FileNotFoundException, IOException {
        
     BufferedReader teclado= new BufferedReader(
	                               		new InputStreamReader(
	                                   	System.in));

	        	System.out.print ("Caminho para a matriz? ");
	        	String caminhoParaOArquivo=teclado.readLine();

	        	BufferedReader arquivo =new BufferedReader(
	                               		new FileReader(
	                               		caminhoParaOArquivo));

           //PEGANDO VALOR DA COLUNA E LINHA

	    for(int linha = 1; linha <= 6; linha++){

			if(linha == 1){
		    		    	String Arquivo = arquivo.readLine();
		    		  
		    		        System.out.println(Arquivo);
				          }

            if(linha == 6){
		                	String Arquivo = arquivo.readLine();
		    		        

		    		        System.out.println(Arquivo);
			               }

        }
        	//Coord.setLinha(TotalLinha);
        	//Coord.setColuna(TotalColuna);

        	//caminho.empilhe(Coord);
        	//System.out.println("valor coord empilhe : "+caminho.toString());

        Matriz = new char[TotalLinha][TotalColuna];
        return Matriz;
    }   
//ler aqui o arquivo        
    public boolean TouF(char simbolo1, char simbolo) throws Exception{
        boolean AchouT = false;
        boolean AchouF = false;
        int linha=0;
        int coluna=0;
       
        for(int j = 0; j<=this.Matriz.length;j++)
           if(this.Matriz[0][j]==simbolo)
                coluna = j;
            
        for(int i = 0; i<=this.Matriz.length;i++){
           if(this.Matriz[i][0]==simbolo1)
               coluna=i;
               
           if(this.Matriz[linha][coluna]=='T')
               return true;
        
      //se nao achou T, logo achou F que está definido como false;devolvendo false
    }
        return false;
    }
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(obj==this)
            return true;
        if(obj instanceof Matriz)
            return false;
        Matriz m = (Matriz)obj;
        if (this.Matriz!=m.Matriz)
            return false;
        if (this.TotalLinha!=m.TotalLinha)
            return false;
        if (this.TotalColuna!=m.TotalColuna)
            return false;
        if (this.posicaoInicialLinha!=m.posicaoInicialLinha)
            return false;
        if (this.posicaoFinalLinha!=m.posicaoFinalLinha)
            return false;
        if (this.posicaoFinalColuna!=m.posicaoFinalColuna)
            return false;
 
        
     return true;
    }
    
    public int hashCode()
    {
        int ret = 777;
        ret = ret * 7+ new Integer(this.TotalLinha).hashCode();
        ret = ret * 7+ new Integer(this.TotalColuna).hashCode();
        ret = ret * 7+ new Integer(this.posicaoInicialLinha).hashCode();
        ret = ret * 7+ new Integer(this.posicaoFinalLinha).hashCode();
        ret = ret * 7+ new Integer(this.posicaoFinalColuna).hashCode();
        return ret;
    }
    
    public String toString()
    {
        String ret = "";
     for(int i=0;i<=posicaoFinalLinha;i++)
         for(int j=0;j<=posicaoFinalColuna;j++){
             ret = CharAt(Matriz[i][j]);
             System.out.print(this.Matriz[i][j]);}
     return ret;
    }

    
    private String CharAt(char Matriz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}