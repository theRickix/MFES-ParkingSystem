
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MySystem {
  private Number idGroup;
  private Number idCard;
  private Number idParking;
  private Number idOperation;
  public VDMSet groups;
  public VDMSet cards;
  public VDMSet parkings;
  public VDMSet ops;

  public void cg_init_MySystem_1() {

    idGroup = 0L;
    idCard = 0L;
    idParking = 0L;
    idOperation = 0L;
    groups = SetUtil.set();
    cards = SetUtil.set();
    parkings = SetUtil.set();
    ops = SetUtil.set();
    return;
  }

  public MySystem() {

    cg_init_MySystem_1();
  }

  public Group addGroup(final String newName) {

    Group newGroup = new Group(idGroup, newName);
    groups = SetUtil.union(Utils.copy(groups), SetUtil.set(newGroup));
    idGroup = idGroup.longValue() + 1L;
    return newGroup;
  }

  public Card addCard(final Group newGroup, final String newName, final Date newDate) {

    Card newCard = new Card(idCard, newGroup, newName, newDate);
    cards = SetUtil.union(Utils.copy(cards), SetUtil.set(newCard));
    idCard = idCard.longValue() + 1L;
    return newCard;
  }

  public ParkingLot addParking(final Number maxLotation, final Group newGroup) {

    ParkingLot newParking = new ParkingLot(idParking, maxLotation, newGroup);
    parkings = SetUtil.union(Utils.copy(parkings), SetUtil.set(newParking));
    idParking = idParking.longValue() + 1L;
    return newParking;
  }

  public Operation addOperation(
      final String plate,
      final Date currentDate,
      final Card newCard,
      final ParkingLot newParking,
      final Object newType) {

    Operation newOp =
        new Operation(idOperation, currentDate, newCard, newParking, ((Object) newType));
    ops = SetUtil.union(Utils.copy(ops), SetUtil.set(newOp));
    return newOp;
  }

  public void cancelCard(final Card newCard) {

    newCard.cancel();
  }

  public void reactivateCard(final Card newCard) {

    newCard.reactivate();
  }

  public Number getParkingCurrLotation(final ParkingLot parking) {

    return parking.getCurrLotation();
  }

  public VDMSet getCardOperations(final Card newCard) {

    return newCard.getOperations();
  }

  public String toString() {

    return "MySystem{"
        + "idGroup := "
        + Utils.toString(idGroup)
        + ", idCard := "
        + Utils.toString(idCard)
        + ", idParking := "
        + Utils.toString(idParking)
        + ", idOperation := "
        + Utils.toString(idOperation)
        + ", groups := "
        + Utils.toString(groups)
        + ", cards := "
        + Utils.toString(cards)
        + ", parkings := "
        + Utils.toString(parkings)
        + ", ops := "
        + Utils.toString(ops)
        + "}";
  }
}
