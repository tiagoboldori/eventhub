CREATE TABLE presence_confirmations (

    id BIGSERIAL PRIMARY KEY,

    event_session_id BIGINT NOT NULL UNIQUE,

    confirmed BOOLEAN NOT NULL,

    guest_count INTEGER NOT NULL DEFAULT 0,

    observation VARCHAR(500),

    confirmed_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_presence_session
        FOREIGN KEY (event_session_id)
            REFERENCES event_sessions(id)
            ON DELETE CASCADE

);

CREATE INDEX idx_presence_session
    ON presence_confirmations(event_session_id);




--==================================== MURAL/WALL ==============================

CREATE TABLE wall_messages (

   id BIGSERIAL PRIMARY KEY,

   event_session_id BIGINT NOT NULL,

   message VARCHAR(500) NOT NULL,

   highlighted BOOLEAN NOT NULL DEFAULT FALSE,

   deleted BOOLEAN NOT NULL DEFAULT FALSE,

   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

   updated_at TIMESTAMP,

   CONSTRAINT fk_wall_session
       FOREIGN KEY (event_session_id)
           REFERENCES event_sessions(id)
           ON DELETE CASCADE

);

CREATE INDEX idx_wall_session
    ON wall_messages(event_session_id);

CREATE INDEX idx_wall_created
    ON wall_messages(created_at);




--==================================== VOTAÇÃO/POLLS ==============================
CREATE TABLE polls (

    id BIGSERIAL PRIMARY KEY,

    event_module_id BIGINT NOT NULL,

    title VARCHAR(255) NOT NULL,

    description VARCHAR(500),

    multiple_choice BOOLEAN NOT NULL DEFAULT FALSE,

    active BOOLEAN NOT NULL DEFAULT TRUE,

    starts_at TIMESTAMP,

    ends_at TIMESTAMP,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_poll_module
        FOREIGN KEY (event_module_id)
            REFERENCES event_modules(id)
            ON DELETE CASCADE

);

CREATE INDEX idx_poll_module
    ON polls(event_module_id);

CREATE TABLE poll_options (

    id BIGSERIAL PRIMARY KEY,

    poll_id BIGINT NOT NULL,

    option_text VARCHAR(255) NOT NULL,

    display_order INTEGER NOT NULL DEFAULT 0,

    CONSTRAINT fk_poll_option
        FOREIGN KEY (poll_id)
            REFERENCES polls(id)
            ON DELETE CASCADE

);

CREATE INDEX idx_poll_option
    ON poll_options(poll_id);



CREATE TABLE poll_votes (

    id BIGSERIAL PRIMARY KEY,

    poll_option_id BIGINT NOT NULL,

    poll_id BIGINT NOT NULL,

    event_session_id BIGINT NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_vote_option
        FOREIGN KEY (poll_option_id)
            REFERENCES poll_options(id)
            ON DELETE CASCADE,

    CONSTRAINT fk_vote_session
        FOREIGN KEY (event_session_id)
            REFERENCES event_sessions(id)
            ON DELETE CASCADE,

    CONSTRAINT fk_vote_poll
        FOREIGN KEY (poll_id)
            REFERENCES polls(id)
            ON DELETE CASCADE

);

CREATE INDEX idx_vote_session
    ON poll_votes(event_session_id);

CREATE INDEX idx_vote_option
    ON poll_votes(poll_option_id);

CREATE UNIQUE INDEX uk_poll_session
    ON poll_votes(poll_id, event_session_id);

CREATE INDEX idx_vote_poll
    ON poll_votes(poll_id);