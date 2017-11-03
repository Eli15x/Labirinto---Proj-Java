public class Pilha<X>
{
    private Object[] Vetor;
    private int taxa;
    private int topo;



    public Pilha(int tc)
    {
    	taxa = tc;  // recebe a taxa de crescimento do meu vetor passada pelo programa.
	    Vetor = new Object[tc];  // recebendo o tamanho da taxa passada.
	    topo = -1;

	}

	public Pilha()
	{

    	this(10);

	}

	public void Cresca()
	{
		int Tamanho = this.Vetor.length + this.taxa;

		Object[] dep = new Object[Tamanho];

		for(int i = 0; i <= this.Vetor.length-1; i++)
	   		dep[i] = this.Vetor[i];


	    this.topo = this.Vetor.length-1;
		this.Vetor = dep;

	}

    public void empilhe(X x) throws Exception
    {

	  //for(int i =0 ; i <= this.Vetor.length-1; i++)
	  	//if(this.Vetor[i] == x)
	    	//throw new Exception("Valor já inserido,porfavor digite outro valor");

		     	//throw new Exception ("Erro valor x inválido");

	     	if(this.topo < this.Vetor.length-1)
	    	{
                topo++;
				this.Vetor[topo] = x;

		    } else
		    {

               this.Cresca();
               topo++;
               this.Vetor[topo] = x;

		    }






    //QUAL SEIA O POSSÍVEL ERRO?


	}

 /*  public X getTopo() throws Exception
   {
        if (this.topo == -1)
              throw new Exception ("Não há nada no vetor");

         return (X)this.vetor[topo];

   //nao entendi essa parte ver dpss...


   }*/

	public void Desempilhe() throws Exception
	{

       //PRECISA PRIMEIRO PEGAR O VALOR PELO GetTopo().

		  Object[] dep = new Object[this.Vetor.length];

          if(this.topo == -1)
             throw new Exception ("Não é possível desempilhar pois topo vale -1... não há valores em Vetor.");
         else
		  {
			  for(int i = 0; i < topo; i++)
		      dep[i] = this.Vetor[i];


              this.topo--;

		      this.Vetor = dep;
	      }








	}

	public boolean Vazia()
	{

    	if(this.topo != -1)
         	return false;

         return true;

	}

	public String toString()
	{
    	String ret;
    	ret = "{";

        ret += "Taxa: "+ this.taxa;
        ret += " Topo: "+ this.topo;

        ret += " Vetor : ";
        for(int i = 0; i<=topo; i++)
       		ret +=  this.Vetor[i] +(i != topo?",":" ");


       		ret += "}";


       return ret;
    }

	public boolean equals(Object obj)
	{
    	if(this == obj)
    		return true;

    	if(obj == null)
    		return false;

    	if(!(obj instanceof Pilha))
    		return false;

    	Pilha dep =(Pilha) obj;

    	if(this.taxa != dep.taxa)
    		return false;

    	if(this.topo != dep.topo)
    		return false;


    	for(int i = 0; i<=topo; i++)
    		if(this.Vetor[i] != dep.Vetor[i])
    	  		return false;



    	return true;
     }


    public int hashCode()
    {
    	int ret = 77;

    	ret = ret*7  + new Integer(this.taxa).hashCode();
        ret = ret*5  + new Integer(this.topo).hashCode();

        for(int i = 0; i <= this.topo;i++)
        ret = ret*11 + new Integer(this.Vetor[i].hashCode()); // Vetor é object então posso usar o hashCode dele.

        return ret;
	}

}