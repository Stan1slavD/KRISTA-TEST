
public class Plant {
    private String common;
    private String botanical;
    private String zone;
    private String light;
    private String price;
    private String availability;
    private  int id;
    private static int counter;

    static {
        try {
            counter = DBWriter.getMaxPlantID();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Plant(String common, String botanical, String zone, String light, String price, String availability) {
        this.common = common;
        this.botanical = botanical;
        this.zone = zone;
        this.light = light;
        this.price = price;
        this.availability = availability;
        this.id=counter++;
    }

    public Plant(){ this.id=counter++;}
    public String getCommon() {
        return common;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "common='" + common + '\'' +
                ", botanical='" + botanical + '\'' +
                ", zone=" + zone +
                ", light='" + light + '\'' +
                ", price='" + price + '\'' +
                ", availability=" + availability +
                ", id=" + id +
                '}';
    }

    public  int getId() {
        return id;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getBotanical() {
        return botanical;
    }

    public void setBotanical(String botanical) {
        this.botanical = botanical;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }


}
