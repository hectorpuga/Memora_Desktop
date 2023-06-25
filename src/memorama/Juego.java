
package memorama;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Juego extends JFrame {

    JLabel GIf;
    int Cont;
    int Ban;
    int Ban1;
    int antnum;
    int antx;
    int anty;
    int actualnum;
    int actualx;
    int actualy;
    JLayeredPane PanelPresentacion;
    JLabel FondoPresentacion;
    JLabel NombreJugador;
    JButton BotonJugar;
    Timer Tiempo, TiempoEspera, TiempoEspera1;
    //
    int ContadorSegun;
    JLabel Contar;
    JPanel PanelJuego;
    JLabel Matriz[][];
    int Minutos, Segundo;

    Random Aleatorio = new Random();
    int Mat[][] = new int[4][5];
    int MatAux[][] = new int[4][5];
   

    String Jugador;

    public Juego() throws MalformedURLException {

        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        InicializacionComponentes();

    }
    

    public void InicializacionComponentes() throws MalformedURLException {
        CreacionPanelPrincipal();
        VentanaForma();
       BotonJugar();
        AccionBoton();
        NumeroAleatorios();
        PanelJuego();
        ContadorYNombre();
        MetodoImagenes();
        Contador();
        VoltearCartas();
        TiempoEspera();
        
    }
  public void VentanaForma() {

        this.setUndecorated(true);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getSize().width, this.getSize().height, 30, 30);
     
       
    }
    public void CreacionPanelPrincipal() {

        PanelPresentacion = new FondoInicio();
        PanelPresentacion.setOpaque(true);
       
        this.getContentPane().add(PanelPresentacion);
        
    }


   public void BotonJugar() {

        BotonJugar = new JButton();
        BotonJugar.setSize(this.getWidth(), this.getHeight());
        BotonJugar.setContentAreaFilled(false);
        BotonJugar.setOpaque(false);
        BotonJugar.setBorderPainted(false);
        PanelPresentacion.add(BotonJugar);
    }

    public void AccionBoton() {

        BotonJugar.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {

                Jugador = JOptionPane.showInputDialog("Nombre del jugador", "Escribe Aqui");
                while (Jugador == null || Jugador.compareTo("Escribe Aqui") == 0 || Jugador.compareTo("") == 0) {
                    Jugador = JOptionPane.showInputDialog("Nombre del jugador", "Escribe Aqui");
                }
                NombreJugador.setText("Jugador: "+Jugador);
                Tiempo.start();
                PanelPresentacion.setVisible(false);
                add(PanelJuego);
                PanelJuego.setVisible(true);

            }

        });
    }

    public void PanelJuego() {

        PanelJuego = new JPanel();
        PanelJuego.setSize(this.getWidth(), this.getHeight());
        PanelJuego.setLocation(0, 0);
        PanelJuego.setLayout(null);
        PanelJuego.setVisible(true);
        Color Color=new Color(0,204,204);
        PanelJuego.setBackground(Color);
        PanelJuego.setBorder(BorderFactory.createLineBorder(Color.black, 6));

    }

    public void ContadorYNombre() throws MalformedURLException {
       Font Fondo = new Font("Serief", Font.BOLD, 20);

        NombreJugador = new JLabel();
        NombreJugador.setBounds(50, 0, 200, 100);
         NombreJugador.setFont(Fondo);
        PanelJuego.add(NombreJugador, 0);
       
        Contar = new JLabel();
        Contar.setBounds(400, 0, 300, 100);
        Contar.setFont(Fondo);
        PanelJuego.add(Contar, 0);
        
        
       
        final String Imagen="https://i.pinimg.com/originals/51/d7/e3/51d7e3f786340a03d35c114687bc727c.gif";
        URL url= new URL(Imagen);
        Icon IconGif=new ImageIcon(url);
        GIf = new JLabel(IconGif);
        GIf.setBounds(0, 0, 600, 600);
        GIf.setFont(Fondo);
        
         PanelPresentacion.add(GIf);
        
    }

    public void NumeroAleatorios() {
        int Acumulador = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {

                Mat[i][j] = 0;
                MatAux[i][j] = 0;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                Mat[i][j] = Aleatorio.nextInt(10) + 1;
                do {
                    Acumulador = 0;
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l < 5; l++) {
                            if (Mat[i][j] == Mat[k][l]) {
                                Acumulador += 1;
                            }

                        }

                    }
                    if (Acumulador == 3) {

                        Mat[i][j] = Aleatorio.nextInt(10) + 1;
                    }
                } while (Acumulador == 3);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(Mat[i][j] + " ");

            }
            System.out.println("");
        }

    }

    public void MetodoImagenes() {

        Matriz = new JLabel[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                Matriz[i][j] = new JLabel();
                Matriz[i][j].setBounds(30 + (j * 110), 100 + (i * 110), 100, 100);
                ImageIcon Imagen = new ImageIcon(MatAux[i][j] + ".jpg");
                Matriz[i][j].setIcon(new ImageIcon(Imagen.getImage().getScaledInstance(Matriz[i][j].getWidth(), Matriz[i][j].getHeight(), Image.SCALE_SMOOTH)));
                Matriz[i][j].setVisible(true);
                PanelJuego.add(Matriz[i][j], 0);

            }

        }
    }

    public void Contador() {
        Minutos = 0;
        Segundo = 0;
        Tiempo = new Timer(1000, (ActionEvent ae) -> {
            Segundo++;
            if (Segundo == 60) {
                Minutos++;
                Segundo = 0;
            }
            Contar.setText("Tiempo: " + Minutos +" : " + Segundo);
        });

    }

    public void TiempoEspera() {

        ContadorSegun = 0;
        TiempoEspera = new Timer(1000, (ActionEvent ae) -> {
            ContadorSegun++;

        });
        TiempoEspera.start();
        TiempoEspera.stop();
        ContadorSegun = 0;
        Ban = 0;
    }

    public void VoltearCartas() {

        Cont = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {

                Matriz[i][j].addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {

                        for (int k = 0; k < 4; k++) {
                            for (int l = 0; l < 5; l++) {
                                if (e.getSource() == Matriz[k][l] && Cont != 2) {

                                   
                                    if (MatAux[k][l] == 0) {

                                        MatAux[k][l] = Mat[k][l];
                                        ImageIcon Imagen = new ImageIcon(MatAux[k][l] + ".jpg");
                                        Matriz[k][l].setIcon(new ImageIcon(Imagen.getImage().getScaledInstance(Matriz[k][l].getWidth(), Matriz[k][l].getHeight(), Image.SCALE_SMOOTH)));

                                        Cont++;

                                        actualnum = Mat[k][l];
                                        actualx = k;
                                        actualy = l;

                                        if (Cont == 1) {

                                            antnum = Mat[k][l];
                                            antx = k;
                                            anty = l;
                                        }

                                        TiempoEspera1 = new Timer(500, (ActionEvent ae) -> {

                                            if (Cont == 2 && Ban1 == 0) {
                                                TiempoEspera.restart();
                                                Ban1 = 1;
                                            }
                                            if (Cont == 2 && ContadorSegun == 1) {
                                                TiempoEspera.stop();
                                                ContadorSegun = 0;
                                                if (MatAux[actualx][actualy] == MatAux[antx][anty]) {
                                                    MatAux[actualx][actualy] = -1;
                                                    MatAux[antx][anty] = -1;

                                                   

                                                    Matriz[actualx][actualy].setIcon(null);
                                                    Matriz[antx][anty].setIcon(null);
                                                    Cont = 0;
                                                    int acum = 0;
                                                    for (int m = 0; m < 4; m++) {
                                                        for (int n = 0; n < 5; n++) {
                                                            if (MatAux[m][n] == -1) {
                                                                acum++;
                                                            }

                                                        }
                                                    }
                                                    if (acum == 20) {
                                                        Tiempo.stop();
                                                        JOptionPane.showMessageDialog(null, "Felicitaciones, Usted Gano Con Un Tiempo De: " + Minutos + ":" + Segundo);

                                                        String Continuar=JOptionPane.showInputDialog("¿Desea jugar de nuevo? ").toUpperCase();
                                                        if(Continuar.equals("SI")){
                                                        for (int m = 0; m < 4; m++) {
                                                            for (int n = 0; n < 5; n++) {
                                                                Mat[m][n] = 0;
                                                                MatAux[m][n] = 0;
                                                                ImageIcon Imagen2 = new ImageIcon(MatAux[m][n] + ".jpg");
                                                                Matriz[m][n].setIcon(new ImageIcon(Imagen2.getImage().getScaledInstance(Matriz[m][n].getWidth(), Matriz[m][n].getHeight(), Image.SCALE_SMOOTH)));

                                                            }

                                                        }
                                                        NumeroAleatorios();
                                                        Minutos = 0;
                                                        Segundo = 0;
                                                        Tiempo.start();

                                                    }else{
                                                        
                                                        System.exit(0);
                                                        }
                                                    
                                                    }
                                                }

                                                for (int m = 0; m < 4; m++) {
                                                    for (int n = 0; n < 5; n++) {
                                                        if (MatAux[m][n] != 0 && MatAux[m][n] != -1) {
                                                            MatAux[m][n] = 0;
                                                            ImageIcon Imagen2 = new ImageIcon(MatAux[m][n] + ".jpg");
                                                            Matriz[m][n].setIcon(new ImageIcon(Imagen2.getImage().getScaledInstance(Matriz[m][n].getWidth(), Matriz[m][n].getHeight(), Image.SCALE_SMOOTH)));

                                                           

                                                            Cont = 0;

                                                        }
                                                    }
                                                }
                                                TiempoEspera1.stop();
                                                Ban1 = 0;

                                            }

                                        });
                                        if (Ban == 0) {
                                            TiempoEspera1.start();
                                            Ban = 1;
                                        }

                                        if (Cont == 2) {
                                            TiempoEspera1.restart();
                                        }
                                    }

                                }

                            }
                        }

                    }

                });

            }

        }

    }

}
