package com.tencent.smtt.utils;

import android.content.Context;
import android.provider.Settings.System;
import android.text.TextUtils;

public class QBInstallerRecorder
{
  private static final String INSTALLER_FILE = "ins.dat";
  private static final String SYS_SETTING_TBS_QB_INSTALLER = "sys_setting_tbs_qb_installer";
  private static final String TAG = "QBInstallerRecorder";
  private static Context mContext = null;
  private static QBInstallerRecorder mIntance = null;
  
  public static QBInstallerRecorder getInstance(Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
    if (mIntance == null) {
      mIntance = new QBInstallerRecorder();
    }
    return mIntance;
  }
  
  /* Error */
  private String loadQBInstallerFromSDCard()
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/smtt/utils/FileUtil:hasSDcard	()Z
    //   3: ifne +8 -> 11
    //   6: ldc 53
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: aconst_null
    //   12: astore 4
    //   14: aconst_null
    //   15: astore_2
    //   16: aconst_null
    //   17: astore_3
    //   18: aload_2
    //   19: astore_1
    //   20: new 55	java/io/File
    //   23: dup
    //   24: invokestatic 59	com/tencent/smtt/utils/FileUtil:getTbsSdcardShareDir	()Ljava/io/File;
    //   27: ldc 8
    //   29: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: astore 6
    //   34: aload_2
    //   35: astore_1
    //   36: aload 6
    //   38: invokevirtual 65	java/io/File:exists	()Z
    //   41: ifne +27 -> 68
    //   44: ldc 53
    //   46: astore_3
    //   47: aload_3
    //   48: astore_1
    //   49: iconst_0
    //   50: ifeq -41 -> 9
    //   53: new 67	java/lang/NullPointerException
    //   56: dup
    //   57: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   60: athrow
    //   61: astore_1
    //   62: aload_1
    //   63: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   66: aload_3
    //   67: areturn
    //   68: aload_2
    //   69: astore_1
    //   70: aload 6
    //   72: invokestatic 75	com/tencent/smtt/utils/FileUtil:read	(Ljava/io/File;)[B
    //   75: astore 5
    //   77: aload 5
    //   79: ifnull +11 -> 90
    //   82: aload_2
    //   83: astore_1
    //   84: aload 5
    //   86: arraylength
    //   87: ifgt +24 -> 111
    //   90: ldc 53
    //   92: astore_3
    //   93: aload_3
    //   94: astore_1
    //   95: iconst_0
    //   96: ifeq -87 -> 9
    //   99: new 67	java/lang/NullPointerException
    //   102: dup
    //   103: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   106: athrow
    //   107: astore_1
    //   108: goto -46 -> 62
    //   111: aload_2
    //   112: astore_1
    //   113: new 77	java/io/DataInputStream
    //   116: dup
    //   117: aload 6
    //   119: invokestatic 81	com/tencent/smtt/utils/FileUtil:openInputStream	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   122: invokespecial 84	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   125: astore_2
    //   126: aload_2
    //   127: invokevirtual 87	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   130: astore_3
    //   131: aload_3
    //   132: astore_1
    //   133: aload_2
    //   134: ifnull -125 -> 9
    //   137: aload_2
    //   138: invokevirtual 90	java/io/DataInputStream:close	()V
    //   141: aload_3
    //   142: areturn
    //   143: astore_1
    //   144: goto -82 -> 62
    //   147: astore_1
    //   148: aload_3
    //   149: astore_2
    //   150: aload_1
    //   151: astore_3
    //   152: aload_2
    //   153: astore_1
    //   154: aload_3
    //   155: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 90	java/io/DataInputStream:close	()V
    //   166: ldc 53
    //   168: areturn
    //   169: astore_3
    //   170: aload 4
    //   172: astore_2
    //   173: aload_2
    //   174: astore_1
    //   175: aload_3
    //   176: invokevirtual 92	java/lang/Error:printStackTrace	()V
    //   179: aload_2
    //   180: ifnull -14 -> 166
    //   183: aload_2
    //   184: invokevirtual 90	java/io/DataInputStream:close	()V
    //   187: goto -21 -> 166
    //   190: astore_1
    //   191: aload_1
    //   192: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   195: goto -29 -> 166
    //   198: astore_3
    //   199: aload_1
    //   200: astore_2
    //   201: aload_3
    //   202: astore_1
    //   203: aload_2
    //   204: ifnull +7 -> 211
    //   207: aload_2
    //   208: invokevirtual 90	java/io/DataInputStream:close	()V
    //   211: aload_1
    //   212: athrow
    //   213: astore_2
    //   214: aload_2
    //   215: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   218: goto -7 -> 211
    //   221: astore_1
    //   222: goto -31 -> 191
    //   225: astore_1
    //   226: goto -23 -> 203
    //   229: astore_3
    //   230: goto -57 -> 173
    //   233: astore_3
    //   234: goto -82 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	QBInstallerRecorder
    //   8	41	1	localObject1	Object
    //   61	2	1	localIOException1	java.io.IOException
    //   69	26	1	localObject2	Object
    //   107	1	1	localIOException2	java.io.IOException
    //   112	21	1	localObject3	Object
    //   143	1	1	localIOException3	java.io.IOException
    //   147	4	1	localException1	Exception
    //   153	22	1	localObject4	Object
    //   190	10	1	localIOException4	java.io.IOException
    //   202	10	1	localObject5	Object
    //   221	1	1	localIOException5	java.io.IOException
    //   225	1	1	localObject6	Object
    //   15	193	2	localObject7	Object
    //   213	2	2	localIOException6	java.io.IOException
    //   17	138	3	localObject8	Object
    //   169	7	3	localError1	Error
    //   198	4	3	localObject9	Object
    //   229	1	3	localError2	Error
    //   233	1	3	localException2	Exception
    //   12	159	4	localObject10	Object
    //   75	10	5	arrayOfByte	byte[]
    //   32	86	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   53	61	61	java/io/IOException
    //   99	107	107	java/io/IOException
    //   137	141	143	java/io/IOException
    //   20	34	147	java/lang/Exception
    //   36	44	147	java/lang/Exception
    //   70	77	147	java/lang/Exception
    //   84	90	147	java/lang/Exception
    //   113	126	147	java/lang/Exception
    //   20	34	169	java/lang/Error
    //   36	44	169	java/lang/Error
    //   70	77	169	java/lang/Error
    //   84	90	169	java/lang/Error
    //   113	126	169	java/lang/Error
    //   183	187	190	java/io/IOException
    //   20	34	198	finally
    //   36	44	198	finally
    //   70	77	198	finally
    //   84	90	198	finally
    //   113	126	198	finally
    //   154	158	198	finally
    //   175	179	198	finally
    //   207	211	213	java/io/IOException
    //   162	166	221	java/io/IOException
    //   126	131	225	finally
    //   126	131	229	java/lang/Error
    //   126	131	233	java/lang/Exception
  }
  
  private String loadQBInstallerFromSysSetting()
  {
    try
    {
      str1 = Settings.System.getString(mContext.getContentResolver(), "sys_setting_tbs_qb_installer");
      String str2 = str1;
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        if (TextUtils.isEmpty(str1)) {
          str2 = "";
        }
        return str2;
      }
      catch (Exception localException2)
      {
        String str1;
        for (;;) {}
      }
      localException1 = localException1;
      str1 = "";
    }
    return str1;
  }
  
  /* Error */
  private void recordInstallerToSDCard(String paramString)
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/smtt/utils/FileUtil:hasSDcard	()Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aconst_null
    //   8: astore_3
    //   9: aconst_null
    //   10: astore 4
    //   12: aload_3
    //   13: astore_2
    //   14: new 55	java/io/File
    //   17: dup
    //   18: invokestatic 59	com/tencent/smtt/utils/FileUtil:getTbsSdcardShareDir	()Ljava/io/File;
    //   21: ldc 8
    //   23: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore 5
    //   28: aload_3
    //   29: astore_2
    //   30: aload 5
    //   32: invokevirtual 65	java/io/File:exists	()Z
    //   35: ifne +11 -> 46
    //   38: aload_3
    //   39: astore_2
    //   40: aload 5
    //   42: invokevirtual 114	java/io/File:createNewFile	()Z
    //   45: pop
    //   46: aload_3
    //   47: astore_2
    //   48: new 116	java/io/DataOutputStream
    //   51: dup
    //   52: aload 5
    //   54: invokestatic 120	com/tencent/smtt/utils/FileUtil:openOutputStream	(Ljava/io/File;)Ljava/io/FileOutputStream;
    //   57: invokespecial 123	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_3
    //   61: aload_3
    //   62: aload_1
    //   63: invokevirtual 126	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   66: aload_3
    //   67: invokevirtual 129	java/io/DataOutputStream:flush	()V
    //   70: aload_3
    //   71: ifnull -65 -> 6
    //   74: aload_3
    //   75: invokevirtual 130	java/io/DataOutputStream:close	()V
    //   78: return
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   84: return
    //   85: astore_3
    //   86: aload 4
    //   88: astore_1
    //   89: aload_1
    //   90: astore_2
    //   91: aload_3
    //   92: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   95: aload_1
    //   96: ifnull -90 -> 6
    //   99: aload_1
    //   100: invokevirtual 130	java/io/DataOutputStream:close	()V
    //   103: return
    //   104: astore_1
    //   105: goto -25 -> 80
    //   108: astore_1
    //   109: aload_2
    //   110: ifnull +7 -> 117
    //   113: aload_2
    //   114: invokevirtual 130	java/io/DataOutputStream:close	()V
    //   117: aload_1
    //   118: athrow
    //   119: astore_2
    //   120: aload_2
    //   121: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   124: goto -7 -> 117
    //   127: astore_1
    //   128: aload_3
    //   129: astore_2
    //   130: goto -21 -> 109
    //   133: astore_2
    //   134: aload_3
    //   135: astore_1
    //   136: aload_2
    //   137: astore_3
    //   138: goto -49 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	QBInstallerRecorder
    //   0	141	1	paramString	String
    //   13	101	2	localObject1	Object
    //   119	2	2	localIOException	java.io.IOException
    //   129	1	2	localException1	Exception
    //   133	4	2	localException2	Exception
    //   8	67	3	localDataOutputStream	java.io.DataOutputStream
    //   85	50	3	localException3	Exception
    //   137	1	3	localObject2	Object
    //   10	77	4	localObject3	Object
    //   26	27	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   74	78	79	java/io/IOException
    //   14	28	85	java/lang/Exception
    //   30	38	85	java/lang/Exception
    //   40	46	85	java/lang/Exception
    //   48	61	85	java/lang/Exception
    //   99	103	104	java/io/IOException
    //   14	28	108	finally
    //   30	38	108	finally
    //   40	46	108	finally
    //   48	61	108	finally
    //   91	95	108	finally
    //   113	117	119	java/io/IOException
    //   61	70	127	finally
    //   61	70	133	java/lang/Exception
  }
  
  private void recordInstallerToSysSetting(String paramString)
  {
    try
    {
      Settings.System.putString(mContext.getContentResolver(), "sys_setting_tbs_qb_installer", paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String getQBInstaller()
  {
    if (!TextUtils.isEmpty(loadQBInstallerFromSDCard())) {
      return "";
    }
    return loadQBInstallerFromSysSetting();
  }
  
  public void recordQBInstaller(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    recordInstallerToSDCard(paramString);
    recordInstallerToSysSetting(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\utils\QBInstallerRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */