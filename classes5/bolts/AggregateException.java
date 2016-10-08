package bolts;

import java.util.ArrayList;
import java.util.List;

public class AggregateException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private Throwable[] causes;
  
  public AggregateException(String paramString, Throwable[] paramArrayOfThrowable) {}
  
  @Deprecated
  public AggregateException(List<Exception> paramList)
  {
    this("There were multiple errors.", (Throwable[])paramList.toArray(new Exception[paramList.size()]));
  }
  
  public Throwable[] getCauses()
  {
    return this.causes;
  }
  
  @Deprecated
  public List<Exception> getErrors()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.causes == null) {
      return localArrayList;
    }
    Throwable[] arrayOfThrowable = this.causes;
    int j = arrayOfThrowable.length;
    int i = 0;
    label29:
    Throwable localThrowable;
    if (i < j)
    {
      localThrowable = arrayOfThrowable[i];
      if (!(localThrowable instanceof Exception)) {
        break label68;
      }
      localArrayList.add((Exception)localThrowable);
    }
    for (;;)
    {
      i += 1;
      break label29;
      break;
      label68:
      localArrayList.add(new Exception(localThrowable));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\bolts\AggregateException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */