package pl.geeksoft.examples;

import javax.swing.*;

import pl.geeksoft.examples.ui.MainWindow;

public class Application {

	public static void main(String[] args) {
		new Application().start();
	}

	public void start() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainWindow().setVisible(true);
			}

		});
	}

}
