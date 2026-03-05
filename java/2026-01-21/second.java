// 2. Raju wet to the market with Rs. 1500 then he buy 2 chocolates each costing Rs. 120.
// At market he met his group, 6 of them they roam around the market.
// One of their friend has some financial issues so rest of them contributed equally 
// and gave Rs. 2000 to him. Mohan returned Rs 500 back to Raju which he has taken 2 months before.
// After spending some time all of them they went to their own way.
// Raju then went to shop and buy 5kg rice which cost Rs 80 per kg.
// While returning back Raju met some dogs and he buy Rs 50. Marie biscuit and feed them to dogs.
// Write a program to Calculate the balance amount Raju have now.


public class second {
    public static void main(String[] args) {

        int balance = 1500;

        int chocolateCost = 2 * 120;
        balance = balance - chocolateCost;

        int contribution = 2000 / 5;
        balance = balance - contribution;

        //mohan returned 500
        balance = balance + 500;

        int riceCost = 5 * 80;
        balance = balance - riceCost;
        
        //biscuit
        balance = balance - 50;

        System.out.println("Balance amount Raju has now: Rs. " + balance);
    }
}

