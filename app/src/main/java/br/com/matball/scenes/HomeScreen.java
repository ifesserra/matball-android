package br.com.matball.scenes;

import org.cocos2d.actions.instant.CCCallFunc;
import org.cocos2d.actions.interval.CCFadeIn;
import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.actions.interval.CCRotateBy;
import org.cocos2d.actions.interval.CCScaleTo;
import org.cocos2d.actions.interval.CCSpawn;
import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.ccColor3B;

import java.util.concurrent.TimeUnit;
import br.com.matball.Device;
import br.com.matball.components.Button;
import br.com.matball.components.ButtonDelegate;
import br.com.matball.multimedia.Sprites;

public class HomeScreen extends DefaultScreen implements ButtonDelegate {
    private Button jogar, sair;

    public HomeScreen() {
        super();

        // Configura o logotipo do jogo
        CCSprite logotipo = Sprites.getByName("logotipo");
        logotipo.setPosition(CGPoint.make(
                Device.getScreenWidth() / 2f,
                // Topo + 150px da borda superior
                Device.getScreenHeight() - (logotipo.getContentSize().getHeight() / 2f) - 150
            )
        );

        this.addChild(logotipo);

        this.setIsTouchEnabled(true);
        criaBotoes();
    }

    private void criaBotoes(){
        CCLabel lblJogar = CCLabel.makeLabel("PLAY", "font/SigmarOne.otf", 60.0f);
        CCLabel lblSair = CCLabel.makeLabel("EXIT", "font/SigmarOne.otf", 60.0f);

        this.jogar = new Button(lblJogar);
        this.sair = new Button(lblSair);

        this.jogar.setDelegate(this);
        this.sair.setDelegate(this);

        posicionaBotoes();
        addChild(this.jogar);
        addChild(this.sair);

        animaEntrada();
    }

    @Override
    public void buttonClicked(Button button) {
        if(button.equals(this.jogar)){
            cliqueItem(button, "acaoJogar");
        }
        else if(button.equals(this.sair)){
            cliqueItem(button, "acaoSair");
        }
    }

    private void posicionaBotoes() {
        this.jogar.setPosition(0, 0);
        this.jogar.getLabel().setPosition(
                0 - this.jogar.getLabel().getBoundingBox().size.width / 2.0f,
                0
        );

        this.sair.setPosition(0, 0);
        this.sair.getLabel().setPosition(
                Device.getScreenWidth() + this.sair.getLabel().getBoundingBox().size.width / 2.0f,
                0
        );
    }

    public void animaEntrada(){
        CCFadeIn fadeIn = CCFadeIn.action(0.4f);

        CCMoveTo moveTo1 = CCMoveTo.action(0.4f,
                CGPoint.make(Device.getScreenWidth() / 2.0f, (Device.getScreenHeight() / 2f) - 100));

        CCMoveTo moveTo2 = CCMoveTo.action(0.4f,
                CGPoint.make(Device.getScreenWidth() / 2.0f, (Device.getScreenHeight() / 2f) - 180));

        this.jogar.getLabel().runAction(CCSpawn.actions(fadeIn.copy(), moveTo1));
        this.sair.getLabel().runAction(CCSpawn.actions(fadeIn.copy(), moveTo2));
    }

    private void cliqueItem(final Button bt, final String acao){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //bt.getLabel().runAction(CCRotateBy.action(0.2f, 360f));
                bt.getLabel().runAction(CCScaleTo.action(0.1f, 1.2f));
                bt.getLabel().setColor(ccColor3B.ccc3(241, 89, 78));
                CCCallFunc func = CCCallFunc.action(HomeScreen.this, acao);

                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    bt.runAction(func);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void acaoJogar(){/*
        CCDirector.sharedDirector().replaceScene(
                CCRotoZoomTransition.transition(0.2f, GameScreen.createGame()));
        jogar.setVisible(true);*/
    }

    public void acaoSair(){
        CCDirector.sharedDirector().getActivity().finish();
    }
}
