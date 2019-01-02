package Poe.Models.Entities;

import Poe.Drawable.Animation;
import Poe.Engine.GameLoop;
import Poe.Engine.Input.KeyInput;
import Poe.Engine.Input.MouseInput;
import Poe.Models.Item.Weapons.Projectile.Bow;
import Poe.Models.Item.Weapons.Projectile.Projectile;
import Poe.Models.Item.Weapons.Projectile.ThrowingStar;
import Poe.ResourceManager.ImageResource;
import Poe.Engine.Utlities.GameUtils;
import Poe.World.World;
import com.jogamp.newt.event.KeyEvent;

import java.util.ArrayList;

public class Player extends Entity {

    public boolean currentlyRangeAttacking = false;
    public boolean rangeClick = false;

    public boolean currentlyMeleeAttacking = false;
    public boolean meleeClick = false;

    private Projectile[] rangeWeapons = new Projectile[2];
    private int rangeWeaponIndex = 0;

    public Player() {
        this.width = 1.5f;
        this.height = 1.5f;
        this.velocity = 6;
        this.id = World.currentLevel.generateId();
        animations = new ArrayList<>();
        Animation walking = new Animation();
        walking.frames = new ImageResource[1];
        String uri =  "/Images/Poe.png";
        walking.frames[0] = new ImageResource(this.getClass().getResourceAsStream(uri));
        animations.add(walking);
        rangeWeapons[0] = new ThrowingStar();
        rangeWeapons[1] = new Bow();
    }

    @Override
    public void update() {

        float xInput = 0;
        float yInput = 0;

        if(KeyInput.getKey(KeyEvent.VK_A) && canMoveLeft) {
            xInput -= velocity;
        }
        if(KeyInput.getKey(KeyEvent.VK_D) && canMoveRight) {
            xInput += velocity;
        }
        if(KeyInput.getKey(KeyEvent.VK_W) && canMoveUp) {
            yInput += velocity;
        }
        if(KeyInput.getKey(KeyEvent.VK_S) && canMoveDown) {
            yInput -= velocity;
        }

        X += xInput * GameLoop.getDelta();
        Y += yInput * GameLoop.getDelta();
        rotation = GameUtils.getAngle(MouseInput.getWorldX(), MouseInput.getWorldY(), X, -Y);

        if(rangeClick && !currentlyRangeAttacking) {
            this.rangeAttack();
        }
        canMoveLeft = true;
        canMoveUp = true;
        canMoveDown = true;
        canMoveRight = true;
    }

    public void rangeAttack() {
        this.currentlyRangeAttacking = true;
        World.activeRangeWeapon.setInstanceLocation(this.X, this.Y);
        World.activeRangeWeapon.rotation = rotation;
    }

    public Projectile getRangeWeapon() {
        return rangeWeapons[rangeWeaponIndex];
    }

    public void scrollRangeWeapons() {
        rangeWeaponIndex++;
        if(rangeWeaponIndex > rangeWeapons.length - 1) {
            rangeWeaponIndex = 0;
        }
    }

    @Override
    public void recieveHit(float hitAmount) {
        this.health -= hitAmount;
    }

}

