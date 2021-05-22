package util;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class InputHelper {

    public static List<String> read(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream)).lines().map(String::trim).collect(Collectors.toList());
    }

    public static List<String> read(String filename) throws FileNotFoundException {
        return read(new FileInputStream(filename));
    }

}
