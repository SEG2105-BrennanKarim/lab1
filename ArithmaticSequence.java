public class ArithmaticSequence extends Sequence {
    private int a, diff, xn;

    public ArithmaticSequence(int diff, int initial) {
        this.diff = diff;
        this.a = this.xn = initial;
    }

    public int get_element() { return xn; }

    public int get_next_element() {
        xn += diff;
        indx ++;
        return get_element();
    }

    public int get_prev_element() {
        xn -= diff;
        indx --;
        return get_element();
    }

    public int get_element_by_index(int index) {
        if (indx >= index) {
            index = Math.abs(index - indx);
            while (index-- > 0) this.get_prev_element();
        } else {
            index = Math.abs(index - indx);
            while (index-- > 0) this.get_next_element();
        }

        return this.get_element();
    }

    public int get_sum_of_elements(int y, int x) {
        x += 1;

        int ax = a + ((x - 1) * diff),
            ay = a + ((y - 1) * diff);

        return ((x * (a + ax)) - (y * (a + ay))) / 2;
    }
}