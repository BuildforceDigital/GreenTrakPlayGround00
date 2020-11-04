-- SET schema "DEV_GREENTRAK00";
create schema DEV_GREENTRAK00;

create table DEV_GREENTRAK00.A0000USERS (
                                       ID                 LONGVARBINARY,
                                       "BirthDay"         varchar(36),
                                       "BusinessEmail"    varchar(10),
                                       "CitizenServiceNr" varchar(36),
                                       "FullName"         varchar(40),
                                       "Gender"           varchar(10),
                                       "JobFunction"      varchar(36),
                                       "LandlinePhone"    varchar(40),
                                       "MobilePhone"      varchar(40),
                                       "Nationality"      varchar(40),
                                       "Nickname"         varchar(40),
                                       "PrivateEmail"     varchar(40),
                                       "TillDate"         TIMESTAMP WITH TIME ZONE,
                                       "UserName"         varchar(40),
                                       "UserImage"        varchar(40),
                                       PRIMARY KEY (ID));

INSERT INTO DEV_GREENTRAK00.A0000USERS VALUES ('04a47a9852374cc8b2fac629bd8f019e', 'Bd', 'Be', 'Csnr', 'TestActor05', 'M', 'Jf', 'lp', 'mp', 'nat', 'Jan',    'pe', '2020-05-01', 'us', null);
INSERT INTO DEV_GREENTRAK00.A0000USERS VALUES ('4e65220e9332442eb0bcd1b5b16c1db8', 'Bd', 'Be', 'Csnr', 'Fn1', 'M', 'Jf', 'lp', 'mp', 'nat', 'Jan',    'pe', '2020-05-01', 'us', null);
INSERT INTO DEV_GREENTRAK00.A0000USERS VALUES ('9dfa89d32387455ebe800ed77c200fa3', 'Bd', 'Be', 'Csnr', 'Fn2', 'M', 'Jf', 'lp', 'mp', 'nat', 'Piet',   'pe', '2020-05-01', 'us', null);
INSERT INTO DEV_GREENTRAK00.A0000USERS VALUES ('a7de5d729e0343419e7da348aaa8eac2', 'Bd', 'Be', 'Csnr', 'Fn3', 'M', 'Jf', 'lp', 'mp', 'nat', 'Klaas',  'pe', '2020-05-01', 'us', null);
INSERT INTO DEV_GREENTRAK00.A0000USERS VALUES ('caa70247ad7c4b688949edec7e879ae2', 'Bd', 'Be', 'Csnr', 'Fn4', 'M', 'Jf', 'lp', 'mp', 'nat', 'Willem', 'pe', '2020-05-01', 'us', null);
INSERT INTO DEV_GREENTRAK00.A0000USERS VALUES ('f2a3b1deee884b2885729d6afc856116', 'Bd', 'Be', 'Csnr', 'Anita', 'F', 'Jf', 'lp', 'mp', 'nat', 'Anita',  'pe', '2020-05-01', 'us', '../media/Woman_avatar_02.png');

CREATE TABLE DEV_GREENTRAK00."AttendanceEventsAll"
(
    ID                 INTEGER       NOT NULL,
    "CheckInDateTime"  TIMESTAMP WITH TIME ZONE     NOT NULL,
    "ProjOwner"        VARCHAR(36)   NOT NULL,
    "ProjectCode"      VARCHAR(10)   NOT NULL,
    "TermGuidIn"       VARCHAR(36)   NOT NULL,
    "UserID"           LONGVARBINARY NOT NULL,
    "UserName"         VARCHAR(40)   NOT NULL,
    "AggApprTime"      VARCHAR(255),
    "AggStartDate"     DATE,
    "AggTotalTime"     VARCHAR(255),
    "ApprovalBy"       VARCHAR(40),
    "ApprovalDateTime" TIMESTAMP WITH TIME ZONE,
    "CheckOutDateTime" TIMESTAMP WITH TIME ZONE,
    "Description"      VARCHAR(160),
    "Remarks"          VARCHAR(480),
    "TermGuidOut"      VARCHAR(36),
    PRIMARY KEY (ID)
);

INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"(ID, "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "UserName", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (0, '2020-01-16 16:42:54.037088+01:00', 'WH&FF', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'TestActor05', 'AggApprTime', '2020-02-16', 'AggTotalTime', null, null, null, null, null, null);
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"(ID, "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "UserName", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (1, '2020-01-16 16:42:54.037088+01:00', 'WH&FF', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'TestActor05', 'AggApprTime', '2020-02-16', 'AggTotalTime', null, null, '2020-01-16 18:22:54.037088+01:00', null, null, 'TERMINAL0000001');
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"(ID, "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "UserName", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (2, '2020-01-16 16:42:54.037088+01:00', 'WH&FF', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'TestActor05', 'AggApprTime', '2020-02-16', 'AggTotalTime', 'FvdB', '2020-02-16 17:42:54.037088+02:00', '2020-01-16 16:22:54.037088+01:00', 'Tieback poured', null, 'TERMINAL0000001');
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"(ID, "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "UserName", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (3, '2020-05-16 17:42:54.037088+02:00', 'Heijmans Infra', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'TestActor05', 'AggApprTime', '2020-05-16', 'AggTotalTime', null, null, null, null, null, null);
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"(ID, "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "UserName", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (4, '2020-05-16 15:42:54.037088+02:00', 'Heijmans Infra', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'TestActor05', 'AggApprTime', '2020-05-16', 'AggTotalTime', null, null, '2020-05-16 18:22:54.037088+01:00', null, null, 'TERMINAL0000001');
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"(ID, "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "UserName", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (5, '2020-05-16 13:42:54.037088+02:00', 'Heijmans Infra', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'TestActor05', 'AggApprTime', '2020-05-16', 'AggTotalTime', 'FvdB',     '2020-05-16 17:42:54.037088+02:00', '2020-05-16 16:22:54.037088+01:00', 'Tieback poured', null, 'TERMINAL0000001');
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"(ID, "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "UserName", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (6, '2020-05-16 10:00:00+02:00', 'Heijmans Infra', 'ZUIDPLUS00', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'TestActor05', 'AggApprTime', '2020-05-16', 'AggTotalTime', 'FvdB',            '2020-05-16 17:42:54.037088+02:00', '2020-05-16 16:22:54.037088+01:00', 'Tieback poured', null, 'TERMINAL0000001');
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"(ID, "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "UserName", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (10,'2020-05-16 10:00:00+02:00', 'Heijmans Infra', 'ZUIDPLUS00', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'TestActor05', 'AggApprTime', '2020-05-16', 'AggTotalTime', 'FvdB',              '2020-05-16 17:42:54.037088+02:00', '2020-05-16 16:22:54.037088+01:00', 'Tieback poured', null, 'TERMINAL0000001');
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"(ID, "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "UserName", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (11,'2020-05-16 10:00:00+02:00', 'Heijmans Infra', 'ZUIDPLUS00', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'TestActor05', 'AggApprTime', '2020-05-16', 'AggTotalTime', 'FvdB',              '2020-05-16 17:42:54.037088+02:00', '2020-05-16 16:22:54.037088+01:00', 'Tieback poured', null, 'TERMINAL0000001');

ALTER TABLE DEV_GREENTRAK00."AttendanceEventsAll" ADD CONSTRAINT "FK_AttendanceEventsAll_UserID" FOREIGN KEY ("UserID") REFERENCES DEV_GREENTRAK00.A0000USERS (ID);


create table DEV_GREENTRAK00.P0000PROJECTS(
                                              "Id"          INTEGER not null constraint P0000PROJECTS_PK primary key,
                                              "StartDate"   TIMESTAMP WITH TIME ZONE,
                                              "ProjectName" VARCHAR(20),
                                              "ProjectCode" VARCHAR(20),
                                              "ProjOwner"   VARCHAR(20),
                                              "Description" VARCHAR(320)
);

create table DEV_GREENTRAK00."P0000ProjMembers"(
                                                   "P0000ProjectId" INTEGER,
                                                   "A0000UserId"    LONGVARBINARY
);

INSERT INTO DEV_GREENTRAK00."P0000ProjMembers" VALUES (0, 'f2a3b1deee884b2885729d6afc856116');

INSERT INTO DEV_GREENTRAK00.P0000PROJECTS VALUES ( 0, '2020-05-16 12:00:00.000000+02:00', 'Zuidasdok', 'ZUIDPLUS00', 'Heijmans Infra',
'De verbreding van 4 naar 6 rijstroken en ondergronds brengen van Rijksweg A10 Zuid;
De herinrichting van de verkeersknooppunten Amstel en De Nieuwe Meer;
Het uitbreiden en vernieuwen van het station Amsterdam Zuid;
Het opnieuw inrichten van het stationsgebied.');