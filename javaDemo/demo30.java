// 缓存实例的不可变类

//   定义缓存池
class CacheImmutable {
    private static int MAX_SIZE = 10;
    private static CacheImmutable[] cache = new CacheImmutable[MAX_SIZE];
    private static int pos = 0; //pos-1 代表指向缓存池插入位置
    private final String name;

    private CacheImmutable(String name) {
        this.name = name;
    }

    public static CacheImmutable valueOf(String n) {
        //如果已存在，返回该对象 
        for (int i = 0; i < MAX_SIZE; i++) {
            if (cache[i] != null && cache[i].name.equals(n)) {
                printPos();
                return cache[i];
            }
        }

        // 缓存池已满
        if (pos == MAX_SIZE) {
            pos = 1;
            cache[pos - 1] = new CacheImmutable(n);
        } else {
            cache[pos] = new CacheImmutable(n);
            pos++;
        }

        printPos();
        return cache[pos - 1];
    }
    
    // 定义相等条件
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj != null && CacheImmutable.class == obj.getClass()) {
            return this.name.equals(((CacheImmutable) obj).getName());
        }

        return false;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    private static void printPos() {
        System.out.println(pos + "---" + cache[pos-1].getName());
    }
}

public class demo30 {
    public static void main(String[] args) {
        CacheImmutable e1 = CacheImmutable.valueOf("hello");
        CacheImmutable e2 = CacheImmutable.valueOf("hello");

        // test-code
        // CacheImmutable[] e = new CacheImmutable[100];
        // for (byte i = 65; i < 91; i++) {
        //     String tempString = String.valueOf((char) i);
        //     e[i - 65] = CacheImmutable.valueOf(tempString);
        // }
        
        System.out.println("e1 == e2" + (e1 == e2));
    }
}