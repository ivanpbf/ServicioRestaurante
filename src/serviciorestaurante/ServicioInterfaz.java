/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciorestaurante;

import java.awt.JobAttributes;
import javax.swing.JTextField;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;
import serviciorestaurante.Gerente;
import serviciorestaurante.JefeMesoneros;
import static serviciorestaurante.ServicioRestaurant.*;
/**
 *
 * @author Ivan
 */
public class ServicioInterfaz extends javax.swing.JFrame {

    /**
     * Creates new form Servicio
     */
    public ServicioInterfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContratarEntrada = new javax.swing.JButton();
        DespedirEntrada = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CocinerosEntradas = new javax.swing.JTextField();
        MesonEntradas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CocinerosPlatos = new javax.swing.JTextField();
        MesonPlatos = new javax.swing.JTextField();
        ContratarPlato = new javax.swing.JButton();
        DespedirPlato = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CocinerosPostres = new javax.swing.JTextField();
        MesonPostres = new javax.swing.JTextField();
        ContratarPostre = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        DespedirPostre = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Mesoneros = new javax.swing.JTextField();
        ContratarMesonero = new javax.swing.JButton();
        DespedirMesonero = new javax.swing.JButton();
        Comidas = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JefeMesoneros = new javax.swing.JTextField();
        Gerente = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        HorasRestantes = new javax.swing.JTextField();
        Iniciar = new javax.swing.JButton();
        Totales = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ContratarEntrada.setBackground(new java.awt.Color(153, 255, 153));
        ContratarEntrada.setText("Contratar");
        ContratarEntrada.setEnabled(false);
        ContratarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContratarEntradaActionPerformed(evt);
            }
        });
        getContentPane().add(ContratarEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 90, -1));

        DespedirEntrada.setBackground(new java.awt.Color(255, 102, 102));
        DespedirEntrada.setText("Despedir");
        DespedirEntrada.setEnabled(false);
        DespedirEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DespedirEntradaActionPerformed(evt);
            }
        });
        getContentPane().add(DespedirEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 90, -1));

        Salir.setBackground(new java.awt.Color(255, 0, 0));
        Salir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setText("SALIR");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 575, -1, 30));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/unimet-logo.png"))); // NOI18N
        getContentPane().add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 200, 80));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ENTRADAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 100, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Cocineros: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Disponibilidad: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));
        getContentPane().add(CocinerosEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 60, -1));

        MesonEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MesonEntradasActionPerformed(evt);
            }
        });
        getContentPane().add(MesonEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 60, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("PLATOS FUERTES");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Cocineros: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Disponibilidad: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        CocinerosPlatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CocinerosPlatosActionPerformed(evt);
            }
        });
        getContentPane().add(CocinerosPlatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 60, -1));
        getContentPane().add(MesonPlatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 60, -1));

        ContratarPlato.setBackground(new java.awt.Color(153, 255, 153));
        ContratarPlato.setText("Contratar");
        ContratarPlato.setEnabled(false);
        ContratarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContratarPlatoActionPerformed(evt);
            }
        });
        getContentPane().add(ContratarPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 90, -1));

        DespedirPlato.setBackground(new java.awt.Color(255, 102, 102));
        DespedirPlato.setText("Despedir");
        DespedirPlato.setEnabled(false);
        DespedirPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DespedirPlatoActionPerformed(evt);
            }
        });
        getContentPane().add(DespedirPlato, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("POSTRE");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Cocineros: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Disponibilidad: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));
        getContentPane().add(CocinerosPostres, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 60, -1));
        getContentPane().add(MesonPostres, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 60, -1));

        ContratarPostre.setBackground(new java.awt.Color(153, 255, 153));
        ContratarPostre.setText("Contratar");
        ContratarPostre.setEnabled(false);
        ContratarPostre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContratarPostreActionPerformed(evt);
            }
        });
        getContentPane().add(ContratarPostre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 90, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 400, 10));

        DespedirPostre.setBackground(new java.awt.Color(255, 102, 102));
        DespedirPostre.setText("Depedir");
        DespedirPostre.setEnabled(false);
        DespedirPostre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DespedirPostreActionPerformed(evt);
            }
        });
        getContentPane().add(DespedirPostre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 90, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 400, 20));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 22, 20, 500));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("MESONEROS");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Cantidad: ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Ordenes Atendidas: ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        Mesoneros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MesonerosActionPerformed(evt);
            }
        });
        getContentPane().add(Mesoneros, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 60, -1));

        ContratarMesonero.setBackground(new java.awt.Color(153, 255, 153));
        ContratarMesonero.setText("Contratar");
        ContratarMesonero.setEnabled(false);
        ContratarMesonero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContratarMesoneroActionPerformed(evt);
            }
        });
        getContentPane().add(ContratarMesonero, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        DespedirMesonero.setBackground(new java.awt.Color(255, 102, 102));
        DespedirMesonero.setText("Despedir");
        DespedirMesonero.setEnabled(false);
        DespedirMesonero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DespedirMesoneroActionPerformed(evt);
            }
        });
        getContentPane().add(DespedirMesonero, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, -1, -1));
        getContentPane().add(Comidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 50, -1));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 310, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Jefe de Mesoneros: ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Gerente: ");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));
        getContentPane().add(JefeMesoneros, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 80, -1));
        getContentPane().add(Gerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 80, -1));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 310, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Horas restantes: ");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, -1, -1));
        getContentPane().add(HorasRestantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, 70, -1));

        Iniciar.setBackground(new java.awt.Color(51, 255, 51));
        Iniciar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Iniciar.setText("INICIAR");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });
        getContentPane().add(Iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 575, -1, 30));
        getContentPane().add(Totales, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 70, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Totales:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Ivan Rivolta");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 430, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Ivan Loscher");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/restaurant-766050_960_720.jpg"))); // NOI18N
        jLabelFondo.setOpaque(true);
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 735, 619));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void MesonEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MesonEntradasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MesonEntradasActionPerformed

    private void CocinerosPlatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CocinerosPlatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CocinerosPlatosActionPerformed

    private void DespedirPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DespedirPlatoActionPerformed
       CPlatoFuerte cocinero = new CPlatoFuerte(mesonPlato, SEPlato, SPPlato, SCPlato,tiempo, entraPF, salePF, servicio);
        if(!"".equals(CocinerosPlatos.getText()) && Integer.parseInt(CocinerosPlatos.getText()) <= maxCantPF &&
                Integer.parseInt(CocinerosPlatos.getText()) > 0 ){
            cocinero.despedir();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se puede despedir mas Cocineros de Platos Fuertes.");
        }
    }//GEN-LAST:event_DespedirPlatoActionPerformed

    private void MesonerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MesonerosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MesonerosActionPerformed

    private void ContratarMesoneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContratarMesoneroActionPerformed
        Mesonero mesonero = new Mesonero(SEComida, SPComida, SCComida, entraC, saleC, SEEntrada, SPEntrada, SCEntrada, entraE, saleE,
                SEPlato, SPPlato, SCPlato, entraPF, salePF, SEPostre, SPPostre, SCPostre, entraP, saleP, servicio,tiempo, mesonEntradas, mesonPlato, mesonPostre, mesonComida);
        if(!"".equals(Mesoneros.getText()) && Integer.parseInt(Mesoneros.getText()) < cantMaxMesoneros &&
                Integer.parseInt(Mesoneros.getText()) >= 0 ){
            mesonero.contratar();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se puede contratar mas Mesoneros.");
        }
    }//GEN-LAST:event_ContratarMesoneroActionPerformed

    private void ContratarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContratarEntradaActionPerformed
        CEntrada cocinero = new CEntrada(mesonEntradas, SEEntrada, SPEntrada, SCEntrada,tiempo, entraE, saleE, servicio);
        if(!"".equals(CocinerosEntradas.getText()) && Integer.parseInt(CocinerosEntradas.getText()) < maxCantEntrada &&
                Integer.parseInt(CocinerosEntradas.getText()) >= 0 ){
            cocinero.contratar();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se puede contratar mas Cocineros de Entradas.");
        }
    }//GEN-LAST:event_ContratarEntradaActionPerformed

    private void DespedirEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DespedirEntradaActionPerformed
        CEntrada cocinero = new CEntrada(mesonEntradas, SEEntrada, SPEntrada, SCEntrada,tiempo, entraE, saleE, servicio);
        if(!"".equals(CocinerosEntradas.getText()) && Integer.parseInt(CocinerosEntradas.getText()) <= maxCantEntrada &&
                Integer.parseInt(CocinerosEntradas.getText()) > 0 ){
            cocinero.despedir();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se puede despedir mas Cocineros de Entradas.");
        }
    }//GEN-LAST:event_DespedirEntradaActionPerformed

    private void ContratarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContratarPlatoActionPerformed
        CPlatoFuerte cocinero = new CPlatoFuerte(mesonPlato, SEPlato, SPPlato, SCPlato,tiempo, entraPF, salePF, servicio);
        if(!"".equals(CocinerosPlatos.getText()) && Integer.parseInt(CocinerosPlatos.getText()) < maxCantPF &&
                Integer.parseInt(CocinerosPlatos.getText()) >= 0 ){
            cocinero.contratar();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se puede contratar mas Cocineros de Platos Fuertes.");
        }
    }//GEN-LAST:event_ContratarPlatoActionPerformed

    private void ContratarPostreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContratarPostreActionPerformed
        CPostre cocinero = new CPostre(mesonPostre, SEPostre, SPPostre, SCPostre,tiempo, entraP, saleP, servicio);
        if(!"".equals(CocinerosPostres.getText()) && Integer.parseInt(CocinerosPostres.getText()) < maxCantPostre &&
                Integer.parseInt(CocinerosPostres.getText()) >= 0 ){
            cocinero.contratar();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se puede contratar mas Cocineros de Postres.");
        }
    }//GEN-LAST:event_ContratarPostreActionPerformed

    private void DespedirMesoneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DespedirMesoneroActionPerformed
        Mesonero mesonero = new Mesonero(SEComida, SPComida, SCComida, entraC, saleC, SEEntrada, SPEntrada, SCEntrada, entraE, saleE,
                SEPlato, SPPlato, SCPlato, entraPF, salePF, SEPostre, SPPostre, SCPostre, entraP, saleP, servicio,tiempo, mesonEntradas, mesonPlato, mesonPostre, mesonComida);
        if(!"".equals(Mesoneros.getText()) && Integer.parseInt(Mesoneros.getText()) <= cantMaxMesoneros &&
                Integer.parseInt(Mesoneros.getText()) > 0 ){
            mesonero.despedir();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se puede despedir mas Mesoneros.");
        }
    }//GEN-LAST:event_DespedirMesoneroActionPerformed

    private void DespedirPostreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DespedirPostreActionPerformed
        CPostre cocinero = new CPostre(mesonPostre, SEPostre, SPPostre, SCPostre,tiempo, entraP, saleP, servicio);
        if(!"".equals(CocinerosPostres.getText()) && Integer.parseInt(CocinerosPostres.getText()) <= maxCantPostre &&
                Integer.parseInt(CocinerosPostres.getText()) > 0 ){
            cocinero.despedir();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se puede contratar mas Cocineros de Postres.");
        }
    }//GEN-LAST:event_DespedirPostreActionPerformed

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        ContratarEntrada.setEnabled(true);
        ContratarMesonero.setEnabled(true);
        ContratarPlato.setEnabled(true);
        ContratarPostre.setEnabled(true);
        DespedirEntrada.setEnabled(true);
        DespedirMesonero.setEnabled(true);
        DespedirPlato.setEnabled(true);
        DespedirPostre.setEnabled(true);
        for(int i = 0; i < cantInicialEntrada; i++){
            CEntradas[i].start();
        }
        for(int i = 0; i < cantInicialPF; i++){
            CPlato[i].start();
            //set numero en interfaz
        }
        for(int i = 0; i < cantInicialPostres; i++){
            CPostres[i].start();
            //set numero en interfaz
        }
        for(int i = 0; i < cantInicialMesoneros; i++){
            CMesoneros[i].start();
        }
        jefemesoneros.start();
        gerente.start();
    }//GEN-LAST:event_IniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServicioInterfaz().setVisible(true);
            }
        });
    }

    public JTextField getCocinerosEntradas() {
        return CocinerosEntradas;
    }

    public JTextField getCocinerosPlatos() {
        return CocinerosPlatos;
    }

    public JTextField getCocinerosPostres() {
        return CocinerosPostres;
    }

    public JTextField getComidas() {
        return Comidas;
    }

    public JTextField getGerente() {
        return Gerente;
    }

    public JTextField getHorasRestantes() {
        return HorasRestantes;
    }

    public JTextField getJefeMesoneros() {
        return JefeMesoneros;
    }

    public JTextField getMesonEntradas() {
        return MesonEntradas;
    }

    public JTextField getMesonPlatos() {
        return MesonPlatos;
    }

    public JTextField getMesonPostres() {
        return MesonPostres;
    }

    public JTextField getMesoneros() {
        return Mesoneros;
    }

    public void setCocinerosEntradas(JTextField CocinerosEntradas) {
        this.CocinerosEntradas = CocinerosEntradas;
    }

    public void setCocinerosPlatos(JTextField CocinerosPlatos) {
        this.CocinerosPlatos = CocinerosPlatos;
    }

    public void setCocinerosPostres(JTextField CocinerosPostres) {
        this.CocinerosPostres = CocinerosPostres;
    }

    public void setMesonEntradas(JTextField MesonEntradas) {
        this.MesonEntradas = MesonEntradas;
    }

    public void setMesonPlatos(JTextField MesonPlatos) {
        this.MesonPlatos = MesonPlatos;
    }

    public void setMesonPostres(JTextField MesonPostres) {
        this.MesonPostres = MesonPostres;
    }

    public void setMesoneros(JTextField Mesoneros) {
        this.Mesoneros = Mesoneros;
    }

    public void setGerente(JTextField Gerente) {
        this.Gerente = Gerente;
    }

    public void setJefeMesoneros(JTextField JefeMesoneros) {
        this.JefeMesoneros = JefeMesoneros;
    }

    public void setHorasRestantes(JTextField HorasRestantes) {
        this.HorasRestantes = HorasRestantes;
    }

    public void setComidas(JTextField Comidas) {
        this.Comidas = Comidas;
    }

    public JTextField getTotales() {
        return Totales;
    }

    public void setTotales(JTextField Totales) {
        this.Totales = Totales;
    }
     
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CocinerosEntradas;
    private javax.swing.JTextField CocinerosPlatos;
    private javax.swing.JTextField CocinerosPostres;
    private javax.swing.JTextField Comidas;
    private javax.swing.JButton ContratarEntrada;
    private javax.swing.JButton ContratarMesonero;
    private javax.swing.JButton ContratarPlato;
    private javax.swing.JButton ContratarPostre;
    private javax.swing.JButton DespedirEntrada;
    private javax.swing.JButton DespedirMesonero;
    private javax.swing.JButton DespedirPlato;
    private javax.swing.JButton DespedirPostre;
    private javax.swing.JTextField Gerente;
    private javax.swing.JTextField HorasRestantes;
    private javax.swing.JButton Iniciar;
    private javax.swing.JTextField JefeMesoneros;
    private javax.swing.JTextField MesonEntradas;
    private javax.swing.JTextField MesonPlatos;
    private javax.swing.JTextField MesonPostres;
    private javax.swing.JTextField Mesoneros;
    private javax.swing.JButton Salir;
    private javax.swing.JTextField Totales;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
