package task_Database;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) throws OperationNotSupportedException {
        Database db = null;
        try {
            db = new Database(1, 2, 3, 4);
            db.remove();
            db.remove();
            db.remove();
            db.remove();
            db.remove();

        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
            db.add(1);
        }

        for (Integer number : db.fetch()) {
            System.out.println(number);
        }
    }
}
