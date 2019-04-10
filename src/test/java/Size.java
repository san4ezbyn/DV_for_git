public enum Size {

    BIG("L"), VERY_BIG("XL"), AVERAGE("M"), SMALL("S"), VERY_SMALL("XS");


    private String abbreviation;

    Size(String abbreviation){
        this.abbreviation=abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
