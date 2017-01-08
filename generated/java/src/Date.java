
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Date {
  public Number day;
  public Number month;
  public Number year;

  public void cg_init_Date_1(final Number newDay, final Number newMonth, final Number newYear) {

    day = newDay;
    month = newMonth;
    year = newYear;
  }

  public Date(final Number newDay, final Number newMonth, final Number newYear) {

    cg_init_Date_1(newDay, newMonth, newYear);
  }

  public Date() {}

  public String toString() {

    return "Date{"
        + "day := "
        + Utils.toString(day)
        + ", month := "
        + Utils.toString(month)
        + ", year := "
        + Utils.toString(year)
        + "}";
  }
}
