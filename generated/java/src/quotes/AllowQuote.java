package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class AllowQuote {
  private static int hc = 0;
  private static AllowQuote instance = null;

  public AllowQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static AllowQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new AllowQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof AllowQuote;
  }

  public String toString() {

    return "<Allow>";
  }
}
