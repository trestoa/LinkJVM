package linkjvm.low.factory;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public abstract class AbstractMultiton<U, I>{
	private HashMap<U, WeakReference<I>> instances;
	
	public AbstractMultiton(){
		instances = new HashMap<U, WeakReference<I>>();
	}
	
	public I getInstance(U uniqueIdentifier){
		WeakReference<I> weakReference = instances.get(uniqueIdentifier);
		if(weakReference == null){
			weakReference = new WeakReference<I>(getNewConcreteInstance());
			instances.put(uniqueIdentifier, weakReference);
		}
		return weakReference.get();
	}
	
	protected abstract I getNewConcreteInstance();
}
