package ejercicio309.copy;

public class Student {

	/**
	 * MISMO C�DIGO QUE EN LA ACTIVIDAD ANTERIOR
	 */
	private String id;
	private String name;
	private String surname;
	private int age;

	public Student(String id, String name, String surname, int edad) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = edad;
	}

	public Student() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
