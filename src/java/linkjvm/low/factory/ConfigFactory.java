package linkjvm.low.factory;

import linkjvm.low.vision.Config;
import linkjvm.low.vision.ConfigPath;

public class ConfigFactory extends AbstractMultiton<String, Config> {

	@Override
	protected Config getNewConcreteInstance(String uniqueIdentifier) {
		return Config.load(ConfigPath.path(uniqueIdentifier));
	}

}
