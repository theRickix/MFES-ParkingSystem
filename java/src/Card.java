
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Card {
  public Number id;
  public Group group;
  public String username;
  public VDMSet plates;
  public Boolean inside;
  public Date expirationDate;
  public Boolean cancelled;
  public VDMSet ops;

  public void cg_init_Card_1(
      final Number newId, final Group newGroup, final String newName, final Date newDate) {

    id = newId;
    group = newGroup;
    username = newName;
    plates = SetUtil.set();
    inside = false;
    expirationDate = newDate;
    cancelled = false;
    ops = SetUtil.set();
    return;
  }

  public Card(final Number newId, final Group newGroup, final String newName, final Date newDate) {

    cg_init_Card_1(newId, newGroup, newName, newDate);
  }

  public Number getId() {

    return this.id;
  }

  public Group getGroup() {

    return this.group;
  }

  public Date getDate() {

    return this.expirationDate;
  }

  public String getName() {

    return this.username;
  }

  public VDMSet getPlates() {

    return this.plates;
  }

  public void setInside() {

    inside = true;
  }

  public void setOutside() {

    inside = false;
  }

  public Boolean isInside() {

    return this.inside;
  }

  public Boolean isCancelled() {

    return this.cancelled;
  }

  public void cancel() {

    cancelled = true;
  }

  public void reactivate() {

    cancelled = false;
  }

  public Boolean isNotExpired(final Date date) {

    Boolean orResult_1 = false;

    if (expirationDate.year.longValue() > date.year.longValue()) {
      orResult_1 = true;
    } else {
      Boolean orResult_2 = false;

      Boolean andResult_1 = false;

      if (Utils.equals(expirationDate.year, date.year)) {
        if (expirationDate.month.longValue() > date.month.longValue()) {
          andResult_1 = true;
        }
      }

      if (andResult_1) {
        orResult_2 = true;
      } else {
        Boolean andResult_2 = false;

        if (Utils.equals(expirationDate.year, date.year)) {
          Boolean andResult_3 = false;

          if (Utils.equals(expirationDate.month, date.month)) {
            if (expirationDate.day.longValue() >= date.day.longValue()) {
              andResult_3 = true;
            }
          }

          if (andResult_3) {
            andResult_2 = true;
          }
        }

        orResult_2 = andResult_2;
      }

      orResult_1 = orResult_2;
    }

    if (orResult_1) {
      return true;

    } else {
      return false;
    }
  }

  public void addPlate(final String newPlate) {

    plates = SetUtil.union(Utils.copy(plates), SetUtil.set(Utils.copy(newPlate)));
  }

  public void removePlate(final VDMSeq plate) {

    plates = SetUtil.diff(Utils.copy(plates), SetUtil.set(Utils.copy(plate)));
  }

  public void addOperation(final Operation op1) {

    ops = SetUtil.union(Utils.copy(ops), SetUtil.set(op1));
  }

  public VDMSet getOperations() {

    return this.ops;
  }

  public Card() {}

  public String toString() {

    return "Card{"
        + "id := "
        + Utils.toString(id)
        + ", group := "
        + Utils.toString(group)
        + ", username := "
        + Utils.toString(username)
        + ", plates := "
        + Utils.toString(plates)
        + ", inside := "
        + Utils.toString(inside)
        + ", expirationDate := "
        + Utils.toString(expirationDate)
        + ", cancelled := "
        + Utils.toString(cancelled)
        + ", ops := "
        + Utils.toString(ops)
        + "}";
  }
}
