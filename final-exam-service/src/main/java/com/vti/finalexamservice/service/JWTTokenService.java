package com.vti.finalexamservice.service;

import com.vti.finalexamservice.config.sercurity.model.Token;
import com.vti.finalexamservice.config.token.JWTConfig;
import com.vti.finalexamservice.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JWTTokenService {
    @Autowired
    private TokenRepository repository;

    public Token findByToken(String key){
        key = key.substring(JWTConfig.tokenPrefix.length()).trim();
        Token token = null;
        if (repository.findByToken(key).isPresent()){
            token = repository.findByToken(key).get();
        }
        return token;
    }

    public Token save(Token token){
        try {
            token = repository.save(token);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return token;
    }


}
