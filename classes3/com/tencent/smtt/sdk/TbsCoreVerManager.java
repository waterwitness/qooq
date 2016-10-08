package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

class TbsCoreVerManager
{
  private static final String TAG = "TbsCoreVerManager";
  private static final String TBS_APK_PATH = "install_apk_path";
  private static final String TBS_CORE_COPY_RETRY_NUM = "copy_retry_num";
  private static final String TBS_CORE_COPY_STATUS = "copy_status";
  private static final String TBS_CORE_COPY_VER = "copy_core_ver";
  private static final String TBS_CORE_DEXOPT_RETRY_NUM = "dexopt_retry_num";
  private static final String TBS_CORE_INSTALL_FILE = "tbscoreinstall.txt";
  private static final String TBS_CORE_INSTALL_STATUS = "install_status";
  private static final String TBS_CORE_INSTALL_VER = "install_core_ver";
  private static final String TBS_CORE_UNZIP_RETRY_NUM = "unzip_retry_num";
  private static final String TBS_INCRUPDATE_STATUS = "incrupdate_status";
  private static Context mContext = null;
  private static TbsCoreVerManager mInstance = null;
  
  static TbsCoreVerManager getInstance(Context paramContext)
  {
    try
    {
      mContext = paramContext.getApplicationContext();
      if (mInstance == null) {
        mInstance = new TbsCoreVerManager();
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private Properties getTbsCoreInstallProp()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   6: astore_2
    //   7: new 73	java/util/Properties
    //   10: dup
    //   11: invokespecial 74	java/util/Properties:<init>	()V
    //   14: astore_1
    //   15: aload_2
    //   16: ifnull +108 -> 124
    //   19: aload_1
    //   20: ifnull +104 -> 124
    //   23: new 76	java/io/FileInputStream
    //   26: dup
    //   27: aload_2
    //   28: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_2
    //   32: aload_1
    //   33: aload_2
    //   34: invokevirtual 83	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   37: aload_2
    //   38: ifnull +7 -> 45
    //   41: aload_2
    //   42: invokevirtual 86	java/io/FileInputStream:close	()V
    //   45: aload_1
    //   46: astore_3
    //   47: aload_3
    //   48: areturn
    //   49: astore_2
    //   50: aload_2
    //   51: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   54: goto -9 -> 45
    //   57: astore_3
    //   58: aconst_null
    //   59: astore_2
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_3
    //   63: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   66: aload_1
    //   67: astore_3
    //   68: aload_2
    //   69: ifnull -22 -> 47
    //   72: aload_2
    //   73: invokevirtual 86	java/io/FileInputStream:close	()V
    //   76: aload_1
    //   77: areturn
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   83: aload_1
    //   84: areturn
    //   85: astore_1
    //   86: aload_3
    //   87: astore_2
    //   88: aload_2
    //   89: ifnull +7 -> 96
    //   92: aload_2
    //   93: invokevirtual 86	java/io/FileInputStream:close	()V
    //   96: aload_1
    //   97: athrow
    //   98: astore_2
    //   99: aload_2
    //   100: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   103: goto -7 -> 96
    //   106: astore_1
    //   107: goto -19 -> 88
    //   110: astore_1
    //   111: goto -23 -> 88
    //   114: astore_3
    //   115: aconst_null
    //   116: astore_2
    //   117: goto -55 -> 62
    //   120: astore_3
    //   121: goto -59 -> 62
    //   124: aconst_null
    //   125: astore_2
    //   126: goto -89 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	TbsCoreVerManager
    //   14	70	1	localProperties	Properties
    //   85	12	1	localObject1	Object
    //   106	1	1	localObject2	Object
    //   110	1	1	localObject3	Object
    //   6	36	2	localObject4	Object
    //   49	2	2	localIOException1	IOException
    //   59	14	2	localObject5	Object
    //   78	2	2	localIOException2	IOException
    //   87	6	2	localObject6	Object
    //   98	2	2	localIOException3	IOException
    //   116	10	2	localObject7	Object
    //   1	47	3	localObject8	Object
    //   57	6	3	localException1	Exception
    //   67	20	3	localObject9	Object
    //   114	1	3	localException2	Exception
    //   120	1	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   41	45	49	java/io/IOException
    //   2	15	57	java/lang/Exception
    //   72	76	78	java/io/IOException
    //   2	15	85	finally
    //   23	32	85	finally
    //   92	96	98	java/io/IOException
    //   32	37	106	finally
    //   62	66	110	finally
    //   23	32	114	java/lang/Exception
    //   32	37	120	java/lang/Exception
  }
  
  String getTbsApkPath()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("install_apk_path") != null)) {
      return localProperties.getProperty("install_apk_path");
    }
    return null;
  }
  
  int getTbsCoreCopyRetryNum()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("copy_retry_num") != null)) {
      return Integer.parseInt(localProperties.getProperty("copy_retry_num"));
    }
    return 0;
  }
  
  int getTbsCoreCopyStatus()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("copy_status") != null)) {
      return Integer.parseInt(localProperties.getProperty("copy_status"));
    }
    return -1;
  }
  
  int getTbsCoreCopyVer()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("copy_core_ver") != null)) {
      return Integer.parseInt(localProperties.getProperty("copy_core_ver"));
    }
    return 0;
  }
  
  int getTbsCoreDexoptRetryNum()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("dexopt_retry_num") != null)) {
      return Integer.parseInt(localProperties.getProperty("dexopt_retry_num"));
    }
    return 0;
  }
  
  int getTbsCoreIncrUpdateStatus()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("incrupdate_status") != null)) {
      return Integer.parseInt(localProperties.getProperty("incrupdate_status"));
    }
    return -1;
  }
  
  File getTbsCoreInstallFile()
  {
    TbsInstaller.getInstance();
    File localFile = new File(TbsInstaller.getTbsCorePrivateDir(mContext), "tbscoreinstall.txt");
    if ((localFile != null) && (!localFile.exists())) {}
    try
    {
      localFile.createNewFile();
      return localFile;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  int getTbsCoreInstallStatus()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("install_status") != null)) {
      return Integer.parseInt(localProperties.getProperty("install_status"));
    }
    return -1;
  }
  
  int getTbsCoreInstallVer()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("install_core_ver") != null)) {
      return Integer.parseInt(localProperties.getProperty("install_core_ver"));
    }
    return 0;
  }
  
  int getTbsCoreUnzipRetryNum()
  {
    Properties localProperties = getTbsCoreInstallProp();
    if ((localProperties != null) && (localProperties.getProperty("unzip_retry_num") != null)) {
      return Integer.parseInt(localProperties.getProperty("unzip_retry_num"));
    }
    return 0;
  }
  
  /* Error */
  void setTbsApkPath(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   9: astore 5
    //   11: aload 4
    //   13: astore_2
    //   14: aload 5
    //   16: ifnull +45 -> 61
    //   19: aload 5
    //   21: ldc 11
    //   23: aload_1
    //   24: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   27: pop
    //   28: aload_0
    //   29: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   32: astore_1
    //   33: aload 4
    //   35: astore_2
    //   36: aload_1
    //   37: ifnull +24 -> 61
    //   40: new 142	java/io/FileOutputStream
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: astore_1
    //   49: aload_1
    //   50: astore_2
    //   51: aload 5
    //   53: aload_1
    //   54: ldc -111
    //   56: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   59: aload_1
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +7 -> 69
    //   65: aload_2
    //   66: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   69: return
    //   70: astore_1
    //   71: aload_1
    //   72: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   75: return
    //   76: astore_3
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: astore_2
    //   81: aload_3
    //   82: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   85: aload_1
    //   86: ifnull -17 -> 69
    //   89: aload_1
    //   90: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   93: return
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   99: return
    //   100: astore_1
    //   101: aload_3
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   111: aload_1
    //   112: athrow
    //   113: astore_2
    //   114: aload_2
    //   115: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   118: goto -7 -> 111
    //   121: astore_1
    //   122: goto -19 -> 103
    //   125: astore_3
    //   126: goto -47 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	TbsCoreVerManager
    //   0	129	1	paramString	String
    //   13	95	2	localObject1	Object
    //   113	2	2	localIOException	IOException
    //   1	1	3	localObject2	Object
    //   76	26	3	localException1	Exception
    //   125	1	3	localException2	Exception
    //   3	31	4	localObject3	Object
    //   9	43	5	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   65	69	70	java/io/IOException
    //   5	11	76	java/lang/Exception
    //   19	33	76	java/lang/Exception
    //   40	49	76	java/lang/Exception
    //   89	93	94	java/io/IOException
    //   5	11	100	finally
    //   19	33	100	finally
    //   40	49	100	finally
    //   107	111	113	java/io/IOException
    //   51	59	121	finally
    //   81	85	121	finally
    //   51	59	125	java/lang/Exception
  }
  
  /* Error */
  void setTbsCoreCopyRetryNum(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   9: astore 5
    //   11: aload 4
    //   13: astore_2
    //   14: aload 5
    //   16: ifnull +49 -> 65
    //   19: aload 5
    //   21: ldc 14
    //   23: iload_1
    //   24: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   27: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   30: pop
    //   31: aload_0
    //   32: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   35: astore 6
    //   37: aload 4
    //   39: astore_2
    //   40: aload 6
    //   42: ifnull +23 -> 65
    //   45: new 142	java/io/FileOutputStream
    //   48: dup
    //   49: aload 6
    //   51: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_3
    //   57: aload 5
    //   59: aload_2
    //   60: ldc -96
    //   62: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   65: aload_2
    //   66: ifnull +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   73: return
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   79: return
    //   80: astore 4
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_2
    //   85: astore_3
    //   86: aload 4
    //   88: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   91: aload_2
    //   92: ifnull -19 -> 73
    //   95: aload_2
    //   96: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   99: return
    //   100: astore_2
    //   101: aload_2
    //   102: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   105: return
    //   106: astore_2
    //   107: aload_3
    //   108: ifnull +7 -> 115
    //   111: aload_3
    //   112: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   115: aload_2
    //   116: athrow
    //   117: astore_3
    //   118: aload_3
    //   119: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   122: goto -7 -> 115
    //   125: astore_2
    //   126: goto -19 -> 107
    //   129: astore 4
    //   131: goto -47 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	TbsCoreVerManager
    //   0	134	1	paramInt	int
    //   13	57	2	localObject1	Object
    //   74	2	2	localIOException1	IOException
    //   83	13	2	localObject2	Object
    //   100	2	2	localIOException2	IOException
    //   106	10	2	localObject3	Object
    //   125	1	2	localObject4	Object
    //   1	111	3	localObject5	Object
    //   117	2	3	localIOException3	IOException
    //   3	35	4	localObject6	Object
    //   80	7	4	localException1	Exception
    //   129	1	4	localException2	Exception
    //   9	49	5	localProperties	Properties
    //   35	15	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   69	73	74	java/io/IOException
    //   5	11	80	java/lang/Exception
    //   19	37	80	java/lang/Exception
    //   45	55	80	java/lang/Exception
    //   95	99	100	java/io/IOException
    //   5	11	106	finally
    //   19	37	106	finally
    //   45	55	106	finally
    //   111	115	117	java/io/IOException
    //   57	65	125	finally
    //   86	91	125	finally
    //   57	65	129	java/lang/Exception
  }
  
  /* Error */
  void setTbsCoreCopyStatus(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   10: astore 6
    //   12: aload 5
    //   14: astore_3
    //   15: aload 6
    //   17: ifnull +62 -> 79
    //   20: aload 6
    //   22: ldc 20
    //   24: iload_1
    //   25: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   28: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   31: pop
    //   32: aload 6
    //   34: ldc 17
    //   36: iload_2
    //   37: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   40: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   43: pop
    //   44: aload_0
    //   45: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   48: astore 7
    //   50: aload 5
    //   52: astore_3
    //   53: aload 7
    //   55: ifnull +24 -> 79
    //   58: new 142	java/io/FileOutputStream
    //   61: dup
    //   62: aload 7
    //   64: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: astore_3
    //   68: aload_3
    //   69: astore 4
    //   71: aload 6
    //   73: aload_3
    //   74: ldc -92
    //   76: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   79: aload_3
    //   80: ifnull +7 -> 87
    //   83: aload_3
    //   84: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   87: return
    //   88: astore_3
    //   89: aload_3
    //   90: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   93: return
    //   94: astore 5
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: astore 4
    //   101: aload 5
    //   103: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   106: aload_3
    //   107: ifnull -20 -> 87
    //   110: aload_3
    //   111: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   114: return
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   120: return
    //   121: astore_3
    //   122: aload 4
    //   124: ifnull +8 -> 132
    //   127: aload 4
    //   129: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   132: aload_3
    //   133: athrow
    //   134: astore 4
    //   136: aload 4
    //   138: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   141: goto -9 -> 132
    //   144: astore_3
    //   145: goto -23 -> 122
    //   148: astore 5
    //   150: goto -52 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	TbsCoreVerManager
    //   0	153	1	paramInt1	int
    //   0	153	2	paramInt2	int
    //   14	70	3	localObject1	Object
    //   88	2	3	localIOException1	IOException
    //   97	14	3	localObject2	Object
    //   115	2	3	localIOException2	IOException
    //   121	12	3	localObject3	Object
    //   144	1	3	localObject4	Object
    //   1	127	4	localObject5	Object
    //   134	3	4	localIOException3	IOException
    //   4	47	5	localObject6	Object
    //   94	8	5	localException1	Exception
    //   148	1	5	localException2	Exception
    //   10	62	6	localProperties	Properties
    //   48	15	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   83	87	88	java/io/IOException
    //   6	12	94	java/lang/Exception
    //   20	50	94	java/lang/Exception
    //   58	68	94	java/lang/Exception
    //   110	114	115	java/io/IOException
    //   6	12	121	finally
    //   20	50	121	finally
    //   58	68	121	finally
    //   127	132	134	java/io/IOException
    //   71	79	144	finally
    //   101	106	144	finally
    //   71	79	148	java/lang/Exception
  }
  
  /* Error */
  void setTbsCoreDexoptRetryNum(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   9: astore 5
    //   11: aload 4
    //   13: astore_2
    //   14: aload 5
    //   16: ifnull +49 -> 65
    //   19: aload 5
    //   21: ldc 23
    //   23: iload_1
    //   24: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   27: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   30: pop
    //   31: aload_0
    //   32: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   35: astore 6
    //   37: aload 4
    //   39: astore_2
    //   40: aload 6
    //   42: ifnull +23 -> 65
    //   45: new 142	java/io/FileOutputStream
    //   48: dup
    //   49: aload 6
    //   51: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_3
    //   57: aload 5
    //   59: aload_2
    //   60: ldc -89
    //   62: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   65: aload_2
    //   66: ifnull +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   73: return
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   79: return
    //   80: astore 4
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_2
    //   85: astore_3
    //   86: aload 4
    //   88: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   91: aload_2
    //   92: ifnull -19 -> 73
    //   95: aload_2
    //   96: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   99: return
    //   100: astore_2
    //   101: aload_2
    //   102: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   105: return
    //   106: astore_2
    //   107: aload_3
    //   108: ifnull +7 -> 115
    //   111: aload_3
    //   112: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   115: aload_2
    //   116: athrow
    //   117: astore_3
    //   118: aload_3
    //   119: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   122: goto -7 -> 115
    //   125: astore_2
    //   126: goto -19 -> 107
    //   129: astore 4
    //   131: goto -47 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	TbsCoreVerManager
    //   0	134	1	paramInt	int
    //   13	57	2	localObject1	Object
    //   74	2	2	localIOException1	IOException
    //   83	13	2	localObject2	Object
    //   100	2	2	localIOException2	IOException
    //   106	10	2	localObject3	Object
    //   125	1	2	localObject4	Object
    //   1	111	3	localObject5	Object
    //   117	2	3	localIOException3	IOException
    //   3	35	4	localObject6	Object
    //   80	7	4	localException1	Exception
    //   129	1	4	localException2	Exception
    //   9	49	5	localProperties	Properties
    //   35	15	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   69	73	74	java/io/IOException
    //   5	11	80	java/lang/Exception
    //   19	37	80	java/lang/Exception
    //   45	55	80	java/lang/Exception
    //   95	99	100	java/io/IOException
    //   5	11	106	finally
    //   19	37	106	finally
    //   45	55	106	finally
    //   111	115	117	java/io/IOException
    //   57	65	125	finally
    //   86	91	125	finally
    //   57	65	129	java/lang/Exception
  }
  
  /* Error */
  void setTbsCoreIncrUpdateStatus(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   9: astore 5
    //   11: aload 4
    //   13: astore_2
    //   14: aload 5
    //   16: ifnull +49 -> 65
    //   19: aload 5
    //   21: ldc 38
    //   23: iload_1
    //   24: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   27: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   30: pop
    //   31: aload_0
    //   32: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   35: astore 6
    //   37: aload 4
    //   39: astore_2
    //   40: aload 6
    //   42: ifnull +23 -> 65
    //   45: new 142	java/io/FileOutputStream
    //   48: dup
    //   49: aload 6
    //   51: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_3
    //   57: aload 5
    //   59: aload_2
    //   60: ldc -86
    //   62: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   65: aload_2
    //   66: ifnull +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   73: return
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   79: return
    //   80: astore 4
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_2
    //   85: astore_3
    //   86: aload 4
    //   88: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   91: aload_2
    //   92: ifnull -19 -> 73
    //   95: aload_2
    //   96: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   99: return
    //   100: astore_2
    //   101: aload_2
    //   102: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   105: return
    //   106: astore_2
    //   107: aload_3
    //   108: ifnull +7 -> 115
    //   111: aload_3
    //   112: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   115: aload_2
    //   116: athrow
    //   117: astore_3
    //   118: aload_3
    //   119: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   122: goto -7 -> 115
    //   125: astore_2
    //   126: goto -19 -> 107
    //   129: astore 4
    //   131: goto -47 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	TbsCoreVerManager
    //   0	134	1	paramInt	int
    //   13	57	2	localObject1	Object
    //   74	2	2	localIOException1	IOException
    //   83	13	2	localObject2	Object
    //   100	2	2	localIOException2	IOException
    //   106	10	2	localObject3	Object
    //   125	1	2	localObject4	Object
    //   1	111	3	localObject5	Object
    //   117	2	3	localIOException3	IOException
    //   3	35	4	localObject6	Object
    //   80	7	4	localException1	Exception
    //   129	1	4	localException2	Exception
    //   9	49	5	localProperties	Properties
    //   35	15	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   69	73	74	java/io/IOException
    //   5	11	80	java/lang/Exception
    //   19	37	80	java/lang/Exception
    //   45	55	80	java/lang/Exception
    //   95	99	100	java/io/IOException
    //   5	11	106	finally
    //   19	37	106	finally
    //   45	55	106	finally
    //   111	115	117	java/io/IOException
    //   57	65	125	finally
    //   86	91	125	finally
    //   57	65	129	java/lang/Exception
  }
  
  /* Error */
  void setTbsCoreInstallStatus(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   10: astore 6
    //   12: aload 5
    //   14: astore_3
    //   15: aload 6
    //   17: ifnull +62 -> 79
    //   20: aload 6
    //   22: ldc 32
    //   24: iload_1
    //   25: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   28: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   31: pop
    //   32: aload 6
    //   34: ldc 29
    //   36: iload_2
    //   37: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   40: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   43: pop
    //   44: aload_0
    //   45: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   48: astore 7
    //   50: aload 5
    //   52: astore_3
    //   53: aload 7
    //   55: ifnull +24 -> 79
    //   58: new 142	java/io/FileOutputStream
    //   61: dup
    //   62: aload 7
    //   64: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: astore_3
    //   68: aload_3
    //   69: astore 4
    //   71: aload 6
    //   73: aload_3
    //   74: ldc -86
    //   76: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   79: aload_3
    //   80: ifnull +7 -> 87
    //   83: aload_3
    //   84: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   87: return
    //   88: astore_3
    //   89: aload_3
    //   90: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   93: return
    //   94: astore 5
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: astore 4
    //   101: aload 5
    //   103: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   106: aload_3
    //   107: ifnull -20 -> 87
    //   110: aload_3
    //   111: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   114: return
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   120: return
    //   121: astore_3
    //   122: aload 4
    //   124: ifnull +8 -> 132
    //   127: aload 4
    //   129: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   132: aload_3
    //   133: athrow
    //   134: astore 4
    //   136: aload 4
    //   138: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   141: goto -9 -> 132
    //   144: astore_3
    //   145: goto -23 -> 122
    //   148: astore 5
    //   150: goto -52 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	TbsCoreVerManager
    //   0	153	1	paramInt1	int
    //   0	153	2	paramInt2	int
    //   14	70	3	localObject1	Object
    //   88	2	3	localIOException1	IOException
    //   97	14	3	localObject2	Object
    //   115	2	3	localIOException2	IOException
    //   121	12	3	localObject3	Object
    //   144	1	3	localObject4	Object
    //   1	127	4	localObject5	Object
    //   134	3	4	localIOException3	IOException
    //   4	47	5	localObject6	Object
    //   94	8	5	localException1	Exception
    //   148	1	5	localException2	Exception
    //   10	62	6	localProperties	Properties
    //   48	15	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   83	87	88	java/io/IOException
    //   6	12	94	java/lang/Exception
    //   20	50	94	java/lang/Exception
    //   58	68	94	java/lang/Exception
    //   110	114	115	java/io/IOException
    //   6	12	121	finally
    //   20	50	121	finally
    //   58	68	121	finally
    //   127	132	134	java/io/IOException
    //   71	79	144	finally
    //   101	106	144	finally
    //   71	79	148	java/lang/Exception
  }
  
  /* Error */
  void setTbsCoreUnzipRetryNum(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokespecial 94	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallProp	()Ljava/util/Properties;
    //   9: astore 5
    //   11: aload 4
    //   13: astore_2
    //   14: aload 5
    //   16: ifnull +49 -> 65
    //   19: aload 5
    //   21: ldc 35
    //   23: iload_1
    //   24: invokestatic 158	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   27: invokevirtual 140	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   30: pop
    //   31: aload_0
    //   32: invokevirtual 71	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallFile	()Ljava/io/File;
    //   35: astore 6
    //   37: aload 4
    //   39: astore_2
    //   40: aload 6
    //   42: ifnull +23 -> 65
    //   45: new 142	java/io/FileOutputStream
    //   48: dup
    //   49: aload 6
    //   51: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_3
    //   57: aload 5
    //   59: aload_2
    //   60: ldc -82
    //   62: invokevirtual 149	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   65: aload_2
    //   66: ifnull +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   73: return
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   79: return
    //   80: astore 4
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_2
    //   85: astore_3
    //   86: aload 4
    //   88: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   91: aload_2
    //   92: ifnull -19 -> 73
    //   95: aload_2
    //   96: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   99: return
    //   100: astore_2
    //   101: aload_2
    //   102: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   105: return
    //   106: astore_2
    //   107: aload_3
    //   108: ifnull +7 -> 115
    //   111: aload_3
    //   112: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   115: aload_2
    //   116: athrow
    //   117: astore_3
    //   118: aload_3
    //   119: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   122: goto -7 -> 115
    //   125: astore_2
    //   126: goto -19 -> 107
    //   129: astore 4
    //   131: goto -47 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	TbsCoreVerManager
    //   0	134	1	paramInt	int
    //   13	57	2	localObject1	Object
    //   74	2	2	localIOException1	IOException
    //   83	13	2	localObject2	Object
    //   100	2	2	localIOException2	IOException
    //   106	10	2	localObject3	Object
    //   125	1	2	localObject4	Object
    //   1	111	3	localObject5	Object
    //   117	2	3	localIOException3	IOException
    //   3	35	4	localObject6	Object
    //   80	7	4	localException1	Exception
    //   129	1	4	localException2	Exception
    //   9	49	5	localProperties	Properties
    //   35	15	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   69	73	74	java/io/IOException
    //   5	11	80	java/lang/Exception
    //   19	37	80	java/lang/Exception
    //   45	55	80	java/lang/Exception
    //   95	99	100	java/io/IOException
    //   5	11	106	finally
    //   19	37	106	finally
    //   45	55	106	finally
    //   111	115	117	java/io/IOException
    //   57	65	125	finally
    //   86	91	125	finally
    //   57	65	129	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\TbsCoreVerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */