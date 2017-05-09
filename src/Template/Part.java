package Template;

public class Part {
	static List <Factory<? extends Part>> partFactories =  new ArrayList<Factory<? extends Part>>();     static {         partFactories.add(new FuelFilter.Factory());         partFactories.add(new AirFilter.Factory());         partFactories.add(new FanBelt.Factory());         partFactories.add(new PowerSteeringBelt.Factory());     }     private static Random rand = new Random(47);     public static Part createRandom() {         int n = rand.nextInt(partFactories.size());         return partFactories.get(n).create();     }     public String toString() {         return getClass().getSimpleName();     }
}
