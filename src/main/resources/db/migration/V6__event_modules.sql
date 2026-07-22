CREATE TABLE event_modules (

   id BIGSERIAL PRIMARY KEY,

   event_id BIGINT NOT NULL,

   module_id BIGINT NOT NULL,

   enabled BOOLEAN NOT NULL DEFAULT TRUE,

   display_order INTEGER NOT NULL DEFAULT 0,

   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

   CONSTRAINT fk_event_modules_event
       FOREIGN KEY (event_id)
           REFERENCES events(id)
           ON DELETE CASCADE,

   CONSTRAINT fk_event_modules_module
       FOREIGN KEY (module_id)
           REFERENCES modules(id),

   CONSTRAINT uk_event_module
       UNIQUE(event_id,module_id)
);