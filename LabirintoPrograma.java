
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import labirintoprograma.labirinto.labirinto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 17165, 17171 e 16
 */
public class LabirintoPrograma {
 public static void main(String[] args) throws IOException
  {
    try
    {            
        char[][] lab = null;
        int totalLinha = 0;
        int totalColuna = 0;         
        labirinto l;         
        String nomeArquivo = null;
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Caminho para o arquivo?");
	       	  String caminhoParaOArquivo=teclado.readLine();        

        BufferedReader arquivo = new BufferedReader(new FileReader(caminhoParaOArquivo));

        for(int linha = 1; linha <= 2; linha++){
        if(linha == 1){
            String Arquivo = arquivo.readLine();
            totalLinha = Integer.parseInt(Arquivo);
            System.out.println(totalLinha);
                    }
        
        if(linha == 2){
        String Arquivo = arquivo.readLine();
        totalColuna = Integer.parseInt(Arquivo);
        System.out.println(totalColuna);
                }
        }
        char[][] labirinto = new char[totalLinha][totalColuna];
        int contagemLinha = 0;       

        while (arquivo.ready())
        {
            String componente = arquivo.readLine(); //armazenando em uma var os valores da linha em questao do arquivo

            for(int coluna = 0; coluna <= totalColuna-1; coluna++){ // ja percoreu a linha 0 e colunas
                labirinto[contagemLinha][coluna] = componente.charAt(coluna);
                System.out.print(labirinto[contagemLinha][coluna]);
            }
            System.out.println("");
            contagemLinha++;                                                                                                                                                  //ele começara com a ContagemLinha qúe é o int que declarei acima, ela funciona para saber de qual linha estou tratando...
          
      }         
         l = new labirinto(labirinto,totalLinha,totalColuna); 
         l.resolverLab();
       
    }   
    catch(FileNotFoundException erro2)
    { System.out.println("Não foi achado o arquivo.");}

    catch(Exception erro)
    { System.out.println("Labirinto errado");}

  }   
    
}
