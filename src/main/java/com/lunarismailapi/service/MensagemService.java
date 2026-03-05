package com.lunarismailapi.service;

import com.lunarismailapi.model.Mensagem;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class MensagemService {
    private final JavaMailSender mailSender;

    public MensagemService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    public void enviarEmail(Mensagem mensagem) throws MessagingException, IOException {
        ClassPathResource resource = new ClassPathResource("templates/emailTemplate.html");
        String html;
        try (InputStream inputStream = resource.getInputStream()) {
            html = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }

        html = html.replace("${nomeAluno}", mensagem.getNomeAluno());
        html = html.replace("${conteudo}", mensagem.getConteudo());

        MimeMessage email = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(email, true, "UTF-8");

        helper.setFrom("api@seudominio.com");
        helper.setTo(mensagem.getEmailProfessor());
        helper.setSubject(mensagem.getAssunto() + " - " + mensagem.getNomeAluno());
        helper.setText(html, true);

        mailSender.send(email);
    }
}
