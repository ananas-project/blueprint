package ananas.lib.impl.blueprint.core;

import ananas.lib.blueprint.core.dom.BPImplementation;
import ananas.lib.blueprint.core.lang.BPDocumentLoaderFactory;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespaceRegistrar;
import ananas.lib.blueprint.core.util.BPBuilderFactory;
import ananas.lib.blueprint.core.util.BPVisitorFactory;
import ananas.lib.blueprint.core.util.BPXMLReaderFactory;
import ananas.lib.blueprint.core.xml.serializer.BPXmlSerializerFactory;
import ananas.lib.io.DefaultConnector;
import ananas.lib.io.IConnector;

public class EnvironmentImpl implements BPEnvironment {

	private final BPNamespaceRegistrar mNsReg;
	private final BPImplementation mImplementation;
	private final BPXMLReaderFactory mParserFactory;
	private BPXmlSerializerFactory mSerializerFactory;
	private final BPBuilderFactory mBuilderFactory;
	private BPVisitorFactory mVisitorFactory;
	private final IConnector mConnector;
	private  final BPDocumentLoaderFactory mDocLoaderFactory;

	public EnvironmentImpl() {
		this.mConnector = new DefaultConnector();
		this.mImplementation = new ImplementationImpl();
		this.mParserFactory = new ParserFactoryImpl();
		this.mBuilderFactory = new BuilderFactoryImpl();
		this.mNsReg = new NamespaceRegImpl();
		this.mDocLoaderFactory = new  DocLoaderFactoryImpl ()  ;
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
	public IConnector getConnector() {
		return this.mConnector;
	}

	@Override
	public BPXMLReaderFactory getXMLReaderFactory() {
		return this.mParserFactory;
	}

	@Override
	public BPDocumentLoaderFactory getDocumentLoaderFactory() {
		return this.mDocLoaderFactory ;
	}

}
