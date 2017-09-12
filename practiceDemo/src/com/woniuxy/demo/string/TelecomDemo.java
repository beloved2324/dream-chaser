package com.woniuxy.demo.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TelecomDemo {
	/*2.电信面试题：

		[2016][9][8][10][55][3]{1}[2016][9][8][10][58][57]
		[2016][9][8][11][17][26]{0}[2016][9][8][11][19][55]
		[2016][9][8][11][45][32]{1}[2016][9][8][11][58][19]
		{1}表示主叫
		{0}表示被叫
		主叫计费，被叫不计费但要统计时长
		计算每次通话时长，主叫费用，被叫通话时长
		不足一分钟但超过30秒，按一分钟计费（尽量做到每15秒计费一次，如果是每15秒计费，那么计费为0.06元）
		每分钟0.24元
		思路：
		1. 判断某一个字符串是否有{1}或者{0}，如果有{1}则为主叫，需要计算费用和时长
		2. 利用subString将{x}前后截断为两个字符串，分别表示开始和结束
		3. 利用StringTokenizer将字符串的[]过滤
		4. 在过滤的同时，将字符串转型为int
		5. 每次过滤后将得到的值放入容器
		6. 循环容器 减呗*/
	
	public static void main(String[] args) {
		TelecomDemo tele = new TelecomDemo();
		String s = "[2016][9][8][10][55][3]{1}[2016][9][8][10][58][57]";
		String s1 = "[2016][9][8][11][17][26]{0}[2016][9][8][11][19][55]";
		String s2 = "[2016][9][8][11][45][32]{1}[2016][9][8][11][58][19]";
		tele.calculate(s);
		tele.calculate(s1);
		tele.calculate(s2);
	}
	/**
	 * 
	 * @param s	需要处理的字符串
	 */
	private void calculate(String s) {
		String mode = this.getMode(s);
		int time = this.getTimeInSeconds(s);
		if(mode.equals("{1}")){
			//主叫
			System.out.println("主叫，通话时长："+time+"秒，消费"+this.getAccount(time)+"元");
		}else{
			//被叫
			System.out.println("被叫，通话时长"+time+"秒");
		}
	}
	/**
	 * 
	 * @param time 时间差
	 * @return 付费金额
	 */
	private double getAccount(int time) {
		double money;
		if(time%15 == 0){
			money = time/15 *0.06;
		}else{
			money = time/15 *0.06 +0.06;
		}
		return money;
	}

	/**
	 * 计算时间差
	 * @param s 时间字符串
	 * @return 时间差
	 */
	private int getTimeInSeconds(String s) {
		Calendar start = this.getStartTime(s);
		Calendar end = this.getEndTime(s);
		int time = (int) (end.getTimeInMillis()-start.getTimeInMillis())/1000;
		return time;
	}
	/**
	 * 获取结束时间所对应的日历
	 * @param s	结束时间所对应的字符串
	 * @return	结束时间所对应的日历
	 */
	private Calendar getEndTime(String s) {
		Calendar end = this.getCalendar(s.substring(s.indexOf("}")+1));
		return end;
	}
	/**
	 * 获取开始时间所对应的日历
	 * @param s	开始时间所对应的字符串
	 * @return	开始时间所对应的日历
	 */
	private Calendar getStartTime(String s) {
		Calendar start = this.getCalendar(s.substring(0, s.indexOf("{")));
		return start;
	}
	/**
	 * 格式化时间字符串获取日历
	 * @param str 时间字符串
	 * @return	日历
	 */
	private Calendar getCalendar(String str) {
		SimpleDateFormat format = new SimpleDateFormat("[yyyy][MM][dd][HH][mm][ss]");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		return c;
	}
	/**
	 * 获取模式（主叫还是被叫）
	 * @param s 时间字符串
	 * @return	判断主被叫的字符串
	 */
	private String getMode(String s) {//��ȡ������
		String mode = s.substring(s.indexOf("{"),s.indexOf("}")+1);
		return mode;
	}
}
