import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller {
    private static final int ORANGE_PRICE = 3;
    private static final int APPLE_PRICE = 4;
    private static final int BANANA_PRICE = 5;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private Button submit;

    @FXML
    private Label total;

    @FXML
    void On_submit(ActionEvent event) {
        int totalPrice = (spinner_item1.getValue() * ORANGE_PRICE)
                + (spinner_item2.getValue() * APPLE_PRICE)
                + (spinner_item3.getValue() * BANANA_PRICE);
        total.setText("$" + totalPrice);
    }

    @FXML
    void on_scroll(MouseEvent event) {

    }
    VBox vbox = new VBox();
    // --- ITEM 1: Orange ($3) ---
    HBox hbox1 = new HBox();
    Label label_item1 = new Label("Orange");
    Label label_item1_price = new Label("$" + ORANGE_PRICE);
    ImageView imageview_item_1 = new ImageView();
    Spinner<Integer> spinner_item1 = new Spinner<>(0, 10, 0);

    // --- ITEM 2: Apple ($4) ---
    HBox hbox2 = new HBox();
    Label label_item2 = new Label("Apple");
    Label label_item2_price = new Label("$" + APPLE_PRICE);
    ImageView imageview_item_2 = new ImageView();
    Spinner<Integer> spinner_item2 = new Spinner<>(0, 10, 0);

    // --- ITEM 3: Banana ($5) ---
    HBox hbox3 = new HBox();
    Label label_item3 = new Label("Banana");
    Label label_item3_price = new Label("$" + BANANA_PRICE);
    ImageView imageview_item_3 = new ImageView();
    Spinner<Integer> spinner_item3 = new Spinner<>(0, 10, 0);

    @FXML
    void initialize() {
        // --- IMAGE LOADING BLOCK ---
        loadImage(imageview_item_1, "orange.jpg");
        loadImage(imageview_item_2, "item3.jpeg");
        loadImage(imageview_item_3, "item4.jpeg");

        // --- LAYOUT AND STRUCTURING ---
        vbox.setSpacing(15); // Adds vertical spacing between each row
        vbox.getChildren().clear();

        // Configure Row 1
        configureRow(hbox1, imageview_item_1, label_item1, label_item1_price, spinner_item1);
        
        // Configure Row 2
        configureRow(hbox2, imageview_item_2, label_item2, label_item2_price, spinner_item2);
        
        // Configure Row 3
        configureRow(hbox3, imageview_item_3, label_item3, label_item3_price, spinner_item3);

        // Add rows to VBox and mount to ScrollPane
        vbox.getChildren().addAll(hbox1, hbox2, hbox3);
        scrollpane.setContent(vbox);
    }

    // Helper method to keep image configurations and sizes unified
    private void loadImage(ImageView iv, String filename) {
        try {
            java.net.URL imageUrl = getClass().getResource(filename);
            if (imageUrl != null) {
                javafx.scene.image.Image img = new javafx.scene.image.Image(imageUrl.toExternalForm());
                iv.setImage(img);
            } else {
                System.out.println("Image resource not found: " + filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        iv.setFitWidth(60);
        iv.setFitHeight(60);
        iv.setPreserveRatio(true);
    }

    // Helper method to keep alignment and spacing matching perfectly across rows
    private void configureRow(HBox row, ImageView iv, Label name, Label price, Spinner<Integer> spin) {
        row.setSpacing(20);
        row.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        row.getChildren().clear();
        row.getChildren().addAll(iv, name, price, spin);
    }
}
