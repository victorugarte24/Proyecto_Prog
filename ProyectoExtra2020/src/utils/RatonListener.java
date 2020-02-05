package utils;

import java.awt.Frame;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.print.attribute.standard.Finishings;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;

public class RatonListener extends SwingWorker<Integer, String> {
	private static Timer timer;
    private static final int DELAY = 1000;
    private static final int FINAL = 10;
    private static Set<MouseMotionListener> mouseMotionListeners;
    private static int counter = 0;
    public static Frame frame;
    
    public static AtomicBoolean INACTIVIDAD = new AtomicBoolean(false);
    
        public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		RatonListener.counter = counter;
	}

	public static Frame getFrame() {
		return frame;
	}

	public static void setFrame(Frame frame) {
		RatonListener.frame = frame;
	}

	public static AtomicBoolean getINACTIVIDAD() {
		return INACTIVIDAD;
	}

	public static void setINACTIVIDAD(AtomicBoolean iNACTIVIDAD) {
		INACTIVIDAD = iNACTIVIDAD;
	}

	public static int getDelay() {
		return DELAY;
	}

	public static int getFinal() {
		return FINAL;
	}

		@Override
        protected Integer doInBackground() throws Exception {
        	counter = 0;
            timer = new Timer(DELAY, new ActionListener() {
                private Point lastPoint = MouseInfo.getPointerInfo().getLocation();

                /* called every DELAY milliseconds to fetch the
                 * current mouse coordinates */

                public synchronized void actionPerformed(ActionEvent e) {
                    Point point = MouseInfo.getPointerInfo().getLocation();

                    if (!point.equals(lastPoint)) {
                        fireMouseMotionEvent(point);
                        counter = 0;
                    } else {
                        counter++;
                        System.out.println("Contador segundos: " + counter);
                        if(counter > FINAL) {
                        	//System.out.println("Termino...");
                        	stop();
                        	INACTIVIDAD.set(true);
                        	
                            Window[] children = Window.getWindows();
                            for (Window win : children) {
                                if (win instanceof JDialog) {
                                    win.dispose();
                                }
                            }
                        	try {
								this.finalize();
							} catch (Throwable e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
                        }
                    }

                    lastPoint = point;
                }
            });
            mouseMotionListeners = new HashSet<MouseMotionListener>();
            
            start();
            
            return 1;
        }
        
	    public void start() {
	        timer.start();
	    }

	    public void stop() {
	        timer.stop();
	        frame.dispose();
	    }
        
        protected void fireMouseMotionEvent(Point point) {
            synchronized (mouseMotionListeners) {
                for (final MouseMotionListener listener : mouseMotionListeners) {
                    final MouseEvent event =
                        new MouseEvent(frame, MouseEvent.MOUSE_MOVED, System.currentTimeMillis(),
                                       0, point.x, point.y, 0, false);

                    SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                listener.mouseMoved(event);
                            }
                        });
                }
            }
        }
    };

