package com.theinvader360.sitters.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.theinvader360.sitters.Renderer;
import com.theinvader360.sitters.Sitters;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "SiTTeRS";
        config.width = Renderer.WIDTH;
		config.height = Renderer.HEIGHT;
		new LwjglApplication(new Sitters(), config);
	}

}
