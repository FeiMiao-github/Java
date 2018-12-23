
# readme
## 1
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
* demo16: `instanceof` 运算符
    > 在引用变量进行强制类型转换时，为了避免异常， 可以首先用 instanceof 进行判断是否可以转换成功
* demo17: 使用继承时的注意点
* demo18: java类的新成员，初始化代码块
    > 运行顺序: 类成员变量 (class fields) -> 静态代码块 -> 类对象成员变量 (instance fields) ->代码块 -> 对象构造器
    > 类创建的时候加载类成员  类对象创建的时候加载类对象成员
* demo19: 一个关于自动装箱、自动拆箱的不重要的问题  
* demo20: Object toString() 方法和 hashCode() 方法
* demo21: `==` 和 `equals()` 方法
* demo22: 重写 `equals()` 方法
* demo23: 单例类 (singleton)
* demo24: `final` 修饰符修饰变量
* demo25: `final` 修饰基本变量类型和引用变量的区别
* demo26: 编译时确定变量的值还是运行时确定编译的值
* demo27: `final` 方法重写
> private 方法不可被重写
* demo28: 不可变类就是实例的实例变量是不可变的类
* demo29: 引用类型变量指向的对象不可变
* demo30: 缓存实例的不可变类
* demo31: 定义一个抽象类
* demo32: 模板设计模式
* demo33：更加彻底的抽象类 ----- 接口
    > Q1: 测试抽象类中的变量是否转换为静态 `public final` 变量
* demo34: 可执行"宏替换"的 `final` 变量
* demo35: 接口之间的多继承
* demo36: 接口的三种功能
    > * 声明变量
    > * 调用接口中定义的常量
    > * 被其它类实现
* demo37: 简单工厂模式
* demo38：命令模式
* demo39: 使用匿名内部类重构 demo38
* demo40: 内部类同名变量访问
* demo41: 外部类访问内部类变量
* demo42: 静态类变量访问规则
* demo43: 使用内部类
* demo44：访问内部类的构造器
* demo45: 匿名内部类
* demo46: 对于匿名内部类的变量自动使用 final 修饰
* demo47: 命令模式2
* demo48: 使用Lambda表达式
* demo49: Lambda表达式的几种简化写法

# 2
<strong>./run_java.ps1 使用方法</strong>
./run_java.ps1 -FileName 无后缀文件名或路径, 如:
>`./run_java.ps1 -FileName demo1`

>`./run_java.ps1 -FileName demo9`