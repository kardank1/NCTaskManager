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

        if(time < 0){
            throw new IllegalArgumentException("Invalid arguments!");
        }

        this.title = title;
        this.time = time;
        repeat = false;
        active = false;
    }

    public Task(String title, int start, int end, int interval){

        if(start > end) {
            throw new IllegalArgumentException("Invalid interval parametrs!");
        }
        if(interval < 0){
            throw new IllegalArgumentException("Invalid arguments!");
        }

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
        if(time < 0){
            throw new IllegalArgumentException("Invalid argument!");
        }
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
        if(start > end) {
            throw new IllegalArgumentException("Invalid interval parametrs!");
        }
        if(interval < 0){
            throw new IllegalArgumentException("Invalid arguments!");
        }
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
        if(current < 0){
            throw new IllegalArgumentException ("Invalid argument!");
        }

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
