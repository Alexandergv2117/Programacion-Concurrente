class Elevator extends Thread{
    int currentFloor = 0;
    int destination = 0;

    boolean direction = true; // true = subiendo, false = bajando
    boolean resting = true;

    Hotel hotel;
    

    public Elevator(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void run() {
        while (true) {
            if (resting) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                if (direction) {
                    currentFloor++;
                } else {
                    currentFloor--;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (currentFloor == destination) {
                    resting = true;
                }
            }
        }
    }
  
}