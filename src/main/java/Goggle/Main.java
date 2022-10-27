package Goggle;
import com.mongodb.ConnectionString;
import  com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

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
    public static JPanel contentPane = new JPanel();

    public static int PrevX, PrevY, PrevWidth, PrevHeight;
    public static void openGUI() throws IOException {
        //frame
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
        exit.setFont(font);
        exit.setBounds(1830, 1170, 90, 30);
        contentPane.add(exit);
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
//        MongoClientURI connectionString = new MongoClientURI("mongodb://GobbleAdmin:g0bbleg0bble@cluster0.vogil9m.mongodb.net/?retryWrites=true&w=majority");
//        MongoClient mongoClient = new MongoClient(connectionString);
//        MongoDatabase database = mongoClient.getDatabase("Stuffing");
//        MongoCollection<Document> collection = database.getCollection("bread");
//        Document doc = new Document("name", "MongoDB")
//                .append("type", "database")
//                .append("count", 1)
//                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
//                .append("info", new Document("x", 203).append("y", 102));
//        collection.insertOne(doc);
//
//
//
//        ConnectionString connectionString = new ConnectionString("mongodb://GobbleAdmin:<password>@ac-jy57ork-shard-00-00.vogil9m.mongodb.net:27017,ac-jy57ork-shard-00-01.vogil9m.mongodb.net:27017,ac-jy57ork-shard-00-02.vogil9m.mongodb.net:27017/?ssl=true&replicaSet=atlas-1318b5-shard-0&authSource=admin&retryWrites=true&w=majority");
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//        MongoClient mongoClient = MongoClients.create(settings);
//        MongoDatabase database = mongoClient.getDatabase("test");




        ConnectionString connectionString = new ConnectionString("mongodb://GobbleAdmin:<password>@ac-jy57ork-shard-00-00.vogil9m.mongodb.net:27017,ac-jy57ork-shard-00-01.vogil9m.mongodb.net:27017,ac-jy57ork-shard-00-02.vogil9m.mongodb.net:27017/?ssl=true&replicaSet=atlas-1318b5-shard-0&authSource=admin&retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("test");


    }
}