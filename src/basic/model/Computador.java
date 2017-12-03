	package basic.model;

public class Computador extends Produto{
	private PlacaMae pm;
	private Memoria mem1 = null, mem2 = null, mem3 = null, mem4 = null;
	private DiscoRigido hd1 = null, hd2 = null;
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

	public void setMem(Memoria mem) {
		if (this.mem1 != null) this.mem1 = mem;
		else if (this.mem2 != null) this.mem2 = mem;
		else if (this.mem3 != null) this.mem3 = mem;
		else if (this.mem4 != null) this.mem4 = mem;
	}
	
	public Memoria getMem2() {
		return mem2;
	}

	public Memoria getMem3() {
		return mem3;
	}

	public Memoria getMem4() {
		return mem4;
	}
	
	public Processador getProc() {
		return proc;
	}

	public void setProc(Processador proc) {
		this.proc = proc;
	}

	public DiscoRigido getHd1() {
		return hd1;
	}

	public void setHd(DiscoRigido hd) {
		if (this.hd1 != null) this.hd1 = hd;
		else if (this.hd2 != null) this.hd2 = hd;
	}

	public DiscoRigido getHd2() {
		return hd2;
	}
}
