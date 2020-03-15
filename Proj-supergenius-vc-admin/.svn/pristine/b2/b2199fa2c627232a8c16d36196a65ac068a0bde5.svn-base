SELECT
	p.`pid`,
	p.`name`,
	u.`corporation`,
	p.`createtime`,
	p.`area`,
	pi.`videobuy`,
	p.`followcount`,
	p.`freezecount`,
	p.`status`
FROM
	project AS p
	INNER JOIN USER AS u ON p.`useruid` = u.`useruid`
	INNER JOIN projectinfo AS PI ON p.pid = pi.pid
	INNER JOIN financing AS fc ON fc.`pid`=p.`pid`
	WHERE pi.`rounds`=3
	
	
	SELECT  * FROM project
	
	SELECT *FROM financing