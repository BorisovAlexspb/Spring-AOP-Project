CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE orders (
                        id SERIAL PRIMARY KEY,
                        description VARCHAR(255),
                        status VARCHAR(255),
                        user_id INTEGER REFERENCES users(id) ON DELETE CASCADE
);
