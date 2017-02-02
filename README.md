# teste-java-involves

A arquitetura do software consiste em 3 artefatos:

1 ) involves-teste-persistence : Artefato responsável pela camada de persistência. (módulo) 

2 ) involves-teste-services : Artefato que contém os serviços com as regras de negócio. (módulo) 

3 ) involves-teste : Artefato que contém o executável, de onde partirão os comandos. 


O módulo involves-teste-services tem a dependência do módulo invoves-teste-persistence e o módulo involves-teste tem como dependência o módulo involves-teste-services.
O processo de build é gerenciado pelo maven, portanto os módulos devem ser buildados pelo maven na sequencia apresentada. Ao buildá-los 
os testes serão executados. Os testes utilizam o junit, o módulo persistence e services possui testes no diretório src/test/java.

O JDK utilizado foi o de versão 7. 
