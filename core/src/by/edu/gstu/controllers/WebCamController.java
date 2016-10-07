package by.edu.gstu.controllers;

import com.badlogic.gdx.graphics.Texture;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;

/**
 * Created by Alexandr Kolymago on 10/8/2016.
 */
public class WebCamController {

    private static final String IMG_NAME = "camera.jpg";
    private Mat webcamImage;
    private VideoCapture webcam;

    /**
     * Construct WebCamController
     * @param webcam used web camera
     */
    public WebCamController(final VideoCapture webcam) {
        webcamImage = new Mat();
        this.webcam = webcam;
    }

    /**
     * Fetch picture from web camera and convert it to jpg image.
     * @return texture which represent camera view.
     */
    public Texture fetchTextureFromCam() {
        webcam.read(webcamImage);

        Highgui.imwrite(IMG_NAME, webcamImage);

        return new Texture(IMG_NAME);
    }
}
