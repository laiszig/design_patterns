package org.lais.factory;

import org.lais.buttons.Button;
import org.lais.buttons.WindowsButton;

public class WindowsDialog extends Dialog{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
