# Desafio Trilha Core
## Sitema de Geração de Relatório
### Informações básicas para funcionamento:
Este sistema realiza a leitura de arquivos _.dat_ e gera relatórios a partir das informações contidas no arquivo;

Para a utilização do sistema é necessário que exista no diretório _/home/[username]_ as seguintes pastas para a entrada e saída de dados: _/data/in_ e _/data/out_
 
**ou**

edite o arquivo   _/src/main/resources/config.properties_ para que as pastas de entrada e saída fiquem setadas corretamente.

### Sobre o funcionamento
Este sistema funciona basicamente em duas etapas.
1. Realiza a leitura de todos os arquivos _.dat_ da pasta de entrada; Ao ler cada linha do arquivo, cria seus respectivos objetos; Com todos os objetos do arquivo montados, é gerado os relatórios, que são escritos na pasta de saída; 
2. Monitora a criação ou a atualização de qualquer arquivo _.dat_ na pasta de entrada; Quando acontece uma das duas operações o arquivo é lido do mesmo modo que acima.