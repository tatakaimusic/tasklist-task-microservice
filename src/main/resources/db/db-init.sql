CREATE TABLE IF NOT EXISTS tasks
(
    id              BIGSERIAL PRIMARY KEY,
    user_email      VARCHAR(255) NOT NULL,
    title           VARCHAR(255) NOT NULL,
    description     VARCHAR(255) NULL,
    status          VARCHAR(255) NOT NULL,
    expiration_date TIMESTAMP    NULL,
    FOREIGN KEY (user_email) REFERENCES users (email) ON DELETE CASCADE
);
