import java.util.Vector;


	public class staff  implements Runnable   {
		public static int itr;
		public static Object convey5=new Object();
		public static Object convey3=new Object();
		//public static Object convey4=new Object();
		public static Object[]  conveys= new Object[14];
		//public static Vector<Vector> Group=new Vector<Vector()>();
		public static Vector<Object> waitingGroup2=new Vector<Object>();
		private String num;
		public static int turn=-1;
		private String con="0";
		private Thread thread;
		public staff(String nu) {
			this.con=nu;
			turn++;
			this.num="staff"+nu;
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
		public void callThestudent() {
			
			synchronized(convey5) {
				if (!(monitor.isEmpty()))
					while(true)
						try {
							convey5.wait();msg("student can enter the show now");break;
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}}
				while(monitor.waitingTheshow.size()>0) {
					synchronized(monitor.waitingTheshow.elementAt(0)) {// releasing the student left outside the tent in FCFS ORDER
					monitor.waitingTheshow.elementAt(0).notify();
					}
					monitor.waitingTheshow.removeElementAt(0);}
			
		}
		public void run() {
			synchronized (clock.convey4){// wait to the end of the show 
				try {
					clock.convey4.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		this.callThestudent();
		synchronized (clock.convey4){
			try {
				clock.convey4.wait();// wait untill the end of the second show
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	this.callThestudent();
			
		}

}
