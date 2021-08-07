package com.pets.fibicado.petadoption.controller;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.pets.fibicado.petadoption.authentication.JwtTokenUtil;
import com.pets.fibicado.petadoption.dao.CustomerDAO;
import com.pets.fibicado.petadoption.model.JwtRequest;
import com.pets.fibicado.petadoption.model.JwtResponse;
import com.pets.fibicado.petadoption.model.LogoutRequest;
import com.pets.fibicado.petadoption.model.LogoutResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {



    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = customerDAO
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

   /* @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<?> logOutAuthenticationToken(@RequestBody JwtRequest logoutRequest) throws Exception {

        String jwtToken = "";//      logoutRequest.getJwtToken();

        JwtTokenUtil.logoutUserToken(jwtToken);

        return ResponseEntity.ok(new LogoutResponse("User logged out . Token invalidated "));
    }*/

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


}

