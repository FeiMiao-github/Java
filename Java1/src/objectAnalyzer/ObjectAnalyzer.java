package objectAnalyzer;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/**
 * @author FeiMiao
 * */
public class ObjectAnalyzer {
	/**
	 * @param obj an object
	 * @return a string with the object's class name and all field names and values
	 * */
	
	public String toString(Object obj) {
		Class<?> c = obj.getClass();
		int cMNum = c.getModifiers();
		String cM = Modifier.toString(cMNum);
		System.out.print(cM + " class " + c.getName() + "{");
		Field[] f = c.getDeclaredFields();
		System.out.println();
		for (Field fEle: f) {
			String fM = Modifier.toString(fEle.getModifiers());
			String o = fEle.getType().getSimpleName();
			fEle.setAccessible(true);
			System.out.print("\t" + fM + " " + o + " "+ fEle.getName() + " = ");
			Object fEleValue;
			try {
				fEleValue = fEle.get(obj);
				if (o.equals("String"))
					System.out.println("\"" + fEleValue + "\";");
				else
					System.out.println(fEleValue + ";");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println("}");
		return "true";
	}
}
