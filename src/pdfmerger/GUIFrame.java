/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfmerger;

import java.awt.Desktop;
import java.io.File;
import java.util.prefs.Preferences;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.pdfbox.util.PDFMergerUtility;

/**
 *
 * @author Ryan
 */
public class GUIFrame extends javax.swing.JFrame {

    Preferences prefsRoot;
    Preferences prefs;
    public GUIFrame() {
        JOptionPane.showMessageDialog(new JFrame(), "Welcome to PDFMerger");
        prefsRoot = Preferences.userRoot();
        prefs = prefsRoot.node(GUIFrame.class.getName());
        InitTask task = new InitTask();
        task.execute();
    }

    class InitTask extends SwingWorker<Void, Void> {

        IndeterminateLoadingFrame ilf;
        public InitTask() {
            ilf = new IndeterminateLoadingFrame();
        }

        String savedFile1Path_str;
        String savedFile2Path_str;
        String savedOutputPath_str;
        String savedOutputFileName_str;
        
        @Override
        protected Void doInBackground() throws Exception {
            
            savedFile1Path_str = prefs.get("file1Path", "");
            savedFile2Path_str = prefs.get("file2Path", "");
            savedOutputPath_str = prefs.get("outputDir", "");
            savedOutputFileName_str = prefs.get("outputFileName", "");
                
            return null;
        }

        @Override
        protected void done() {
            
            initComponents();
            outputDir.setText(savedOutputPath_str);
            file1Path.setText(savedFile1Path_str);
            file2Path.setText(savedFile2Path_str);
            outputFileName.setText(savedOutputFileName_str);
            jCheckBox1.setSelected(prefs.getBoolean("open", false));
            
            outputFileName.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    System.out.println(e.toString());
                    changedUpdate(e);
                }


                @Override
                public void removeUpdate(DocumentEvent e) {
                    System.out.println(e.toString());
                    changedUpdate(e);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    System.out.println("Saving");
                    prefs.put("outputFileName", outputFileName.getText());
                }
            });
            
            outputDir.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    System.out.println(e.toString());
                    changedUpdate(e);
                }


                @Override
                public void removeUpdate(DocumentEvent e) {
                    System.out.println(e.toString());
                    changedUpdate(e);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    System.out.println("Saving");
                    prefs.put("outputDir", outputDir.getText());
                }
            });
            
            file1Path.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    System.out.println(e.toString());
                    changedUpdate(e);
                }


                @Override
                public void removeUpdate(DocumentEvent e) {
                    System.out.println(e.toString());
                    changedUpdate(e);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    System.out.println("Saving");
                    prefs.put("file1Path", file1Path.getText());
                }
            });
            
            file2Path.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    System.out.println(e.toString());
                    changedUpdate(e);
                }


                @Override
                public void removeUpdate(DocumentEvent e) {
                    System.out.println(e.toString());
                    changedUpdate(e);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    System.out.println("Saving");
                    prefs.put("file2Path", file2Path.getText());
                }
            });
            
            ilf.close();
            setVisible(true);
            setLocationRelativeTo(null);
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        file2Path = new javax.swing.JTextField();
        file1Path = new javax.swing.JTextField();
        outputFileName = new javax.swing.JTextField();
        outputDir = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDFMerger");

        jButton3.setText("Browse");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText(".pdf");

        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        file2Path.setText("jTextField4");

        file1Path.setText("jTextField3");

        outputFileName.setText("jTextField2");

        outputDir.setText("jTextField1");

        jLabel4.setText("Output Filename:");

        jLabel1.setText("File #1:");

        jLabel3.setText("Output Dir:");

        jLabel2.setText("File #2:");

        jButton4.setText("Merge");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("open");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(file1Path)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(outputDir, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(45, 45, 45)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(50, 50, 50))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(outputFileName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(file2Path)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(file1Path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(file2Path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jCheckBox1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new FileChooserFileName(file1Path.getText(), file1Path).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        new FileChooserFileName(file2Path.getText(), file2Path).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        new FileChooserOutputDir(outputDir.getText(), outputDir).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            PDFMergerUtility pdfmu = new PDFMergerUtility();
            pdfmu.addSource(new File(file1Path.getText()));
            pdfmu.addSource(new File(file2Path.getText()));
            String filename = outputDir.getText() + File.separator + outputFileName.getText() + ".pdf";
            File file = new File(filename);
            if(file.exists())
                file.createNewFile();
            pdfmu.setDestinationFileName(filename);
            pdfmu.mergeDocuments();
            
            System.out.println(filename);

            if(jCheckBox1.isSelected()) {
                if(Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(new File(filename));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error merging PDFs.\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        prefs.putBoolean("open", jCheckBox1.isSelected());
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField file1Path;
    private javax.swing.JTextField file2Path;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField outputDir;
    private javax.swing.JTextField outputFileName;
    // End of variables declaration//GEN-END:variables
}
