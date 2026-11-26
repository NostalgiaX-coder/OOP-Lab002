import java.util.Map;
import java.util.TreeMap;

public class AirPurifier{
    String model;
    String serialNo;
    boolean power;
    int fanSpeed;
    double pm25;
    static int totalCount = 0;
    static int modelCount = 0;
    static Map<String, Integer> modelCounts = new TreeMap<>();

    AirPurifier(String model, String serialNo){
        this.model = model;
        this.serialNo = serialNo;
        this.power = false;
        this.fanSpeed = 0;
        this.pm25 = 0;
        totalCount++;
        if (!modelCounts.containsKey(model)) {
            modelCount++;
            modelCounts.put(model, 0);
        }
        modelCounts.put(model, modelCounts.get(model) + 1);
    }
    void turnOn(){
        power = true;
        fanSpeed = 1;
    }
    void turnOff(){
        power = false;
        fanSpeed = 0;
    }
    void setFanSpeed(int speed){
        if( power == true ){
            if(speed >=1 && speed <=3){
                fanSpeed = speed;
            }
            if (speed == 0){
                fanSpeed = 0;
                power = false;
            }
        }
    }
    void setPM25(double value){
        if(value >= 0){
            pm25 = value;
        }
    }
    boolean isOn(){
        return power;
    }
    int getFanSpeed(){
        return fanSpeed;
    }
    double getPM25(){
        return pm25;
    }
    void showStatus(){
        System.out.println("Model: " + model);
        System.out.println("Serial: " + serialNo);
        System.out.println("Power: " + power);
        System.out.println("Fan Speed: " + fanSpeed);
        System.out.println("PM2.5 : " + pm25);
    }
    static int getTotalCount() {
        return totalCount;
    }
    static int getModelCount() {
        return modelCount;
    }
    static String mostPopularModel() {
        String result = null;
        int maxCount = 0;
        for (String model : modelCounts.keySet()) {
            int count = modelCounts.get(model);
            if (count > maxCount) {
                maxCount = count;
                result = model;
            }
        }
        return result;
    }
    static double averageCountPerModel() {
        if (modelCount == 0) {
            return 0.0;
        }

        return (double) totalCount / modelCount;
    }
}