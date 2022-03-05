package oo.heranca.loja;

class RodarAplicacao {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		
		// Upcasts (impl�citos, n�o se perdem dados, pois os dados presentes na classe filha estar�o na classe m�e)
		Funcionario gerente = new Gerente();
		Funcionario vendedor = new Vendedor();
		Funcionario faxineiro = new Faxineiro();
		
		// Downcasts (expl�citos, poder� haver perda de dados, logo, dar� um erro)
		//Downcast deve ser evitado em OO, apesar de ser um conceito v�lido
		//Gerente gerente = new Funcionario(); // n�o pode converter de funcion�rio para gerente
		Vendedor vendedor_ = (Vendedor) new Funcionario();
		
	}
}
