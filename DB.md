    CREATE DATABASE ZoomCar;
    USE ZoomCar;
    
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
    
    insert into CAR values (1,'https://imgd.aeplcdn.com/1056x594/n/ns5dora_1420343.jpg?q=80',2700,'KL416446','Maruti Suzuki','Alto 800','STD','Grey','Petrol','Hatchback','MT',false,false,false);
    insert into CAR values (2,'https://auto.ndtvimg.com/car-images/gallery/maruti-suzuki/alto-800/exterior/maruti-suzuki-alto800-front-view.jpg?v=2016-06-01',3900,'KL818878','Maruti Suzuki','Alto 800','LXI','Green','CNG','Hatchback','MT',true,false,false);
    insert into CAR values (3,'https://5.imimg.com/data5/SC/KW/MY-25580384/maruti-suzuki-omni-500x500.png',3000,'KL415772','Maruti Suzuki','Omni','STR','White','Petrol','MUV','MT',false,false,false);
    
    insert into CAR values (4,'https://www.drivespark.com/car-image/640x480x100/car/300x225x2709575-maruti_wagonr.jpg.pagespeed.ic.kDGFbu7l2Q.jpg',5000,'TN333145','Maruti Suzuki','Wagon R','LXI','Blue','CNG','Hatchback','AT',true,true,false);
    insert into CAR values (5,'https://auto.ndtvimg.com/car-images/big/maruti-suzuki/alto-k10/maruti-suzuki-alto-k10.jpg?v=22',3400,'KL997227','Maruti Suzuki','Alto k10','LX','Orange','Petrol','Hatchback','MT',true,false,false);
    insert into CAR values (6,'https://imgd.aeplcdn.com/1056x594/n/m8beora_1420352.jpg?q=80',4300,'KL776116','Maruti Suzuki','Alto k10','LXI','Grey','CNG','Hatchback','MT',true,false,false);
    
    insert into CAR values (7,'https://imgd.aeplcdn.com/1056x594/cw/ec/32953/Hyundai-Elite-i20-Exterior-118748.jpg?wm=0&q=80',7900,'DL012116','Hyundai','Elite i20','Sportz','Blue','Diesel','Hatchback','MT',true,true,true);
    insert into CAR values (8,'http://www.hyundai.com/wcm/idc/groups/sgvehiclecontent/@in/documents/sitecontent/mdaw/mte1/~edisp/in_gal_ext_ib_feb_03.jpg',8200,'UP339196','Hyundai','Elite i20','Asta','Orange','Petrol','Hatchback','AT',true,true,true);
    insert into CAR values (9,'https://auto.ndtvimg.com/car-images/big/honda/city/honda-city.jpg?v=19',10600,'MH135496','Honda','City','V','Red','Petrol','Sedan','MT',true,true,false);
    
    insert into CAR values (10,'http://s2.glbimg.com/iB1U0csvqPlTzSOT1FGoBAP4_sw=/620x413/e.glbimg.com/og/ed/f/original/2017/01/16/city01.jpg',12000,'UP318155','Maruti Suzuki','Wagon R','V-CVT','Blue','Petrol','Sedan','AT',true,true,false);
    insert into CAR values (11,'https://auto.ndtvimg.com/car-images/big/hyundai/new-santro/hyundai-new-santro.jpg?v=9',5000,'JK796828','Hyundai','Santro','Sportz','Brown','Petrol','Hatchback','MT',true,false,false);
    insert into CAR values (12,'https://auto.ndtvimg.com/car-images/big/hyundai/new-santro/hyundai-new-santro.jpg?v=9',5400,'AP818960','Hyundai','Santro','Magna','Brown','Petrol','Hatchback','AT',true,false,false);
    
    insert into CAR values (13,'https://imgd.aeplcdn.com/1056x594/cw/ec/34457/Honda-CRV-Exterior-137861.jpg?v=20180910155558&wm=1&q=80',28000,'KA013117','Honda','CRV','2WD Petrol','Red','Petrol','SUV','AT',true,true,true);
    insert into CAR values (14,'https://cache2.pakwheels.com/system/car_generation_pictures/4772/original/Honda_CR-V.jpg?1519205461',30000,'KA800881','Honda','CRV','2WD Diesel','White','Diesel','MUV','AT',true,true,true);
    insert into CAR values (15,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4dGtG5JFoGAdt6QU46i5eHxSoYWeno8jTW5WIGPjGdn1XDkIs',14700,'BR773939','Toyota','Innova Crysta','GX 7 STR','Brown','Petrol','MUV','MT',true,true,false);
    insert into CAR values (16,'https://imgd.aeplcdn.com/1056x594/cw/ec/31883/Mahindra-Scorpio-Exterior-113863.jpg?wm=0&q=80',10000,'UK186167','Mahindra','Scorpio','S3 2WD STR','White','Diesel','MUV','AT',true,true,false);
    insert into CAR values (17,'https://imgd.aeplcdn.com/1056x594/cw/ec/26944/Mahindra-Marazzo-Exterior-134818.jpg?wm=0&q=80',10000,'WB801231','Mahindra','Marazzo','M2 7 STR','Black','Diesel','MUV','MT',true,true,false);
    insert into CAR values (18,'https://imgd.aeplcdn.com/1056x594/cw/ec/20780/Ford-Endeavour-Right-Front-Three-Quarter-60426.jpg?v=201711021421&q=80',30000,'KL575512','Ford','Endevour','Titanium','Red','Diesel','SUV','AT',true,true,true);
    
    insert into CAR values (19,'https://www.jeffdrennenford.com/inventoryphotos/5939/maj3p1te0jc190474/sp/1.jpg',7900,'GJ1428825','Ford','Ecosport','Ambient','Orange','Petrol','MUV','MT',true,true,false);
    insert into CAR values (20,'https://imgd.aeplcdn.com/1056x594/cw/ec/25465/Hyundai-Verna-Exterior-118764.jpg?wm=0&q=80',10600,'GJ353296','Hyundai','Verna','VTVT','Coffee','Petrol','Sedan','AT',true,true,false);
    insert into CAR values (21,'https://imgd.aeplcdn.com/1056x594/cw/ec/25465/Hyundai-Verna-Exterior-118764.jpg?wm=0&q=80',12000,'GJ353277','Hyundai','Verna','CRDi','Coffee','Diesel','Sedan','AT',true,true,false);

