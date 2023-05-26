## Produtor Consumidor


O problema do Produtor e Consumidor consiste em um desafio de sincronização de duas ou mais threads concorrêntes que tem
acesso a um mesmo recurso do programa que está sendo executado. O fato do recurso estar sendo compartilhado implica na
possibilidade de conflitos entre as threadas que disputam pelo controle da CPU para acesar o recurso.

O recurso disputado é um buffer de memória (um vetor) de tamanho fixo. O Produtor é responsável por enfileirar novos 
dados nesse buffer e o Consumidor assume a responsabilidade de extrair esses dados.

![Representação do Bounder Buffer](https://deinfo.uepg.br/~alunoso/2021/SO/producerconsumer_java/Producer&Consumer_files/bbp.png)

Algumas situações podem acontecer neste problema:
- E se o Produtor produzir muito rápido?
- E o Consumidor não for capaz de acompanhá-lo?

Para solucionar este problema, basta bloquearmos (wait) a execução do Produtor enquanto o buffer estiver cheio ou do Consumidor
quando a fila estiver vazia e ambas as threads deverão sinalizar (notify/notifyAll) o estado da fila para que o trabalho sejá
retomado, ou seja:

- o Consumidor precisa bloquear (wait) ao se deparar com uma fila vazia e aguardar um sinal do Produtor.
- O Produtor precisa bloquear (wait) ao se deparar com uma fila cheia e aguardar um sinal do Consumidor.

![Representação do envio de sinal](https://deinfo.uepg.br/~alunoso/2021/SO/producerconsumer_java/Producer&Consumer_files/SINAL.png)