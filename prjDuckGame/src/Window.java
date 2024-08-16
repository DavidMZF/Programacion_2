import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Window extends JFrame implements Runnable{

    public static final int WIDTH = 800, HEIGHT = 600; 
    private Canvas canvas;
    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    private final int FPS = 60;
    private double TARJETTIME = 1000000000/FPS;
    private double delta = 0;
    private int AVARAGEFPS = FPS;

    public Window() {
        setTitle("Duck Hunt");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(true);
        
        add(canvas);
        
    }
    
    int x = 0;
    private void update(){
        x++;
    }
    
    private void draw(){
        bs = canvas.getBufferStrategy();

        if(bs == null){
            canvas.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        //----------------------

        g.clearRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.BLACK);
        g.drawString(""+AVARAGEFPS, 10, 10);

        //----------------------

        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        
        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime)/TARJETTIME;
            time += (now - lastTime);
            lastTime = now;

            if(delta >= 1){
                update();
                draw();
                delta --;
                frames++;
                System.out.println(frames);
            }
            if (time >= 1000000000) {
                AVARAGEFPS = frames; 
                frames = 0;
                time = 0;
            }
        }

        stop();
    }

    public void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private void stop(){
        try {
            thread.join();
            running = false;
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
