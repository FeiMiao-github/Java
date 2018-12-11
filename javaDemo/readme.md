
* demo1: 对象、引用和指针
* demo2: 返回this
* demo3: 参数的传递机制
* demo4: 参数可变的方法
* demo5: 递归运算
* demo6: 静态导入
* demo7: 测试静态导入实例
> 多个源文件的使用， 详情见java核心编程第十版4.3.2多个源文件的使用
> 1. `javac Employee*.java` 使用通配符
* demo8: 构造器中调用构造器
> 被调用的构造器应该放在代码块的第一行，具体见demo8
* demo9: 重写父类方法
* demo10: 继承覆盖父类变量
* demo11: 关于父类成员变量和子类成员变量的访问
* demo12: 父类构造器调用
* demo13: 多态方法调用
* demo14: 文件输入输出尝试
* demo15: 引用变量的强制类型转换
* demo16: instanceof 运算符
> 在引用变量进行强制类型转换时，为了避免异常， 可以首先用 instanceof 进行判断是否可以转换成功
* demo17: 使用继承时的注意点
* demo18: java类的新成员，初始化代码块
> 运行顺序: 类成员变量(class fields) -> 静态代码块 -> 类对象成员变量(instance fields) ->代码块 -> 对象构造器
> 类创建的时候加载类成员  类对象创建的时候加载类对象成员
* demo19: 一个关于自动装箱、自动拆箱的不重要的问题  
* demo20: Object toString() 方法和 hashCode() 方法
* demo21: `==` 和 `equals()` 方法
* demo22: 重写 `equals()` 方法
* demo23: 单例类 (singleton)
* demo24: `final` 修饰符修饰变量
* demo25: `final` 修饰基本变量类型和引用变量的区别
* demo26: 编译时确定变量的值还是运行时确定编译的值
* demo27: final 方法重写
> private 方法不可被重写
* demo28: 不可变类就是实例的实例变量是不可变的类
* demo29: 引用类型变量指向的对象不可变
* demo30: 缓存实例的不可变类
