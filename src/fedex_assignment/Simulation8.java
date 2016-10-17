package fedex_assignment;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import com.mysql.jdbc.PreparedStatement;


public class Simulation8 implements Runnable{


	public void run()
	{
		int i=0;
		int k=0;


		while (k==0)
		{


			for(i=50001;i<=60000;i++)
			{
				Connection conn4 = null;
				Statement stmt4 = null;
				String Source=null, Destination=null, Present=null;
				int weight=0;
				

				try{


					Class.forName("com.mysql.jdbc.Driver");

					//STEP 3: Open a connection

					conn4 = DriverManager.getConnection("jdbc:mysql://localhost/sys?autoReconnect=true&useSSL=false", "root", "admin");


					//STEP 4: Execute a query
					//System.out.println("Creating statement...");
					stmt4 = conn4.createStatement();

					String sql = "SELECT Source, Destination, Present FROM PackageDetails WHERE trackid ="+i;
					ResultSet rs2 = stmt4.executeQuery(sql);
					//STEP 5: Extract data from result set
					while(rs2.next()){
						//Retrieve by column name


						Source = rs2.getString("Source");
						Destination = rs2.getString("Destination");
						Present = rs2.getString("Present");

						// weight= rs.getInt("Weight");


						Main_Activity.mapper.put(i, new FedexPackage(weight,Source,Destination,Present));


					}
					rs2.close();
				}catch(SQLException se){
					//Handle errors for JDBC
					se.printStackTrace();
				}catch(Exception e){
					//Handle errors for Class.forName
					e.printStackTrace();
				}finally{
					//finally block used to close resources
					try{
						if(stmt4!=null)
							conn4.close();
					}catch(SQLException se){
					}// do nothing
					try{
						if(conn4!=null)
							conn4.close();
					}catch(SQLException se){
						se.printStackTrace();
					}//end finally try
				}//end try
			}
			k++;
			//FedexPackage a=Main_Activity.mapper.get(1);
			//System.out.println("3 done");
		}

		//************************************SIMULATION**********************************************//



		while(true)
		{



			try {
				for(i=50001;i<=60000;i++)
				{


					int srcno = 0,destno = 0,weight=0;
					//FedexPackage pack3 = new FedexPackage();
					FedexPackage pack3=new FedexPackage();
					pack3= Main_Activity.mapper.get(i);
					//pack3=Main_Activity.mapper.get(50);
					Dijkstra path=new Dijkstra();

					// String src = null;
					// System.out.println(pack3.getDestination());
					// System.out.println("Present "+pack3.getPresent());


					//System.out.println("ssssssssssssssss");
					//String dest = ;

					ArrayList<Integer> shortest=new ArrayList<Integer>();






					String[] cityarray ={"Northborough, MA","Edison, NJ","Pittsburgh, PA","Allentown, PA","Martinsburg, WV","Charlotte, NC","Atlanta, GA","Orlando, FL","Memphis, TN","Grove City, OH","Indianapolis, IN","Detroit, MI","New Berlin, WI", "Minneapolis, MN", "St. Louis, MO", "Kansas, KS", "Dallas, TX", "Houston, TX","Denver, CO","Salt Lake City, UT","Phoenix, AZ","Los Angeles, CA","Chino, CA","Sacramento, CA","Seattle, WA"};

					k=0;
					
					if (pack3!=null){
					for(String s:cityarray ){

						if(s.equals(pack3.getSource()))
							srcno=k;
						else
							k++;
					}
					k=0;
					for(String s:cityarray ){

						if(s.equals(pack3.getDestination()))
							destno=k;
						else
							k++;
					}
					}
					shortest= path.getShortestPath(srcno, destno);

					//  for ( int f:shortest)
					//  {
					//   System.out.println(path.cityName(f));
					//   }

					FedexPackage packet=new FedexPackage();
					packet=Main_Activity.mapper.get(i);

					/*if(packet.getPresent()==packet.getDestination())

					{

						//System.out.println("here");
						break;

					}	*/
if (packet!=null){

					if (Time_Thread.counter<shortest.size())
					{
						//System.out.println(packet.getPresent()+" "+packet.getDestination()+Time_Thread.counter);

						Main_Activity.mapper.put(i, new FedexPackage(weight, packet.getSource(),packet.getDestination(),cityarray[shortest.get(Time_Thread.counter)]));

					}

					else
					{
						//System.out.println("here");
						Main_Activity.mapper.put(i, new FedexPackage(weight, packet.getSource(),packet.getDestination(),packet.getDestination()));
					}

}



				}
			} catch (Exception e) {
				System.out.println("Exception occured");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					 


		}



	}}