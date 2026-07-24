CREATE TABLE event_sessions (

    id BIGSERIAL PRIMARY KEY,

    name VARCHAR(50),

    event_id BIGINT NOT NULL,

    session_token VARCHAR(255) NOT NULL,

    first_access TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    last_access TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    access_count INT NOT NULL DEFAULT 1,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    last_ip VARCHAR(45),

    last_user_agent VARCHAR(500),

    CONSTRAINT fk_event_session_event
        FOREIGN KEY (event_id)
            REFERENCES events(id)
            ON DELETE CASCADE,

    CONSTRAINT uk_event_session_token
        UNIQUE (event_id, session_token)

);

CREATE INDEX idx_event_session_event
    ON event_sessions(event_id);

CREATE INDEX idx_session_token
    ON event_sessions(session_token);