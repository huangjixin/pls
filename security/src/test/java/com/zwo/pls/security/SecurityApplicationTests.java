package com.zwo.pls.security;

import com.zwo.pls.core.utils.TreeHelper;
import com.zwo.pls.core.vo.Node;
import com.zwo.pls.security.domain.Permission;
import com.zwo.pls.security.dto.UserDto;
import com.zwo.pls.security.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SecurityApplication.class)
public class SecurityApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testTreeHelp(){
        UserDto user = userService.selectByUserName("1");
        List<Node> nodes = new ArrayList<Node>();
        List<Permission> permissionList =  user.getPermissions();
        List permissions = new ArrayList( );
        for (Permission permission:permissionList) {
            if(!permissions.contains(permission)){
                permissions.add(permission);
            }
        }
        System.out.println(permissionList);
//        Node node1 = new Node("1", "0", "组织架构");
//        Node node2 = new Node("2", "1", "党委a");
//        Node node3 = new Node("3", "1", "党委b"));
//        Node node4 = new Node("4", "2", "a支部1"));
//        Node node5 = new Node("5", "2", "a支部2"));
//        Node node6 = new Node("6", "2", "a支部3"));
//        Node node7 = new Node("7", "3", "b支部1"));
//        Node node8 = new Node("1", "0", "组织架构");
//        Node node9 = new Node("1", "0", "组织架构");
//
//        nodes.add();
//        nodes.add(new Node());
//        nodes.add(new Node();
//        nodes.add(new Node();
//        nodes.add(new Node();
//        nodes.add(new Node();
//        nodes.add(new Node();
//        nodes.add(new Node();
//        nodes.add(new Node("9", "4", "b支部3"));

//        List<Node> list = TreeHelper.getSortedNodes(nodes);

//        for (Node node : list) {
//            for (int i = 0; i < node.getLevel(); i++)
//                System.out.print("  ");
//            System.out.println(node.getId() + " " + node.getName());
//        }

        List<Permission> rootList = TreeHelper.getTreeNodes(permissions);
        System.out.println(rootList.toString());
    }
}
