package model;
import java.util.ArrayList;
import java.util.List;


public class SimulationState{

    private int roadLength;
    private int numberOfCars;
    private boolean isRunning;

    // varje bil har en position på vägen
    private List<Integer> carPositions;

    //konstruktör
    public SimulationState(int roadLength, int numberOfCars){
        this.roadLength = roadLength;
        this.numberOfCars = numberOfCars;
        this.isRunning = false; // Simulationen är stoppad(false)

        //skapar en array som kommer innehålla bilarnas pesitioner
        this.carPositions = new ArrayList<>();
        reset(); // arrayen fylls på med bilar

    }
        // börja om
        public void reset(){
            carPositions.clear();// ta bort gamla positioner

            // avstånd mellan varje bil
            int gap = roadLength / numberOfCars;

            for (int i = 0; i < numberOfCars; i++){
                int position = i * gap; // avstånds skillanden mellan bilarna * varje bil i ordning
                carPositions.add(position);
            }
        } 

        // getters(läsa värden)
        public int getRoadLength(){
            return roadLength;
        }

        public List<Integer> getCarPositions(){
            return carPositions;
        }


        public void start(){
            isRunning = true;
        }

        public void stop(){
            isRunning = false;
        }

        // eftersom isRunning är privat då måste den användas(hämtas) av andra klasser via den här
        public boolean isRunning(){
            return isRunning;
        }

        // UI test, flytta bilen ett steg efter varje trick
        public void step(){
            for (int i = 0; i < carPositions.size(); i++){
                int currentPosition = carPositions.get(i); // hämtar bilens position
                int newPosition = currentPosition + 1; // flytta bilen ett steg framåt

                if(newPosition >= roadLength){
                    newPosition = 0; // om bilens postion når vägens slutpunkt, börja om
                }
                carPositions.set(i, newPosition); // spara nya positionen
            }
        }




        
    }
