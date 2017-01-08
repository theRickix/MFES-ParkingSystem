package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DenyQuote {
  private static int hc = 0;
  private static DenyQuote instance = null;

  public DenyQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static DenyQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new DenyQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof DenyQuote;
  }

  public String toString() {

    return "<Deny>";
  }
}
