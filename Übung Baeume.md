# Übung Bäume

Welche Elemente gibt es in der Datenstruktur Baum?
1. Wurzelknoten
2. innere Knoten
3. Blätter
4. Kindknoten
5. Vaterknoten

Was ist besonders an einem Binärbaum?
- Ein Vaterknoten kann maximal 2 Kindknoten haben

Welche Transversierungsmöglichkeiten von Bäumen kennen sie?
- PreOrder -> V-l-r
- PostOrder -> l-r-V
- InOrder -> l-V-r

Beschreiben sie einen Suchbaum:
- Ein Suchbaum ist ein Binärbaum mit Regeln
    - z.B.: 
        Wert <= Vater -> Wert wird links eingefügt
        Wert > Vater -> Wert wird rechts eingefügt

Erstellen sie einen Suchbaum für:
9 10 17 5 2 1 8

        9
      /   \
     5     10
   /  \      \
  2    8     17
 /
1

PreOrder: 
- 9, 5, 2, 1, 8, 10, 17
PostOrder
- 1, 2, 8, 5, 17, 10, 9
InOrder:
- 1, 2, 5, 8, 9, 10, 17