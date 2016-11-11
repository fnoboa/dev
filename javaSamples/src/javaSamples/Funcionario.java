package javaSamples;

public class Funcionario {
	
	private String nome;
    private String departamento;
    private double salario;
    private Data dataEntrada;
    private String rg;
    private int identificador;
    private static int proximoFuncionario = 0;
    
    
    public Funcionario() {
    	
    }
    
    public Funcionario(String nome ) {
    	this.nome = nome;
    	this.identificador = ++proximoFuncionario;
    }
    
    public int getIdentificador() {
    	return this.identificador;
    }
        
    public double getGanhoAnual() {
    	return this.salario * 12;
    }
    
    public String getNome() {
    	return this.nome;    	
    }
    
    public void setNome (String nome) {
    	this.nome = nome;
    }
    
    public String getDepartamento() {
    	return this.departamento;
    }
    
    public void setDepartamento (String departamento) {
    	this.departamento = departamento;
    }
    
    public double getSalario() {
    	return this.salario;
    }
	
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public Data getDataEntrada() {
        return this.dataEntrada;
    }

    public void setDataEntrada (Data dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getRg() {
        return this.rg;
    }
    
    
}

class Data {
	
	int dia;
	int mes; 
	int ano;
	
	public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        if (! isDataViavel(dia, mes, ano)) {
            System.out.println("A data não existe!");
        }
    }
	
	private boolean isDataViavel(int dia, int mes, int ano) {
        if (dia <= 0 || mes <= 0 || mes > 12 || ano <= 0) {
            return false;
        }

        int ultimoDiaDoMes = 31; // por padrao são 31 dias
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11 ) {
            ultimoDiaDoMes = 30;
        } else if (mes == 2) {
            ultimoDiaDoMes = 28;
            if((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))){
                ultimoDiaDoMes = 29;
            }
        }
        if (dia > ultimoDiaDoMes) {
            return false;
        }

        return true;
    }
	
}

class Empresa {
	
	String nomeEmpresa;
	String cnpj;
	Funcionario[] empregados;
	int livre = 0;
	int tamanho = 0;
	
	public Empresa (int tamanho ) {
    	this.tamanho = tamanho;
    }
	
	public Funcionario getFuncionario (int posicao) {
		return this.empregados[posicao];
		
	}
	void adiciona(Funcionario f) {
        this.empregados[this.livre] = f;
        this.livre++;
    }
	
	void mostraEmpregados() {
        for (int i = 0; i < this.livre; i++) {
            System.out.println("Funcionário na posição: " + i);
            System.out.println("R$" + this.empregados[i].getSalario());
        }
    }

	void mostraTodasAsInformacoes() {
				
		for (int i = 0; i < this.livre; i++) {
            System.out.println("Funcionário na posição: " + i);
            //this.empregados[i].mostra();            
        }		
	}
	
	boolean contem(Funcionario f) {
		for (int i = 0; i < this.livre; i++) {
            
			if (f == this.empregados[i]) {
				return true;
			}
						            
        }	
		
		return false;
    }
			
}

class TestaEmpresa {
	
	public static void main(String[] args) {
		
		Empresa empresa = new Empresa(10);
        empresa.empregados = new Funcionario[10];

        Funcionario f1 = new Funcionario();
        Data d = new Data(31, 8, 2016);
        f1.setSalario(1000);
        f1.setDataEntrada(d);
        empresa.adiciona(f1);

        Funcionario f2 = new Funcionario();
        f1.setSalario(1700);
        f2.setDataEntrada(d);        
        empresa.adiciona(f2);

        //empresa.empregados[0].mostra();
        //empresa.empregados[1].mostra();
        
        empresa.mostraEmpregados();
        
        empresa.mostraTodasAsInformacoes();
        
		
	}
	
}

