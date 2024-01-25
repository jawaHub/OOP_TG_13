# k Means Algorithmus

## Definition

Clustering von zufälligen Datenpunkten

## Algorithmus

### Beschreibung

-wähle 1,2, bis k zufällige Zentren für Cluster die klassifiziert werden sollen.
-wiederhole solange sich die Position eines Clusters ändert
    -Ordne alle Datenpunkte zum nächsten Cluster zu.

    für alle Cluster:
        für alle Datensätz des Clusters
            -berechne den mittleren x-y Wert zu zu diesem
        -setze die Position dieses Clusters neu.





### Pseudocode

wähle Clusterzentren $c_1,c_2,\cdots c_k \leftarrow \R$
    solange ein $c_j$ sich ändert:
        Für alle $x_i$
            $l=argmin_{j=1}^k=(|x_i-c_j|)$

    Für alle$c_j$
