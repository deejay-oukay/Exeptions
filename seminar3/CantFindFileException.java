package seminar3;

import java.io.FileNotFoundException;

public class CantFindFileException extends FileNotFoundException {
    CantFindFileException(String msg) {
        super(msg);
    }
}
