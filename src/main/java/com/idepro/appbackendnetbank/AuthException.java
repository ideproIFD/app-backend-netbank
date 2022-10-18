package com.idepro.appbackendnetbank;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idepro.appbackendnetbank.model.Response;
import com.idepro.appbackendnetbank.model.Usuario;
import com.idepro.appbackendnetbank.util.ConstantsUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthException implements AuthenticationEntryPoint {
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
			throws IOException, ServletException {
		final Map<String, Object> mapException = new HashMap<>();

//		mapException.put("error", "401");
		mapException.put("mensaje", ConstantsUtil.PARAM_MENSAJE_RECURSO_NO_AUTORIZADO);
		mapException.put("estado", ConstantsUtil.PARAM_ESTADO_NOK);
		mapException.put("fecha", (new Date()).getTime());
		mapException.put("data", null);
//		mapException.put("path", request.getServletPath());


		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), mapException);
	}
}