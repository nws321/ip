import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ToDo extends Task {
    public ToDo(boolean mark, String task) {
        super(mark, task);

    }

    @Override
    public void hasDate() throws BoombotrozException {

    }

    @Override
    public String toString() {
        String s;
        s = String.format("[T]%s", super.toString());
        return s;
    }

}
