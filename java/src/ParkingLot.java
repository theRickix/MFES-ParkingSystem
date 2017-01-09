
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ParkingLot {
  private Number id;
  private Number maxLotation;
  public Number currLotation;
  private Group group;
  private VDMSet cardsIn;
  public Boolean maintenance;

  public void cg_init_ParkingLot_1(
      final Number newId, final Number newMaxLotation, final Group newGroup) {

    id = newId;
    maxLotation = newMaxLotation;
    currLotation = maxLotation;
    group = newGroup;
    cardsIn = SetUtil.set();
    maintenance = false;
    return;
  }

  public ParkingLot(final Number newId, final Number newMaxLotation, final Group newGroup) {

    cg_init_ParkingLot_1(newId, newMaxLotation, newGroup);
  }

  public Number getId() {

    return this.id;
  }

  public Number getMaxLotation() {

    return this.maxLotation;
  }

  public Number getCurrLotation() {

    return this.currLotation;
  }

  public Group getGroup() {

    return this.group;
  }

  public VDMSet getCardsIn() {

    return this.cardsIn;
  }

  public void carEntered(final Card newCard) {

    currLotation = currLotation.longValue() - 1L;
    cardsIn = SetUtil.union(Utils.copy(cardsIn), SetUtil.set(newCard));
  }

  public void carLeft(final Card newCard) {

    currLotation = currLotation.longValue() + 1L;
    cardsIn = SetUtil.diff(Utils.copy(cardsIn), SetUtil.set(newCard));
  }

  public ParkingLot() {}

  public String toString() {

    return "ParkingLot{"
        + "id := "
        + Utils.toString(id)
        + ", maxLotation := "
        + Utils.toString(maxLotation)
        + ", currLotation := "
        + Utils.toString(currLotation)
        + ", group := "
        + Utils.toString(group)
        + ", cardsIn := "
        + Utils.toString(cardsIn)
        + ", maintenance := "
        + Utils.toString(maintenance)
        + "}";
  }
}
