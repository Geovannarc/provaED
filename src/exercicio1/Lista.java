package exercicio1;

public class Lista {
	No inicio, fim;
	
	// insere um n� no final da lista. Esse m�todo ser� chamado pelo m�todo inserir
	private void inserirFim(No aux) {
		if(inicio == null) {
			inicio = aux;
		} else {
			fim.prox = aux;
		}
		fim = aux;
	}
	
	//esse m�todo dever� ser implementado de acordo com o enunciado do exerc�cio
	private void inserirPrioridade(No aux) {

		//caso 1: lista vazia --> amarelo é inicio e fim
		if(inicio == null){
			inicio = aux;
			fim = aux;
		}else if(inicio.cor.equalsIgnoreCase("verde")){ //caso 2: só itens verdes --> amarelo fica em 1
			No aux2 = inicio;
			inicio = aux;
			aux.prox = aux2;
		}else if(fim.cor.equalsIgnoreCase("amarelo")) { //caso 3: último item é amarelo --> amarelo entra em último
			fim.prox = aux;
			fim = aux;
		}else{ //caso 4: amarelos e verdes --> inserir depois do ultimo amarelo
			No ultimoAmarelo = inicio;
				while(ultimoAmarelo.prox.cor.equalsIgnoreCase("amarelo")){
					ultimoAmarelo = ultimoAmarelo.prox;
				}
			No primeiroVerde = ultimoAmarelo.prox;
			ultimoAmarelo.prox = aux;
			aux.prox = primeiroVerde;
		}
	}
	
	// m�todo inserir. Esse m�todo ser� chamado a partir da classe Main
	public void inserir(int numero, String cor) {
		No aux = new No(numero, cor);
		if(cor.equalsIgnoreCase("verde")) {
			inserirFim(aux);
		} else {
			inserirPrioridade(aux);
		}
	}
	
	// m�todo utilizado para imprimir os dados da lista
	public void imprimir() {
		No aux = inicio;
		while(aux != null) {
			System.out.println(aux.numero);
			aux = aux.prox;
		}
	}
}
