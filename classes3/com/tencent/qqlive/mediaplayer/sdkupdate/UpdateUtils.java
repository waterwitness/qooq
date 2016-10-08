package com.tencent.qqlive.mediaplayer.sdkupdate;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class UpdateUtils
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static boolean b = false;
  private static TVK_SDKMgr.OnLogListener c = null;
  
  public static String a(File paramFile)
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = new FileInputStream(paramFile);
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      for (;;)
      {
        int i = paramFile.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramFile.close();
      paramFile = a(localMessageDigest.digest());
      return paramFile;
    }
    catch (Exception paramFile) {}
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(a[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(a[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void a(TVK_SDKMgr.OnLogListener paramOnLogListener)
  {
    c = paramOnLogListener;
  }
  
  public static void a(LogType paramLogType, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = "[" + paramString1 + "]" + paramString3;
    if (c != null) {
      switch (1.a[paramLogType.ordinal()])
      {
      }
    }
    while (!b)
    {
      return;
      c.v(paramString2, paramString1);
      return;
      c.d(paramString2, paramString1);
      return;
      c.i(paramString2, paramString1);
      return;
      c.w(paramString2, paramString1);
      return;
      c.e(paramString2, paramString1);
      return;
    }
    switch (1.a[paramLogType.ordinal()])
    {
    default: 
      return;
    case 1: 
      Log.v(paramString2, paramString1);
      return;
    case 2: 
      Log.d(paramString2, paramString1);
      return;
    case 3: 
      Log.i(paramString2, paramString1);
      return;
    case 4: 
      Log.w(paramString2, paramString1);
      return;
    }
    Log.e(paramString2, paramString1);
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 136	java/util/zip/ZipFile
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 139	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   10: astore 6
    //   12: aload 6
    //   14: invokevirtual 143	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   17: astore 7
    //   19: aconst_null
    //   20: astore_0
    //   21: aload_2
    //   22: astore_3
    //   23: aload_0
    //   24: astore 4
    //   26: aload 7
    //   28: invokeinterface 149 1 0
    //   33: ifeq +250 -> 283
    //   36: aload_2
    //   37: astore_3
    //   38: aload_0
    //   39: astore 4
    //   41: aload 7
    //   43: invokeinterface 153 1 0
    //   48: checkcast 155	java/util/zip/ZipEntry
    //   51: astore 8
    //   53: aload_2
    //   54: astore_3
    //   55: aload_0
    //   56: astore 4
    //   58: aload 6
    //   60: aload 8
    //   62: invokevirtual 159	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   65: astore 5
    //   67: aload 5
    //   69: astore_0
    //   70: aload 8
    //   72: invokevirtual 162	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   75: astore_3
    //   76: aload 8
    //   78: invokevirtual 165	java/util/zip/ZipEntry:isDirectory	()Z
    //   81: ifeq +53 -> 134
    //   84: aload_3
    //   85: iconst_0
    //   86: aload_3
    //   87: invokevirtual 170	java/lang/String:length	()I
    //   90: iconst_1
    //   91: isub
    //   92: invokevirtual 174	java/lang/String:substring	(II)Ljava/lang/String;
    //   95: astore_3
    //   96: new 176	java/io/File
    //   99: dup
    //   100: new 79	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   107: aload_1
    //   108: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: getstatic 180	java/io/File:separator	Ljava/lang/String;
    //   114: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_3
    //   118: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   127: invokevirtual 184	java/io/File:mkdirs	()Z
    //   130: pop
    //   131: goto -110 -> 21
    //   134: new 176	java/io/File
    //   137: dup
    //   138: new 79	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   145: aload_1
    //   146: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: getstatic 180	java/io/File:separator	Ljava/lang/String;
    //   152: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_3
    //   156: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   165: astore_3
    //   166: aload_3
    //   167: invokevirtual 188	java/io/File:getParentFile	()Ljava/io/File;
    //   170: invokevirtual 191	java/io/File:exists	()Z
    //   173: ifne +11 -> 184
    //   176: aload_3
    //   177: invokevirtual 188	java/io/File:getParentFile	()Ljava/io/File;
    //   180: invokevirtual 184	java/io/File:mkdirs	()Z
    //   183: pop
    //   184: new 193	java/io/FileOutputStream
    //   187: dup
    //   188: aload_3
    //   189: invokespecial 194	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   192: astore_3
    //   193: sipush 8192
    //   196: newarray <illegal type>
    //   198: astore_2
    //   199: aload_0
    //   200: aload_2
    //   201: iconst_0
    //   202: aload_2
    //   203: arraylength
    //   204: invokevirtual 197	java/io/InputStream:read	([BII)I
    //   207: istore 9
    //   209: iload 9
    //   211: iconst_m1
    //   212: if_icmpeq +62 -> 274
    //   215: aload_3
    //   216: aload_2
    //   217: iconst_0
    //   218: iload 9
    //   220: invokevirtual 200	java/io/FileOutputStream:write	([BII)V
    //   223: aload_3
    //   224: invokevirtual 203	java/io/FileOutputStream:flush	()V
    //   227: goto -28 -> 199
    //   230: astore_1
    //   231: aload_3
    //   232: astore_2
    //   233: aload_2
    //   234: astore_3
    //   235: aload_0
    //   236: astore 4
    //   238: aload_1
    //   239: athrow
    //   240: astore_1
    //   241: aload 4
    //   243: astore_0
    //   244: aload_3
    //   245: astore_2
    //   246: aload 6
    //   248: ifnull +8 -> 256
    //   251: aload 6
    //   253: invokevirtual 204	java/util/zip/ZipFile:close	()V
    //   256: aload_0
    //   257: ifnull +7 -> 264
    //   260: aload_0
    //   261: invokevirtual 70	java/io/InputStream:close	()V
    //   264: aload_2
    //   265: ifnull +7 -> 272
    //   268: aload_2
    //   269: invokevirtual 205	java/io/FileOutputStream:close	()V
    //   272: aload_1
    //   273: athrow
    //   274: aload_3
    //   275: invokevirtual 205	java/io/FileOutputStream:close	()V
    //   278: aload_3
    //   279: astore_2
    //   280: goto -259 -> 21
    //   283: aload 6
    //   285: ifnull +8 -> 293
    //   288: aload 6
    //   290: invokevirtual 204	java/util/zip/ZipFile:close	()V
    //   293: aload_0
    //   294: ifnull +7 -> 301
    //   297: aload_0
    //   298: invokevirtual 70	java/io/InputStream:close	()V
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 205	java/io/FileOutputStream:close	()V
    //   309: return
    //   310: astore_0
    //   311: aload_0
    //   312: athrow
    //   313: astore_0
    //   314: aload_0
    //   315: athrow
    //   316: astore_1
    //   317: aload_3
    //   318: astore_2
    //   319: goto -73 -> 246
    //   322: astore_1
    //   323: goto -77 -> 246
    //   326: astore_1
    //   327: goto -94 -> 233
    //   330: astore_1
    //   331: goto -98 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramString1	String
    //   0	334	1	paramString2	String
    //   1	318	2	localObject1	Object
    //   22	296	3	localObject2	Object
    //   24	218	4	str	String
    //   65	3	5	localInputStream	InputStream
    //   10	279	6	localZipFile	java.util.zip.ZipFile
    //   17	25	7	localEnumeration	java.util.Enumeration
    //   51	26	8	localZipEntry	java.util.zip.ZipEntry
    //   207	12	9	i	int
    // Exception table:
    //   from	to	target	type
    //   193	199	230	java/lang/Exception
    //   199	209	230	java/lang/Exception
    //   215	227	230	java/lang/Exception
    //   274	278	230	java/lang/Exception
    //   26	36	240	finally
    //   41	53	240	finally
    //   58	67	240	finally
    //   238	240	240	finally
    //   288	293	310	java/lang/Exception
    //   297	301	310	java/lang/Exception
    //   305	309	310	java/lang/Exception
    //   251	256	313	java/lang/Exception
    //   260	264	313	java/lang/Exception
    //   268	272	313	java/lang/Exception
    //   193	199	316	finally
    //   199	209	316	finally
    //   215	227	316	finally
    //   274	278	316	finally
    //   70	131	322	finally
    //   134	184	322	finally
    //   184	193	322	finally
    //   26	36	326	java/lang/Exception
    //   41	53	326	java/lang/Exception
    //   58	67	326	java/lang/Exception
    //   70	131	330	java/lang/Exception
    //   134	184	330	java/lang/Exception
    //   184	193	330	java/lang/Exception
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext != null)
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.getType() == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    try
    {
      paramFile1 = new FileInputStream(paramFile1);
      paramFile2 = new FileOutputStream(paramFile2);
      byte[] arrayOfByte = new byte[' '];
      for (;;)
      {
        int i = paramFile1.read(arrayOfByte, 0, 8192);
        if (i <= -1) {
          break;
        }
        paramFile2.write(arrayOfByte, 0, i);
      }
      paramFile2.flush();
      paramFile2.close();
      paramFile1.close();
      return true;
    }
    catch (Exception paramFile1) {}
    return false;
  }
  
  public static void b(File paramFile)
  {
    if (paramFile.isFile()) {
      paramFile.delete();
    }
    while (!paramFile.isDirectory()) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      b(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  public static enum LogType
  {
    private LogType() {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\qqlive\mediaplayer\sdkupdate\UpdateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */