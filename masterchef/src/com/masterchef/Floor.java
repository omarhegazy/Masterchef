package com.masterchef;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Floor extends Sprite {
	
	BodyDef bodyDef;
	Body body;
	PolygonShape ps;
	FixtureDef fd;
	Fixture f;
	
	public Floor(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
		super(texture, srcX, srcY, srcWidth, srcHeight);
		
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.StaticBody;
		bodyDef.position.set(0, 0);
		
		body = Registry.world.createBody(bodyDef);
		
		ps = new PolygonShape();
		Vector2[] vertices = new Vector2[4];
		vertices[0] = new Vector2(0, 0);
		vertices[1] = new Vector2(80.0f, 0);
		vertices[2] = new Vector2(80.0f, 1.6f);
		vertices[3] = new Vector2(0, 1.6f);
		ps.set(vertices);
		//ps.setAsBox(20.0f, 0.2f);
		ps.setRadius(0.0f);
		
		fd = new FixtureDef();
		fd.shape = ps;
		fd.density = 0.5f;
		fd.friction = 0.9f;
		fd.restitution = 0.2f;
		
		f = body.createFixture(fd);
		
		ps.dispose();
	}

}
