import java.util.Random;

public class FibonacciTester {
   public static void main(String[] args){
      final int []ref_Values = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765};
      Random rnd = new Random();

      FibonacciSequence seq = new FibonacciSequence();
      for (int i=0; i<20; i++){
         int next = seq.get_next_element();
         if (next != ref_Values[i+1]) {
            System.out.println("get_next_element Error F" + (i+1) + " is supposed to be " + ref_Values[i+1] + " but " + next+ " was calculated instead!");
         }
         if (seq.get_index() != i+1) {
            System.out.println("get_index Error1 index value retrieved " + seq.get_index() + " is different from expected " + (i+1));            
         }
      }
      for (int i=20; i>0; i--){
         int prev = seq.get_prev_element();
         if (prev != ref_Values[i-1]) {
            System.out.println("Error F" + (i-1) + " is supposed to be " + ref_Values[i-1] + " but " + prev+ " was calculated instead!");
         }
         if (seq.get_index() != i-1) {
            System.out.println("get_index Error2 index value retrieved " + seq.get_index() + " is different from expected " + (i+1));            
         }
      }
      for (int i=0; i<5; i++){
         int ii = rnd.nextInt(20);
         if (seq.get_element_by_index(ii) != ref_Values[ii]){
            System.out.println("get_element_by_index Error F" + (ii) + " is supposed to be " + ref_Values[ii] + " but " + seq.get_element_by_index(ii)+ " was calculated instead!");            
         }
      }

      // get_sum_of_elements() tests
        for (int x = 0; x < ref_Values.length; x ++) {
            for (int y = 1; y < (ref_Values.length - x); y ++) {
                int sum = 0;
                for (int i = x; i <= (x + y); i ++) {
                    sum += ref_Values[i];
                }
 
                int got = seq.get_sum_of_elements(x, x + y);
                if (sum != got) {
                    System.out.format("Error: bad sum between %d and %d: expected %d, got %d\n", x, x + y, sum, got);
                }
            }
        }
   }
}
