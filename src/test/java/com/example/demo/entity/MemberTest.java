package com.example.demo.entity;

import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void memberTest() {
        String id = "id1";
        Member member = Member.builder()
                .userName("username")
                .age(20)
                .build();
        //등록
        Member result = memberRepository.save(member);
        System.out.println("save=" + result.toString());
        //수정
        result = memberRepository.findById(result.getId()).orElseThrow();
        result.updateUserName("test");
        result.setUser();
        System.out.println("findById=" + result);
        // 삭제
        memberRepository.delete(result);
        System.out.println(memberRepository.findAll());
    }

    @Test
    void dataInsertTest() {
        // 부서 등록
        Department departmemt = new Department();
        departmemt.setName("개발부");
//		em.persist(departmemt);

        // 직원 여러명 등록
        for (int i = 1; i <= 5; i++) {
            Employee employee = new Employee();
            employee.setName("직원-" + i);
            // 직원에 부서 정보 설정
            employee.setDept(departmemt);
//			em.persist(employee);
        }
        var result = departmentRepository.save(departmemt);
        System.out.println(result);

    }
}