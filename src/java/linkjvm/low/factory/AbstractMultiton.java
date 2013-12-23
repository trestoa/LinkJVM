package linkjvm.low.factory;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public abstract class AbstractMultiton<U, I>{
	private HashMap<U, WeakReference<I>> instances;
	private ReferenceQueue<I> referenceQueue;
	
	/**
	 * 
	 * @param rq
	 */
	public AbstractMultiton(ReferenceQueue<I> rq){
		instances = new HashMap<U, WeakReference<I>>();
		this.referenceQueue = rq;
	}
	
	/**
	 * 
	 * @param uniqueIdentifier
	 * @return
	 */
	public I getInstance(U uniqueIdentifier){
		WeakReference<I> weakReference = instances.get(uniqueIdentifier);
		if(weakReference == null){
			weakReference = new WeakReference<I>(getNewConcreteInstance(uniqueIdentifier), referenceQueue);
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
	
	/**
	 * 
	 * @param uniqueIdentifier
	 */
	protected void removeInstance(U uniqueIdentifier){
		instances.remove(uniqueIdentifier);
	}
}
