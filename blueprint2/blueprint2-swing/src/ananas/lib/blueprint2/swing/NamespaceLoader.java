package ananas.lib.blueprint2.swing;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JToolTip;
import javax.swing.JTree;
import javax.swing.JViewport;
import javax.swing.border.Border;

import ananas.lib.blueprint2.dom.helper.IImplementation;
import ananas.lib.blueprint2.dom.helper.INamespace;
import ananas.lib.blueprint2.dom.helper.INamespaceLoader;
import ananas.lib.blueprint2.element.base.BaseAttr;

public class NamespaceLoader implements INamespaceLoader {

	class MyHelper {

		private final INamespace mNS;
		private final String mURI;

		public MyHelper(INamespace ns) {
			this.mNS = ns;
			this.mURI = ns.getNamespaceURI();
		}

		public void reg(String localName, Class<?> classWrapper,
				Class<?> classTarget) {

			this.mNS.registerClass(this.mURI, localName, classWrapper,
					classTarget);
		}
	}

	@Override
	public INamespace load(IImplementation impl) {
		String uri = "xmlns:ananas:blueprint:swing";
		String defaultPrefix = "swing";
		INamespace ns = impl.newNamespace(uri, defaultPrefix);
		MyHelper h = new MyHelper(ns);
		{
			// attribute

			h.reg("actionCommand", BaseAttr.class, String.class);
			h.reg("actionListener", BaseAttr.class, String.class);
			h.reg("axis", BaseAttr.class, String.class);
			h.reg("background", BaseAttr.class, Color.class);
			h.reg("command", BaseAttr.class, String.class);
			h.reg("dividerLocation", BaseAttr.class, Double.class);
			h.reg("dividerSize", BaseAttr.class, Integer.class);
			h.reg("editable", BaseAttr.class, Boolean.class);
			h.reg("floatable", BaseAttr.class, Boolean.class);
			h.reg("height", BaseAttr.class, Integer.class);
			h.reg("horizontalAlignment", BaseAttr.class, String.class);
			h.reg("id", BaseAttr.class, String.class);
			h.reg("label", BaseAttr.class, String.class);
			h.reg("orientation", BaseAttr.class, String.class);
			h.reg("resizeWeight", BaseAttr.class, Double.class);
			h.reg("title", BaseAttr.class, String.class);
			h.reg("src", BaseAttr.class, String.class);
			h.reg("text", BaseAttr.class, String.class);
			h.reg("value", BaseAttr.class, String.class);
			h.reg("verticalAlignment", BaseAttr.class, String.class);
			h.reg("width", BaseAttr.class, Integer.class);
			h.reg("x", BaseAttr.class, Integer.class);
			h.reg("y", BaseAttr.class, Integer.class);
			h.reg("font", BaseAttr.class, Integer.class);
			h.reg("preferredSizeX", BaseAttr.class, Integer.class);
			h.reg("preferredSizeY", BaseAttr.class, Integer.class);

		}
		{
			// element

			h.reg("position", Swing_positionWrapper.class, Swing_position.class);

			h.reg("Border", BorderWrapper.class, Border.class);
			h.reg("BorderFactory", BorderFactoryWrapper.class,
					BorderFactory.class);
			h.reg("BoxLayout", BoxLayoutWrapper.class, BoxLayout.class);
			h.reg("ImageIcon", ImageIconWrapper.class, ImageIcon.class);

			h.reg("JMenu", JMenuWrapper.class, JMenu.class);
			h.reg("JMenuBar", JMenuBarWrapper.class, JMenuBar.class);
			h.reg("JMenuItem", JMenuItemWrapper.class, JMenuItem.class);
			h.reg("JPopupMenu", JPopupMenuWrapper.class, JPopupMenu.class);

			h.reg("JButton", JButtonWrapper.class, JButton.class);
			h.reg("JCheckBox", JCheckBoxWrapper.class, JCheckBox.class);
			h.reg("JComboBox", JComboBoxWrapper.class, JComboBox.class);
			h.reg("JDesktopPane", JDesktopPaneWrapper.class, JDesktopPane.class);
			h.reg("JEditorPane", JEditorPaneWrapper.class, JEditorPane.class);
			h.reg("JFormattedTextField", JFormattedTextFieldWrapper.class,
					JFormattedTextField.class);
			h.reg("JFrame", JFrameWrapper.class, JFrame.class);
			h.reg("JInternalFrame", JInternalFrameWrapper.class,
					JInternalFrame.class);
			h.reg("JLabel", JLabelWrapper.class, JLabel.class);
			h.reg("JLayeredPane", JLayeredPaneWrapper.class, JLayeredPane.class);
			h.reg("JList", JListWrapper.class, JList.class);
			h.reg("JPanel", JPanelWrapper.class, JPanel.class);
			h.reg("JPasswordField", JPasswordFieldWrapper.class,
					JPasswordField.class);
			h.reg("JProgressBar", JProgressBarWrapper.class, JProgressBar.class);
			h.reg("JRadioButton", JRadioButtonWrapper.class, JRadioButton.class);
			h.reg("JScrollBar", JScrollBarWrapper.class, JScrollBar.class);
			h.reg("JScrollPane", JScrollPaneWrapper.class, JScrollPane.class);
			h.reg("JSeparator", JSeparatorWrapper.class, JSeparator.class);
			h.reg("JSlider", JSliderWrapper.class, JSlider.class);
			h.reg("JSplitPane", JSplitPaneWrapper.class, JSplitPane.class);
			h.reg("JSpinner", JSpinnerWrapper.class, JSpinner.class);

			h.reg("JTabbedPane", JTabbedPaneWrapper.class, JTabbedPane.class);
			h.reg("JTable", JTableWrapper.class, JTable.class);
			h.reg("JTextArea", JTextAreaWrapper.class, JTextArea.class);
			h.reg("JTextField", JTextFieldWrapper.class, JTextField.class);
			h.reg("JTextPane", JTextPaneWrapper.class, JTextPane.class);

			h.reg("JToggleButton", JToggleButtonWrapper.class,
					JToggleButton.class);
			h.reg("JToolBar", JToolBarWrapper.class, JToolBar.class);
			h.reg("JToolTip", JToolTipWrapper.class, JToolTip.class);
			h.reg("JTree", JTreeWrapper.class, JTree.class);

			h.reg("JViewport", JViewportWrapper.class, JViewport.class);
			h.reg("JDialog", JDialogWrapper.class, JDialog.class);

		}
		return ns;
	}

}
