package impl.ananas.blueprint4.core.util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import ananas.blueprint4.core.BPContext;
import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.util.BPDocumentBuilder;

final class BPDocumentBuilderImpl implements BPDocumentBuilder {

	@Override
	public BPDocument build(BPContext context, Document dom) {

		DOMImplementationLS ls = (DOMImplementationLS) dom.getImplementation()
				.getFeature("LS", "3.0");
		LSSerializer seri = ls.createLSSerializer();
		LSOutput out = ls.createLSOutput();

		seri.setNewLine("\n");

		out.setEncoding("UTF-8");
		out.setByteStream(System.out);

		Node node = dom.getElementsByTagName("filter-list").item(0);
		seri.write(node, out);

		// TODO Auto-generated method stub
		return null;
	}
}
