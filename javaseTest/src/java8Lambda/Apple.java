package java8Lambda;

public class Apple {

	private String color;
	private int weight;
	public Apple() {
	}
	Apple(int weight){
		this.weight = weight;
	}
	public Apple(String color,int weight) {
		this.color = color;
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeiht() {
		return weight;
	}
	public void setWeiht(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}
	
	
}
