package java8Lambda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleTest {

	public static void main(String[] args) {
		
		
		
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> results = new ArrayList<>();
		for (T t : results) {
			if (p.test(t)) {
				results.add(t);
			}
		}
		return results;
	}
	
	public static void testAppleLambda(){
		List<Apple> inventory = new ArrayList<>();
		inventory=creatApples();
		List<Apple> greenApples = filterGreenApple(inventory, "green");
		System.out.println(greenApples);
		/**
		 * lambda表达式 （参数）-> 主体
		 * ()->{} 表示无参数  无返回值  ()-> 语句;
		 * ()-> "String" 无参数 返回值无string类型
		 * ()-> {return "String";} 无参数  返回值为string类型   显示声明返回值
		 * 这样就可以不用去创建多个ApplePredicate的实现类  只需要在使用通过lambda表达式 
		 *    个人认为：就是不用去多实现，而是在调用的时候去自己实现。 lambda表达式实现了一个方法相当于传入的是一个实现类。
		 */
		List<Apple> redApples = filterApple(inventory, (Apple apple)-> "red".equals(apple.getColor()));
		List<Apple> redApples1 = filterApple(inventory, (Apple apple)-> {return "red".equals(apple.getColor()); });
		System.out.println(redApples);
		System.out.println(redApples1);
		List<Apple> weight1 = filterApple(inventory, (Apple apple)-> apple.getWeiht()>150);
		System.out.println(weight1);
		/*ApplePredicate applePredicate = new ApplePredicate() {
			@Override
			public boolean condition(Apple apple) {
				System.out.println("apple");
				return true;
			}
		};*/
		ApplePredicate applePredicate = (Apple apple) -> {System.out.println("apple"); return true;} ;
		/**
		 * (Apple apple) -> {System.out.println("apple"); return true;} ;相当于：
			new ApplePredicate() {
				@Override
				public boolean condition(Apple apple) {
					System.out.println("apple");
					return true;
				}
			};
		*/
		applePredicate.condition(new Apple());
		
	}
	
	public static List<Apple> creatApples(){
		List<Apple> inventory = new ArrayList<>();
		Apple apple = new Apple("green",150);
		Apple apple1 = new Apple("green",151);
		Apple apple2 = new Apple("red",151);
		Apple apple3 = new Apple("red",150);
		inventory.add(apple);
		inventory.add(apple1);
		inventory.add(apple2);
		inventory.add(apple3);
		return inventory;
	}
	
	
	public static List<Apple> filterGreenApple(List<Apple> inventory,String color){
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (color.equals(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	public static List<Apple> filterWeigheApple(List<Apple> inventory,int weight){
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (apple.getWeiht()>weight) {
				result.add(apple);
			}
		}
		return result;
	}
	/**
	 * 行为参数化 使用lambda表达式
	 * 
	 * @param inventory
	 * @param applePredicate
	 * @return
	 */
	public static List<Apple> filterApple(List<Apple> inventory,ApplePredicate applePredicate){
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (applePredicate.condition(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	
	public static void testFilePath(){
		/*try {
		String string = processFile();
		System.out.println(string);
	} catch (IOException e) {
		e.printStackTrace();
	}
	File directory = new File("");//设定为当前文件夹 
	
	    try {
			System.out.println(directory.getCanonicalPath());//获取标准的路径 
			System.out.println(directory.getAbsolutePath());//获取绝对路径 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    */
	 /*   /javaseTest/src/java8Lambda/Apple.java   */
	//File.getCanonicalPath()和File.getAbsolutePath()大约只是对于new File(".")和new File("..")两种路径有所区别。 
	
	}
	
	public static String processFile() throws IOException{
		//System.out.println(System.getProperty("Apple.java"));
		try (BufferedReader br = new BufferedReader(new FileReader("src//java8Lambda//Apple.java"))){
			
			return br.readLine();
		} 
		
	}
	
	

}
