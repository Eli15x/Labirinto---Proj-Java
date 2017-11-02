/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.pkg2;

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
   
       // fazer ler o arquivo texto
    /**
     * Método que encontra
     * @return
     * @throws Exception 
     */           
    public boolean TouF() throws Exception{
        boolean AchouT = false;
        boolean AchouF = false;
        int Contador = 0;
        int aux = 2;

while(aux != 0){

	if(Contador == this.TotalLinha-1) 
		aux = 0;

	for(int coluna = 0; coluna <= this.TotalColuna-1;coluna++){
		if((this.Matriz[Contador][coluna] == 'T')||(this.Matriz[Contador][coluna] == 't')){

			this.posicaoInicialLinha = Contador;
			this.posicaoInicialColuna = coluna;
			AchouT = true;
		}

	    if((this.Matriz[Contador][coluna] == 'F')||(this.Matriz[Contador][coluna] == 'f')){

			this.posicaoFinalLinha = Contador;
			this.posicaoFinalColuna = coluna;
			AchouF = false;
        }

    }
       Contador = this.TotalLinha-1; 
 }

	aux = 2;       
	Contador = 0;  
  while(aux != 0){

	if(Contador == this.TotalColuna-1)
		aux = 0;

    for(int linha = 0; linha <= this.TotalLinha-1; linha++){
		if((this.Matriz[linha][Contador] == 'T')||(this.Matriz[linha][Contador] == 't')){

			this.posicaoInicialLinha = linha;
			this.posicaoInicialColuna = Contador;
			AchouT = true;

	    }
		if((this.Matriz[linha][Contador] == 'F')||(this.Matriz[linha][Contador] == 'f')){

			this.posicaoFinalLinha = linha;
			this.posicaoFinalColuna = Contador;
			AchouF = false;
	    }

       }
      Contador = this.TotalColuna-1; 
   }

    if((AchouF)&&(AchouT))
    	return true;
    else{
	    throw new Exception ("Não foi encontrado");
    }
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