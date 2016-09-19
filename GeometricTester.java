public class GeometricTester {
    public static void main(String[] args) {
        int[] values = {2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576};
        GeometricSequence seq = new GeometricSequence(2, 2);

        // get_next_element() tests
        for (int i = 0; i < (values.length - 1); i ++) {
            eql(values[i+1], seq.get_next_element(), "should get next element");
        }

        // get_prev_element() tests
        for (int i = values.length - 1; i > 0; i --) {
            eql(values[i-1], seq.get_prev_element(), "should get previous element");
        }

        // get_element_by_index() tests
        for (int i = 0; i < values.length; i ++) {
            eql(values[i], seq.get_element_by_index(i), "should get specific element");
        }

        // get_sum_of_elements() tests
        for (int x = 0; x < values.length; x ++) {
            for (int y = 1; y < (values.length - x); y ++) {
                int sum = 0;
                for (int i = x; i <= (x + y); i ++) {
                    sum += values[i];
                }

                eql(sum, seq.get_sum_of_elements(x, x + y), "should compute sum of subset");
            }
        }
    }

    // simple assert runner
    private static void eql(int expected, int given, String message) {
        System.out.format(
            "\u001b[%dm %s %s%s\u001b[39m\n",
            expected == given ? 32 : 31,
            expected == given ? "\u2713" : "x",
            message,
            expected != given ? " (expected " + expected + ", got " + given + ")" : ""
        );
    }
}