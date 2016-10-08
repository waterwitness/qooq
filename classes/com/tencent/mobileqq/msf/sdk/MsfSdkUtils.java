package com.tencent.mobileqq.msf.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MsfSdkUtils
{
  private static final String APP_FILE_PATH = "/data/data/com.tencent.mobileqq/files";
  public static final String TAG_COREUTIL_TOMSGE_UID = "__CoreUtil_toMsg_Uid";
  public static final boolean isPublicVersion = false;
  private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
  private static final String tag = "MsfSdkUtils";
  public static final SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
  
  public static void addFromMsgProcessName(String paramString, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    paramFromServiceMsg.getAttributes().put("to_SenderProcessName", paramString);
  }
  
  public static void addLoginSimpleAccount(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object localObject = getNewAppUinStoreFile();
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        if (((File)localObject).exists())
        {
          if (isAccountFileExist((File)localObject, paramString)) {
            updateSimpleAccountNotCreate(paramString, true);
          }
        }
        else {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder().append(((File)localObject).getAbsolutePath()).append("/").append("u_").append(paramString);
        if (paramBoolean)
        {
          localObject = "_t";
          localObject = new File((String)localObject);
          try
          {
            ((File)localObject).createNewFile();
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel()) {
            QLog.d("MsfSdkUtils", 2, "add user failed " + paramString + " " + localException);
          }
        }
        else
        {
          String str = "_f";
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public static void addSimpleAccount(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 75	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getNewAppUinStoreFile	()Ljava/io/File;
    //   6: astore_1
    //   7: aload_1
    //   8: invokevirtual 81	java/io/File:exists	()Z
    //   11: ifne +8 -> 19
    //   14: aload_1
    //   15: invokevirtual 84	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: aload_1
    //   20: invokevirtual 81	java/io/File:exists	()Z
    //   23: ifeq +13 -> 36
    //   26: aload_1
    //   27: aload_0
    //   28: invokestatic 88	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:isAccountFileExist	(Ljava/io/File;Ljava/lang/String;)Z
    //   31: istore_2
    //   32: iload_2
    //   33: ifeq +7 -> 40
    //   36: ldc 2
    //   38: monitorexit
    //   39: return
    //   40: new 77	java/io/File
    //   43: dup
    //   44: new 93	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   51: aload_1
    //   52: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   55: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 104
    //   60: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 106
    //   65: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc -123
    //   74: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual 115	java/io/File:createNewFile	()Z
    //   88: pop
    //   89: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq -56 -> 36
    //   95: ldc 19
    //   97: iconst_2
    //   98: new 93	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   105: ldc -120
    //   107: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_0
    //   111: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: goto -84 -> 36
    //   123: astore_1
    //   124: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq -91 -> 36
    //   130: ldc 19
    //   132: iconst_2
    //   133: new 93	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   140: ldc 122
    //   142: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_0
    //   146: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc 124
    //   151: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_1
    //   155: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: goto -128 -> 36
    //   167: astore_0
    //   168: ldc 2
    //   170: monitorexit
    //   171: aload_0
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramString	String
    //   6	79	1	localFile	File
    //   123	32	1	localException	Exception
    //   31	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   84	120	123	java/lang/Exception
    //   3	19	167	finally
    //   19	32	167	finally
    //   40	84	167	finally
    //   84	120	167	finally
    //   124	164	167	finally
  }
  
  public static void addToMsgProcessName(String paramString, ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.getAttributes().put("to_SenderProcessName", paramString);
  }
  
  public static FromServiceMsg constructResponse(ToServiceMsg paramToServiceMsg, int paramInt, String paramString, Object paramObject)
  {
    if (paramToServiceMsg == null) {
      return new FromServiceMsg();
    }
    paramString = constructResponse(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd(), paramToServiceMsg.getAppId(), paramInt, paramString, paramObject, paramToServiceMsg.getRequestSsoSeq());
    paramString.setAppSeq(paramToServiceMsg.getAppSeq());
    return paramString;
  }
  
  public static FromServiceMsg constructResponse(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, Object paramObject, int paramInt3)
  {
    paramString1 = new FromServiceMsg(paramString1, paramString2);
    paramString1.setAppId(paramInt1);
    if (paramInt2 != 1000) {
      paramString1.setBusinessFail(paramInt2, paramString3);
    }
    for (;;)
    {
      if (paramObject != null) {
        paramString1.addAttribute(paramString2, paramObject);
      }
      paramString1.setRequestSsoSeq(paramInt3);
      return paramString1;
      paramString1.setMsgSuccess();
    }
  }
  
  public static int convertBytes2Int(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] << 24 & 0xFF000000 | paramArrayOfByte[1] << 16 & 0xFF0000 | paramArrayOfByte[2] << 8 & 0xFF00 | paramArrayOfByte[3] << 0 & 0xFF;
  }
  
  public static int convertBytes2Int(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 0)] << 24 & 0xFF000000 | paramArrayOfByte[(paramInt + 1)] << 16 & 0xFF0000 | paramArrayOfByte[(paramInt + 2)] << 8 & 0xFF00 | paramArrayOfByte[(paramInt + 3)] << 0 & 0xFF;
  }
  
  public static byte[] convertInt2Bytes(int paramInt)
  {
    return new byte[] { (byte)(paramInt >>> 24 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static void delSimpleAccount(String paramString)
  {
    try
    {
      File localFile = getNewAppUinStoreFile();
      if (localFile.exists())
      {
        String[] arrayOfString = localFile.list();
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if ((str.equals("u_" + paramString + "_f")) || (str.equals("u_" + paramString + "_t")))
          {
            new File(localFile.getPath(), str).delete();
            if (QLog.isColorLevel()) {
              QLog.d("MsfSdkUtils", 2, "del user succ " + paramString);
            }
          }
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
  
  public static File getAppUinBackStoreFile()
  {
    try
    {
      localObject = BaseApplication.getContext().getFilesDir().getAbsolutePath();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject = new File((String)localObject + "/simpleback.user");
          return (File)localObject;
        }
        catch (Exception localException2)
        {
          String str;
          localException2.printStackTrace();
        }
        localException1 = localException1;
        str = "/data/data/com.tencent.mobileqq/files";
      }
    }
    return null;
  }
  
  public static File getAppUinStoreFile()
  {
    try
    {
      localObject = BaseApplication.getContext().getFilesDir().getAbsolutePath();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject = new File((String)localObject + "/simple.user");
          return (File)localObject;
        }
        catch (Exception localException2)
        {
          String str;
          localException2.printStackTrace();
        }
        localException1 = localException1;
        str = "/data/data/com.tencent.mobileqq/files";
      }
    }
    return null;
  }
  
  public static ArrayList getLoginedAccountList()
  {
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        Object localObject1 = getNewAppUinStoreFile();
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          String[] arrayOfString = ((File)localObject1).list();
          localArrayList = new ArrayList();
          if (arrayOfString == null)
          {
            localObject1 = localArrayList;
            return (ArrayList)localObject1;
          }
          int j = arrayOfString.length;
          i = 0;
          localObject1 = localArrayList;
          if (i >= j) {
            continue;
          }
          localObject1 = arrayOfString[i];
          try
          {
            if (!((String)localObject1).startsWith("u_")) {
              break label328;
            }
            String str = ((String)localObject1).substring(2, ((String)localObject1).length() - 2);
            boolean bool = ((String)localObject1).endsWith("_t");
            SimpleAccount localSimpleAccount = new SimpleAccount();
            localSimpleAccount.setUin(str);
            localSimpleAccount.setAttribute("_isLogined", String.valueOf(bool));
            if (isUinLong(str)) {
              localArrayList.add(localSimpleAccount);
            } else {
              QLog.d("MsfSdkUtils", 1, "found invalid uin: " + str);
            }
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              break label328;
            }
          }
          QLog.d("MsfSdkUtils", 2, "parse user failed " + localException + " " + (String)localObject1);
        }
      }
      finally {}
      Object localObject3 = getLoginedAccountList(getAppUinStoreFile());
      if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0))
      {
        localArrayList = getLoginedAccountList(getAppUinBackStoreFile());
        localObject3 = localArrayList;
        if (localArrayList != null)
        {
          localObject3 = localArrayList;
          if (QLog.isColorLevel())
          {
            QLog.d("MsfSdkUtils", 2, "load accountList " + localArrayList.size() + " from backFile");
            localObject3 = localArrayList;
          }
        }
      }
      else
      {
        QLog.d("MsfSdkUtils", 1, "load accountList " + ((ArrayList)localObject3).size());
        continue;
        label328:
        i += 1;
      }
    }
  }
  
  /* Error */
  public static ArrayList getLoginedAccountList(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 236	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 237	java/util/ArrayList:<init>	()V
    //   10: astore_3
    //   11: aload_0
    //   12: ifnull +14 -> 26
    //   15: aload_0
    //   16: invokevirtual 81	java/io/File:exists	()Z
    //   19: istore 7
    //   21: iload 7
    //   23: ifne +8 -> 31
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_3
    //   30: areturn
    //   31: new 297	java/util/Properties
    //   34: dup
    //   35: invokespecial 298	java/util/Properties:<init>	()V
    //   38: astore_2
    //   39: new 300	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 303	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_1
    //   48: aload_1
    //   49: astore_0
    //   50: aload_2
    //   51: aload_1
    //   52: invokevirtual 307	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: invokevirtual 311	java/util/Properties:keySet	()Ljava/util/Set;
    //   61: invokeinterface 317 1 0
    //   66: astore 4
    //   68: aload_1
    //   69: astore_0
    //   70: aload 4
    //   72: invokeinterface 322 1 0
    //   77: ifeq +158 -> 235
    //   80: aload_1
    //   81: astore_0
    //   82: aload 4
    //   84: invokeinterface 326 1 0
    //   89: checkcast 201	java/lang/String
    //   92: astore 5
    //   94: aload_1
    //   95: astore_0
    //   96: aload_2
    //   97: aload 5
    //   99: invokevirtual 330	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 6
    //   104: aload 6
    //   106: ifnull -38 -> 68
    //   109: aload_1
    //   110: astore_0
    //   111: aload 6
    //   113: invokestatic 334	com/tencent/qphone/base/remote/SimpleAccount:parseSimpleAccount	(Ljava/lang/String;)Lcom/tencent/qphone/base/remote/SimpleAccount;
    //   116: astore 6
    //   118: aload 6
    //   120: ifnull -52 -> 68
    //   123: aload_1
    //   124: astore_0
    //   125: aload 6
    //   127: invokevirtual 335	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   130: invokestatic 269	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:isUinLong	(Ljava/lang/String;)Z
    //   133: ifeq +33 -> 166
    //   136: aload_1
    //   137: astore_0
    //   138: aload_3
    //   139: aload 6
    //   141: invokevirtual 272	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   144: pop
    //   145: goto -77 -> 68
    //   148: astore_2
    //   149: aload_1
    //   150: astore_0
    //   151: aload_2
    //   152: invokevirtual 229	java/lang/Exception:printStackTrace	()V
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 338	java/io/FileInputStream:close	()V
    //   163: goto -137 -> 26
    //   166: aload_1
    //   167: astore_0
    //   168: ldc 19
    //   170: iconst_1
    //   171: new 93	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 274
    //   181: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 5
    //   186: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   195: goto -127 -> 68
    //   198: astore_2
    //   199: aload_0
    //   200: astore_1
    //   201: aload_2
    //   202: astore_0
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 338	java/io/FileInputStream:close	()V
    //   211: aload_0
    //   212: athrow
    //   213: astore_0
    //   214: ldc 2
    //   216: monitorexit
    //   217: aload_0
    //   218: athrow
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 339	java/io/IOException:printStackTrace	()V
    //   224: goto -13 -> 211
    //   227: astore_0
    //   228: aload_0
    //   229: invokevirtual 339	java/io/IOException:printStackTrace	()V
    //   232: goto -69 -> 163
    //   235: aload_1
    //   236: ifnull -73 -> 163
    //   239: aload_1
    //   240: invokevirtual 338	java/io/FileInputStream:close	()V
    //   243: goto -80 -> 163
    //   246: astore_0
    //   247: aload_0
    //   248: invokevirtual 339	java/io/IOException:printStackTrace	()V
    //   251: goto -88 -> 163
    //   254: astore_0
    //   255: aconst_null
    //   256: astore_1
    //   257: goto -54 -> 203
    //   260: astore_2
    //   261: aconst_null
    //   262: astore_1
    //   263: goto -114 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramFile	File
    //   47	161	1	localObject1	Object
    //   219	21	1	localIOException	IOException
    //   256	7	1	localObject2	Object
    //   38	59	2	localProperties	java.util.Properties
    //   148	4	2	localException1	Exception
    //   198	4	2	localObject3	Object
    //   260	1	2	localException2	Exception
    //   10	129	3	localArrayList	ArrayList
    //   66	17	4	localIterator	Iterator
    //   92	93	5	str	String
    //   102	38	6	localObject4	Object
    //   19	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   50	55	148	java/lang/Exception
    //   57	68	148	java/lang/Exception
    //   70	80	148	java/lang/Exception
    //   82	94	148	java/lang/Exception
    //   96	104	148	java/lang/Exception
    //   111	118	148	java/lang/Exception
    //   125	136	148	java/lang/Exception
    //   138	145	148	java/lang/Exception
    //   168	195	148	java/lang/Exception
    //   50	55	198	finally
    //   57	68	198	finally
    //   70	80	198	finally
    //   82	94	198	finally
    //   96	104	198	finally
    //   111	118	198	finally
    //   125	136	198	finally
    //   138	145	198	finally
    //   151	155	198	finally
    //   168	195	198	finally
    //   3	11	213	finally
    //   15	21	213	finally
    //   31	39	213	finally
    //   159	163	213	finally
    //   207	211	213	finally
    //   211	213	213	finally
    //   220	224	213	finally
    //   228	232	213	finally
    //   239	243	213	finally
    //   247	251	213	finally
    //   207	211	219	java/io/IOException
    //   159	163	227	java/io/IOException
    //   239	243	246	java/io/IOException
    //   39	48	254	finally
    //   39	48	260	java/lang/Exception
  }
  
  public static File getNewAppUinStoreFile()
  {
    try
    {
      str1 = BaseApplication.getContext().getFilesDir().getAbsolutePath();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          String str1;
          File localFile = new File(str1 + "/user/");
          return localFile;
        }
        catch (Exception localException2)
        {
          String str2;
          if (!QLog.isColorLevel()) {
            break label89;
          }
          QLog.e("MsfSdkUtils", 2, "get user file error " + str2 + " " + localException2);
        }
        localException1 = localException1;
        str2 = "/data/data/com.tencent.mobileqq/files";
      }
    }
    label89:
    return null;
  }
  
  public static int getNextAppSeq()
  {
    try
    {
      int j = seqFactory.incrementAndGet();
      if (j > 1000000) {
        seqFactory.set(new Random().nextInt(100000));
      }
      int i = j;
      if (j == 50000) {
        i = j + 10000;
      }
      return i;
    }
    finally {}
  }
  
  public static String getProcessName(Context paramContext)
  {
    if (paramContext == null) {
      return "unknown";
    }
    Context localContext = null;
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      localContext = paramContext;
      Iterator localIterator = paramContext.iterator();
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
      do
      {
        do
        {
          localContext = paramContext;
          if (!localIterator.hasNext()) {
            break;
          }
          localContext = paramContext;
          localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        } while (localRunningAppProcessInfo == null);
        localContext = paramContext;
      } while (localRunningAppProcessInfo.pid != Process.myPid());
      localContext = paramContext;
      paramContext = localRunningAppProcessInfo.processName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      QLog.d("MsfSdkUtils", 1, "getProcessName error " + localContext, paramContext);
    }
    return "unknown";
  }
  
  public static String getResolutionString(Context paramContext)
  {
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    int j = paramContext.getResources().getDisplayMetrics().heightPixels;
    int k;
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      k = j;
      j = i;
    }
    for (;;)
    {
      return k + "X" + j;
      k = i;
    }
  }
  
  /* Error */
  public static String getServerConfig(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: aload_2
    //   3: invokestatic 431	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getServerConfigFile	(Ljava/lang/String;ILjava/lang/String;)Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +10 -> 18
    //   11: aload_2
    //   12: invokevirtual 81	java/io/File:exists	()Z
    //   15: ifne +7 -> 22
    //   18: ldc_w 433
    //   21: areturn
    //   22: new 93	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   29: astore 4
    //   31: aconst_null
    //   32: astore_0
    //   33: new 435	java/io/InputStreamReader
    //   36: dup
    //   37: new 300	java/io/FileInputStream
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 303	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: ldc_w 437
    //   48: invokespecial 440	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: astore_0
    //   54: sipush 4096
    //   57: newarray <illegal type>
    //   59: astore_3
    //   60: aload_2
    //   61: astore_0
    //   62: aload_2
    //   63: aload_3
    //   64: invokevirtual 444	java/io/InputStreamReader:read	([C)I
    //   67: istore_1
    //   68: iconst_m1
    //   69: iload_1
    //   70: if_icmpeq +61 -> 131
    //   73: aload_2
    //   74: astore_0
    //   75: aload 4
    //   77: aload_3
    //   78: iconst_0
    //   79: iload_1
    //   80: invokevirtual 447	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: goto -24 -> 60
    //   87: astore_3
    //   88: aload_2
    //   89: astore_0
    //   90: aload_3
    //   91: invokevirtual 229	java/lang/Exception:printStackTrace	()V
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 448	java/io/InputStreamReader:close	()V
    //   102: aload 4
    //   104: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: areturn
    //   108: astore_3
    //   109: aload_0
    //   110: astore_2
    //   111: aload_3
    //   112: astore_0
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 448	java/io/InputStreamReader:close	()V
    //   121: aload_0
    //   122: athrow
    //   123: astore_2
    //   124: goto -3 -> 121
    //   127: astore_0
    //   128: goto -26 -> 102
    //   131: aload_2
    //   132: ifnull -30 -> 102
    //   135: aload_2
    //   136: invokevirtual 448	java/io/InputStreamReader:close	()V
    //   139: goto -37 -> 102
    //   142: astore_3
    //   143: aload_0
    //   144: astore_2
    //   145: aload_3
    //   146: astore_0
    //   147: goto -34 -> 113
    //   150: astore_3
    //   151: aconst_null
    //   152: astore_2
    //   153: goto -65 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString1	String
    //   0	156	1	paramInt	int
    //   0	156	2	paramString2	String
    //   59	19	3	arrayOfChar	char[]
    //   87	4	3	localException1	Exception
    //   108	4	3	localObject1	Object
    //   142	4	3	localObject2	Object
    //   150	1	3	localException2	Exception
    //   29	74	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   54	60	87	java/lang/Exception
    //   62	68	87	java/lang/Exception
    //   75	84	87	java/lang/Exception
    //   33	52	108	finally
    //   117	121	123	java/io/IOException
    //   98	102	127	java/io/IOException
    //   135	139	127	java/io/IOException
    //   54	60	142	finally
    //   62	68	142	finally
    //   75	84	142	finally
    //   90	94	142	finally
    //   33	52	150	java/lang/Exception
  }
  
  public static File getServerConfigFile(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 == null) {}
    String str;
    do
    {
      return null;
      str = paramString1.replaceAll(":", "_");
      try
      {
        paramString1 = BaseApplication.getContext().getFilesDir().getAbsolutePath();
        if (paramInt == 0) {
          return new File(paramString1 + "/" + str + "_common");
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1 = "/data/data/com.tencent.mobileqq/files";
        }
        if (paramInt == 1) {
          return new File(paramString1 + "/" + str + "_" + paramString2.hashCode() + "_user");
        }
      }
    } while (paramInt != 2);
    return new File(paramString1 + "/" + str + "_app");
  }
  
  public static String getShortUin(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 4)) {
      return paramString;
    }
    return "*" + paramString.substring(paramString.length() - 4, paramString.length());
  }
  
  public static String getStackTraceString(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    for (Object localObject = paramThrowable; localObject != null; localObject = ((Throwable)localObject).getCause()) {
      if ((localObject instanceof UnknownHostException)) {
        return "";
      }
    }
    localObject = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return ((StringWriter)localObject).toString();
  }
  
  public static String getTotalMemory()
  {
    for (;;)
    {
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
        String str = localBufferedReader.readLine();
        if (str != null) {
          str = str.trim();
        }
        str = "";
      }
      catch (IOException localIOException1)
      {
        try
        {
          localBufferedReader.close();
          return str;
        }
        catch (IOException localIOException2)
        {
          continue;
        }
        localIOException1 = localIOException1;
        str = "";
        localIOException1.printStackTrace();
        return str;
      }
    }
  }
  
  public static String insertMtype(String paramString1, String paramString2)
  {
    if (paramString2.contains("mType=")) {}
    do
    {
      do
      {
        return paramString2;
      } while (paramString1 == null);
      int i = paramString2.indexOf("?");
      if (i > 0)
      {
        if (paramString2.length() == i + 1) {
          return paramString2.substring(0, i + 1) + "mType=" + paramString1;
        }
        i = paramString2.indexOf("#", i);
        if (i > -1) {}
        for (paramString1 = paramString2.substring(0, i) + "&mType=" + paramString1 + paramString2.substring(i);; paramString1 = paramString2 + "&mType=" + paramString1) {
          return paramString1;
        }
      }
    } while (paramString2.length() <= 0);
    return paramString2 + "?mType=" + paramString1;
  }
  
  private static boolean isAccountFileExist(File paramFile, String paramString)
  {
    boolean bool2 = false;
    paramFile = paramFile.list();
    boolean bool1 = bool2;
    int i;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (paramFile.length > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramFile.length)
      {
        if ((paramFile[i] != null) && ((paramFile[i].equals("u_" + paramString + "_f")) || (paramFile[i].equals("u_" + paramString + "_t")))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isScreenOn(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      boolean bool = ((Boolean)paramContext.getClass().getMethod("isScreenOn", new Class[0]).invoke(paramContext, (Object[])null)).booleanValue();
      return bool;
    }
    catch (Throwable paramContext)
    {
      QLog.d("MsfSdkUtils", 1, "e = " + paramContext.toString());
    }
    return true;
  }
  
  public static boolean isTopActivity(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      String str = paramContext.getPackageName();
      boolean bool = ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getPackageName().equals(str);
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean isUinLong(String paramString)
  {
    try
    {
      Long.parseLong(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static boolean killProcess(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.processName.equals(paramString))
      {
        Process.killProcess(localRunningAppProcessInfo.pid);
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public static java.util.Properties loadConfig(String paramString)
    throws Exception
  {
    // Byte code:
    //   0: new 297	java/util/Properties
    //   3: dup
    //   4: invokespecial 298	java/util/Properties:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aload_2
    //   13: areturn
    //   14: new 300	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 608	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 307	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   28: aload_1
    //   29: ifnull -17 -> 12
    //   32: aload_1
    //   33: invokevirtual 338	java/io/FileInputStream:close	()V
    //   36: aload_2
    //   37: areturn
    //   38: astore_0
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +7 -> 49
    //   45: aload_1
    //   46: invokevirtual 338	java/io/FileInputStream:close	()V
    //   49: aload_0
    //   50: athrow
    //   51: astore_0
    //   52: goto -11 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramString	String
    //   22	24	1	localFileInputStream	java.io.FileInputStream
    //   7	30	2	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   14	23	38	finally
    //   23	28	51	finally
  }
  
  /* Error */
  public static void saveConfig(String paramString, java.util.Properties paramProperties)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 613	java/io/FileOutputStream
    //   12: dup
    //   13: aload_0
    //   14: iconst_0
    //   15: invokespecial 615	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   18: astore_2
    //   19: aload_1
    //   20: aload_2
    //   21: ldc_w 433
    //   24: invokevirtual 619	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   27: aload_2
    //   28: ifnull -20 -> 8
    //   31: aload_2
    //   32: invokevirtual 620	java/io/FileOutputStream:close	()V
    //   35: return
    //   36: astore_0
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 620	java/io/FileOutputStream:close	()V
    //   47: aload_0
    //   48: athrow
    //   49: astore_0
    //   50: aload_2
    //   51: astore_1
    //   52: goto -13 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramString	String
    //   0	55	1	paramProperties	java.util.Properties
    //   18	33	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   9	19	36	finally
    //   19	27	49	finally
  }
  
  public static void updateSimpleAccount(String paramString, boolean paramBoolean)
  {
    label390:
    for (;;)
    {
      try
      {
        Object localObject2 = getNewAppUinStoreFile();
        int i;
        if (((File)localObject2).exists())
        {
          Object localObject3 = new StringBuilder().append(((File)localObject2).getAbsolutePath()).append("/").append("u_").append(paramString);
          if (!paramBoolean) {
            continue;
          }
          localObject1 = "_t";
          localObject1 = (String)localObject1;
          localObject3 = new File((String)localObject1);
          if (((File)localObject3).exists())
          {
            ((File)localObject3).delete();
            if (QLog.isColorLevel()) {
              QLog.d("MsfSdkUtils", 2, "found want update user exists,del " + paramString + " " + paramBoolean);
            }
          }
          localObject2 = ((File)localObject2).listFiles();
          if (localObject2 == null) {
            continue;
          }
          int j = localObject2.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject3 = localObject2[i];
          if ((!((File)localObject3).getName().equals("u_" + paramString + "_t")) && (!((File)localObject3).getName().equals("u_" + paramString + "_f"))) {
            break label390;
          }
          ((File)localObject3).renameTo(new File((String)localObject1));
          if (QLog.isColorLevel()) {
            QLog.d("MsfSdkUtils", 2, "update user succ " + paramString + " " + paramBoolean);
          }
        }
        return;
        Object localObject1 = "_f";
        continue;
        localObject1 = new File((String)localObject1);
        try
        {
          ((File)localObject1).createNewFile();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MsfSdkUtils", 2, "update add user succ " + MD5.toMD5(paramString));
        }
        catch (Exception localException)
        {
          QLog.d("MsfSdkUtils", 1, "update add user failed " + MD5.toMD5(paramString) + " " + localException);
        }
        continue;
        i += 1;
      }
      finally {}
    }
  }
  
  /* Error */
  public static void updateSimpleAccountNotCreate(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 75	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getNewAppUinStoreFile	()Ljava/io/File;
    //   6: astore_3
    //   7: aload_3
    //   8: invokevirtual 81	java/io/File:exists	()Z
    //   11: ifeq +172 -> 183
    //   14: new 93	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   21: aload_3
    //   22: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   25: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 104
    //   30: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 106
    //   35: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: astore 4
    //   44: iload_1
    //   45: ifeq +142 -> 187
    //   48: ldc 108
    //   50: astore_2
    //   51: aload 4
    //   53: aload_2
    //   54: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore_2
    //   61: new 77	java/io/File
    //   64: dup
    //   65: aload_2
    //   66: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   69: pop
    //   70: aload_3
    //   71: invokevirtual 630	java/io/File:listFiles	()[Ljava/io/File;
    //   74: astore_3
    //   75: aload_3
    //   76: ifnull +107 -> 183
    //   79: aload_3
    //   80: arraylength
    //   81: istore 6
    //   83: iconst_0
    //   84: istore 5
    //   86: iload 5
    //   88: iload 6
    //   90: if_icmpge +93 -> 183
    //   93: aload_3
    //   94: iload 5
    //   96: aaload
    //   97: astore 4
    //   99: aload 4
    //   101: invokevirtual 633	java/io/File:getName	()Ljava/lang/String;
    //   104: new 93	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   111: ldc 106
    //   113: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 108
    //   122: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifne +38 -> 169
    //   134: aload 4
    //   136: invokevirtual 633	java/io/File:getName	()Ljava/lang/String;
    //   139: new 93	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   146: ldc 106
    //   148: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc -123
    //   157: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq +27 -> 193
    //   169: aload 4
    //   171: new 77	java/io/File
    //   174: dup
    //   175: aload_2
    //   176: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   179: invokevirtual 637	java/io/File:renameTo	(Ljava/io/File;)Z
    //   182: pop
    //   183: ldc 2
    //   185: monitorexit
    //   186: return
    //   187: ldc -123
    //   189: astore_2
    //   190: goto -139 -> 51
    //   193: iload 5
    //   195: iconst_1
    //   196: iadd
    //   197: istore 5
    //   199: goto -113 -> 86
    //   202: astore_0
    //   203: ldc 2
    //   205: monitorexit
    //   206: aload_0
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramString	String
    //   0	208	1	paramBoolean	boolean
    //   50	140	2	str	String
    //   6	88	3	localObject	Object
    //   42	128	4	localStringBuilder	StringBuilder
    //   84	114	5	i	int
    //   81	10	6	j	int
    // Exception table:
    //   from	to	target	type
    //   3	44	202	finally
    //   51	75	202	finally
    //   79	83	202	finally
    //   99	169	202	finally
    //   169	183	202	finally
  }
  
  /* Error */
  public static void writeServerConfig(String paramString1, int paramInt, String paramString2, String paramString3)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: aload_3
    //   3: invokestatic 431	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getServerConfigFile	(Ljava/lang/String;ILjava/lang/String;)Ljava/io/File;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +14 -> 22
    //   11: new 295	java/io/IOException
    //   14: dup
    //   15: ldc_w 652
    //   18: invokespecial 653	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   21: athrow
    //   22: aload_3
    //   23: invokevirtual 81	java/io/File:exists	()Z
    //   26: ifne +8 -> 34
    //   29: aload_3
    //   30: invokevirtual 115	java/io/File:createNewFile	()Z
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 81	java/io/File:exists	()Z
    //   38: ifeq +10 -> 48
    //   41: aload_3
    //   42: invokevirtual 656	java/io/File:canWrite	()Z
    //   45: ifne +34 -> 79
    //   48: new 295	java/io/IOException
    //   51: dup
    //   52: new 93	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 658
    //   62: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_3
    //   66: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 653	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   78: athrow
    //   79: aconst_null
    //   80: astore_0
    //   81: new 660	java/io/OutputStreamWriter
    //   84: dup
    //   85: new 613	java/io/FileOutputStream
    //   88: dup
    //   89: aload_3
    //   90: invokespecial 661	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   93: ldc_w 437
    //   96: invokespecial 663	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   99: astore_3
    //   100: aload_3
    //   101: astore_0
    //   102: aload_3
    //   103: aload_2
    //   104: invokevirtual 666	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   107: aload_3
    //   108: astore_0
    //   109: aload_3
    //   110: invokevirtual 667	java/io/OutputStreamWriter:flush	()V
    //   113: aload_3
    //   114: ifnull +7 -> 121
    //   117: aload_3
    //   118: invokevirtual 668	java/io/OutputStreamWriter:close	()V
    //   121: return
    //   122: astore 4
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: astore_0
    //   128: aload 4
    //   130: invokevirtual 229	java/lang/Exception:printStackTrace	()V
    //   133: aload_2
    //   134: ifnull -13 -> 121
    //   137: aload_2
    //   138: invokevirtual 668	java/io/OutputStreamWriter:close	()V
    //   141: return
    //   142: astore_0
    //   143: return
    //   144: astore_3
    //   145: aload_0
    //   146: astore_2
    //   147: aload_3
    //   148: astore_0
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 668	java/io/OutputStreamWriter:close	()V
    //   157: aload_0
    //   158: athrow
    //   159: astore_2
    //   160: goto -3 -> 157
    //   163: astore_3
    //   164: aload_0
    //   165: astore_2
    //   166: aload_3
    //   167: astore_0
    //   168: goto -19 -> 149
    //   171: astore 4
    //   173: aload_3
    //   174: astore_2
    //   175: goto -49 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramString1	String
    //   0	178	1	paramInt	int
    //   0	178	2	paramString2	String
    //   0	178	3	paramString3	String
    //   122	7	4	localException1	Exception
    //   171	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   81	100	122	java/lang/Exception
    //   117	121	142	java/io/IOException
    //   137	141	142	java/io/IOException
    //   81	100	144	finally
    //   153	157	159	java/io/IOException
    //   102	107	163	finally
    //   109	113	163	finally
    //   128	133	163	finally
    //   102	107	171	java/lang/Exception
    //   109	113	171	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\MsfSdkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */