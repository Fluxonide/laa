/* 
Implement the pattern in java

***** 
****# 
***## 
**### 
*#### 
#####

 */

public class pat {
    public static void main(String[] args) {

        int r = 20;  // number of rows

        for (int i = 1; i <= r; i++) {

            for (int m = i; m <= r-1; m++) {
                System.out.print("*");
            }

            for (int n = 1; n <= i-1; n++) {
                System.out.print("#");
            }

            System.out.println();
        }
    }
}
