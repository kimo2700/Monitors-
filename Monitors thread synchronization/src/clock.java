import java.util.Vector;

public class clock implements Runnable {
	public static int itr;

	public static Object convey3=new Object();
	public static Object convey4=new Object();
	public static Object[]  conveys= new Object[14];
	//public static Vector<Vector> Group=new Vector<Vector()>();
	public static Vector<Object> waitingGroup2=new Vector<Object>();
	private String num;
	public static int turn=-1;
	private String con="0";
	private Thread thread;
	public clock(String nu) {
		this.con=nu;
		turn++;
		this.num="clock"+nu;
	//System.out.println(con);
		
		this.thread=new Thread(this,num);
		
		}
	public void start() {
	    thread.start();
	  }
	
	public static long time = System.currentTimeMillis();
	public  void msg(String m) {
		 System.out.println(time +num+m);
	}
public void run() {
	msg("Parade 11:00am start");
	try {
		thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	synchronized(convey3) {
		
		
convey3.notifyAll();
}
	try {
		thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	monitor.numb=0;// set the numb to zero again
	msg("show 11:15am start");
	try {
		thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	synchronized(convey4) {
		
		
		convey4.notifyAll();// notified the staff member that the show ends
		msg("end the show of 11:15am");
		}
	try {
		thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	msg("Parade 12:00am start");
	synchronized(convey3) {
		
		
		convey3.notifyAll();// the student can enter now
		}
	msg("show 12:45am start");
	monitor.numb=0;// set the numb to zero again
	try {
		thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	synchronized(convey4) {
		
		msg("end the show of 12:155am");
		convey4.notifyAll();// notified the staff member that the show ends
		
		}try {
			thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg("Parade 1:00pm start");
		synchronized(convey3) {
			
			
			convey3.notifyAll();// the student can enter now
			}
		try {
			thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	
	
}
}
