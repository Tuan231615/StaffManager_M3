package model;

public class Staff {
    private int id;
    private String code;
    private String name;
    private float cCCD;
    private float phone;
    private String address;
    private String email;
    private String note;

    public Staff() {
    }

    public Staff(int id, String code, String name, float cCCD, float phone, String address, String email, String note) {

        this.id = id;
        this.code = code;
        this.name = name;
        this.cCCD = cCCD;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getcCCD() {
        return cCCD;
    }

    public void setcCCD(float cCCD) {
        this.cCCD = cCCD;
    }

    public float getPhone() {
        return phone;
    }

    public void setPhone(float phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
