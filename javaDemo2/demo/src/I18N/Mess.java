package I18N;

import java.util.ListResourceBundle;

/*
 * Java也允许使用类文件来替代资源文件
 * 需要满足如下条件：
 * 1. 该类的类名必须是baseName_language_country
 * 2. 该类必须继承 ListResourceBundle, 并重写 getContents, 该方法返回 Object 数组
 * */
public class Mess extends ListResourceBundle {
	private final Object myData[][] = {
			{"msg", "{0}，你好！今天的日期是{1}"},
	};
	
	public Object[][] getContents() {
		return myData;
	}
}
