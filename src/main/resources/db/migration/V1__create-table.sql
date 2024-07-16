CREATE TABLE email (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email_from VARCHAR(100) NOT NULL,
    email_to VARCHAR(100) NOT NULL,
    subject VARCHAR(100) NOT NULL,
    text VARCHAR(250) NOT NULL,
    send_date_email DATETIME NOT NULL,
    status_email VARCHAR(100) NOT NULL
);