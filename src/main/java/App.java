import driver.ReadingDriver;
import model.RowResult;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class App {

    public static void main(String args[]) throws Exception {
        // 读取文件
        Reader reader = new FileReader("test");

        ReadingDriver readingDriver = new ReadingDriver();

        // 读取每列的类型
        List<String> types = readingDriver.readType(reader);

        // 读取全部<>内的token
        List<String> list = readingDriver.readline(reader, types.size());

        // 读入对象中
        RowResult result = new RowResult();
        result.generate(list, types);

        System.out.println(result.getRowResult());
    }

}
