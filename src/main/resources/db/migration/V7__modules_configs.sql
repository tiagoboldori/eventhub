--  ============================== CONFIGURAÇÃO DE PRESENÇA ========================

CREATE TABLE presence_config (

    id BIGSERIAL PRIMARY KEY,

    event_module_id BIGINT NOT NULL UNIQUE,

    enabled BOOLEAN NOT NULL DEFAULT TRUE,

    require_name BOOLEAN NOT NULL DEFAULT TRUE,

    require_phone BOOLEAN NOT NULL DEFAULT FALSE,

    require_email BOOLEAN NOT NULL DEFAULT FALSE,

    allow_guest BOOLEAN NOT NULL DEFAULT TRUE,

    allow_multiple_checkins BOOLEAN NOT NULL DEFAULT FALSE,

    CONSTRAINT fk_presence_config_module
    FOREIGN KEY (event_module_id)
        REFERENCES event_modules(id)
        ON DELETE CASCADE

);






--  ============================== CONFIGURAÇÃO DE MURAL ========================
CREATE TABLE wall_config (

    id BIGSERIAL PRIMARY KEY,

    event_module_id BIGINT NOT NULL UNIQUE,

    enabled BOOLEAN NOT NULL DEFAULT TRUE,

    anonymous BOOLEAN NOT NULL DEFAULT FALSE,

    allow_images BOOLEAN NOT NULL DEFAULT FALSE,

    moderation BOOLEAN NOT NULL DEFAULT FALSE,

    max_message_length INTEGER NOT NULL DEFAULT 500,

    CONSTRAINT fk_wall_config_module
    FOREIGN KEY (event_module_id)
        REFERENCES event_modules(id)
        ON DELETE CASCADE

);



--  ============================== CONFIGURAÇÃO DE VOTAÇÃO ========================
CREATE TABLE poll_config (
    id BIGSERIAL PRIMARY KEY,

    event_module_id BIGINT NOT NULL UNIQUE,

    enabled BOOLEAN NOT NULL DEFAULT TRUE,

    -- anonymous_vote BOOLEAN NOT NULL DEFAULT FALSE,

    allow_vote_change BOOLEAN NOT NULL DEFAULT TRUE,

    show_partial_results BOOLEAN NOT NULL DEFAULT FALSE,

    show_final_results BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT fk_poll_config_module
    FOREIGN KEY (event_module_id)
        REFERENCES event_modules(id)
        ON DELETE CASCADE
);