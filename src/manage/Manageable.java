package manage;

import java.util.Scanner;

public interface Manageable {
    void read(Scanner scan);
    void print(boolean check);
    boolean matches(String kwd);
    boolean matches(String[] kwdArr);
}
