package com.woniuxy.demo.jcf;

public class SinglyLinkedList<T> {
	Node<T> firstNode;
	Node<T> lastNode;
	
	private int length;
	
	public static class Node<T>{
		public Node(T data) {
			this.data = data;
		}

		Node<T> next;
		
		T data;
		
 	}
	public boolean remove(T data){
		Node<T> node = firstNode;
		if(node!=null&&data.equals(node.data)){
			this.removeFirst();
			return true;
		}else{
			while(node.next!=null){
				if(node.next.data.equals(data)){
					node.next = node.next.next;
					length--;
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}
	private void removeFirst() {
		firstNode = firstNode.next;
		length--;
	}
	public T get(int index){
		if(index<=0 || index>length){
			throw new IndexOutOfBoundsException("你输入的下标超过了链表的长度："+index);
		}
		Node<T> node = firstNode;
		while(--index!=0){
			node=node.next;
		}
		return node.data;
	}
	public int length(){
		return length;
	}
	
	public boolean add(T data){
		if(firstNode==null){
			this.addFirst(data);
		}else{
			this.addLastNode(data);
		}
		length++;
		return true;
	}

	private void addLastNode(T data) {
		Node<T> node = new Node<T>(data);
		lastNode.next = node;
		lastNode = node;
	}

	private void addFirst(T data) {
		Node<T> node = new Node<T>(data);
		firstNode = node;
		lastNode = node;
	}

	@Override
	public String toString() {
		StringBuffer buff=  new StringBuffer("[");
		Node<T> node = firstNode;
		while(node!= null){
			buff.append(node.data+",");
			node = node.next;
		}
		int i = buff.lastIndexOf(",");
		if(i!=-1)
			buff.replace(i, buff.length(), "");
		buff.append("]");
		return buff.toString();
	}
	
	
	
}
