package interfaces;

public interface PetFoodSupplior extends PetStore{
	/* 接口继承*/
	
	/* 默认设置为public */
	default void foodSupply() {
		System.out.println("default implements");
	}
	
	static void welcome() {
		System.out.println("welcome to the PetWorld!");
	}
	
	int price = 10;/* 默认设置为public static  final */
}
