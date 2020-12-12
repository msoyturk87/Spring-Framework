EXPLAIN ANALYZE
select *
from towns
where id=35;

--Create Index

CREATE INDEX idx_towns_name ON towns(name);
DROP INDEX IF EXISTS idx_towns_name;

-- Show all indexes
SELECT
    tablename,
    indexname,
    indexdef
FROM
    pg_indexes
WHERE
        schemaname = 'public'
ORDER BY
    tablename,
    indexname;

-- Create Functions

CREATE OR REPLACE FUNCTION get_department_count_by_name(dep_name varchar)
    returns int
    language plpgsql
        as
$$
    declare
    department_count integer;
    begin
    select count(*)
        into department_count
        from employees
        where department=dep_name;
        return department_count;
    end;


    $$

-- use function
Select get_department_count_by_name('Sports');


CREATE  OR REPLACE FUNCTION get_department(p_pattern varchar)
returns table(
    employee_name varchar,
    employee_email varchar
             )
    language plpgsql
as
    $$
    begin
    return query
        select first_name,email
        from employees
        where department ilike p_pattern;
    end;




    $$


select * from get_department('%Oth%');
--Drop it 
DROP FUNCTION get_department(p_pattern varchar);


-- Drop table

DROP TABLE IF EXISTS mentors;
CREATE TABLE mentors(
                        id INT GENERATED ALWAYS AS IDENTITY,
                        first_name varchar(40) not null,
                        last_name varchar(40) not null ,
                        primary key(id)
);

DROP TABLE IF EXISTS mentor_audit;
CREATE TABLE mentor_audit(
                             id INT GENERATED ALWAYS AS IDENTITY,
                             mentor_id INT not null,
                             last_name varchar(40) not null ,
                             changed_on timestamp(6) not null
);

CREATE OR REPLACE  FUNCTION log_last_name_changes()
    returns trigger
    language plpgsql
as
$$
begin
    IF NEW.last_name <> OLD.last_name THEN
        INSERT INTO mentor_audit(mentor_id,last_name,changed_on) VALUES
        (OLD.id,OLD.last_name,now());
    end if;

    RETURN new;
end;
$$