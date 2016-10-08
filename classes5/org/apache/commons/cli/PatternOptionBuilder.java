package org.apache.commons.cli;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Date;

public class PatternOptionBuilder
{
  public static final Class<?> CLASS_VALUE;
  public static final Class<Date> DATE_VALUE;
  public static final Class<FileInputStream> EXISTING_FILE_VALUE;
  public static final Class<File[]> FILES_VALUE = File[].class;
  public static final Class<File> FILE_VALUE;
  public static final Class<Number> NUMBER_VALUE;
  public static final Class<Object> OBJECT_VALUE;
  public static final Class<String> STRING_VALUE = String.class;
  public static final Class<URL> URL_VALUE = URL.class;
  
  static
  {
    OBJECT_VALUE = Object.class;
    NUMBER_VALUE = Number.class;
    DATE_VALUE = Date.class;
    CLASS_VALUE = Class.class;
    EXISTING_FILE_VALUE = FileInputStream.class;
    FILE_VALUE = File.class;
  }
  
  public static Object getValueClass(char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return null;
    case '@': 
      return OBJECT_VALUE;
    case ':': 
      return STRING_VALUE;
    case '%': 
      return NUMBER_VALUE;
    case '+': 
      return CLASS_VALUE;
    case '#': 
      return DATE_VALUE;
    case '<': 
      return EXISTING_FILE_VALUE;
    case '>': 
      return FILE_VALUE;
    case '*': 
      return FILES_VALUE;
    }
    return URL_VALUE;
  }
  
  public static boolean isValueCode(char paramChar)
  {
    return (paramChar == '@') || (paramChar == ':') || (paramChar == '%') || (paramChar == '+') || (paramChar == '#') || (paramChar == '<') || (paramChar == '>') || (paramChar == '*') || (paramChar == '/') || (paramChar == '!');
  }
  
  public static Options parsePattern(String paramString)
  {
    boolean bool3 = true;
    char c1 = ' ';
    boolean bool1 = false;
    Object localObject1 = null;
    Options localOptions = new Options();
    int i = 0;
    if (i >= paramString.length()) {
      if (c1 != ' ')
      {
        paramString = Option.builder(String.valueOf(c1));
        if (localObject1 == null) {
          break label202;
        }
      }
    }
    label124:
    label202:
    for (boolean bool2 = bool3;; bool2 = false)
    {
      localOptions.addOption(paramString.hasArg(bool2).required(bool1).type((Class)localObject1).build());
      return localOptions;
      char c2 = paramString.charAt(i);
      if (!isValueCode(c2))
      {
        bool2 = bool1;
        Object localObject2 = localObject1;
        if (c1 != ' ')
        {
          localObject2 = Option.builder(String.valueOf(c1));
          if (localObject1 != null)
          {
            bool2 = true;
            localOptions.addOption(((Option.Builder)localObject2).hasArg(bool2).required(bool1).type((Class)localObject1).build());
            bool2 = false;
            localObject2 = null;
          }
        }
        else
        {
          c1 = c2;
          localObject1 = localObject2;
          bool1 = bool2;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        bool2 = false;
        break label124;
        if (c2 == '!') {
          bool1 = true;
        } else {
          localObject1 = (Class)getValueClass(c2);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\org\apache\commons\cli\PatternOptionBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */