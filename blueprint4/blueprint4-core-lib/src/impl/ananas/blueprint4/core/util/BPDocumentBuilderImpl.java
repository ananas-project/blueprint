package impl.ananas.blueprint4.core.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import ananas.blueprint4.core.BPContext;
import ananas.blueprint4.core.lang.BPDocument;
import ananas.blueprint4.core.lang.BPElement;
import ananas.blueprint4.core.lang.BPNode;
import ananas.blueprint4.core.lang.BPText;
import ananas.blueprint4.core.util.BPDocumentBuilder;
import ananas.lib.util.logging.Logger;

final class BPDocumentBuilderImpl implements BPDocumentBuilder {

	final static Logger log = Logger.Agent.getLogger();

	@Override
	public BPDocument build(BPContext context, Document dom) {
		BPElement rlt = this.build(context, dom.getDocumentElement());
		return rlt.getOwnerDocument();
	}

	@Override
	public BPElement build(BPContext context, Element element) {
		MyBuildContext bc = new MyBuildContext();
		bc._bpDocument = context.getBPDocumentImplementation().createDocument(
				context);
		return this.buildElement(element, bc, 64);
	}

	private BPElement buildElement(Element element, BuildContext bc,
			int depthLimit) {

		if (depthLimit < 0) {
			throw new RuntimeException("the dom tree is too deep.");
		}

		BPDocument bpDoc = bc.getBPDocument();
		String uri, localName;
		uri = element.getNamespaceURI();
		localName = element.getLocalName();
		final BPElement pBpEle = bpDoc.createElement(uri, localName);
		if (pBpEle == null) {
			this.warning("cannot create bp-element", element, null);
			// return null;
		}

		// attributes
		;

		// children
		NodeList chs = element.getChildNodes();
		final int len = chs.getLength();
		for (int i = 0; i < len; i++) {
			Node chNode = chs.item(i);
			BPNode chBpNode = null;
			switch (chNode.getNodeType()) {
			case Node.ELEMENT_NODE: {
				final Element chEle = (Element) chNode;
				chBpNode = this.buildElement(chEle, bc, depthLimit - 1);
				break;
			}
			case Node.TEXT_NODE: {
				final Text chText = (Text) chNode;
				chBpNode = this.buildText(chText, bc);
				break;
			}
			case Node.ATTRIBUTE_NODE: {
				break;
			}
			default:
			}

			if ((chBpNode != null) && (pBpEle != null)) {
				boolean rlt = pBpEle.appendChild(chBpNode);
				if (!rlt) {
					this.warning("cannot append child to parent", element,
							chNode);
				}
			}

		}

		return pBpEle;
	}

	private BPText buildText(Text text, BuildContext bc) {
		String data = text.getData();
		return bc.getBPDocument().createText(data);
	}

	private void warning(String message, Node parent, Node child) {
		if (parent != null) {
			if (child != null) {
				String urip = this.getFullNodeURI(parent);
				String uric = this.getFullNodeURI(child);
				log.warn(message + "[parent:" + urip + "][child:" + uric + "]");
			} else {
				String uri = this.getFullNodeURI(parent);
				log.warn(message + ": " + uri);
			}
		} else {
			if (child != null) {
				String uri = this.getFullNodeURI(child);
				log.warn(message + ": " + uri);
			} else {
				log.warn(message);
			}
		}

	}

	private String getFullNodeURI(Node node) {
		String lname = node.getLocalName();
		String uri = node.getNamespaceURI();
		return (uri + "#" + lname);
	}

	class MyBuildContext implements BuildContext {

		private BPDocument _bpDocument;

		@Override
		public BPDocument getBPDocument() {
			return _bpDocument;
		}
	}

	interface BuildContext {

		BPDocument getBPDocument();
	}
}
