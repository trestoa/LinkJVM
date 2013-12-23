package linkjvm.low.factory;

import java.lang.ref.ReferenceQueue;

import linkjvm.low.accel.AccelX;
import linkjvm.low.accel.AccelY;
import linkjvm.low.accel.AccelZ;
import linkjvm.low.sensors.ShortSensor;

enum Axis{
	X,
	Y,
	Z
}

/**
 * 
 * @author Markus Klein
 *
 */
public class AccelerationFactory extends AbstractMultiton<Axis, ShortSensor> {
	
	
	public AccelerationFactory(ReferenceQueue<ShortSensor> rq) {
		super(rq);
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
