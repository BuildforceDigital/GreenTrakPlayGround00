SET schema OLINGO;
-- create schema "OLINGO";

--------BUSINESS PARTNER---------------------------------------------------------------------------------------------------------
CREATE TABLE OLINGO."BusinessPartner"(
    ID                            VARCHAR(32) CONSTRAINT BusinessPartner_pkey PRIMARY KEY,
    "ETag"                        BIGINT,
    "Type"                        VARCHAR(2),
    "CustomString1"               VARCHAR(250),
    "CustomString2"               VARCHAR(250),
    "CustomNum1"                  DECIMAL(16, 5),
    "CustomNum2"                  DECIMAL(31, 0),
    "NameLine1"                   VARCHAR(250),
    "NameLine2"                   VARCHAR(250),
    "BirthDay"                    DATE,
    "Address.StreetName"          VARCHAR(200),
    "Address.StreetNumber"        VARCHAR(60),
    "Address.PostOfficeBox"       VARCHAR(60),
    "Address.City"                VARCHAR(100),
    "Address.PostalCode"          VARCHAR(60),
    "ADDRESS_REGIONCODEPUBLISHER" VARCHAR(10) NOT NULL,
    "ADDRESS_REGIONCODEID"        VARCHAR(10) NOT NULL,
    "ADDRESS_REGION"              VARCHAR(10) NOT NULL,
    "Address.Country"             VARCHAR(100),
    "Telecom.Phone"               VARCHAR(100),
    "Telecom.Mobile"              VARCHAR(100),
    "Telecom.Fax"                 VARCHAR(100),
    "Telecom.Email"               VARCHAR(100),
    "CreatedBy"                   VARCHAR(32) NOT NULL CONSTRAINT "FK_BusinessPartner_CreatedBy" REFERENCES OLINGO."BusinessPartner",
    "CreatedAt"                   TIMESTAMP /*WITH TIME ZONE*/ DEFAULT CURRENT_TIMESTAMP,
    "UpdatedBy"                   VARCHAR(32) CONSTRAINT "FK_BusinessPartner_UpdatedBy" REFERENCES OLINGO."BusinessPartner",
    "UpdatedAt"                   TIMESTAMP /*WITH TIME ZONE*/ CHECK ("UpdatedAt" >= "CreatedAt"),
    "Country"                     VARCHAR(4),
    "AbcClass"                    VARCHAR(1),
    "AccessRights"                INTEGER
);

INSERT INTO OLINGO."BusinessPartner" VALUES ('99', 0, '1', '', '',   null, null, 'Max', 'Mustermann', null, 'Test Straße', '12', '', 'Teststadt', '10115', 'ISO', '3166-2', 'DE-BE', 'DEU', '', '', '', '', '99', '2016-01-20 09:21:23', null, null, 'DEU', null, 1);
INSERT INTO OLINGO."BusinessPartner" VALUES ('98', 0, '1', '', '',   null, null, 'John', 'Doe',       null, 'Test Road', '55',   '', 'Test City', '76321', 'ISO', '3166-2', 'US-TX', 'USA', '', '', '', '', '99', '2016-01-20 09:21:23', null, null, 'DEU', null, 2);
INSERT INTO OLINGO."BusinessPartner" VALUES ('97', 0, '1', '', '',   null, null, 'Urs', 'Müller',     null, 'Test Straße', '23', '', 'Test Dorf',  '4123', 'ISO', '3166-2', 'CH-BL', 'CHE', '', '', '', '', '99', '2016-07-20 09:21:23', null, null, 'CHE', null, 9);
INSERT INTO OLINGO."BusinessPartner" VALUES ( '1', 0, '2', '', '', 6000.5, null, 'First Org.', '',    null, 'Test Road', '23',   '', 'Test City', '94321', 'ISO', '3166-2', 'US-CA', 'USA', '', '', '', '', '99', '2016-01-20 09:21:23', null, null, 'USA', 'A', null);
INSERT INTO OLINGO."BusinessPartner" VALUES ('10', 0, '2', '', '',   null, null, 'Tenth Org.', '',    null, 'Test Road', '12',   '', 'Test City', '03921', 'ISO', '3166-2', 'US-ME', 'USA', '', '', '', '', '99', '2016-01-20 09:21:23', null, null, 'DEU', null, null);
INSERT INTO OLINGO."BusinessPartner" VALUES ( '2', 0, '2', '', '',   null, null, 'Second Org.', '',   null, 'Test Road', '45',   '', 'Test City', '76321', 'ISO', '3166-2', 'US-TX', 'USA', '', '', '', '', '97', '2016-01-20 09:21:23', null, null, 'USA', 'B', null);
INSERT INTO OLINGO."BusinessPartner" VALUES ( '3', 0, '2', '', '',   null, null, 'Third Org.', '',    null, 'Test Road', '223',  '', 'Test City', '94322', 'ISO', '3166-2', 'US-CA', 'USA', '', '', '', '', '99', '2016-01-20 09:21:23', null, null, 'USA', 'C', null);
INSERT INTO OLINGO."BusinessPartner" VALUES ( '4', 0, '2', '', '',   null, null, 'Fourth Org.', '',   null, 'Test Road', '56',   '', 'Test City', '84321', 'ISO', '3166-2', 'US-UT', 'USA', '', '', '', '', '98', '2016-01-20 09:21:23', null, null, 'USA', 'C', null);
INSERT INTO OLINGO."BusinessPartner" VALUES ( '5', 0, '2', '', '',   null, null, 'Fifth Org.', '',    null, 'Test Road', '35',   '', 'Test City', '59321', 'ISO', '3166-2', 'US-MT', 'USA', '', '', '', '', '99', '2016-01-20 09:21:23', null, null, 'USA', null, null);
INSERT INTO OLINGO."BusinessPartner" VALUES ( '6', 0, '2', '', '',   null, null, 'Sixth Org.', '',    null, 'Test Road', '7856', '', 'Test City', '94324', 'ISO', '3166-2', 'US-CA', 'USA', '', '', '', '', '99', '2016-01-20 09:21:23', null, null, 'USA', null, null);
INSERT INTO OLINGO."BusinessPartner" VALUES ( '7', 0, '2', '', '',   null, null, 'Seventh Org.', '',  null, 'Test Road', '4',    '', 'Test City', '29321', 'ISO', '3166-2', 'US-SC', 'USA', '', '', '', '', '99', '2016-01-20 09:21:23', null, null, 'USA', null, null);
INSERT INTO OLINGO."BusinessPartner" VALUES ( '8', 0, '2', '', '',   null, null, 'Eighth Org.', '',   null, 'Test Road', '453',  '', 'Test City', '29221', 'ISO', '3166-2', 'US-SC', 'USA', '', '', '', '', '99', '2016-01-20 09:21:23', null, null, 'USA', null, null);
INSERT INTO OLINGO."BusinessPartner" VALUES ( '9', 0, '2', '', '',   null, null, 'Ninth Org.', '',    null, 'Test Road', '93',   '', 'Test City', '55021', 'ISO', '3166-2', 'US-MN', 'USA', '', '', '', '', '99', '2016-01-20 09:21:23', null, null, 'USA', null, null);