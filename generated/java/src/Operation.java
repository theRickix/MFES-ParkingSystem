
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Operation {
  public Number id;
  public Date date;
  public Card cardUsed;
  public ParkingLot parking;
  public Object type;
  public Object result;

  public void cg_init_Operation_1(
      final Number newId,
      final Date newDate,
      final Card newCard,
      final ParkingLot newParking,
      final Object newType) {

    id = newId;
    date = newDate;
    cardUsed = newCard;
    parking = newParking;
    type = newType;
    if (Utils.equals(type, quotes.EnterQuote.getInstance())) {
      this.enter();
    }

    if (Utils.equals(type, quotes.LeaveQuote.getInstance())) {
      this.leave();
    }

    cardUsed.addOperation(this);
    return;
  }

  public Operation(
      final Number newId,
      final Date newDate,
      final Card newCard,
      final ParkingLot newParking,
      final Object newType) {

    cg_init_Operation_1(newId, newDate, newCard, newParking, newType);
  }

  private void enter() {

    result = quotes.DenyQuote.getInstance();
    Boolean andResult_11 = false;

    if (!(SetUtil.inSet(cardUsed, parking.getCardsIn()))) {
      if (!(cardUsed.isInside())) {
        andResult_11 = true;
      }
    }

    if (andResult_11) {
      result = quotes.AllowQuote.getInstance();
      parking.carEntered(cardUsed);
      cardUsed.setInside();
    }
  }

  private void leave() {

    result = quotes.DenyQuote.getInstance();
    Boolean andResult_12 = false;

    if (SetUtil.inSet(cardUsed, parking.getCardsIn())) {
      if (cardUsed.isInside()) {
        andResult_12 = true;
      }
    }

    if (andResult_12) {
      result = quotes.AllowQuote.getInstance();
      parking.carLeft(cardUsed);
      cardUsed.setOutside();
    }
  }

  public Object getResult() {

    return this.result;
  }

  public Operation() {}

  public String toString() {

    return "Operation{"
        + "id := "
        + Utils.toString(id)
        + ", date := "
        + Utils.toString(date)
        + ", cardUsed := "
        + Utils.toString(cardUsed)
        + ", parking := "
        + Utils.toString(parking)
        + ", type := "
        + Utils.toString(type)
        + ", result := "
        + Utils.toString(result)
        + "}";
  }
}
