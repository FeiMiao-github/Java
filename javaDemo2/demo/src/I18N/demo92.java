package I18N;

import java.util.Locale;

public class demo92 {
	public static void main(String[] args) {
		new demo92().test();
	}
	
	void test() {
		Locale[] localeList = Locale.getAvailableLocales();
		for (Locale l: localeList) {
			String s0 = l.getDisplayCountry() + "=" + l.getCountry();
			String s1 = l.getDisplayLanguage() + "=" + l.getLanguage();

			System.out.println(s0 + "\t" +s1);
		}
	}
}
