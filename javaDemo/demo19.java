import jdk.jfr.Unsigned;

// 一个关于自动装箱、自动拆箱的不重要的问题

public class demo19 {
    public static void main(String[] args) {
        Boolean boolObj = true;
        boolean booleanObj = boolObj;

        System.out.println("booleanObj..." + booleanObj);

        booleanObj = Boolean.parseBoolean("true");
        System.out.println("booleanObj..." + booleanObj);

        //Q
        System.out.println((char) (Character.PRIVATE_USE));
        
        Byte byteObj = Byte.parseByte("127");
        System.out.println("byteObj..." + byteObj);

        Integer a = 3;
        Integer b = 3;
        System.out.println("a==b ?????");
        System.out.println(a == b);
        // 见源码

        a = 128;
        b = 128;
        System.out.println("a==b ?????");
        System.out.println(a == b);
        // a 和 b 是引用变量，地址不同

        Byte cString = Demo.valueOf("107", 4);
        System.out.println(cString);
    }
}

class Demo {
    public static final byte   MIN_VALUE = -128;
    public static final byte MAX_VALUE = 127;
    
    public static Byte valueOf(String s, int radix)
            throws NumberFormatException {
        return valueOf(parseByte(s, radix));
    }
    
    public static Byte valueOf(byte b) {
        final int offset = 128;
        System.out.println("cache[(int) b + offset] = " + ByteCache.cache[(int)b + offset]);
        return ByteCache.cache[(int) b + offset];
    }
    
    public static byte parseByte(String s, int radix)
            throws NumberFormatException {
        int i = Integer.parseInt(s, radix);
        if (i < MIN_VALUE || i > MAX_VALUE)
            throw new NumberFormatException("Value out of range. Value:\"" + s + "\" Radix:" + radix);
        return (byte) i;
    }
    
        private static class ByteCache {
        private ByteCache(){}

        static final Byte cache[] = new Byte[-(-128) + 127 + 1];

        static {
            for(int i = 0; i < cache.length; i++)
                cache[i] = (byte)(i - 128);
        }
    }
}