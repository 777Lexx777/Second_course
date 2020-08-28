package Lesson_2;

import java.util.Random;

public class Airplane {
    public void doStabilityCheck() {
        try {
            checkMechanisation();
            checkElectricity();
        } catch (MechanisationException | ElectricityException e) {
            throw new StabilityErrorException("Something went wrong during stability check", e);
        }
    }

    private void checkMechanisation() throws MechanisationException {
        if (!new Random().nextBoolean()) {
            throw new MechanisationException("Something went wrong with plane mechanisation");
        }
    }

    private void checkElectricity() throws ElectricityException {
        if (!new Random().nextBoolean()) {
            throw new ElectricityException("Something went wrong with plane electricity");
        }
    }
}
