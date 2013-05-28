package pl.geeksoft.examples.ui;

import java.awt.*;

import javax.swing.*;

import org.apache.commons.lang3.StringUtils;

/**
 * User: Damian Dunajski
 * Date: 28.05.2013
 * Time: 22:54
 */
public class MainWindow extends JFrame {

	public MainWindow() {
		buildControls();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void buildControls() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.add(new JLabel("Hello World", JLabel.CENTER));
		panel.add(new JButton(StringUtils.swapCase("Click me!")));
		add(panel);
		pack();
	}

}
