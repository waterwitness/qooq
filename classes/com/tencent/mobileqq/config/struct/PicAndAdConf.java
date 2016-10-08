package com.tencent.mobileqq.config.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ConfigListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import oicq.wlogin_sdk.tools.MD5;
import rbb;

public class PicAndAdConf
  extends BaseConf
  implements ImgConfHandler
{
  public static final String b = "ShanPing";
  public static final String c = "PicAndAdConf";
  private static final long d = 36000L;
  public static final String d = "qq_config_pic";
  public static final int i = 1;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  public boolean a;
  
  public PicAndAdConf(short paramShort, byte paramByte)
  {
    super(paramShort, paramByte);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(8);
  }
  
  private void a(File paramFile)
  {
    if (paramFile.exists())
    {
      if (!paramFile.isFile()) {
        break label25;
      }
      paramFile.delete();
    }
    for (;;)
    {
      paramFile.delete();
      return;
      label25:
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile == null) {
          break;
        }
        int j = 0;
        while (j < arrayOfFile.length)
        {
          a(arrayOfFile[j]);
          j += 1;
        }
      }
    }
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte, String paramString, long paramLong)
  {
    // Byte code:
    //   0: new 48	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aconst_null
    //   10: astore 5
    //   12: aload_2
    //   13: invokevirtual 52	java/io/File:exists	()Z
    //   16: ifne +86 -> 102
    //   19: aload_2
    //   20: invokevirtual 76	java/io/File:createNewFile	()Z
    //   23: pop
    //   24: new 78	java/io/FileOutputStream
    //   27: dup
    //   28: aload_2
    //   29: iconst_1
    //   30: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   33: astore_2
    //   34: aload_2
    //   35: aload_1
    //   36: invokevirtual 85	java/io/FileOutputStream:write	([B)V
    //   39: aload_2
    //   40: invokevirtual 89	java/io/FileOutputStream:flush	()V
    //   43: aload_2
    //   44: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   47: invokestatic 98	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   50: ldc 100
    //   52: iconst_0
    //   53: invokevirtual 104	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   56: invokeinterface 110 1 0
    //   61: astore_1
    //   62: aload_1
    //   63: ldc 112
    //   65: lload_3
    //   66: invokeinterface 118 4 0
    //   71: pop
    //   72: aload_1
    //   73: invokeinterface 121 1 0
    //   78: pop
    //   79: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +11 -> 93
    //   85: ldc 10
    //   87: iconst_2
    //   88: ldc -128
    //   90: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   101: return
    //   102: aload_2
    //   103: invokevirtual 58	java/io/File:delete	()Z
    //   106: pop
    //   107: aload_2
    //   108: invokevirtual 76	java/io/File:createNewFile	()Z
    //   111: pop
    //   112: goto -88 -> 24
    //   115: astore_1
    //   116: aload 5
    //   118: astore_1
    //   119: aload_1
    //   120: ifnull -19 -> 101
    //   123: aload_1
    //   124: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   127: return
    //   128: astore_1
    //   129: return
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_2
    //   133: aload_2
    //   134: ifnull +7 -> 141
    //   137: aload_2
    //   138: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   141: aload_1
    //   142: athrow
    //   143: astore_1
    //   144: return
    //   145: astore_2
    //   146: goto -5 -> 141
    //   149: astore_1
    //   150: goto -17 -> 133
    //   153: astore_1
    //   154: aload_2
    //   155: astore_1
    //   156: goto -37 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	PicAndAdConf
    //   0	159	1	paramArrayOfByte	byte[]
    //   0	159	2	paramString	String
    //   0	159	3	paramLong	long
    //   10	107	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	24	115	java/lang/Exception
    //   24	34	115	java/lang/Exception
    //   102	112	115	java/lang/Exception
    //   123	127	128	java/lang/Exception
    //   12	24	130	finally
    //   24	34	130	finally
    //   102	112	130	finally
    //   97	101	143	java/lang/Exception
    //   137	141	145	java/lang/Exception
    //   34	93	149	finally
    //   34	93	153	java/lang/Exception
  }
  
  /* Error */
  private boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: iconst_1
    //   6: istore 6
    //   8: new 48	java/io/File
    //   11: dup
    //   12: new 136	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   19: invokestatic 98	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   22: invokevirtual 142	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   25: invokevirtual 146	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc -104
    //   33: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore 5
    //   44: new 48	java/io/File
    //   47: dup
    //   48: new 136	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   55: invokestatic 98	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   58: invokevirtual 142	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   61: invokevirtual 146	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   64: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc -99
    //   69: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_2
    //   73: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore_2
    //   83: aload 5
    //   85: invokevirtual 52	java/io/File:exists	()Z
    //   88: ifne +9 -> 97
    //   91: aload 5
    //   93: invokevirtual 160	java/io/File:mkdirs	()Z
    //   96: pop
    //   97: aload_2
    //   98: invokevirtual 52	java/io/File:exists	()Z
    //   101: ifne +46 -> 147
    //   104: aload_2
    //   105: invokevirtual 76	java/io/File:createNewFile	()Z
    //   108: pop
    //   109: new 78	java/io/FileOutputStream
    //   112: dup
    //   113: aload_2
    //   114: iconst_1
    //   115: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   118: astore_2
    //   119: aload_2
    //   120: aload_1
    //   121: invokevirtual 85	java/io/FileOutputStream:write	([B)V
    //   124: aload_2
    //   125: invokevirtual 89	java/io/FileOutputStream:flush	()V
    //   128: aload_2
    //   129: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   132: iconst_0
    //   133: ifeq +11 -> 144
    //   136: new 162	java/lang/NullPointerException
    //   139: dup
    //   140: invokespecial 163	java/lang/NullPointerException:<init>	()V
    //   143: athrow
    //   144: iload 6
    //   146: ireturn
    //   147: aload_2
    //   148: invokevirtual 58	java/io/File:delete	()Z
    //   151: pop
    //   152: aload_2
    //   153: invokevirtual 76	java/io/File:createNewFile	()Z
    //   156: pop
    //   157: goto -48 -> 109
    //   160: astore_1
    //   161: aload_3
    //   162: astore_1
    //   163: iconst_0
    //   164: istore 6
    //   166: aload_1
    //   167: ifnull -23 -> 144
    //   170: aload_1
    //   171: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_1
    //   184: aload_1
    //   185: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   188: iconst_1
    //   189: ireturn
    //   190: astore_1
    //   191: aload 4
    //   193: astore_2
    //   194: aload_2
    //   195: ifnull +7 -> 202
    //   198: aload_2
    //   199: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   202: aload_1
    //   203: athrow
    //   204: astore_2
    //   205: aload_2
    //   206: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   209: goto -7 -> 202
    //   212: astore_1
    //   213: goto -19 -> 194
    //   216: astore_1
    //   217: aload_2
    //   218: astore_1
    //   219: goto -56 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	PicAndAdConf
    //   0	222	1	paramArrayOfByte	byte[]
    //   0	222	2	paramString	String
    //   4	158	3	localObject1	Object
    //   1	191	4	localObject2	Object
    //   42	50	5	localFile	File
    //   6	159	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   83	97	160	java/lang/Exception
    //   97	109	160	java/lang/Exception
    //   109	119	160	java/lang/Exception
    //   147	157	160	java/lang/Exception
    //   170	174	176	java/io/IOException
    //   136	144	183	java/io/IOException
    //   83	97	190	finally
    //   97	109	190	finally
    //   109	119	190	finally
    //   147	157	190	finally
    //   198	202	204	java/io/IOException
    //   119	132	212	finally
    //   119	132	216	java/lang/Exception
  }
  
  /* Error */
  private boolean b(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: iconst_1
    //   6: istore 7
    //   8: new 48	java/io/File
    //   11: dup
    //   12: new 136	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   19: invokestatic 98	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   22: invokevirtual 142	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   25: invokevirtual 146	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc -88
    //   33: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc -86
    //   38: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 5
    //   49: new 48	java/io/File
    //   52: dup
    //   53: new 136	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   60: invokestatic 98	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   63: invokevirtual 142	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   66: invokevirtual 146	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc -88
    //   74: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc -86
    //   79: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc -88
    //   84: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_2
    //   88: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: astore 6
    //   99: aload_3
    //   100: astore_2
    //   101: aload 5
    //   103: invokevirtual 52	java/io/File:exists	()Z
    //   106: ifne +11 -> 117
    //   109: aload_3
    //   110: astore_2
    //   111: aload 5
    //   113: invokevirtual 160	java/io/File:mkdirs	()Z
    //   116: pop
    //   117: aload_3
    //   118: astore_2
    //   119: aload 6
    //   121: invokevirtual 52	java/io/File:exists	()Z
    //   124: ifne +52 -> 176
    //   127: aload_3
    //   128: astore_2
    //   129: aload 6
    //   131: invokevirtual 76	java/io/File:createNewFile	()Z
    //   134: pop
    //   135: aload_3
    //   136: astore_2
    //   137: new 78	java/io/FileOutputStream
    //   140: dup
    //   141: aload 6
    //   143: iconst_1
    //   144: invokespecial 81	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   147: astore_3
    //   148: aload_3
    //   149: aload_1
    //   150: invokevirtual 85	java/io/FileOutputStream:write	([B)V
    //   153: aload_3
    //   154: invokevirtual 89	java/io/FileOutputStream:flush	()V
    //   157: aload_3
    //   158: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   161: iconst_0
    //   162: ifeq +11 -> 173
    //   165: new 162	java/lang/NullPointerException
    //   168: dup
    //   169: invokespecial 163	java/lang/NullPointerException:<init>	()V
    //   172: athrow
    //   173: iload 7
    //   175: ireturn
    //   176: aload_3
    //   177: astore_2
    //   178: aload 6
    //   180: invokevirtual 58	java/io/File:delete	()Z
    //   183: pop
    //   184: aload_3
    //   185: astore_2
    //   186: aload 6
    //   188: invokevirtual 76	java/io/File:createNewFile	()Z
    //   191: pop
    //   192: goto -57 -> 135
    //   195: astore_3
    //   196: aload 4
    //   198: astore_1
    //   199: aload_1
    //   200: astore_2
    //   201: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +14 -> 218
    //   207: aload_1
    //   208: astore_2
    //   209: ldc 13
    //   211: iconst_2
    //   212: ldc -84
    //   214: aload_3
    //   215: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   218: iconst_0
    //   219: istore 7
    //   221: aload_1
    //   222: ifnull -49 -> 173
    //   225: aload_1
    //   226: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   229: iconst_0
    //   230: ireturn
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   236: iconst_0
    //   237: ireturn
    //   238: astore_1
    //   239: aload_1
    //   240: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   243: iconst_1
    //   244: ireturn
    //   245: astore_1
    //   246: aload_2
    //   247: ifnull +7 -> 254
    //   250: aload_2
    //   251: invokevirtual 92	java/io/FileOutputStream:close	()V
    //   254: aload_1
    //   255: athrow
    //   256: astore_2
    //   257: aload_2
    //   258: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   261: goto -7 -> 254
    //   264: astore_1
    //   265: aload_3
    //   266: astore_2
    //   267: goto -21 -> 246
    //   270: astore_2
    //   271: aload_3
    //   272: astore_1
    //   273: aload_2
    //   274: astore_3
    //   275: goto -76 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	PicAndAdConf
    //   0	278	1	paramArrayOfByte	byte[]
    //   0	278	2	paramString	String
    //   1	184	3	localFileOutputStream	java.io.FileOutputStream
    //   195	77	3	localException	Exception
    //   274	1	3	str	String
    //   3	194	4	localObject	Object
    //   47	65	5	localFile1	File
    //   97	90	6	localFile2	File
    //   6	214	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   101	109	195	java/lang/Exception
    //   111	117	195	java/lang/Exception
    //   119	127	195	java/lang/Exception
    //   129	135	195	java/lang/Exception
    //   137	148	195	java/lang/Exception
    //   178	184	195	java/lang/Exception
    //   186	192	195	java/lang/Exception
    //   225	229	231	java/io/IOException
    //   165	173	238	java/io/IOException
    //   101	109	245	finally
    //   111	117	245	finally
    //   119	127	245	finally
    //   129	135	245	finally
    //   137	148	245	finally
    //   178	184	245	finally
    //   186	192	245	finally
    //   201	207	245	finally
    //   209	218	245	finally
    //   250	254	256	java/io/IOException
    //   148	161	264	finally
    //   148	161	270	java/lang/Exception
  }
  
  public long a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return 0L;
    }
    return ((PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Long;
  }
  
  /* Error */
  public android.graphics.Bitmap a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: aload_2
    //   9: astore_3
    //   10: iload_1
    //   11: iflt +16 -> 27
    //   14: iload_1
    //   15: aload_0
    //   16: getfield 179	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   19: invokevirtual 185	java/util/ArrayList:size	()I
    //   22: if_icmplt +7 -> 29
    //   25: aload_2
    //   26: astore_3
    //   27: aload_3
    //   28: areturn
    //   29: aload 5
    //   31: astore_3
    //   32: aload_0
    //   33: getfield 179	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   36: iload_1
    //   37: invokevirtual 189	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   40: checkcast 191	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct
    //   43: astore 6
    //   45: aload 5
    //   47: astore_3
    //   48: aload 6
    //   50: getfield 201	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:jdField_a_of_type_Byte	B
    //   53: istore 9
    //   55: aload_2
    //   56: astore_3
    //   57: iload 9
    //   59: tableswitch	default:+25->84, 1:+27->86, 2:+-32->27, 3:+41->100
    //   84: aconst_null
    //   85: areturn
    //   86: aload 5
    //   88: astore_3
    //   89: aload 6
    //   91: getfield 203	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:b	Ljava/lang/String;
    //   94: invokestatic 208	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   97: astore_2
    //   98: aload_2
    //   99: areturn
    //   100: aload 5
    //   102: astore_3
    //   103: aload_0
    //   104: getfield 179	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   107: iload_1
    //   108: invokevirtual 189	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   111: checkcast 191	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct
    //   114: getfield 211	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:jdField_a_of_type_ArrayOfByte	[B
    //   117: astore 7
    //   119: aload 5
    //   121: astore_3
    //   122: aload_0
    //   123: getfield 179	com/tencent/mobileqq/config/struct/PicAndAdConf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   126: iload_1
    //   127: invokevirtual 189	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   130: checkcast 191	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct
    //   133: getfield 213	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:c	Ljava/lang/String;
    //   136: astore 8
    //   138: aload 8
    //   140: ifnull +43 -> 183
    //   143: aload 5
    //   145: astore_3
    //   146: aload_0
    //   147: getfield 216	com/tencent/mobileqq/config/struct/PicAndAdConf:a_	B
    //   150: iconst_1
    //   151: if_icmpne +32 -> 183
    //   154: aload 5
    //   156: astore_3
    //   157: aload_0
    //   158: invokevirtual 218	com/tencent/mobileqq/config/struct/PicAndAdConf:a	()Z
    //   161: ifne +22 -> 183
    //   164: aload 5
    //   166: astore_3
    //   167: aload_0
    //   168: invokevirtual 220	com/tencent/mobileqq/config/struct/PicAndAdConf:b	()Z
    //   171: ifne +12 -> 183
    //   174: aload 5
    //   176: astore_3
    //   177: aload 8
    //   179: invokestatic 208	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   182: areturn
    //   183: aload 8
    //   185: ifnull +86 -> 271
    //   188: aload 5
    //   190: astore_3
    //   191: aload_0
    //   192: getfield 216	com/tencent/mobileqq/config/struct/PicAndAdConf:a_	B
    //   195: ifne +76 -> 271
    //   198: aload 5
    //   200: astore_3
    //   201: new 48	java/io/File
    //   204: dup
    //   205: aload 8
    //   207: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   210: invokevirtual 52	java/io/File:exists	()Z
    //   213: ifeq +41 -> 254
    //   216: aload 5
    //   218: astore_3
    //   219: aload 8
    //   221: invokestatic 208	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   224: astore_2
    //   225: aload_2
    //   226: ifnonnull +228 -> 454
    //   229: aload 6
    //   231: getfield 221	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:jdField_a_of_type_Boolean	Z
    //   234: ifeq +220 -> 454
    //   237: aload 6
    //   239: iconst_0
    //   240: putfield 221	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:jdField_a_of_type_Boolean	Z
    //   243: aload_0
    //   244: aload 6
    //   246: getfield 203	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:b	Ljava/lang/String;
    //   249: invokevirtual 223	com/tencent/mobileqq/config/struct/PicAndAdConf:a_	(Ljava/lang/String;)V
    //   252: aload_2
    //   253: areturn
    //   254: aload 5
    //   256: astore_3
    //   257: aload_0
    //   258: aload 6
    //   260: getfield 203	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:b	Ljava/lang/String;
    //   263: invokevirtual 223	com/tencent/mobileqq/config/struct/PicAndAdConf:a_	(Ljava/lang/String;)V
    //   266: aconst_null
    //   267: astore_2
    //   268: goto -16 -> 252
    //   271: aload 5
    //   273: astore_3
    //   274: aload 8
    //   276: invokestatic 229	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   279: ifne +125 -> 404
    //   282: aload 5
    //   284: astore_3
    //   285: aload_0
    //   286: getfield 216	com/tencent/mobileqq/config/struct/PicAndAdConf:a_	B
    //   289: iconst_2
    //   290: if_icmpne +114 -> 404
    //   293: aload 5
    //   295: astore_3
    //   296: new 48	java/io/File
    //   299: dup
    //   300: aload 8
    //   302: invokespecial 73	java/io/File:<init>	(Ljava/lang/String;)V
    //   305: invokevirtual 52	java/io/File:exists	()Z
    //   308: istore 10
    //   310: aload 4
    //   312: astore_2
    //   313: iload 10
    //   315: ifeq +12 -> 327
    //   318: aload 5
    //   320: astore_3
    //   321: aload 8
    //   323: invokestatic 208	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   326: astore_2
    //   327: aload_2
    //   328: astore_3
    //   329: aload_2
    //   330: ifnonnull -303 -> 27
    //   333: aload_2
    //   334: astore_3
    //   335: aload_0
    //   336: aload 6
    //   338: getfield 203	com/tencent/mobileqq/config/struct/PicAndAdConf$PicStruct:b	Ljava/lang/String;
    //   341: invokevirtual 223	com/tencent/mobileqq/config/struct/PicAndAdConf:a_	(Ljava/lang/String;)V
    //   344: aload_2
    //   345: areturn
    //   346: astore 4
    //   348: aload_3
    //   349: astore_2
    //   350: aload_2
    //   351: astore_3
    //   352: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq -328 -> 27
    //   358: ldc -25
    //   360: iconst_2
    //   361: aload 4
    //   363: invokestatic 235	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   366: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload_2
    //   370: areturn
    //   371: astore 7
    //   373: aload 4
    //   375: astore_2
    //   376: aload 5
    //   378: astore_3
    //   379: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq -55 -> 327
    //   385: aload 5
    //   387: astore_3
    //   388: ldc 13
    //   390: iconst_2
    //   391: ldc -16
    //   393: aload 7
    //   395: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   398: aload 4
    //   400: astore_2
    //   401: goto -74 -> 327
    //   404: aload_2
    //   405: astore_3
    //   406: aload 7
    //   408: ifnull -381 -> 27
    //   411: aload 5
    //   413: astore_3
    //   414: aload 7
    //   416: arraylength
    //   417: istore_1
    //   418: aload_2
    //   419: astore_3
    //   420: iload_1
    //   421: ifle -394 -> 27
    //   424: aload 7
    //   426: iconst_0
    //   427: aload 7
    //   429: arraylength
    //   430: invokestatic 246	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   433: astore_2
    //   434: aload_2
    //   435: areturn
    //   436: astore_2
    //   437: aload 4
    //   439: astore_2
    //   440: goto -113 -> 327
    //   443: astore 4
    //   445: goto -95 -> 350
    //   448: astore_2
    //   449: aconst_null
    //   450: areturn
    //   451: astore_2
    //   452: aconst_null
    //   453: areturn
    //   454: goto -202 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	this	PicAndAdConf
    //   0	457	1	paramInt	int
    //   7	428	2	localObject1	Object
    //   436	1	2	localOutOfMemoryError	OutOfMemoryError
    //   439	1	2	localThrowable1	Throwable
    //   448	1	2	localException1	Exception
    //   451	1	2	localThrowable2	Throwable
    //   9	411	3	localObject2	Object
    //   1	310	4	localObject3	Object
    //   346	92	4	localThrowable3	Throwable
    //   443	1	4	localThrowable4	Throwable
    //   4	408	5	localObject4	Object
    //   43	294	6	localPicStruct	PicAndAdConf.PicStruct
    //   117	1	7	arrayOfByte	byte[]
    //   371	57	7	localException2	Exception
    //   136	186	8	str	String
    //   53	5	9	j	int
    //   308	6	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   32	45	346	java/lang/Throwable
    //   48	55	346	java/lang/Throwable
    //   89	98	346	java/lang/Throwable
    //   103	119	346	java/lang/Throwable
    //   122	138	346	java/lang/Throwable
    //   146	154	346	java/lang/Throwable
    //   157	164	346	java/lang/Throwable
    //   167	174	346	java/lang/Throwable
    //   177	183	346	java/lang/Throwable
    //   191	198	346	java/lang/Throwable
    //   201	216	346	java/lang/Throwable
    //   219	225	346	java/lang/Throwable
    //   257	266	346	java/lang/Throwable
    //   274	282	346	java/lang/Throwable
    //   285	293	346	java/lang/Throwable
    //   296	310	346	java/lang/Throwable
    //   321	327	346	java/lang/Throwable
    //   335	344	346	java/lang/Throwable
    //   379	385	346	java/lang/Throwable
    //   388	398	346	java/lang/Throwable
    //   414	418	346	java/lang/Throwable
    //   321	327	371	java/lang/Exception
    //   321	327	436	java/lang/OutOfMemoryError
    //   229	252	443	java/lang/Throwable
    //   89	98	448	java/lang/Exception
    //   424	434	451	java/lang/Throwable
  }
  
  public PicAndAdConf.PicStruct a(long paramLong, String paramString1, byte paramByte, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort, String paramString6)
  {
    PicAndAdConf.PicStruct localPicStruct = new PicAndAdConf.PicStruct(this);
    localPicStruct.jdField_a_of_type_Long = paramLong;
    localPicStruct.jdField_a_of_type_JavaLangString = paramString1;
    localPicStruct.b = paramString2;
    localPicStruct.d = paramString3;
    localPicStruct.jdField_a_of_type_Byte = paramByte;
    localPicStruct.c = paramString4;
    localPicStruct.e = paramString5;
    localPicStruct.jdField_a_of_type_Short = paramShort;
    localPicStruct.f = paramString6;
    localPicStruct.jdField_a_of_type_Int = 0;
    return localPicStruct;
  }
  
  public PicAndAdConf.PicStruct a(long paramLong, String paramString1, byte paramByte, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    PicAndAdConf.PicStruct localPicStruct = new PicAndAdConf.PicStruct(this);
    localPicStruct.jdField_a_of_type_Long = paramLong;
    localPicStruct.jdField_a_of_type_JavaLangString = paramString1;
    localPicStruct.b = paramString2;
    localPicStruct.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localPicStruct.d = paramString3;
    localPicStruct.jdField_a_of_type_Byte = paramByte;
    localPicStruct.jdField_a_of_type_Int = 0;
    return localPicStruct;
  }
  
  public PicAndAdConf.PicStruct a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort)
  {
    return a(paramLong, paramString1, (byte)3, paramString2, paramString3, paramString4, paramString5, paramShort, "");
  }
  
  public PicAndAdConf.PicStruct a(long paramLong, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    return a(paramLong, paramString1, (byte)3, paramString2, paramArrayOfByte, paramString3);
  }
  
  public String a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return "";
    }
    return ((PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString, byte paramByte)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = paramString;
    switch (paramByte)
    {
    default: 
      str = paramString;
    }
    for (;;)
    {
      paramString = str;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShanPing", 2, "flashlogo final request url = " + str);
      return str;
      str = paramString;
      if (!paramString.startsWith("/"))
      {
        str = "/" + paramString;
        continue;
        if ((paramString.startsWith("http://")) && (!paramString.endsWith(".png")))
        {
          if (this.a_ == 6) {
            str = paramString + "_" + Config.aw + "_" + Config.av + ".png";
          } else if (this.a_ == 0) {
            str = paramString + "_" + (Config.av - 2) + ".png";
          } else if ((this.a_ == 1) && (paramString.contains("[]"))) {
            str = paramString.replace("[]", DeviceInfoUtil.f() + "x" + DeviceInfoUtil.g());
          } else {
            str = paramString + "_" + Config.av + ".png";
          }
        }
        else
        {
          str = paramString;
          if (paramString.startsWith("http://"))
          {
            str = paramString;
            if (this.a_ == 1)
            {
              str = paramString;
              if (paramString.contains("[]")) {
                str = paramString.replace("[]", DeviceInfoUtil.f() + "x" + DeviceInfoUtil.g());
              }
            }
          }
        }
      }
    }
  }
  
  public short a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return -1;
    }
    return ((PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Short;
  }
  
  public void a()
  {
    a(true);
    long l = this.c;
    this.b = -1L;
    this.c = -1L;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    switch (this.a_)
    {
    }
    for (;;)
    {
      return;
      c();
      return;
      File localFile = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "flashlogo.png");
      try
      {
        if (localFile.exists())
        {
          localFile.delete();
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void a(HttpMsg paramHttpMsg) {}
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if ((paramHttpMsg1 == null) || (paramHttpMsg2 == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "flashlogo request huibao decode ");
    }
    a(paramHttpMsg1.a(), paramHttpMsg2.a());
  }
  
  public void a(DataInputStream paramDataInputStream)
  {
    this.jdField_a_of_type_Short = paramDataInputStream.readShort();
    this.jdField_a_of_type_Long = paramDataInputStream.readLong();
    this.b = paramDataInputStream.readLong();
    this.c = paramDataInputStream.readLong();
    this.a_ = paramDataInputStream.readByte();
    int k = paramDataInputStream.readInt();
    if (k > 0)
    {
      int j = 0;
      if (j < k)
      {
        PicAndAdConf.PicStruct localPicStruct = new PicAndAdConf.PicStruct(this);
        if (this.a_ == 2) {
          localPicStruct.b(paramDataInputStream);
        }
        for (;;)
        {
          a(localPicStruct);
          j += 1;
          break;
          localPicStruct.a(paramDataInputStream);
        }
      }
    }
  }
  
  public void a(DataOutputStream paramDataOutputStream)
  {
    paramDataOutputStream.writeShort(this.jdField_a_of_type_Short);
    paramDataOutputStream.writeLong(this.jdField_a_of_type_Long);
    paramDataOutputStream.writeLong(this.b);
    paramDataOutputStream.writeLong(this.c);
    paramDataOutputStream.writeByte(this.a_);
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      paramDataOutputStream.writeInt(0);
      return;
    }
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramDataOutputStream.writeInt(k);
    int j = 0;
    label80:
    PicAndAdConf.PicStruct localPicStruct;
    if (j < k)
    {
      localPicStruct = (PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (this.a_ != 2) {
        break label118;
      }
      localPicStruct.b(paramDataOutputStream);
    }
    for (;;)
    {
      j += 1;
      break label80;
      break;
      label118:
      localPicStruct.a(paramDataOutputStream);
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, byte[] arg2)
  {
    if ((??? == null) || (???.length <= 0) || (paramString == null) || (paramString.length() <= 0))
    {
      if (!TextUtils.isEmpty(paramString)) {
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
          return;
        }
      }
    }
    else
    {
      ArrayList localArrayList = Config.a();
      int j = 0;
      while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        PicAndAdConf.PicStruct localPicStruct = (PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (paramString.startsWith(localPicStruct.b))
        {
          if (this.a_ == 1)
          {
            localPicStruct.c = (BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/" + "flashlogo.png");
            a(???, localPicStruct.c, this.b);
            if (localArrayList == null) {
              break;
            }
            ??? = localArrayList.iterator();
            while (???.hasNext()) {
              ((ConfigListener)???.next()).a(true, this.jdField_a_of_type_Short, j, paramString);
            }
          }
          if (this.a_ == 0)
          {
            a(???, String.valueOf(localPicStruct.f));
            try
            {
              ??? = new File(localPicStruct.c);
              if (!MD5.getFileMD5(???).equalsIgnoreCase(localPicStruct.f))
              {
                ???.delete();
                if (localPicStruct.jdField_a_of_type_Int < 1)
                {
                  localPicStruct.jdField_a_of_type_Int += 1;
                  a_(localPicStruct.b);
                }
              }
              if (localArrayList == null) {
                break;
              }
              ??? = localArrayList.iterator();
              while (???.hasNext()) {
                ((ConfigListener)???.next()).a(true, this.jdField_a_of_type_Short, j, paramString);
              }
            }
            catch (Exception ???)
            {
              for (;;)
              {
                ???.printStackTrace();
              }
            }
          }
          if (this.a_ != 2) {
            break;
          }
          b(???, String.valueOf(localPicStruct.f));
          for (;;)
          {
            try
            {
              ??? = new File(localPicStruct.c);
              paramString = MD5.getFileMD5(???);
              if (!paramString.equalsIgnoreCase(localPicStruct.f))
              {
                ???.delete();
                if (localPicStruct.jdField_a_of_type_Int >= 1) {
                  break label501;
                }
                localPicStruct.jdField_a_of_type_Int += 1;
                a_(localPicStruct.b);
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PicAndAdConf", 2, "handle download NearbyBanner image, cid = " + localPicStruct.jdField_a_of_type_Long + ", md5 is " + paramString.equalsIgnoreCase(localPicStruct.f));
              return;
            }
            catch (Exception paramString)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
            }
            QLog.d("PicAndAdConf", 2, "handleImgData exception, item md5 = " + localPicStruct.f, paramString);
            return;
            label501:
            synchronized (this.jdField_a_of_type_JavaUtilHashMap)
            {
              this.jdField_a_of_type_JavaUtilHashMap.put(localPicStruct.b, Long.valueOf(System.currentTimeMillis()));
            }
          }
        }
        j += 1;
      }
    }
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (paramInt == 3)
    {
      paramHttpMsg2 = paramHttpMsg2.a("Content-Type");
      paramHttpMsg1 = null;
      if (paramHttpMsg2 != null) {
        paramHttpMsg1 = paramHttpMsg2.toLowerCase();
      }
      if ((paramHttpMsg1 != null) && (paramHttpMsg1.indexOf("image") != -1)) {
        return true;
      }
    }
    return false;
  }
  
  public void a_(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("http://"))) {}
    do
    {
      return;
      if (this.a_ == 2) {
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) && (Math.abs(System.currentTimeMillis() - ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue()) < 36000L))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PicAndAdConf", 2, "sendImgRequest | retry interval is too small, " + paramString);
            }
            return;
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilHashSet == null) {
        this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
      ??? = Config.a();
    } while (??? == null);
    ((HttpCommunicator)???).a(new HttpMsg(paramString, null, this, true));
  }
  
  public String b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return "";
    }
    return ((PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).e;
  }
  
  public void b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    int j = 0;
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramHttpMsg2 = (PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (paramHttpMsg1.a().startsWith(paramHttpMsg2.b))
      {
        paramHttpMsg2 = Config.a();
        if (paramHttpMsg2 == null) {
          break;
        }
        paramHttpMsg2 = paramHttpMsg2.iterator();
        while (paramHttpMsg2.hasNext()) {
          ((ConfigListener)paramHttpMsg2.next()).a(false, this.jdField_a_of_type_Short, j, paramHttpMsg1.a());
        }
      }
      j += 1;
    }
  }
  
  public String c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return "";
    }
    return ((PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).f;
  }
  
  public void c()
  {
    File localFile = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/ADPic");
    try
    {
      a(localFile);
      return;
    }
    catch (Exception localException) {}
  }
  
  public String d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return "";
    }
    return ((PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).d;
  }
  
  public void d()
  {
    if (this.a_ == 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preDownload NearbyBanner image");
      int j = 0;
      if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        PicAndAdConf.PicStruct localPicStruct = (PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if (localPicStruct.c != null)
        {
          File localFile = new File(localPicStruct.c);
          if ((!localFile.exists()) || (!localFile.canRead())) {
            break label94;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          label94:
          localStringBuilder.append(" | ").append(localPicStruct.jdField_a_of_type_Long);
          ThreadManager.a(new rbb(this, localPicStruct), 5, null, false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicAndAdConf", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\config\struct\PicAndAdConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */