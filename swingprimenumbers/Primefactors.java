package swingprimenumbers;

import javafx.concurrent.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.time.Instant;


public class Primefactors extends JFrame implements ActionListener {
    JFrame f;
    JLabel pirmas;
    JTextField idetipirma;
    JLabel antras;
    JTextField idetiantra;
    JLabel trecias;
    JTextField idetitrecia;
    JButton skaiciuoti;
    JButton baigti;
    JProgressBar progressBaras;

    Primefactors() {

        f = new JFrame();
        pirmas = new JLabel("Pirmas skaicius:");
        pirmas.setBounds(50, 70, 150, 20);
        idetipirma = new JTextField();
        idetipirma.setBounds(50, 100, 200, 20);
        antras = new JLabel("Antras skaicius:");
        antras.setBounds(50, 130, 150, 20);
        idetiantra = new JTextField();
        idetiantra.setBounds(50, 160, 200, 20);
        trecias = new JLabel("Trecias skaicius:");
        trecias.setBounds(50, 190, 150, 20);
        idetitrecia = new JTextField();
        idetitrecia.setBounds(50, 220, 200, 20);
        skaiciuoti = new JButton("Pradėti");
        skaiciuoti.setBounds(50, 250, 100, 30);
        baigti = new JButton("Baigti");
        baigti.setBounds(200, 250, 100, 30);
        progressBaras = new JProgressBar();
        progressBaras.setBounds(50, 300, 300, 100);

        f.add(pirmas);
        f.add(idetipirma);
        f.add(antras);
        f.add(idetiantra);
        f.add(trecias);
        f.add(idetitrecia);
        f.add(skaiciuoti);
        f.add(baigti);

        skaiciuoti.addActionListener(this);
         baigti.addActionListener(new CloseListener());
        f.setSize(400, 800);
        f.setLayout(null);
        f.setVisible(true);
        f.add(progressBaras);

    }

    private class CloseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            System.exit(0);

            }
        }


    public void actionPerformed(ActionEvent e) {
        String s1 = idetipirma.getText();
        String s2 = idetiantra.getText();
        String s3 = idetitrecia.getText();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);

            Instant instant = Instant.now();

            System.out.println(instant + " " + "Naudojami skaiciai:" + s1 + "  " + s2 + "  " + " " + s3);
            try {
                Logger.log(instant + " " + "Naudojami skaiciai:" + s1 + "  " + s2 + "  " + " " + s3);
                Logger.log("\r\n");
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        for (int z = a; z <= b; z += c) {

           progressBaras.setValue(z);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
                System.out.println(e1);
            }

            int n = z;
            while (n % 2 == 0) {
                System.out.print(2 + "*");

                try {
                    Logger.log(2 + "*");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                n /= 2;
            }
            for (int i = 3; i <= Math.sqrt(n); i += 2) {
                while (n % i == 0) {
                    System.out.print(i + "*");
                    try {
                        Logger.log(i + "*");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    n /= i;
                }
            }
            if (n > 2)

                System.out.print(n);
            Instant instantas = Instant.now();
            System.out.println("=" + z + "   " + instantas);
            try {
                Logger.log("=" + z + "   " + instantas);
                Logger.log("\r\n");
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        Instant instantt = Instant.now();
        System.out.println(instantt + " " + "skaiciavimo pabaiga");
        try {
            Logger.log(instantt + " " + "skaiciavimo pabaiga");
            Logger.log("\r\n");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Primefactors();

    }
}

class Logger {
    public static void log(String message) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("output.txt", true), true);
        out.write(message);
        out.close();
    }
}