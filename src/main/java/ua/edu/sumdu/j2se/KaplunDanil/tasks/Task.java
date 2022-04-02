package ua.edu.sumdu.j2se.KaplunDanil.tasks;

public class Task {
    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private boolean repeat;


    public Task(String title, int time){
        this.title = title;
        this.time = time;
        repeat = false;
        active = false;
    }

    public Task(String title, int start, int end, int interval){
        this.title = title;
        time = start;
        this.start = start;
        this.end = end;
        this.interval = interval;
        repeat = true;
        active= false;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
        repeat = false;
    }

    public int getStartTime()
    {
        if(!repeat)
        {
            return time;
        }
        else
        {
            return start;
        }
    }

    public int getEndTime()
    {
        if(!repeat)
        {
            return time;
        }
        else
        {
            return end;
        }
    }

    public int getRepeatInterval()
    {
        if(!repeat)
        {
            return 0;
        }
        else
        {
            return interval;
        }
    }

    public void setTime(int start, int end, int interval)
    {
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.time = start;
        repeat = true;
    }

    public boolean isRepeated()
    {
        return repeat;
    }

    public int nextTimeAfter(int current){
        if(!active)
        {
            return  -1;
        }
        else
        {
            if(!repeat)
            {
                if(time <= current)
                {
                    return -1;
                }
                else
                {
                    return time;
                }
            }
            else
            {
                int temp = start;
                while (temp <= current)
                {
                    temp += interval;
                    if(temp > end)
                    {
                        return -1;
                    }
                }
                return temp;
            }
        }
    }
}
