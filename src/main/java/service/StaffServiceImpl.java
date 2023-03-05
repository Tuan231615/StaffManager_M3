package service;

import model.Staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffServiceImpl implements StaffService {
    private static final Map<Integer, Staff> staffs;
    static {
        staffs = new HashMap<>();
        staffs.put(1, new Staff(1, "nv1", "Nguyen Anh Tuan", 036200007613,
                0376017645, "Nam Dinh", "Nguyentuan@gmail.com", "Cu bi gut boy"));
        staffs.put(2, new Staff(2, "nv2", "Le Van Doan", 01624566222,
                01623456, "Ninh Binh", "DoanChoDien@gmail.com", "gia ma non"));
        staffs.put(3, new Staff(3, "nv3", "Trinh Van Nam", 03222222222,
                0123453222, "Ninh Binh", "Nam1lan@gmail.com", "gia ma non"));
    }
    @Override
    public List<Staff> findAll() {
        return new ArrayList<>(staffs.values());
    }

    @Override
    public void save(Staff staff) {
        staffs.put(staff.getId(), staff);
    }

    @Override
    public Staff findById(int id) {
        return staffs.get(id);
    }

    @Override
    public void update(int id, Staff staff) {
        staffs.put(id, staff);
    }

    @Override
    public void remove(int id) {
        staffs.remove(id);
    }

}
