# Write your MySQL query statement below

with my_cte as(
    select Email,min(ID)as id_to_keep
    from Person
    group by Email
)
delete from Person
where ID not in (select id_to_keep from my_cte);