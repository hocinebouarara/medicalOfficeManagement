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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
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
    @FXML
    private VBox menuScorll;

    boolean menuIsActive;
    boolean notificationsIsActive;
    int countMenu;
    int countNotif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image = new Image(Links.PROFILEIMAGE);
        circle.setFill(new ImagePattern(image));
        slideTransition(slideAnchor, 420, 0.1);
        menuIsActive = false;
        notificationsIsActive = false;
        countMenu = 1;
        countNotif = 1;
        menuBtn.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                slideTransition(menuSlide, -420, 400);
                menuIsActive = true;
                countMenu = 0;

            }
        });
        removeMenuBtm.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                slideTransition(menuSlide, 420, 400);
                menuIsActive = false;
                countMenu = 1;

            }
        });
        notificationBtn.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                slideTransition(notificationsSlide, -420, 400);
                notificationsIsActive = true;
                countNotif = 0;
            }
        });
        removeNotificationsBtn.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                slideTransition(notificationsSlide, 420, 400);
                notificationsIsActive = false;
                countNotif = 1;
                

            }
        });

        anchor.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                countMenu++;
                countNotif++;
                if (notificationsIsActive = true && countNotif == 1) {
                    slideTransition(notificationsSlide, 420, 400);
                    notificationsIsActive = false;
                }
                if (menuIsActive = true && countMenu == 1) {
                    slideTransition(menuSlide, 420, 400);
                    menuIsActive = false;

                }

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

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    }



}
