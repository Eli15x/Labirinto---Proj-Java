package projeto.pkg2;

/**
 * Classe com o proposio de instanciar e possibilitar a cria?ao da pilha do labirinto
 * @author @u15164 @17171  @17165
 * @param <X> recebe as coordenadas da classe coordenada
 */
public class Pilha<X>
{
   //O usuario s? pode mecher com o topo
   private int topo; //Controlara o tamanho da pilha
   private Object[] vetor;
   private float taxaDeCrescimento;

/**
 *
 * @param tam tamanho da pilha
 * @param tc taxa de crescimento para aumento da pilha
 * @throws Exception caso os valores sejam inv?lidos, lan?a a excessao
 */
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
/**
 * Aumenta o tamanho da pilha com base na taxa de crescimento quando encher
 */
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
/**
 *
 * @return retorna o topo da pilha
 * @throws Exception caso n?o h? elementos lan?a excessao
 *
 */
  public X getTopo() throws Exception
  {
    // retornar sempre o que esta no topo
	  if(this.topo == -1) //Quer nao ha elementos guardados
	    throw new Exception("Nao ha elementos a serem retornados!");

	  return (X)this.vetor[topo];
  }
  /**
   *
   * @return retorna a pilha desempilhada
   * @throws Exception Caso a pilha ja esteja vazia, lan?a excessao
   */
  public X desempilhar() throws Exception
  {
	  if(this.vazia())
	    throw new Exception("Ja esta vazia!");

	  X aux = (X)this.vetor[this.topo];
	  this.vetor[this.topo--] = null;

	  return aux;
  }
  /**
   * Desempilha da pilha
   * @throws Exception caso esteja vazia, impedindo-o de desempilhar. Lança excessao
   */
 public void desempilhe() throws Exception
 {

     //PRECISA PRIMEIRO PEGAR O VALOR PELO GetTopo().

 	Object[] dep = new Object[this.vetor.length];

  		if(this.vazia())
    		throw new Exception ("N?o ? poss?vel desempilhar pois topo vale -1... n?o h? valores em Vetor.");


  	for(int i = 0; i < topo; i++)
  		dep[i] = this.vetor[i];


  	this.topo--;

  this.vetor = dep;
}

  /**
   *
   * @return retorna false caso esteja vazia
   */
  public boolean vazia()
  {
	 if (this.topo == -1) //Posicao -1 indica que nao h? nada
	  return true;

     return false;
  }
  /**
   *Empilha no vetor
   * @param x parametro do tipo X que serve como valor a empilhar
   * @throws Exception caso o valor seja nulo, lan?a excessao
   */
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
/**
 * M?todo que realiza a compara??o entre objetos
 * @param obj vindo da classe obj servindo para compararmos objetos
 * @return retorna true caso os objetos sejam compar?veis
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
/**
 *
 * @return retorna a string ret para auxiliar na exibi??o
 */
 public String toString()
 {
	 String ret = "{";

	 ret += "Topo vale :"+ this.topo;
	 ret += "Taxa De Crescimento : "+ this.taxaDeCrescimento;

	 ret += " Vetor:{";

   for(int i = 0 ; i <= this.vetor.length-1;i++)
         ret += this.vetor[i] +",";

     ret += "}  }";

	 return ret;

 }
 /**
 * Organiza os elementos da classe
 * @return retorna a variavel ret calculada no m?todo
 */
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
/**
    * Construtor de c?pia para fazermos c?pias e evitar que usu?rios causem acidentes na classe
    * @param modelo representa a c?pia da classe
    * @throws Exception Caso modelo seja nulo, lan?a a excessao sobre seu valor inv?lido
    */
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
/**
 * Metodo para clonar a classe fila
 * @return retorna a variavel ret do tipo fila clonada
 */
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