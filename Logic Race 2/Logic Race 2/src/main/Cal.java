package main;

public class Cal {
	private int value1,value2,value3,value4;
	private int obj1,obj2, obj3,obj4;
	
	Cal(){	
	}
	
	public int max(int m,int n){
		
		if (m>n){
			return m;
		}
		return n;
	}
	
	public int max(int a,int b,int c){
		
		if(a>b && a>c){
			return a;
		}
		else if (b>a && b>c){
			return b;
		}
		else 
			return c;
		
	}
	
	public int max(int a,int b,int c,int d){
		if(a>b && a>c && a>d){
			return a;}
		else if(b>a && b>c && b>d){
			return b;}
		else if(c>a && c>b && c>d){
			return c;}
		else {
			return d;}
	}
	
	public void randomValue(){
		value1 = (int) (Math.random()*100);
		do{
			value2 = (int) (Math.random()*100);
		}while(value1==value2);
		do{
			value3 = (int) (Math.random()*100);
		}while(value1==value3 || value3==value2);
		do{
			value4 = (int) (Math.random()*100);
		}while(value4==value2 || value4==value3 || value4==value1);
	}
	
	public void randomPic(){
		obj1 = (int) (Math.random()*game.nItem);
		do{
			obj2 = (int) (Math.random()*game.nItem);
		}while(obj2==obj1);	
		do{
			obj3 = (int) (Math.random()*game.nItem);
		}while(obj3==obj1 || obj3==obj2);	
		do{
			obj4 = (int) (Math.random()*game.nItem);
		}while(obj4==obj1 || obj4==obj3 || obj4==obj2 );		
	}

	public int getValue1() {
		return value1;
	}

	public int getValue2() {
		return value2;
	}

	public int getValue3() {
		return value3;
	}

	public int getValue4() {
		return value4;
	}

	public int getObj1() {
		return obj1;
	}

	public int getObj2() {
		return obj2;
	}

	public int getObj3() {
		return obj3;
	}

	public int getObj4() {
		return obj4;
	}
}
