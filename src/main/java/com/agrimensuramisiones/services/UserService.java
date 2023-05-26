
package com.agrimensuramisiones.services;

import com.agrimensuramisiones.entities.Photo;
import com.agrimensuramisiones.entities.User;
import com.agrimensuramisiones.enums.Cargo;
import com.agrimensuramisiones.enums.Cities;
import com.agrimensuramisiones.enums.Gender;
import com.agrimensuramisiones.enums.Rol;
import com.agrimensuramisiones.repositories.UserRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PhotoService photoService;
    
    @Transactional(rollbackFor = {Exception.class})
    public User createPartner(String first_name, String last_name, String addres, Integer dni, Integer cuit, Gender gender, String email, Date birth_date, Cities city, Integer phone, String password, String matricula) throws Exception {
        
        validar(first_name, last_name, addres, dni, cuit, email, birth_date, phone, password);
        
        User user = new User();
        
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setAddres(addres);
        user.setDni(dni);
        user.setCuit(cuit);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirth_date(birth_date);
        user.setPhone(phone);
        user.setCity(city);
        user.setMatricula(matricula);
        user.setActive(true);
        
        user.setCreated_at(new Date());
        user.setUpdated_at(null);
        user.setSubscribe_at(new Date());
        user.setUnsubscribe_at(null);
        
        user.setRol(Rol.PARTNER);
        user.setCargo(null);
        user.setPhoto(null);
        
        user.setPassword(password);
//        String encryptedPassword = new BCryptPasswordEncoder().encode(password);
//        user.setPassword(encryptedPassword);

        return userRepository.save(user);
    }
    
    @Transactional(rollbackFor = {Exception.class})
    public void modify(MultipartFile archive, String id, String first_name, String last_name, String addres, Integer dni, Integer cuit, Gender gender, String email, Date birth_date, Cities city, Integer phone, String password, String matricula) throws Exception {
        
        validar(first_name, last_name, addres, dni, cuit, email, birth_date, phone, password);
        
        Optional<User> respuesta = userRepository.findById(id);
        
        if (respuesta.isPresent()) {
            
            User user = respuesta.get();
            
            user.setFirst_name(first_name);
            user.setLast_name(last_name);
            user.setAddres(addres);
            user.setDni(dni);
            user.setCuit(cuit);
            user.setEmail(email);
            user.setGender(gender);
            user.setBirth_date(birth_date);
            user.setPhone(phone);
            user.setCity(city);
            user.setMatricula(matricula);
            user.setUpdated_at(new Date());
            
            if (archive != null) {
                String photoId = null;
                if (user.getPhoto() != null) {

                    photoId = user.getPhoto().getId();
                }
                Photo photo = photoService.modify(archive, photoId);
                user.setPhoto(photo);
            }
            userRepository.save(user);
        } else {
            throw new Exception("El usuario no ha sido encontrado");
        }
    }
    
    @Transactional(rollbackFor = {Exception.class})
    public void addAuthority(String id, MultipartFile archive, Cargo cargo) throws Exception {
        
        Optional<User> respuesta = userRepository.findById(id);
        
        if (respuesta.isPresent()) {
            
            User user = respuesta.get();
            
            user.setCargo(cargo);
            user.setRol(Rol.AUTHORITY);
            user.setUpdated_at(new Date());
            
            if (archive != null) {
                String photoId = null;
                if (user.getPhoto() != null) {

                    photoId = user.getPhoto().getId();
                }
                Photo photo = photoService.modify(archive, photoId);
                user.setPhoto(photo);
            }
            userRepository.save(user);
        } else {
            throw new Exception("El usuario no ha sido encontrado");
        }
    }
    
    @Transactional(readOnly = true)
    public User findById(String id) throws Exception {
        Optional<User> respuesta = userRepository.findById(id);
        if (respuesta.isPresent()) {
            return respuesta.get();
        } else {
            throw new Exception("El usuario no ha sido encontrado");
        }
    }
    
    @Transactional(readOnly = true)
    public List<User> userList() {
        return userRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public List<User> userPartnerList() {
        return userRepository.findParteners(Rol.PARTNER);
    }
    
    @Transactional(readOnly = true)
    public List<User> userAuthorityList() {
        return userRepository.findAuthorities(Rol.AUTHORITY);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public User enable(String id) throws Exception {
        Optional<User> respuesta = userRepository.findById(id);
        if (respuesta.isPresent()) {
            User user = respuesta.get();
            user.setActive(true);
            return userRepository.save(user);
        } else {
            throw new Exception("El usuario no ha sido encontrado");
        }
    }
    
    @Transactional(rollbackFor = Exception.class)
    public User disable(String id) throws Exception {
        Optional<User> respuesta = userRepository.findById(id);
        if (respuesta.isPresent()) {
            User user = respuesta.get();
            user.setActive(false);
            return userRepository.save(user);
        } else {
            throw new Exception("El usuario no ha sido encontrado");
        }
    }
    
    private void validar(String first_name, String last_name, String addres, Integer dni, Integer cuit, String email, Date birth_date, Integer phone, String password) throws Exception {
        if (first_name == null || first_name.trim().isEmpty()) {
            throw new Exception("Debe ingresar su nombre");
        }
        if (last_name == null || last_name.trim().isEmpty()) {
            throw new Exception("Debe ingresar su apellido");
        }
        if (addres == null || addres.trim().isEmpty()) {
            throw new Exception("Debe ingresar su dirección de domicilio");
        }
        if (dni == null || dni < 8) {
            throw new Exception("El numero de dni ingresado no es correcto");
        }
        if (cuit == null || cuit < 11) {
            throw new Exception("El numero de cuit ingresado no es correcto");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new Exception("Debe ingresar su correo electrónico");
        }
        if (birth_date == null) {
            throw new Exception("Debe ingresar su fecha de nacimiento");
        }
        if (phone == null || phone < 10) {
            throw new Exception("El numero de telefono ingresado no es correcto");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new Exception("Debe ingresar una contraseña");
        }
    }
    
}
