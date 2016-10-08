package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonStreamContext;

public class JsonWriteContext
  extends JsonStreamContext
{
  public static final int STATUS_EXPECT_NAME = 5;
  public static final int STATUS_EXPECT_VALUE = 4;
  public static final int STATUS_OK_AFTER_COLON = 2;
  public static final int STATUS_OK_AFTER_COMMA = 1;
  public static final int STATUS_OK_AFTER_SPACE = 3;
  public static final int STATUS_OK_AS_IS = 0;
  protected JsonWriteContext _child = null;
  protected String _currentName;
  protected final JsonWriteContext _parent;
  
  protected JsonWriteContext(int paramInt, JsonWriteContext paramJsonWriteContext)
  {
    this._type = paramInt;
    this._parent = paramJsonWriteContext;
    this._index = -1;
  }
  
  public static JsonWriteContext createRootContext()
  {
    return new JsonWriteContext(0, null);
  }
  
  private JsonWriteContext reset(int paramInt)
  {
    this._type = paramInt;
    this._index = -1;
    this._currentName = null;
    return this;
  }
  
  protected final void appendDesc(StringBuilder paramStringBuilder)
  {
    if (this._type == 2)
    {
      paramStringBuilder.append('{');
      if (this._currentName != null)
      {
        paramStringBuilder.append('"');
        paramStringBuilder.append(this._currentName);
        paramStringBuilder.append('"');
      }
      for (;;)
      {
        paramStringBuilder.append('}');
        return;
        paramStringBuilder.append('?');
      }
    }
    if (this._type == 1)
    {
      paramStringBuilder.append('[');
      paramStringBuilder.append(getCurrentIndex());
      paramStringBuilder.append(']');
      return;
    }
    paramStringBuilder.append("/");
  }
  
  public final JsonWriteContext createChildArrayContext()
  {
    JsonWriteContext localJsonWriteContext = this._child;
    if (localJsonWriteContext == null)
    {
      localJsonWriteContext = new JsonWriteContext(1, this);
      this._child = localJsonWriteContext;
      return localJsonWriteContext;
    }
    return localJsonWriteContext.reset(1);
  }
  
  public final JsonWriteContext createChildObjectContext()
  {
    JsonWriteContext localJsonWriteContext = this._child;
    if (localJsonWriteContext == null)
    {
      localJsonWriteContext = new JsonWriteContext(2, this);
      this._child = localJsonWriteContext;
      return localJsonWriteContext;
    }
    return localJsonWriteContext.reset(2);
  }
  
  public final String getCurrentName()
  {
    return this._currentName;
  }
  
  public final JsonWriteContext getParent()
  {
    return this._parent;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    appendDesc(localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public final int writeFieldName(String paramString)
  {
    if ((this._type != 2) || (this._currentName != null)) {
      return 4;
    }
    this._currentName = paramString;
    if (this._index < 0) {
      return 0;
    }
    return 1;
  }
  
  public final int writeValue()
  {
    int i = 0;
    if (this._type == 2) {
      if (this._currentName == null) {
        i = 5;
      }
    }
    do
    {
      int j;
      do
      {
        return i;
        this._currentName = null;
        this._index += 1;
        return 2;
        if (this._type != 1) {
          break;
        }
        j = this._index;
        this._index += 1;
      } while (j < 0);
      return 1;
      this._index += 1;
    } while (this._index == 0);
    return 3;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\json\JsonWriteContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */