// Author: Jamie Roche
// Date: 28/04/23
// Purpose: Non-Linear Data Struct & Algorithms
// Student Number: R00151829
// Class: SDH2-B

public class PaperRollCuttingBottomUp
{

    public static void main (String[]args)
    {

        int lengthOfPaperRoll = 27;	// length of paper roll
        double[] costOfPaperRoll = { 0, 1.2, 3, 5.8, 10.1 };	// cost of each roll-piece
        double[] maxProfit = new double[lengthOfPaperRoll + 1];	// array to store maximum profit for each length
        int[] cuts = new int[lengthOfPaperRoll + 1];	// array to store number of cuts for each length

        // initialization
        maxProfit[0] = 0;

        // bottom-up approach to compute maximum profit for each length
        for (int i = 1; i <= lengthOfPaperRoll; i++)
        {				// loop over all lengths from 1 to n

            double maxRevenue = 0;	// set the initial maximum profit to 0
            int numOfCuts = -1;	// set the initial number of cuts to -1

            for (int j = 1; j <= 4; j++)
            {			// loop over all possible line cuts (1-4)

                if (i >= j)
                {			// check if current length is greater than or equal to current cut length

                    // calculate profit for current length using current cut length
                    double currentProfit = maxProfit[i - j] + costOfPaperRoll[j];

                    if (currentProfit > maxRevenue)
                    {		// check if current profit is greater than current maximum profit

                        maxRevenue = currentProfit;	// update maximum profit
                        numOfCuts = j;	// update number of cuts

                    }
                }
            }

            maxProfit[i] = maxRevenue;	// store maximum revenue for current length
            cuts[i] = numOfCuts;	// store number of cuts for current length

        }

        // print results
        System.out.printf ("Maximum Profit from Paper-Roll: €%,.2f\n", maxProfit[lengthOfPaperRoll]);	// prints maximum profit with two decimal points
        System.out.println ();
        System.out.println ("Cuts:");

        int k = 1;
        while (lengthOfPaperRoll > 0)
        {

            // prints number of cuts made for each length, along with the price of each cut
            System.out.printf ("Cut %d: %dm = €%.2f\n", k,
                    cuts[lengthOfPaperRoll],
                    costOfPaperRoll[cuts[lengthOfPaperRoll]]);
            k++;
            lengthOfPaperRoll -= cuts[lengthOfPaperRoll];

        }
    }
}
