/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author Abdullah Shublaq
 */
public class Main extends Application {

    @FXML
    private ListView<String> list;
    @FXML
    private TextArea area;

    @FXML
    private void Copy() {
        System.out.println("Copy");
        ObservableList<String> observableList = list.getSelectionModel().getSelectedItems();
        if (observableList.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No Items Select");
            alert.show();
        } else {
            area.clear();
            for (String item : observableList) {
                area.appendText(item + "\n");
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        loader.setController(this);
        Parent parent = loader.load();
        
        list.setItems(FXCollections.
                observableArrayList("Black", "White", "Red", "Blue", "Cyan", "Orange", "Green", "Yellow", "Pink", "Gray", "Brown", "Indigo", "Purple "));
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        Scene scene = new Scene(parent, 500, 250);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
