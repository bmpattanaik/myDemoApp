CREATE TABLE IF NOT EXISTS countries (
  id int(11) NOT NULL ,
  sortname varchar(3) NOT NULL,
  name varchar(150) NOT NULL,
  phonecode int(11) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS states (
  id int(11) NOT NULL ,
  name varchar(30) NOT NULL,
  country_id int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (id)
);
