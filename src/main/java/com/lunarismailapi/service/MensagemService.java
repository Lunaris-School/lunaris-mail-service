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
        try (InputStream inputStream = resource.getInputStream()) {
            String html = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

            html = html.replace("${nomeAluno}", mensagem.getNomeAluno());
            html = html.replace("${conteudo}", mensagem.getConteudo());

            MimeMessage email = mailSender.createMimeMessage();
            MimeMessageHelper mensagemHp = new MimeMessageHelper(email, "UTF-8");

            mensagemHp.setTo(mensagem.getEmailProfessor());
            mensagemHp.setSubject(mensagem.getAssunto() + " - " + mensagem.getNomeAluno());
            mensagemHp.setText(html, true);

            mailSender.send(email);
        }
    }
}
