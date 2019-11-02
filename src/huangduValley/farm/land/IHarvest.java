package huangduValley.farm.land;

import huangduValley.farm.plant.Carrot;
import huangduValley.farm.plant.Plant;
import huangduValley.farm.plant.Potato;

// part of "Decorator" design pattern
// implemented by class farm.land.Land and farm.land.Soil
// scene "Farm", by Song Guanqun
public interface IHarvest {

    // you can call it through an farm.land.IHarvest implemented by a farm.land.Land Object
    // without decorations of farm.land.Soil
    // or, call harvest() through an farm.land.IHarvest implemented by
    // a concrete farm.land.Soil whose iHarvest field is initialized with a farm.land.Land Object
    public void harvest() throws Exception;

    // for the convenience of calling these methods
    // through one unified interface
    // to be modified
    // public void plant(Plant plant);
    public Plant getPlant();
    public void water();
    public void fertilize();

    public Carrot plantCarrot() throws Exception;
    public Potato plantPotato() throws Exception;
}
