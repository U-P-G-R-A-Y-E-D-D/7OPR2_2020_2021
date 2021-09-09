package eng.distinctStack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IgnoredStackTest {

  @Test
  public void testPutSimple(){
    String item = "ahoj";
    Stack<String> stack = new IgnoredStack<>();

    stack.put(item);

    assertEquals(item, stack.peek());
  }


  @Test
  public void testPutDuplicity(){
    String item = "ahoj";
    Stack<String> stack = new IgnoredStack<>();

    stack.put(item);
    stack.put(item);

    stack.pop();
    assertFalse(stack.contains(item));
  }

}
