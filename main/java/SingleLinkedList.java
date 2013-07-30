import java.util.ArrayList;

/**
 * User: kpv
 * Date: 7/29/13
 * Time: 1:54 PM
 */

public class SingleLinkedList
{
    private int size;
    private Node root;

    public SingleLinkedList()
    {
        size = 0;
        root = null;
    }

    public SingleLinkedList(ArrayList<Object> list)
    {
        for (Object i : list)
        {
            insertObject(i);
        }
    }

    public void insertObject(Object i)
    {
        Node tmp = new Node(i);
        Node nodeRoot = root;
        if (root == null)
        {
            root = tmp;
            return;
        }
        while (nodeRoot.getNext() != null)
        {
            nodeRoot = nodeRoot.getNext();
        }
        nodeRoot.setNext(tmp);
        size++;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public Node getRoot()
    {
        return root;
    }

    public void setRoot(Node root)
    {
        this.root = root;
    }

    public Node findObject(Object value)
    {
        if (root != null)
        {
            Node tmp = root;
            while (tmp.getNext() != null)
            {
                if (tmp.getValue().equals(value))
                {
                    return tmp;
                }
                tmp = tmp.getNext();
            }

        }
        return null;
    }

    public void insertAfter(Node tmpNode, Object value)
    {
        Node tmp = root;
        while (tmp != null && !tmp.equals(tmpNode))
        {
            tmp = tmp.getNext();
        }
        if (tmp != null)
        {
            tmp.setNext(new Node(value, tmp.getNext()));
            size++;
        }
        root = tmp;
    }

    @Override
    public String toString()
    {
        String result = "";
        if (root != null)
        {
            Node tmp = root;

            while (tmp.getNext() != null)
            {
                result += "  root=" + tmp.getValue() +
                        ", size=" + size;
                tmp = tmp.getNext();
            }
            result += "  root=" + tmp.getValue() +
                    ", size=" + size;

        }
        return result;
    }

    public void deleteNode(Node tmp_)
    {
        if (root == null)
        {
            throw new RuntimeException("root is null");
        }

        Node tmp = root;
        while (tmp.getNext() != null)
        {
            if (tmp.getNext().equals(tmp_))
            {
                tmp.setNext(tmp_.getNext());
                size--;
            }
            tmp = tmp.getNext();
        }
    }

    public Node first()
    {
        return root;
    }

    public Node last()
    {
        if (root != null)
        {
            Node tmp = root;
            while (tmp.getNext() != null)
            {
                tmp = tmp.getNext();
            }
            return tmp;

        }
        else
        {
            return null;
        }
    }

    public Node before(Node tmp_)
    {
        if (root != null)
        {
            Node tmp = root;
            while (tmp.getNext() != null)
            {
                if (tmp.getNext().equals(tmp_))
                {
                    return tmp;
                }
                tmp = tmp.getNext();
            }
            return null;

        }
        else
        {
            return null;
        }
    }

    public Node after(Node tmp_)
    {
        if (root != null)
        {
            Node tmp = root;
            while (tmp.getNext() != null)
            {
                if (tmp.equals(tmp_))
                {
                    return tmp.getNext();
                }
                tmp = tmp.getNext();
            }
            return null;

        }
        else
        {
            return null;
        }
    }

    public void append(Object value)
    {
        insertObject(value);
    }

    public void insertFirst(Object value)
    {
        Node inserfirst = new Node(value,root);
        size++;
        root = inserfirst;
    }
}
