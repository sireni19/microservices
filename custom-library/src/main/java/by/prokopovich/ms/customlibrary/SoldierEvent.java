package by.prokopovich.ms.customlibrary;


import java.util.Objects;
/**
 * SoldierEvent представляет собой сообщение, которое Kafka Producer отправляет в Kafka Broker,
 * из которого это сообщение берет Kafka Consumer
 */
public class SoldierEvent {
    private String soldierId;
    private String lastName_firstName_patronymic;

    public SoldierEvent() {

    }

    public String getSoldierId() {
        return soldierId;
    }

    public void setSoldierId(String soldierId) {
        this.soldierId = soldierId;
    }

    public String getLastName_firstName_patronymic() {
        return lastName_firstName_patronymic;
    }

    public void setLastName_firstName_patronymic(String lastName_firstName_patronymic) {
        this.lastName_firstName_patronymic = lastName_firstName_patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoldierEvent that = (SoldierEvent) o;
        return Objects.equals(soldierId, that.soldierId) && Objects.equals(lastName_firstName_patronymic, that.lastName_firstName_patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soldierId, lastName_firstName_patronymic);
    }

    @Override
    public String toString() {
        return "SoldierEvent{" +
                "soldierId='" + soldierId + '\'' +
                ", lastName_firstName_patronymic='" + lastName_firstName_patronymic + '\'' +
                '}';
    }
}
