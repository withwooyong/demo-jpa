package com.example.demo.entity;

import com.example.demo.entity.test.Child;
import com.example.demo.entity.test.Parent;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.ParentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.LinkedHashSet;
import java.util.Set;

@DataJpaTest
class JpaTest {

    @Autowired
    ParentRepository parentRepository;

    @Autowired
    ChildRepository childRepository;

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 10; i++) {
            Parent parent = new Parent("a" + String.valueOf(i));


            Set<Child> childSet = new LinkedHashSet<Child>();
            childSet.add(new Child("Ted" + String.valueOf(i), parent));
            childSet.add(new Child("andy" + String.valueOf(i), parent));

            var result = parentRepository.save(parent);
//            System.out.println(result.toString());
        }

    }

    @Test
    void oneToManyParentTest() {
        var result1 = parentRepository.findByName("father1");
        System.out.println("result1=" + result1.toString());
    }

    @Test
    void oneToManyChildTest() {
        var result2 = childRepository.findByName("Ted1");
        System.out.println("result2=" + result2);
        var result3 = result2.get().getParent();
        System.out.println("result3=" + result3);
    }

    @Test
    void removeTest() {
//        dbParent.getChildren().removeIf(child -> child.getName().equalsIgnoreCase("james"));
        var result = parentRepository.findAll();
        System.out.println(result);
        var result2 = result.removeIf(child -> child.getName().equalsIgnoreCase("Ted1"));
        System.out.println(result2);
        var result3 = parentRepository.findAll();
        System.out.println(result3);
    }

    @Test
//    @Transactional
//    @Rollback(false)
    public void oneToManyTest() throws Exception {
//        Parent parent = new Parent("father");
//        Set<Child> children = new LinkedHashSet<>();
//
//        children.add(new Child("james", parent));
//        children.add(new Child("tomas", parent));
////        parent.setChildren(children);
//        parent.addAllChild(children);
//
//        Parent dbParent = parentRepository.save(parent);
//        System.out.println("### 0 " + dbParent.toString());
//        var result = dbParent.getChild().removeIf(child -> child.getName().equalsIgnoreCase("james"));
//        System.out.println(result);
//        var result2 = parentRepository.findAll();
//        result2.forEach(System.out::println);
////        System.out.println("### 1 " + parentRepository.findAll());
//        parentRepository.deleteAll();
////        System.out.println("### 2 " + parentRepository.findAll());
    }
}