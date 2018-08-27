package Poe.Models;

import Poe.Drawable.Drawable;

public class Player extends GameObject {

    @Override
    public void update() {

    }

    @Override
    public void render(){
        Drawable.fillRect(x, y, width, height);
    }
}
