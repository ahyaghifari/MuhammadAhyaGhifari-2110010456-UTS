package ahyaghifari.aplikasiresepmasakan;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.ResepMasakan;

/**
 *
 * @author Ahya Ghifari
 */
public class FrameAplikasiResepMasakan extends javax.swing.JFrame {

    
    ResepMasakan resepMasakan; // inisialisasi model ResepMasakan
    public static ArrayList<ResepMasakan> resepResepMasakan = new ArrayList<ResepMasakan>(); // inisialisasi array list yang akan menampung model resep resep masakan
    
    private String cari = ""; // inisialisasi untuk pencarian dengan text
    private String urutkan = "Default"; // inisialisasi untuk pengurutan data
    
    // method untuk mengisi array list resep masakan untuk ditampilkan ke tabel saat program dijalankan    
    public final void initialResepMasakan(){
        
        resepResepMasakan.add(new ResepMasakan("RSP1", "Nasi Goreng Sosis", "30 menit", 
                
                "2 piring nasi(nasi sisa lebih bagus ya)\n" +
                "3 buah sosis\n" +
                "1 butir telur\n" +
                "7 butir bawang merah\n" +
                "2 butir bawang putih\n" +
                "2 buah cabe merah keriting\n" +
                "4 buah cabe rawit merah\n" +
                "2 sdt garam halus\n" +
                "3 sdm kecap manis\n" +
                "Secukupnya penyedap(optional)", 
                
                "1. Haluskan cabe dan bawang putih lalu uleg kasar bawang merah nya\n" + 
                "2. Tumis bumbu sampai harum, masukkan sosis yg diiris tipis sampai matang sambil diaduk-aduk lalu masukkan telur dan diaduk kembali\n" +
                "3. Masukkan nasi, lalu tambahkan kecap, garam dan penyedap\n" +
                 "4. Koreksi rasa, aduk kembali sampai bumbu tercampur rata dan nasi sudah kering. Matikan api lalu hidangkan"));
        
        resepResepMasakan.add(new ResepMasakan("RSP2", "Capcay Goreng Bakso", "35 menit", 
                "1 buah wortel ukuran sedang, kupas lalu potong²\n" +
                "7 buah buncis, siangi lalu potong²\n" +
                "1 kuntum kembang kol ukuran kecil, siangi\n" +
                "5 lembar sawi putih, potong²\n" +
                "10 butir bakso ayam, iris bulat\n" +
                "1 butir telur\n" +
                "2 siung bawang putih, cincang\n" +
                "1/4 buah bawang bombay, iris²\n" +
                "1 batang daun bawang, iris²\n" +
                "1,5 sdm tepung maizena, larutkan\n" +
                "Secukupnya air\n" +
                "Secukupnya minyak goreng", 
                
                "1. Panaskan minyak, tumis bawang putih hingga layu, kemudian masukkan bawang bombay dan daun bawang, tumis hingga wangi, masukkan telur, buat orak arik kemudian masukkan bakso ayam, aduk rata.\n" + 
                "2. Tambahkan air, tunggu mendidih kemudian masukkan wortel, masak hingga wortel setengah matang kemudian masukkan buncis dan kembang kol, masukkan juga semua seasoning nya, aduk rata.\n" + 
                "3. Terakhir masukkan sawi putih dan larutan maizena, aduk dan masak hingga mengental, cek rasa dan siap di sajikan."
                ));
        resepResepMasakan.add(new ResepMasakan("RSP3", "Bakwan Jagung", "25 menit",
                "3 buah jagung manis, disisir\n" +
                "7 sdm penuh tepung terigu (sy pake segitiga)\n" +
                "2 sdm tepung beras\n" +
                "4 siung bawang putih ditumbuk halus\n" +
                "8 btr bawang merah diiris halus\n" +
                "5 batang seledri iris halus\n" +
                "2 batang daun bawang kecil iris halus\n" +
                "secukupnya air\n" +
                "secukupnya Garam, merica", 
                
                "1. Cuci jagung, sisir dg pisau. Taro dlm baskom. Siapkan bahan2\n" + 
                "2. Campur semua bahan dlm baskom. Aduk rata\n" + 
                "3. Penampakan adonan bakwan jagung yg telah dicampur. Dilihat adonan nya ya...kalo terlalu kental tambahkan air sebaliknya kalo kurang tepung tambahkan terigu. Jangan lupa beri garam dan merica. Tidak perlu kasih gula krn jagung sudah manis\n" +
                "4. Goreng adonan bakwan dlm minyak panas. Kalo mau bikin tebal tinggal ditebalin aja adonan nya pake 2 buah sendok krn sy sukanya tipis2 sy cm pake 1 sendok langsung beberkan adonan ke dalam minyak\n" + 
                "5. Goreng bakwan sampai matang"));
        

    }
    
    // method untuk mengambil isi dari array list resep dan menampilkannya ke tabel    
    public final void selectResepMasakan(){
        
        ArrayList<ResepMasakan> data = new ArrayList<ResepMasakan>(); // inisialiasasi local array list 
        
        // pengondisian pencarian resep jika parameter keyword tidak kosong
        if(!cari.equals("")){
            for(ResepMasakan rm : resepResepMasakan){
                if(rm.getNama().toLowerCase().contains(cari.toLowerCase())){
                    data.add(rm);
                }
            }
        }else{
            data = resepResepMasakan; // jika parameter keyword kosong maka data yang akan ditampilkan adalah keseluruhan isi dari array list resep masakan
        }
        
        // pengondisian untuk pengurutan resep berdasarkan nama
        if(urutkan.equals("Atas Ke Bawah")){
          Collections.sort(data, Comparator.comparing(ResepMasakan::getNama));
        }else if(urutkan.equals("Bawah Ke Atas")){
          Collections.sort(data, Comparator.comparing(ResepMasakan::getNama));
          Collections.reverse(data);
        }else{
            Collections.sort(data, Comparator.comparing(ResepMasakan::getIdResepMasakan));
        }
        
        // inisialisai tabel dan objek
        DefaultTableModel tableResepMasakan = (DefaultTableModel)tableMasakan.getModel();
        Object[] row = new Object[5];
        
        // mengambil seluruh isi array list local yang sudah di filter ke dalam tabel dalam bentuk objek
        for(int i = 0; i < data.size(); i++){
            row[0] = data.get(i).getIdResepMasakan();
            row[1] = data.get(i).getNama();
            row[2] = data.get(i).getLamaMemasak();
            row[3] = data.get(i).getBahanBahan();
            row[4] = data.get(i).getCaraMemasak();
            
            tableResepMasakan.addRow(row);
        }
    }
    
    // method untuk mereset dan menampilkan resep masakan
    public final void showResepMasakan(){
        DefaultTableModel tableResepMasakan = (DefaultTableModel)tableMasakan.getModel();
        tableResepMasakan.setRowCount(0); // 
        selectResepMasakan();
    }
    
    /**
     * Creates new form FrameAplikasiResepMasakan
     */
    public FrameAplikasiResepMasakan() {
        initComponents();
        setLocationRelativeTo(null);
        initialResepMasakan();
        showResepMasakan();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMasakan = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        tfCari = new javax.swing.JTextField();
        btnImport = new javax.swing.JButton();
        btnLihat = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbUrutkan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Resep Masakan - MamaMia");
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(222, 160, 87));

        jLabel1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(252, 255, 231));
        jLabel1.setText("Aplikasi Resep Masakan");

        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mamamia");

        btnKeluar.setBackground(new java.awt.Color(206, 148, 97));
        btnKeluar.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnKeluar.setText("Keluar");
        btnKeluar.setBorder(null);
        btnKeluar.setBorderPainted(false);
        btnKeluar.setMaximumSize(new java.awt.Dimension(50, 25));
        btnKeluar.setMinimumSize(new java.awt.Dimension(50, 25));
        btnKeluar.setPreferredSize(new java.awt.Dimension(50, 25));
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(252, 255, 231));
        jScrollPane1.setInheritsPopupMenu(true);

        tableMasakan.setBackground(new java.awt.Color(252, 255, 231));
        tableMasakan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tableMasakan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Resep", "Nama", "Lama Memasak", "Bahan-Bahan", "Cara Memasak"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMasakan.setToolTipText("");
        tableMasakan.setOpaque(false);
        tableMasakan.setRowHeight(25);
        tableMasakan.setSelectionBackground(new java.awt.Color(224, 216, 176));
        jScrollPane1.setViewportView(tableMasakan);
        if (tableMasakan.getColumnModel().getColumnCount() > 0) {
            tableMasakan.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        btnTambah.setBackground(new java.awt.Color(222, 160, 87));
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        tfCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCariKeyTyped(evt);
            }
        });

        btnImport.setBackground(new java.awt.Color(252, 255, 231));
        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        btnLihat.setBackground(new java.awt.Color(222, 160, 87));
        btnLihat.setForeground(new java.awt.Color(255, 255, 255));
        btnLihat.setText("Lihat Selengkapnya");
        btnLihat.setBorder(null);
        btnLihat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatActionPerformed(evt);
            }
        });

        btnExport.setBackground(new java.awt.Color(252, 255, 231));
        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Cari");

        cbUrutkan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cbUrutkan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Default", "Atas Ke Bawah", "Bawah Ke Atas" }));
        cbUrutkan.setToolTipText("Urutkan data resep");
        cbUrutkan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbUrutkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUrutkanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLihat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnImport)
                        .addGap(5, 5, 5)
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbUrutkan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImport)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTambah)
                        .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(cbUrutkan, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLihat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // event menampikan frame tambah    
    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        FrameTambahResepMasakan frameTambah = new FrameTambahResepMasakan();
        frameTambah.setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        showResepMasakan(); // tabel akan direset jika frame utama ditampilkan atau aktif
    }//GEN-LAST:event_formWindowActivated

   
    private void btnLihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatActionPerformed
        int i = tableMasakan.getSelectedRow(); // mengambil informasi row keberapa yang dipilih di tabel
        if(i >= 0){
            TableModel model = tableMasakan.getModel();
            
            resepMasakan = new ResepMasakan();
            
            // mengambil nilai dari row atau baris tabel yang di seleksi dimasukkan ke dalam objek ResepMasakan yang dibuat            
            resepMasakan.setIdResepMasakan(model.getValueAt(i, 0).toString());
            resepMasakan.setNama(model.getValueAt(i, 1).toString());
            resepMasakan.setLamaMemasak(model.getValueAt(i, 2).toString());
            resepMasakan.setBahanBahan(model.getValueAt(i, 3).toString());
            resepMasakan.setCaraMemasak(model.getValueAt(i, 4).toString());
            
            // menampilkan frame detail resep dengan isi objek resep yang sudah dibuat
            FrameDetailResepMasakan frameDetail = new FrameDetailResepMasakan(resepMasakan);
            frameDetail.setVisible(true);
        }else{
           JOptionPane.showMessageDialog(this, "Pilih salah satu resep terlebih dahulu", "Pilih Resep", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnLihatActionPerformed

    // event ketika text field cari sedang diketik dan melakukan pencarian
    private void tfCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCariKeyTyped
        cari = tfCari.getText();
        showResepMasakan();
    }//GEN-LAST:event_tfCariKeyTyped

    // event tombol export dengan isi paramater frame export
    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        FrameImportExportResepMasakan frameExport = new FrameImportExportResepMasakan("EXPORT");
        frameExport.setVisible(true);
    }//GEN-LAST:event_btnExportActionPerformed

    // event tombol import dengan isi parameter frame import
    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        FrameImportExportResepMasakan frameExport = new FrameImportExportResepMasakan("IMPORT");
        frameExport.setVisible(true);
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // konfirmasi apakah pengguna benar benar ingin keluar dari aplikasi atau tidak
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Yakin ingin keluar dari aplikasi ini?", "Keluar", JOptionPane.YES_NO_OPTION);
        if(konfirmasi == 0 ){
            System.exit(0);
        }
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void cbUrutkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUrutkanActionPerformed
        urutkan = cbUrutkan.getSelectedItem().toString();
        showResepMasakan();
    }//GEN-LAST:event_cbUrutkanActionPerformed

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
            java.util.logging.Logger.getLogger(FrameAplikasiResepMasakan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAplikasiResepMasakan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAplikasiResepMasakan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAplikasiResepMasakan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameAplikasiResepMasakan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnLihat;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cbUrutkan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMasakan;
    private javax.swing.JTextField tfCari;
    // End of variables declaration//GEN-END:variables
}
