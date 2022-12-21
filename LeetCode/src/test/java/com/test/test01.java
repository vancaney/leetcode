//package com.test;
//
//import com.why.leetcode.pojo.ListNode;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class test01 {
//    @Test
//    public void test() {
//        ListNode[] listNodes = new ListNode[]{new ListNode(1 , new ListNode(4,new ListNode(5))),
//                                                new ListNode(1,new ListNode(3,new ListNode(4))),
//                                                new ListNode(2,new ListNode(6))};
//        mergeKLists(listNodes);
//    }
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode dummy = new ListNode(0);
//        ListNode d = dummy;
//        for(int i = 0 ; i < lists.length ; i++){
//            d.next = mergeLists(d , lists[i]);
//            d = d.next;
//        }
//        return dummy.next;
//    }
//
//    public ListNode mergeLists(ListNode dummy , ListNode list){
//        ListNode res = new ListNode(0);
//        ListNode d = dummy , l = list , r = res;
//        while(d != null && l != null){
//            while(d != null && d.val < l.val){
//                r.next = d;
//                d = d.next;
//            }
//            if(d == null){
//                r.next = l;
//                break;
//            }
//            while(l != null && d.val > l.val){
//                r.next = l;
//                l = l.next;
//            }
//            if(l == null){
//                r.next = d;
//                break;
//            }
//            if(r != null)
//                r = r.next;
//            else
//                break;
//        }
//
//        return res.next;
//    }
//
//
//}
