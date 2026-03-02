package com.lunarismailapi.service;

import com.lunarismailapi.model.Mensagem;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
public class MensagemService {
    private final JavaMailSender mailSender;

    public MensagemService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void enviarEmail(Mensagem mensagem) throws MessagingException, IOException {
        String html;

        ClassPathResource resource = new ClassPathResource("templates/emailTemplate.html");
        html = Files.readString(resource.getFile().toPath(), StandardCharsets.UTF_8);
        html = html.replace("${nomeAluno}", mensagem.getNomeAluno());
        html = html.replace("${conteudo}", mensagem.getConteudo());

        MimeMessage email = mailSender.createMimeMessage();
        MimeMessageHelper mensagemHp = new MimeMessageHelper(email);

        mensagemHp.setTo(mensagem.getEmailProfessor());
        mensagemHp.setSubject(mensagem.getAssunto() + " - " + mensagem.getNomeAluno());
        mensagemHp.setText(html,true);
        mailSender.send(email);
    }
}
