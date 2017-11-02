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

public class Projeto2{


	public static void main(String[] args) throws IOException{

    	char[][] Matriz;
    	int TotalLinha = 0;  
    	int TotalColuna= 0;  

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

	    for(int linha = 1; linha <= 2; linha++){

			if(linha == 1){
		    		    	String Arquivo = arquivo.readLine();
		    		        TotalLinha = Integer.parseInt(Arquivo);

		    		        System.out.println(TotalLinha);
				          }

            if(linha == 2){
		                	String Arquivo = arquivo.readLine();
		    		        TotalColuna = Integer.parseInt(Arquivo);

		    		        System.out.println(TotalColuna);
			               }
           
    
	}   
            StringTokenizer quebrador = new StringTokenizer("exp","+-/*^",true);
            Pilha p = new Pilha(quebrador.nextToken(caminhoParaOArquivo));
            Fila f = new Fila(quebrador.nextToken(caminhoParaOArquivo));
            if(quebrador.equals("+"))
               p.empilhe(quebrador.nextToken());
            if(quebrador.equals("-"))
               p.empilhe(quebrador.nextToken());
            if(quebrador.equals("/"))
               p.empilhe(quebrador.nextToken());
            if(quebrador.equals("*"))
               p.empilhe(quebrador.nextToken());
            if(quebrador.equals("^"))
               p.empilhe(quebrador.nextToken());
            if(quebrador.equals("("))
               p.empilhe(quebrador.nextToken());
            else{
                f.enfileire(quebrador.nextToken());
            }
            

        } catch (FileNotFoundException e1){
		System.out.println("Não encontramos vosso arquivo, por favor redigite tal caminho ^u^ : ");
        }}
}
            
    

