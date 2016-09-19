
public abstract class Sequence {
   protected int indx;
   
   abstract public int get_next_element();
   abstract public int get_prev_element();
   abstract public int get_element_by_index(int index);
   abstract public int get_sum_of_elements(int start_index, int end_index);
   public int get_index() { return indx; }
}
