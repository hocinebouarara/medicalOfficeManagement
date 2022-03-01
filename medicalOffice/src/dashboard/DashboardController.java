/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import com.jfoenix.controls.JFXDrawer;
import helpres.Links;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hocin
 */
public class DashboardController implements Initializable {

    @FXML
    private BorderPane anchor;
    @FXML
    private Button menuBtn;
    @FXML
    private Button notificationBtn;
    @FXML
    private Button removeMenuBtm;
    @FXML
    private VBox menuSlide;
    @FXML
    private VBox notificationsSlide;
    @FXML
    private Button removeNotificationsBtn;
    @FXML
    private AnchorPane slideAnchor;
    @FXML
    private Circle circle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image = new Image(Links.PROFILEIMAGE);
        circle.setFill(new ImagePattern(image));
        slideTransition(slideAnchor, 400, 0.1);
        menuBtn.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                slideTransition(menuSlide, -400, 400);

            }
        });
        removeMenuBtm.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                slideTransition(menuSlide, 400, 400);

            }
        });
        notificationBtn.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                slideTransition(notificationsSlide, -400, 400);

            }
        });
        removeNotificationsBtn.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                slideTransition(notificationsSlide, 400, 400);

            }
        });

    }

    void slideTransition(Node node, double x, double t) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(t), node);
        tt.setByX(x);
        tt.fromXProperty();
        //tt.setCycleCount((int) 4f);
        //tt.setAutoReverse(true);
        tt.play();
    }

}
