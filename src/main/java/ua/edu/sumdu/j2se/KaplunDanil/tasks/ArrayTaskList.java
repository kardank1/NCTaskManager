package ua.edu.sumdu.j2se.KaplunDanil.tasks;

import java.util.Iterator;

public class ArrayTaskList extends AbstractTaskList{
    private int num;
    private Task [] tasks;

    public ArrayTaskList(){
        num = 1;
        tasks = new Task[num];
        size = 0;
    }

    public void add(Task task)
    {
        if(task == null){
            throw new NullPointerException("null argument!");
        }

        tasks[size] = task;
        size++;
        if(size == num)
        {
           tasks = sizeIncrease(tasks);
        }

    }

    public boolean remove(Task task)
    {
        boolean rem = false;

        for(int i = 0; i < size; i++)
        {
            if(task.equals(tasks[i]) && !rem)
            {

                tasks[i] = null;
                rem = true;
            }
            if(rem)
            {
                tasks[i] = tasks[i+1];
                tasks[i+1] = null;
            }
        }

        if(rem)
        {
            size--;
        }
        if(size < num - 5)
        {
           tasks = sizeDecrease(tasks);
        }

        return rem;
    }

    public int size()
    {
        return size;
    }

    public Task getTask(int index)
    {
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException("invalid index!");
        }
        return tasks[index];
    }

    public Task[] sizeIncrease(Task [] tasks)
    {
        num += 5;
        Task [] tasks1 = new Task[num];

        System.arraycopy(tasks, 0, tasks1, 0, tasks.length);
        return tasks1;
    }

    public Task[] sizeDecrease(Task [] tasks)
    {
        num -= 5;
        Task [] tasks1 = new Task[num];

        System.arraycopy(tasks, 0, tasks1, 0, tasks.length);
        return tasks1;
    }

    @Override
    public Iterator<Task> iterator() {
        return new Iterator<Task>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Task next() {
                if(index == size) {
                    throw new ArrayIndexOutOfBoundsException("Iterator reached last position!");
                }
                return tasks[index++];
            }


        };
    }
}
