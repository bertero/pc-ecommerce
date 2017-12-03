	package basic.model;

public class Computador extends Produto{
	private PlacaMae pm;
	private Memoria mem1, mem2;
	private Processador proc;
	
	public Computador() {
		super();
	}

	public PlacaMae getPm() {
		return pm;
	}

	public void setPm(PlacaMae pm) {
		this.pm = pm;
	}

	public Memoria getMem1() {
		return mem1;
	}

	public void setMem1(Memoria mem) {
		this.mem1 = mem;
	}
	
	public Memoria getMem2() {
		return mem2;
	}

	public void setMem2(Memoria mem) {
		this.mem2 = mem;
	}

	public Processador getProc() {
		return proc;
	}

	public void setProc(Processador proc) {
		this.proc = proc;
	}
}
