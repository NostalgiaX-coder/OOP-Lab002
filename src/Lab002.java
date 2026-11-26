public class Lab002 {
    public static void main(String[] args){
        AirPurifier a = new AirPurifier("Pro", "001");
        AirPurifier b = new AirPurifier("Standard", "002");

        a.turnOn();
        a.setFanSpeed(3);
        a.setPM25(34.3);

        b.turnOn();
        b.setFanSpeed(2);
        b.setPM25(15.5);
        b.turnOff();

        a.setFanSpeed(10);
        a.setPM25(-5);

        a.showStatus();

        System.out.println("---------------------");

        b.showStatus();

        System.out.println("A is on: " + a.isOn());
        System.out.println("A speed: " + a.getFanSpeed());
        System.out.println("A PM2.5: " + a.getPM25());
    }
}
