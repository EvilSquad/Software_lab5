import java.util.List;
/**
 * Лабораторна робота №5
 *
 * Виконав: Овер'янов Богдан, ст. групи ІК-24, ФІОТ
 *
 * Варіант №11
 *
 * Створити узагальнений клас та не менше 3 класів-нащадків, що описують задану варіантом
 * (п.2) область знань. Створити клас, що складається з масиву об’єктів, з яким можна виконати
 * вказані варіантом дії. Необхідно обробити всі виключні ситуації, що можуть виникнути під час
 * виконання програмного коду. Код повинен бути детально задокументований. Код повинен відповідати
 * стандартам Java Code Conventions (або Google Java Style Guide) та бути завантаженим на GitHub
 *
 * Завантажити фургон певного обсягу вантажем на певну суму з різних сортів кави, що можуть перебувати
 * у різних фізичних станах (зерно, мелена, розчинна в банках і пакетиках). Ураховувати обсяг кави
 * разом з упаковкою. Провести сортування товарів на основі співвідношення ціни й ваги. Знайти товар
 * у фургоні, що відповідає заданому діапазону якості кави.
 *
 * Примітка: При створенні коду я для всієї кави, окрім розчинної, враховував тип упаковки
 * в вазі, яку задавав. А для розчинної я зробив вагу упаковки окремою та реалізував її
 * обрахунок (бо відповідно банок при збільшенні ваги кави в фургоні теж стає більше, та
 * і це більш логічно).
 *
 * Ще варто зазначити, що під "сортуванням за співвідношенням ціни до ваги" я зрозумів
 * загальну вартість кави (тобто ціна_кави * вага_кави).
 */
public class Main {
    public static void main(String[] args) {
        Truck truck = new Truck(1000); // Фургон, в який може поміститись 1000кг кави

        // Створюю екземляри класів різних типів кави
        Coffee coffee1 = new BeanCoffee("Арабіка", 20.5, 15, 85);
        Coffee coffee2 = new GroundCoffee("Робуста", 18.0, 10, 70);
        Coffee coffee3 = new InstantCoffee("Нескафе", 25.0, 5, 90, 1);
        Coffee coffee4 = new InstantCoffee("Нестле", 22.0, 7, 75, 0);
        Coffee coffee5 = new BeanCoffee("Бразилія", 23.0, 12, 88);
        Coffee coffee6 = new GroundCoffee("Колумбія", 19.5, 8, 72);
        Coffee coffee7 = new InstantCoffee("Голд", 27.0, 4, 95, 1);
        Coffee coffee8 = new InstantCoffee("Класік", 20.0, 6, 78, 0);
        Coffee coffee9 = new BeanCoffee("Ефіопія", 24.0, 14, 90);
        Coffee coffee10 = new GroundCoffee("Індія", 17.5, 9, 68);
        Coffee coffee11 = new InstantCoffee("Маккофі", 21.0, 5, 80, 0);
        Coffee coffee12 = new BeanCoffee("Коста-Ріка", 26.0, 11, 92);
        Coffee coffee13 = new InstantCoffee("Якобс", 30.0, 3, 98, 1);
        Coffee coffee14 = new GroundCoffee("В'єтнам", 16.0, 7, 65);

        // Тут, відповідно, завантажую їх в фургон
        truck.addCoffee(coffee1);
        truck.addCoffee(coffee2);
        truck.addCoffee(coffee3);
        truck.addCoffee(coffee4);
        truck.addCoffee(coffee5);
        truck.addCoffee(coffee6);
        truck.addCoffee(coffee7);
        truck.addCoffee(coffee8);
        truck.addCoffee(coffee9);
        truck.addCoffee(coffee10);
        truck.addCoffee(coffee11);
        truck.addCoffee(coffee12);
        truck.addCoffee(coffee13);
        truck.addCoffee(coffee14);

        // Виводжу початковий стан фургону
        truck.displayCargo();

        // Зробив для відстежування вивід поточної завантаженості фургону
        System.out.println("\nПоточна завантаженість фургону: "+ truck.getCurrentLoad() + " / " + truck.getMaxCapacity() + " кг.");

        // Сортую та виводжу вантаж після сортування
        System.out.println("\nСортування вантажу за співвідношенням ціни до ваги...");
        truck.sortCargoByPricePerWeight();
        truck.displayCargo();

        // Пошук кави за діапазоном і, відповідно, її виведення
        System.out.println("\nПошук кави з якістю від 80 до 100...");
        List<Coffee> qualityCoffees = truck.findCoffeeByQualityRange(80, 100);
        for (Coffee coffee : qualityCoffees) {
            System.out.println(coffee);
        }
    }
}