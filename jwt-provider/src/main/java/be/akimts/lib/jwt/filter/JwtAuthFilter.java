package be.akimts.lib.jwt.filter;

import be.akimts.lib.jwt.utils.JwtProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtProvider provider;

    public JwtAuthFilter(JwtProvider provider) {
        this.provider = provider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = provider.extractToken(request);

        if(token != null && provider.validateToken(token) ){
            Authentication auth = provider.generateAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication( auth );
        }

        filterChain.doFilter(request, response);

    }
}
