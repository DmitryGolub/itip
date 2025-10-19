import java.util.Locale;

abstract class Furniture {
    protected String name;
    protected String material;
    protected String color;
    protected double weightKg;
    protected double price;
    protected static int count = 0;

    public Furniture() {
        this("Безымянная мебель", "дерево", "натуральный", 5.0, 0.0);
    }

    public Furniture(String name, String material, String color, double weightKg, double price) {
        this.name = name;
        this.material = material;
        this.color = color;
        this.weightKg = weightKg;
        this.price = price;
        count++;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getWeightKg() { return weightKg; }
    public void setWeightKg(double weightKg) { this.weightKg = weightKg; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract void use();      // поведение 1
    public abstract void showInfo(); // ввод/вывод информации об объекте

    public static void showCount() {
        System.out.println("Создано объектов мебели: " + count);
    }
}

// --------------------------- Стол ---------------------------
class Table extends Furniture {
    private String shape;
    private int seats;
    private boolean extendable;

    public Table() {
        this("Обеденный стол", "дерево", "орех", 18.0, 15990.0,
             "прямоугольный", 6, true);
    }

    public Table(String name, String material, String color, double weightKg, double price,
                 String shape, int seats, boolean extendable) {
        super(name, material, color, weightKg, price);
        this.shape = shape;
        this.seats = seats;
        this.extendable = extendable;
    }

    public String getShape() { return shape; }
    public void setShape(String shape) { this.shape = shape; }

    public int getSeats() { return seats; }
    public void setSeats(int seats) { this.seats = seats; }

    public boolean isExtendable() { return extendable; }
    public void setExtendable(boolean extendable) { this.extendable = extendable; }

    public void extend() {
        if (extendable) {
            seats += 2;
            System.out.println(name + ": стол разложен, теперь мест: " + seats);
        } else {
            System.out.println(name + ": стол не раскладывается.");
        }
    }

    @Override
    public void use() {
        System.out.println(name + ": сервируем и принимаем пищу.");
    }

    @Override
    public void showInfo() {
        System.out.println("=== Стол ===");
        System.out.printf(Locale.US,
                "Название: %s%nМатериал: %s%nЦвет: %s%nВес: %.1f кг%nЦена: %.2f%n",
                name, material, color, weightKg, price);
        System.out.println("Форма: " + shape);
        System.out.println("Количество мест: " + seats);
        System.out.println("Раскладной: " + (extendable ? "да" : "нет"));
        System.out.println();
    }
}

// --------------------------- Стул ---------------------------
class Chair extends Furniture {
    private boolean hasArmrests;
    private int heightCm;
    private int maxLoadKg;

    public Chair() {
        this("Офисный стул", "пластик/ткань", "чёрный", 9.0, 7990.0,
             true, 45, 120);
    }

    public Chair(String name, String material, String color, double weightKg, double price,
                 boolean hasArmrests, int heightCm, int maxLoadKg) {
        super(name, material, color, weightKg, price);
        this.hasArmrests = hasArmrests;
        this.heightCm = heightCm;
        this.maxLoadKg = maxLoadKg;
    }

    public boolean isHasArmrests() { return hasArmrests; }
    public void setHasArmrests(boolean hasArmrests) { this.hasArmrests = hasArmrests; }

    public int getHeightCm() { return heightCm; }
    public void setHeightCm(int heightCm) { this.heightCm = heightCm; }

    public int getMaxLoadKg() { return maxLoadKg; }
    public void setMaxLoadKg(int maxLoadKg) { this.maxLoadKg = maxLoadKg; }

    public void adjustHeight(int delta) {
        heightCm = Math.max(35, Math.min(60, heightCm + delta));
        System.out.println(name + ": высота отрегулирована до " + heightCm + " см.");
    }

    @Override
    public void use() {
        System.out.println(name + ": садимся за работу или отдых.");
    }

    @Override
    public void showInfo() {
        System.out.println("=== Стул ===");
        System.out.printf(Locale.US,
                "Название: %s%nМатериал: %s%nЦвет: %s%nВес: %.1f кг%nЦена: %.2f%n",
                name, material, color, weightKg, price);
        System.out.println("Подлокотники: " + (hasArmrests ? "есть" : "нет"));
        System.out.println("Высота сиденья: " + heightCm + " см");
        System.out.println("Макс. нагрузка: " + maxLoadKg + " кг");
        System.out.println();
    }
}

// --------------------------- Кровать ---------------------------
class Bed extends Furniture {
    private String size;
    private String mattress;
    private boolean hasStorage;

    public Bed() {
        this("Кровать «Соната»", "массив", "белый", 35.0, 24990.0,
             "двуспальная", "ортопедический", true);
    }

    public Bed(String name, String material, String color, double weightKg, double price,
               String size, String mattress, boolean hasStorage) {
        super(name, material, color, weightKg, price);
        this.size = size;
        this.mattress = mattress;
        this.hasStorage = hasStorage;
    }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getMattress() { return mattress; }
    public void setMattress(String mattress) { this.mattress = mattress; }

    public boolean isHasStorage() { return hasStorage; }
    public void setHasStorage(boolean hasStorage) { this.hasStorage = hasStorage; }

    public void makeBed() {
        System.out.println(name + ": кровать застелена, всё готово ко сну.");
    }

    @Override
    public void use() {
        System.out.println(name + ": спим и отдыхаем.");
    }

    @Override
    public void showInfo() {
        System.out.println("=== Кровать ===");
        System.out.printf(Locale.US,
                "Название: %s%nМатериал: %s%nЦвет: %s%nВес: %.1f кг%nЦена: %.2f%n",
                name, material, color, weightKg, price);
        System.out.println("Размер: " + size);
        System.out.println("Матрас: " + mattress);
        System.out.println("Ящики для хранения: " + (hasStorage ? "есть" : "нет"));
        System.out.println();
    }
}

// --------------------------- Демонстрация ---------------------------
public class Main {
    public static void main(String[] args) {
        Table t1 = new Table();
        Chair c1 = new Chair();
        Bed b1   = new Bed();

        Table t2 = new Table("Журнальный столик", "стекло/металл", "прозрачный",
                8.0, 10990.0, "круглый", 4, false);

        Chair c2 = new Chair("Стул «Олимп»", "бук", "орех", 6.5, 4990.0,
                false, 43, 140);

        Bed b2 = new Bed("Кровать «Норд»", "ЛДСП", "дуб сонома", 29.0, 18990.0,
                "полуторная", "пружинный", false);

        t1.showInfo(); t2.showInfo();
        c1.showInfo(); c2.showInfo();
        b1.showInfo(); b2.showInfo();

        Furniture[] items = { t1, t2, c1, c2, b1, b2 };
        for (Furniture f : items) f.use();

        t1.extend();
        c1.adjustHeight(+5);
        b1.makeBed();

        c2.setHasArmrests(true);
        System.out.println(c2.getName() + ": подлокотники теперь " + (c2.isHasArmrests() ? "есть" : "нет"));
        t2.setSeats(2);
        System.out.println(t2.getName() + ": пересчитаны места = " + t2.getSeats());
        b2.setMattress("латексный");
        System.out.println(b2.getName() + ": матрас -> " + b2.getMattress());

        Furniture.showCount();
    }
}
