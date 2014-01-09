package linkjvm.low.factory;

import linkjvm.low.camera.Device;
import linkjvm.low.camera.InputProvider;

public class CameraFactory extends AbstractMultiton<InputProvider, Device>{

	@Override
	protected Device getNewConcreteInstance(InputProvider uniqueIdentifier) {
		return new Device(uniqueIdentifier);
	}

}
