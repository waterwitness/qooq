package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

final class SysUtil
{
  private static byte[] cachedBuffer = null;
  
  static File createLibsDirectory(Context paramContext)
  {
    paramContext = getLibsDirectory(paramContext);
    if ((!paramContext.isDirectory()) && (!paramContext.mkdirs())) {
      throw new RuntimeException("could not create libs directory");
    }
    return paramContext;
  }
  
  public static void deleteOrThrow(File paramFile)
    throws IOException
  {
    if (!paramFile.delete()) {
      throw new IOException("could not delete file " + paramFile);
    }
  }
  
  static void dumbDeleteRecrusive(File paramFile)
    throws IOException
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        dumbDeleteRecrusive(arrayOfFile[i]);
        i += 1;
      }
    }
    if ((!paramFile.delete()) && (paramFile.exists())) {
      throw new IOException("could not delete: " + paramFile);
    }
  }
  
  public static void fallocateIfSupported(FileDescriptor paramFileDescriptor, long paramLong)
    throws IOException
  {
    if (Build.VERSION.SDK_INT >= 21) {
      LollipopSysdeps.fallocate(paramFileDescriptor, paramLong);
    }
  }
  
  public static int findAbiScore(String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if ((paramArrayOfString[i] != null) && (paramString.equals(paramArrayOfString[i]))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static void freeCopyBuffer()
  {
    cachedBuffer = null;
  }
  
  static File getLibsDirectory(Context paramContext)
  {
    return new File(paramContext.getApplicationInfo().dataDir, "app_libs");
  }
  
  public static String[] getSupportedAbis()
  {
    return new String[] { Build.CPU_ABI, Build.CPU_ABI2 };
  }
  
  public static FileLocker lockLibsDirectory(Context paramContext)
    throws IOException
  {
    return FileLocker.lock(new File(paramContext.getApplicationInfo().dataDir, "libs-dir-lock"));
  }
  
  /* Error */
  public static void reliablyCopyExecutable(java.io.InputStream paramInputStream, File paramFile, long paramLong1, long paramLong2)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 45	java/io/File:delete	()Z
    //   4: pop
    //   5: aconst_null
    //   6: astore 6
    //   8: new 138	java/io/FileOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 140	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   16: astore 7
    //   18: getstatic 13	com/facebook/soloader/SysUtil:cachedBuffer	[B
    //   21: ifnonnull +74 -> 95
    //   24: sipush 16384
    //   27: newarray <illegal type>
    //   29: astore 6
    //   31: aload 6
    //   33: putstatic 13	com/facebook/soloader/SysUtil:cachedBuffer	[B
    //   36: lload_2
    //   37: lconst_0
    //   38: lcmp
    //   39: ifle +12 -> 51
    //   42: aload 7
    //   44: invokevirtual 144	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   47: lload_2
    //   48: invokestatic 146	com/facebook/soloader/SysUtil:fallocateIfSupported	(Ljava/io/FileDescriptor;J)V
    //   51: aload_0
    //   52: aload 6
    //   54: iconst_0
    //   55: aload 6
    //   57: arraylength
    //   58: invokevirtual 152	java/io/InputStream:read	([BII)I
    //   61: istore 8
    //   63: iload 8
    //   65: iflt +38 -> 103
    //   68: aload 7
    //   70: aload 6
    //   72: iconst_0
    //   73: iload 8
    //   75: invokevirtual 156	java/io/FileOutputStream:write	([BII)V
    //   78: goto -27 -> 51
    //   81: astore_0
    //   82: aload 7
    //   84: astore_1
    //   85: aload_1
    //   86: ifnull +7 -> 93
    //   89: aload_1
    //   90: invokevirtual 159	java/io/FileOutputStream:close	()V
    //   93: aload_0
    //   94: athrow
    //   95: getstatic 13	com/facebook/soloader/SysUtil:cachedBuffer	[B
    //   98: astore 6
    //   100: goto -64 -> 36
    //   103: aload 7
    //   105: invokevirtual 144	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   108: invokevirtual 164	java/io/FileDescriptor:sync	()V
    //   111: aload_1
    //   112: iconst_1
    //   113: invokevirtual 168	java/io/File:setExecutable	(Z)Z
    //   116: pop
    //   117: aload_1
    //   118: lload 4
    //   120: invokevirtual 172	java/io/File:setLastModified	(J)Z
    //   123: pop
    //   124: aload 7
    //   126: invokevirtual 144	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   129: invokevirtual 164	java/io/FileDescriptor:sync	()V
    //   132: aload 7
    //   134: ifnull +8 -> 142
    //   137: aload 7
    //   139: invokevirtual 159	java/io/FileOutputStream:close	()V
    //   142: return
    //   143: astore_0
    //   144: return
    //   145: astore_1
    //   146: goto -53 -> 93
    //   149: astore_0
    //   150: aload 6
    //   152: astore_1
    //   153: goto -68 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramInputStream	java.io.InputStream
    //   0	156	1	paramFile	File
    //   0	156	2	paramLong1	long
    //   0	156	4	paramLong2	long
    //   6	145	6	arrayOfByte	byte[]
    //   16	122	7	localFileOutputStream	java.io.FileOutputStream
    //   61	13	8	i	int
    // Exception table:
    //   from	to	target	type
    //   18	36	81	finally
    //   42	51	81	finally
    //   51	63	81	finally
    //   68	78	81	finally
    //   95	100	81	finally
    //   103	132	81	finally
    //   137	142	143	java/lang/Exception
    //   89	93	145	java/lang/Exception
    //   8	18	149	finally
  }
  
  private static final class LollipopSysdeps
  {
    public static void fallocate(FileDescriptor paramFileDescriptor, long paramLong)
      throws IOException
    {}
    
    public static String[] getSupportedAbis()
    {
      return null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\soloader\SysUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */