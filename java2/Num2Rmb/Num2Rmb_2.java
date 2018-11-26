public class Num2Rmb_2 {
    /** 
     * @version 2.0
     * 
    */
    private static final String[] numArr = {
        "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"
    };

    private static final String[] unitArr = { 
        "", "十", "百", "千", "万", "亿"
    };

    private static final String[] units = { 
        "", "万", "亿", "..."
    };

    public String[] divideNum(double num) {
        // 整数部分
        long integerPart = (long) num;
        // 小数部分
        double fractonalPart = num - integerPart;
        long fractonal2Integer = (long) (fractonalPart * 100);

        return new String[] { Long.toString(integerPart), (fractonal2Integer + "") };
    }

    public String partInteger(String part) {
        String hanzi = "";
        boolean flag = (0 == Integer.valueOf(part));
        int len = part.length();

        if (!flag) {
            for (int i = 0; i < len; i++) {
                String next = "";
                int index = part.charAt(i) - 48;
                int nextIndex = (i == len - 1) ? 0 : (part.charAt(i + 1) - 48);
                if (index != 0) {
                    next = numArr[index];
                } else if (nextIndex != 0) {
                    next = numArr[index];
                }
                
                int intIndex = (len - 1 - i) % 4;
                if (index != 0) {
                    next += unitArr[intIndex];
                }

                hanzi += next;
            }
        }
        
        return hanzi;
    }

    public String integer2Hanzi(String numStrings) {
        String integerHanzi = "";
        int len = numStrings.length();

        int i = 0;
        for (; i < (len / 4); i++) {
            String temp = numStrings.substring((len - 4 - i * 4), (len - i * 4));
            String unit = "";

            if (this.partInteger(temp).equals("")) {
                break;
            }

            switch (i) {
            case 0:
            case 1:
            case 2:
                unit = units[i];
                break;
            default:
                unit = units[3];
                break;
            }
            integerHanzi = this.partInteger(temp) + unit + integerHanzi;
        }

        String temp = numStrings.substring(0, (len - i * 4));
        integerHanzi = this.partInteger(temp) + (i > 2?units[3]:units[i]) + integerHanzi;

        return integerHanzi;
    }
    
    public String decimals2Hanzi(String decimalsString) {
        String decimalHanzi = "";

        for (int i = 0; i < decimalsString.length(); i++) {
            int index = decimalsString.charAt(i) - 48;
            decimalHanzi += numArr[index];
        }
        return decimalHanzi;
    }

    public String combinationNum2Rmb(String integerString, String decimalsString) {
        return integerString + "点" + decimalsString;
    }
    public static void main(String[] args) {
        Num2Rmb_2 testDemo = new Num2Rmb_2();
        double num = 10000009000.1234;

        String[] s = testDemo.divideNum(num);
        String intString = testDemo.integer2Hanzi(s[0]);
        String decString = testDemo.decimals2Hanzi(s[1]);
        String rmb = testDemo.combinationNum2Rmb(intString, decString);

        System.out.printf("num: %.2f\n", num);
        System.out.println("汉字: " + rmb);
    }
}