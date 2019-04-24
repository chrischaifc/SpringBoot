package com.fuchunchai.hospital.web.application;

import com.fuchunchai.hospital.business.domain.DoctorAppointment;
import com.fuchunchai.hospital.business.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//Controller for Web

@Controller
@RequestMapping(value="/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(method= RequestMethod.GET)
    public String getReservations(@RequestParam(value="date", required=false)String dateString, Model model){
        List<DoctorAppointment> doctorAppointmentList = this.appointmentService.getDoctorAppointmentForDate(dateString);
        model.addAttribute("doctorAppointments", doctorAppointmentList);
        return "appointments";
    }
}
