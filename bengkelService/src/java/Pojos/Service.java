package Pojos;
// Generated Nov 1, 2018 12:42:32 PM by Hibernate Tools 4.3.1

/**
 * Service generated by hbm2java
 */
public class Service implements java.io.Serializable {

    private int noAntrian;

    public Service() {
    }

    public Service(int noAntrian) {
        this.noAntrian = noAntrian;
    }

    public int getNoAntrian() {
        return this.noAntrian;
    }

    public void setNoAntrian(int noAntrian) {
        this.noAntrian = noAntrian;
    }

    public String toJson() {

        return "{\"noAntrian\":" + getNoAntrian() + "}";

    }}
