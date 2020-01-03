package yku.game;

//import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JFormattedTextField;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;

public class MyClass extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel jContentPane = null;

    private JFormattedTextField input = null;

    private JButton guessAns = null;

    private JScrollPane jScrollPane = null;

    private JTextArea ansArea = null;

    private JButton start = null;

    private int ans = 0;

    private final int maxInt = 99;

    private JButton aboutMe = null;

    private JButton Ans = null;

    /**
     * This is the default constructor
     */
    public MyClass() {
        super();
        initialize();
        reStart();
    }

    public void reStart() {
        this.input.setText("");
        this.ansArea.setText("");
        java.util.Random r = new java.util.Random();
        this.ans = r.nextInt(maxInt) + 1;
        this.getInput().requestFocus();
    }

    public void doGuest() {
        int input_ans = 0;
        try {
            input_ans = Integer.parseInt(this.getInput().getText());
        } catch (Exception ex) {
            return;
        }
        if (input_ans > this.ans)
            this.getAnsArea().append(input_ans + "Less than answer!\n");
        else if (input_ans < this.ans)
            this.getAnsArea().append(input_ans + "More than answer!\n");
        else
            this.getAnsArea().append(input_ans + " Your right!\n");

        // ???????
        this.getInput().setText("");
        this.getInput().requestFocus();

    }

    public void doAns() {

        this.getAnsArea().append("Answer is:" + this.ans + "\n");
        this.getInput().setText("");
        this.getInput().requestFocus();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(300, 200);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width / 2 - this.getWidth() / 2,
                screenSize.height / 2 - this.getHeight() / 2);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setContentPane(getJContentPane());
        this.setTitle("MyClass");
        this.setVisible(true);
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getInput(), null);
            jContentPane.add(getGuessAns(), null);
            jContentPane.add(getJScrollPane(), null);
            jContentPane.add(getStart(), null);
            jContentPane.add(getAns(), null);

        }
        return jContentPane;
    }

    /**
     * This method initializes input
     *
     * @return javax.swing.JFormattedTextField
     */
    private JFormattedTextField getInput() {
        if (input == null) {
            javax.swing.text.NumberFormatter mf2 = null;
            mf2 = new javax.swing.text.NumberFormatter();
            mf2.setMaximum(new Integer(maxInt));
            mf2.setMinimum(new Integer(1));
            input = new JFormattedTextField(mf2);
            input.setBounds(new Rectangle(95, 2, 97, 78));
            input.setFont(new Font("Dialog", Font.PLAIN, 72));
            input.setHorizontalAlignment(JTextField.CENTER);
            input.setText("12");
        }
        return input;
    }

    /**
     * This method initializes guessAns
     *
     * @return javax.swing.JButton
     */
    private JButton getGuessAns() {
        if (guessAns == null) {
            guessAns = new JButton();
            guessAns.setBounds(new Rectangle(104, 92, 80, 36));
            guessAns.setText("Guess");
            guessAns.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    MyClass frame = ((MyClass) ((JButton) e.getSource())
                            .getTopLevelAncestor());
                    frame.doGuest();
                }
            });
        }
        return guessAns;
    }

    /**
     * This method initializes jScrollPane
     *
     * @return javax.swing.JScrollPane
     */
    private JScrollPane getJScrollPane() {
        if (jScrollPane == null) {
            jScrollPane = new JScrollPane();
            jScrollPane.setBounds(new Rectangle(195, 1, 98, 166));
            jScrollPane.setViewportView(getAnsArea());
        }
        return jScrollPane;
    }

    /**
     * This method initializes ansArea
     *
     * @return javax.swing.JTextArea
     */
    private JTextArea getAnsArea() {
        if (ansArea == null) {
            ansArea = new JTextArea();
        }
        return ansArea;
    }

    /**
     * This method initializes start
     *
     * @return javax.swing.JButton
     */
    private JButton getStart() {
        if (start == null) {
            start = new JButton();
            start.setBounds(new Rectangle(2, 1, 91, 34));
            start.setActionCommand("Return");
            start.setText("Return");
            start.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    MyClass frame = ((MyClass) ((JButton) e.getSource())
                            .getTopLevelAncestor());
                    frame.reStart();
                }
            });
        }
        return start;
    }

    /**
     * This method initializes Ans
     *
     * @return javax.swing.JButton
     */
    private JButton getAns() {
        if (Ans == null) {
            Ans = new JButton();
            Ans.setBounds(new Rectangle(11, 135, 71, 23));
            Ans.setText("Answer");
            Ans.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    MyClass frame = ((MyClass) ((JButton) e.getSource())
                            .getTopLevelAncestor());
                    frame.doAns();
                }
            });
        }
        return Ans;
    }

    /**
     * This method initializes aboutMe
     *
     * @return javax.swing.JButton
     */

    public static void main(String args[]) {
        new MyClass();
    }
}
