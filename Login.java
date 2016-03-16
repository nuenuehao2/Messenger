import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by yuedeng on 3/15/16.
 */
public class Login {
    public static void main(String[] args) {
        final JFrame login = new JFrame("Login");
        JPanel panel = new JPanel();
        final JTextField loginName = new JTextField(20);
        JButton enter = new JButton("Login");

        panel.add(loginName);
        panel.add(enter);
        login.setSize(300, 100);
        login.add(panel);
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ChatClient client = new ChatClient(loginName.getText());
                    login.setVisible(false);
                    login.dispose();
                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        loginName.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        ChatClient client = new ChatClient(loginName.getText());
                        login.setVisible(false);
                        login.dispose();
                    } catch (UnknownHostException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
