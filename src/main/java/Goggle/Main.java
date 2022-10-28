package Goggle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import javafx.scene.input.KeyCode;
import org.bson.Document;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;

public class Main {
    private JButton exit;
    private Border searchBord;
    private static BufferedImage logo;
    private JLabel l;
    public static void main(String[] args) throws IOException {
        System.out.printf("Welcome to %s.", Variables.name);
        Scanner s = new Scanner(System.in);
        openGUI();
    }

    public static int PrevX, PrevY, PrevWidth, PrevHeight;
    public static void openGUI() throws IOException {
        //frame
        JPanel contentPane = new JPanel();
        JFrame frame = new JFrame();
        contentPane.setLayout(null);
        frame.setContentPane(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(84, 59, 45));
        frame.setUndecorated(true);
        frame.setBounds(0, 0, frame.getToolkit().getScreenSize().width, frame.getToolkit()
                .getScreenSize().height);
        frame.setVisible(true);
        //exit button
        JButton exit = new JButton("Quit");
        Border exitBord = BorderFactory.createLineBorder(new Color(56, 38, 21), 1);
        exit.setBorder(exitBord);
        exit.setFocusable(false);
        Font font = new Font("Comic Sans MS", Font.BOLD, 14);
        frame.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(exit);
        buttonPanel.setBackground(new Color(84, 59, 45));
        contentPane.add(buttonPanel,BorderLayout.SOUTH);
        exit.setFont(font);
        exit.setBounds(1830, 1170, 90, 30);
        exit.setVisible(true);
        exit.setBackground(new Color(237, 115, 46));
        exit.addActionListener(e -> {
            frame.dispose();
        });
        //search field
        JTextField search = new JTextField();
        search.setBounds((frame.getToolkit().getScreenSize().width / 2) - 370, (frame.getToolkit().getScreenSize().height / 2), 800, 50);
        search.setBackground(new Color(255, 255, 255));
        search.setFont(font);
        contentPane.add(search);
        search.setVisible(true);
        Border searchBord = BorderFactory.createLineBorder(new Color(56, 38, 21), 1);
        search.setBorder(searchBord);
        //logo
//        JPanel p = new JPanel();
//        contentPane.setBounds((frame.getToolkit().getScreenSize().width / 2) - 370, (frame.getToolkit().getScreenSize().height / 4), 800, 50);
//        //frame.add(p);
//        BufferedImage l = ImageIO.read(new File("C:\\Users\\100035158\\IdeaProjects\\Goggle\\src\\Goggle\\clipart944219.png"));
//        ImageIcon logo = new ImageIcon(l);
//
//        JLabel lbl = new JLabel();
//        lbl.setIcon(logo);
//        lbl.setVisible(true);
//        contentPane.add(lbl);





        ConnectionString connectionString = new ConnectionString("mongodb+srv://GobbleAdmin:g0bbleg0bble@cluster0.vogil9m.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("Stuffing");
        MongoCollection<Document> collection = database.getCollection("bread");

        search.addActionListener(e-> {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Document myDoc = collection.find(eq("name", search.getText().substring(0, 1).toUpperCase() + search.getText().substring(1))).first();
//            String place = myDoc.get("name").getAsString();
            if (myDoc != null) {
                String fileDataJsonObject = myDoc.toJson();
                JSONObject obj = new JSONObject(fileDataJsonObject);
                String name = (String) obj.get("name");
                System.out.println(name);
            } else {
                MongoCursor<Document> cursor = collection.find().iterator();
                try {
                    while (cursor.hasNext()) {
                    }
                } finally {
                    cursor.close();
                }
            }
            frame.dispose();
            searchGUI(search.getText());
        });

    }

    public static void searchGUI(String search) {
        JPanel contentPane = new JPanel();
        JFrame newFrame = new JFrame();
        contentPane.setLayout(null);
        newFrame.setContentPane(contentPane);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.getContentPane().setBackground(new Color(84, 59, 45));
        newFrame.setUndecorated(true);
        newFrame.setBounds(0, 0, newFrame.getToolkit().getScreenSize().width, newFrame.getToolkit()
                .getScreenSize().height);
        newFrame.setVisible(true);
        //exit button
        JButton exit = new JButton("Quit");
        Border exitBord = BorderFactory.createLineBorder(new Color(56, 38, 21), 1);
        exit.setBorder(exitBord);
        exit.setFocusable(false);
        Font font = new Font("Comic Sans MS", Font.BOLD, 14);
        newFrame.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(exit);
        buttonPanel.setBackground(new Color(84, 59, 45));
        contentPane.add(buttonPanel,BorderLayout.SOUTH);
        exit.setFont(font);
        exit.setBounds(1830, 1170, 90, 30);
        exit.setVisible(true);
        exit.setBackground(new Color(237, 115, 46));
        exit.addActionListener(e -> {
            newFrame.dispose();
        });
    }
}