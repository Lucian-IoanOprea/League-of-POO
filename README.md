# League-of-POO
Java Implementation of a MMO style game
Structuras si logica implementarii:
  Pachetul players ce contine clasa abstracta din care se mostenesc toate ti-
  pologiile din enunt si ca pattern acesta contine factoryul de jucatori:

	- clasa Players este abstracta si retine toate campurile importante ale
	  unui caracter ( hp, pozitie, nivel, experienta, damage overtime etc.)
	  ,dar si metodele de calcul pentru primirea de damage, verificarea daca
	  un erou este in viata sau metoda pentru deplasarea unui erou pe mapa.

	- clasa PlayersFactory reprezinta factory-ul de jucatori pentru care
	  metoda statica getPlayer primeste ca parametru tipul jucatorului spe-
	  cificat cu prima litera din nume si pozitia acestuia.
	
	- cele 4 clase ce extind clasa abstracta au in componenta un constructor
	  ce initializeaza campurile in functie de rasa eroului( ex: Knight are
	  hp si maxhp initial 900).In aceste clase avem metoda accept ce este
	  specifica visitor pattern prin care fiecare va putea sa interactioneze
          cu atacurile provenite de la adeversar.

 Pachetul main contine intrarea Main in program , parsarea inputului , harta jo-
 cului si clasa GameLogic in care se desfasoara rundele:
	
	- clasa GameMap este un singleton ce retine harta sub forma de matrice
	  si pentru un anumit set de coordonate intoarce tipul terenului( ex:
	  'W' de la wood).
	
	- cele 2 clase GameInput si GameInputLoader citesc inputul din fisierul
	  de intrare si formeaza setul de date de intrare prin intermediul unor
	  colectii ( ex: un Arraylist pentru numele playerilor sau pentru pere-
          chile de coordonate. Datele construite in cele 2 clase sunt trimise
          clasei GameLogic in care are loc jocul.

	- clasa GameLogic implementeaza functionalitatea jocului in care se 
          se parcurge numarul de runde , se executa miscarile fiecarui jucator,
 	  se scade damge-ul overtime(daca exista) si apoi se parcurge lista de 
	  jucatori. Cei aflati pe coordonate identince se lupta prin intermediul
	  double dispatch-ului ce ilustreaza interactiunea dintre erou si abili-
	  tatile jucatorului ce il ataca.

	- clasa Pair ce este o clasa generica ce retine coordonatele pe harta.

	- clasa Main unde are loc instantierea obiectelor pentru input, instanta
	  pentru desfasurarea jocului ,dar si unde se face afisarea.

 Pachetul abilities contine interfata de vizitator si vizitatorii reprezentati
 prin setul de 2 puteri ale fiecarui jucator:

	- interfata Ability ce implementeaza celelalte tipuri de vizitatori ce
	  vor suprascrie cele 4 metode de visit in functie de tipologia celui
	  atacat
	
	- cele 4 clase ce implementeaza interfata de mai sus avand in vedere
	  eroul atacat utilizand modificatorii de teren si rasa din clasele
  	  definite pentru constanta.

 Pachetul constants contine pentru fiecare rasa in parte modificatorii de rasa
 si teren.

 
Pe langa caracteristicile de la prima etapa am implementat in plus :

  - clasa Angels ce extinde celelalte tipuri de ingeri construiti prin 
    intermediul unui factory.

  - interfata Strategy ce implementeaza cele trei modalitati ( attack, defensive
    si basic ) care se aleg dinamic cu metoda chooseStrategy aferenta fiecarui 
    tip de erou.

  - visitor patternul ce ilustreaza vizitarea ingerului a fiecarui jucator aflat		 
    pe pozitia din input.( prin metodele visit sunt descrise actiunile fiecarui
    erou in parte.

  - strategiile se aleg inainte de efectuarea mutarii pentru fiecare erou in 
    parte doar daca respectivul nu este incapacitat.
  
  - Marele Magician ce este notificat prin intermediul observer patternului in
    legatura cu jucatori , ingeri si interactiunea dintre acestia - implementat
    ca Singleton.

	
