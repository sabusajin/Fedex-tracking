package fedex_assignment;

public class Time_Thread implements Runnable{

	static int counter=0;

	public void run()
	{
		try{

			if (counter==0)
			{
				Thread.sleep(15000);             //give 15 sec delay at the begin
			}

			while(counter<15)
			{





				Thread.sleep(5000);             //give 5 second delay each time before incrementing counter
				counter++;

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}



}
