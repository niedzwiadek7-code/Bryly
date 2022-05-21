import com.google.gson.Gson;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        EventQueue.invokeLater(Window::new);
    }
}