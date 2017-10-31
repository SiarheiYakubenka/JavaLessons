package by.itclass.bank;

public class Client {
    private String name;
    private String surname;
    private final String passportNumber;

    public Client(String name, String surname, String passportNumber) {

        setName(name);
        setSurname(surname);
        if (passportNumber == null || passportNumber.isEmpty()) {
            throw  new IllegalArgumentException("Номер паспорта не может быть пустым");
        }

        this.passportNumber = passportNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Имя не может быть пустным");
        }
        this.name = name;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой");
        }
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return passportNumber.equals(client.passportNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
