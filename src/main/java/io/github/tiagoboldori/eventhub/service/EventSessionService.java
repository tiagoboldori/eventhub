package io.github.tiagoboldori.eventhub.service;

import io.github.tiagoboldori.eventhub.entity.Event;
import io.github.tiagoboldori.eventhub.entity.EventSession;
import io.github.tiagoboldori.eventhub.repository.EventSessionRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Service
public class EventSessionService {

    private static final String COOKIE_NAME = "eh_session";

    private final EventSessionRepository eventSessionRepository;

    public EventSessionService(EventSessionRepository eventSessionRepository) {
        this.eventSessionRepository = eventSessionRepository;
    }

    public EventSession getOrCreateSession(
            Event event,
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        String sessionToken = getOrCreateSessionToken(request, response);

        return eventSessionRepository
                .findByEventIdAndSessionToken(event.getId(), sessionToken)
                .map(this::updateAccess)
                .orElseGet(() -> createSession(event, sessionToken));
    }

    private String getOrCreateSessionToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            Cookie cookie = Arrays.stream(cookies)
                    .filter(c -> COOKIE_NAME.equals(c.getName()))
                    .findFirst()
                    .orElse(null);

            if (cookie != null) {
                return cookie.getValue();
            }
        }

        String sessionToken = UUID.randomUUID().toString();

        Cookie cookie = new Cookie(COOKIE_NAME, sessionToken);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24 * 365);

        response.addCookie(cookie);

        return sessionToken;
    }

    private EventSession updateAccess(EventSession session) {

        session.setLastAccess(LocalDateTime.now());
        session.setAccessCount(session.getAccessCount() + 1);

        return eventSessionRepository.save(session);
    }

    private EventSession createSession(
            Event event,
            String sessionToken
    ) {

        EventSession eventSession = new EventSession();

        eventSession.setEvent(event);
        eventSession.setSessionToken(sessionToken);
        eventSession.setAccessCount(1);
        eventSession.setLastAccess(LocalDateTime.now());

        return eventSessionRepository.save(eventSession);
    }


    public EventSession save(EventSession eventSession){
        return eventSessionRepository.save(eventSession);
    }
}