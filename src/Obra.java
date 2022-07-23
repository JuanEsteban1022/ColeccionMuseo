import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Obra {
    //List<Integer> arreglo = new ArrayList<>();

    public List<Integer> clases(List<Integer> clases) {
        List<Integer> sinDuplicados = clases.stream().distinct().collect(Collectors.toList());
        System.out.println(sinDuplicados);
        return sinDuplicados;
    }

    public List<Integer> meFaltanDeLaClase(List<Integer> faltantes, List<Integer> coleccion, int categoria) {
        List<Integer> sinDuplicados = new ArrayList<>();
        for (Integer i : faltantes) {
            if (coleccion.get(i) == categoria) {
                sinDuplicados.add(i);
            }
        }
        System.out.println(sinDuplicados);
        return sinDuplicados;
    }

    public List<Integer> noTengo(List<Integer> museoA, List<Integer> museoB) {
        List<Integer> noTiene = new ArrayList<>();
        for (Integer i : museoA) {
            if (!museoB.contains(i)) {
                noTiene.add(i);
            }
        }
        System.out.println(noTiene);
        return noTiene;
    }

    public Integer puedoCambiar(List<Integer> museoA, List<Integer> museoB) {
        List<Integer> aux1;
        List<Integer> aux2;
        int cambioEfectivo;
        int contador;
        aux1 = noTengo(museoA, museoB);
        cambioEfectivo = aux1.size();
        aux2 = noTengo(museoB, museoA);
        contador = aux2.size();
        if (cambioEfectivo > contador) {
            return contador;
        } else {
            return cambioEfectivo;
        }
    }

    public static void main(String[] args) {
        Obra obra = new Obra();
        Integer[] clases = new Integer[]{1, 2, 5, 5, 5, 1, 2, 5, 5, 5};
        Integer[] faltantes = new Integer[]{1, 3, 6, 8};
        Integer[] museoA = new Integer[]{3, 5, 7, 10, 15, 16};
        Integer[] museoB = new Integer[]{4, 10, 5, 8};
        int m;
        obra.clases(Arrays.asList(clases));
        obra.meFaltanDeLaClase(Arrays.asList(faltantes), Arrays.asList(clases), 5);
        obra.noTengo(Arrays.asList(museoA), Arrays.asList(museoB));
        m = obra.puedoCambiar(List.of(museoA), List.of(museoB));
        System.out.println("\nLos cambios efectivos son: " + m);
    }
}
