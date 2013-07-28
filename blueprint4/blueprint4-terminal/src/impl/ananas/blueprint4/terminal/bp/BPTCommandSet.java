package impl.ananas.blueprint4.terminal.bp;

import java.util.ArrayList;
import java.util.List;

import ananas.blueprint4.core.lang.BPNode;

public class BPTCommandSet extends BPTCommand {

	private final List<BPTCommandItem> _items = new ArrayList<BPTCommandItem>();

	protected boolean onAppendChild(BPNode child) {
		if (child instanceof BPTCommandItem) {
			BPTCommandItem item = (BPTCommandItem) child;
			_items.add(item);
			item.setParentItem(this);
		} else {
			return super.onAppendChild(child);
		}
		return true;
	}

	public void iterateItems(BPTCommandItemListener listener, boolean recursion) {
		super.iterateItems(listener, recursion);
		for (BPTCommandItem item : _items) {
			item.iterateItems(listener, recursion);
		}
	}

}
