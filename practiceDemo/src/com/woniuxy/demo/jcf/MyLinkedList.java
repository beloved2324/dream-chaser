package com.woniuxy.demo.jcf;
/**
 * 
 * @author jing
 *
 * @param <T>
 */
public class MyLinkedList<T> {
	private Node<T> firstNode;
	private Node<T> lastNode;
	
	private int length;
	
	public static class Node<T>{
		public Node<T> prev;
		public T data;
		public Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
		public boolean equals(Object obj) {
			if(this==obj){
				return true;
			}
			if(obj instanceof Node){
				@SuppressWarnings("unchecked")
				Node<T> node = (Node<T>)obj;
				if(node.data.equals(this.data))
					return true;
			}
			return false;
		}
		public String toString(){
			return data.toString();
		}
	}
	
	
	/**
	 * 获取双向链表的元素个数
	 * @return 链表的长度
	 */
	public int length(){
		return length;
	}
	public T get(int index){
		if(index>length || index <= 0){
			throw new IndexOutOfBoundsException("您输入了越界的下标:	"+index);
		}
		Node<T> node = firstNode;
		while(--index!=0){
			node=node.next;
		}
		T d = node.data;
		return d;
	}
	public boolean add(T data){
		Node<T> node = new Node<T>(data);
		if(firstNode == null){
			this.addFirst(node);
		}else{
			this.addLast(node);
		}
		return true;
	}
	public boolean remove(T data){
		boolean flag = false;
		if(firstNode != null && data.equals(firstNode.data)){
			this.removeFirst();
			return true;
		}else{
			flag = this.removeByData(data);
			return flag;
		}
	}
	private boolean removeByData(T data) {
		Node<T> node = new Node<T>(data);
		Node<T> init = firstNode;
		boolean flag = false;
		while(init!=null){
			if(init.equals(node)){
				if(init.equals(lastNode)){
					flag = this.removeLast();
				}else{
					init.prev.next = init.next;
					init.next.prev = init.prev;
					init=null;
					length--;
					flag = true;
				}
				break;
			}
			init = init.next;
		}
		return flag;
	}
	private boolean removeLast() {
		lastNode.prev.next = null;
		lastNode = lastNode.prev;
		length--;
		return true;
	}
	private void removeFirst() {
		firstNode = firstNode.next;
		firstNode.prev = null;
		length--;
	}
//	private Node<T> findNode(T data) {
//		Node<T> node = firstNode;
//		while(node!=null){
//			if(node.data.equals(data)){
//				return node;
//			}
//			node = node.next;
//		}
//		
//		return node;
//	}
	private void addLast(Node<T> node) {
		lastNode.next = node;
		node.prev = lastNode;
		length++;
		lastNode = node;
	}
	private void addFirst(Node<T> node) {
		firstNode = node;
		lastNode = node;
		length++;
	}
	@Override
	public String toString() {
		Node<T> node = firstNode;
		StringBuffer buff = new StringBuffer("[");
		while(node!=null){
			buff.append(node.prev+":"+node.data+":"+node.next+",");
			node = node.next;
		}
		buff.replace(buff.length()-1, buff.length(), "]");
		return buff.toString();
	}
	
}
