package pl.coderslab.get;

import java.io.File;

public class Test {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource("test.txt").getFile());
        System.out.println(file.exists());
    }
}
