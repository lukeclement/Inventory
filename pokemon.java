import javafx.fxml.FXML;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;

public class pokemon{
    public int id;
    public String name;
    public String description;
    public String imageRef;
    public String stats;
    
    public pokemon(int id, String name, String description, String imageRef, String stats){
        this.id=id;
        this.name=name;
        this.description=description;
        this.imageRef=imageRef;
        this.stats=stats;
    }
    @Override public String toString(){
        return (name + " " + imageRef);
    }
    
    public static void readAll(List<pokemon> list){
        list.clear();
        PreparedStatement statement = index.database.newStatement("SELECT * FROM pokemon");
        if (statement != null)
        {
            ResultSet results = index.database.runQuery(statement);
            
            if (results != null)
            {
                try {
                    while (results.next()) {
                        list.add( new pokemon(results.getInt("id"),
                                              results.getString("name"),
                                              results.getString("description"),
                                              results.getString("imageRef"),
                                              results.getString("stats")) );
                    }
                }
                catch (SQLException resultsexception)
                {
                    System.out.println("Database result processing error: " + resultsexception.getMessage());
                }
            }
        }
    }
}