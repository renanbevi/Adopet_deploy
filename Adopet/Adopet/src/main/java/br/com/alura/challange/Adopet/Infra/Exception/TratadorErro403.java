package br.com.alura.challange.Adopet.Infra.Exception;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class TratadorErro403 implements AccessDeniedHandler {

    public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException ex) throws IOException, ServletException {
        res.setStatus(403);
        res.setContentType("application/json");
        res.getWriter().write("Acesso não autorizado");
    }
}

