package ananas.lib.blueprint2.element.base;

import ananas.lib.blueprint2.dom.IAttr;
import ananas.lib.blueprint2.dom.IElement;
import ananas.lib.blueprint2.dom.INode;
import ananas.lib.blueprint2.dom.IText;

public class BpParameterElement extends BaseElement {

	private IAttr m_attr_type;
	private INode m_value;

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if (name == null) {
			return false;
		} else if (name.equals("type")) {
			this.m_attr_type = attr;
			return true;
		} else {
			return super.setAttribute(attr);
		}
	}

	@Override
	public boolean appendChild(INode child) {
		this.m_value = child;
		return true;
	}

	public Class<?> getParameterClass() {

		try {
			IAttr attrType = this.m_attr_type;
			if (attrType == null) {
				return String.class;
			}

			String classpath = attrType.getValue();
			if (classpath.contains(".")) {
				return Class.forName(classpath);

			} else if (classpath.equals("int")) {
				return int.class;
			} else if (classpath.equals("long")) {
				return long.class;
			} else if (classpath.equals("short")) {
				return short.class;
			} else if (classpath.equals("byte")) {
				return byte.class;
			} else if (classpath.equals("char")) {
				return char.class;
			} else if (classpath.equals("double")) {
				return double.class;
			} else if (classpath.equals("float")) {
				return float.class;
			} else if (classpath.equals("boolean")) {
				return boolean.class;

			} else {
				return String.class;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public Object getParameterObject() {
		INode value = this.m_value;
		if (value == null) {
			return null;

		} else if (value instanceof IText) {
			return this._textToObject((IText) value);

		} else if (value instanceof IElement) {
			IElement element = (IElement) value;
			return element.getTarget(true);

		} else {
			return null;
		}
	}

	private Object _textToObject(IText value) {
		IAttr attrType = this.m_attr_type;
		String str = value.getData();
		if (attrType != null) {
			String type = attrType.getValue();
			if (type == null) {

			} else if (type.equals("int")) {
				return Integer.parseInt(str);

			} else if (type.equals("long")) {
				return Long.parseLong(str);

			} else if (type.equals("short")) {
				return Short.parseShort(str);

			} else if (type.equals("byte")) {
				return Byte.parseByte(str);

			} else if (type.equals("char")) {
				return ((char) str.indexOf(0));

			} else if (type.equals("double")) {
				return Double.parseDouble(str);

			} else if (type.equals("float")) {
				return Float.parseFloat(str);

			} else {
			}
		}
		return str;
	}

}
