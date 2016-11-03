package Menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class TbMenu extends TextButton {

    String sText;

    public TbMenu(String text, TextButton.TextButtonStyle tbs) {
        super(text, tbs);
        sText = text;
        this.setSize(200, 80);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent e, float x, float y) {
                System.out.println(sText);
            }
        });
    }
}
