
/**
 * Classe com o proposito de instanciar e possibilitar a criaçao das coordenadas do labirinto
 * @author @u15164 @17171  @17165 
 */
public class Coordenada
{
    protected int coluna;
    protected int linha;
/**
 * 
 * @param Coluna recebe a coluna para ser definida
 * @throws Exception caso coluna não esteja nos padroes lança excessao
 */
   public void setColuna(int Coluna)throws Exception
   {
     if(Coluna<0)
         throw new Exception("Valor inválido");
     this.coluna = Coluna;
   }
/**
 * 
 * @return retorna coluna
 */
   public int getColuna()
   {
      return this.coluna;
   }
 /**
  * 
  * @param Linha recebe a linha para ser definida
  * @throws Exception caso coluna não esteja nos padroes lança excessao
  */
   public void setLinha(int Linha) throws Exception
   {
         if(Linha<0)
         throw new Exception("Valor inválido");
       this.linha = Linha;
   }
/**
 * 
 * @return retorna linha
 */
   public int getLinha()
   {
     return this.linha;
   }

/**
 * 
 * @return retorna a string ret que "concatenaria" a exibicao
 */
   public String toString()
   {
	   String ret;

     ret = "(";

     ret += this.linha +","+ this.coluna;

     ret += ")";


     return ret;
   }
   /**
    * 
    * @param obj parametro do tipo Object que permite a comparação entre objetos
    * @return retorna true caso sejam comparáveis os objetos
    */
   public boolean equals(Object obj)
   {

      if(this == obj)
      	return true;

      if(obj == null)
          return false;

      if(!(obj instanceof Coordenada))
      	return false;

     	Coordenada dep =(Coordenada) obj;

      if(this.linha != dep.linha)
      	return false;

      if(this.coluna != dep.coluna)
      	return false;

      return true;
    }

/**
 * 
 * @return retorna o int que serviu para organização dos elementos através dos calculos
 */
    public int hashCode()
    {
      int ret = 77;

      ret = ret*7  + new Integer(this.linha).hashCode();
      ret = ret*5  + new Integer(this.coluna).hashCode();

    return ret;
	  }



}