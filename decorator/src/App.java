// Component Interface
interface Coffee {
    String getDescription();

    double getCost();
}

// Concrete Component
class BasicCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getCost() {
        return 2.0;
    }
}

// Decorator Abstract Class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete Decorator 1
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
}

// Concrete Decorator 2
class ChocolateDecorator extends CoffeeDecorator {
    public ChocolateDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Chocolate";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }
}

// Client
class Main {
    public static void main(String[] args) {
        // Order a basic coffee
        Coffee basicCoffee = new BasicCoffee();
        System.out.println("Description: " + basicCoffee.getDescription());
        System.out.println("Cost: $" + basicCoffee.getCost());

        // Add milk to the coffee
        Coffee milkCoffee = new MilkDecorator(basicCoffee);
        System.out.println("\nDescription: " + milkCoffee.getDescription());
        System.out.println("Cost: $" + milkCoffee.getCost());

        // Add chocolate to the coffee
        Coffee chocolateCoffee = new ChocolateDecorator(basicCoffee);
        System.out.println("\nDescription: " + chocolateCoffee.getDescription());
        System.out.println("Cost: $" + chocolateCoffee.getCost());

        // Add milk and chocolate to the coffee
        Coffee milkChocolateCoffee = new ChocolateDecorator(new MilkDecorator(basicCoffee));
        System.out.println("\nDescription: " + milkChocolateCoffee.getDescription());
        System.out.println("Cost: $" + milkChocolateCoffee.getCost());
    }
}
