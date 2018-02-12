package Illuminated;

public class ContadorDeInstancias {
	private static int numInstances = 0;

	protected static int getCount() {
		return numInstances;
	}
	ContadorDeInstancias () {
		numInstances++;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting with " + ContadorDeInstancias.getCount());
		for (int i = 0;i<300;i++) {
			new ContadorDeInstancias();
			System.out.println("Created "+ ContadorDeInstancias.getCount());
		}

	}

}
