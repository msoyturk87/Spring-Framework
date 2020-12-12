CREATE OR REPLACE PROCEDURE update_department(emp_id int)
language plpgsql
as
    $$
    declare
    begin
        update employees set department='Toys'
        where employee_id=emp_id;
        commit;
    end

    $$;
-- call procedure
call update_department(1);
--verify it
select * from employees where employee_id=1;

CREATE OR REPLACE PROCEDURE transfer(
sender_id int ,
amount decimal,
receiver_id int)
language plpgsql
as
    $$
    declare
    begin
        update  employees
        set salary=salary-amount
        where employee_id=sender_id;

        update  employees
        set salary=salary+amount
        where employee_id=receiver_id;

        commit;
    end

    $$;

call transfer (1,44000,2);

select * from employees order by employee_id;