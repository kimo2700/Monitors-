import java.util.Vector;

public class main {
	public static clock clk;
	public static clock clk2;
	public static staff staf;
	public static green_uniform [] tor;
	public static orange_uniform [] tor1;	
	public static void main(String args[]) throws InterruptedException  {
		
		
		tor1= new orange_uniform[Integer.parseInt(args[1])];
		
		tor= new green_uniform[Integer.parseInt(args[0])];
		
		for (int x=0; x<Integer.parseInt(args[1]); x++) {
		    
			tor1[x]= new orange_uniform(Integer.toString(x));    
	   }
		for (int x=0; x<Integer.parseInt(args[1]); x++) {
			tor1[x].start();
		}
		for (int x=0; x<Integer.parseInt(args[0]); x++) {
		    
		tor[x]= new green_uniform(Integer.toString(x));    
	   }
		for (int x=0; x<Integer.parseInt(args[0]); x++) {
			tor[x].start();
		}
		
		clk=new clock("1");
		clk.start();
		staf=new staff("1");
		staf.start();
		
	}

}
