package interfaces;

public class ImplementsClass implements PetFoodSupplior{

	@Override
	public void eatFood(PetSpecies petSpecies) {
		// generated method stub
		System.out.println("supply pet food!");
	}
	
	@Override
	public void foodSupply() {
		System.out.println("the price: $" + price);
	}
}
