-- inner join

-- 예제 1 : employees 테이블과 title 테이블을 join 하여 직원의 이름과 직책을 모두 출력
select a.first_name, b.title
from employees a, titles b
where a.emp_no = b.emp_no			-- join 조건 (n-1)  -> n : 테이블 개수
and b.to_date = '9999-01-01';		-- row 선택 조건

-- 예제 2 : employees 테이블과 title 테이블을 join 하여 직원의 이름과 직책을 출력하되 여성 엔지니어만 출력하세요.
select a.first_name, b.title
from employees a, titles b
where a.emp_no = b.emp_no			-- join 조건 (n-1)  -> n : 테이블 개수
and b.to_date = '9999-01-01' 		-- row 선택 조건 1
and a.gender = 'f'					-- row 선택 조건 2
and b.title = 'engineer'; 			-- row 선택 조건 3

-- 
-- ANSI/ISO SQL1999 JOIN 표준 문법

-- 1) natural join
-- 두 테이블에 공통 컬럼이 있으면 별다른 조인 조건 없이 암묵적으로 조인이 됨 
-- 쓸 일 없음...
select a.first_name, b.title
from employees a natural join titles b
-- on a.emp_no = b.emp_no 생략
where a.emp_no = b.emp_no			-- join 조건 (n-1)  -> n : 테이블 개수
and b.to_date = '9999-01-01'; 		-- row 선택 조건 

-- 2) join ~ using
select a.first_name, b.title
from employees a join titles b using (emp_no)
where b.to_date = '9999-01-01'; 		-- row 선택 조건 

-- 3) join ~ on
select a.first_name, b.title
from employees a join titles b on a.emp_no = b.emp_no
where b.to_date = '9999-01-01'; 		-- row 선택 조건 
