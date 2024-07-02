import java.util.Arrays;

public class Person{
	
	private int id;
	private String name;
	private int age;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "day_1 [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	
//	public static void swap1(Person a, Person b) {
//		Person temp = a;
//		a = b;
//		b = temp;
//	}
	public static Person[] arrayPerson(Person [] person) {
		
		for(int i =0;i<person.length;i++) {
			for(int j=i+1;j<person.length;j++) {
				if(person[i].age > person[j].age) {
					Person temp=person[i];
					person[i]=person[j];
					person[j]=temp;
				}
			}
		}
		return person;
	}
	
	public static void main(String[] args) {
		
			Person person[]= new Person[5];
			
			person[0] = new Person(3,"Ani",34);
			person[1] = new Person(1,"Satya",24);
			person[2] = new Person(5,"Akash",23);
			person[3] = new Person(7,"Aniket",21);
			person[4] = new Person(2,"Anusha",19);
			
			System.out.println("Before sorting :"+ Arrays.toString(person));
			arrayPerson(person);
			System.out.println("after sorting :"+ Arrays.toString(person));	
	}
}
