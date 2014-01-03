package linkjvm.low.factory;

import linkjvm.low.accel.AccelX;
import linkjvm.low.accel.AccelY;
import linkjvm.low.accel.AccelZ;
import linkjvm.low.sensors.ShortSensor;


/**
 * 
 * @author Markus Klein
 *
 */
public class AccelerationFactory extends AbstractMultiton<AccelerationFactory.Axis, ShortSensor> {
	public static enum Axis{
		X,
		Y,
		Z
	}
	
	@Override
	protected ShortSensor getNewConcreteInstance(Axis uniqueIdentifier) {
		switch(uniqueIdentifier){
		case X:
			return new AccelX();
		case Y:
			return new AccelY();
		case Z:
			return new AccelZ();
		default:
			return null;
		}
	}
}
