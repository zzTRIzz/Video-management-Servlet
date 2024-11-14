//package NguoiDung;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserService {
//    private List<User> list = new ArrayList<>();
//
//    public UserService(){
////        list.add(new User("1","1","1","1",true));
////        list.add(new User("2","1","1","1",true));
//    }
//
//    public List<User> getList() {
//        return list;
//    }
//
//    public void add(User u) {
//        list.add(u);
//    }
//
//    public void removeID(String id) {
//        User u = findID(id);
//        if (u != null){
//            System.out.println("Done");
//            list.remove(u);
//        }
//    }
//
//    public User findID(String id){
//        for (User u : list) {
//            if (u.getId().equals(id)){
//                return u;
//            }
//        }
//        return null;
//    }
//
//    public void update(User u){
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId().equals(u.getId())){
//                list.set(i,u);
//            }
//        }
//    }
//
//
//}
