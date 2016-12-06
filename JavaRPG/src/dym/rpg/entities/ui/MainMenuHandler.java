package dym.rpg.entities.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import dym.rpg.Display;
import dym.rpg.Input;
import dym.rpg.entities.Entity;
import dym.rpg.scene.SceneManager;

public class MainMenuHandler extends Entity {
	public MainMenuHandler() {
		super();
		
	}
	@Override
	public void update() {
		if (Input.keysDown.contains(KeyEvent.VK_LEFT)) {
		
			Input.keysDown.remove((Object)KeyEvent.VK_LEFT);
		}
		if (Input.keysDown.contains(KeyEvent.VK_RIGHT)) {
			
			Input.keysDown.remove((Object)KeyEvent.VK_RIGHT);
		}
		if (Input.keysDown.contains(KeyEvent.VK_UP)) {
			
			
			
			Input.keysDown.remove((Object)KeyEvent.VK_UP);
		}
		if (Input.keysDown.contains(KeyEvent.VK_DOWN)) {
			
			
			
			Input.keysDown.remove((Object)KeyEvent.VK_DOWN);
		}
	}
	
	@Override
	public void draw(Graphics g) {
		
	}
}
