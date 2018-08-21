package dto;

public class Kakeibo {
	private int id;
	private int month;
	private int day;
	private int money;
	private String content;


	public Kakeibo(int id, int month, int day, int money, String content) {
		super();
		this.id = id;
		this.month = month;
		this.day = day;
		this.money = money;
		this.content = content;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getMonth() {
		return month;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		this.day = day;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}




}
