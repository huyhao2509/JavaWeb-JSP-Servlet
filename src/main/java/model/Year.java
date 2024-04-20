package model;

public class Year {
    private Long yearid;
    private String yearname;
    private Double yearprice;

    public Year() {
    }

    public Year(Long yearid, String yearname, Double yearprice) {
        this.yearid = yearid;
        this.yearname = yearname;
        this.yearprice = yearprice;
    }

    public Long getYearid() {
        return yearid;
    }

    public void setYearid(Long yearid) {
        this.yearid = yearid;
    }

    public String getYearname() {
        return yearname;
    }

    public void setYearname(String yearname) {
        this.yearname = yearname;
    }

    public Double getYearprice() {
        return yearprice;
    }

    public void setYearprice(Double yearprice) {
        this.yearprice = yearprice;
    }
}