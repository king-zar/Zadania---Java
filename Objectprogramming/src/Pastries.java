import org.w3c.dom.ls.LSOutput;

import java.util.*;

interface oven {
    public void bakingTime();
    public void temperature();
    public void bakingProgram();
}

interface risingTime {
    public void wholeDoughTime();
    public void dividedDoughTime();
}

interface addings {
    public void raisins();
    public void orangePeel();
    public void coconut();
    public void chocolate();
}

abstract class Eggs {
    private int eggsAmount;
    private int yolksAmount;
    private int proteinsAmount;

    Eggs () {
    }

    private int getYolksAmount () {
        return yolksAmount;
    }

    private int getProteinsAmount () {
        return proteinsAmount;
    }

    public int getEggsAmount () {
        return eggsAmount;
    }

    public int chooseNeededPart (String neededPart) {
        if (neededPart == "yolks") {
            return getYolksAmount();

        } else if (neededPart == "proteins") {
            return getProteinsAmount();
        }

        return 0;
    } // if two of them are needed in the same time, function returns 0
      // because it shouldn't be called

    abstract protected void Mixing();
    // (abstraction) this method, because we need it in cheese mass
    // there we decide how to mix the eggs

}

class CheeseMass extends Eggs implements addings {
    int sugarAmount;
    String choseAdding;

    CheeseMass () {
    }

    CheeseMass (int sugarAmount) {
        this.sugarAmount = sugarAmount;
    }

    @Override
    public void chocolate () {
        System.out.println("You can add chocolate chips to your cheese mass.");
    }

    public void coconut () {
        System.out.println("Your cheese mass'll be better with some coconut!");
    }

    @Override
    public void raisins () {
        System.out.println("Do you like raisins in cheese mass? Let's add it!");
    }

    public void orangePeel () {
        System.out.println("If you want something special, orange peel'll be perfect.");
    }

    public void setChoosedAdding (String choseAdding) {
        this.choseAdding = choseAdding;
        System.out.println("You chose " + choseAdding + ".");
    }

    @Override
    protected void Mixing() {
        System.out.println("Mix yolks, powdered sugar, etc. At the end add " + choseAdding ".");
    }
}

class CheeseCake extends CheeseMass implements oven {
    @Override
    public void bakingTime() {
        System.out.println("Bake your bread 60 minutes.");
    }

    @Override
    public void temperature() {
        System.out.println("Temperature: 170 degrees");
    }

    @Override
    public void bakingProgram() {
        System.out.println("Heating: top-down");
    }

    void serving () {
        System.out.println("Serve with melted chocolate or home-made jam.");
    }
}

class Flour {
    String typeOfFlour;
    private int flourAmount;

    Flour() {
    }

    Flour (String typeOfFlour, int glassAmount) {
        this.typeOfFlour = typeOfFlour;
    }

    private void setFlourAmount (int glassAmount) {
        flourAmount = glassAmount*160; // 1 glass of flour is about 160g
    };

    public int getFlourAmount () {
        return flourAmount;
    }
}

class Leaven extends Flour {
    private int mlOfWater;

    Leaven () {
    }

    Leaven (int mlOfWater) {
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }
}

class Dough extends Flour implements risingTime {
    String flourName;
    int foldingTime;

    private void setBreadName (String flourName) {
        this.flourName = flourName;
    }

    public String getFlourName () {
        return flourName;
    }

    @Override
    public void wholeDoughTime() {
        System.out.println("Dough should rise 4 hours before dividing.");
    }

    @Override
    public void dividedDoughTime() {
        System.out.println("Divide dough in two and let both parts rise 3 more hours.");
    }

    public void foldInHalf (int foldingTime) {
        this.foldingTime = foldingTime; // each x hour
    }
}

// polymorphism - Bread and Pizza use same classes

class Bread extends Dough implements oven {
    @Override
    public void bakingTime() {
        System.out.println("Bake your bread 40 minutes.");
    }

    @Override
    public void temperature() {
        System.out.println("Temperature: 200 degrees");
    }

    @Override
    public void bakingProgram() {
        System.out.println("Heating: top-down");
        System.out.println("Program: with steam");
    }

    @Override
    public void foldInHalf(int foldingTime) {
        super.foldInHalf(foldingTime);

        if (foldingTime == 1) {
            System.out.println("Remember to fold your dough each " + foldingTime + " hour!");

        } else if (foldingTime > 1) {
            System.out.println("Remember to fold your dough each " + foldingTime + " hours!");

        } else {
            System.out.println("error");
        }
    }
}

class Pizza extends Dough implements oven {
    @Override
    public void foldInHalf(int foldingTime) {
        System.out.println("Let pizza rise alone! Don't fold it.");
    }

    void pizzaAddings() {
        System.out.println("Add your favourite ingredients (for example: a lot of cheese and salami).");
    }

    @Override
    public void bakingTime() {
        System.out.println("Bake your pizza 5 minutes.");
    }

    @Override
    public void temperature() {
        System.out.println("Temperature: 250 degrees");
    }

    @Override
    public void bakingProgram() {
        System.out.println("Heating: top-down");
    }
}

public class Pastries {
}
