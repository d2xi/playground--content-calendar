CREATE TABLE IF NOT EXISTS Content (
    id INTEGER AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    desc TEXT,
    status VARCHAR(20) NOT NULL,
    data_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255),
    PRIMARY KEY(id)
);