package ETradeDemo.dataAccess.concretes;

import ETradeDemo.dataAccess.abstracts.UserDao;
import ETradeDemo.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class HibernateUserDao implements UserDao {

    private List<User> users = new ArrayList<User>();

    @Override
    public void add(User user) {
        System.out.println("Kullanıcı eklendi : " + user.getFirstName());
        users.add(user);
    }

    @Override
    public void update(User user) {
        System.out.println("Kullanıcı güncellendi : "+ user.getFirstName());
    }

    @Override
    public void delete(User user) {
        System.out.println("Kullanıcı silindi : "+ user.getFirstName());
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        for(User user : users){
            if(user.getEmail() == email) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}
