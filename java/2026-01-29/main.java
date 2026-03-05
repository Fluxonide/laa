//Calculate the amount to be paid by students based on the category he/she belongs:
//1. Govt Quota- 50% discount on course fee
//2. Non-Govt Quota:-
//(a) Merit based:
//   >=90% - 30% discount
//   >=80% and < 90% - 20% discount
//   >=70% and < 80% - 10% Discount
//(b) Additional discount on remaining amount:
//   Defence Quota - 10% discount
//   Disability quota - 20% discount
//Let's assume course fees is Rs 100000.


class main {
    public static void main(String[] args) {

        double fee = 100000;

        int quota = 2;      // 1 = Govt, 2 = Non-Govt
        double per = 75;    

        boolean isDefence = true;
        boolean isDisabled = true;

        if (quota == 1) {
            fee -= fee * 0.50;
        } 
        else {
            if (per >= 90) {
                fee -= fee * 0.30;
            } 
            else if (per >= 80) {
                fee -= fee * 0.20;
            } 
            else if (per >= 70) {
                fee -= fee * 0.10;
            }

            if (isDefence) {
                fee -= fee * 0.10;
            }
            if (isDisabled) {
                fee -= fee * 0.20;
            }
        }

        System.out.println("Final fees: Rs " + fee);
    }
}
