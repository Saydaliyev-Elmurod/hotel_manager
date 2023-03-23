package org.example.service;

import org.example.entity.GuestEntity;
import org.example.entity.PassportEntity;
import org.example.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    public void add(String name, String surname, String phone, String passNum, String givenDate, String expDate, String givenBy) {
        PassportEntity passport = guestRepository.getPassport(passNum);
        if (passport != null) {
            System.out.println("This passport belong other guest");
            return;
        }
        passport = new PassportEntity();
        passport.setNumber(passNum);
        passport.setGiven_date(LocalDate.parse(givenDate));
        passport.setExp_date(LocalDate.parse(expDate));
        passport.setGivenBy(givenBy);
        guestRepository.save(passport);

        GuestEntity guest = new GuestEntity();
        guest.setName(name);
        guest.setSurname(surname);
        guest.setPhone(phone);
        guest.setPassport(passport);

        guestRepository.save(guest);

//        passport.setEmployee_id(guestRepository.getById(/));

    }

    public List<GuestEntity> list() {
        return guestRepository.getGuestList();
    }
}
