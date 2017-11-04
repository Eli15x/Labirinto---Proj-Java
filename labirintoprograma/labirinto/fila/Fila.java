package labirintoprograma.labirinto.fila;

import java.lang.reflect.*;

/**
 *  Classe com o proposio de instanciar e possibilitar a cria�ao de Filas
 * @author @u15164 @17165  @17171 
 * @param <X> recebe o sua classificacao, pois a classe e generica
 */
public class Fila<X>
{
    protected int inicio, fim, qtd,Controlador;
    protected Object[] vetor;
    protected float taxaDeCrescimento;     

   /**
    * Constructor da classe, no qual na se passa parametros
    * */ 
   public Fila()
   {
        this.iniciacao();
   }

   protected void  iniciacao()
   {
   	this.iniciacao(10);
   }

   protected void iniciacao(int tam)
   {
   	this.iniciacao(tam,10/*por cento*/);
   }

   protected void iniciacao(int tam,float tc)
   {
   	this.vetor  = new Object[tam];
   	this.inicio = 0;
   	this.fim    = -1;
   	this.qtd    = 0;
   	this.taxaDeCrescimento = tc;
   	this.Controlador = -1;
   }
   
   /** 
    * @param tam passa o tamanho do vetor
    * @throws Exception caso o tamanho n�o seja v�lido lan�a excessao 
    */

   public Fila(int tam) throws Exception
   {
	   this.iniciacao(tam);
   }   

   /**
    * 
    * @param tam passa o tamanho do vetor
    * @param tc  passa a taxa de crescimento
    * @throws Exception caso o tamanho seja inv�lido ou a taxa de crescimento lan�ando excessao
    */
   public Fila(int tam, float tc) throws Exception
   {
   	if(tam<=0)
            throw new Exception("Tamanho invalido!");

   	 if(tc<=0)
            throw new Exception("Taxa de crescimento invalida!");

   	 this.iniciacao(tam,tc);
   }

   protected void cresca()
   {
        float multiplicador = (this.taxaDeCrescimento/100) +1;
        int tamNovo         = Math.round(this.vetor.length*multiplicador);

        Object[] novoVet = new Object[tamNovo];

        for(int i=0; i<=this.fim;i++) //Usar this.fim ou this.vetor.length?
            novoVet[i] = this.vetor[i]; // no novo vetor fazer com que a minha posicao zero receba o da ultima

        this.vetor = novoVet; //Atualizar o meu vetor com o tamanho aumentado
   }
   
   /**
    * @return retorna falso caso exista algo na variavel diferente de 0
    */
   public boolean vazia()
    {
        if(this.qtd==0)
                return true;

        return false;
   }

   protected void ColocarNoInicio(X x)
   {
   		this.Controlador++;
		this.vetor[Controlador] = x;

    	if(Controlador == this.inicio-1)
    	{
                this.inicio = 0;
    		this.Controlador = -1;
   		}
   }
   
   /** 
    * @param x valor para ser enfileirado
    * @throws Exception caso seja nulo lan�ando a excessao
    */   
   public void enfileire(X x) throws Exception
   {
   	  	if(x==null)
   	  		throw new Exception("Paramentro para enfileirar invalido!");

      	if(this.fim==this.vetor.length-1){      	
                if(this.inicio == 0){
                this.cresca();
                this.vetor[++this.fim] = x;
	    	}
   	    	else
		ColocarNoInicio(x);
      	}
      	else{
      	this.vetor[++this.fim] = x; //aqui ele ja est� atribuindo um novo valor para this.fim que � this.fim+1;
	}

   	  this.qtd++;
   }
   
  /**
   * Metodo que desenfileira o que esta no inicio da fila
   * @throws lanca-se excecao quando a fila ja se encontra vazia, logo nao a o que desenfileirar
   * */
   
   public void desenfileire() throws Exception
   {
   		if(this.vazia())
   			throw new Exception("Nao ha como remover, pois nao ha conteudo!");
   		//inicio recebe null e aumenta o inicio
   		this.vetor[inicio++] = null;
   		this.qtd--;
   }

   /**
    * @return retorna o elemento X da qual a classe Generica e.
    * @throws Exception  caso nao exista fila a ser retornada lan�ando excessao 
    */
   public X getFila() throws Exception
   {
   		if(this.vazia())
   			throw new Exception("Nao ha filinha a ser retornada");

        return (X)this.vetor[inicio];
   }
   
   /**
    * @return retorna a string ret para auxiliar na exibi��o 
    */
   public String toString()
   {
   		String ret = "{";

        for(int i = 0 ; i <= this.fim;i++)
        	 ret += this.vetor[i] + (i!=this.fim?",":"");

   		ret += "}";

   		return ret;
   }
   
   /**
    * Organiza os elementos da classe
    * @return retorna a variavel ret calculada no m�todo
    */
   public int hashCode()
   {
   		int ret = 9;

   	    ret = ret * 3 + new Integer(this.inicio).hashCode();

   		for(int i = 0; i <= this.fim; i++)
   			ret = ret * 3 /*primo qualquer*/ + this.vetor[i].hashCode();


   	    ret = ret * 3 + new Integer(this.fim).hashCode();

   	    ret = ret * 3 + new Integer(this.qtd).hashCode();

   	    ret = ret * 3 + new Float(this.taxaDeCrescimento).hashCode();

   	    return ret;
   }

   /**
    * M�todo que realiza a compara��o entre objetos
    * @param obj vindo da classe obj servindo para compararmos objetos
    * @return retorna true caso os objetos sejam compar�veis
    */
   public boolean equals(Object obj)
   {
   		if(obj==null)
   			return false;

   		if(this==obj) // se possuem a mesma intancia
   			return true;

   		if(!(obj instanceof Fila))
   			return false;

   		Fila fil = (Fila)obj; //convencer o java que de fato obj e um objeto de fila

   		if(!(this.inicio==fil.inicio))
   			return false;

   		if(!(this.fim==fil.fim))
   			return false;

   		if(!(this.qtd==fil.qtd))
   			return false;

   		if(!(this.taxaDeCrescimento==fil.taxaDeCrescimento))
   			return false;

   		for(int i = 0; i <= this.fim; i++)
   			if(!(this.vetor[i].equals(fil.vetor[i])))
   				return false;

   		return true;
   }

 protected X meuCloneDeX(X x)
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
    catch(Exception erro1)
    {}

    return ret;
   }  
 
 /**
  * Construtor de c�pia para fazermos c�pias e evitar que usu�rios causem acidentes na classe
  * @param modelo representa a c�pia da classe 
  * @throws Exception Caso modelo seja nulo, lan�a a excessao sobre seu valor inv�lido
  */
   public Fila (Fila modelo) throws Exception
   {
        if(modelo == null)
                throw new Exception("Modelo passado e invalido");

        this.vetor  = new Object[modelo.vetor.length];

        for(int i = 0; i <= this.fim; i++)
         if(this.vetor[i] instanceof Cloneable)
             this.vetor[i] = this.meuCloneDeX((X)modelo.vetor[i]);
         else
            this.vetor[i] = modelo.vetor[i];
        
   	// atribuir agora o valor das variaveis
        this.inicio   = modelo.inicio;
        this.fim      = modelo.fim;
        this.qtd      = modelo.qtd;
        this.taxaDeCrescimento = modelo.taxaDeCrescimento;
   }
   
   /**
    * Metodo para clonar a classe fila
    * @return retorna a variavel ret do tipo fila clonada
    */
   public Object clone()
   {
    Fila ret = null;

    try
    {
            ret = new Fila(this);

    }
    catch(Exception erro)
    {} //ignoro, pois o this nunca e null

    return ret;
   }

 }