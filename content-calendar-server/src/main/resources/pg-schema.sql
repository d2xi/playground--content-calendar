DROP TABLE IF EXISTS Content;

CREATE TABLE IF NOT EXISTS Content (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    "desc" TEXT,
    status VARCHAR(20) NOT NULL,
    type VARCHAR(20) NOT NULL,
    date_created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_updated TIMESTAMP,
    url VARCHAR(255)
);

INSERT INTO Content (title, status, "desc", type, url)
VALUES
    ('Sample Title 1', 'IDEA', 'Description for sample content 1.', 'VIDEO', ''),
    ('Sample Title 2', 'COMPLETED', 'Description for sample content 2.', 'COURSE', 'https://example.com/content2'),
    ('Sample Title 3', 'PUBLISHED', 'Description for sample content 3.', 'ARTICLE', 'https://example.com/content3');
