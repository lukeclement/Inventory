import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.chart.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import java.util.List;

public class controllerAlpha
{
    private static Stage alpha;
    @FXML private Pane back;
    @FXML private Label name;
    @FXML private TextField search;
    @FXML private StackedBarChart stats;
    @FXML private Label description;
    @FXML private ImageView image;
    @FXML private Line a;
    @FXML private Line b;
    @FXML private ListView list;
    @FXML private Button delete;
    @FXML private Button deck;
    //@FXML private ChoiceBox addToDeck;
    public controllerAlpha(){
        System.out.println("Here we go");
    }
    
    @FXML void initialize(){
        System.out.println("Asserting controls...");
        try
        {
            assert back != null : "Can't find pane.";
            assert name !=null : "No name";
            assert search !=null : "Problems";
            assert stats !=null : "Problems";
            assert description !=null : "Problems";
            assert image !=null : "Problems";
            assert a !=null : "Problems";
            assert b !=null : "Problems";
            assert list !=null : "Problems";
            assert delete !=null : "Problems";
            assert deck !=null : "Problems";
            //assert addToDeck !=null : "Problems";
            System.out.println("Populating scene with items from the database...");
            @SuppressWarnings("unchecked")
            List<pokemon> targetList = list.getItems();
            pokemon.readAll(targetList);
        }
        catch (AssertionError ae)
        {
            System.out.println("FXML assertion failure: " + ae.getMessage());
            index.kill();
        }
    }
    public void prepareStageEvents(Stage stage)
    {
        System.out.println("Preparing stage events...");
        
        this.alpha = stage;
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.out.println("Close button was clicked!");
                index.kill();
            }
        });
    }
    
    @FXML   void delClick()
    {
        System.out.println("Delete was clicked!");
    }
    
    @FXML   void deckMk()
    {
        System.out.println("Make a deck!");
    }
    
    @FXML   void listClick()
    {
        name.setText("a");
        System.out.println("List was clicked!");
    }
    
    @FXML   void searchThis()
    {
        
        System.out.println(search.getText());
    }
}