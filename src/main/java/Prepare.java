import java.util.ArrayList;

public class Prepare {

    ArrayList<ArrayList<String>> tableColumn;

    public Prepare (ArrayList<ArrayList<String>> tableColumn) {
        this.tableColumn = tableColumn;
    }

    public void start() {
        for (ArrayList<String> string : tableColumn) {
            System.out.println(string);
        }
    }
}
