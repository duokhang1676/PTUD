/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class ResizeContent {
    public static void resizeContent(JPanel p){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        p.setPreferredSize(new Dimension((int)screenSize.getWidth(), (int)screenSize.getHeight() -220));
    }
}
