SELECT users.name, COALESCE(SUM(distance), 0)  AS travelled_distance
FROM users
LEFT JOIN rides
ON users.id = rides.user_id
GROUP BY users.name, rides.user_id
ORDER BY travelled_distance DESC, users.name ASC;