// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
//  */

// // package com.mycompany.notepad;

// /**
//  *
//  * @author Kanishk
//  */

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
//import javax.swing.text.*;
import javax.swing.UIManager.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
class NotepadApp extends JFrame implements ActionListener {

    // Text component
    JTextArea t;

    // Frame
    JFrame f;
    private static JTextArea lines;
    private JScrollPane jsp;
    private JLabel statusLabel;
    // Constructor
    NotepadApp() {
        // Create a frame
        f = new JFrame("Notepad");

        // Text component
        t = new JTextArea();

        // Create a menubar
        JMenuBar mb = new JMenuBar();

        UIManager.put("MenuBar.background", Color.LIGHT_GRAY);
        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        f.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(f.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
       

        // Create amenu for menu
        JMenu m1 = new JMenu("File");

        // ImageIcon
        ImageIcon icon = new ImageIcon("C:\\Users\\Kanishk\\Downloads\\new.png");
        // Create menu items
        // icon.setIconHeight();
        jsp = new JScrollPane();
        t = new JTextArea();
        lines = new JTextArea("1");
        statusLabel = new JLabel("Ln " + "0, Col 0");
        lines.setBackground(Color.LIGHT_GRAY);
        lines.setEditable(false);
        // Code to implement line numbers inside the JTextArea
        t.getDocument().addDocumentListener(new DocumentListener() {
            public String getText() {
                int caretPosition = t.getDocument().getLength(); // return caret position index
                // System.out.println("CAret0" + caretPosition);
                Element root = t.getDocument().getDefaultRootElement();
                // System.out.println("roott  ==>   " + root);
                // LineNumberReader lr = new LineNumberReader();
                // System.out.println(textArea.getLin);
                String text = "1" + System.getProperty("line.separator");
                String dummy = System.getProperty("line.seperator");
                // System.out.println(text);
                // System.out.println(dummy);
                for (int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
                    text += i + System.getProperty("line.separator");
                }
                
                return text;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                lines.setText(getText());
                System.out.println("hettdfgdgfg"+getText().length());
                int lineNo = (getText().length()) / 3;

                statusLabel.setText("Ln "+ lineNo+", Col "+t.getDocument().getLength());
            }

            @Override
            public void insertUpdate(DocumentEvent de) {
                lines.setText(getText());
                // System.out.println("hettdfgdgfg"+t.getRows());
                System.out.println("hettdfgdgfg" + getText().length());
                int lineNo = (getText().length()) / 3;

                statusLabel.setText(
                        "Ln " + lineNo + ", Col " + t.getDocument().getLength());

            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                lines.setText(getText());
                // System.out.println("hettdfgdgfg"+t.getRows());
                System.out.println("hettdfgdgfg" + getText().length());
                int lineNo = (getText().length()) / 3;
                statusLabel.setText(
                        "Ln " + lineNo + ", Col " + t.getDocument().getLength());


            }
        });
        jsp.getViewport().add(t);
        jsp.setRowHeaderView(lines);
        add(jsp);
        // System.out.println(text);
        // JLabel statusLabel = new JLabel("Ln" + "0" +", Col "+"1");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem mi2 = new JMenuItem("Open");
        JMenuItem mi3 = new JMenuItem("Save");
        JMenuItem mi9 = new JMenuItem("Print");

        mi1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mi2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mi3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mi9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));

        // Add action listener
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi9.addActionListener(this);

        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi9);

        // Create amenu for menu
        JMenu m2 = new JMenu("Edit");

        // Create menu items
        JMenuItem mi4 = new JMenuItem("cut");
        JMenuItem mi5 = new JMenuItem("copy");
        JMenuItem mi6 = new JMenuItem("paste");

        mi4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mi5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mi6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));

        // Add action listener
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);

        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);

        // Environment menu
        JMenu m3 = new JMenu("Environment");

        JMenuItem mi7 = new JMenuItem("Dark theme");
        JMenuItem mi8 = new JMenuItem("Light theme");

        mi7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mi8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));

        m3.add(mi7);
        m3.add(mi8);
        // m3.add(mi10);

        mi7.addActionListener(this);
        mi8.addActionListener(this);

        // Font menu
        JMenu m4 = new JMenu("Style");

        JMenu m5 = new JMenu("Color");

        JMenu m6 = new JMenu("Size");

        JMenu m7 = new JMenu("Formatting");
        JMenu m8 = new JMenu("Font");

        JMenuItem mi25 = new JMenuItem("B");
        JMenuItem mi26 = new JMenuItem("I");

        // JMenuItem mi10=new JMenuItem("Font color");
        JMenuItem mi11 = new JMenuItem("Red");
        JMenuItem mi12 = new JMenuItem("Yellow");
        JMenuItem mi13 = new JMenuItem("Blue");
        JMenuItem mi14 = new JMenuItem("Gray");
        JMenuItem mi15 = new JMenuItem("Black");
        JMenuItem mi22 = new JMenuItem("10");
        JMenuItem mi16 = new JMenuItem("12");
        JMenuItem mi17 = new JMenuItem("14");
        JMenuItem mi18 = new JMenuItem("16");
        JMenuItem mi19 = new JMenuItem("18");
        JMenuItem mi20 = new JMenuItem("20");
        JMenuItem mi21 = new JMenuItem("22");
        JMenuItem mi23 = new JMenuItem("24");
        JMenuItem mi24 = new JMenuItem("26");
        JMenuItem mi27 = new JMenuItem("Times New Roman");
        JMenuItem mi28 = new JMenuItem("Calibri");
        JMenuItem mi29 = new JMenuItem("JetBrains Mono");
        JMenuItem mi30 = new JMenuItem("Courier");

        // m4.add(mi10);
        m4.add(m5);
        m4.add(m6);
        m4.add(m7);
        m4.add(m8);
        m5.add(mi11);
        m5.add(mi12);
        m5.add(mi13);
        m5.add(mi14);
        m5.add(mi15);
        m6.add(mi16);
        m6.add(mi22);
        m6.add(mi17);
        m6.add(mi18);
        m6.add(mi19);
        m6.add(mi20);
        m6.add(mi21);
        m6.add(mi23);
        m6.add(mi24);
        m7.add(mi25);
        m7.add(mi26);
        m8.add(mi27);
        m8.add(mi28);
        m8.add(mi29);
        m8.add(mi30);
        // mi10.addActionListener(this);
        mi11.addActionListener(this);
        mi12.addActionListener(this);
        mi13.addActionListener(this);
        mi14.addActionListener(this);
        mi15.addActionListener(this);
        mi16.addActionListener(this);
        mi17.addActionListener(this);
        mi18.addActionListener(this);
        mi19.addActionListener(this);
        mi20.addActionListener(this);
        mi21.addActionListener(this);
        mi22.addActionListener(this);
        mi23.addActionListener(this);
        mi24.addActionListener(this);
        mi25.addActionListener(this);
        mi26.addActionListener(this);
        mi27.addActionListener(this);
        mi28.addActionListener(this);
        mi29.addActionListener(this);
        mi30.addActionListener(this);

        // mi8.addActionListener(this);

        JMenuItem mc = new JMenuItem("Close");
        // JLabel l = new JLabel(Integer.toString(t.getColumns()));
        mc.addActionListener(this);

        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        mb.add(m4);
        // mb.add(mc);

        f.setJMenuBar(mb);
        // f.add(t);
        // f.add(l);
        f.add(jsp);
        f.setSize(500, 500);
        // f.show();
        f.setVisible(true);
    }

    // If a button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        switch (s) {
            case "cut":
                t.cut();
                break;
            case "copy":
                t.copy();
                break;
            case "paste":
                t.paste();
                break;
            case "Save": {
                // Create an object of JFileChooser class
                JFileChooser j = new JFileChooser("f:");
                // Invoke the showsSaveDialog function to show the save dialog
                int r = j.showSaveDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {

                    // Set the label to the path of the selected directory
                    File fi = new File(j.getSelectedFile().getAbsolutePath());

                    try {
                        // Create a file writer
                        FileWriter wr = new FileWriter(fi, false);

                        // Create buffered writer to write
                        BufferedWriter w = new BufferedWriter(wr);

                        // Write
                        w.write(t.getText());

                        w.flush();
                        w.close();
                    } catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                }
                // If the user cancelled the operation
                else
                    JOptionPane.showMessageDialog(f, "the user cancelled the operation");
                break;
            }
            case "Print":
                try {
                    // print the file
                    t.print();
                } catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
                break;
            case "Open": {
                // Create an object of JFileChooser class
                JFileChooser j = new JFileChooser("f:");
                // Invoke the showsOpenDialog function to show the save dialog
                int r = j.showOpenDialog(null);
                // If the user selects a file
                if (r == JFileChooser.APPROVE_OPTION) {
                    // Set the label to the path of the selected directory
                    File fi = new File(j.getSelectedFile().getAbsolutePath());

                    try {
                        // String
                        String s1 = "", sl = "";

                        // File reader
                        FileReader fr = new FileReader(fi);

                        // Buffered reader
                        BufferedReader br = new BufferedReader(fr);

                        // Initialize sl
                        sl = br.readLine();

                        // Take the input from the file
                        while ((s1 = br.readLine()) != null) {
                            sl = sl + "\n" + s1;
                        }

                        // Set the text
                        t.setText(sl);
                    } catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                }
                // If the user cancelled the operation
                else
                    JOptionPane.showMessageDialog(f, "the user cancelled the operation");
                break;
            }
            case "New":
                t.setText("");
                break;
            case "close":
                f.setVisible(false);
                break;
            default:
                break;

            case "Dark theme":
                t.setBackground(Color.DARK_GRAY);
                t.setForeground(Color.white);
                break;

            case "Light theme":
                t.setBackground(Color.white);
                t.setForeground(Color.DARK_GRAY);
                break;

            case "Red":
                t.setForeground(Color.red);
                break;

            case "Yellow":
                t.setForeground(Color.yellow);
                break;

            case "Blue":
                t.setForeground(Color.blue);
                break;

            case "Gray":
                t.setForeground(Color.gray);
                break;

            case "Black":
                t.setForeground(Color.black);
                break;

            case "10":

                t.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 10));
                lines.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 10));
                break;
            case "12":
                t.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 12));
                lines.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 12));

                break;

            case "14":
                t.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 14));
                lines.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 14));

                break;
            case "16":
                t.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 16));
                lines.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 16));

                break;
            case "18":
                t.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 18));
            lines.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 18));

                break;
            case "20":
                t.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 20));
                lines.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 20));

                break;
            case "22":
                t.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 22));
                lines.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 22));

                break;
            case "24":
                t.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 24));
            lines.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 24));

                break;
            case "26":
                t.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 26));
                lines.setFont(new Font(t.getFont().getFamily(), Font.PLAIN, 26));

                break;
            case "B":
                // Dimension size = t.getSize();
                Font old = t.getFont();
                // System.out.println("Get style");
                // System.out.println(old.getStyle());
                t.setFont(new Font(old.getFamily(), old.getStyle() == 2 ? Font.BOLD+Font.ITALIC : Font.BOLD, old.getSize()));
                lines.setFont(new Font(old.getFamily(), old.getStyle() == 2 ? Font.BOLD+Font.ITALIC : Font.BOLD, old.getSize()));

                break;
            case "I":
                t.setFont(new Font(t.getFont().getFamily(), t.getFont().getStyle() == 1 ? Font.ITALIC + Font.BOLD : Font.ITALIC, t.getFont().getSize()));
                lines.setFont(new Font(t.getFont().getFamily(), t.getFont().getStyle() == 1 ? Font.ITALIC + Font.BOLD : Font.ITALIC, t.getFont().getSize()));

                break;
                case "Times New Roman":
                    t.setFont(new Font("Times New Roman",
                            Font.PLAIN,
                            t.getFont().getSize()));
                    lines.setFont(new Font("Times New Roman",
                            Font.PLAIN,
                            t.getFont().getSize()));
break;
                case "Calibri":
                    t.setFont(new Font("Calibri",
                            Font.PLAIN,
                            t.getFont().getSize()));
                    lines.setFont(new Font("Calibri",
                            Font.PLAIN,
                            t.getFont().getSize()));
break;
                case "JetBrains Mono":
                    t.setFont(new Font("JetBrains Mono",
                            Font.PLAIN,
                            t.getFont().getSize()));
                    lines.setFont(new Font("JetBrains Mono",
                            Font.PLAIN,
                            t.getFont().getSize()));
break;
                case "Courier":
                    lines.setFont(new Font("Courier",
                            Font.PLAIN,
                            t.getFont().getSize()));
break;
        }
    }

    // Main class
    public static void main(String args[]) {
        NotepadApp e = new NotepadApp();
    }
}