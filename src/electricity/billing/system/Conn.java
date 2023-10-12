package electricity.billing.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///elec", "root", "Sathu@285");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
