# teste-java-involves

O sistema consite em 3 artefatos:

involves-teste-persistence : Artefato responsável pela camada de persistência. (módulo)
involves-teste-services : Artefato que contém os serviços com as regras de negócio. (módulo)
involves-teste : Artefato que contém o executável, de onde partirão os comandos. 

O processo de build é gerenciado pelo maven, portanto os módulos devem ser buildados pelo maven na sequencia apresentada. Ao buildá-los 
os testes serão executados. Os testes utilizam o junit, o módulo persistence e services possui testes no diretório src/test/java.

O JDK utilizado foi o de versão 7. 