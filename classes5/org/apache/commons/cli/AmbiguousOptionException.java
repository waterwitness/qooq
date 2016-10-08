package org.apache.commons.cli;

import java.util.Collection;
import java.util.Iterator;

public class AmbiguousOptionException
  extends UnrecognizedOptionException
{
  private static final long serialVersionUID = 5829816121277947229L;
  private final Collection<String> matchingOptions;
  
  public AmbiguousOptionException(String paramString, Collection<String> paramCollection)
  {
    super(createMessage(paramString, paramCollection), paramString);
    this.matchingOptions = paramCollection;
  }
  
  private static String createMessage(String paramString, Collection<String> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder("Ambiguous option: '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'  (could be: ");
    paramString = paramCollection.iterator();
    for (;;)
    {
      if (!paramString.hasNext())
      {
        localStringBuilder.append(")");
        return localStringBuilder.toString();
      }
      localStringBuilder.append("'");
      localStringBuilder.append((String)paramString.next());
      localStringBuilder.append("'");
      if (paramString.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
  }
  
  public Collection<String> getMatchingOptions()
  {
    return this.matchingOptions;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\AmbiguousOptionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */