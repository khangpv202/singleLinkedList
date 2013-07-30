import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: kpv
 * Date: 7/29/13
 * Time: 1:51 PM
 */

public class TestSingleLinkedList
{
    @Test
    public void testInitialNewSingleLinkedList(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        assertEquals(singleLinkedList.getSize(),0);
        assertEquals(singleLinkedList.getRoot(),null);
    }
    @Test
    public void testInitialSingleLinkedListFromArrayOfObject(){
        ArrayList<Object> list =new ArrayList<Object>();
        list.add("hehe");
        list.add("nothing");
        list.add("hehe");
        list.add("nothing");
        SingleLinkedList singleLinkedList = new SingleLinkedList(list);
        System.out.println(singleLinkedList.getSize()+ " " +list.size());
        assertEquals(singleLinkedList.getSize(),list.size()-1);
    }
    private SingleLinkedList intialSigleLinkedList(){
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertObject("hehe");
        singleLinkedList.insertObject("nothing");
        singleLinkedList.insertObject("hope");
        singleLinkedList.insertObject("discard");
        return singleLinkedList;
    }
    @Test
    public void testGetSize(){
        SingleLinkedList list = intialSigleLinkedList();
        int size = list.getSize();
        assertEquals(size,3);
    }
    @Test
    public void testInsertAfter(){
        SingleLinkedList list = intialSigleLinkedList();
        Node tmpNode = list.findObject("hope");
        list.insertAfter(tmpNode,"insertAfter");
        assertEquals(list.getSize(),4);
    }
    @Test
    public void testDeleteANode(){
        SingleLinkedList list = intialSigleLinkedList();
        Node tmp = list.findObject("hope");
        list.deleteNode(tmp);
        tmp = list.findObject("hope");
        assertTrue(tmp==null);
        assertEquals(list.getSize(),2);
    }
    @Test
    public void testGetFirst(){
        SingleLinkedList list = intialSigleLinkedList();
        Node first = list.first();
        assertEquals(first.getValue(),"hehe");
    }
    @Test
    public void testLast(){
        SingleLinkedList list = intialSigleLinkedList();
        Node last = list.last();
        assertEquals(last.getValue(),"discard");
    }
    @Test
    public void testBefore(){
        SingleLinkedList list = intialSigleLinkedList();
        Node tmp = list.findObject("hope");
        Node before = list.before(tmp);
        assertEquals(before.getValue(),"nothing");
    }
    @Test
    public void testAfter(){
        SingleLinkedList list = intialSigleLinkedList();
        Node tmp = list.findObject("hope");
        Node after = list.after(tmp);
        assertEquals(after.getValue(),"discard");
    }
    @Test
    public void testAppend(){
        SingleLinkedList list = intialSigleLinkedList();
        list.append("final");
        assertEquals(list.getSize(),4);
    }
    @Test
    public void testInsertFirst(){
        SingleLinkedList list = intialSigleLinkedList();
        list.insertFirst("firstValue");
        System.out.println(list);
        assertEquals(list.getSize(),4);
    }
    @Test
    public void testDeleteEmptyList(){
        SingleLinkedList list = new SingleLinkedList();
        Node node = new Node("hehe");
        try {
            list.deleteNode(node);
        } catch (Exception e){
            assertEquals(e.getMessage(),"root is null");
        }
    }
}
