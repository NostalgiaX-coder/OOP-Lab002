public class Lab02 {
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

        a.setFanSpeed(0);

        System.out.println("A is on: " + a.isOn());
        System.out.println("A speed: " + a.getFanSpeed());

        System.out.println("---------------------");

        AirPurifier c = new AirPurifier("Pro", "003");
        AirPurifier d = new AirPurifier("Standard", "004");
        AirPurifier e = new AirPurifier("Pro", "005");

        System.out.println("Total Count: " + AirPurifier.getTotalCount());
        System.out.println("Model Count: " + AirPurifier.getModelCount());
        System.out.println("Model Counts: " + AirPurifier.modelCounts);
        System.out.println("Most Popular: " + AirPurifier.mostPopularModel());
        System.out.println("Average: " + AirPurifier.averageCountPerModel());
    }
}
