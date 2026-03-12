package com.lunarismailapi.service;

import com.lunarismailapi.model.Mensagem;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class MensagemService {

    private final JavaMailSender mailSender;
    private final String fromAddress;

    public MensagemService(
            JavaMailSender mailSender,
            @Value("${spring.mail.from:nao-responda@lunaris.com}") String fromAddress
    ) {
        this.mailSender = mailSender;
        this.fromAddress = fromAddress;
    }

    @Async
    public void enviarEmail(Mensagem mensagem) {
        try {

            String html = buildEmailHtml(mensagem);

            MimeMessage email = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(email, true, "UTF-8");

            helper.setFrom(fromAddress);
            helper.setTo(mensagem.getEmailProfessor());
            helper.setSubject(mensagem.getAssunto() + " - " + mensagem.getNomeAluno());
            helper.setText(html, true);

            mailSender.send(email);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar email", e);
        }
    }

    private String buildEmailHtml(Mensagem mensagem) throws Exception {

        ClassPathResource resource = new ClassPathResource("templates/emailTemplate.html");

        String html;
        try (InputStream inputStream = resource.getInputStream()) {
            html = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }

        html = html.replace("${nomeAluno}", mensagem.getNomeAluno());
        html = html.replace("${conteudo}", mensagem.getConteudo());

        return html;
    }
}