package borsch.membersservice.security;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class JwtTokenFilter extends OncePerRequestFilter {

    public static final String AUTH_HEADER = "Access-Token";

    private static final Set<String> KNOWN_TOKENS = Sets.newHashSet("token_1", "token_2", "token_3");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = request.getHeader(AUTH_HEADER);

        if (KNOWN_TOKENS.contains(accessToken)) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(accessToken, accessToken, Lists.newArrayList()));
        }

        filterChain.doFilter(request, response);
    }
}
