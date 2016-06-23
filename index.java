import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class index{

    //public static DatabaseConnection database;
    
    public static void main(String args[]){
        //making panel
        JFXPanel panel = new JFXPanel();
        //Starting platform
        Platform.runLater(() -> start());
    }
    
    private static void start(){
        try{
            //making connection
            //database = new DatabaseConnection("Dex.db");
            //Loading first FXML file
            FXMLLoader loader=new FXMLLoader(index.class.getResource("Alpha.fxml"));
            //Making abd setting up stage
            Stage alpha = new Stage();
            alpha.setTitle("Main");
            alpha.setScene(new Scene(loader.load()));
            alpha.show();
            //Making controller
            controllerAlpha ca = loader.getController();
            ca.prepareStageEvents(alpha);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            kill();
        }
    }
    public static void kill(){
        System.out.println("Die app die");
        System.exit(0);
    }
}