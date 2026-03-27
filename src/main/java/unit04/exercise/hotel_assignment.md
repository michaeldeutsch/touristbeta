# Assignment: Hotel SQL Export Utility (Java)

## Objective

Create a simple Java application that models hotels and exports their
data as SQL `INSERT` statements into a file.

------------------------------------------------------------------------

## Requirements

### 1. Hotel Class

Create a `Hotel` class with **three attributes of your choice**\
(e.g., `id`, `name`, `zipCode`).

-   Use **Lombok** to reduce boilerplate code (e.g., `@Data`,
    `@AllArgsConstructor`, etc.)
-   The class should be clean and minimal

------------------------------------------------------------------------

### 2. Hotel Utility

Create a utility class (e.g., `HotelUtil`) that contains a method to:

-   Accept a list of `Hotel` objects
-   Write the data into a file as **SQL INSERT statements**

Example output:

    INSERT INTO Hotel VALUES (1, "Sacher", 1010);
    INSERT INTO Hotel VALUES (2, "Hilton", 1020);

------------------------------------------------------------------------

### 3. File Output

-   The SQL statements should be written into a file (e.g.,
    `hotels.sql`)
-   Ensure proper formatting (each statement in a new line)

------------------------------------------------------------------------

### 4. Main Method

-   Create at least **3 Hotel objects**
-   Store them in a collection (e.g., `List`)
-   Call the utility method to generate the SQL file

------------------------------------------------------------------------

## Optional (Bonus)

-   Add a **timestamp** to the filename\
    Example: `hotels_20260326.sql`

------------------------------------------------------------------------

## Learning Goals

-   Working with Java classes and objects
-   Using Lombok for code simplification
-   File handling in Java
-   Generating structured output (SQL)
