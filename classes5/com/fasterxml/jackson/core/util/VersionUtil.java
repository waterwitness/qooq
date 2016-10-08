package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.regex.Pattern;

public class VersionUtil
{
  public static final String PACKAGE_VERSION_CLASS_NAME = "PackageVersion";
  @Deprecated
  public static final String VERSION_FILE = "VERSION.txt";
  private static final Pattern VERSION_SEPARATOR = Pattern.compile("[-_./;:]");
  private final Version _version;
  
  protected VersionUtil()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = versionFor(getClass());
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        System.err.println("ERROR: Failed to load Version information for bundle (via " + getClass().getName() + ").");
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = Version.unknownVersion();
    }
    this._version = ((Version)localObject2);
  }
  
  private static Version doReadVersion(Reader paramReader)
  {
    localObject1 = null;
    Object localObject2 = null;
    Object localObject7 = null;
    localObject5 = null;
    String str = null;
    localBufferedReader = new BufferedReader(paramReader);
    paramReader = (Reader)localObject2;
    try
    {
      localObject6 = localBufferedReader.readLine();
      paramReader = str;
      localObject1 = localObject7;
      if (localObject6 != null)
      {
        paramReader = (Reader)localObject2;
        localObject1 = localObject6;
        localObject2 = localBufferedReader.readLine();
        paramReader = str;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          paramReader = (Reader)localObject2;
          localObject1 = localObject6;
          str = localBufferedReader.readLine();
          paramReader = str;
          localObject1 = localObject2;
        }
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        try
        {
          label88:
          localBufferedReader.close();
          Object localObject3 = localObject5;
          localObject5 = paramReader;
          localObject6 = localObject1;
        }
        catch (IOException localIOException3)
        {
          Object localObject4 = localObject5;
          localObject5 = paramReader;
          Object localObject6 = localObject1;
        }
      }
    }
    finally
    {
      try
      {
        localBufferedReader.close();
        throw paramReader;
      }
      catch (IOException localIOException1)
      {
        for (;;) {}
      }
    }
    try
    {
      localBufferedReader.close();
      localObject5 = localObject1;
      localObject2 = paramReader;
    }
    catch (IOException localIOException4)
    {
      Reader localReader = paramReader;
      localObject5 = localIOException1;
      break label88;
    }
    paramReader = (Reader)localObject5;
    if (localObject5 != null) {
      paramReader = ((String)localObject5).trim();
    }
    localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = ((String)localObject2).trim();
    }
    return parseVersion((String)localObject6, paramReader, (String)localObject1);
  }
  
  /* Error */
  public static Version mavenVersionFor(ClassLoader paramClassLoader, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 58	java/lang/StringBuilder
    //   4: dup
    //   5: ldc 111
    //   7: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ldc 113
    //   13: ldc 115
    //   15: invokevirtual 119	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   18: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc 115
    //   23: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_2
    //   27: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 121
    //   32: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokevirtual 127	java/lang/ClassLoader:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   41: astore_0
    //   42: aload_0
    //   43: ifnull +53 -> 96
    //   46: new 129	java/util/Properties
    //   49: dup
    //   50: invokespecial 130	java/util/Properties:<init>	()V
    //   53: astore_1
    //   54: aload_1
    //   55: aload_0
    //   56: invokevirtual 134	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   59: aload_1
    //   60: ldc -120
    //   62: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore_2
    //   66: aload_1
    //   67: ldc -114
    //   69: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_3
    //   73: aload_2
    //   74: aload_1
    //   75: ldc -112
    //   77: invokevirtual 140	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   80: aload_3
    //   81: invokestatic 107	com/fasterxml/jackson/core/util/VersionUtil:parseVersion	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/fasterxml/jackson/core/Version;
    //   84: astore_1
    //   85: aload_0
    //   86: invokevirtual 147	java/io/InputStream:close	()V
    //   89: aload_1
    //   90: areturn
    //   91: astore_1
    //   92: aload_0
    //   93: invokevirtual 147	java/io/InputStream:close	()V
    //   96: invokestatic 48	com/fasterxml/jackson/core/Version:unknownVersion	()Lcom/fasterxml/jackson/core/Version;
    //   99: areturn
    //   100: astore_1
    //   101: aload_0
    //   102: invokevirtual 147	java/io/InputStream:close	()V
    //   105: aload_1
    //   106: athrow
    //   107: astore_0
    //   108: aload_1
    //   109: areturn
    //   110: astore_0
    //   111: goto -15 -> 96
    //   114: astore_0
    //   115: goto -10 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramClassLoader	ClassLoader
    //   0	118	1	paramString1	String
    //   0	118	2	paramString2	String
    //   72	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   46	85	91	java/io/IOException
    //   46	85	100	finally
    //   85	89	107	java/io/IOException
    //   92	96	110	java/io/IOException
    //   101	105	114	java/io/IOException
  }
  
  public static Version packageVersionFor(Class<?> paramClass)
  {
    try
    {
      paramClass = Class.forName(paramClass.getPackage().getName() + "." + "PackageVersion", true, paramClass.getClassLoader());
      if (paramClass == null) {
        return null;
      }
    }
    catch (Exception paramClass)
    {
      return null;
    }
    try
    {
      Object localObject = paramClass.newInstance();
      if (!(localObject instanceof Versioned)) {
        throw new IllegalArgumentException("Bad version class " + paramClass.getName() + ": does not implement " + Versioned.class.getName());
      }
    }
    catch (RuntimeException paramClass)
    {
      throw paramClass;
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException("Failed to instantiate " + paramClass.getName() + " to find version information, problem: " + localException.getMessage(), localException);
    }
    return ((Versioned)localException).version();
  }
  
  @Deprecated
  public static Version parseVersion(String paramString)
  {
    return parseVersion(paramString, null, null);
  }
  
  public static Version parseVersion(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = null;
    if (paramString1 == null) {}
    do
    {
      return null;
      paramString1 = paramString1.trim();
    } while (paramString1.length() == 0);
    String[] arrayOfString = VERSION_SEPARATOR.split(paramString1);
    int k = parseVersionPart(arrayOfString[0]);
    int i;
    if (arrayOfString.length > 1)
    {
      i = parseVersionPart(arrayOfString[1]);
      if (arrayOfString.length <= 2) {
        break label107;
      }
    }
    label107:
    for (int j = parseVersionPart(arrayOfString[2]);; j = 0)
    {
      paramString1 = (String)localObject;
      if (arrayOfString.length > 3) {
        paramString1 = arrayOfString[3];
      }
      return new Version(k, i, j, paramString1, paramString2, paramString3);
      i = 0;
      break;
    }
  }
  
  protected static int parseVersionPart(String paramString)
  {
    paramString = paramString.toString();
    int k = paramString.length();
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i >= k) {}
      int m;
      do
      {
        return j;
        m = paramString.charAt(i);
      } while ((m > 57) || (m < 48));
      j = j * 10 + (m - 48);
      i += 1;
    }
  }
  
  public static final void throwInternal()
  {
    throw new RuntimeException("Internal error: this code path should never get executed");
  }
  
  /* Error */
  public static Version versionFor(Class<?> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 224	com/fasterxml/jackson/core/util/VersionUtil:packageVersionFor	(Ljava/lang/Class;)Lcom/fasterxml/jackson/core/Version;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +5 -> 11
    //   9: aload_1
    //   10: areturn
    //   11: aload_0
    //   12: ldc 11
    //   14: invokevirtual 225	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_0
    //   18: aload_0
    //   19: ifnonnull +7 -> 26
    //   22: invokestatic 48	com/fasterxml/jackson/core/Version:unknownVersion	()Lcom/fasterxml/jackson/core/Version;
    //   25: areturn
    //   26: new 227	java/io/InputStreamReader
    //   29: dup
    //   30: aload_0
    //   31: ldc -27
    //   33: invokespecial 232	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   36: astore_1
    //   37: aload_1
    //   38: invokestatic 234	com/fasterxml/jackson/core/util/VersionUtil:doReadVersion	(Ljava/io/Reader;)Lcom/fasterxml/jackson/core/Version;
    //   41: astore_2
    //   42: aload_1
    //   43: invokevirtual 235	java/io/InputStreamReader:close	()V
    //   46: aload_0
    //   47: invokevirtual 147	java/io/InputStream:close	()V
    //   50: aload_2
    //   51: areturn
    //   52: astore_0
    //   53: new 150	java/lang/RuntimeException
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 238	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   61: athrow
    //   62: astore_2
    //   63: aload_1
    //   64: invokevirtual 235	java/io/InputStreamReader:close	()V
    //   67: aload_2
    //   68: athrow
    //   69: astore_1
    //   70: invokestatic 48	com/fasterxml/jackson/core/Version:unknownVersion	()Lcom/fasterxml/jackson/core/Version;
    //   73: astore_1
    //   74: aload_0
    //   75: invokevirtual 147	java/io/InputStream:close	()V
    //   78: aload_1
    //   79: areturn
    //   80: astore_0
    //   81: new 150	java/lang/RuntimeException
    //   84: dup
    //   85: aload_0
    //   86: invokespecial 238	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   89: athrow
    //   90: astore_1
    //   91: aload_0
    //   92: invokevirtual 147	java/io/InputStream:close	()V
    //   95: aload_1
    //   96: athrow
    //   97: astore_0
    //   98: new 150	java/lang/RuntimeException
    //   101: dup
    //   102: aload_0
    //   103: invokespecial 238	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   106: athrow
    //   107: astore_1
    //   108: goto -62 -> 46
    //   111: astore_1
    //   112: goto -45 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramClass	Class<?>
    //   4	60	1	localObject1	Object
    //   69	1	1	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   73	6	1	localVersion1	Version
    //   90	6	1	localObject2	Object
    //   107	1	1	localIOException1	IOException
    //   111	1	1	localIOException2	IOException
    //   41	10	2	localVersion2	Version
    //   62	6	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   46	50	52	java/io/IOException
    //   37	42	62	finally
    //   26	37	69	java/io/UnsupportedEncodingException
    //   42	46	69	java/io/UnsupportedEncodingException
    //   63	67	69	java/io/UnsupportedEncodingException
    //   67	69	69	java/io/UnsupportedEncodingException
    //   74	78	80	java/io/IOException
    //   26	37	90	finally
    //   42	46	90	finally
    //   63	67	90	finally
    //   67	69	90	finally
    //   70	74	90	finally
    //   91	95	97	java/io/IOException
    //   42	46	107	java/io/IOException
    //   63	67	111	java/io/IOException
  }
  
  public Version version()
  {
    return this._version;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\util\VersionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */