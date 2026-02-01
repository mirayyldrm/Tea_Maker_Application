CREATE DATABASE tea_maker_db;
USE tea_maker_db;

CREATE TABLE tea_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    num_cups INT NOT NULL,
    log_date DATETIME DEFAULT CURRENT_TIMESTAMP
);
