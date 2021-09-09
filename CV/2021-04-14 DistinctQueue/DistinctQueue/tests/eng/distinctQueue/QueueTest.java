package eng.distinctQueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

  @Test
  public void testExceptionAddSimple() {
    String item = "prvek";
    Queue<String> queue = new Queue<>(Queue.QueueBehavior.EXCEPTION);

    assertFalse(queue.contains(item));
    queue.add(item);
    assertTrue(queue.contains(item));
  }

  @Test
  public void testIgnoreAddSimple() {
    String item = "prvek";
    Queue<String> queue = new Queue<>(Queue.QueueBehavior.IGNORE);

    assertFalse(queue.contains(item));
    queue.add(item);
    assertTrue(queue.contains(item));
  }

  @Test
  public void testIgnoreAddDuplicit(){
    String item = "prvek";
    Queue<String> queue = new Queue<>(Queue.QueueBehavior.IGNORE);

    assertFalse(queue.contains(item));
    queue.add(item);
    queue.add(item);

    queue.take();
    assertFalse(queue.contains(item));
  }

  @Test
  public void testExceptionAddDuplicity(){
    String item = "prvek";
    Queue<String> queue = new Queue<>(Queue.QueueBehavior.EXCEPTION);

    assertFalse(queue.contains(item));
    queue.add(item);

    try {
      queue.add(item);
      fail("Add should fail for duplicity item");
    } catch (DuplicityItemException e) {
      // je to ok.
    } catch (Exception e){
      fail("Add should throw 'DuplicityItemException'.");
    }
  }
}
