package com.fuchunchai.hospital.web.service;

import com.fuchunchai.hospital.business.domain.DoctorAppointment;
import com.fuchunchai.hospital.business.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller for API

@RestController
@RequestMapping(value = "/api")
public class AppointmentServiceController {

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(method = RequestMethod.GET, value = "/appointments/{date}")
    public List<DoctorAppointment> getAllAppointmentsForDate(@PathVariable
                                                                     (value = "date") String dateString) {
        return this.appointmentService.getDoctorAppointmentForDate(dateString);
    }
}
