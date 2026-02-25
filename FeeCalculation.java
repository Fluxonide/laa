
    class FeeCalculation {
    public static void main(String[] args) {

        double courseFee = 100000;
        double payableAmount = courseFee;

        // Hardcoded values
        int quota = 1;          // 1 = Govt, 2 = Non-Govt
        double percentage = 91; // marks percentage
        int addQuota = 1;       // 1 = None, 2 = Defence, 3 = Disability

        if (quota == 1) {
            // Govt Quota - 50% discount
            payableAmount = courseFee * 0.5;
        } 
        else {
            // Merit-based discount
            if (percentage >= 90) {
                payableAmount -= payableAmount * 0.30;
            } 
            else if (percentage >= 80) {
                payableAmount -= payableAmount * 0.20;
            } 
            else if (percentage >= 70) {
                payableAmount -= payableAmount * 0.10;
            }

            // Additional discount
            if (addQuota == 2) {
                payableAmount -= payableAmount * 0.10;
            } 
            else if (addQuota == 3) {
                payableAmount -= payableAmount * 0.20;
            }
        }

        System.out.println("Amount to be paid: Rs " + payableAmount);
    }
}


