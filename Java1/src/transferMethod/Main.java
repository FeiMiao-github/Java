package transferMethod;
/** @see https://www.zhihu.com/question/31203609 */
public class Main {
	/** @throws ת����link��ַ */
	
	public static void main(String[] args) {
		int num = 3;
		String str = "hello";
		
		/* �������� */
		setValue(num);
		System.out.println("num = " + num);
		/* OUTPUT:
		 * num = 3
		 * */
		
		/* û���ṩ�ı����������������� */
		setString(str);
		System.out.println(str);
		/* OUTPUT:
		 * hello
		 * */
		
		/* �ṩ�˸ı����������������� */
		StringBuilder sB = new StringBuilder("Linux");
		setSB(sB);
		System.out.println(sB);
		/* OUTPUT:
		 * Linux��ơ!
		 * */
		
		/* �ṩ���޸�����ķ�������������,���ǲ�ʹ��.*/
		/* ����ʹ�ø�ֵ�����*/
		setSb(sB);
		System.out.println(sB);
		/* OUTPUT:
		 * Linux��ơ!
		 * */
		
	}
	
	public static void setValue(int value) {
		value = 10;
	}
	
	public static void setString(String text) {
		text = "Windows";
	}
	
	public static void setSB(StringBuilder builder) {
		builder.append("��ơ!");
	}
	
	public static void setSb(StringBuilder builder) {
		builder = new StringBuilder("ţơ!");
	}

}
