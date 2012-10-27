package ananas.lib.blueprint2.awt;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.HashMap;
import java.util.Map;

import ananas.lib.blueprint2.dom.IAttr;

public class FlowLayoutWrapper extends ObjectWrapper implements
		LayoutManagerWrapper {

	private static Map<String, Integer> sAlignMapper = null;
	private String m_attr_align;

	public FlowLayoutWrapper() {
	}

	@Override
	public LayoutManager getLayoutManager(boolean create) {
		return (LayoutManager) this.getTarget(create);
	}

	@Override
	public void addComponentToContainer(Component component,
			Container container, String position) {

		container.add(component);
	}

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if (name == null) {
			return false;
		} else if (name.equals("align")) {
			this.m_attr_align = attr.getValue();
			return true;
		} else {
			return super.setAttribute(attr);
		}
	}

	public void onTagEnd() {
		super.onTagEnd();

		FlowLayout target = (FlowLayout) this.getTarget(true);
		String align = this.m_attr_align;
		if (align != null) {
			int n = this._alignStringToInt(align);
			target.setAlignment(n);
		}
	}

	private int _alignStringToInt(String align) {
		Map<String, Integer> map = sAlignMapper;
		if (map == null) {
			map = new HashMap<String, Integer>();
			map.put("CENTER", FlowLayout.CENTER);
			map.put("LEFT", FlowLayout.LEFT);
			map.put("RIGHT", FlowLayout.RIGHT);
			map.put("LEADING", FlowLayout.LEADING);
			map.put("TRAILING", FlowLayout.TRAILING);
			sAlignMapper = map;
		}
		Integer ret = map.get(align);
		if (ret == null) {
			return FlowLayout.CENTER;
		}
		return ret;
	}

}
