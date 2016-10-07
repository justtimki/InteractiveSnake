package by.edu.gstu;

import by.edu.gstu.controllers.WebCamController;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.opencv.highgui.VideoCapture;

public class SnakeGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

    private VideoCapture webcam;
    WebCamController webCamController;

	@Override
	public void create () {
        try {
            batch = new SpriteBatch();
            webcam = new VideoCapture(0);
            webCamController = new WebCamController(webcam);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        img = webCamController.fetchTextureFromCam();
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
        webcam.release();
	}
}
