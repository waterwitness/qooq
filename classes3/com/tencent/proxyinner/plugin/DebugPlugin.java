package com.tencent.proxyinner.plugin;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.tencent.proxyinner.utility.UtilMisc;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DebugPlugin
{
  private static final String DEBUG_SDCARD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/xplatform/zips";
  private static final String TAG = "TXProxy | DebugPlugin";
  String mLocalPath;
  
  public static String getTestPluginPath()
  {
    Log.i("TXProxy | DebugPlugin", "getTestPluginPath");
    String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/odapp/odproxy.test";
    Object localObject2 = new File(str1);
    Log.i("TXProxy | DebugPlugin", "TestFilePath = " + str1);
    if ((localObject2 == null) || (!((File)localObject2).exists())) {
      return null;
    }
    Log.i("TXProxy | DebugPlugin", "TestFilePath = " + str1);
    str1 = " ";
    Object localObject1 = str1;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream((File)localObject2);
      localObject2 = str1;
      if (localFileInputStream != null)
      {
        localObject1 = str1;
        localObject2 = new BufferedReader(new InputStreamReader(localFileInputStream));
        for (;;)
        {
          localObject1 = str1;
          String str2 = ((BufferedReader)localObject2).readLine();
          if (str2 == null) {
            break;
          }
          localObject1 = str1;
          Log.i("ODSDK|Util", "line = " + str2);
          localObject1 = str1;
          str1 = str1 + str2;
        }
        localObject1 = str1;
        localFileInputStream.close();
        localObject2 = str1;
      }
      localObject1 = localObject2;
      Log.i("TXProxy | DebugPlugin", "testPluginPath = " + (String)localObject2);
      localObject1 = localObject2;
      str1 = ((String)localObject2).trim();
      return str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return (String)localObject1;
  }
  
  private void initDebugPluginPath()
  {
    this.mLocalPath = UtilMisc.getTestPluginPath();
    if (this.mLocalPath == null) {}
    File localFile;
    do
    {
      return;
      localFile = new File(this.mLocalPath);
    } while ((localFile == null) || (localFile.exists()));
    this.mLocalPath = "";
  }
  
  /* Error */
  private void writePathToTestFile(String paramString)
  {
    // Byte code:
    //   0: new 25	java/io/File
    //   3: dup
    //   4: invokestatic 117	com/tencent/proxyinner/utility/UtilMisc:getTestFilePath	()Ljava/lang/String;
    //   7: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: aload_3
    //   12: invokevirtual 63	java/io/File:exists	()Z
    //   15: ifne +8 -> 23
    //   18: aload_3
    //   19: invokevirtual 120	java/io/File:createNewFile	()Z
    //   22: pop
    //   23: aconst_null
    //   24: astore 5
    //   26: aconst_null
    //   27: astore_2
    //   28: aconst_null
    //   29: astore 4
    //   31: new 122	java/io/FileOutputStream
    //   34: dup
    //   35: aload_3
    //   36: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: astore_3
    //   40: aload_3
    //   41: aload_1
    //   42: invokevirtual 127	java/lang/String:getBytes	()[B
    //   45: invokevirtual 131	java/io/FileOutputStream:write	([B)V
    //   48: aload_3
    //   49: ifnull +113 -> 162
    //   52: aload_3
    //   53: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   56: return
    //   57: astore_2
    //   58: aload_2
    //   59: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   62: goto -39 -> 23
    //   65: astore_1
    //   66: aload_1
    //   67: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   70: return
    //   71: astore_3
    //   72: aload 4
    //   74: astore_1
    //   75: aload_1
    //   76: astore_2
    //   77: aload_3
    //   78: invokevirtual 134	java/io/FileNotFoundException:printStackTrace	()V
    //   81: aload_1
    //   82: ifnull -26 -> 56
    //   85: aload_1
    //   86: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   89: return
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   95: return
    //   96: astore_3
    //   97: aload 5
    //   99: astore_1
    //   100: aload_1
    //   101: astore_2
    //   102: aload_3
    //   103: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   106: aload_1
    //   107: ifnull -51 -> 56
    //   110: aload_1
    //   111: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   114: return
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   120: return
    //   121: astore_1
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   130: aload_1
    //   131: athrow
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 133	java/io/IOException:printStackTrace	()V
    //   137: goto -7 -> 130
    //   140: astore_1
    //   141: aload_3
    //   142: astore_2
    //   143: goto -21 -> 122
    //   146: astore_2
    //   147: aload_3
    //   148: astore_1
    //   149: aload_2
    //   150: astore_3
    //   151: goto -51 -> 100
    //   154: astore_2
    //   155: aload_3
    //   156: astore_1
    //   157: aload_2
    //   158: astore_3
    //   159: goto -84 -> 75
    //   162: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	DebugPlugin
    //   0	163	1	paramString	String
    //   27	1	2	localObject1	Object
    //   57	2	2	localIOException1	java.io.IOException
    //   76	51	2	str	String
    //   132	2	2	localIOException2	java.io.IOException
    //   142	1	2	localIOException3	java.io.IOException
    //   146	4	2	localIOException4	java.io.IOException
    //   154	4	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   10	43	3	localObject2	Object
    //   71	7	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   96	52	3	localIOException5	java.io.IOException
    //   150	9	3	localObject3	Object
    //   29	44	4	localObject4	Object
    //   24	74	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   18	23	57	java/io/IOException
    //   52	56	65	java/io/IOException
    //   31	40	71	java/io/FileNotFoundException
    //   85	89	90	java/io/IOException
    //   31	40	96	java/io/IOException
    //   110	114	115	java/io/IOException
    //   31	40	121	finally
    //   77	81	121	finally
    //   102	106	121	finally
    //   126	130	132	java/io/IOException
    //   40	48	140	finally
    //   40	48	146	java/io/IOException
    //   40	48	154	java/io/FileNotFoundException
  }
  
  public String getPath()
  {
    return this.mLocalPath;
  }
  
  public void init(Context paramContext)
  {
    initDebugPluginPath();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\proxyinner\plugin\DebugPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */