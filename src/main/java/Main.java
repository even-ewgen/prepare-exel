import exel.Read;
import exel.Write;

public class Main {
    private static String title = "";

    public static void main (String[] arg) {
        Read read = new Read();
        read.readFile(title);

        Prepare prepare = new Prepare(read.getTableColumn());
        prepare.start();

        Write write = new Write(read.getTable());
        write.createFile(title);
        write.write();
    }
}
