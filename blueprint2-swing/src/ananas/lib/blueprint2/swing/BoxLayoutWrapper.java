package ananas.lib.blueprint2.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.util.HashMap;

import javax.swing.BoxLayout;

import ananas.lib.blueprint2.awt.LayoutManagerWrapper;
import ananas.lib.blueprint2.awt.ObjectWrapper;
import ananas.lib.blueprint2.dom.IAttr;

public class BoxLayoutWrapper extends ObjectWrapper implements
		LayoutManagerWrapper {

	private Container mContainer;
	private Object m_attr_axis;

	@Override
	public LayoutManager getLayoutManager(boolean create) {
		return (LayoutManager) this.getTarget(create);
	}

	@Override
	public void addComponentToContainer(Component component,
			Container container, String position) {
		this.mContainer = container;
		container.add(component);
	}

	public void onTagEnd() {
		super.onTagEnd();
	}

	@Override
	public Object createTarget() {
		Integer n = sMapper.get(this.m_attr_axis);
		if (n == null) {
			n = BoxLayout.X_AXIS;
		}
		return new BoxLayout(this.mContainer, n);
	}

	@Override
	public boolean setContainer(Container container) {
		this.mContainer = container;
		return true;
	}

	static final HashMap<String, Integer> sMapper = new HashMap<String, Integer>();
	static {
		sMapper.put("LINE_AXIS", BoxLayout.LINE_AXIS);
		sMapper.put("PAGE_AXIS", BoxLayout.PAGE_AXIS);
		sMapper.put("X_AXIS", BoxLayout.X_AXIS);
		sMapper.put("Y_AXIS", BoxLayout.Y_AXIS);
	}

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if (name == null) {
			return false;
		} else if (name.equals("axis")) {
			this.m_attr_axis = attr.getValue();
			return true;
		} else {
			return super.setAttribute(attr);
		}
	}

}
