package xh.zero.dao;

public interface AccountDao {
    void out(String outName, int money);

    void in(String inName, int money);
}
