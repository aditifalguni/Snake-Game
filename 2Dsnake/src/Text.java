
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Text extends JPanel implements ActionListener, FocusListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField textField;
    protected JTextArea textArea;
    Gameplay gameplay = new Gameplay();
    static JFrame frame;

    public Text() {
        super(new GridBagLayout());

        textField = new JTextField(1);
        textField.addActionListener(this);
        textField.setBackground(Color.black);
        textField.setFont(new Font("arial", Font.BOLD, 20));
        textField.setForeground(Color.white);
        textField.addFocusListener(this);

        textArea = new JTextArea(11, 26);
        textArea.setEditable(false);
        textArea.append("Congrats! \nEnter your name to register your High Score!");
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.white);
        textArea.setFont(new Font("arial", Font.BOLD, 20));
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
    }

    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        if (text.matches("")) {
        	text="Anon";
        }
        text=text.replaceAll("\\s","");
        gameplay.name = text;
        textField.selectAll();

        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());
        frame.dispose();
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setUndecorated(true);

        //Add contents to the window.
        frame.add(new Text());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        frame.setLocationRelativeTo(null);
        
    }
    

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

	@Override
	public void focusGained(FocusEvent arg0) {
		if (textField.getText().length()!=0) {
			textField.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
    	textField.setText("Enter name here");
	}
}
