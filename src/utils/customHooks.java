package utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JOptionPane;

public class customHooks {
    
    public static void scaleImage(String imgName, JLabel container)
    {
        ImageIcon icon = new ImageIcon("src/image/" + imgName); 
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(container.getWidth(), container.getHeight(), Image.SCALE_SMOOTH);
        container.setIcon(new ImageIcon(scaledImg));
    }
    
    public static void alert(String type, String message)
    {
        switch(type)
        {
            case "success":
                JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
            break;
            
            case "error":
                JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
            break;
        }
    }
    
    public static void changeFrame(JFrame currentPage, JFrame newPage) {
      currentPage.dispose(); // Close the current frame
      newPage.setLocationRelativeTo(null); // Center the new frame
      newPage.setVisible(true); // Show the new frame
    }
    
    public static void imageUpload()
    {
        JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select an Image");
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));

            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();

                // Define the target directory inside your project
                File targetDirectory = new File("src/image");
                if (!targetDirectory.exists()) {
                    targetDirectory.mkdirs(); // Create the directory if it doesn't exist
                }

                // Generate a unique filename using timestamp
                String fileExtension = selectedFile.getName().substring(selectedFile.getName().lastIndexOf("."));
                String uniqueFileName = System.currentTimeMillis() + fileExtension; // Example: 1710001234567.png

                // Save the image to the target directory with a new unique name
                File destination = new File(targetDirectory, uniqueFileName);
                try {
                    Files.copy(selectedFile.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(null, "Image uploaded successfully!\nSaved as: " + uniqueFileName, "Success", JOptionPane.INFORMATION_MESSAGE);

                    //imgNameLabel.setText(uniqueFileName); // Set the new filename in your UI

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
    }
}
