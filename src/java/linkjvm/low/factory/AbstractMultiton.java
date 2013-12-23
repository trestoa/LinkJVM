package linkjvm.low.factory;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

public abstract class AbstractMultiton<U, I>{
	private HashMap<U, WeakReference<I>> instances;
	private ReferenceQueue<I> referenceQueue;
	
	/**
	 * 
	 */
	public AbstractMultiton(){
		instances = new HashMap<U, WeakReference<I>>();
		referenceQueue = new ReferenceQueue<I>();
	}
	
	/**
	 * 
	 * @param uniqueIdentifier
	 * @return
	 */
	public synchronized final I getInstance(U uniqueIdentifier){
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
	 */
	protected synchronized final void cleanup(){
		Reference<I> referenceToDeletedObject = (Reference<I>) referenceQueue.poll();
		if(referenceToDeletedObject != null){
			LinkedList<WeakReference<I>> list = (LinkedList<WeakReference<I>>) instances.values();
			list.remove(referenceToDeletedObject.get());
		}		
	}
}
