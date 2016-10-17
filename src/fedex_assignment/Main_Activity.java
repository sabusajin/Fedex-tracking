

//*********************************Program to simulate Fedex tracking system**************************************
//Sajin Sabu


package fedex_assignment;

import java.util.HashMap;
import java.util.Map;




public class Main_Activity {

	public static final Map<Integer, FedexPackage> mapper = new HashMap<Integer, FedexPackage>();

	public static void main(String[] args) {


//Simulation Threads
		Thread simuthread1 = new Thread(new Simulation1());
		Thread simuthread2 = new Thread(new Simulation2());		
		Thread simuthread3 = new Thread(new Simulation3());
		Thread simuthread4 = new Thread(new Simulation4());
		Thread simuthread5 = new Thread(new Simulation5());
		Thread simuthread6 = new Thread(new Simulation6());
		Thread simuthread7 = new Thread(new Simulation7());
		Thread simuthread8 = new Thread(new Simulation8());
		Thread simuthread9 = new Thread(new Simulation9());
		Thread simuthread10 = new Thread(new Simulation10());

//Thread to calculate time		
		Thread timethread = new Thread(new Time_Thread());

//Query Thread		
		Thread query = new Thread(new QueryThread());
		
		timethread.start();

		simuthread1.start();
		simuthread2.start();
		simuthread3.start();
		simuthread4.start();
		simuthread5.start();
		simuthread6.start();
		simuthread7.start();
		//simuthread8.start();
		//simuthread9.start();
		//simuthread10.start();

		query.start();

		// TODO Auto-generated method stub

	}

}
