package ananas.lib.impl.blueprint.core;

import ananas.lib.blueprint.core.dom.BPImplementation;
import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.core.lang.BPNamespaceRegistrar;
import ananas.lib.blueprint.core.util.BPBuilderFactory;
import ananas.lib.blueprint.core.util.BPVisitorFactory;
import ananas.lib.blueprint.core.xml.parser.BPXmlParserFactory;
import ananas.lib.blueprint.core.xml.serializer.BPXmlSerializerFactory;
import ananas.lib.io.DefaultConnector;
import ananas.lib.io.IConnector;

public class EnvironmentImpl implements BPEnvironment {

	private BPNamespaceRegistrar mNsReg;
	private final BPImplementation mImplementation;
	private final BPXmlParserFactory mParserFactory;
	private BPXmlSerializerFactory mSerializerFactory;
	private final BPBuilderFactory mBuilderFactory;
	private BPVisitorFactory mVisitorFactory;
	private final IConnector mConnector;

	public EnvironmentImpl() {
		this.mConnector = new DefaultConnector();
		this.mImplementation = new ImplementationImpl();
		this.mParserFactory = new ParserFactoryImpl();
		this.mBuilderFactory = new BuilderFactoryImpl();
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
	public BPXmlParserFactory getXmlParserFactory() {
		return this.mParserFactory;
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

}
