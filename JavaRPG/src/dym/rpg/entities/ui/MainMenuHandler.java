package dym.rpg.entities.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dym.rpg.Display;
import dym.rpg.Game;
import dym.rpg.Input;
import dym.rpg.entities.Entity;
import dym.rpg.scene.Scene;
import dym.rpg.scene.SceneManager;

public class MainMenuHandler extends Entity {
	public static final int menuButtons = 2;
	private static int arrowlocation; 
	public static final Scene[] selectionDestinations = {SceneManager.currentScene, SceneManager.currentScene, SceneManager.settings};


	public MainMenuHandler() {
		super();
		//Set the starting arrow location;
				arrowlocation = 13;
	}
	
	public void resetSelection() {
		arrowlocation = 13;
	}
	
	@Override
	public void update() {
		Game.uiMenuArrow.animate();
		if (Input.keysDown.contains(KeyEvent.VK_LEFT)) {
		
			Input.keysDown.remove((Object)KeyEvent.VK_LEFT);
		}
		if (Input.keysDown.contains(KeyEvent.VK_RIGHT)) {
			
			Input.keysDown.remove((Object)KeyEvent.VK_RIGHT);
		}
		
		if (Input.keysDown.contains(KeyEvent.VK_UP)) {
			//Move arrow down
			if (arrowlocation<13+20*(menuButtons-1)) {
				arrowlocation+=20;
				}
				
			Input.keysDown.remove((Object)KeyEvent.VK_UP);
		}
		
		if (Input.keysDown.contains(KeyEvent.VK_DOWN)) {
			//Move arrow down
			if (arrowlocation<13+20*(menuButtons-1)) {
				arrowlocation+=20;
			}
			
			
			Input.keysDown.remove((Object)KeyEvent.VK_DOWN);
		}
		
		if (Input.keysDown.contains(KeyEvent.VK_ENTER)){
			SceneManager.gotoScene(selectionDestinations[(int)((arrowlocation-13)/20)]);
			Game.p.menu = false;
			Game.p.busy = false;
			Input.keysDown.remove((Object)KeyEvent.VK_ENTER);
		}
	}
	
	@Override
	public void draw(Graphics g) {
		Game.uiMainMenu.drawUI(g, 0, 0);
		Game.uiNG_u.drawUI(g, 500, 300);
	}
}
