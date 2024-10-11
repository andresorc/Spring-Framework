package com.andres.curso.sppringboot.webap.springboot_web.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.sppringboot.webap.springboot_web.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required=false,defaultValue = "Hola que tal") String message){
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message!=null? message : "hola");
        return paramDto;
    }
    @GetMapping("/bar")
    public ParamDto bar(@RequestParam String text, @RequestParam int code) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(text);
        paramDto.setCode(code);
        return paramDto;
    }
    @GetMapping("/request")
    public ParamDto bar(HttpServletRequest request) {
        // Acceder a los parámetros "text" y "code" de la solicitud de forma nativa
        String text = request.getParameter("text");
        String codeParam = request.getParameter("code");

        // Manejo de posibles valores nulos
        if (text == null) {
            text = "Valor predeterminado"; // Asignar un valor predeterminado si es null
        }

        int code = 0; // Código predeterminado en caso de que falte o no sea válido
        try {
            if (codeParam != null) {
                code = Integer.parseInt(codeParam); // Convertir el código a int si existe
            }
        } catch (NumberFormatException e) {
            // Manejar excepción si el parámetro "code" no es un número válido
            code = -1; // Valor por defecto si el código no es válido
        }

        // Crear y devolver el objeto ParamDto
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(text);
        paramDto.setCode(code);
        return paramDto;
    }
}


