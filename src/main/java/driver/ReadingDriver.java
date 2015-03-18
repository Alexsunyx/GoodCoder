package driver;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ReadingDriver {

    public List<String> readType(Reader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<String>();
        int c = reader.read();
        boolean beginFlag = false;
        while( c != -1) {
            if (beginFlag) {
                if ((char) c == '>') {
                    beginFlag = false;
                    result.add(builder.toString());
                    builder.delete(0, builder.length());
                }
                else {
                    builder.append((char) c);
                }
            } else {
                if ((char) c == '\n') {
                    return result;
                }
                if ((char) c == '<') {
                    beginFlag = true;
                }
            }
            c = reader.read();
        }
        return result;
    }

    public List<String> readline(Reader reader, int num) throws Exception {
        int count = 0;
        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<String>();
        int c = reader.read();
        boolean beginFlag = false;
        while( c != -1) {
            if (beginFlag) {
                if ((char) c == '>') {
                    beginFlag = false;
                    result.add(builder.toString());
                    builder.delete(0, builder.length());
                }
                else {
                    builder.append((char) c);
                }
            } else {
                if ((char) c == '\n') {
                    if (count != num) {
                        throw new Exception();
                    }
                    count = 0;
                }
                if ((char) c == '<') {
                    beginFlag = true;
                    count++;
                }
            }
            c = reader.read();
        }

        return result;
    }

}
