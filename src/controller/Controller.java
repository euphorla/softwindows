package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

import javax.print.DocFlavor;

public class Controller {

    public void downloadFile(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("An exception occurred!");
        alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(new String(String.valueOf(returnGaren(1,2,3))))));
        alert.showAndWait();
    }

    public Integer returnGaren (Integer a,Integer b,Integer c){
        return (a+b)*c;
    }


}
