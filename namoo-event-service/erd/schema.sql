DROP TABLE IF EXISTS Event RESTRICT;

CREATE TABLE Event (
	id          INTEGER      PRIMARY KEY AUTO_INCREMENT, 
	name        VARCHAR(20)  NOT NULL, 
	openDate    VARCHAR      NULL,    
	summaryDes  VARCHAR(50)  NULL,     
	description VARCHAR(300) NULL,     
	small_type  VARCHAR(50)  NULL,     
	small_file  VARCHAR(50)  NULL,   
	large_type  VARCHAR(50)  NULL,     
	large_file  VARCHAR(50)  NULL     
);
