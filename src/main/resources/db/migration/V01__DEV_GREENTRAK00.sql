-- SET schema "DEV_GREENTRAK00";
-- create schema DEV_GREENTRAK00;

create table DEV_GREENTRAK00.PROFILES (
                                       ID                 LONGVARBINARY,
                                       "BirthDate"        varchar(36),
                                       "BusinessEmail"    varchar(10),
                                       "CitizenServiceNr" varchar(36),
                                       "FullName"         varchar(40),
                                       "Gender"           varchar(10),
                                       "JobTitle"         varchar(36),
                                       "LandlinePhone"    varchar(40),
                                       "MobilePhone"      varchar(40),
                                       "Nationality"      varchar(40),
                                       "Nickname"         varchar(40),
                                       "PrivateEmail"     varchar(40),
                                       "TillDate"         TIMESTAMP WITH TIME ZONE,
                                       "UserName"         varchar(40),
                                       "ImageURL"         varchar(40),
                                       "Organization"     LONGVARBINARY,
                                       PRIMARY KEY (ID));

INSERT INTO DEV_GREENTRAK00.PROFILES VALUES ('04a47a9852374cc8b2fac629bd8f019e', 'Bd', 'Be', 'Csnr', 'TestActor05', 'M', 'Jf', 'lp', 'mp', 'nat', 'Jan',    'pe', '2020-05-01', 'us', null, null);
INSERT INTO DEV_GREENTRAK00.PROFILES VALUES ('4e65220e9332442eb0bcd1b5b16c1db8', 'Bd', 'Be', 'Csnr', 'Fn1', 'M', 'Jf', 'lp', 'mp', 'nat', 'Jan',    'pe', '2020-05-01', 'us', null, null);
INSERT INTO DEV_GREENTRAK00.PROFILES VALUES ('9dfa89d32387455ebe800ed77c200fa3', 'Bd', 'Be', 'Csnr', 'Fn2', 'M', 'Jf', 'lp', 'mp', 'nat', 'Piet',   'pe', '2020-05-01', 'us', null, null);
INSERT INTO DEV_GREENTRAK00.PROFILES VALUES ('a7de5d729e0343419e7da348aaa8eac2', 'Bd', 'Be', 'Csnr', 'Fn3', 'M', 'Jf', 'lp', 'mp', 'nat', 'Klaas',  'pe', '2020-05-01', 'us', null, null);
INSERT INTO DEV_GREENTRAK00.PROFILES VALUES ('caa70247ad7c4b688949edec7e879ae2', 'Bd', 'Be', 'Csnr', 'Fn4', 'M', 'Jf', 'lp', 'mp', 'nat', 'Willem', 'pe', '2020-05-01', 'us', null, null);
INSERT INTO DEV_GREENTRAK00.PROFILES VALUES ('f2a3b1deee884b2885729d6afc856116', 'Bd', 'Be', 'Csnr', 'Anita Fullname', 'F', 'Jf', 'lp', 'mp', 'nat', 'Anita',  'pe', '2020-05-01', 'Anniet', '../media/Woman_avatar_02.png', 'f1a3b1deee884b2885729d6afc856116');
INSERT INTO DEV_GREENTRAK00.PROFILES VALUES ('f0a3b1deee884b2885729d6afc856116', 'Bd', 'Be', 'Csnr', 'WH&FF Pvt Ltd', 'F', 'Jf', 'lp', 'mp', 'nat', 'WH&FF',  'pe', '2020-05-01', 'us', null, null);
INSERT INTO DEV_GREENTRAK00.PROFILES VALUES ('f1a3b1deee884b2885729d6afc856116', 'Bd', 'Be', 'Csnr', 'Heijmans Infra bv', 'F', 'Jf', 'lp', 'mp', 'nat', 'Heijmans Infra',  'pe', '2020-05-01', 'us', null, null);

ALTER TABLE DEV_GREENTRAK00.PROFILES ADD CONSTRAINT "FK_PROFILES_Organization" FOREIGN KEY ("Organization") REFERENCES DEV_GREENTRAK00.PROFILES (ID);

CREATE TABLE DEV_GREENTRAK00."AttendanceEventsAll"
(
    "Version"          INTEGER       NOT NULL,
    "CheckInDateTime"  TIMESTAMP WITH TIME ZONE     NOT NULL,
    "ProjOwner"        LONGVARBINARY NOT NULL,
    "ProjectCode"      VARCHAR(10)   NOT NULL,
    "TermGuidIn"       VARCHAR(36)   NOT NULL,
    "UserID"           LONGVARBINARY NOT NULL,
    "AggApprTime"      VARCHAR(255),
    "AggStartDate"     DATE,
    "AggTotalTime"     VARCHAR(255),
    "ApprovalBy"       VARCHAR(40),
    "ApprovalDateTime" TIMESTAMP WITH TIME ZONE,
    "CheckOutDateTime" TIMESTAMP WITH TIME ZONE,
    "Description"      VARCHAR(160),
    "Remarks"          VARCHAR(480),
    "TermGuidOut"      VARCHAR(36),
    PRIMARY KEY ("UserID", "CheckInDateTime", "Version")
);

INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"("Version", "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (0, '2020-01-16 16:42:54+01:00', 'f0a3b1deee884b2885729d6afc856116', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'AggApprTime', '2020-01-16', 'AggTotalTime', null, null, null, null, null, null);
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"("Version", "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (0, '2020-01-16 17:42:54+01:00', 'f0a3b1deee884b2885729d6afc856116', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'AggApprTime', '2020-01-16', 'AggTotalTime', null, null, '2020-01-16 18:22:54+01:00', null, null, 'TERMINAL0000001');
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"("Version", "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (0, '2020-01-16 18:42:54+01:00', 'f0a3b1deee884b2885729d6afc856116', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'AggApprTime', '2020-01-16', 'AggTotalTime', 'FvdB', '2020-02-16 17:42:54+02:00', '2020-01-16 16:22:54+01:00', 'Tieback poured', null, 'TERMINAL0000001');
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"("Version", "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (0, '2020-05-16 19:42:54+02:00', 'f1a3b1deee884b2885729d6afc856116', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'AggApprTime', '2020-05-16', 'AggTotalTime', null, null, null, null, null, null);
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"("Version", "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (0, '2020-05-16 15:42:54+02:00', 'f1a3b1deee884b2885729d6afc856116', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'AggApprTime', '2020-05-16', 'AggTotalTime', null, null, '2020-05-16 18:22:54+01:00', null, null, 'TERMINAL0000001');
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"("Version", "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (0, '2020-05-16 13:42:54+02:00', 'f1a3b1deee884b2885729d6afc856116', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'AggApprTime', '2020-05-16', 'AggTotalTime', 'FvdB',     '2020-05-16 17:42:54+02:00', '2020-05-16 16:22:54+01:00', 'Tieback poured', null, 'TERMINAL0000001');

INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"("Version", "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (0, '2020-05-16 10:00:00+02:00',        'f1a3b1deee884b2885729d6afc856116', 'ZUIDPLUS00', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'AggApprTime', '2020-05-16', 'AggTotalTime', 'FvdB',            '2020-05-16 17:42:54+02:00', '2020-05-16 16:22:54+01:00', 'Tieback poured', null, 'TERMINAL0000001');
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"("Version", "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (1, '2020-05-16 10:00:00+02:00',        'f1a3b1deee884b2885729d6afc856116', 'ZUIDPLUS00', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'AggApprTime', '2020-05-16', 'AggTotalTime', 'FvdB',              '2020-05-16 17:42:54+02:00', '2020-05-16 16:22:54+01:00', 'Tieback poured', null, 'TERMINAL0000001');
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"("Version", "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (2, '2020-05-16 10:00:00+02:00',        'f1a3b1deee884b2885729d6afc856116', 'ZUIDPLUS00', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'AggApprTime', '2020-05-16', 'AggTotalTime', 'FvdB',              '2020-05-16 17:42:54+02:00', '2020-05-16 16:22:54+01:00', 'Tieback poured', null, 'TERMINAL0000001');

/*
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"("Version", "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (1, '2020-01-16 16:42:54+01:00', 'f0a3b1deee884b2885729d6afc856116', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'AggApprTime', '2020-01-16', 'AggTotalTime', 'FvdB', '2020-02-16 17:42:54+02:00', '2020-01-16 16:22:54+01:00', 'Tieback poured', null, 'TERMINAL0000001');
INSERT INTO DEV_GREENTRAK00."AttendanceEventsAll"("Version", "CheckInDateTime", "ProjOwner", "ProjectCode", "TermGuidIn", "UserID", "AggApprTime", "AggStartDate", "AggTotalTime", "ApprovalBy", "ApprovalDateTime", "CheckOutDateTime", "Description", "Remarks", "TermGuidOut") VALUES (1, '2020-05-16 13:42:54+02:00', 'f1a3b1deee884b2885729d6afc856116', 'PRUTSERIJ0', 'TERMINAL0000003', x'F2A3B1DEEE884B2885729D6AFC856116', 'AggApprTime', '2020-05-16', 'AggTotalTime', 'FvdB',     '2020-05-16 17:42:54+02:00', '2020-05-16 16:22:54+01:00', 'Tieback poured', null, 'TERMINAL0000001');
*/

ALTER TABLE DEV_GREENTRAK00."AttendanceEventsAll" ADD CONSTRAINT "FK_AttendanceEventsAll_UserID" FOREIGN KEY ("UserID") REFERENCES DEV_GREENTRAK00.PROFILES (ID);

/*
CREATE VIEW DEV_GREENTRAK00."VAttendanceEventsAll"
            ("Version",
             "CheckInDateTime",
             "FullProjOwner",
             "ProjectCode",
             "TermGuidIn",
             "UserID",
             "UserName",
             "FullName",
             "AggApprTime",
             "AggStartDate",
             "AggTotalTime",
             "ApprovalBy",
             "ApprovalDateTime",
             "CheckOutDateTime",
             "Description",
             "Remarks",
             "TermGuidOut")
as
SELECT T1."Version",
       T1."CheckInDateTime",
       (select T3."FullName" from DEV_GREENTRAK00.PROFILES T3 where T3.ID = T1."ProjOwner"),
       T1."ProjectCode",
       T1."TermGuidIn",
       T1."UserID",
       T2."UserName",
       T2."FullName",
       T1."AggApprTime",
       T1."AggStartDate",
       T1."AggTotalTime",
       T1."ApprovalBy",
       T1."ApprovalDateTime",
       T1."CheckOutDateTime",
       T1."Description",
       T1."Remarks",
       T1."TermGuidOut"
FROM DEV_GREENTRAK00."AttendanceEventsAll" T1,
     DEV_GREENTRAK00.PROFILES T2,
     (SELECT T0."CheckInDateTime" CIDT, MAX(T0."Version") VERSION, T0."UserID" UID
      FROM DEV_GREENTRAK00."AttendanceEventsAll" T0
      GROUP BY T0."CheckInDateTime", T0."UserID") T3
WHERE T1."UserID" = T2.ID
  AND (T1."CheckInDateTime", T1."Version", T1."UserID") = (T3.CIDT, T3.VERSION, T3.UID);
*/

create table DEV_GREENTRAK00.P0000PROJECTS(
                                              "Id"          INTEGER not null constraint P0000PROJECTS_PK primary key,
                                              "StartDate"   TIMESTAMP WITH TIME ZONE NOT NULL,
                                              "ProjectCode" VARCHAR(20) NOT NULL,
                                              "ProjOwner"   LONGVARBINARY NOT NULL,
                                              "ProjectName" VARCHAR(20),
                                              "Description" VARCHAR(320)
);

INSERT INTO DEV_GREENTRAK00.P0000PROJECTS VALUES ( 0, '2020-05-16 12:00:00.000000+02:00', 'ZUIDPLUS00', 'f0a3b1deee884b2885729d6afc856116', 'Zuidasdok',
'De verbreding van 4 naar 6 rijstroken en ondergronds brengen van Rijksweg A10 Zuid;
De herinrichting van de verkeersknooppunten Amstel en De Nieuwe Meer;
Het uitbreiden en vernieuwen van het station Amsterdam Zuid;
Het opnieuw inrichten van het stationsgebied.');

INSERT INTO DEV_GREENTRAK00.P0000PROJECTS VALUES ( 1, '2020-05-16 12:00:00.000000+02:00', 'PRUTSPLUS0', 'f1a3b1deee884b2885729d6afc856116', 'Pruts Plus',
                                                   'Beschrijving volgt');

ALTER TABLE DEV_GREENTRAK00.P0000PROJECTS ADD CONSTRAINT "FK_P0000PROJECTS_ProjOwner" FOREIGN KEY ("ProjOwner") REFERENCES DEV_GREENTRAK00.PROFILES (ID);