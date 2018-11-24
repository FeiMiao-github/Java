package interfaces;

public class Dog extends Animal implements PetStore {
	public String name = null;
	
	public Dog(String name) {
		this.name = name;
	}
	
	@Override
	public void eatFood(PetSpecies p) {
		if (this.getClass().getSimpleName().equals(p.name()))
			System.out.print(this.name + " is a " + p.name());
		else
			System.out.print(this.name + " is not a(an) " + p.name() 
				+ "It is a " + getClass().getSimpleName());
		System.out.println(" and it likes eatting bones!");
	}
}
