package algorithm.string;

/**
 * Created by qun.chen on 14/5/17.
 */
public class IntegerToEnglishWord {

    public static void main(String[] argv) {
        IntegerToEnglishWord integerToEnglishWord = new IntegerToEnglishWord();
        System.out.print(integerToEnglishWord.numberToWords(123));
    }

    /**
     * construct all special word and different level, empty string for not applicable cases
     */
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", " Thousand", " Million", " Billion"};

    /**
     * if equals 0, return word of 0
     * 1. split the number into every 3 digits add thousands level based on position
     * 2. for every 3 number use help function
     * 3. concatenate values and thousands level
     * O(digit number)
     * @param num
     * @return
     */
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String result = "";
        int i = 0;
        while (num > 0) {
            int temp = num % 1000;
            if (temp>0) {
                if(result.equals("")){
                    result = help(temp) + THOUSANDS[i];
                }else{
                    result = help(temp) + THOUSANDS[i] + " " + result;
                }
            }

            num = num / 1000;
            i++;

        }
        return result;
    }

    /**
     * 1. return empty string if it is 0
     * 2. map to special word if less than 20
     * 3. map to tens level and special word if larger than 20 but less than 100
     * 4. get the number of hundred by mapping to hundred level apply less than 100 part recursively
     * O(1)
     * @param num
     * @return
     */
    public String help(int num) {
        if(num==0){
            return "";
        }
        if (num < 20) {
            return LESS_THAN_20[num];
        }
        if (num < 100) {
            if (num % 10 == 0) {
                return TENS[num / 10];
            } else {
                return TENS[num / 10] + " " + LESS_THAN_20[num % 10];
            }
        } else {
            if (num % 100 == 0) {
                return LESS_THAN_20[num / 100] + " Hundred";
            } else {
                return LESS_THAN_20[num / 100] + " Hundred " + help(num % 100);
            }

        }

    }
}
