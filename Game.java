import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This is a simplified version of a common card game, "21"
 * for Assignment 4. 
 *
 * The players take turns requesting cards, trying to get
 * as close to 21 as possible, but not going over 21. A player
 * may stand (ask for no more cards). Once a player has passed,
 * he or she cannot later ask for another card. When all three
 * players have passed, the game ends.
 *
 * The winner is the player who has come closest to 21 without
 * exceeding it. In the case of a tie, or if everyone goes over
 * 21, no one wins.
 * 
 * Per the assignment, we assume exactly three players. The game 
 * is only played once.
 */
public class Game extends Application {

	// An ArrayList to store the 3 Player objects 
	static ArrayList<Player> players;

	// An ArrayList to store the deck of cards
	static ArrayList<Card> cardDeck;
	
	public void start(Stage primaryStage) {
		/* TODO: Add your code */ 

		cardDeck = new ArrayList<Card>();
		initDeck(cardDeck);
		
		Pane pane = new Pane();
		
		// Display a single card
		// TODO: update this snippet to fit your GUI and move it to an appropriate place
		try { 
			Image pic = new Image(new FileInputStream("images/3C.png"), 70, 100, false, false);
			ImageView cardImage = new ImageView();
			cardImage.setImage(pic);
			pane.getChildren().add(cardImage);
		}
		catch (FileNotFoundException e) {	
			System.out.println(e.getMessage());
		}


		// Create a Scene
		Scene scene = new Scene(pane, 500, 500);

		// Make changes to the stage
		primaryStage.setTitle("Blackjack"); // Set the stage title

		// Place the scene in the stage
		primaryStage.setScene(scene); 

		// Display the stage	
		primaryStage.show(); 
	}

	
	public static void initDeck(ArrayList<Card> d) {
		
		String[] suits = new String[] {"C", "D", "H", "S"};
		String[] faces = new String[] {"J", "Q", "K", "A"};
		
		for (String s: suits) {           
	        for(int i = 2; i < 11; i++) {
	        		// Create and add a new card for each of the numbered cards
	        		String name = i + s; 
	        		String imagePath = "images/" + name + ".png";
	        		Card c = new Card(name, imagePath, i);
	        		d.add(c);
	        }
	    } 
		
		for (String s:suits) {           
	        for(String f:faces) {
	        		// Create and add a new card for each of the face cards
	        		String name = f + s; 
	        		String imagePath = "images/" + name + ".png";
	        		
	        		if( f.equals("A") )
	        			d.add(new Card(name, imagePath, 11));
	        		else	
	        			d.add(new Card(name, imagePath, 10));
	        }
	    } 
	}

	
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
  public static void main(String[] args) {
      launch(args);
  }
  
}