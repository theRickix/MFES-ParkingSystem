package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class EnterQuote {
  private static int hc = 0;
  private static EnterQuote instance = null;

  public EnterQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static EnterQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new EnterQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof EnterQuote;
  }

  public String toString() {

    return "<Enter>";
  }
}
