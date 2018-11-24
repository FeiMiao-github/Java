public class Num2Rmb {
    private static final String[] numArr = {
        "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"
    };

    private static final String[] unitArr = {
       "", "十", "百", "千", "万" 
    };

    public long[] divideNum(double num) {
        // 整数部分
        long longegerPart = (long) num;
        // 小数部分
        double fractonalPart = num - longegerPart;
        long fractonal2longeger = (long) (fractonalPart * 100);

        long[] dividedNum = new long[] { longegerPart, fractonal2longeger };
        return dividedNum;
    }
    
    public String num2Hanzi(long[] dividedNum) {
        // 小数部分
        String fractionalPart = "";
        String longegerPart = "";
        
        int firstFraNum = (int)(dividedNum[1] / 10);
        int secondFraNum = (int)(dividedNum[1] % 10);
        fractionalPart = numArr[firstFraNum] + numArr[secondFraNum];

        // 整数部分
        for (long temp = dividedNum[0], i = 0; temp > 0; i++) {
            int index = (int)(temp % 10);
            String next = numArr[index];

            int unitA = (int)(i % 4);
            int unitB = (int)(i / 4);

            next = next + unitArr[unitA];
            if (unitA == 0) {
                for (long j = unitB; j > 0; j--) {
                    next = next + unitArr[4];
                }
            }

            longegerPart = next + longegerPart;
            temp /= 10;
        }

        return longegerPart + "点" + fractionalPart;
    }

    public static void main(String[] args) {
        Num2Rmb testDemo = new Num2Rmb();
        long[] arrNum = testDemo.divideNum(214748364733.0221);
        System.out.println(testDemo.num2Hanzi(arrNum));
    }
}