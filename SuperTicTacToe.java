import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;;

public class SuperTicTacToe implements ActionListener {

    Random rand = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel main_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[81];
    JPanel[] supers = new JPanel[9];
    int winarray[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    boolean turn;

    SuperTicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800); // Adjusted size for better visibility
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(Color.DARK_GRAY);
        textfield.setForeground(Color.GREEN);
        textfield.setFont(new Font("Ink Free", Font.BOLD, 65));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Super TicTacToe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 50);

        main_panel.setLayout(new GridLayout(3, 3));
        main_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            supers[i] = new JPanel();
            supers[i].setLayout(new GridLayout(3, 3));
            supers[i].setBackground(new Color(150, 150, 150));
            supers[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            for (int j = i * 9; j < (i * 9 + 9); j++) {
                buttons[j] = new JButton();
                supers[i].add(buttons[j]);
                buttons[j].setFont(new Font("MV Boli", Font.BOLD, 30));
                buttons[j].setFocusable(false);
                buttons[j].addActionListener(this);
            }
        }

        for (int i = 0; i < 9; i++) {
            main_panel.add(supers[i]);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(main_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int j = 0; j < 9; j++)
            for (int i = j * 9; i < (j * 9 + 9); i++) {
                if (e.getSource() == buttons[i]) {
                    if (turn) {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(Color.RED);
                            buttons[i].setText("X");
                            turn = false;
                            textfield.setText("O's Turn");
                            creator();
                            check(j);
                        }
                    } else {
                        if (buttons[i].getText() == "") {
                            buttons[i].setForeground(Color.BLUE);
                            buttons[i].setText("O");
                            turn = true;
                            textfield.setText("X's Turn");
                            creator();
                            check(j);
                        }
                    }
                }
            }

    }

    public void firstTurn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (rand.nextInt(2) == 0) {
            turn = true;
            textfield.setText("X's Turn");
        } else {
            turn = false;
            textfield.setText("O's Turn");
        }
    }

    public void check(int i) {
        i = i * 9;
        // check X win conditions
        if ((buttons[(i + 0)].getText() == "X") &&
                (buttons[(i + 1)].getText() == "X") &&
                (buttons[(i + 2)].getText() == "X")) {
            xWins(i + 0, i + 1, i + 2, i);
        }
        if ((buttons[(i + 3)].getText() == "X") &&
                (buttons[(i + 4)].getText() == "X") &&
                (buttons[(i + 5)].getText() == "X")) {
            xWins(i + 3, i + 4, i + 5, i);
        }
        if ((buttons[(i + 6)].getText() == "X") &&
                (buttons[(i + 7)].getText() == "X") &&
                (buttons[(i + 8)].getText() == "X")) {
            xWins(i + 6, i + 7, i + 8, i);
        }
        if ((buttons[(i + 0)].getText() == "X") &&
                (buttons[(i + 3)].getText() == "X") &&
                (buttons[(i + 6)].getText() == "X")) {
            xWins(i + 0, i + 3, i + 6, i);
        }
        if ((buttons[(i + 1)].getText() == "X") &&
                (buttons[(i + 4)].getText() == "X") &&
                (buttons[(i + 7)].getText() == "X")) {
            xWins(i + 1, i + 4, i + 7, i);
        }
        if ((buttons[(i + 2)].getText() == "X") &&
                (buttons[(i + 5)].getText() == "X") &&
                (buttons[(i + 8)].getText() == "X")) {
            xWins(i + 2, i + 5, i + 8, i);
        }
        if ((buttons[(i + 0)].getText() == "X") &&
                (buttons[(i + 4)].getText() == "X") &&
                (buttons[(i + 8)].getText() == "X")) {
            xWins(i + 0, i + 4, i + 8, i);
        }
        if ((buttons[(i + 2)].getText() == "X") &&
                (buttons[(i + 4)].getText() == "X") &&
                (buttons[(i + 6)].getText() == "X")) {
            xWins(i + 2, i + 4, i + 6, i);
        }
        // check O win conditions
        if ((buttons[(i + 0)].getText() == "O") &&
                (buttons[(i + 1)].getText() == "O") &&
                (buttons[(i + 2)].getText() == "O")) {
            oWins(i + 0, i + 1, i + 2, i);
        }
        if ((buttons[(i + 3)].getText() == "O") &&
                (buttons[(i + 4)].getText() == "O") &&
                (buttons[(i + 5)].getText() == "O")) {
            oWins(i + 3, i + 4, i + 5, i);
        }
        if ((buttons[(i + 6)].getText() == "O") &&
                (buttons[(i + 7)].getText() == "O") &&
                (buttons[(i + 8)].getText() == "O")) {
            oWins(i + 6, i + 7, i + 8, i);
        }
        if ((buttons[(i + 0)].getText() == "O") &&
                (buttons[(i + 3)].getText() == "O") &&
                (buttons[(i + 6)].getText() == "O")) {
            oWins(i + 0, i + 3, i + 6, i);
        }
        if ((buttons[(i + 1)].getText() == "O") &&
                (buttons[(i + 4)].getText() == "O") &&
                (buttons[(i + 7)].getText() == "O")) {
            oWins(i + 1, i + 4, i + 7, i);
        }
        if ((buttons[(i + 2)].getText() == "O") &&
                (buttons[(i + 5)].getText() == "O") &&
                (buttons[(i + 8)].getText() == "O")) {
            oWins(i + 2, i + 5, i + 8, i);
        }
        if ((buttons[(i + 0)].getText() == "O") &&
                (buttons[(i + 4)].getText() == "O") &&
                (buttons[(i + 8)].getText() == "O")) {
            oWins(i + 0, i + 4, i + 8, i);
        }
        if ((buttons[(i + 2)].getText() == "O") &&
                (buttons[(i + 4)].getText() == "O") &&
                (buttons[(i + 6)].getText() == "O")) {
            oWins(i + 2, i + 4, i + 6, i);
        }

    }

    public void creator(){
        int count1=0;
        int count2=0;
        for(int i=0;i<9;i++){
            if(buttons[(9*i)+4].getText() == "X"){
                count1++;
            }
            if(buttons[(9*i)+4].getText() == "O"){
                count2++;
            }
        }
        if(count1 == 9 || count2 == 9){
            textfield.setText("Made By Black Stack <3");
        }
    }

    public void checkmain() {
        if ((winarray[0] == 1) &&
                (winarray[1] == 1) &&
                (winarray[2] == 1)) {
            Xmainwin(0, 1, 2);
        }
        if ((winarray[3] == 1) &&
                (winarray[4] == 1) &&
                (winarray[5] == 1)) {
            Xmainwin(3, 4, 5);
        }
        if ((winarray[6] == 1) &&
                (winarray[7] == 1) &&
                (winarray[8] == 1)) {
            Xmainwin(6, 7, 8);
        }
        if ((winarray[0] == 1) &&
                (winarray[3] == 1) &&
                (winarray[6] == 1)) {
            Xmainwin(0, 3, 6);
        }
        if ((winarray[1] == 1) &&
                (winarray[4] == 1) &&
                (winarray[7] == 1)) {
            Xmainwin(1, 4, 7);
        }
        if ((winarray[2] == 1) &&
                (winarray[5] == 1) &&
                (winarray[8] == 1)) {
            Xmainwin(2, 5, 8);
        }
        if ((winarray[0] == 1) &&
                (winarray[4] == 1) &&
                (winarray[8] == 1)) {
            Xmainwin(0, 4, 8);
        }
        if ((winarray[2] == 1) &&
                (winarray[4] == 1) &&
                (winarray[6] == 1)) {
            Xmainwin(2, 4, 6);
        }
        // check -1 win c-1nditi-1ns
        if ((winarray[0] == -1) &&
                (winarray[1] == -1) &&
                (winarray[2] == -1)) {
            Omainwin(0, 1, 2);
        }
        if ((winarray[3] == -1) &&
                (winarray[4] == -1) &&
                (winarray[5] == -1)) {
            Omainwin(3, 4, 5);
        }
        if ((winarray[6] == -1) &&
                (winarray[7] == -1) &&
                (winarray[8] == -1)) {
            Omainwin(6, 7, 8);
        }
        if ((winarray[0] == -1) &&
                (winarray[3] == -1) &&
                (winarray[6] == -1)) {
            Omainwin(0, 3, 6);
        }
        if ((winarray[1] == -1) &&
                (winarray[4] == -1) &&
                (winarray[7] == -1)) {
            Omainwin(1, 4, 7);
        }
        if ((winarray[2] == -1) &&
                (winarray[5] == -1) &&
                (winarray[8] == -1)) {
            Omainwin(2, 5, 8);
        }
        if ((winarray[0] == -1) &&
                (winarray[4] == -1) &&
                (winarray[8] == -1)) {
            Omainwin(0, 4, 8);
        }
        if ((winarray[2] == -1) &&
                (winarray[4] == -1) &&
                (winarray[6] == -1)) {
            Omainwin(2, 4, 6);
        }

    }

    public void xWins(int a, int b, int c, int d) {
        buttons[a].setBackground(Color.red);
        buttons[b].setBackground(Color.red);
        buttons[c].setBackground(Color.red);

        for (int i = d; i < d + 9; i++) {
            buttons[i].setEnabled(false);
        }
        winarray[(d / 9)] = 1;
        checkmain();
    }

    public void oWins(int a, int b, int c, int d) {
        buttons[a].setBackground(Color.blue);
        buttons[b].setBackground(Color.blue);
        buttons[c].setBackground(Color.blue);

        for (int i = d; i < d + 9; i++) {
            buttons[i].setEnabled(false);
        }
        winarray[(d / 9)] = -1;
        checkmain();
    }

    public void Xmainwin(int a, int b, int c) {
        supers[a].removeAll();
        supers[a].setBackground(Color.GREEN);
        supers[b].removeAll();
        supers[b].setBackground(Color.GREEN);
        supers[c].removeAll();
        supers[c].setBackground(Color.GREEN);

        JLabel giantX = new JLabel("X");
        JLabel giantX2 = new JLabel("X");
        JLabel giantX3 = new JLabel("X");
        giantX.setFont(new Font("MV Boli", Font.BOLD, 150));
        giantX.setForeground(Color.RED);
        giantX.setHorizontalAlignment(JLabel.CENTER);
        giantX2.setFont(new Font("MV Boli", Font.BOLD, 150));
        giantX2.setForeground(Color.RED);
        giantX2.setHorizontalAlignment(JLabel.CENTER);
        giantX3.setFont(new Font("MV Boli", Font.BOLD, 150));
        giantX3.setForeground(Color.RED);
        giantX3.setHorizontalAlignment(JLabel.CENTER);

        supers[a].setLayout(new BorderLayout());
        supers[a].setBounds(0, 0, 500, 500);
        supers[a].add(giantX);
        supers[b].setLayout(new BorderLayout());
        supers[b].setBounds(0, 0, 500, 500);
        supers[b].add(giantX2);
        supers[c].setLayout(new BorderLayout());
        supers[c].setBounds(0, 0, 500, 500);
        supers[c].add(giantX3);

        textfield.setText("X WINSSS!");

        for (int i = 0; i < 9; i++) {
            if (winarray[i] == 0) {
                for (int j = i * 9; j < (i * 9) + 9; i++) {
                    buttons[i].setEnabled(false);
                }
            }
        }

    }

    public void Omainwin(int a, int b, int c) {
        supers[a].removeAll();
        supers[a].setBackground(Color.GREEN);
        supers[b].removeAll();
        supers[b].setBackground(Color.GREEN);
        supers[c].removeAll();
        supers[c].setBackground(Color.GREEN);

        JLabel giantX = new JLabel("O");
        JLabel giantX2 = new JLabel("O");
        JLabel giantX3 = new JLabel("O");
        giantX.setFont(new Font("MV Boli", Font.BOLD, 150));
        giantX.setForeground(Color.RED);
        giantX.setHorizontalAlignment(JLabel.CENTER);
        giantX2.setFont(new Font("MV Boli", Font.BOLD, 150));
        giantX2.setForeground(Color.RED);
        giantX2.setHorizontalAlignment(JLabel.CENTER);
        giantX3.setFont(new Font("MV Boli", Font.BOLD, 150));
        giantX3.setForeground(Color.RED);
        giantX3.setHorizontalAlignment(JLabel.CENTER);

        supers[a].setLayout(new BorderLayout());
        supers[a].setBounds(0, 0, 500, 500);
        supers[a].add(giantX);
        supers[b].setLayout(new BorderLayout());
        supers[b].setBounds(0, 0, 500, 500);
        supers[b].add(giantX2);
        supers[c].setLayout(new BorderLayout());
        supers[c].setBounds(0, 0, 500, 500);
        supers[c].add(giantX3);

        textfield.setText("O WINSSS!");

        for (int i = 0; i < 9; i++) {
            if (winarray[i] == 0) {
                for (int j = i * 9; j < (i * 9) + 9; i++) {
                    buttons[i].setEnabled(false);
                }
            }
        }

    }


}
