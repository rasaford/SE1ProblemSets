package test;

public class TabletTest {
	public static void main(String[] args) {
		// create Object
		Tablet tablet = new Tablet();
		
		// print inits
		System.out.println(tablet.getScreenSize());
		System.out.println(tablet.getWeight());
		System.out.println(tablet.getWifiOnly());
		
		// set Vars
		tablet.setScreenSize(12.3456f);
		tablet.setWeight(1);
		tablet.setWifiOnly(true);
		
		//get vars again
		System.out.println(tablet.getScreenSize());
		System.out.println(tablet.getWeight());
		System.out.println(tablet.getWifiOnly());
		

	}
	
	//constructor
	TabletTest(){
	}

}
