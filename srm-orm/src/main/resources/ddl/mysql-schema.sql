DROP TABLE
    IF EXISTS srm_user;
CREATE TABLE
    srm_user
    (
        id INT(19) auto_increment PRIMARY KEY,
        name VARCHAR(255) NOT NULL UNIQUE,
        password VARCHAR(60),
        nickname VARCHAR(255),
        birthday TIMESTAMP,
        gender INT(1),
        company_id INT(19),
        company_admin_flag INT(1),
        system_admin_flag INT(1),
        status INT(1) NULL DEFAULT 0,
        create_time TIMESTAMP,
        modify_time TIMESTAMP,
        creator INT(19),
        modifier INT(19)
    )
    engine=innodb;
DROP TABLE
    IF EXISTS srm_company;
CREATE TABLE
    srm_company
    (
        id INT(19) auto_increment PRIMARY KEY,
        name VARCHAR(255) NOT NULL UNIQUE,
        description VARCHAR(2000),
        website VARCHAR(255),
        address VARCHAR(255),
        zipcode VARCHAR(6),
        status INT(1) NULL DEFAULT 0,
        create_time TIMESTAMP,
        modify_time TIMESTAMP,
        creator INT(19),
        modifier INT(19)
    )
    engine=innodb;