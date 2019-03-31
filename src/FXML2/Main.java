/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Abdullah Shublaq
 */
public class Main extends Application {

    @FXML
    private TextArea area;

    @FXML
    private void Open() {
        area.setEditable(true);
        System.out.println("Open");
        try {
            FileChooser chooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            chooser.getExtensionFilters().add(extFilter);
            File file = chooser.showOpenDialog(null);
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                area.appendText(s.next() + "\n");
            }
        } catch (Exception ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("OPEN ERROR");
        }
    }

    @FXML
    private void Close() {
        System.out.println("Close");
        area.setText("Default Text...");
        area.setEditable(false);
        area.setFont(new Font(16));
        area.setStyle("-fx-text-inner-color:black;");
    }

    @FXML
    private void Exit() {
        System.out.println("Exit");
        System.exit(0);
    }

    @FXML
    private void Font() {
        System.out.println("Font");
        Integer[] fonts = {2, 4, 8, 16, 23, 46, 128};
        ChoiceDialog<Integer> dialog = new ChoiceDialog(fonts[3], fonts);
        dialog.setTitle("Font Selector");
        dialog.setHeaderText("Selet the font size : ");
        dialog.setContentText("Font size : ");
        dialog.showAndWait();
        area.setFont(new Font(dialog.getSelectedItem()));
    }

    @FXML
    private void Color() {
        System.out.println("Color");
        String[] colors = {"red", "black", "green"};
        ChoiceDialog<String> dialog = new ChoiceDialog(colors[1], colors);
        dialog.setTitle("Color Selector");
        dialog.setHeaderText("Selet the color size : ");
        dialog.setContentText("Color size : ");
        dialog.showAndWait();
        area.setStyle("-fx-text-inner-color:" + dialog.getSelectedItem());
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        loader.setController(this);
        Parent parent = loader.load();

        area.setEditable(false);
        area.setFont(new Font(16));
        area.setStyle("-fx-text-inner-color:black;");

        Scene scene = new Scene(parent, 300, 300);
        primaryStage.setScene(scene);
//        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
