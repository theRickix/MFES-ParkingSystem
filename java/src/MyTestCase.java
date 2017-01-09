
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MyTestCase {
  protected void assertTrue(final Boolean arg) {

    return;
  }

  protected void assertEqual(final Object expected, final Object actual) {

    if (!(Utils.equals(expected, actual))) {
      IO.print(SeqUtil.seq('A', 'c', 't', 'u', 'a', 'l', ' ', 'v', 'a', 'l', 'u', 'e', ' ', '('));
      IO.print(((Object) actual));
      IO.print(
          SeqUtil.seq(
              ')', ' ', 'd', 'i', 'f', 'f', 'e', 'r', 'e', 'n', 't', ' ', 'f', 'r', 'o', 'm', ' ',
              'e', 'x', 'p', 'e', 'c', 't', 'e', 'd', ' ', '('));
      IO.print(((Object) expected));
      IO.println(SeqUtil.seq(')', '\n'));
    }
  }

  public MyTestCase() {}

  public String toString() {

    return "MyTestCase{}";
  }
}
