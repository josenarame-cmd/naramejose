import java.awt.*;
import java.awt.event.*;



public class Myshapes extends Frame {

    public Myshapes() {
        // --- 1. Frame Setup ---
        setTitle("My Shapes - Smiley Face");
        setSize(400, 400);


        DrawingCanvas canvas = new DrawingCanvas();
        add(canvas, BorderLayout.CENTER);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });

        setVisible(true);
    }

    // Inner class to handle the custom drawing
    class DrawingCanvas extends Canvas {
        public DrawingCanvas() {
            setBackground(Color.WHITE); // Background matches the image
        }



        @Override
        public void paint(Graphics g) {
            super.paint(g);
            int width = getSize().width;
            int height = getSize().height;

            // Calculate center and radius to keep the drawing responsive and centered
            int centerX = width / 2;
            int centerY = height / 2;
            int radius = Math.min(width, height) / 3;

            // Set drawing color to black
            g.setColor(Color.BLACK);


            g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

            // 2. Draw the eyes (Small filled circles)
            int eyeSize = radius / 8;
            int eyeOffset = radius / 3;

            // Left Eye: fillOval(x, y, width, height)
            g.fillOval(centerX - eyeOffset - eyeSize / 2, centerY - eyeOffset - eyeSize / 2, eyeSize, eyeSize);

            // Right Eye
            g.fillOval(centerX + eyeOffset - eyeSize / 2, centerY - eyeOffset - eyeSize / 2, eyeSize, eyeSize);

            // 3. Draw the mouth (Arc for a smile)
            int mouthWidth = radius;
            int mouthHeight = radius / 3;
            int mouthY = centerY + radius / 4;

            // drawArc(x, y, width, height, startAngle, arcAngle)
            // A start angle of 0 and an arc of -180 degrees creates a downward-facing smile/arc.
            g.drawArc(centerX - mouthWidth / 2, mouthY, mouthWidth, mouthHeight, 0, -180);
        }
    }

    public static void main(String[] args) {
        new Myshapes();
    }
}
