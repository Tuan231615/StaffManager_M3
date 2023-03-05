package service;

import model.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> findAll();
void save(Staff staff);
Staff findById(int id);
void update(int id, Staff staff);
void remove(int id);
}
