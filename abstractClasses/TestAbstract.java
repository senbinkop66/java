package abstractClasses;

public class TestAbstract{
	public static void main(String[] args) {
		Person[] people=new Person[2];

		people[0]=new Employee("bob",200000,2015,7,1);
		people[1]=new Student("mike","defender");

		for (Person p:people){
			System.out.println(p.getName()+", "+p.getDescription());
		}
	}
}