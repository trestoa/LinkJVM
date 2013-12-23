package linkjvm.low.factory;

/**
 * 
 * @author Markus Klein
 *
 * @param <I>
 */
public abstract class AbstractSingleton<I> {
	private I instance;
	
	/**
	 * 
	 * @return
	 */
	public I getInstance(){
		if(instance == null){
			instance = getConcreteInstance();
		}
		return instance;
	}
	
	/**
	 * 
	 * @return
	 */
	protected abstract I getConcreteInstance();
}
