package by.edu.gstu.desktop;

import by.edu.gstu.SnakeGame;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.opencv.core.Core;

/**
 * App start point class.
 */
public final class DesktopLauncher {

    /*
      Load openCV library.
     */
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    /**
     * Default constructor.
     */
    private DesktopLauncher() { }

    /**
     * App start point method.
     * @param arg command line args.
     */
	public static void main(final String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SnakeGame(), config);
	}
}
