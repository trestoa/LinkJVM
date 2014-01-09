package linkjvm.low.factory;

import linkjvm.low.vision.Device;
import linkjvm.low.vision.InputProvider;

public class CameraFactory extends AbstractMultiton<InputProvider, Device>{

	@Override
	protected Device getNewConcreteInstance(InputProvider uniqueIdentifier) {
		return new Device(uniqueIdentifier);
	}

}
