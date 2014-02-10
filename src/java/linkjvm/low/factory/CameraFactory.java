package linkjvm.low.factory;

import linkjvm.low.vision.Device;
import linkjvm.vision.CameraConfig;

public class CameraFactory extends AbstractMultiton<CameraConfig, Device>{

	@Override
	protected Device getNewConcreteInstance(CameraConfig uniqueIdentifier) {
		Device ret = new Device(uniqueIdentifier.getInputProvider());
		ret.setWidth(uniqueIdentifier.getResolution().width);
		ret.setHeight(uniqueIdentifier.getResolution().height);
		return ret;
	}

}
