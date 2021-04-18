import java.util.*;

class lpn { // lpn = longPressedName

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String name = scn.next(), typed = scn.next();

        System.out.println(isLongPressedName(name, typed));

        scn.close();
    }

    public static boolean isLongPressedName(String name, String typed) {
        
        if(typed.length() < name.length()) return false;
        if(name.charAt(0) != typed.charAt(0)) return false; // edge case
        
        int i = 0, j = 0; // two pointer to traverse through name and typed string
        
        while(i < name.length() || j < typed.length()) {
            if(i < name.length() && j < typed.length() && name.charAt(i) == typed.charAt(j)) {
                i++; j++;
            }
            else {
                if(j < typed.length() && typed.charAt(j) == typed.charAt(j-1)) j++;
                else return false;
            }
        }
        
        return true;
        
    }

}