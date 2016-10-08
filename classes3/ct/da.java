package ct;

import java.util.Iterator;

public final class da
{
  private final String a;
  
  public da(String paramString)
  {
    this.a = paramString;
  }
  
  public final StringBuilder a(StringBuilder paramStringBuilder, Iterator<?> paramIterator)
  {
    Object localObject;
    if (paramIterator.hasNext())
    {
      localObject = paramIterator.next();
      if (localObject != null) {
        paramStringBuilder.append(localObject.toString());
      }
    }
    while (paramIterator.hasNext())
    {
      localObject = paramIterator.next();
      if (localObject != null)
      {
        paramStringBuilder.append(this.a);
        paramStringBuilder.append(localObject.toString());
      }
    }
    return paramStringBuilder;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */