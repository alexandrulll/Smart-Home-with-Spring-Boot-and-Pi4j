CREATE TABLE alarm (
  id BIGINT NOT NULL,
  alarm_label varchar(255),
  generating_entity varchar(255),
  generating_value varchar(255),
  PRIMARY KEY (id)
 );
 
 CREATE TABLE humidity (
  id BIGINT NOT NULL,
  value double,
  timeStamp BIGINT,
  sensor_name varchar(255),
  measure_unit varchar(255),
  PRIMARY KEY (id)
 );
 
  CREATE TABLE temperature (
  id BIGINT NOT NULL,
  value double,
  timeStamp BIGINT,
  sensor_name varchar(255),
  measure_unit varchar(255),
  PRIMARY KEY (id)
 );
 
  CREATE TABLE motion (
  id BIGINT NOT NULL,
  timeStamp BIGINT,
  alert_text varchar(255),
  PRIMARY KEY (id)
 );
 
  CREATE TABLE dust (
  id BIGINT NOT NULL,
  timeStamp BIGINT,
  density_unit varchar(255),
  voltage_unit varchar(255),
  dust_density float,
  voltage float,
  PRIMARY KEY (id)
 );
 
  CREATE TABLE light (
  id BIGINT NOT NULL,
  timeStamp BIGINT,
  measureUnit varchar(255),
  full_spectrum double,
  infrared_spectrum double,
  visible_spectrum double,
  PRIMARY KEY (id)
 );