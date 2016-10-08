package com.tencent.smtt.utils;

import android.content.Context;
import java.io.File;

public class TbsConfigFile
{
  private static final String COMMON_CONFIG_FILE = "debug.conf";
  private static final String KEY_TBS_FORCE_USE_SYSTEMWEBVIEW = "setting_forceUseSystemWebview";
  private static final String KEY_TBS_FORCE_USE_SYSTEMWEBVIEW_RESULT = "result_systemWebviewForceUsed";
  static final String TBS_FOLDER_NAME = "tbs";
  static final String TBS_PRIVATE_FOLDER_NAME = "core_private";
  private static TbsConfigFile mInstance = null;
  private Context mContext = null;
  public boolean mForceUseSystemWebview = false;
  private boolean mForceUseSystemWebview_result = false;
  private File mTbsConfigDir = null;
  private File mpropFile = null;
  
  private TbsConfigFile(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    loadProperties();
  }
  
  private File getConfigFile()
  {
    try
    {
      if (this.mTbsConfigDir == null)
      {
        this.mTbsConfigDir = new File(this.mContext.getDir("tbs", 0), "core_private");
        if (this.mTbsConfigDir == null) {
          break label97;
        }
        if (!this.mTbsConfigDir.isDirectory()) {
          return null;
        }
      }
      File localFile2 = new File(this.mTbsConfigDir, "debug.conf");
      localFile1 = localFile2;
      if (localFile2 != null)
      {
        localFile1 = localFile2;
        if (!localFile2.exists())
        {
          localFile2.createNewFile();
          localFile1 = localFile2;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        File localFile1;
        localThrowable.printStackTrace();
        Object localObject = null;
      }
    }
    return localFile1;
    label97:
    return null;
  }
  
  public static TbsConfigFile getInstance()
  {
    try
    {
      TbsConfigFile localTbsConfigFile = mInstance;
      return localTbsConfigFile;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static TbsConfigFile getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TbsConfigFile(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public void loadProperties()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: getfield 49	com/tencent/smtt/utils/TbsConfigFile:mpropFile	Ljava/io/File;
    //   8: ifnonnull +11 -> 19
    //   11: aload_0
    //   12: aload_0
    //   13: invokespecial 93	com/tencent/smtt/utils/TbsConfigFile:getConfigFile	()Ljava/io/File;
    //   16: putfield 49	com/tencent/smtt/utils/TbsConfigFile:mpropFile	Ljava/io/File;
    //   19: aload_0
    //   20: getfield 49	com/tencent/smtt/utils/TbsConfigFile:mpropFile	Ljava/io/File;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnonnull +27 -> 52
    //   28: new 95	java/lang/NullPointerException
    //   31: dup
    //   32: invokespecial 96	java/lang/NullPointerException:<init>	()V
    //   35: athrow
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   44: goto -8 -> 36
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: new 99	java/io/FileInputStream
    //   55: dup
    //   56: aload_0
    //   57: getfield 49	com/tencent/smtt/utils/TbsConfigFile:mpropFile	Ljava/io/File;
    //   60: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: astore_2
    //   64: new 104	java/util/Properties
    //   67: dup
    //   68: invokespecial 105	java/util/Properties:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 109	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   77: aload_1
    //   78: ldc 11
    //   80: ldc 111
    //   82: invokevirtual 115	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_1
    //   86: ldc 111
    //   88: aload_1
    //   89: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifne +11 -> 103
    //   95: aload_0
    //   96: aload_1
    //   97: invokestatic 127	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   100: putfield 45	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview	Z
    //   103: aload_2
    //   104: invokevirtual 130	java/io/FileInputStream:close	()V
    //   107: goto -71 -> 36
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   115: goto -79 -> 36
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 84	java/lang/Throwable:printStackTrace	()V
    //   123: aload_1
    //   124: invokevirtual 130	java/io/FileInputStream:close	()V
    //   127: goto -91 -> 36
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   135: goto -99 -> 36
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_2
    //   141: aload_2
    //   142: invokevirtual 130	java/io/FileInputStream:close	()V
    //   145: aload_1
    //   146: athrow
    //   147: astore_2
    //   148: aload_2
    //   149: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   152: goto -7 -> 145
    //   155: astore_1
    //   156: goto -15 -> 141
    //   159: astore_3
    //   160: aload_1
    //   161: astore_2
    //   162: aload_3
    //   163: astore_1
    //   164: goto -23 -> 141
    //   167: astore_3
    //   168: aload_2
    //   169: astore_1
    //   170: aload_3
    //   171: astore_2
    //   172: goto -53 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	TbsConfigFile
    //   3	1	1	localObject1	Object
    //   39	2	1	localException1	Exception
    //   47	4	1	localObject2	Object
    //   71	26	1	localObject3	Object
    //   110	14	1	localException2	Exception
    //   130	2	1	localException3	Exception
    //   138	8	1	localObject4	Object
    //   155	6	1	localObject5	Object
    //   163	7	1	localObject6	Object
    //   23	81	2	localObject7	Object
    //   118	2	2	localThrowable1	Throwable
    //   140	2	2	localObject8	Object
    //   147	2	2	localException4	Exception
    //   161	11	2	localObject9	Object
    //   159	4	3	localObject10	Object
    //   167	4	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   28	36	39	java/lang/Exception
    //   28	36	47	finally
    //   40	44	47	finally
    //   103	107	47	finally
    //   111	115	47	finally
    //   123	127	47	finally
    //   131	135	47	finally
    //   141	145	47	finally
    //   145	147	47	finally
    //   148	152	47	finally
    //   103	107	110	java/lang/Exception
    //   4	19	118	java/lang/Throwable
    //   19	24	118	java/lang/Throwable
    //   52	64	118	java/lang/Throwable
    //   123	127	130	java/lang/Exception
    //   4	19	138	finally
    //   19	24	138	finally
    //   52	64	138	finally
    //   141	145	147	java/lang/Exception
    //   64	103	155	finally
    //   119	123	159	finally
    //   64	103	167	java/lang/Throwable
  }
  
  /* Error */
  public boolean resetProperties()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 93	com/tencent/smtt/utils/TbsConfigFile:getConfigFile	()Ljava/io/File;
    //   4: astore 4
    //   6: aload 4
    //   8: ifnonnull +34 -> 42
    //   11: new 95	java/lang/NullPointerException
    //   14: dup
    //   15: invokespecial 96	java/lang/NullPointerException:<init>	()V
    //   18: athrow
    //   19: new 95	java/lang/NullPointerException
    //   22: dup
    //   23: invokespecial 96	java/lang/NullPointerException:<init>	()V
    //   26: athrow
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   32: goto -13 -> 19
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   40: iconst_0
    //   41: ireturn
    //   42: new 99	java/io/FileInputStream
    //   45: dup
    //   46: aload 4
    //   48: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: astore_2
    //   52: aload_2
    //   53: astore_1
    //   54: new 104	java/util/Properties
    //   57: dup
    //   58: invokespecial 105	java/util/Properties:<init>	()V
    //   61: astore_3
    //   62: aload_2
    //   63: astore_1
    //   64: aload_3
    //   65: aload_2
    //   66: invokevirtual 109	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   69: aload_2
    //   70: astore_1
    //   71: aload_0
    //   72: iconst_0
    //   73: putfield 45	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview	Z
    //   76: aload_2
    //   77: astore_1
    //   78: aload_3
    //   79: ldc 11
    //   81: aload_0
    //   82: getfield 45	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview	Z
    //   85: invokestatic 135	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   88: invokevirtual 139	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   91: pop
    //   92: aload_2
    //   93: astore_1
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 47	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview_result	Z
    //   99: aload_2
    //   100: astore_1
    //   101: aload_3
    //   102: ldc 14
    //   104: aload_0
    //   105: getfield 47	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview_result	Z
    //   108: invokestatic 135	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   111: invokevirtual 139	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   114: pop
    //   115: aload_2
    //   116: astore_1
    //   117: aload_3
    //   118: new 141	java/io/FileOutputStream
    //   121: dup
    //   122: aload 4
    //   124: invokespecial 142	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   127: aconst_null
    //   128: invokevirtual 146	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   131: aload_2
    //   132: invokevirtual 130	java/io/FileInputStream:close	()V
    //   135: aload_2
    //   136: invokevirtual 130	java/io/FileInputStream:close	()V
    //   139: iconst_1
    //   140: ireturn
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   146: iconst_1
    //   147: ireturn
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   153: goto -18 -> 135
    //   156: astore_3
    //   157: aconst_null
    //   158: astore_2
    //   159: aload_2
    //   160: astore_1
    //   161: aload_3
    //   162: invokevirtual 84	java/lang/Throwable:printStackTrace	()V
    //   165: aload_2
    //   166: invokevirtual 130	java/io/FileInputStream:close	()V
    //   169: aload_2
    //   170: invokevirtual 130	java/io/FileInputStream:close	()V
    //   173: iconst_0
    //   174: ireturn
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   180: iconst_0
    //   181: ireturn
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   187: goto -18 -> 169
    //   190: astore_2
    //   191: aconst_null
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 130	java/io/FileInputStream:close	()V
    //   197: aload_1
    //   198: invokevirtual 130	java/io/FileInputStream:close	()V
    //   201: aload_2
    //   202: athrow
    //   203: astore_3
    //   204: aload_3
    //   205: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   208: goto -11 -> 197
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   216: goto -15 -> 201
    //   219: astore_2
    //   220: goto -27 -> 193
    //   223: astore_3
    //   224: goto -65 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	TbsConfigFile
    //   27	2	1	localException1	Exception
    //   35	2	1	localException2	Exception
    //   53	64	1	localObject1	Object
    //   141	2	1	localException3	Exception
    //   148	2	1	localException4	Exception
    //   160	1	1	localObject2	Object
    //   175	2	1	localException5	Exception
    //   182	2	1	localException6	Exception
    //   192	6	1	localObject3	Object
    //   211	2	1	localException7	Exception
    //   51	119	2	localFileInputStream	java.io.FileInputStream
    //   190	12	2	localObject4	Object
    //   219	1	2	localObject5	Object
    //   61	57	3	localProperties	java.util.Properties
    //   156	6	3	localThrowable1	Throwable
    //   203	2	3	localException8	Exception
    //   223	1	3	localThrowable2	Throwable
    //   4	119	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   11	19	27	java/lang/Exception
    //   19	27	35	java/lang/Exception
    //   135	139	141	java/lang/Exception
    //   131	135	148	java/lang/Exception
    //   0	6	156	java/lang/Throwable
    //   42	52	156	java/lang/Throwable
    //   169	173	175	java/lang/Exception
    //   165	169	182	java/lang/Exception
    //   0	6	190	finally
    //   42	52	190	finally
    //   193	197	203	java/lang/Exception
    //   197	201	211	java/lang/Exception
    //   54	62	219	finally
    //   64	69	219	finally
    //   71	76	219	finally
    //   78	92	219	finally
    //   94	99	219	finally
    //   101	115	219	finally
    //   117	131	219	finally
    //   161	165	219	finally
    //   54	62	223	java/lang/Throwable
    //   64	69	223	java/lang/Throwable
    //   71	76	223	java/lang/Throwable
    //   78	92	223	java/lang/Throwable
    //   94	99	223	java/lang/Throwable
    //   101	115	223	java/lang/Throwable
    //   117	131	223	java/lang/Throwable
  }
  
  /* Error */
  public void saveProperties()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 6
    //   8: aload_0
    //   9: invokespecial 93	com/tencent/smtt/utils/TbsConfigFile:getConfigFile	()Ljava/io/File;
    //   12: astore 5
    //   14: aload 5
    //   16: ifnonnull +33 -> 49
    //   19: new 95	java/lang/NullPointerException
    //   22: dup
    //   23: invokespecial 96	java/lang/NullPointerException:<init>	()V
    //   26: athrow
    //   27: new 95	java/lang/NullPointerException
    //   30: dup
    //   31: invokespecial 96	java/lang/NullPointerException:<init>	()V
    //   34: athrow
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   40: goto -13 -> 27
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   48: return
    //   49: new 99	java/io/FileInputStream
    //   52: dup
    //   53: aload 5
    //   55: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: astore_1
    //   59: aload_1
    //   60: astore_3
    //   61: aload 4
    //   63: astore_2
    //   64: new 104	java/util/Properties
    //   67: dup
    //   68: invokespecial 105	java/util/Properties:<init>	()V
    //   71: astore 7
    //   73: aload_1
    //   74: astore_3
    //   75: aload 4
    //   77: astore_2
    //   78: aload 7
    //   80: aload_1
    //   81: invokevirtual 109	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   84: aload_1
    //   85: astore_3
    //   86: aload 4
    //   88: astore_2
    //   89: aload 7
    //   91: ldc 11
    //   93: aload_0
    //   94: getfield 45	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview	Z
    //   97: invokestatic 135	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   100: invokevirtual 139	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   103: pop
    //   104: aload_1
    //   105: astore_3
    //   106: aload 4
    //   108: astore_2
    //   109: aload 7
    //   111: ldc 14
    //   113: aload_0
    //   114: getfield 47	com/tencent/smtt/utils/TbsConfigFile:mForceUseSystemWebview_result	Z
    //   117: invokestatic 135	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   120: invokevirtual 139	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   123: pop
    //   124: aload_1
    //   125: astore_3
    //   126: aload 4
    //   128: astore_2
    //   129: new 141	java/io/FileOutputStream
    //   132: dup
    //   133: aload 5
    //   135: invokespecial 142	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   138: astore 4
    //   140: aload 7
    //   142: aload 4
    //   144: aconst_null
    //   145: invokevirtual 146	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   148: aload_1
    //   149: invokevirtual 130	java/io/FileInputStream:close	()V
    //   152: aload 4
    //   154: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   157: return
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   163: return
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   169: goto -17 -> 152
    //   172: astore 4
    //   174: aconst_null
    //   175: astore 5
    //   177: aload 6
    //   179: astore_1
    //   180: aload 5
    //   182: astore_3
    //   183: aload_1
    //   184: astore_2
    //   185: aload 4
    //   187: invokevirtual 84	java/lang/Throwable:printStackTrace	()V
    //   190: aload 5
    //   192: invokevirtual 130	java/io/FileInputStream:close	()V
    //   195: aload_1
    //   196: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   199: return
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   205: return
    //   206: astore_2
    //   207: aload_2
    //   208: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   211: goto -16 -> 195
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 130	java/io/FileInputStream:close	()V
    //   222: aload_2
    //   223: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   226: aload 4
    //   228: athrow
    //   229: astore_1
    //   230: aload_1
    //   231: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   234: goto -12 -> 222
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   242: goto -16 -> 226
    //   245: astore 4
    //   247: aload_3
    //   248: astore_1
    //   249: goto -31 -> 218
    //   252: astore_3
    //   253: aload 4
    //   255: astore_2
    //   256: aload_3
    //   257: astore 4
    //   259: goto -41 -> 218
    //   262: astore 4
    //   264: aload_1
    //   265: astore 5
    //   267: aload 6
    //   269: astore_1
    //   270: goto -90 -> 180
    //   273: astore_3
    //   274: aload 4
    //   276: astore_2
    //   277: aload_3
    //   278: astore 4
    //   280: aload_1
    //   281: astore 5
    //   283: aload_2
    //   284: astore_1
    //   285: goto -105 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	TbsConfigFile
    //   35	2	1	localException1	Exception
    //   43	2	1	localException2	Exception
    //   58	91	1	localFileInputStream	java.io.FileInputStream
    //   158	2	1	localException3	Exception
    //   164	2	1	localException4	Exception
    //   179	17	1	localObject1	Object
    //   200	2	1	localException5	Exception
    //   217	2	1	localObject2	Object
    //   229	2	1	localException6	Exception
    //   237	2	1	localException7	Exception
    //   248	37	1	localObject3	Object
    //   1	184	2	localObject4	Object
    //   206	17	2	localException8	Exception
    //   255	29	2	localObject5	Object
    //   60	188	3	localObject6	Object
    //   252	5	3	localObject7	Object
    //   273	5	3	localThrowable1	Throwable
    //   3	150	4	localFileOutputStream	java.io.FileOutputStream
    //   172	14	4	localThrowable2	Throwable
    //   214	13	4	localObject8	Object
    //   245	9	4	localObject9	Object
    //   257	1	4	localObject10	Object
    //   262	13	4	localThrowable3	Throwable
    //   278	1	4	localObject11	Object
    //   12	270	5	localObject12	Object
    //   6	262	6	localObject13	Object
    //   71	70	7	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   19	27	35	java/lang/Exception
    //   27	35	43	java/lang/Exception
    //   152	157	158	java/lang/Exception
    //   148	152	164	java/lang/Exception
    //   8	14	172	java/lang/Throwable
    //   49	59	172	java/lang/Throwable
    //   195	199	200	java/lang/Exception
    //   190	195	206	java/lang/Exception
    //   8	14	214	finally
    //   49	59	214	finally
    //   218	222	229	java/lang/Exception
    //   222	226	237	java/lang/Exception
    //   64	73	245	finally
    //   78	84	245	finally
    //   89	104	245	finally
    //   109	124	245	finally
    //   129	140	245	finally
    //   185	190	245	finally
    //   140	148	252	finally
    //   64	73	262	java/lang/Throwable
    //   78	84	262	java/lang/Throwable
    //   89	104	262	java/lang/Throwable
    //   109	124	262	java/lang/Throwable
    //   129	140	262	java/lang/Throwable
    //   140	148	273	java/lang/Throwable
  }
  
  public void setForceUseSystemWebview(boolean paramBoolean)
  {
    this.mForceUseSystemWebview_result = paramBoolean;
    saveProperties();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\utils\TbsConfigFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */