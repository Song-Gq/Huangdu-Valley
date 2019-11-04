package huangduValley.farm.land;

import huangduValley.Stdout;
import huangduValley.farm.plant.*;
import huangduValley.farm.storage.Ingredients;
import huangduValley.farm.storage.RootBag;

// provide a function to calculate the production
// pass "this" to obj for print
public class CalculateProduction {

    // calculate production by plant type
    public static void cal (Plant plant, int production, ILand iLand) throws Exception {
        if(plant instanceof StrongCarrot) {
            exec("Carrot", production * 2, iLand);
        }
        else if(plant instanceof CommonCarrot) {
            exec("Carrot", production, iLand);
        }
        else if(plant instanceof StrongPotato) {
            exec("Potato", production * 2, iLand);
        }
        else if(plant instanceof CommonPotato) {
            exec("Potato", production, iLand);
        }
        // unknown plant
        else {
            throw new Exception("unknown plant when harvest()");
        }
    }

    // add the production into the storage
    // and print
    private static void exec(String name, int production, ILand iLand) throws Exception {
        if(iLand instanceof Land)
            Stdout.print("huangduValley.farm.land.CalculateProduction@static",
                    "Get " + production + " " + name + " during harvest");
        else if(iLand instanceof RedSoil)
            Stdout.print("huangduValley.farm.land.CalculateProduction@static",
                    "Get extra " + production +
                    " " + name + " during harvest");
        else
            Stdout.print("huangduValley.farm.land.CalculateProduction@static",
                    "Get extra " + production +
                    " " + name + " during harvest");

        RootBag rootBag = RootBag.getInstance();
        rootBag.add(new Ingredients(name, production));
    }
}
