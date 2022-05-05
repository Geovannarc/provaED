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
					while(aux != null){
						if(novo.dado > aux.dado) {
							novo.esq = aux;
							novo.dir = aux.dir;
							aux.dir.esq = novo;
							aux.dir = novo;
							break;
						}
						aux = aux.dir;
					}
				}
			}
		}
	}
	
	// m�todo para imprimir os elementos da lista
	public void imprimir() {
		No aux = inicio;
		while(aux != null) {
			System.out.println(aux.dado);
			aux = aux.dir;
		}
	}
}
