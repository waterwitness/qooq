package org.apache.commons.cli;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class TypeHandler
{
  public static Class<?> createClass(String paramString)
    throws ParseException
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new ParseException("Unable to find the class: " + paramString);
    }
  }
  
  public static Date createDate(String paramString)
  {
    throw new UnsupportedOperationException("Not yet implemented");
  }
  
  public static File createFile(String paramString)
  {
    return new File(paramString);
  }
  
  public static File[] createFiles(String paramString)
  {
    throw new UnsupportedOperationException("Not yet implemented");
  }
  
  public static Number createNumber(String paramString)
    throws ParseException
  {
    try
    {
      if (paramString.indexOf('.') != -1) {
        return Double.valueOf(paramString);
      }
      paramString = Long.valueOf(paramString);
      return paramString;
    }
    catch (NumberFormatException paramString)
    {
      throw new ParseException(paramString.getMessage());
    }
  }
  
  /* Error */
  public static Object createObject(String paramString)
    throws ParseException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 20	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual 85	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   9: astore_1
    //   10: aload_1
    //   11: areturn
    //   12: astore_1
    //   13: new 13	org/apache/commons/cli/ParseException
    //   16: dup
    //   17: new 22	java/lang/StringBuilder
    //   20: dup
    //   21: ldc 24
    //   23: invokespecial 27	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokespecial 36	org/apache/commons/cli/ParseException:<init>	(Ljava/lang/String;)V
    //   36: athrow
    //   37: astore_1
    //   38: new 13	org/apache/commons/cli/ParseException
    //   41: dup
    //   42: new 22	java/lang/StringBuilder
    //   45: dup
    //   46: aload_1
    //   47: invokevirtual 89	java/lang/Object:getClass	()Ljava/lang/Class;
    //   50: invokevirtual 92	java/lang/Class:getName	()Ljava/lang/String;
    //   53: invokestatic 95	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   56: invokespecial 27	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: ldc 97
    //   61: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokespecial 36	org/apache/commons/cli/ParseException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramString	String
    //   4	7	1	localObject	Object
    //   12	1	1	localClassNotFoundException	ClassNotFoundException
    //   37	10	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	5	12	java/lang/ClassNotFoundException
    //   5	10	37	java/lang/Exception
  }
  
  public static URL createURL(String paramString)
    throws ParseException
  {
    try
    {
      URL localURL = new URL(paramString);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new ParseException("Unable to parse the URL: " + paramString);
    }
  }
  
  public static Object createValue(String paramString, Class<?> paramClass)
    throws ParseException
  {
    if (PatternOptionBuilder.STRING_VALUE == paramClass) {
      return paramString;
    }
    if (PatternOptionBuilder.OBJECT_VALUE == paramClass) {
      return createObject(paramString);
    }
    if (PatternOptionBuilder.NUMBER_VALUE == paramClass) {
      return createNumber(paramString);
    }
    if (PatternOptionBuilder.DATE_VALUE == paramClass) {
      return createDate(paramString);
    }
    if (PatternOptionBuilder.CLASS_VALUE == paramClass) {
      return createClass(paramString);
    }
    if (PatternOptionBuilder.FILE_VALUE == paramClass) {
      return createFile(paramString);
    }
    if (PatternOptionBuilder.EXISTING_FILE_VALUE == paramClass) {
      return createFile(paramString);
    }
    if (PatternOptionBuilder.FILES_VALUE == paramClass) {
      return createFiles(paramString);
    }
    if (PatternOptionBuilder.URL_VALUE == paramClass) {
      return createURL(paramString);
    }
    return null;
  }
  
  public static Object createValue(String paramString, Object paramObject)
    throws ParseException
  {
    return createValue(paramString, (Class)paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\TypeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */