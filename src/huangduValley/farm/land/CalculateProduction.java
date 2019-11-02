package huangduValley.farm.land;

import huangduValley.farm.Stdout;
import huangduValley.farm.plant.*;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.RootBag;

// provide a function to calculate the production
// pass "this" to obj for print
public class CalculateProduction {

    // calculate production by plant type
    public static void cal (Plant plant, int production, Object obj) throws Exception {
        if(plant instanceof StrongCarrot) {
            exec("Carrot", production * 2, obj);
        }
        else if(plant instanceof CommonCarrot) {
            exec("Carrot", production, obj);
        }
        else if(plant instanceof StrongPotato) {
            exec("Potato", production * 2, obj);
        }
        else if(plant instanceof CommonPotato) {
            exec("Potato", production, obj);
        }
        // unknown plant
        else {
            throw new Exception("unknown plant when harvest()");
        }
    }

    // add the production into the storage
    // and print
    private static void exec(String name, int production, Object obj) throws Exception {
        RootBag rootBag = RootBag.getInstance();
        rootBag.add(new Ingredients(name, production));

        if(obj instanceof Land)
            Stdout.print(obj, "Get " + production + " " + name + " during harvest");
        else if(obj instanceof RedSoil)
            Stdout.print(obj, "Get extra " + production +
                    " " + name + " during harvest");
        else
            Stdout.print(obj, "Get extra " + production +
                    " " + name + " during harvest");
    }
}
