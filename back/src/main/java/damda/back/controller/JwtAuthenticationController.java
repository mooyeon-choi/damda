package damda.back.controller;

import damda.back.config.JwtTokenUtil;
import damda.back.dto.JwtRequestDto;
import damda.back.dto.JwtResponseDto;
import damda.back.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping("/signup")
    public ResponseEntity<Object> saveUser(@RequestBody JwtRequestDto authenticationRequest, Errors errors){
        if (errors.hasErrors()){
            return new ResponseEntity<>("User does not exist or empty request", HttpStatus.BAD_REQUEST);
        }
        userDetailsService.save(authenticationRequest);
        return ResponseEntity.ok("User created successfully");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDto authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLE", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponseDto(token));
    }
}
