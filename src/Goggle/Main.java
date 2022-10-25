package Goggle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
public class Main {
    private JButton exit;
    public static void main(String[] args) {
        System.out.printf("Welcome to %s.", Variables.name);
        Scanner s = new Scanner(System.in);
        GUIOpen();
    }
}