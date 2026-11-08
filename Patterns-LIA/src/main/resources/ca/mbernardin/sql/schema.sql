CREATE TABLE IF NOT EXISTS User (
    user_id INTEGER,
    full_name TEXT NOT NULL,
    email TEXT NOT NULL,
    age INTEGER NOT NULL CHECK (age > 0),
    usertype TEXT NOT NULL,
    CONSTRAINT PK_User PRIMARY KEY (user_id AUTOINCREMENT),
    CONSTRAINT UNIQUE_User_Email UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS Credentials (
    credential_id INTEGER,
    user_id INTEGER,
    password_hash TEXT NOT NULL,
    CONSTRAINT PK_Credentials PRIMARY KEY (credential_id AUTOINCREMENT),
    CONSTRAINT FK_User_Credentials FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Conference (
    conference_id INTEGER,
    title TEXT NOT NULL,
    capacity INTEGER NOT NULL CHECK (capacity > 0),
    start_date DATE NOT NULL CHECK (start_date < end_date),
    end_date DATE NOT NULL CHECK (end_date > start_date),
    location TEXT NOT NULL,
    CONSTRAINT PK_Conference PRIMARY KEY (conference_id AUTOINCREMENT)
);

CREATE TABLE IF NOT EXISTS Subscription (
    subscription_id INTEGER,
    user_id INTEGER NOT NULL,
    conference_id INTEGER NOT NULL,
    waitinglist_status TEXT NOT NULL,
    waitinglist_position DATE NOT NULL,
    CONSTRAINT PK_Subscription PRIMARY KEY (subscription_id AUTOINCREMENT),
    CONSTRAINT FK_Subscription_User FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE,
    CONSTRAINT FK_Subscription_Conference FOREIGN KEY (conference_id) REFERENCES Conference(conference_id) ON DELETE CASCADE
);
