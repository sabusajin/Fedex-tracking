package fedex_assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class QueryThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//int ctr=0;
		int n=1;
		Dijkstra path = new Dijkstra();
		try {
			while(n!=0)
			{


				System.out.println(" **************************************************************************************");
				System.out.println("                       Welcome to Fedex Tracking System  ");
				System.out.println(" **************************************************************************************");
				System.out.println();
				System.out.println("Please enter the tracking number");
				Scanner reader = new Scanner(System.in);  // Reading from System.in

				n = reader.nextInt(); // Scans the next token of the input as an int.


				FedexPackage p=Main_Activity.mapper.get(n);
				ArrayList<Integer> f=new ArrayList<Integer>();

				int k = 0;
				int srcno = 0;

				int destno = 0;
				int counter=0;
				String[] cityarray ={"Northborough, MA","Edison, NJ","Pittsburgh, PA","Allentown, PA","Martinsburg, WV","Charlotte, NC","Atlanta, GA","Orlando, FL","Memphis, TN","Grove City, OH","Indianapolis, IN","Detroit, MI","New Berlin, WI", "Minneapolis, MN", "St. Louis, MO", "Kansas, KS", "Dallas, TX", "Houston, TX","Denver, CO","Salt Lake City, UT","Phoenix, AZ","Los Angeles, CA","Chino, CA","Sacramento, CA","Seattle, WA"};
				for(String s:cityarray ){


					if(s.equals(p.getSource()))
						srcno=k;
					else
						k++;
				}
				k=0;
				for(String s:cityarray ){


					if(s.equals(p.getDestination()))
						destno=k;
					else
						k++;
				}
				f= path.getShortestPath(srcno, destno);
				
				for (int r=1;r<f.size()-1;r++)
				{
					if (p.getPresent().equals(cityarray[f.get(r)]))
						counter=r;
						
				}
				if (!(p.getDestination().equals(p.getPresent())))
				{
					

					System.out.println();
					System.out.println("Tracking Number "+n+"\n");
					System.out.println("Package Source -"+p.getSource());
					System.out.println("Package Destination -"+p.getDestination());
					System.out.println();
					System.out.println();
					System.out.println("Your package is IN TRANSIT to "+p.getDestination());
					for (int r=1;r<counter;r++)
					{
						System.out.println("-------------------------------------------------------------");	
					System.out.println("Your package arrived at "+cityarray[f.get(r)]+" sorting facility");
					System.out.println("Your package left "+cityarray[f.get(r)]+" sorting facility");
					
					}
					System.out.println("Your package is currently at "+p.getPresent()+" sorting faccility");

					//System.out.println("-------------------------------------------------------------");

				}

				else
				{
					System.out.println();
					System.out.println("Tracking Number -"+n+"\n");
					System.out.println("Package Source -"+p.getSource());
					System.out.println("Package Destination -"+p.getDestination());
					System.out.println();
					System.out.println();
					//System.out.println("Your package is in transit");
					System.out.println("Your package arrived at "+p.getPresent()+" destination");

					System.out.println("_________________________"+"\n"+"Packet History"+"\n"+"---------------------");

					int m = 0;

					System.out.println("Packet left source facility at "+p.getSource());

					for (m=1;m<f.size()-1;m++)
					{
						System.out.println("Packet arrived at intermediate sorting facility at "+cityarray[f.get(m)]);
					}

					if (m==f.size()-1)
					{
						System.out.println("Packet was delivered to customer address at "+p.getDestination());
					}



				
					//System.out.println("-------------------------------------------------------------");
				}


			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occured due to wrong trackingID. Please check your input!");
			e.printStackTrace();
		}

	}



}
