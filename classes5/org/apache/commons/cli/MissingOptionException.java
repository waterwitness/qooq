package org.apache.commons.cli;

import java.util.Iterator;
import java.util.List;

public class MissingOptionException
  extends ParseException
{
  private static final long serialVersionUID = 8161889051578563249L;
  private List missingOptions;
  
  public MissingOptionException(String paramString)
  {
    super(paramString);
  }
  
  public MissingOptionException(List paramList)
  {
    this(createMessage(paramList));
    this.missingOptions = paramList;
  }
  
  private static String createMessage(List<?> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder("Missing required option");
    String str;
    if (paramList.size() == 1)
    {
      str = "";
      localStringBuilder.append(str);
      localStringBuilder.append(": ");
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext())
      {
        return localStringBuilder.toString();
        str = "s";
        break;
      }
      localStringBuilder.append(paramList.next());
      if (paramList.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
  }
  
  public List getMissingOptions()
  {
    return this.missingOptions;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\MissingOptionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */