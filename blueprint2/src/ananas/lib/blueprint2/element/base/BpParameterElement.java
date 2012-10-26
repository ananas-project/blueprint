package ananas.lib.blueprint2.element.base;

import ananas.lib.blueprint2.dom.IAttr;
import ananas.lib.blueprint2.dom.IElement;
import ananas.lib.blueprint2.dom.INode;
import ananas.lib.blueprint2.dom.IText;

public class BpParameterElement extends BaseElement {

	private INode m_value;
	private String m_attr_type;
	private String m_attr_object;

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if (name == null) {
			return false;

		} else if (name.equals("object")) {
			this.m_attr_object = attr.getValue();
			return true;

		} else if (name.equals("class")) {
			this.m_attr_type = attr.getValue();
			return true;
		} else if (name.equals("type")) {
			this.m_attr_type = attr.getValue();
			return true;

		} else {
			return super.setAttribute(attr);
		}
	}

	@Override
	public boolean onAppendChild(INode child) {
		this.m_value = child;
		return true;
	}

	public Class<?> getParameterClass() {
		return this._getParameterClass();
	}

	private Class<?> _getParameterClass() {

		try {
			String type = this.m_attr_type;
			if (type == null) {
				return String.class;
			}

			String classpath = type;
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

		return this._getParameterObject();

	}

	private Object _getParameterObject() {
		INode value = this.m_value;
		if (value == null) {
			return null;

		} else if (value instanceof IText) {
			return this._textToObject((IText) value);

		} else if (value instanceof IElement) {
			IElement element = (IElement) value;
			if ("element".equals(this.m_attr_object)) {
				return element;
			} else {
				return element.getTarget(true);
			}
		} else {
			return null;
		}
	}

	private Object _textToObject(IText value) {

		String str = value.getData();

		String type = this.m_attr_type;
		if (type == null) {
			// default

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
		return str;
	}

}
