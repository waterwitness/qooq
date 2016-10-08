package com.tencent.image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ArgumentsRunnable<T>
  implements Runnable
{
  private ArrayList<T> args = null;
  
  private final List<T> getArguments()
  {
    try
    {
      ArrayList localArrayList = this.args;
      this.args = null;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void add(T... paramVarArgs)
  {
    int i = 1;
    try
    {
      if (this.args == null)
      {
        i = 0;
        this.args = new ArrayList();
      }
      Collections.addAll(this.args, paramVarArgs);
      if (i == 0) {
        submit();
      }
      return;
    }
    finally {}
  }
  
  public final void run()
  {
    run(getArguments());
  }
  
  protected abstract void run(List<T> paramList);
  
  protected abstract void submit();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\ArgumentsRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */