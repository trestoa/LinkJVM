package linkjvm.low.factory;

import linkjvm.high.vision.CameraConfig;
import linkjvm.low.vision.Device;

public class CameraFactory extends AbstractMultiton<CameraConfig, Device>{

	@Override
	protected Device getNewConcreteInstance(CameraConfig uniqueIdentifier) {
		return new Device(uniqueIdentifier.getInputProvider());
	}

}
