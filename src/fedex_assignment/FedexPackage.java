package fedex_assignment;

import java.util.Random;

public class FedexPackage {
	
               private int trackingNumber;
               private int weight;
               private String source;
               private String destination;
               private String present;
               public String getPresent() {
				return present;
			}

			public void setPresent(String present) {
				this.present = present;
			}
			String[] cityarray ={"Northborough, MA","Edison, NJ","Pittsburgh, PA","Allentown, PA","Martinsburg, WV","Charlotte, NC","Atlanta, GA","Orlando, FL","Memphis, TN","Grove City, OH","Indianapolis, IN","Detroit, MI","New Berlin, WI", "Minneapolis, MN", "St. Louis, MO", "Kansas, KS", "Dallas, TX", "Houston, TX","Denver, CO","Salt Lake City, UT","Phoenix, AZ","Los Angeles, CA","Chino, CA","Sacramento, CA","Seattle, WA"};
			
               
              

			public FedexPackage(int weight, String source, String destination, String present) {
				//super();
				this.weight = weight;
				this.source = source;
				this.destination = destination;
				this.present = present;
			}

			public FedexPackage() {
				// TODO Auto-generated constructor stub
			}

			public FedexPackage(String present) {
				// TODO Auto-generated constructor stub
				this.present=present;
				
			}

			public void generateSource(){
           		Random randomGenerator = new Random();
           		int src=randomGenerator.nextInt(cityarray.length);
           		source=cityarray[src];
           		
           	}
           	
           	public void generateDestination(){
           		Random randomGenerator = new Random();
           		int dest=randomGenerator.nextInt(cityarray.length);
           		if (cityarray[dest]==source)
           			{
           			if (dest!=23)
           			
           				{dest=23;}
           			else
           				{dest=22;}
           	}
           	destination=cityarray[dest];
           		
           	}
           	
           	public void generateWeight(){
           		Random randomGenerator = new Random();
           		weight=randomGenerator.nextInt(15);
           		
           		
           	}
           	
           	public void generateId(){
           		Random randomGenerator = new Random();
           		trackingNumber=randomGenerator.nextInt(999999999);
           		
           		
           	}     
               
               
               
               public int getTrackingNumber() {
				return trackingNumber;
			}
			public void setTrackingNumber(int trackingNumber) {
				this.trackingNumber = trackingNumber;
			}
			public int getWeight() {
				return weight;
			}
			public void setWeight(int weight) {
				this.weight = weight;
			}
			public String getSource() {
				return source;
			}
			public void setSource(String source) {
				this.source = source;
			}
			public String getDestination() {
				return destination;
			}
			public void setDestination(String destination) {
				this.destination = destination;
			}
               
               
               

}
