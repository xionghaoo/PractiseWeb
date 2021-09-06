package xh.zero.aop;

import xh.zero.domain.User;

public class Order {
    private long id;
    private long order_time;
    private String order_no;
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrder_time() {
        return order_time;
    }

    public void setOrder_time(long order_time) {
        this.order_time = order_time;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_time=" + order_time +
                ", order_no='" + order_no + '\'' +
                ", user=" + user +
                '}' + "\n";
    }
}
