package labirintoprograma.labirinto.coordenada;
/**
 * Classe com o proposio de instanciar e possibilitar a criaçao de coordenadas
 * @author @u15164 @17171  @17165
 */
public class Coordenada
{
    protected int coluna;
    protected int linha;
    protected int colunaFinal;
    protected int linhaFinal;

/**
 * @param parametro passado na instanciacao
 * @throws se os valores passados forem menores que zero
 * */

  public Coordenada(int coluna, int linha) throws Exception
   {
	   if(coluna < 0)
	   	throw new Exception("Coluna invalida");

	   if(linha < 0)
	   	throw new Exception("Linha invalida");

	   this.coluna = coluna;
	   this.linha  = linha;
   }
  
  /**
  *
  * @param Coluna recebe a coluna para ser definida
  * @throws Exception caso coluna não esteja nos padroes lança excessao
  */
   public void setColuna(int Coluna)
   {
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

   public void setLinha(int Linha)
   {
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
   * @return retorna a string ret que exibe devidamente os valores da Classe Coordenada
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
   * @return retorna true caso sejam de fato semelhantes os objetos
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
	/**
	 * Constructor de Copia
	 * @param modelo sera um obj Coordenada que sera copiado
	 * @throws lanca excecao, quando seu parametro nao e devidamente valido, ou seja null
	 * */
	public Coordenada (Coordenada modelo) throws Exception
	{
		  if(modelo==null)
		      throw new Exception("Modelo invalido");


		 this.coluna = modelo.coluna;
	     this.linha = modelo.linha;
	}
	/**
	 * @return retornara a copia do this, sendo assim usando o constructor de copia
	 * */

	public Object clone()
	{
		 Coordenada ret = null;

		 try
		 {
	        ret = new Coordenada(this);
		 }
		 catch(Exception erro)
		 {}

		return ret;
	}

	
}