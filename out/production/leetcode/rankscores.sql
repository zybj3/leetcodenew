SELECT
Score,
(SELECT count(distinct Score) FROM Scores where Score>=s.Score) Rank
FROM Scores as s
ORDER BY Score desc