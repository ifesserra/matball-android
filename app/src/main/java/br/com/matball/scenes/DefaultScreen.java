package br.com.matball.scenes;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import br.com.matball.Device;
import br.com.matball.multimedia.Sprites;

public abstract class DefaultScreen extends CCLayer {
    protected CCSprite background;

    public CCScene scene(){
        CCScene scene = CCScene.node();
        scene.addChild(this);
        return scene;
    }

    public DefaultScreen() {
        // Configura o background da tela
        background = Sprites.getByName("background");
        background.setPosition(CGPoint.make(
                Device.getScreenWidth() / 2.0f,
                Device.getScreenHeight() / 2.0f
                )
        );

        this.addChild(background);
    }

    public static void stop() {

    }
}