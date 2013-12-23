package linkjvm.low.factory;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public abstract class AbstractMultiton<U, I>{
	private HashMap<U, WeakReference<I>> instances;
	
	/**
	 * 
	 */
	public AbstractMultiton(){
		instances = new HashMap<U, WeakReference<I>>();
	}
	
	/**
	 * 
	 * @param uniqueIdentifier
	 * @return
	 */
	public I getInstance(U uniqueIdentifier){
		WeakReference<I> weakReference = instances.get(uniqueIdentifier);
		if(weakReference == null){
			weakReference = new WeakReference<I>(getNewConcreteInstance(uniqueIdentifier));
			instances.put(uniqueIdentifier, weakReference);
		}
		return weakReference.get();
	}
	
	/**
	 * 
	 * @param uniqueIdentifier
	 * @return
	 */
	protected abstract I getNewConcreteInstance(U uniqueIdentifier);
}
