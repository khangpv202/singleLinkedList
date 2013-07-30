/**
 * User: kpv
 * Date: 7/29/13
 * Time: 1:55 PM
 */

public class Node
{
    private Node next;
    private Object value;

    public Node(Object i)
    {
        this.value = i;
        this.next = null;
    }

    public Node(Object value, Node next)
    {
        this.value = value;
        this.next = next;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Node))
        {
            return false;
        }

        Node node = (Node) o;

        if (next != null ? !next.equals(node.next) : node.next != null)
        {
            return false;
        }
        if (value != null ? !value.equals(node.value) : node.value != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        return  1;
    }

    @Override
    public String toString()
    {
        return "Node{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }
}
