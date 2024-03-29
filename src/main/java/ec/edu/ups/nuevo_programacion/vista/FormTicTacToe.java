package ec.edu.ups.nuevo_programacion.vista;

import ec.edu.ups.nuevo_programacion.modelo.Simbolo;
import ec.edu.ups.nuevo_programacion.controlador.TicTacToe;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author David V
 */
public class FormTicTacToe extends javax.swing.JFrame {

    private TicTacToe juego;
    private JLabel[][] tablero;
    private int J1Puntos;
    private int J2Puntos;

    public FormTicTacToe() {
        initComponents();
        this.juego = new TicTacToe();
        JLabel[][] t = {
            {lbl00, lbl01, lbl02},
            {lbl10, lbl11, lbl12},
            {lbl20, lbl21, lbl22},};
        this.tablero = t;
        this.J1Puntos = 0;
        this.J2Puntos = 0;
        this.reset();
    }

    private int generaNumeroAleatorio(int minimo, int maximo) {
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }

    public void elegirTurnoInicial() {
        int n = this.generaNumeroAleatorio(1, 2);
        this.juego.setTurno(n == 1);
    }

    public void actualizarPuntuacion() {
        this.txtJ1Puntos.setText(this.J1Puntos + "");
        this.txtJ2Puntos.setText(this.J2Puntos + "");
    }

    public void mostrarTurno() {
        if (this.juego.isTurno()) {
            this.lblTurno.setText("J1");
        } else {
            this.lblTurno.setText("J2");
        }
    }

    public void inicializarTablero() {

        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[0].length; j++) {

                Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

                Image img = new ImageIcon("img/vacio.png").getImage();
                ImageIcon img2 = new ImageIcon(img.getScaledInstance(
                        this.tablero[i][j].getWidth(),
                        this.tablero[i][j].getHeight(),
                        Image.SCALE_SMOOTH)
                );

                this.tablero[i][j].setIcon(img2);
                this.tablero[i][j].setBorder(border);
            }
        }

    }

    public void elegirPosicion(int i, int j) {
        if (this.juego.getSimboloAt(i, j) == Simbolo.VACIO) {
            juego.insertarEn(i, j);

            Image img;
            if (this.juego.isTurno()) {
                img = new ImageIcon("img/x.png").getImage();
            } else {
                img = new ImageIcon("img/o.png").getImage();
            }

            ImageIcon img2 = new ImageIcon(img.getScaledInstance(
                    this.tablero[i][j].getWidth(),
                    this.tablero[i][j].getHeight(),
                    Image.SCALE_SMOOTH)
            );

            this.tablero[i][j].setIcon(img2);

            this.juego.cambiarTurno();

            this.mostrarTurno();

            if (this.juego.finPartida()) {
                // Imprime el estado final del tablero en la consola
                imprimirEstadoTableroConsola();

                Simbolo ganador = juego.ganador();

                // Imprime el resultado de la partida en la consola
                imprimirResultadoPartida(ganador);

                if (ganador == null) {
                    JOptionPane.showMessageDialog(rootPane, "Empate");
                } else if (ganador == Simbolo.X) {
                    this.J1Puntos++;
                    JOptionPane.showMessageDialog(rootPane, "J1 gana");
                } else {
                    this.J2Puntos++;
                    JOptionPane.showMessageDialog(rootPane, "J2 gana");
                }
                this.reset();
            }
        }
    }

// Agrega este método para imprimir el estado actual del tablero en la consola
    private void imprimirEstadoTableroConsola() {
        System.out.println("Estado final del tablero:");
        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[0].length; j++) {
                System.out.print(this.juego.getSimboloAt(i, j).getSimbolo() + " ");
            }
            System.out.println("");
        }
    }

    // Agrega este método para imprimir el resultado de la partida en la consola
    private void imprimirResultadoPartida(Simbolo ganador) {
        if (ganador == null) {
            System.out.println("La partida terminó en empate.");
        } else if (ganador == Simbolo.X) {
            System.out.println("Jugador 1 (X) gana la partida.");
        } else {
            System.out.println("Jugador 2 (O) gana la partida.");
        }
    }

    public void reset() {
        this.juego = new TicTacToe();
        this.elegirTurnoInicial();
        this.mostrarTurno();
        this.actualizarPuntuacion();
        this.inicializarTablero();
        this.actualizarPuntuacion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        lbl00 = new javax.swing.JLabel();
        lbl01 = new javax.swing.JLabel();
        lbl02 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        lbl20 = new javax.swing.JLabel();
        lbl21 = new javax.swing.JLabel();
        lbl22 = new javax.swing.JLabel();
        txtJ1Puntos = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        txtJ2Puntos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setMinimumSize(new java.awt.Dimension(300, 400));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(5, 3));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Turno");
        getContentPane().add(jLabel2);

        lblTurno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTurno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTurno.setText("J1");
        getContentPane().add(lblTurno);

        lbl00.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl00MouseClicked(evt);
            }
        });
        getContentPane().add(lbl00);

        lbl01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl01MouseClicked(evt);
            }
        });
        getContentPane().add(lbl01);

        lbl02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl02MouseClicked(evt);
            }
        });
        getContentPane().add(lbl02);

        lbl10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl10MouseClicked(evt);
            }
        });
        getContentPane().add(lbl10);

        lbl11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl11MouseClicked(evt);
            }
        });
        getContentPane().add(lbl11);

        lbl12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl12MouseClicked(evt);
            }
        });
        getContentPane().add(lbl12);

        lbl20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl20MouseClicked(evt);
            }
        });
        getContentPane().add(lbl20);

        lbl21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl21MouseClicked(evt);
            }
        });
        getContentPane().add(lbl21);

        lbl22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl22MouseClicked(evt);
            }
        });
        getContentPane().add(lbl22);

        txtJ1Puntos.setEditable(false);
        txtJ1Puntos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtJ1Puntos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtJ1Puntos);

        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset);

        txtJ2Puntos.setEditable(false);
        txtJ2Puntos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtJ2Puntos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtJ2Puntos);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl00MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl00MouseClicked
        elegirPosicion(0, 0);
    }//GEN-LAST:event_lbl00MouseClicked

    private void lbl01MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl01MouseClicked
        elegirPosicion(0, 1);
    }//GEN-LAST:event_lbl01MouseClicked

    private void lbl02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl02MouseClicked
        elegirPosicion(0, 2);
    }//GEN-LAST:event_lbl02MouseClicked

    private void lbl10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl10MouseClicked
        elegirPosicion(1, 0);
    }//GEN-LAST:event_lbl10MouseClicked

    private void lbl11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl11MouseClicked
        elegirPosicion(1, 1);
    }//GEN-LAST:event_lbl11MouseClicked

    private void lbl12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl12MouseClicked
        elegirPosicion(1, 2);
    }//GEN-LAST:event_lbl12MouseClicked

    private void lbl20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl20MouseClicked
        elegirPosicion(2, 0);
    }//GEN-LAST:event_lbl20MouseClicked

    private void lbl21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl21MouseClicked
        elegirPosicion(2, 1);
    }//GEN-LAST:event_lbl21MouseClicked

    private void lbl22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl22MouseClicked
        elegirPosicion(2, 2);
    }//GEN-LAST:event_lbl22MouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
        guardarPuntosEnArchivo();
    }//GEN-LAST:event_btnResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTicTacToe().setVisible(true);
            }
        });
    }

    private void guardarPuntosEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("puntos.txt"))) {
            writer.write("Jugador 1 Puntos: " + J1Puntos);
            writer.newLine();
            writer.write("Jugador 2 Puntos: " + J2Puntos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarPuntosDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("puntos.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("Jugador 1 Puntos:")) {
                    J1Puntos = Integer.parseInt(linea.substring(linea.lastIndexOf(" ") + 1));
                } else if (linea.startsWith("Jugador 2 Puntos:")) {
                    J2Puntos = Integer.parseInt(linea.substring(linea.lastIndexOf(" ") + 1));
                }
            }
        } catch (IOException | NumberFormatException e) {
            // Maneja la excepción de formato incorrecto o problemas de lectura
            e.printStackTrace();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl00;
    private javax.swing.JLabel lbl01;
    private javax.swing.JLabel lbl02;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl20;
    private javax.swing.JLabel lbl21;
    private javax.swing.JLabel lbl22;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JTextField txtJ1Puntos;
    private javax.swing.JTextField txtJ2Puntos;
    // End of variables declaration//GEN-END:variables
}
