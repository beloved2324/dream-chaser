package com.woniuxy.demo.string;

public class JiuYuanYinHaiDemo {
	/*�����Ƽ���������ᱣ����Ŀ�Ŀ�����ά�����ӽ���������һֱΪ�ɶ�����ᱣ�վ��з����ڲ���Ҫϵͳ!
	Ч��1��
	����
	����
	�Ƽ�
	����
	���� ��������������
	Ч��2��
	��
	����
	�Ƽ���
	�������
	������Ŀ��
	������ά����
	�ӽ���������һ
	ֱΪ�ɶ�����ᱣ
	�վ��з����ڲ���Ҫϵͳ!*/

	public static void main(String[] args) {
		String s = "银海科技致力于社会保险项目的开发和维护，从建立以来，一直为成都市社会保险局研发其内部主要系统!"
				+ "银海科技致力于社会保险项目的开发和维护，从建立以来，一直为成都市社会保险局研发其内部主要系统!";
		mode1(s);
		System.out.println("Mode2------------------");
		mode2(s);
	}
	public static void mode1(String s){
		for(int i = 0;i<s.length()-1;i++){
			System.out.println(s.substring(i, i+2));
		}
	}
	public static void mode2(String s){
		for(int i =1;i<=s.length();i++){
			System.out.print(s.substring(0, i));
			s = s.substring(i);
			if(s.length()<i){//���ʣ���s�ĳ��Ȳ�������ô��s��ӡ�ں�
				System.out.println(s);
			}else{//�����������
				System.out.println();
			}
		}
	}
}
