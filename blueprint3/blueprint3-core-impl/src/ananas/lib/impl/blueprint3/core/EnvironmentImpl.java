package ananas.lib.impl.blueprint3.core;

import ananas.lib.blueprint3.core.dom.BPImplementation;
import ananas.lib.blueprint3.core.lang.BPDocumentLoaderFactory;
import ananas.lib.blueprint3.core.lang.BPEnvironment;
import ananas.lib.blueprint3.core.lang.BPNamespaceRegistrar;
import ananas.lib.blueprint3.core.lang.BlueprintException;
import ananas.lib.blueprint3.core.util.BPBuilderFactory;
import ananas.lib.blueprint3.core.util.BPVisitorFactory;
import ananas.lib.blueprint3.core.util.BPXMLReaderFactory;
import ananas.lib.blueprint3.core.util.nsloader.BPNamespaceInfo;
import ananas.lib.blueprint3.core.util.nsloader.BPNamespaceLoaderFactory;
import ananas.lib.blueprint3.core.xml.serializer.BPXmlSerializerFactory;
import ananas.lib.io.Connector;
import ananas.lib.io.impl.DefaultConnector;

public class EnvironmentImpl implements BPEnvironment {

	private final BPNamespaceRegistrar mNsReg;
	private final BPImplementation mImplementation;
	private final BPXMLReaderFactory mParserFactory;
	private BPXmlSerializerFactory mSerializerFactory;
	private final BPBuilderFactory mBuilderFactory;
	private BPVisitorFactory mVisitorFactory;
	private final Connector mConnector;
	private final BPDocumentLoaderFactory mDocLoaderFactory;
	private NsLoadingManager mNsLoadingManager;
	private final BPNamespaceLoaderFactory mNsLoaderFactory;

	public EnvironmentImpl() {
		this.mConnector = new DefaultConnector();
		this.mImplementation = new ImplementationImpl();
		this.mParserFactory = new ParserFactoryImpl();
		this.mBuilderFactory = new BuilderFactoryImpl();
		this.mNsReg = new NamespaceRegImpl();
		this.mDocLoaderFactory = new DocLoaderFactoryImpl();
		this.mNsLoaderFactory = new MainNsLoaderFactory();
	}

	@Override
	public BPNamespaceRegistrar getNamespaceRegistrar() {
		return this.mNsReg;
	}

	@Override
	public BPImplementation getImplementation() {
		return this.mImplementation;
	}

	@Override
	public BPXmlSerializerFactory getXmlSerializerFactory() {
		return this.mSerializerFactory;
	}

	@Override
	public BPBuilderFactory getBuilderFactory() {
		return this.mBuilderFactory;
	}

	@Override
	public BPVisitorFactory getVisitorFactory() {
		return this.mVisitorFactory;
	}

	@Override
	public Connector getConnector() {
		return this.mConnector;
	}

	@Override
	public BPXMLReaderFactory getXMLReaderFactory() {
		return this.mParserFactory;
	}

	@Override
	public BPDocumentLoaderFactory getDocumentLoaderFactory() {
		return this.mDocLoaderFactory;
	}

	@Override
	public void loadNamespace(String aClassName, boolean lazy)
			throws BlueprintException {
		try {
			Class<?> cls = Class.forName(aClassName);
			this.loadNamespace(cls, lazy);
		} catch (BlueprintException e) {
			throw e;
		} catch (Exception e) {
			throw new BlueprintException(e);
		}
	}

	@Override
	public void loadNamespace(Class<?> aClass, boolean lazy)
			throws BlueprintException {
		try {
			final BPNamespaceInfo info = (BPNamespaceInfo) aClass.newInstance();
			this.loadNamespace(info, lazy);
		} catch (BlueprintException e) {
			throw e;
		} catch (Exception e) {
			throw new BlueprintException(e);
		}
	}

	@Override
	public void loadNamespace(BPNamespaceInfo info, boolean lazy)
			throws BlueprintException {
		NsLoadingManager nslm = this.mNsLoadingManager;
		if (nslm == null) {
			nslm = new NsLoadingManager();
			this.mNsLoadingManager = nslm;
		}
		nslm.load(this, info, lazy);
	}

	@Override
	public BPNamespaceLoaderFactory getNamespaceLoaderFactory() {
		return this.mNsLoaderFactory;
	}

}
