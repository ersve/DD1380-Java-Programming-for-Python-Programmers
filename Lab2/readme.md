Pussel
Putte har konstruerat en robot som lägger pussel. Först lägger roboten först alla kantbitar, och sedan alla de inre bitarna. Putte har räknat ut att tiden det tar för roboten att lägga ett pussel är

∑i=1k1.001i+∑j=1n1.01j
där k är antalet kantbitar och n är antalet inre bitar. Din uppgift är nu att skriva ett program som givet ett pussels storlek räknar ut hur lång tid det kommer att ta roboten att lägga pusslet.

Indata
Indata består av två heltal x och y som anger antalet pusselbitar i respektive x- och y-led. Du kan förutsätta att 1≤x≤100 och 1≤y≤100.

Utdata
Utdata ska bestå av 5 heltal, utskrivna på en rad med ett mellanslag mellan varje tal. De 5 talen ska ange hur många år, dagar, timmar, minuter och sekunder det tar för roboten att lägga pusslet. Vi räknar med 365 dagar per år, och för enkelhets skull så räknar vi bara hela sekunder (så om det till exempel tar 1 minut och 42.453 sekunder för roboten att lägga pusslet, så ska utdata vara

0 0 0 1 42
