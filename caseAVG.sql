SELECT AVG(CAST(Avg as FLOAT))
FROM
	(SELECT AVG(CAST(NewRate as FLOAT)) as Avg
	FROM
		(SELECT Date,
			CASE Rate
			WHEN 'low' then 1
			WHEN 'mid' then 2
			WHEN 'high' then 3
			ELSE 0
			END as NewRate
		FROM Procs) as NewTable
	GROUP BY Date) as NewTable2