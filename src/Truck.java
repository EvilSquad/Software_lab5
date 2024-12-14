import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * Клас, що відповідає за фургон.
 * Наслідується абстрактний клас кави.
 * Оскільки за умовою лаби в нас кава
 * може бути в банках і пакетиках, то
 * реалізував відповідно і цей функціонал.
 * Також є перевизначення фізичного стану
 * і отримання ваги.
 */
class Truck {
    private List<Coffee> cargo; // Список для вантажу
    private double maxCapacity; // Максимальна вантажопідйомність у кг

    public Truck(double maxCapacity) {
        this.cargo = new ArrayList<>();
        this.maxCapacity = maxCapacity;
    }

    // Додаєм каву. Перевіряєм, чи влазить кава у фургон.
    public boolean addCoffee(Coffee coffee) {
        double currentLoad = getCurrentLoad();
        if (currentLoad + coffee.getWeight() <= maxCapacity) {
            cargo.add(coffee); // Якщо влазить у фургон то додаєм
            return true;
        } else {
            System.out.println("У фургоні недостатньо місця для: " + coffee.getName()); // Якщо не влазить то виводим повідомлення і йдемо далі
            return false;
        }
    }

    // Визначення завантаженості фургона (тобто загальна вага всього вантажу).
    public double getCurrentLoad() {
        return cargo.stream().mapToDouble(Coffee::getWeight).sum(); // Вирішив не робити через цикл, спробував через стрім.
    }

    // Сортування кави за загальною вартістю
    public void sortCargoByPricePerWeight() {
        cargo.sort(Comparator.comparingDouble(Coffee::getPricePerWeight).reversed());
    }

    // Пошук кави за діапазоном якості
    public List<Coffee> findCoffeeByQualityRange(int minQuality, int maxQuality) {
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : cargo) {
            if (coffee.getQuality() >= minQuality && coffee.getQuality() <= maxQuality) {
                result.add(coffee);
            }
        }
        return result;
    }

    // Виведення всього вмісту фургону
    public void displayCargo() {
        System.out.println("Поточний вантаж у фургоні:");
        for (Coffee coffee : cargo) {
            System.out.println(coffee);
        }
    }

    // Геттер для максимальної вмісткості
    public double getMaxCapacity() {
        return this.maxCapacity;
    }
}
