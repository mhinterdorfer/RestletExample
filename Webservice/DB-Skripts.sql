CREATE TABLE [dbo].[Saison] (
    [idSaison] INT          NOT NULL,
    [name]     VARCHAR (80) NULL,
    [datumVon] DATE         NULL,
    [datumBis] DATE         NULL,
    PRIMARY KEY CLUSTERED ([idSaison] ASC)
);

CREATE TABLE [dbo].[Standort]
(
	[idStandort] INT NOT NULL PRIMARY KEY, 
    [bezeichnung] VARCHAR(80) NULL, 
    [strasse] VARCHAR(80) NULL, 
    [plz] INT NULL, 
    [ort] VARCHAR(80) NULL
)

CREATE TABLE [dbo].[Fahrzeug]
(
	[fahrgestellNr] INT NOT NULL PRIMARY KEY, 
    [standort_idstandort] INT NULL, 
    [marke] VARCHAR(45) NULL, 
    [typ] VARCHAR(45) NULL, 
    CONSTRAINT [FK_Standort_Fahrzeug] FOREIGN KEY (standort_idstandort) REFERENCES [Standort](idstandort)
)

CREATE TABLE [dbo].[fahrzeug_in_saison]
(
	[IdSaison] INT NOT NULL , 
    [fahrgestellNr] INT NOT NULL, 
    [tagespreis] FLOAT NULL, 
    PRIMARY KEY ([fahrgestellNr], [IdSaison]), 
    CONSTRAINT [FK_FahrzeugiS_Saison] FOREIGN KEY (IdSaison) REFERENCES [Saison]([IdSaison]), 
    CONSTRAINT [FK_FahrzeugiS_Fahrzeug] FOREIGN KEY (fahrgestellNr) REFERENCES [Fahrzeug]([fahrgestellNr])
)

CREATE TABLE [dbo].[Kunde]
(
	[IdKunde] INT NOT NULL PRIMARY KEY, 
    [vorname] VARCHAR(80) NULL, 
    [nachname] VARCHAR(80) NULL, 
    [strasse] VARCHAR(80) NULL, 
    [plz] INT NULL, 
    [ort] VARCHAR(80) NULL
)


CREATE TABLE [dbo].[Mietfahrzeug]
(
	[fahrgestellNr] INT NOT NULL , 
    [idSaison] INT NOT NULL, 
    [idKunde] INT NOT NULL, 
    [datumVon] DATE NULL, 
    [datumBis] DATE NULL, 
    PRIMARY KEY ([idKunde], [fahrgestellNr], [idSaison]), 
    CONSTRAINT [FK_Fahrzeug_Mietfahrzeug] FOREIGN KEY ([fahrgestellNr]) REFERENCES [Fahrzeug]([fahrgestellNr]), 
    CONSTRAINT [FK_Saison_Mietfahrzeug] FOREIGN KEY ([idSaison]) REFERENCES [Saison]([idSaison]), 
    CONSTRAINT [FK_Kunde_Mietfahrzeug] FOREIGN KEY ([idKunde]) REFERENCES [Kunde]([idKunde])
)

