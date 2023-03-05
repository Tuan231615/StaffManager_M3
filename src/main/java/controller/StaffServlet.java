package controller;

import model.Staff;
import org.apache.taglibs.standard.tag.el.core.IfTag;
import service.StaffService;
import service.StaffServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StaffServlet", value = "/staffs")
public class StaffServlet extends HttpServlet {
    private final StaffService staffService = new StaffServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewStaff(request, response);
                break;
            default:
                listStaffs(request, response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStaff(request, response);
                break;
            case "edit":
                updateToStaff(request, response);
                break;
            case "delete":
                deleteStaff(request, response);
                break;
            default:
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = this.staffService.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("staff", staff);
            dispatcher = request.getRequestDispatcher("staff/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void updateToStaff(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        float cCCD = Float.parseFloat(request.getParameter("cCCD"));
        float phone = Float.parseFloat(request.getParameter("phone"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String note = request.getParameter("note");
        Staff staff = this.staffService.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            staff.setCode(code);
            staff.setName(name);
            staff.setcCCD(cCCD);
            staff.setPhone(phone);
            staff.setAddress(address);
            staff.setEmail(email);
            staff.setNote(note);
            this.staffService.update(id, staff);
            request.setAttribute("staff", staff);
            request.setAttribute("message", "Staff information was update");
            dispatcher = request.getRequestDispatcher("staff/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listStaffs(HttpServletRequest request, HttpServletResponse response) {
        List<Staff> staffs = this.staffService.findAll();
        request.setAttribute("staffs", staffs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createStaff(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        float cCCD = Float.parseFloat(request.getParameter("cCCD"));
        float phone = Float.parseFloat(request.getParameter("phone"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String note = request.getParameter("note");
        int id = (int) (Math.random() * 100);
        Staff staff = new Staff(id, code, name, cCCD, phone, address, email, note);
        this.staffService.save(staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        request.setAttribute("message", "New staff was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = this.staffService.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("staff", staff);
            dispatcher = request.getRequestDispatcher("staff/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteStaff(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = this.staffService.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.staffService.remove(id);
            try {
                response.sendRedirect("/staffs");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void viewStaff(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = this.staffService.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("staff", staff);
            dispatcher = request.getRequestDispatcher("staff/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
