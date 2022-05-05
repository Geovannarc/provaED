package exercicio4;

public class Lista {
	No inicio;
	No fim;
	
	// m�todo para inserir um elemento na lista.
	// a inser��o deve manter a lista ordenada (ordem crescente)
	public void inserir(int dado) {
		if(inicio == null){ //1 caso: lista vazia --> dado é inicio e fim
			No novo = new No(dado);
			inicio = novo;
			fim = novo;
		}else{
			No novo = new No(dado);
			No aux = inicio;

			if(novo.dado < inicio.dado){ //2 caso: dado menor que inicio --> dado é inicio
				novo.dir = inicio;
				inicio.esq = novo;
				inicio = novo;
			}else {
				if(novo.dado >= fim.dado){
					fim.dir = novo;
					novo.esq = fim;
					fim = novo;
				}else{
					do {
						if(novo.dado > aux.dado && novo.dado < aux.dir.dado) {
							aux.esq = aux;
							aux.dir.esq = aux;
							aux.dir = aux;
							break;
						}
						aux = aux.dir;
					} while(aux != null);
				}
			}
		}
	}
	
	// m�todo para imprimir os elementos da lista
	public void imprimir() {
		No aux2 = inicio;
		while(aux2 != null) {
			System.out.println(aux2.dado);
			aux2 = aux2.dir;
		}
	}
}
