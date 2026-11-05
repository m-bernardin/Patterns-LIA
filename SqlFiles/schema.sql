CREATE TABLE User (
    user_id INTEGER,
    full_name TEXT NOT NULL,
    email TEXT NOT NULL,
    age INTEGER NOT NULL,
    password TEXT NOT NULL,
    usertype TEXT NOT NULL,
    CONSTRAINT PK_User PRIMARY KEY (user_id AUTOINCREMENT),
    CONSTRAINT UNIQUE_User_Fullname UNIQUE (full_name),
    CONSTRAINT UNIQUE_User_Email UNIQUE (email)
);

CREATE TABLE Conference (
    conference_id INTEGER,
    title TEXT NOT NULL,
    capacity INTEGER NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    location TEXT NOT NULL,
    CONSTRAINT PK_Conference PRIMARY KEY (conference_id AUTOINCREMENT)
);

CREATE TABLE Subscription (
    subscription_id INTEGER,
    user_id INTEGER NOT NULL,
    conference_id INTEGER NOT NULL,
    is_on_waiting_list TEXT NOT NULL,
    CONSTRAINT PK_Subscription PRIMARY KEY (subscription_id AUTOINCREMENT),
    CONSTRAINT FK_Subscription_User FOREIGN KEY (user_id) REFERENCES User(user_id) ON DELETE CASCADE,
    CONSTRAINT FK_Subscription_Conference FOREIGN KEY (conference_id) REFERENCES Conference(conference_id) ON DELETE CASCADE
);
