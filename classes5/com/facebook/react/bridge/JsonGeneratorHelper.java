package com.facebook.react.bridge;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JsonGeneratorHelper
{
  private static void writeList(JsonGenerator paramJsonGenerator, String paramString, List paramList)
    throws IOException
  {
    paramJsonGenerator.writeArrayFieldStart(paramString);
    paramString = paramList.iterator();
    while (paramString.hasNext()) {
      paramJsonGenerator.writeObject(paramString.next());
    }
    paramJsonGenerator.writeEndArray();
  }
  
  private static void writeMap(JsonGenerator paramJsonGenerator, String paramString, Map paramMap)
    throws IOException
  {
    paramJsonGenerator.writeObjectFieldStart(paramString);
    paramString = paramMap.entrySet().iterator();
    while (paramString.hasNext())
    {
      paramMap = (Map.Entry)paramString.next();
      writeObjectField(paramJsonGenerator, paramMap.getKey().toString(), paramMap.getValue());
    }
    paramJsonGenerator.writeEndObject();
  }
  
  public static void writeObjectField(JsonGenerator paramJsonGenerator, String paramString, Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof Map))
    {
      writeMap(paramJsonGenerator, paramString, (Map)paramObject);
      return;
    }
    if ((paramObject instanceof List))
    {
      writeList(paramJsonGenerator, paramString, (List)paramObject);
      return;
    }
    paramJsonGenerator.writeObjectField(paramString, paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\JsonGeneratorHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */