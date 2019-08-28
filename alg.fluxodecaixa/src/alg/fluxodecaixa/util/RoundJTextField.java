package alg.fluxodecaixa.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class RoundJTextField extends JTextField {
    Font font = new Font ("Tahoma", 1, 16);
    Color blueTxt = new Color (0, 123, 255);
    public RoundJTextField(int size) {
        // Seta o tamanho para do campo redondo do original
        super(size);
        // Desenha a borda interna - padding
        setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createEmptyBorder(6, 10, 6, 6)));
        // Fonte padrão
        setFont(font);
        // Cor da fonte
        setForeground(blueTxt);
        // Seta opacidade para 0
        setOpaque(false); // As suggested by @AVD in comment.
    }
    protected void paintComponent(Graphics g) {
        // Pega o background da cor original
        g.setColor(getBackground());
        // Desenha os cantos arredondados
        g.fillRoundRect(0, 0, getWidth()-1, getHeight(), 20, 20);
        // Transforma o componente original ao desenhado
        super.paintComponent(g);
    }
}
