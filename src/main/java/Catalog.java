import java.util.ArrayList;

public class Catalog {
    private String uuid;
    private String date;
    private String company;
    private ArrayList<Plant> plants;
    private int id;
    private static int counter=0;
    public Catalog(String uuid, String date, String company, ArrayList<Plant> plants) {
        this.uuid = uuid;
        this.date = date;
        this.company = company;
        this.plants = plants;
        this.id=counter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "uuid='" + uuid + '\'' +
                ", date='" + date + '\'' +
                ", company='" + company + '\'' +
                ", plants=" + plants +
                '}';
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }
}

