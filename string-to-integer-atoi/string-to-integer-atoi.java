class Solution {
    public int myAtoi(String str) {
        String num = "";
        int number = 0;
        boolean sign = true;
        boolean sign_done = false;
        boolean start = false;
        int multiplier = 1;
        int i = 0;
        if(str == ""){
            return 0;
        }
        for(; i < str.length(); i++){
            if(str.charAt(i) == 32){
                if(start == true){
                    break;
                }
            }
            else if(str.charAt(i) == 43){
                if(sign_done == true || start == true){
                    break;
                }
                sign_done = true;
                start = true;
            }
            else if(str.charAt(i) == 45){
                if(sign_done == true || start == true){
                    break;
                }
                start = true;
                sign = false;
                sign_done = true;
            }
            else if(str.charAt(i) < 48 || str.charAt(i) > 57){
                break;
            }
            else{
                num = num + str.charAt(i);
                start = true;
            }
        }
        if(num == ""){
            return 0;
        }
        if(num.charAt(0) != 48 && num.length() > 12){
            num = "21474836493";
        }
        long temp = Long.parseLong(num);
        if(sign == false){
            temp *= -1;
        }
        if(temp > 2147483647){
            return 2147483647;
        }
        if(temp < -2147483648){
            return -2147483648;
        }
        number = (int)temp;
        return number;
    }
}