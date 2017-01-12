package edu.rpg.mapeditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dym.rpg.Input;
import dym.rpg.entities.Entity;
import dym.rpg.graphics.Image;
import dym.rpg.graphics.shading.Light;
import dym.rpg.physics.CollisionMap;
import dym.rpg.physics.Vector2;
import dym.rpg.tile.Tile;
import dym.rpg.tile.TileMap;
import dym.rpg.tile.Tiles;

public class MapEditor extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5156583402135090840L;
	private static Input i;
	
	Image[] tileArray = {
			Tiles.tile_grass1,
			Tiles.tile_boulder_brown,
			Tiles.tile_boulder_grey,
			Tiles.tile_lamp_base,
			Tiles.tile_lamp_post,
			Tiles.tile_lamp
		};
	int index = 0;
	JFrame frame;
	int x = 0;
	int y = 0;
	boolean m1d = false; //as in "Mouse Button 1 down
	
	public TileMap tileMap;
	public CollisionMap collisionMap;
	public ArrayList<Entity> entities;
	public ArrayList<Light> lights;
	
	public MapEditor() {
		super();
		Tiles.init();
		i = new Input();
		tileMap = new TileMap();
		collisionMap = new CollisionMap();
		entities = new ArrayList<Entity>();
		lights = new ArrayList<Light>();
		
		frame = new JFrame("Map Editor V1.0");
		//frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setSize(1280,720);
		frame.setContentPane(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addMouseListener(this);
		frame.addKeyListener(i);
		
		while (true) {
			tileSelect();
			repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String args[]) {
		new MapEditor();
	}
	@Override
	public void paintComponent(Graphics g) {
		Iterator<Tile> iter = tileMap.mainTiles.iterator();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1280, 720);
		g.setColor(Color.WHITE);
		/*for (int x = 0; x<1280; x+=16) {
			g.drawLine(x, 0, x, 720);
		}
		for (int y = 0; y<720; y+=16) {
			g.drawLine(0, y, 1280, y);
		}*/
		tileMap.drawTilesEditor(g);
		g.setColor(Color.CYAN);
		x = 0;
		y = 0;
		try {
		x = getMousePosition().x-getMousePosition().x%16;
		y = getMousePosition().y-getMousePosition().y%16;
		g.drawRect(x-1, y-1, 18, 18);
		while (iter.hasNext()){
			Tile t = iter.next();
			if (m1d == true)
				for (Tile r:tileMap.mainTiles) {
					if (r.pos.x==x&&r.pos.y==y) {
						tileMap.mainTiles.remove(r);
						iter.remove();
					}
				}
				tileMap.mainTiles.add(new Tile(new Vector2(x,y), tileArray[index]));
				
			}
		
		
		} 
		catch (NullPointerException e) {
			System.err.println("Null Mouse Pointer Exception");
		}
	}
	
	public void tileSelect(){
		if(Input.keysDown.contains(KeyEvent.VK_1)){
			index = 0;
		}
		if(Input.keysDown.contains(KeyEvent.VK_2)){
			index = 1;
		}
		if(Input.keysDown.contains(KeyEvent.VK_3)){
			index = 2;
		}
		if(Input.keysDown.contains(KeyEvent.VK_4)){
			index = 3;
		}
		if(Input.keysDown.contains(KeyEvent.VK_5)){
			index = 4;
		}
		if(Input.keysDown.contains(KeyEvent.VK_6)){
			index = 5;
		}
	/*	if (Input.keysDown.contains(KeyEvent.VK_LEFT)) {
			if (index>0)
			index--;
		}
		if (Input.keysDown.contains(KeyEvent.VK_RIGHT)) {
			if (index<=tileArray.length)
				index++;
		} */
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		//place tileArray[index]; at pos x,y
		m1d = true;
		System.out.println(index);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		m1d = false;
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
}
