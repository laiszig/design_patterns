package org.lais.factory;

import org.lais.buttons.Button;
import org.lais.buttons.HtmlButton;

public class HtmlDialog extends Dialog{

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
