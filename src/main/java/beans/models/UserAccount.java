package beans.models;

public class UserAccount {

    private long userId;
    private User user;
    private Double amountMoney;

    public UserAccount() {
    }

    public UserAccount(double amountMoney) {
        this.amountMoney = amountMoney;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Double getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(Double amountMoney) {
        this.amountMoney = amountMoney;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", amountMoney=" + amountMoney +
                '}';
    }
}
