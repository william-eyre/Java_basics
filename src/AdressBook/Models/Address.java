package AdressBook.Models;

/**
 * Created by william.eyre on 11/10/2016.
 */
public class Address {

    //fields

    private String HouseNumber;
    private String StreetName;
    private String Town;
    private String County;
    private String PostCode;

    //properties


    public String getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        HouseNumber = houseNumber;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        County = county;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    //constructor


    public Address(String houseNumber, String streetName, String town, String county, String postCode) {

        HouseNumber = houseNumber;
        StreetName = streetName;
        Town = town;
        County = county;
        PostCode = postCode;
    }

}

