import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * This is a class
 * Created 2020-09-29
 *
 * @author Magnus Silverdal
 */
public class GameRunner extends Canvas implements Runnable {
    private JFrame frame;
    private BufferedImage image;
    private int[] pixels;
    private GameOfLife game;
    private Thread thread;
    private boolean running = false;
    private int fps = 60;
    private int ups = 20;
    private int scale = 4;

    public GameRunner(int w, int h) {
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        Dimension size = new Dimension(scale*w, scale*h);
        setPreferredSize(size);
        frame = new JFrame();
        this.game = new GameOfLife(w,h);
    }

    private void draw() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        bs.show();
    }

    public synchronized void start() {
        running = true;
        game.update();
        game.render(pixels);
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        double fpsInterval = 1000000000.0 / fps;
        double upsInterval = 1000000000.0 / ups;
        double deltaRender = 0;
        double deltaUpdate = 0;
        int frames = 0;
        int updates = 0;
        long iterations = 1;
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();

        while (running) {
            long now = System.nanoTime();
            deltaRender += (now - lastTime) / fpsInterval;
            deltaUpdate += (now - lastTime) / upsInterval;
            lastTime = now;

            while(deltaUpdate >= 1) {
                game.update();
                game.render(pixels);
                updates++;
                deltaUpdate--;
                iterations++;
            }

            while(deltaRender >= 1) {
                draw();
                frames++;
                deltaRender--;
            }
        }
        stop();
    }

    public static void main(String[] args) {
        GameRunner runner = new GameRunner(200,200);
        runner.frame.add(runner);
        runner.frame.pack();
        runner.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runner.frame.setLocationRelativeTo(null);
        runner.frame.setVisible(true);
        runner.start();
    }
}