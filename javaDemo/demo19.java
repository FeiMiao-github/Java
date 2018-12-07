import jdk.jfr.Unsigned;

// 一个关于自动装箱、自动拆箱的不重要的问题

public class demo19 {
    public static void main(String[] args) {
        // Boolean boolObj = true;
        // boolean booleanObj = boolObj;

        // System.out.println("booleanObj..." + booleanObj);

        // booleanObj = Boolean.parseBoolean("true");
        // System.out.println("booleanObj..." + booleanObj);

        // //Q
        // System.out.println((char) (Character.PRIVATE_USE));
        
        // Byte byteObj = Byte.parseByte("127");
        // System.out.println("byteObj..." + byteObj);

        // Integer a = 3;
        // Integer b = 3;
        // System.out.println("a==b ?????");
        // System.out.println(a == b);
        // // 见源码

        // a = 128;
        // b = 128;
        // System.out.println("a==b ?????");
        // System.out.println(a == b);
        // // a 和 b 是引用变量，地址不同

        // Byte cString = Demo.valueOf("107", 4);
        // System.out.println(cString);

        int radix = 2;

        try{
            int i = TestInt.parseInt("107", radix);
            System.out.println(i  + ", i");
        } catch (Exception e) {
            System.out.println(e.toString() + "hahaha");
        }
        
        int digit = Character.digit('4', radix);
        System.out.println(digit + "= digit");
        System.out.println(((int) '4') + ", \'4\'");
        
        digit = Character.digit(4, 4);
        System.out.println(digit + "= digit");

        // digit = CharacterData.of(digit).digit(digit, radix);
        // System.out.println(digit + "= digit");
    }
}

class Demo {
    public static final byte   MIN_VALUE = -128;
    public static final byte MAX_VALUE = 127;
    
    public static Byte valueOf(String s, int radix)
            throws TestNumberFormatException {
        return valueOf(parseByte(s, radix));
    }
    
    public static Byte valueOf(byte b) {
        final int offset = 128;
        System.out.println("cache[(int) b + offset] = " + ByteCache.cache[(int)b + offset]);
        return ByteCache.cache[(int) b + offset];
    }
    
    public static byte parseByte(String s, int radix)
            throws TestNumberFormatException {
        int i = Integer.parseInt(s, radix);
        if (i < MIN_VALUE || i > MAX_VALUE)
            throw new TestNumberFormatException("Value out of range. Value:\"" + s + "\" Radix:" + radix);
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

class TestInt {
    public static int parseInt(String s, int radix)
                throws TestNumberFormatException
    {
        /*
         * WARNING: This method may be invoked early during VM initialization
         * before IntegerCache is initialized. Care must be taken to not use
         * the valueOf method.
         */

        if (s == null) {
            throw new TestNumberFormatException("null");
        }

        if (radix < Character.MIN_RADIX) {
            throw new TestNumberFormatException("radix " + radix +
                                            " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
            throw new TestNumberFormatException("radix " + radix +
                                            " greater than Character.MAX_RADIX");
        }

        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        
        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+') {
                    throw TestNumberFormatException.forInputString(s);
                }

                if (len == 1) { // Cannot have lone "+" or "-"
                    throw TestNumberFormatException.forInputString(s);
                }
                i++;
            }

            int multmin = limit / radix;
            int result = 0;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                int digit = Character.digit(s.charAt(i++), radix);
                if (digit < 0 || result < multmin) {
                    throw TestNumberFormatException.forInputString(s);
                }
                result *= radix;
                if (result < limit + digit) {
                    throw TestNumberFormatException.forInputString(s);
                }
                result -= digit;
            }
            return negative ? result : -result;
        } else {
            throw TestNumberFormatException.forInputString(s);
        }
    }
}

class TestNumberFormatException extends Exception {
    static final long serialVersionUID = -2848938806368998894L;
    public TestNumberFormatException() {
        super();
    }
    
    public TestNumberFormatException(String s) {
        super(s);
    }

    static TestNumberFormatException forInputString(String s) {
        return new TestNumberFormatException("forInputString : " + s);
    }
 }

// abstract class CharacterData {
//     static final CharacterData of(int ch) {
//         if (ch >>> 8 == 0) {     // fast-path
//             return CharacterDataLatin1.instance;
//         } else {
//             switch(ch >>> 16) {  //plane 00-16
//             case(0):
//                 return CharacterData00.instance;
//             case(1):
//                 return CharacterData01.instance;
//             case(2):
//                 return CharacterData02.instance;
//             case(14):
//                 return CharacterData0E.instance;
//             case(15):   // Private Use
//             case(16):   // Private Use
//                 return CharacterDataPrivateUse.instance;
//             default:
//                 return CharacterDataUndefined.instance;
//             }
//         }
//     }
//  }