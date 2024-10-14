DROP TABLE Commit IF EXISTS;


CREATE TABLE Commit (
  id             varchar(100),
  repo_name      varchar(100) NOT NULL,
  commit_id      varchar(100) NOT NULL,
  commit_message varchar(100),
  author_name    varchar(100),
  author_email   varchar(100),
  payload        varchar(100),
  created_at     date,
  updated_at     date,
  PRIMARY KEY (id));