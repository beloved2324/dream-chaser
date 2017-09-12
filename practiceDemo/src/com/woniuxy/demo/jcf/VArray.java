package com.woniuxy.demo.jcf;
/**
 * @author jing
 * @param <E>
 *
 */
public class VArray<T> {
	private Object[] elementData = null;
	private final Object[] DEFAULT_ELEMENTDATA={};
	
	private int size;
	/**
	 * 获取变长数组的元素个数
	 * @return	容器内的元素个数
	 */
	public int size(){
		return size;
	}
	
	public VArray() {
		elementData = DEFAULT_ELEMENTDATA;
	}
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Object get(int index){
		if(index<0||index>size){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return elementData[index-1];
	}
	public boolean remove(int index){
		if(index<0||index>size){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		for(int i = index-1;i<size;i++){
			if(i+1<size)
				elementData[i] = elementData[i+1];
		}
		size--;
		return true;
	}
	public boolean add(T element){
		validateLength(size+1);
		elementData[size++]=element;
		return true;
	}

	private void validateLength(int minSize) {
		if(minSize >= elementData.length)
			this.grow(minSize);
	}

	private void grow(int minSize) {
		int oldSize = elementData.length;
		int newSize = (int)(oldSize*1.5);
		
		if(newSize<=minSize){
			newSize = minSize;
		}
		elementData = this.copyData(elementData,newSize);
	}

	private Object[] copyData(Object[] oldData, int newSize) {
		Object[] newData = new Object[newSize];
		
		for(int i = 0;i<size;i++){
			newData[i] = oldData[i];
		}
		return newData;
	}
	public String toString(){
		StringBuffer buff = new StringBuffer("[");
		for(int i = 0;i<size;i++){
			buff.append(elementData[i]+",");
		}
		int i = buff.lastIndexOf(",");
		if(i!=-1)
			buff.replace(i, buff.length(), "");
		buff.append("]");
		return buff.toString();
	}
}
