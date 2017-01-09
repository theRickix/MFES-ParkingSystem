
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Group {
  private Number id;
  private String name;

  public void cg_init_Group_1(final Number newId, final String newName) {

    id = newId;
    name = newName;
    return;
  }

  public Group(final Number newId, final String newName) {

    cg_init_Group_1(newId, newName);
  }

  public Number getId() {

    return this.id;
  }

  public String getName() {

    return this.name;
  }

  public Group() {}

  public String toString() {

    return "Group{" + "id := " + Utils.toString(id) + ", name := " + Utils.toString(name) + "}";
  }
}
