    CREATE DATABASE ZoomCar;
    USE DATABASE ZoomCar;
    
    CREATE TABLE USER(    
        USER_ID VARCHAR(30) PRIMARY KEY,          
        USER_NAME TEXT,          
        GENDER VARCHAR(1),          
        DOB DATE,          
        E_MAIL TEXT,          
        PHONE TEXT,     
        PASSWORD TEXT 
    );
    
    CREATE TABLE CAR(    
        CAR_ID INTEGER PRIMARY KEY, 
        IMG_URL TEXT, 
        COST_PER_DAY FLOAT,        
        NUMBER_PLATE TEXT,          
        COMPANY TEXT,          
        MODEL TEXT,          
        VERSION TEXT,          
        COLOR TEXT,          
        FUEL_TYPE TEXT,          
        CAR_TYPE TEXT,          
        GEAR_TYPE TEXT,          
        AC BOOLEAN,          
        LEATHER_SEATS BOOLEAN,          
        SUNROOF BOOLEAN 
    );
    
    CREATE TABLE TRANSACTION( 
        USER_ID VARCHAR(30) REFERENCES USER,
        CAR_ID INTEGER REFERENCES CAR,
        START_DATE DATE,
        END_DATE DATE,
        DATE_OF_REQUEST DATE,
        PRIMARY KEY(USER_ID , CAR_ID , START_DATE , END_DATE)
    );

