package bp2.swing.demo2;

import bp2.swing.demo2.gui.MainFrame;

public class Demo2_mdi {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				try {
					// UIManager.setLookAndFeel(UIManager
					// .getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}

				MainFrame mf = new MainFrame();
				mf.show();
			}
		});

	}

}
