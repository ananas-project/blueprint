package ananas.blueprint4.core.lang;

import ananas.blueprint4.core.BPContext;

public interface BPDocument extends BPNode {

	BPContext getContext();

	BPController getRootController();
}
