package ananas.lib.blueprint3.awt;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.HashMap;
import java.util.Map;

import ananas.lib.blueprint3.awt.helper.Ctrl_AWTObject;
import ananas.lib.blueprint3.awt.helper.ILayoutManager;

public class CBorderLayout extends Ctrl_AWTObject implements ILayoutManager {

	private boolean mIsInit = false;

	@Override
	public void addComponentToContainer(CContainer cont, CComponent comp,
			String pos) {

		Container tCont = cont.getTargetContainer();
		Component tComp = comp.target_component();

		this.initIfNot(tCont);

		String constr = this.getConstraintsByPos(pos);

		tCont.add(tComp, constr);
	}

	private void initIfNot(Container tCont) {

		if (!this.mIsInit) {
			this.mIsInit = true;
			tCont.setLayout(new BorderLayout());
		}

	}

	private static Map<String, String> s_constr_map = null;

	private String getConstraintsByPos(String pos) {
		Map<String, String> map = s_constr_map;
		if (map == null) {
			map = new HashMap<String, String>();

			String[] array = { BorderLayout.SOUTH, BorderLayout.NORTH,
					BorderLayout.EAST, BorderLayout.WEST, BorderLayout.CENTER };
			for (String str : array) {
				map.put(str.toLowerCase(), str);
			}

			map.put("bottom", BorderLayout.SOUTH);
			map.put("top", BorderLayout.NORTH);
			map.put("right", BorderLayout.EAST);
			map.put("left", BorderLayout.WEST);
			s_constr_map = map;
		}
		String rlt;
		if (pos == null) {
			rlt = BorderLayout.CENTER;
		} else {
			pos = pos.toLowerCase();
			rlt = map.get(pos);
			if (rlt == null) {
				rlt = pos;
			}
		}
		return rlt;
	}
}
