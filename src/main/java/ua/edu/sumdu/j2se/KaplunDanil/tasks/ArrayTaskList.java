package ua.edu.sumdu.j2se.KaplunDanil.tasks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

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

    public boolean remove(Task task) {
        if (task == null) {
            throw new NullPointerException("Task object parameter has null value!");
        }

        boolean status = false;
        int index_to_del;

        for (index_to_del = 0; index_to_del < size; index_to_del++) {
            if (tasks[index_to_del].equals(task)) {
                status = true;
                break;
            }
        }

        if (!status) {
            return false;
        }

        tasks[index_to_del] = null;
        size--;

        if (index_to_del != size) {
            System.arraycopy(tasks, index_to_del + 1, tasks, index_to_del, size - index_to_del);
        }

        if (tasks.length - 5 == size && size != 0) {
            Task[] tempArray = new Task[size];
            System.arraycopy(tasks, 0, tempArray, 0, size);
            tasks = tempArray;
        }
        return true;
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

    public Iterator<Task> iterator()
    {
        return new Iterator()
        {
            private int index = -1;

            @Override
            public boolean hasNext() {
                return (index + 1 < size());
            }

            @Override
            public Task next() {
                return getTask(++index);
            }

            @Override
            public void remove() {
                if (index < 0) throw new IllegalStateException("Итератор на нулевом элементе!");
                ArrayTaskList.this.remove(getTask(index));
                index--;
            }
        };
    }

    public int size()
    {
        return size;
    }

    public Task getTask(int index)
    {
        if(index >= 0 && index <= size) {
            return tasks[index];
            //return TaskList.get(index);
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ArrayTaskList clone() {
        return (ArrayTaskList) super.clone();
    }

    @Override
    public int hashCode() { return super.hashCode(); }
    public Stream<Task> getStream()
    {
        return Arrays.stream(this.tasks).filter(Objects::nonNull);
    }
}


