package data;

public class data {
    private int period;
    private int demand;

    public data(int period, int demand) {
        this.period = period;
        this.demand = demand;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }
}
