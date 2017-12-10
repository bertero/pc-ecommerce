	package basic.model;

public class Computador extends Produto{
	private PlacaMae pm;
	private Memoria mem1 = null, mem2 = null, mem3 = null, mem4 = null;
	private DiscoRigido hd1 = null, hd2 = null;
	private Processador proc;
	
	public Computador(int id) {
		super();
		this.setId(id);
	}

	public Computador() {}
	
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
		if (this.mem1 == null) this.mem1 = mem;
		else if (this.mem2 == null && this.pm.getSlots() > 1) this.mem2 = mem;
		else if (this.mem3 == null && this.pm.getSlots() > 2) this.mem3 = mem;
		else if (this.mem4 == null && this.pm.getSlots() > 3) this.mem4 = mem;
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
		if (this.hd1 == null) this.hd1 = hd;
		else if (this.hd2 == null) this.hd2 = hd;
	}

	public DiscoRigido getHd2() {
		return hd2;
	}
	
	public double calculaPreco() {		
		final double precoMontagem = 300;
		double preco = 0;
		if (this.pm != null) preco += this.pm.getPreco();
		if (this.proc != null) preco += this.proc.getPreco();
		if (this.mem1 != null) {
			preco += this.mem1.getPreco();
			if (this.mem2 != null) {
				preco += this.mem2.getPreco();
				if (this.mem3 != null) {
					preco += this.mem3.getPreco();
					if (this.mem4 != null) preco += this.mem4.getPreco();
				}
			}
		}
		if (this.hd1 != null) {
			preco += this.hd1.getPreco();
			if (this.hd2 != null) preco += this.hd2.getPreco();
		}
		return preco + precoMontagem;
	}
}
