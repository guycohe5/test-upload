package ProjectEnd.company;

public class Node<T> {

    private T value;
    private Node<T> next;

    public Node(T v)
    {
        value=v;
        next=null;
    }
    public Node(T v,Node<T> n)
    {
        value=v;
        next=n;
    }
    public Node<T> GetNext()
    {
        return next;
    }
    public T GetInfo()
    {
        return value;
    }
    public void setInfo(T v)
    {
        value=v;
    }
    public void SetNext(Node<T> n)
    {
        next=n;
    }
    public String PrintNode()
    {
        return value.toString();
    }

}
