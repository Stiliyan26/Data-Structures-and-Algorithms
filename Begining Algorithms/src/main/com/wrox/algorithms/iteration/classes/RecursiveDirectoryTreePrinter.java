package main.com.wrox.algorithms.iteration.classes;

import java.io.File;

public class RecursiveDirectoryTreePrinter {
    private static final String SPACES = "  ";
    public static void main(String[] args) {
        assert args != null : "args can't be null";

        if (args.length != 1) {
            System.err.println("Usage: RecursiveDirectoryTreePrinter <dir>");
            System.exit(4);
        }

        print(new File(args[0]), "");
    }

    public static void print(File file, String indent) {
        assert file != null : "file can't be null";
        assert  indent != null : "indent can't be null";

        System.out.print(indent);
        System.out.println(file.getName());

        if (file.isDirectory()) {
            print(file.listFiles(), indent + SPACES);
        }
    }

    public static void print(File[] files, String indent) {
        assert files != null : "files can’t be null";

        for (int i = 0; i < files.length; i++) {
            print(files[i], indent);
        }
    }
}
