-- Write your query below
select a.first_name,
a.last_name,
b.city,
b.state
from person a 
full join address b 
on a.person_id=b.person_id
where (a.first_name,a.last_name) is not null ;