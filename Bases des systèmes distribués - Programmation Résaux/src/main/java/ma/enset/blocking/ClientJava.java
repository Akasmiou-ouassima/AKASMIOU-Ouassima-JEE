package ma.enset.blocking;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Observable;


public class ClientJava extends Application {
    PrintWriter pw;
    public static void main(String[] args) {
        launch(args); // il fait appel à la méethode start
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Client Java");
        BorderPane borderPane = new BorderPane();
        Label labelHost = new Label("Host:");
        TextField textFieldHost = new TextField("localhost");
        Label labelPort = new Label("Port:");
        TextField textFieldPort = new TextField("1234");
        Button buttonConnecter = new Button("Connecter");
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10));
        hBox.setBackground(new Background(new BackgroundFill(Color.MAROON, null, null)));
        hBox.getChildren().addAll(labelHost, textFieldHost, labelPort, textFieldPort, buttonConnecter);
        borderPane.setTop(hBox);
        ObservableList<String> listModel = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<String>(listModel);
        HBox hBox2 = new HBox();
        hBox2.setSpacing(10);
        hBox2.setPadding(new Insets(10));
        hBox2.getChildren().add(listView);
        borderPane.setCenter(hBox2);

        Label labelMessage = new Label("Message:");
        TextField textFieldMessage = new TextField();
        textFieldMessage.setPrefSize(300,30);
        Button buttonEnvoyer = new Button("Envoyer");

        HBox hBox3 = new HBox();
        hBox3.setPadding(new Insets(10));
        hBox3.getChildren().addAll(labelMessage, textFieldMessage, buttonEnvoyer);
        borderPane.setBottom(hBox3);


        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        borderPane.setCenter(listView);
        buttonConnecter.setOnAction((evt) -> {
            String host = textFieldHost.getText();
            int port = Integer.parseInt(textFieldPort.getText());
            try {
                Socket socket = new Socket(host, port);
                InputStream inputStream = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(isr);
                pw = new PrintWriter(socket.getOutputStream(), true);
                new Thread(() -> {
                    try {
                        while (true) {
                            String response = bufferedReader.readLine();
                            Platform.runLater(()->{
                                listModel.add(response);
                            });

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }).start();  //quand il ya une interface contient une seule méthode c est pas la peine de le redéfinir, on utilise l expression lamda
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        buttonEnvoyer.setOnAction((evt)->{
            String message=textFieldMessage.getText();
            pw.println(message);
        });

    }
}
