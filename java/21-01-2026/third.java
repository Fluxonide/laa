
// 3. Upadesh gave Rs. 1000 each to Enu and Divya. Enu and Divya went to Singtam Mela.
//  Divya likes to play Roteping for which ticket price was Rs 100 and she
//  played three times. Enu went to play Colombus whose ticket price was Rs. 50.
//  Then Enu played Scratching games which cost Rs 20 per scratch and she played 5 times.
//  In her last scratch she won Mobile Phone. But to get mobile phone she need to pay Rs 100 extra. 
// Divya after playing Roteping she played Ring game which provide 6 ring in Rs 50 and she won Rs. 1000. 
// Both happy with their win went to hotel and eat there, where they need to pay Rs. 600.
//  Divya paid 70% of the amount.

// Write a program to calculate the percentage in difference of amount they have with them.

// 3. Program to calculate percentage difference of amount
// Enu and Divya have after spending in Singtam Mela

public class third {
    public static void main(String[] args) {

        float enu = 1000f;
        float divya = 1000f;

        // Divya 
        float rope = 100 * 3;         
        float ringSpend = 50;          
        float ringWon = 1000;          

        // Enu 
        float columbus = 50;
        float scratchingGames = 20 * 5;
        float mobileExtra = 100;

        // Hotel 
        float hotel = 600;
        float divyaHotelPay = (hotel * 0.70f);  
        float enuHotelPay = hotel - divyaHotelPay;  

        // Final amount 
        divya = divya - rope - ringSpend + ringWon - divyaHotelPay;
        enu = enu - columbus - scratchingGames - mobileExtra - enuHotelPay;

        float difference = divya - enu;
        float differenceper=(difference/enu)*100;

        System.out.println("Amount with Enu: Rs. " + enu);
        System.out.println("Amount with Divya: Rs. " + divya);
        System.out.println("Difference amont:"+ difference);
        System.out.println("Difference percentage:"+ differenceper);


    }
}
