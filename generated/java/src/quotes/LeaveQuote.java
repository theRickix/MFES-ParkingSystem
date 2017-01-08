package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class LeaveQuote {
  private static int hc = 0;
  private static LeaveQuote instance = null;

  public LeaveQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static LeaveQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new LeaveQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof LeaveQuote;
  }

  public String toString() {

    return "<Leave>";
  }
}
