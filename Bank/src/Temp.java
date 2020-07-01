class Calci
{
	String args[];
	public Calci(String args[]){
		this.args=args;
	}
	public void display(){//10 20 30
		int sum=0;
		for(int i=0;i<args.length;i++){
		sum=sum+Integer.parseInt(args[i]);	
		}
		System.out.println("Sum is :"+sum);
	}
}
class Demo implements Runnable
{
	Calci c;
	public Demo(Calci c){
		//Thread t1=new Thread(this);
		//t1.start();
		this.c=c;
		new Thread(this).start();
	}
	public void run(){
		c.display();
	}
}
public class Temp {
	public static void main(String[] args) {
	Calci c=new Calci(args);
	Demo d1=new Demo(c);
		//Thread t1=new Thread(d1);
		//t1.start();
	}
}