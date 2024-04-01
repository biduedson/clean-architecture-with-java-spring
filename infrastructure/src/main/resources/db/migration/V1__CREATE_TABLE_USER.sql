CREATE TABLE Users(
    Id UUID PRIMARY KEY NOT NULL,
    Email VARCHAR(70) UNIQUE NOT NULL,
    Password VARCHAR(50) NOT NULL,
    TaxNumber VARCHAR(15) UNIQUE NOT NULL,
    FullName VARCHAR(70) NOT NULL,
    Type VARCHAR(30) NOT NULL,
    CreatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdateAt TIMESTAMP
);