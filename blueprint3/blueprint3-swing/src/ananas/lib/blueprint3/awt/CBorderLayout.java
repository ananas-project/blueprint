package ananas.lib.blueprint3.awt;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.HashMap;
import java.util.Map;

import ananas.lib.blueprint3.core.lang.CObject;

public class CBorderLayout extends CObject implements IBorderLayout,
		ILayoutManager {

	@Override
	public void addComponentToContainer(CContainer cont, CComponent comp,
			String pos) {

		Container tCont = cont.getTargetContainer();
		Component tComp = comp.getTargetComponent();

		String constr = this.getConstraintsByPos(pos);

		tCont.add(tComp, constr);
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
