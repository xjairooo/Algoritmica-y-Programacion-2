package ej4;

public class DynamicArrayListTest {

    public static void main(String[] args) {
        DynamicArrayList<Integer> list = new DynamicArrayList<>();
        // Añadimos algunos elementos
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        // Forzamos el crecimiento de la capacidad
        for (int i = 5; i < 15; i++) {
            list.add(i);
        }
        int capacityBefore = getCapacity(list);
        list.trimToSize();
        int capacityAfter = getCapacity(list);

        assert list.size() == capacityAfter : "La capacidad después de trimToSize debe ser igual al tamaño";
        assert capacityAfter < capacityBefore : "La capacidad debe reducirse tras trimToSize";

        System.out.println("Test trimToSize OK");
    }

    // Método auxiliar para obtener la capacidad interna usando reflexión
    private static int getCapacity(DynamicArrayList<?> list) {
        try {
            java.lang.reflect.Field f = DynamicArrayList.class.getDeclaredField("elements");
            f.setAccessible(true);
            Object[] arr = (Object[]) f.get(list);
            return arr.length;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}