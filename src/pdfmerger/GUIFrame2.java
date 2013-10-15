/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfmerger;

import java.awt.Desktop;
import java.io.File;
import java.util.prefs.Preferences;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.pdfbox.util.PDFMergerUtility;

/**
 *
 * @author Ryan
 */
public class GUIFrame2 extends javax.swing.JFrame {

    Preferences prefsRoot;
    Preferences prefs;
    public GUIFrame2() {
        JOptionPane.showMessageDialog(new JFrame(), "Welcome to PDFMerger.\n\n"
                + "For support, please email ryan@vantagecp.com.");
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

        String savedOutputPath_str;
        String savedOutputFileName_str;
        int savedNumberOfFiles;
        String[] files;
        
        @Override
        protected Void doInBackground() throws Exception {
            
            savedOutputPath_str = prefs.get("outputDir", "");
            savedOutputFileName_str = prefs.get("outputFileName", "");
            savedNumberOfFiles = prefs.getInt("numOfFiles", 0);
            if(savedNumberOfFiles > 0) {
                files = new String[savedNumberOfFiles];
                for(int i = 0; i < savedNumberOfFiles; i++) {
                    files[i] = prefs.get("savedFile" + i, "");
                }
            } else
                files = new String[0];
                
            return null;
        }

        @Override
        protected void done() {
            
            initComponents();
            outputDir.setText(savedOutputPath_str);
            outputFileName.setText(savedOutputFileName_str);
            jCheckBox1.setSelected(prefs.getBoolean("open", false));
            
            outputFileName.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    
                    changedUpdate(e);
                }


                @Override
                public void removeUpdate(DocumentEvent e) {
                    
                    changedUpdate(e);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    
                    prefs.put("outputFileName", outputFileName.getText());
                }
            });
            
            outputDir.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    
                    changedUpdate(e);
                }


                @Override
                public void removeUpdate(DocumentEvent e) {
                    
                    changedUpdate(e);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    prefs.put("outputDir", outputDir.getText());
                }
            });
            
            jList1.setListData(files);
            
            setVisible(true);
            ilf.close();
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
        jButton1 = new javax.swing.JButton();
        outputFileName = new javax.swing.JTextField();
        outputDir = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDFMerger");

        jButton3.setText("Browse");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText(".pdf");

        jButton1.setText("Add Files");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        outputFileName.setText("jTextField2");

        outputDir.setText("jTextField1");

        jLabel4.setText("Output Filename:");

        jLabel1.setText("File List");

        jLabel3.setText("Output Directory:");

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

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jButton2.setText("Delete Selected");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("Clear All");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Move Up");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Move Down");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(outputDir, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(outputFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jCheckBox1))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(outputFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jButton3))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addFiles(File[] files) {
        int size = jList1.getModel().getSize();
        String[] newList = new String[size + files.length];
        for(int i = 0; i < size; i++) {
            String s = jList1.getModel().getElementAt(i).toString();
            newList[i] = s;
            prefs.put("savedFile" + i, s);
            prefs.putInt("numOfFiles", i+1);
        }
        for(int i = size; i < size + files.length; i++) {
            String s = files[i - size].getPath();
            newList[i] = s;
            prefs.put("savedFile" + i, s);
            prefs.putInt("numOfFiles", i+1);
        }
        
        System.out.println("numOfFiles = " + prefs.getInt("numOfFiles", -1));
        jList1.setListData(newList);
        
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new FileChooserMultiFiles(this).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        new FileChooserOutputDir(outputDir.getText(), outputDir).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            PDFMergerUtility pdfmu = new PDFMergerUtility();
            for(int i = 0; i < jList1.getModel().getSize(); i++) {
                pdfmu.addSource(jList1.getModel().getElementAt(i).toString());
            }
            String filename = outputDir.getText() + File.separator + outputFileName.getText() + ".pdf";
            File file = new File(filename);
            if(file.exists())
                file.createNewFile();
            pdfmu.setDestinationFileName(filename);
            pdfmu.mergeDocuments();
            

            if(jCheckBox1.isSelected()) {
                if(Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(new File(filename));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error merging PDFs.\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        prefs.putBoolean("open", jCheckBox1.isSelected());
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        jList1.setListData(new String[0]);
        
        for(int i = 0; i < prefs.getInt("numOfFiles", 0); i++) {
            prefs.remove("savedFile" + i);
        }
        prefs.putInt("numOfFiles", 0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int size = jList1.getModel().getSize();
        int[] selectedIndices = jList1.getSelectedIndices();
        String[] newList = new String[size - selectedIndices.length];
        int SI_index = 0;
        for(int i = 0; i < size; i++) {
            if(SI_index >= selectedIndices.length || i != selectedIndices[SI_index]) {
                String s = jList1.getModel().getElementAt(i).toString();
                newList[i - SI_index] = s;
                prefs.put("savedFile" + (i - SI_index), s);
            } else
                SI_index++;
        }
        
        jList1.setListData(newList);
        
        for(int i = newList.length; i < prefs.getInt("numOfFiles", 0); i++) {
            prefs.remove("savedFile" + i);
        }
        
        prefs.putInt("numOfFiles", newList.length);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        int size = jList1.getModel().getSize();
        
        int[] selectedIndices = jList1.getSelectedIndices();
        if(selectedIndices.length > 0 && selectedIndices[0] > 0) {
            String[] oldList = new String[size];
            String[] newList = new String[size];

            for(int i = 0; i < size; i++) {
                oldList[i] = jList1.getModel().getElementAt(i).toString();
            }
            int firstIndex = selectedIndices[0];
            int lastIndex = selectedIndices[selectedIndices.length - 1];
            System.arraycopy(oldList, 0, newList, 0, firstIndex - 1);
            for(int i = firstIndex; i <= lastIndex; i++) {
                newList[i-1] = oldList[i];
                prefs.put("savedFile" + (i-1), newList[i-1]);
            }
            newList[lastIndex] = oldList[firstIndex - 1];
            prefs.put("savedFile" + lastIndex, newList[lastIndex]);
            System.arraycopy(oldList, lastIndex + 1, newList, lastIndex + 1, size - (lastIndex + 1));
            
            jList1.setListData(newList);
            
            for(int i = 0; i < selectedIndices.length; i++)
                selectedIndices[i] = selectedIndices[i] - 1;
            
            jList1.setSelectedIndices(selectedIndices);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        int size = jList1.getModel().getSize();
        
        int[] selectedIndices = jList1.getSelectedIndices();
        if(selectedIndices.length > 0 && selectedIndices[selectedIndices.length - 1] < (size - 1)) {
            
            String[] oldList = new String[size];
            String[] newList = new String[size];

            for(int i = 0; i < size; i++) {
                oldList[i] = jList1.getModel().getElementAt(i).toString();
            }

            int firstIndex = selectedIndices[0];
            int lastIndex = selectedIndices[selectedIndices.length - 1];
            System.arraycopy(oldList, 0, newList, 0, firstIndex);
            newList[firstIndex] = oldList[lastIndex + 1];
            prefs.put("savedFile" + firstIndex, newList[firstIndex]);
            for(int i = firstIndex; i <= lastIndex; i++) {
                newList[i+1] = oldList[i];
                prefs.put("savedFile" + (i+1), newList[i+1]);
            }
            System.arraycopy(oldList, lastIndex + 2, newList, lastIndex + 2, size - (lastIndex + 2));
            
            jList1.setListData(newList);
            
            for(int i = 0; i < selectedIndices.length; i++)
                selectedIndices[i] = selectedIndices[i] + 1;
            
            jList1.setSelectedIndices(selectedIndices);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
        }
        
        new GUIFrame2();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField outputDir;
    private javax.swing.JTextField outputFileName;
    // End of variables declaration//GEN-END:variables
}