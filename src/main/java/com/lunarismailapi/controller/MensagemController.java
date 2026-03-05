package com.lunarismailapi.controller;

import com.lunarismailapi.model.Mensagem;
import com.lunarismailapi.service.MensagemService;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MensagemController {
    final MensagemService mensagemService;
    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }
    @PostMapping("/enviar-email")
    public ResponseEntity<String> enviarEmail(@RequestBody Mensagem mensagem) {
        try{
            mensagemService.enviarEmail(mensagem);
            return ResponseEntity.ok().body("Email enviado com sucesso!");
        }catch (MessagingException | IOException ex){
            return ResponseEntity.internalServerError().body("Erro ao enviar email: "+ex.getMessage());
        }
    }
}
