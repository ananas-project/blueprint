package ananas.lib.blueprint.schema.impl;

import java.io.IOException;

import org.xml.sax.SAXException;

import ananas.lib.blueprint.core.lang.BPEnvironment;
import ananas.lib.blueprint.schema.SchemaException;
import ananas.lib.blueprint.schema.SchemaInfo;
import ananas.lib.blueprint.schema.SchemaLoader;
import ananas.lib.blueprint.schema.preload.PreLoaderUtil;

public class SchemaLoaderImpl implements SchemaLoader {

	@Override
	public void load(BPEnvironment envi, String infoClass)
			throws SchemaException {

		try {
			SchemaInfo info = (SchemaInfo) Class.forName(infoClass)
					.newInstance();
			this._doLoad(envi, info);
		} catch (Exception e) {
			throw new SchemaException(e);
		}
	}

	@Override
	public void load(BPEnvironment envi, Class<?> infoClass)
			throws SchemaException {

		try {
			SchemaInfo info = (SchemaInfo) infoClass.newInstance();
			this._doLoad(envi, info);
		} catch (Exception e) {
			throw new SchemaException(e);
		}
	}

	@Override
	public void load(BPEnvironment envi, SchemaInfo info)
			throws SchemaException, SAXException, IOException {

		this._doLoad(envi, info);
	}

	private void _doLoad(BPEnvironment envi, SchemaInfo info)
			throws SAXException, IOException {

		if (PreLoaderUtil.isNeedForPreLoading(envi)) {
			PreLoaderUtil.doPreload(envi);
		}

		FinalSchemaLoader ldr = new FinalSchemaLoader(envi, info);
		ldr.load();

	}

}
