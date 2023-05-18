//Problem Statement
//Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included. Write a program to find Nth Ugly Number.


/*
Example 1:

Input:
N = 10
Output: 12
Explanation: 10th ugly number is 12.
Example 2:

Input:
N = 4
Output: 4
Explanation: 4th ugly number is 4.
Your Task:
You don't need to read input or print anything. Your task is to complete the function getNthUglyNo() which takes an integer n as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 10^4
*/

/*
Method 1 (Simple) 
Loop for all positive integers till the ugly number count is smaller than n, if an integer is ugly than increment ugly number count.
To check if a number is ugly, divide the number by greatest divisible powers of 2, 3 and 5, if the number becomes 1 then it is an ugly number otherwise not. 

Method 2 (Use Dynamic Programming) 
Here is a time efficient solution with O(n) extra space. The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … 
     because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below: 
     (1) 1×2, 2×2, 3×2, 4×2, 5×2, … 
     (2) 1×3, 2×3, 3×3, 4×3, 5×3, … 
     (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
     We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5. Then we use similar merge method as merge sort, to get every ugly number from the three subsequences. Every step we choose the smallest one, and move one step after.

1 Declare an array for ugly numbers:  ugly[n]
2 Initialize first ugly no:  ugly[0] = 1
3 Initialize three array index variables i2, i3, i5 to point to 
   1st element of the ugly array: 
        i2 = i3 = i5 =0; 
4 Initialize 3 choices for the next ugly no:
         next_mulitple_of_2 = ugly[i2]*2;
         next_mulitple_of_3 = ugly[i3]*3
         next_mulitple_of_5 = ugly[i5]*5;
5 Now go in a loop to fill all ugly numbers till 150:
For (i = 1; i < 150; i++ ) 
{
    /* These small steps are not optimized for good 
      readability. Will optimize them in C program 
    next_ugly_no  = Min(next_mulitple_of_2,
                        next_mulitple_of_3,
                        next_mulitple_of_5); 

    ugly[i] =  next_ugly_no       

    if (next_ugly_no  == next_mulitple_of_2) 
    {             
        i2 = i2 + 1;        
        next_mulitple_of_2 = ugly[i2]*2;
    } 
    if (next_ugly_no  == next_mulitple_of_3) 
    {             
        i3 = i3 + 1;        
        next_mulitple_of_3 = ugly[i3]*3;
     }            
     if (next_ugly_no  == next_mulitple_of_5)
     {    
        i5 = i5 + 1;        
        next_mulitple_of_5 = ugly[i5]*5;
     } 
     
}
6.return next_ugly_no

*/

//Implementation

public class UglyNumbers {
    public static int getNthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        
        int nextUglyIndex = 1;
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        
        int i2 = 0, i3 = 0, i5 = 0;
        
        while (nextUglyIndex < n) {
            int minUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            uglyNumbers[nextUglyIndex] = minUglyNumber;
            
            if (nextMultipleOf2 == minUglyNumber)
                nextMultipleOf2 = uglyNumbers[++i2] * 2;
            
            if (nextMultipleOf3 == minUglyNumber)
                nextMultipleOf3 = uglyNumbers[++i3] * 3;
            
            if (nextMultipleOf5 == minUglyNumber)
                nextMultipleOf5 = uglyNumbers[++i5] * 5;
            
            nextUglyIndex++;
        }
        
        return uglyNumbers[n - 1];
    }
    
    public static void main(String[] args) {
        int n = 10; // Example: find the 10th ugly number
        int nthUglyNumber = getNthUglyNumber(n);
        System.out.println("The " + n + "th ugly number is: " + nthUglyNumber);
    }
}
// this is the way of dynamic programming approach to find the ugly number.
