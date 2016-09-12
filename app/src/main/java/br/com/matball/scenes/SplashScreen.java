package br.com.matball.scenes;

import org.cocos2d.actions.base.CCAction;
import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.ccColor3B;
import java.util.concurrent.TimeUnit;
import br.com.matball.Device;
import br.com.matball.multimedia.Sprites;

public class SplashScreen extends DefaultScreen {

    public SplashScreen() {
        super();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    // Carrega o Logotipo
                    CCSprite logotipo = Sprites.getByName("logotipo");
                    logotipo.setPosition(CGPoint.make(
                            Device.getScreenWidth() / 2.0f,
                            - (logotipo.getContentSize().getHeight())
                            )
                    );

                    SplashScreen.this.addChild(logotipo);

                    CCAction action = CCMoveTo.action(1f,
                            CGPoint.make(Device.getScreenWidth() / 2.0f,
                            Device.getScreenHeight() / 2.0f));

                    logotipo.runAction(action);

                    TimeUnit.MILLISECONDS.sleep(1500);

                    CCLabel lblCarregando = CCLabel.makeLabel("Loading...", "font/SigmarOne.otf", 40.0f);
                    lblCarregando.setPosition(Device.getScreenWidth() / 2.0f, 80.0f);
                    lblCarregando.setColor(ccColor3B.ccc3(241, 89, 78));
                    SplashScreen.this.addChild(lblCarregando);

                    TimeUnit.SECONDS.sleep(2);

                    CCDirector.sharedDirector().replaceScene(
                            CCFadeTransition.transition(0.3f, new HomeScreen().scene()));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}