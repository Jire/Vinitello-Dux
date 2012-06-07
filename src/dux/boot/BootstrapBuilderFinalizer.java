package dux.boot;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class BootstrapBuilderFinalizer {

	private final Module[] modules;

	protected BootstrapBuilderFinalizer(Module[] modules) {
		this.modules = modules;
	}

	protected Module[] getModules() {
		return modules.clone();
	}

	public Bootstrap build() {
		Injector injector = Guice.createInjector(getModules());
		return injector.getInstance(Bootstrap.class);
	}

}