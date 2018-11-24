package interfaces;

public interface PetStore {
	public void eatFood(PetSpecies petSpecies);
	public default void say() {
		System.out.println("Food!");
	}
}
