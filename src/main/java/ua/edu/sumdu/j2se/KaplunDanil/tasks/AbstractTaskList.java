package ua.edu.sumdu.j2se.KaplunDanil.tasks;

import java.util.stream.Stream;



public abstract class AbstractTaskList implements Iterable<Task> {

    protected int size;
    protected static ListTypes.types type;

    public abstract void add(Task task);
    public abstract boolean remove(Task task);
    public abstract int size();
    public abstract Task getTask(int index);
    public final AbstractTaskList incoming(int from, int to)
    {
        AbstractTaskList resultList = TaskListFactory.createTaskList(ListTypes.getTypeList(this));
        this.getStream().filter(task -> task.nextTimeAfter(from) != -1 && task.nextTimeAfter(from) <= to).forEach(resultList::add);
        return resultList;
    }


    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if(obj instanceof AbstractTaskList)
        {
            return true;
        }
        AbstractTaskList convert = (AbstractTaskList) obj;
        if(this.size() != convert.size())
        {
            return false;
        }
        for(int i = 0; i < convert.size(); i++)
        {
            if (!this.getTask(i).equals(convert.getTask(i))) return false;
        }
        return true;
    }
    @Override
    public int hashCode()
    {
        int num = 4;
        for(Task t : this)
        {
            num *= 21;
            if(t != null)
            {
                num += t.hashCode();
            }
        }
        return num;
    }
    @Override
    public AbstractTaskList clone()
    {
        AbstractTaskList temp = TaskListFactory.createTaskList(ListTypes.getTypeList(this));
        for(int i = 0; i < this.size(); i++)
        {
            temp.add(this.getTask(i).clone());
        }
        return temp;
    }
    @Override
    public String toString()
    {
        String temp = "";
        for(int i = 0; i < size(); i++)
        {
            temp += "ЗАДАЧА № " + (i + 1) + "\n";
            temp += getTask(i).toString() + "\n";
        }
        return temp;
    }

    public abstract Stream<Task> getStream();
}



