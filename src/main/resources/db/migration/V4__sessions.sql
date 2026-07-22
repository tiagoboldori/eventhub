CREATE TABLE event_sessions (

    id BIGSERIAL PRIMARY KEY,

    event_id BIGINT NOT NULL,

    session_token VARCHAR(255) NOT NULL,

    first_access TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    last_access TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    access_count INT NOT NULL DEFAULT 1,

    CONSTRAINT fk_event_session_event
        FOREIGN KEY (event_id)
            REFERENCES events(id)
            ON DELETE CASCADE,

    CONSTRAINT uk_event_session_device
        UNIQUE (event_id, session_token)

);