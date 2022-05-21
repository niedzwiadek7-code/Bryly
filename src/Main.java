package com.company;

import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(Window::new);

        Gson gson = new Gson();
    }
}