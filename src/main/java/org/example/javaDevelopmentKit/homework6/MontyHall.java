package org.example.javaDevelopmentKit.homework6;

import java.util.Random;

public class MontyHall {
    private int doors;
    private Random random = new Random();
    private int carBehindDoor; // Расположение автомобиля за одной из дверей
    private int playerChoice; // Игрок выбирает одну из дверей
    private int doorOpenedByHost; // Ведущий открывает одну из дверей с козой (не выбранную игроком и не содержащую автомобиль)
    private int finalChoice;

    public MontyHall(int doors){
        this.doors = doors;
    }
    public boolean playMontyHall(){
        do{
            doorOpenedByHost = random.nextInt(doors) + 1;
        }while (doorOpenedByHost == playerChoice || doorOpenedByHost == carBehindDoor);{
            boolean switchDoor = random.nextBoolean();
            int finalChoice;
            if(switchDoor){
                do {
                    finalChoice = random.nextInt(doors) + 1;
                } while (finalChoice == playerChoice || finalChoice == doorOpenedByHost);
            }else {
                finalChoice = playerChoice;
            }
            // Возвращаем результат: true, если игрок выбрал дверь с автомобилем
            return finalChoice == carBehindDoor;
        }
    }

    public int getDoors() {
        return doors;
    }

    public Random getRandom() {
        return random;
    }

    public int getCarBehindDoor() {
        return carBehindDoor;
    }

    public int getPlayerChoice() {
        return playerChoice;
    }

    public int getDoorOpenedByHost() {
        return doorOpenedByHost;
    }

    public int getFinalChoice() {
        return finalChoice;
    }
}
