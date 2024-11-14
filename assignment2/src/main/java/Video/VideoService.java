//package Video;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class VideoService {
//    private List<Video> list = new ArrayList<>();
//
//    public VideoService() {
//    }
//
//    public List<Video> getList() {
//        return list;
//    }
//
//    public void add(Video u) {
//        list.add(u);
//    }
//
//    public void removeID(String id) {
//        Video u = findID(id);
//        if (u != null) {
//            System.out.println("Done");
//            list.remove(u);
//        }
//    }
//
//    public Video findID(String id) {
//        for (Video u : list) {
//            if (u.getId().equals(id)) {
//                return u;
//            }
//        }
//        return null;
//    }
//
//    public void update(Video u) {
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId().equals(u.getId())) {
//                list.set(i, u);
//            }
//        }
//    }
//}
