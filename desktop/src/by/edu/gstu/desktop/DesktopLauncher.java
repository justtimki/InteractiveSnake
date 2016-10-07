package by.edu.gstu.desktop;

import by.edu.gstu.SnakeGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.opencv.core.Core;

public class DesktopLauncher {

    /*
      Load openCV library.
     */
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SnakeGame(), config);
	}
}
