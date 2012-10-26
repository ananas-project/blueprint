package ananas.lib.blueprint2.element.base;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import ananas.lib.blueprint2.dom.IAttr;
import ananas.lib.blueprint2.dom.IElement;
import ananas.lib.blueprint2.dom.INode;
import ananas.lib.blueprint2.dom.helper.IInvokeable;

public class BpInvokeElement extends BaseElement implements IInvokeable {

	private final List<BpParameterElement> mParamList;
	private String m_attr_method;// [method-name]
	private String m_attr_class;// [class-name|"null"|"default"]
	private String m_attr_object;// ["element"|"target"|"null"|"default"]

	public BpInvokeElement() {
		this.mParamList = new ArrayList<BpParameterElement>();
	}

	@Override
	public boolean setAttribute(IAttr attr) {
		String name = attr.getBlueprintClass().getLocalName();
		if (name == null) {
			return false;

		} else if (name.equals("object")) {
			this.m_attr_object = attr.getValue();
			return true;
		} else if (name.equals("class")) {
			this.m_attr_class = attr.getValue();
			return true;
		} else if (name.equals("type")) {
			this.m_attr_class = attr.getValue();
			return true;
		} else if (name.equals("method")) {
			this.m_attr_method = attr.getValue();
			return true;

		} else {
			return super.setAttribute(attr);
		}
	}

	@Override
	public boolean onAppendChild(INode child) {
		if (child instanceof BpParameterElement) {
			BpParameterElement param = (BpParameterElement) child;
			this.mParamList.add(param);
			return true;
		} else {
			return super.onAppendChild(child);
		}
	}

	@Override
	public Object play(IElement element) {
		try {
			String methodName = this._getMethodName();
			Class<?> aClass = this._getClass(element);
			Object obj = this._getObject(element);

			Class<?>[] argsClass = this._getArgsClass();
			Object[] argsObject = this._getArgsObject();

			Method method = this._getMethod(aClass, methodName, argsClass);
			return this._invoke(method, obj, argsObject);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Object _getObject(IElement parent) {
		String attr = this.m_attr_object;
		if (attr == null) {
			// default
		} else if (attr.equals("element")) {
			return parent;
		} else if (attr.equals("target")) {
			return parent.getTarget(true);
		} else if (attr.equals("null")) {
			return null;
		} else if (attr.equals("default")) {
			// default
		} else {
			// default
		}
		return parent.getTarget(true);
	}

	private Class<?> _getClass(IElement parent) {
		String attr = this.m_attr_class;
		if (attr == null) {
			// default
		} else if (attr.contains(".")) {
			try {
				return Class.forName(attr);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		// default
		Object obj = this._getObject(parent);
		return obj.getClass();
	}

	private String _getMethodName() {
		return this.m_attr_method;
	}

	private Object _invoke(Method method, Object obj, Object[] arg) {
		try {
			Object ret = null;
			int size = arg.length;
			switch (size) {
			case 0:
				ret = method.invoke(obj);
				break;
			case 1:
				ret = method.invoke(obj, arg[0]);
				break;
			case 2:
				ret = method.invoke(obj, arg[0], arg[1]);
				break;
			case 3:
				ret = method.invoke(obj, arg[0], arg[1], arg[2]);
				break;
			case 4:
				ret = method.invoke(obj, arg[0], arg[1], arg[2], arg[3]);
				break;
			default:
				throw new RuntimeException("parameter list too long.");
			}
			return ret;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private Method _getMethod(Class<?> targetClass, String methodName,
			Class<?>[] arg) {

		try {
			Method ret = null;
			int size = arg.length;
			switch (size) {
			case 0:
				ret = targetClass.getMethod(methodName);
				break;
			case 1:
				ret = targetClass.getMethod(methodName, arg[0]);
				break;
			case 2:
				ret = targetClass.getMethod(methodName, arg[0], arg[1]);
				break;
			case 3:
				ret = targetClass.getMethod(methodName, arg[0], arg[1], arg[2]);
				break;
			case 4:
				ret = targetClass.getMethod(methodName, arg[0], arg[1], arg[2],
						arg[3]);
				break;
			default:
				throw new RuntimeException("parameter list too long.");
			}
			return ret;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private Object[] _getArgsObject() {
		ArrayList<Object> v = new ArrayList<Object>();
		for (BpParameterElement param : this.mParamList) {
			Object obj = param.getParameterObject();
			v.add(obj);
		}
		return v.toArray(new Object[v.size()]);
	}

	private Class<?>[] _getArgsClass() {
		ArrayList<Class<?>> v = new ArrayList<Class<?>>();
		for (BpParameterElement param : this.mParamList) {
			Class<?> cls = param.getParameterClass();
			v.add(cls);
		}
		return v.toArray(new Class<?>[v.size()]);
	}

	@Override
	protected void onParentChanged(IElement oldParent, IElement newParent) {

		super.onParentChanged(oldParent, newParent);

		if (newParent != null) {
			this.play(newParent);
		}
	}

}
