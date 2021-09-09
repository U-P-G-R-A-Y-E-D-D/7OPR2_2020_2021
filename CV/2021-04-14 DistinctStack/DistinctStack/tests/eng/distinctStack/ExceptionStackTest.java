package eng.distinctStack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionStackTest {

  @Test
  public void testPutDuplicity(){
    String item = "ahoj";
    Stack<String> stack = new ExceptionStack<>();

    stack.put(item);

    try{
      stack.put(item);
      fail("Stack should not be able to contain two same items. Exception expected.");
    } catch (ItemAlreadyExistsException ex){

    } catch (Exception ex){
      fail("Stack put() should fail with ItemAlreadyExistsException only.");
    }



    //assertThrows(ItemAlreadyExistsException.class, () -> stack.put(item));
  }

}
