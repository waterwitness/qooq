package com.fasterxml.jackson.core;

import java.io.IOException;

public class JsonProcessingException
  extends IOException
{
  static final long serialVersionUID = 123L;
  protected JsonLocation _location;
  
  protected JsonProcessingException(String paramString)
  {
    super(paramString);
  }
  
  protected JsonProcessingException(String paramString, JsonLocation paramJsonLocation)
  {
    this(paramString, paramJsonLocation, null);
  }
  
  protected JsonProcessingException(String paramString, JsonLocation paramJsonLocation, Throwable paramThrowable)
  {
    super(paramString);
    if (paramThrowable != null) {
      initCause(paramThrowable);
    }
    this._location = paramJsonLocation;
  }
  
  protected JsonProcessingException(String paramString, Throwable paramThrowable)
  {
    this(paramString, null, paramThrowable);
  }
  
  protected JsonProcessingException(Throwable paramThrowable)
  {
    this(null, null, paramThrowable);
  }
  
  public JsonLocation getLocation()
  {
    return this._location;
  }
  
  public String getMessage()
  {
    Object localObject2 = super.getMessage();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "N/A";
    }
    JsonLocation localJsonLocation = getLocation();
    String str = getMessageSuffix();
    if (localJsonLocation == null)
    {
      localObject2 = localObject1;
      if (str == null) {}
    }
    else
    {
      localObject2 = new StringBuilder(100);
      ((StringBuilder)localObject2).append((String)localObject1);
      if (str != null) {
        ((StringBuilder)localObject2).append(str);
      }
      if (localJsonLocation != null)
      {
        ((StringBuilder)localObject2).append('\n');
        ((StringBuilder)localObject2).append(" at ");
        ((StringBuilder)localObject2).append(localJsonLocation.toString());
      }
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return (String)localObject2;
  }
  
  protected String getMessageSuffix()
  {
    return null;
  }
  
  public String getOriginalMessage()
  {
    return super.getMessage();
  }
  
  public String toString()
  {
    return getClass().getName() + ": " + getMessage();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\JsonProcessingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */