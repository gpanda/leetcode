package leetcode.libs;

public class RInteger
{
    private int v;
    public RInteger(int v)
    {
        this.v = v;
    }

    public void add(int w)
    {
        v += w;
    }

    public void sub(int w)
    {
        v -= w;
    }

    public void mul(int w)
    {
        v *= w;
    }

    public void div(int w)
    {
        v /= w;
    }

    public int val()
    {
        return v;
    }

    public String toString()
    {
        return String.valueOf(v);
    }
}
