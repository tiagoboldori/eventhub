CREATE TABLE events(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    organizer_id BIGINT NOT NULL,
    access_token VARCHAR(100) UNIQUE,
    CONSTRAINT fk_organizer
           FOREIGN KEY(organizer_id)
           REFERENCES users(id)
           ON DELETE CASCADE
);