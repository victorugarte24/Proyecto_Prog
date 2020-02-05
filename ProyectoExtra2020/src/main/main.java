package main;

import java.util.concurrent.atomic.AtomicBoolean;

import utils.RatonListener;
import ventanas.VentanaInicio;

public class main {

	public static void main(String[] args) {
		RatonListener rl = new RatonListener();
		rl.execute();
		rl.setINACTIVIDAD(new AtomicBoolean(false));
		int empezar = 1;
		while (rl.getINACTIVIDAD().get() || empezar == 1) {
			empezar = 0;
			VentanaInicio vi = new VentanaInicio();
			vi.setVisible(true);
			rl.setFrame(vi);

		}

	}

}
