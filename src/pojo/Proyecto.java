package pojo;

public class Proyecto {
	
	private int id;
	private String nombre;
	private int fchInicio;
	private int fchFin;
	private int presupuesto;
	
	public Proyecto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	public int getFchInicio() {
		return fchInicio;
	}

	public void setFchInicio(int fchInicio) {
		this.fchInicio = fchInicio;
	}

	public int getFchFin() {
		return fchFin;
	}

	public void setFchFin(int fchFin) {
		this.fchFin = fchFin;
	}

	public Proyecto(int id, String nombre,int fchInicio, int fchFin, int presupuesto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.fchInicio = fchInicio;
		this.fchFin = fchFin;
	}

}
