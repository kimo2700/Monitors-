import java.util.Vector;

public class green_uniform  implements Runnable   {
	public static int itr;
	public static monitor clk;
	public static Object convey3=new Object();
	public static Object convey4=new Object();
	public static Object[]  conveys= new Object[14];
	public static Vector<Object> waitingGreen=new Vector<Object>();
	public static Vector<Object> waitingOrange=new Vector<Object>();
	private String num;
	public static int turn=-1;
	private String con="0";
	private Thread thread;
	public green_uniform(String nu) {
		this.con=nu;
		
		this.num="green_"+nu;
		
		this.thread=new Thread(this,num);
		
		}
	public static long time = System.currentTimeMillis();
	public  void msg(String m) {
		 System.out.println(time +num+m);
	}
	 //int k =Integer.parseInt(con);
	
	
	 
	public void start() {
	    thread.start();
	  }
	public void entryGoups() {
		Object convey = new Object();
		synchronized (convey) {
			if (monitor.notReadygreen(convey)) 
				while(true) 
					try {
						convey.wait();break;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
		}
		
		
	}
	 public void enterShow() {
		 Object convey =new Object();
		 synchronized(convey) {
			 monitor.decNumb();
			 if (monitor.showOn(convey))msg("Left the tent");
				 while(monitor.showOn(convey))
					try {
						
						convey.wait();
						monitor.decNumb();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				 
		 }
	 }
	 
	
	
		
	
	public void run() {
		//System.out.println(k);
		synchronized(clock.convey3) {
		try {
			
			
			
			clock.convey3.wait();
		} catch (InterruptedException e) {}}
		msg("arrive");
		
		try {
			thread.sleep((long)Math.random());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg("grouping");
		this.entryGoups();// Enter on group of 2 green and 1 orange student
		
			
		msg("Circuling arround the stadium");
	try {
		Thread .sleep((long)Math.random()*1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		this.enterShow();// show entry
		
		msg("enter the showroom");
		synchronized(clock.convey4) {
			try {
				clock.convey4.wait();// wait to the show to be open
			} catch (InterruptedException e) {// wait to the be
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		monitor.incNumb();
		
		if(monitor.isEmpty()) synchronized(staff.convey5) {staff.convey5.notify();
		}// the last student in the show notifies the staff member
		synchronized(clock.convey3) {
			try {
				
				
				
				clock.convey3.wait();//wait to parade of 12:00pm
			} catch (InterruptedException e) {}}
			msg("arrive");
			try {
				thread.sleep((long)Math.random());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			msg("grouping");
			this.entryGoups();
			
				
			msg("Circuling arround the stadium");
			try {
				Thread .sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(clock.convey3) {// wait to the parade of  1:00pm
				try {
					
					
					
					clock.convey3.wait();
				} catch (InterruptedException e) {}}
				msg("arrive");
				try {
					thread.sleep((long)Math.random());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				msg("grouping");
				this.entryGoups();
				
					
				msg("Circuling arround the stadium");
				try {
					Thread .sleep((long)Math.random()*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		
	
	}
}
