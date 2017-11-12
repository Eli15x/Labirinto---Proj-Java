/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.pkg2;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.util.StringTokenizer;
import java.lang.NumberFormatException;

public class Projeto2{


	public static void main(String[] args) throws IOException, Exception{

    	char[][] Matriz;
    	String TotalLinha = null;  
    	String TotalColuna= null;  

       // Lendo o arquivo texto
    try {
	   			BufferedReader teclado= new BufferedReader(
	                               		new InputStreamReader(
	                                   	System.in));

	        	System.out.print ("Caminho para o arquivo? ");
	        	String caminhoParaOArquivo=teclado.readLine();

	        	BufferedReader arquivo =new BufferedReader(
	                               		new FileReader(
	                               		caminhoParaOArquivo));

	    for(int linha = 1; linha <= 6; linha++){

			if(linha == 1){
		    		    	String Arquivo = arquivo.readLine();
		    		        TotalLinha = (Arquivo);
                StringTokenizer quebrador = new StringTokenizer(Arquivo,"+-/*",true);
                while(quebrador.hasMoreTokens()){
                Pilha p = new Pilha(10, 10);
                 Fila f  = new Fila(10, 10);
               p.empilhe(quebrador.nextToken("+"));
               p.empilhe(quebrador.nextToken("-"));
               p.empilhe(quebrador.nextToken("/"));
               p.empilhe(quebrador.nextToken("*"));
  
                    
                }
		    		        System.out.println(TotalLinha);
				          }

            if(linha == 6){
		                	String Arquivo = arquivo.readLine();
		    		        TotalColuna = (Arquivo);
                                        StringTokenizer quebrador = new StringTokenizer(Arquivo,"+-/*",true);
                while(quebrador.hasMoreTokens()){
                Pilha p = new Pilha(10, 10);
                 Fila f  = new Fila(10, 10);
               p.empilhe(quebrador.nextToken("+"));
               p.empilhe(quebrador.nextToken("-"));
               p.empilhe(quebrador.nextToken("/"));
               p.empilhe(quebrador.nextToken("*"));
		    		        System.out.println(TotalColuna);
                                        
                                       System.out.println(p.toString());
			               }
           Matriz m = new Matriz();
           m.Leitura();
	   
            
           
            
            
            }}
              

        } catch (FileNotFoundException e1){
		System.out.println("Não encontramos vosso arquivo, por favor redigite tal caminho ^u^ : ");
        }}
}
            
    

