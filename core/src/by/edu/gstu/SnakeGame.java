package by.edu.gstu;

import by.edu.gstu.controllers.WebCamController;
import by.edu.gstu.utils.AssetsUtil;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.opencv.highgui.VideoCapture;

/**
 * Game main loop.
 */
public class SnakeGame extends ApplicationAdapter {

    private SpriteBatch batch;
	private Texture webCamImg;
	private Texture cubeImg;
    private VideoCapture webcam;
    private WebCamController webCamController;

	@Override
	public void create() {
        try {
            batch = new SpriteBatch();
            cubeImg = AssetsUtil.CUBE_ASSET;
            webcam = new VideoCapture(0);
            webCamController = new WebCamController(webcam);
            // need time to initialize web cam
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        webCamImg = webCamController.fetchTextureFromCam();
        batch.begin();
        batch.draw(webCamImg, 0, 0);
        batch.draw(cubeImg, 0, 0);
        batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		webCamImg.dispose();
        webcam.release();
	}
}
