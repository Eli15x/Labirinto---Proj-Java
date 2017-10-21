public class Coordenada
{
    protected int coluna;
    protected int linha;

   public void setColuna(int Coluna)
   {
     this.coluna = Coluna;
   }

   public int getColuna()
   {
      return this.coluna;
   }

   public void setLinha(int Linha)
   {
       this.linha = Linha;
   }

   public int getLinha()
   {
     return this.linha;
   }


   public String toString()
   {
	   String ret;

     ret = "(";

     ret += this.linha +","+ this.coluna;

     ret += ")";


     return ret;
   }
   
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


    public int hashCode()
    {
      int ret = 77;

      ret = ret*7  + new Integer(this.linha).hashCode();
      ret = ret*5  + new Integer(this.coluna).hashCode();

    return ret;
	  }



}