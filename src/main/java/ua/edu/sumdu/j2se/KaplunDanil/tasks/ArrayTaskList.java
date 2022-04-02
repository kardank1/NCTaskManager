package ua.edu.sumdu.j2se.KaplunDanil.tasks;

public class ArrayTaskList {
    private int num;
    private Task [] tasks;
    private int iteratorNow;

    public ArrayTaskList(){
        num = 1;
        tasks = new Task[num];
        iteratorNow = 0;
    }

    public void add(Task task)
    {
        tasks[iteratorNow] = task;
        iteratorNow++;
        if(iteratorNow == num)
        {
           tasks = sizeIncrease(tasks);
        }

    }

    public boolean remove(Task task)
    {
        boolean rem = false;

        for(int i = 0; i < iteratorNow; i++)
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
            iteratorNow--;
        }
        if(iteratorNow < num - 5)
        {
           tasks = sizeDecrease(tasks);
        }

        return rem;
    }

    public int size()
    {
        return iteratorNow;
    }

    public Task getTask(int index)
    {
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

    ArrayTaskList incoming(int from, int to)
    {
        ArrayTaskList actual = new ArrayTaskList();

        for(Task temp:tasks)
        {
            if(temp.nextTimeAfter(from) < to && temp.nextTimeAfter(from) != -1)
            {
                actual.add(temp);
            }
        }
        return actual;
    }
}
