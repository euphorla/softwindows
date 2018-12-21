package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import net.SyncPipe;

import javax.print.DocFlavor;
import java.io.PrintWriter;

public class Controller {

    public void downloadFile(ActionEvent actionEvent) {
        String download_path="D:\\gamer\\Music\\Test Soft";
        String url="https://www.youtube.com/watch?v=j5Td4G0qbkE";
        String[] command =
                {
                        "cmd",
                };
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("cd \""+System.getProperty("user.dir")+"\"");
            stdin.println(System.getProperty("user.dir")+url+ " --write-all-thumbnails");
            stdin.close();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setHeaderText("An exception occurred!");
//        alert.getDialogPane().setExpandableContent(new ScrollPane(new TextArea(new String(String.valueOf(returnGaren(1,2,3))))));
//        alert.showAndWait();


//    public Integer returnGaren (Integer a,Integer b,Integer c){
//        return (a+b)*c;
//    }


}
