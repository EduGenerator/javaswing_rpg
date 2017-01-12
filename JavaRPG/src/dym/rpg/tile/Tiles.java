package dym.rpg.tile;

import java.io.File;
import java.util.HashMap;

import dym.rpg.graphics.Image;

public class Tiles {
	public static Image tile_grass1 = new Image(new File("res"+File.separator+"tiles"+File.separator+"grass1.png"));
	public static Image tile_rock = new Image(new File("res"+File.separator+"tiles"+File.separator+"rock.png"));
	public static Image tile_boulder_brown = new Image(new File("res"+File.separator+"tiles"+File.separator+"brown_boulder.png"));
	public static Image tile_boulder_grey = new Image(new File("res"+File.separator+"tiles"+File.separator+"grey_boulder.png"));
	public static Image tile_lamp_base = new Image(new File("res"+File.separator+"tiles"+File.separator+"lampbase.png"));
	public static Image tile_lamp_post = new Image(new File("res"+File.separator+"tiles"+File.separator+"lamppost.png"));
	public static Image tile_lamp= new Image(new File("res"+File.separator+"tiles"+File.separator+"lamp.png"));
	
	public static HashMap<String, Image> tiles = new HashMap<String, Image>();
	
	public static void init() {
		tiles.put("grass1", tile_grass1);
		tiles.put("grass1", tile_rock);
		tiles.put("grass1", tile_boulder_brown);
		tiles.put("grass1", tile_boulder_grey);
		tiles.put("grass1", tile_lamp_base);
		tiles.put("grass1", tile_lamp_post);
		tiles.put("grass1", tile_lamp);
	}
}
