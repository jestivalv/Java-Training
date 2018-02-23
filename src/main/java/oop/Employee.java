package oop;
import java.time.LocalDate;


// La clase tendrá un método abtract lo que implica que la clase sea abstract y que no se pueda instanciar directamente
public abstract class Employee {
	private static final String DEFAULT_NAME = "UNKNOWN";
	// Variable de clase
	private static int nextId;
	
	// Este es el id que se matcheara con la bbdd
	private Integer id;
	private String name;
	private LocalDate  hireDate;
	
	//Constructor sin argumentos
	public Employee () {
		this(DEFAULT_NAME);
		
	}
	
	public Employee (String name) {
		id = nextId++;
		this.name = name;
		hireDate = LocalDate.now();
		
	}
	
	public Integer getId() {
		return id;
	}
	
	private void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
		
	}
	
	// no se implementa aqui
	public abstract double getPay();
	
	
	@Override
	public String toString() {
		return String.format("Employee{id=%d, name=%s, hireDate=%s}", id, name, hireDate);
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return hireDate != null ? hireDate.equals(employee.hireDate) : employee.hireDate == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        return result;
    }

}
