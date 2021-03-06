public class Pilha<X>
{
   //O usuario s� pode mecher com o topo
   private int topo; //Controlara o tamanho da pilha
   private Object[] vetor;
   private float taxaDeCrescimento;


  public Pilha (int tam, float tc) throws Exception
  {
     if(tam <= 0)
       throw new Exception("Tamanho invalido");

     if(tc <= 0)
      throw new Exception("Taxa invalida");

     this.iniciacao(tam,tc);
  }
  private void iniciacao(int tam, float tc)
  {
      this.vetor   = new Object[tam];
      this.topo    = -1;
      this.taxaDeCrescimento = tc;
  }

  private void iniciacao()
  {
	  this.iniciacao(10); //A pilha tera inicialmente 10 posicoes
  }

  public Pilha (int tam) throws Exception
  {
	  if(tam <= 0)
	    throw new Exception("Tamanho invalido!");

	  this.iniciacao(tam);
  }

  private void iniciacao(int tam)
  {
	  this.iniciacao(tam,10/*por cento*/);
  }
  public Pilha()
  {
	  this.iniciacao();
  }

  private void cresca()
  {
     float multiplicador = (this.taxaDeCrescimento/100)+1;
     int tamNovo         = Math.round(this.vetor.length* multiplicador);

     Object[] novoVet =  new Object[tamNovo];

     //Copiar todos os elementos ja existentes no vetor antigo para o novo
     for(int i = 0; i <= this.topo; i++)
         novoVet[i] = this.vetor[i];

     this.vetor = novoVet;

  }

  public X getTopo() throws Exception
  {
    // retornar sempre o que esta no topo
	  if(this.topo == -1) //Quer nao ha elementos guardados
	    throw new Exception("Nao ha elementos a serem retornados!");

	  return (X)this.vetor[topo];
  }
  public X desempilhe() throws Exception
  {
	  if(this.vazia())
	    throw new Exception("Ja esta vazia!");

	  X aux = (X)this.vetor[this.topo];
	  this.vetor[this.topo--] = null;

	  return aux;
  }
  public boolean vazia()
  {
	 if (this.topo == -1) //Posicao -1 indica que nao ha nada
	  return true;

     return false;
  }
  public void empilhe(X x) throws Exception
  {
	  //for(int i = 0; i <= this.topo; i++)
      //  if(this.vetor)
       if(x==null)
         throw new Exception("Insercao invalida");

       if(this.topo == this.vetor.length-1)
           this.cresca();

      // if(x instanceof Cloneable)
       //   this.vetor[++topo] = this.meuCloneDeX(x);

    //  else
         this.vetor[++topo] = x;
  }

 /*private X meuCloneDeX(X x)
 {
	 X ret = null;

	 try
	 {
       Class<?> classe = x.getClass();
       Class<?>[] tipoParametroFormal = null; //null porque no clone nao ha parametro
       Method metodo = classe.getMethod("clone", tipoParametroFormal);
       Object[] parametroReal = null; //null tambem porque nao ha parametros no clone
       ret = (X)metodo.invoke(x,parametroReal);
	 }
	 catch(NoSuchMethodException erro1)
	 {}
	 catch(InvocationTargetException erro2)
	 {}
	 catch(IllegalAccessException erro3)
	 {}

	 return ret;
 }
 */

 public boolean equals(Object obj)
 {
	 if(obj==null)
	   return false;

	 if(this==obj) //Possuem a mesma instancia
	   return true;

     if(!(obj instanceof Pilha))
       return false;

     Pilha pil = (Pilha)obj;

   	 if(!(this.topo == (pil.topo)))
      	return false;

   	 if(!(this.taxaDeCrescimento == (pil.taxaDeCrescimento)))
      	return false;

   	 for(int i = 0; i<= this.topo; i++)
    	if(!(this.vetor[i].equals(pil.vetor[i])))
      		return false;

    return true;
 }

 public String toString()
 {
	 String ret = "{";

	 ret += "Topo vale :"+ this.topo;
	 ret += "Taxa De Crescimento : "+ this.taxaDeCrescimento;

	 ret += " Vetor:{";

  	 for(int i = 0 ; i <= this.vetor.length-1;i++)
         ret += this.vetor[i] + (i!=this.vetor.length?",":"");

     ret += "}  }";

	 return ret;

 }
 public int HashCode()
 {
	 int ret = 23;

	 ret = ret * 3 /*primo*/ + new Integer (this.topo).hashCode();

	 for(int i = 0; i <= this.topo; i++)
        ret = ret * 3 + this.vetor[i].hashCode();

    return ret;
 }
 // Na main Pilha<integer> b = new Pilha<Integer>a.clone();
 // Ou Pilha<integer> b = new Pilha<integer>(a);
 public Pilha (Pilha modelo) throws Exception
 {
    if(modelo==null)
      throw new Exception("Modelo invalido");

    this.vetor = new Object[modelo.vetor.length];

     for(int i = 0; i <= this.topo; i++)
       //if(this.vetor[i] instanceof Cloneable) // Se ele na main fez uma instancia clone ao inves de passar direto o modelo na instancia
         // this.vetor[i] = this.meuCloneDeX(modelo.vetor[i]);

      // else
           this.vetor[i]= modelo.vetor[i];

     this.topo = modelo.topo;
     this.taxaDeCrescimento = modelo.taxaDeCrescimento;
 }

 public Object clone()
 {
	 Pilha ret = null;

	 try
	 {
        ret = new Pilha(this);
	 }
	 catch(Exception erro)
	 {}

	return ret;
 }

}