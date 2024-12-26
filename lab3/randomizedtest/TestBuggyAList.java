package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public void testThreeAddThreeRemove() {
      AListNoResizing<Integer> correct = new AListNoResizing<>();
      BuggyAList<Integer> broken = new BuggyAList<>();

      correct.addLast(5);
      correct.addLast(10);
      correct.addLast(15);

      broken.addLast(5);
      broken.addLast(10);
      broken.addLast(15);

      assertEquals(correct.size(), broken.size());

      assertEquals(correct.removeLast(), broken.removeLast());
      assertEquals(correct.removeLast(), broken.removeLast());
      assertEquals(correct.removeLast(), broken.removeLast());
  }

  @Test
  public void randomizedTest() {
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> BL = new BuggyAList<>();

      int N = 5000;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              BL.addLast(randVal);
              System.out.println("addLast(" + randVal + ")");
          } else if (operationNumber == 1) {
              // size
              int size = L.size();
              int bsize = BL.size();
              assertEquals(size, bsize);
              System.out.println("size: " + size);
          }else if (L.size() > 0 && operationNumber == 2) {
              //getLast
              int last = L.getLast();
              int blast = BL.getLast();
              assertEquals(last, blast);
              System.out.println("getLast: " + last);
          }else if (L.size() >0 && operationNumber == 3) {
              //removeLast
              int last = L.removeLast();
              int blast = BL.removeLast();
              assertEquals(last, blast);
              System.out.println("removeLast: " + last);
          }
      }
  }
}
