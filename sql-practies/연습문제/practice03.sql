--  테이블간 조인(JOIN) SQL 문제입니다.

--  문제 1. 
--  현재 급여가 많은 직원부터 직원의 사번, 이름, 그리고 연봉을 출력 하시오.
select a.emp_no, a.first_name, b.salary
from employees a join salaries b on a.emp_no = b.emp_no
order by b.salary desc;

--  문제2.
--  전체 사원의 사번, 이름, 현재 직책을 이름 순서로 출력하세요.
select a.emp_no, first_name, title
from employees a join titles b on a.emp_no = b.emp_no
where to_date = '9999-01-01'
order by first_name;

--  문제3.
--  전체 사원의 사번, 이름, 현재 부서를 이름 순서로 출력하세요..
select emp_no, first_name, dept_name
from employees join dept_emp using(emp_no)
				join departments using(dept_no) 
where to_date = '9999-01-01'
order by first_name;

--  문제4.
--  전체 사원의 사번, 이름, 연봉, 직책, 부서를 모두 이름 순서로 출력합니다.
select emp_no, first_name, salary, title, dept_name
from employees join salaries using(emp_no)
			   join titles using(emp_no)
               join dept_emp using(emp_no)
				join departments using(dept_no)
order by first_name;

--  문제5.
--  ‘Technique Leader’의 직책으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 출력하세요. 
--  (현재 ‘Technique Leader’의 직책(으로 근무하는 사원은 고려하지 않습니다.) 
--  이름은 first_name과 last_name을 합쳐 출력 합니다.
select emp_no, concat(first_name, ' ', last_name) 이름 
from employees join titles using(emp_no)
where title = 'Technique Leader'
and to_date != '9999-01-01';


--  문제6.
--  직원 이름(last_name) 중에서 S(대문자)로 시작하는 직원들의 
--  이름, 부서명, 직책을 조회하세요.
select concat(first_name, ' ' ,last_name) 직원이름, dept_name, title
from employees join dept_emp using(emp_no)
			   join departments using(dept_no)
               join titles using(emp_no)
where employees.last_name like 'S%';


--  문제7.
--  현재, 직책이 Engineer인 사원 중에서 
--  현재 급여가 40000 이상인 사원을 급여가 큰 순서대로 출력하세요.
select emp_no, title, salary
from salaries s join titles t using(emp_no)
where title = 'Engineer'
and salary >= '40000' 
and s.to_date = '9999-01-01' and t.to_date = '9999-01-01'
order by salary desc;

--  문제8.
--  현재 급여가 50000이 넘는 사원을 직책, 급여로 급여가 큰 순서대로 출력하시오
select title, salary
from salaries s join titles t using(emp_no)
where salary > 50000
and t.to_date = '9999-01-01' and s.to_date = '9999-01-01'
order by salary desc;

--  문제9.
--  현재, 부서별 평균 연봉을 연봉이 큰 부서 순서대로 출력하세요.
select departments.dept_name, avg(salary) '부서별 평균 연봉'
from dept_emp join salaries using(emp_no)
			  join departments using(dept_no)
where dept_emp.to_date = '9999-01-01'
group by departments.dept_name
order by avg(salary);
              

--  문제10.
--  현재, 직책별 평균 연봉을 연봉이 큰 직책 순서대로 출력하세요.
select title, avg(salary)
from titles join salaries using(emp_no)
where titles.to_date = '9999-01-01'
group by titles.title
order by avg(salary) desc;