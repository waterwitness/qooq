package cooperation.qzone.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.LogFile;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.util.SecurityUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import ypr;
import yps;

public class QZoneAppCtrlUploadFileLogic
{
  public static final int a = 0;
  public static final String a = "QZoneAppCtrlUploadFileLogic";
  public static final int b = 1;
  public static final String b = "anr" + File.separator + "traces.txt";
  public static final int c = -3;
  public static final String c = "anr";
  public static final int d = 26214400;
  public static final String d = "databases";
  static final int e = 3;
  public static final String e = "tencent" + File.separator + "zip";
  private static final int f = 100000000;
  public static final String f = "DB";
  public static final String g = "ANR";
  public static final String h = "TRACE";
  public static final String i = "LOGCAT";
  static final String j = "--";
  static final String k = "\r\n";
  static final String l = "multipart/form-data";
  static final String m = "http://zhizi.qq.com/uploadfile.php";
  private static final String n = "utf-8";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  private static int a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 69	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: new 96	java/util/zip/ZipOutputStream
    //   14: dup
    //   15: new 98	java/io/FileOutputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   23: invokespecial 104	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   26: astore_2
    //   27: aload_2
    //   28: ifnonnull +14 -> 42
    //   31: aload_2
    //   32: ifnull +7 -> 39
    //   35: aload_2
    //   36: invokevirtual 107	java/util/zip/ZipOutputStream:close	()V
    //   39: bipush -3
    //   41: ireturn
    //   42: sipush 1024
    //   45: newarray <illegal type>
    //   47: astore_3
    //   48: new 109	java/util/zip/ZipEntry
    //   51: dup
    //   52: aload_1
    //   53: invokevirtual 112	java/io/File:getName	()Ljava/lang/String;
    //   56: invokespecial 113	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   59: astore 4
    //   61: aload 4
    //   63: aload_1
    //   64: invokevirtual 117	java/io/File:length	()J
    //   67: invokevirtual 121	java/util/zip/ZipEntry:setSize	(J)V
    //   70: aload 4
    //   72: aload_1
    //   73: invokevirtual 124	java/io/File:lastModified	()J
    //   76: invokevirtual 127	java/util/zip/ZipEntry:setTime	(J)V
    //   79: aload_2
    //   80: aload 4
    //   82: invokevirtual 131	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   85: new 133	java/io/BufferedInputStream
    //   88: dup
    //   89: new 135	java/io/FileInputStream
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   97: invokespecial 139	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: astore_1
    //   101: aload_1
    //   102: aload_3
    //   103: iconst_0
    //   104: sipush 1024
    //   107: invokevirtual 145	java/io/InputStream:read	([BII)I
    //   110: istore 5
    //   112: iload 5
    //   114: iconst_m1
    //   115: if_icmpeq +60 -> 175
    //   118: aload_2
    //   119: aload_3
    //   120: iconst_0
    //   121: iload 5
    //   123: invokevirtual 149	java/util/zip/ZipOutputStream:write	([BII)V
    //   126: goto -25 -> 101
    //   129: astore_0
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 150	java/io/InputStream:close	()V
    //   138: aload_0
    //   139: athrow
    //   140: astore_0
    //   141: aload_2
    //   142: astore_1
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 107	java/util/zip/ZipOutputStream:close	()V
    //   151: aload_0
    //   152: athrow
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   158: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   161: ifeq -122 -> 39
    //   164: ldc 10
    //   166: iconst_4
    //   167: ldc -95
    //   169: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: bipush -3
    //   174: ireturn
    //   175: aload_1
    //   176: ifnull +7 -> 183
    //   179: aload_1
    //   180: invokevirtual 150	java/io/InputStream:close	()V
    //   183: aload_2
    //   184: invokevirtual 107	java/util/zip/ZipOutputStream:close	()V
    //   187: aload_0
    //   188: invokevirtual 117	java/io/File:length	()J
    //   191: ldc2_w 165
    //   194: lcmp
    //   195: iflt +27 -> 222
    //   198: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   201: ifeq +11 -> 212
    //   204: ldc 10
    //   206: iconst_4
    //   207: ldc -88
    //   209: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 107	java/util/zip/ZipOutputStream:close	()V
    //   220: iconst_1
    //   221: ireturn
    //   222: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   225: ifeq +11 -> 236
    //   228: ldc 10
    //   230: iconst_4
    //   231: ldc -86
    //   233: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_2
    //   237: ifnull +7 -> 244
    //   240: aload_2
    //   241: invokevirtual 107	java/util/zip/ZipOutputStream:close	()V
    //   244: iconst_0
    //   245: ireturn
    //   246: astore_0
    //   247: aload_3
    //   248: astore_1
    //   249: goto -106 -> 143
    //   252: astore_0
    //   253: aconst_null
    //   254: astore_1
    //   255: goto -125 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	paramString	String
    //   0	258	1	paramFile	File
    //   26	215	2	localZipOutputStream	java.util.zip.ZipOutputStream
    //   1	247	3	arrayOfByte	byte[]
    //   59	22	4	localZipEntry	java.util.zip.ZipEntry
    //   110	12	5	i1	int
    // Exception table:
    //   from	to	target	type
    //   101	112	129	finally
    //   118	126	129	finally
    //   42	85	140	finally
    //   134	138	140	finally
    //   138	140	140	finally
    //   179	183	140	finally
    //   183	212	140	finally
    //   222	236	140	finally
    //   2	11	153	java/lang/Exception
    //   35	39	153	java/lang/Exception
    //   147	151	153	java/lang/Exception
    //   151	153	153	java/lang/Exception
    //   216	220	153	java/lang/Exception
    //   240	244	153	java/lang/Exception
    //   11	27	246	finally
    //   85	101	252	finally
  }
  
  /* Error */
  private static int a(String paramString, ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 69	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: new 96	java/util/zip/ZipOutputStream
    //   14: dup
    //   15: new 98	java/io/FileOutputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   23: invokespecial 104	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   26: astore_2
    //   27: aload_2
    //   28: ifnonnull +18 -> 46
    //   31: aload_2
    //   32: ifnull +7 -> 39
    //   35: aload_2
    //   36: invokevirtual 107	java/util/zip/ZipOutputStream:close	()V
    //   39: bipush -3
    //   41: istore 6
    //   43: iload 6
    //   45: ireturn
    //   46: sipush 1024
    //   49: newarray <illegal type>
    //   51: astore_3
    //   52: aload_1
    //   53: invokevirtual 177	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   56: astore 4
    //   58: aload 4
    //   60: invokeinterface 182 1 0
    //   65: ifeq +152 -> 217
    //   68: aload 4
    //   70: invokeinterface 186 1 0
    //   75: checkcast 69	java/io/File
    //   78: astore_1
    //   79: new 109	java/util/zip/ZipEntry
    //   82: dup
    //   83: aload_1
    //   84: invokevirtual 112	java/io/File:getName	()Ljava/lang/String;
    //   87: invokespecial 113	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   90: astore 5
    //   92: aload 5
    //   94: aload_1
    //   95: invokevirtual 117	java/io/File:length	()J
    //   98: invokevirtual 121	java/util/zip/ZipEntry:setSize	(J)V
    //   101: aload 5
    //   103: aload_1
    //   104: invokevirtual 124	java/io/File:lastModified	()J
    //   107: invokevirtual 127	java/util/zip/ZipEntry:setTime	(J)V
    //   110: aload_2
    //   111: aload 5
    //   113: invokevirtual 131	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   116: new 133	java/io/BufferedInputStream
    //   119: dup
    //   120: new 135	java/io/FileInputStream
    //   123: dup
    //   124: aload_1
    //   125: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   128: invokespecial 139	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   131: astore_1
    //   132: aload_1
    //   133: aload_3
    //   134: iconst_0
    //   135: sipush 1024
    //   138: invokevirtual 145	java/io/InputStream:read	([BII)I
    //   141: istore 6
    //   143: iload 6
    //   145: iconst_m1
    //   146: if_icmpeq +60 -> 206
    //   149: aload_2
    //   150: aload_3
    //   151: iconst_0
    //   152: iload 6
    //   154: invokevirtual 149	java/util/zip/ZipOutputStream:write	([BII)V
    //   157: goto -25 -> 132
    //   160: astore_0
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 150	java/io/InputStream:close	()V
    //   169: aload_0
    //   170: athrow
    //   171: astore_0
    //   172: aload_2
    //   173: astore_1
    //   174: aload_1
    //   175: ifnull +7 -> 182
    //   178: aload_1
    //   179: invokevirtual 107	java/util/zip/ZipOutputStream:close	()V
    //   182: aload_0
    //   183: athrow
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   189: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   192: ifeq +11 -> 203
    //   195: ldc 10
    //   197: iconst_4
    //   198: ldc -68
    //   200: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: bipush -3
    //   205: ireturn
    //   206: aload_1
    //   207: ifnull -149 -> 58
    //   210: aload_1
    //   211: invokevirtual 150	java/io/InputStream:close	()V
    //   214: goto -156 -> 58
    //   217: aload_2
    //   218: invokevirtual 107	java/util/zip/ZipOutputStream:close	()V
    //   221: aload_0
    //   222: invokevirtual 117	java/io/File:length	()J
    //   225: lstore 7
    //   227: lload 7
    //   229: ldc2_w 165
    //   232: lcmp
    //   233: iflt +16 -> 249
    //   236: iconst_1
    //   237: istore 6
    //   239: aload_2
    //   240: ifnull -197 -> 43
    //   243: aload_2
    //   244: invokevirtual 107	java/util/zip/ZipOutputStream:close	()V
    //   247: iconst_1
    //   248: ireturn
    //   249: aload_2
    //   250: ifnull +7 -> 257
    //   253: aload_2
    //   254: invokevirtual 107	java/util/zip/ZipOutputStream:close	()V
    //   257: iconst_0
    //   258: ireturn
    //   259: astore_0
    //   260: aload_3
    //   261: astore_1
    //   262: goto -88 -> 174
    //   265: astore_0
    //   266: aconst_null
    //   267: astore_1
    //   268: goto -107 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	paramString	String
    //   0	271	1	paramArrayList	ArrayList
    //   26	228	2	localZipOutputStream	java.util.zip.ZipOutputStream
    //   1	260	3	arrayOfByte	byte[]
    //   56	13	4	localIterator	java.util.Iterator
    //   90	22	5	localZipEntry	java.util.zip.ZipEntry
    //   41	197	6	i1	int
    //   225	3	7	l1	long
    // Exception table:
    //   from	to	target	type
    //   132	143	160	finally
    //   149	157	160	finally
    //   46	58	171	finally
    //   58	116	171	finally
    //   165	169	171	finally
    //   169	171	171	finally
    //   210	214	171	finally
    //   217	227	171	finally
    //   2	11	184	java/lang/Exception
    //   35	39	184	java/lang/Exception
    //   178	182	184	java/lang/Exception
    //   182	184	184	java/lang/Exception
    //   243	247	184	java/lang/Exception
    //   253	257	184	java/lang/Exception
    //   11	27	259	finally
    //   116	132	265	finally
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramContext = new File(Environment.getDataDirectory().getAbsolutePath() + File.separator + "anr");
    } while ((!paramContext.isDirectory()) || (paramContext.listFiles() == null));
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + e + File.separator + "ANR";
    String str = (String)localObject + File.separator + "upload.log" + ".zip";
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    a(paramContext, str, paramString);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while ((paramLong1 <= 0L) || (paramLong2 <= paramLong1));
      localObject1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "MobileQQ" + File.separator + "trace").listFiles(new ypr(paramLong1, paramLong2));
      localObject2 = new yps();
      paramContext = new ArrayList();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QZoneAppCtrlUploadFileLogic", 4, "logFiles length" + localObject1.length);
        }
        int i2 = localObject1.length;
        int i1 = 0;
        while (i1 < i2)
        {
          paramContext.add(new ShareAppLogHelper.LogFile(localObject1[i1].getPath()));
          Collections.sort(paramContext, (Comparator)localObject2);
          i1 += 1;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "find file: " + paramContext.size());
      }
    } while (paramContext.size() == 0);
    Object localObject2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + e + File.separator + "TRACE";
    Object localObject1 = (String)localObject2 + File.separator + "upload.log" + ".zip";
    localObject2 = new File((String)localObject2);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    a((File)paramContext.get(paramContext.size() - 1), (String)localObject1, paramString);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      localObject = SecurityUtil.a(paramString1);
    }
    paramContext = paramContext.getFilesDir().getParent() + File.separator + "databases" + File.separator + (String)localObject;
    paramString2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + e + File.separator + "DB";
    localObject = new File(paramString2);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    paramString2 = paramString2 + File.separator + "upload.log" + ".zip";
    a(new File(paramContext), paramString2, paramString1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      Object localObject;
      File localFile;
      do
      {
        return;
        paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + e + File.separator + "custom";
        localObject = new File(paramContext);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        localObject = paramContext + File.separator + "upload.log" + ".zip";
        localFile = new File(paramString1);
      } while ((!localFile.isFile()) || (localFile.length() >= paramLong));
      a(new File(paramString1), (String)localObject, paramString2);
    } while (!QLog.isDevelopLevel());
    QLog.d("QZoneAppCtrlUploadFileLogic", 4, "uploadByCustom filename: " + paramContext);
  }
  
  /* Error */
  public static boolean a(File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: invokevirtual 221	java/io/File:exists	()Z
    //   11: ifne +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: invokevirtual 221	java/io/File:exists	()Z
    //   20: ifeq +141 -> 161
    //   23: aload_0
    //   24: invokevirtual 112	java/io/File:getName	()Ljava/lang/String;
    //   27: ldc 16
    //   29: invokevirtual 306	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +110 -> 142
    //   35: aload_0
    //   36: invokevirtual 207	java/io/File:isDirectory	()Z
    //   39: ifeq +103 -> 142
    //   42: new 173	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 244	java/util/ArrayList:<init>	()V
    //   49: astore_3
    //   50: aload_0
    //   51: invokevirtual 211	java/io/File:listFiles	()[Ljava/io/File;
    //   54: astore 5
    //   56: aload 5
    //   58: arraylength
    //   59: istore 8
    //   61: iconst_0
    //   62: istore 7
    //   64: iload 7
    //   66: iload 8
    //   68: if_icmpge +22 -> 90
    //   71: aload_3
    //   72: aload 5
    //   74: iload 7
    //   76: aaload
    //   77: invokevirtual 259	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   80: pop
    //   81: iload 7
    //   83: iconst_1
    //   84: iadd
    //   85: istore 7
    //   87: goto -23 -> 64
    //   90: aload_1
    //   91: aload_3
    //   92: invokestatic 308	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:a	(Ljava/lang/String;Ljava/util/ArrayList;)I
    //   95: istore 7
    //   97: iload 7
    //   99: ifeq +62 -> 161
    //   102: invokestatic 311	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +30 -> 135
    //   108: ldc 10
    //   110: iconst_2
    //   111: new 60	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 313
    //   121: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: iload 7
    //   126: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 316	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_1
    //   136: invokestatic 321	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   139: pop
    //   140: iconst_0
    //   141: ireturn
    //   142: aload_0
    //   143: invokevirtual 295	java/io/File:isFile	()Z
    //   146: ifne +5 -> 151
    //   149: iconst_0
    //   150: ireturn
    //   151: aload_1
    //   152: aload_0
    //   153: invokestatic 323	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:a	(Ljava/lang/String;Ljava/io/File;)I
    //   156: istore 7
    //   158: goto -61 -> 97
    //   161: new 69	java/io/File
    //   164: dup
    //   165: aload_1
    //   166: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   169: astore 6
    //   171: aload 6
    //   173: invokevirtual 221	java/io/File:exists	()Z
    //   176: ifne +5 -> 181
    //   179: iconst_0
    //   180: ireturn
    //   181: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   184: ifeq +58 -> 242
    //   187: ldc 10
    //   189: iconst_4
    //   190: new 60	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   197: ldc_w 325
    //   200: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_1
    //   204: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: ldc 10
    //   215: iconst_4
    //   216: new 60	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 327
    //   226: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: invokevirtual 204	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   233: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: invokestatic 333	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   245: invokevirtual 334	java/util/UUID:toString	()Ljava/lang/String;
    //   248: astore_0
    //   249: new 336	java/net/URL
    //   252: dup
    //   253: ldc 47
    //   255: invokespecial 337	java/net/URL:<init>	(Ljava/lang/String;)V
    //   258: invokevirtual 341	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   261: checkcast 343	java/net/HttpURLConnection
    //   264: astore 5
    //   266: aload 5
    //   268: ldc 24
    //   270: invokevirtual 347	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   273: aload 5
    //   275: ldc 24
    //   277: invokevirtual 350	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   280: aload 5
    //   282: iconst_1
    //   283: invokevirtual 354	java/net/HttpURLConnection:setDoInput	(Z)V
    //   286: aload 5
    //   288: iconst_1
    //   289: invokevirtual 357	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   292: aload 5
    //   294: iconst_0
    //   295: invokevirtual 360	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   298: aload 5
    //   300: ldc_w 362
    //   303: invokevirtual 365	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   306: aload 5
    //   308: ldc_w 367
    //   311: ldc 50
    //   313: invokevirtual 371	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload 5
    //   318: ldc_w 373
    //   321: ldc_w 375
    //   324: invokevirtual 371	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: aload 5
    //   329: ldc_w 377
    //   332: new 60	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   339: ldc_w 379
    //   342: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: aload_0
    //   346: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokevirtual 371	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload 6
    //   357: ifnull +184 -> 541
    //   360: aload 5
    //   362: invokevirtual 383	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   365: astore_1
    //   366: new 385	java/io/DataOutputStream
    //   369: dup
    //   370: aload_1
    //   371: invokespecial 386	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   374: astore_3
    //   375: new 388	java/lang/StringBuffer
    //   378: dup
    //   379: invokespecial 389	java/lang/StringBuffer:<init>	()V
    //   382: astore_1
    //   383: aload_1
    //   384: ldc 38
    //   386: invokevirtual 392	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   389: pop
    //   390: aload_1
    //   391: aload_0
    //   392: invokevirtual 392	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   395: pop
    //   396: aload_1
    //   397: ldc 41
    //   399: invokevirtual 392	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   402: pop
    //   403: aload_1
    //   404: new 60	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 394
    //   414: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 6
    //   419: invokevirtual 112	java/io/File:getName	()Ljava/lang/String;
    //   422: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc_w 396
    //   428: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc 41
    //   433: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokevirtual 392	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   442: pop
    //   443: aload_1
    //   444: ldc_w 398
    //   447: invokevirtual 392	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   450: pop
    //   451: aload_1
    //   452: ldc 41
    //   454: invokevirtual 392	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   457: pop
    //   458: aload_3
    //   459: aload_1
    //   460: invokevirtual 399	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   463: invokevirtual 403	java/lang/String:getBytes	()[B
    //   466: invokevirtual 406	java/io/DataOutputStream:write	([B)V
    //   469: new 135	java/io/FileInputStream
    //   472: dup
    //   473: aload 6
    //   475: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   478: astore_1
    //   479: sipush 1024
    //   482: newarray <illegal type>
    //   484: astore 4
    //   486: aload_1
    //   487: aload 4
    //   489: invokevirtual 409	java/io/InputStream:read	([B)I
    //   492: istore 7
    //   494: iload 7
    //   496: iconst_m1
    //   497: if_icmpeq +46 -> 543
    //   500: aload_3
    //   501: aload 4
    //   503: iconst_0
    //   504: iload 7
    //   506: invokevirtual 410	java/io/DataOutputStream:write	([BII)V
    //   509: goto -23 -> 486
    //   512: astore_0
    //   513: aload_1
    //   514: ifnull +7 -> 521
    //   517: aload_1
    //   518: invokevirtual 150	java/io/InputStream:close	()V
    //   521: aload_0
    //   522: athrow
    //   523: astore_0
    //   524: aload_3
    //   525: astore_1
    //   526: aload_1
    //   527: ifnull +7 -> 534
    //   530: aload_1
    //   531: invokevirtual 411	java/io/DataOutputStream:close	()V
    //   534: aload_0
    //   535: athrow
    //   536: astore_0
    //   537: aload_0
    //   538: invokevirtual 412	java/net/MalformedURLException:printStackTrace	()V
    //   541: iconst_0
    //   542: ireturn
    //   543: aload_1
    //   544: ifnull +7 -> 551
    //   547: aload_1
    //   548: invokevirtual 150	java/io/InputStream:close	()V
    //   551: aload_3
    //   552: ldc 41
    //   554: invokevirtual 403	java/lang/String:getBytes	()[B
    //   557: invokevirtual 406	java/io/DataOutputStream:write	([B)V
    //   560: aload_3
    //   561: new 60	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   568: ldc 38
    //   570: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload_0
    //   574: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: ldc 41
    //   579: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokevirtual 403	java/lang/String:getBytes	()[B
    //   588: invokevirtual 406	java/io/DataOutputStream:write	([B)V
    //   591: new 60	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   598: astore_1
    //   599: aload_1
    //   600: ldc_w 414
    //   603: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload_1
    //   608: ldc 41
    //   610: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload_1
    //   615: new 60	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   622: aload_2
    //   623: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: ldc 41
    //   628: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: aload_1
    //   639: new 60	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   646: ldc 38
    //   648: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: aload_0
    //   652: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: ldc 41
    //   657: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload_1
    //   668: ldc_w 416
    //   671: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload_1
    //   676: ldc 41
    //   678: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: aload_1
    //   683: ldc_w 418
    //   686: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: pop
    //   690: aload_1
    //   691: new 60	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   698: ldc 38
    //   700: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: aload_0
    //   704: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: ldc 41
    //   709: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload_3
    //   720: aload_1
    //   721: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokevirtual 403	java/lang/String:getBytes	()[B
    //   727: invokevirtual 406	java/io/DataOutputStream:write	([B)V
    //   730: aload_3
    //   731: invokevirtual 421	java/io/DataOutputStream:flush	()V
    //   734: aload_3
    //   735: ifnull +7 -> 742
    //   738: aload_3
    //   739: invokevirtual 411	java/io/DataOutputStream:close	()V
    //   742: aload 5
    //   744: invokevirtual 424	java/net/HttpURLConnection:getResponseCode	()I
    //   747: istore 7
    //   749: new 426	java/io/BufferedReader
    //   752: dup
    //   753: new 428	java/io/InputStreamReader
    //   756: dup
    //   757: aload 5
    //   759: invokevirtual 432	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   762: ldc_w 434
    //   765: invokespecial 437	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   768: invokespecial 440	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   771: astore_0
    //   772: aload_0
    //   773: invokevirtual 443	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   776: astore_1
    //   777: aload_1
    //   778: ifnull +21 -> 799
    //   781: getstatic 449	java/lang/System:out	Ljava/io/PrintStream;
    //   784: aload_1
    //   785: invokevirtual 454	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   788: goto -16 -> 772
    //   791: astore_0
    //   792: aload_0
    //   793: invokevirtual 455	java/io/IOException:printStackTrace	()V
    //   796: goto -255 -> 541
    //   799: iload 7
    //   801: sipush 200
    //   804: if_icmpne -263 -> 541
    //   807: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   810: ifeq +12 -> 822
    //   813: ldc 10
    //   815: iconst_4
    //   816: ldc_w 457
    //   819: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   822: iconst_1
    //   823: ireturn
    //   824: astore_0
    //   825: aload 4
    //   827: astore_1
    //   828: goto -302 -> 526
    //   831: astore_0
    //   832: aconst_null
    //   833: astore_1
    //   834: goto -321 -> 513
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	837	0	paramFile	File
    //   0	837	1	paramString1	String
    //   0	837	2	paramString2	String
    //   49	690	3	localObject1	Object
    //   1	825	4	arrayOfByte	byte[]
    //   54	704	5	localObject2	Object
    //   169	305	6	localFile	File
    //   62	743	7	i1	int
    //   59	10	8	i2	int
    // Exception table:
    //   from	to	target	type
    //   479	486	512	finally
    //   486	494	512	finally
    //   500	509	512	finally
    //   375	469	523	finally
    //   517	521	523	finally
    //   521	523	523	finally
    //   547	551	523	finally
    //   551	734	523	finally
    //   249	355	536	java/net/MalformedURLException
    //   360	366	536	java/net/MalformedURLException
    //   530	534	536	java/net/MalformedURLException
    //   534	536	536	java/net/MalformedURLException
    //   738	742	536	java/net/MalformedURLException
    //   742	772	536	java/net/MalformedURLException
    //   772	777	536	java/net/MalformedURLException
    //   781	788	536	java/net/MalformedURLException
    //   807	822	536	java/net/MalformedURLException
    //   249	355	791	java/io/IOException
    //   360	366	791	java/io/IOException
    //   530	534	791	java/io/IOException
    //   534	536	791	java/io/IOException
    //   738	742	791	java/io/IOException
    //   742	772	791	java/io/IOException
    //   772	777	791	java/io/IOException
    //   781	788	791	java/io/IOException
    //   807	822	791	java/io/IOException
    //   366	375	824	finally
    //   469	479	831	finally
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent";
    }
    for (;;)
    {
      int i1;
      try
      {
        paramContext = new File(paramContext);
        if (paramContext.isDirectory())
        {
          QLog.e("QZoneAppCtrlUploadFileLogic", 1, "showDirFileList dirPath:" + paramContext.getAbsolutePath());
          paramContext = paramContext.listFiles();
          if (paramContext != null)
          {
            i1 = 0;
            if (i1 < paramContext.length)
            {
              if (paramContext[i1].isDirectory()) {
                QLog.e("QZoneAppCtrlUploadFileLogic", 1, "dir:" + paramContext[i1].getAbsolutePath());
              }
              if (!paramContext[i1].isFile()) {
                break label243;
              }
              QLog.e("QZoneAppCtrlUploadFileLogic", 1, "file:" + paramContext[i1].getAbsolutePath() + ",size:" + paramContext[i1].length());
              break label243;
            }
          }
        }
        else if (paramContext.isFile())
        {
          QLog.e("QZoneAppCtrlUploadFileLogic", 1, "showDirFileList filePath:" + paramContext.getAbsolutePath());
        }
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      label243:
      i1 += 1;
    }
  }
  
  /* Error */
  public static void c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: invokestatic 478	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: ldc_w 480
    //   6: invokevirtual 484	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   9: invokevirtual 487	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   12: astore_3
    //   13: invokestatic 490	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   16: ldc_w 492
    //   19: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +466 -> 488
    //   25: new 69	java/io/File
    //   28: dup
    //   29: new 60	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   36: invokestatic 214	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   39: invokevirtual 204	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   42: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: getstatic 72	java/io/File:separator	Ljava/lang/String;
    //   48: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 86	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:e	Ljava/lang/String;
    //   54: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: getstatic 72	java/io/File:separator	Ljava/lang/String;
    //   60: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 35
    //   65: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore_2
    //   75: aload_2
    //   76: invokevirtual 221	java/io/File:exists	()Z
    //   79: ifne +43 -> 122
    //   82: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   85: ifeq +32 -> 117
    //   88: ldc 10
    //   90: iconst_4
    //   91: new 60	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 497
    //   101: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_2
    //   105: invokevirtual 204	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   108: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_2
    //   118: invokevirtual 224	java/io/File:mkdirs	()Z
    //   121: pop
    //   122: new 69	java/io/File
    //   125: dup
    //   126: new 60	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   133: invokestatic 214	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   136: invokevirtual 204	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   139: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: getstatic 72	java/io/File:separator	Ljava/lang/String;
    //   145: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: getstatic 86	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:e	Ljava/lang/String;
    //   151: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: getstatic 72	java/io/File:separator	Ljava/lang/String;
    //   157: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc 35
    //   162: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: getstatic 72	java/io/File:separator	Ljava/lang/String;
    //   168: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc_w 499
    //   178: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   187: astore_2
    //   188: aload_2
    //   189: invokevirtual 221	java/io/File:exists	()Z
    //   192: ifne +301 -> 493
    //   195: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   198: ifeq +32 -> 230
    //   201: ldc 10
    //   203: iconst_4
    //   204: new 60	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 501
    //   214: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_2
    //   218: invokevirtual 204	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   221: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: aload_2
    //   231: invokevirtual 504	java/io/File:createNewFile	()Z
    //   234: pop
    //   235: goto +258 -> 493
    //   238: sipush 1024
    //   241: newarray <illegal type>
    //   243: astore 4
    //   245: ldc_w 505
    //   248: istore 5
    //   250: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   253: ifeq +12 -> 265
    //   256: ldc 10
    //   258: iconst_4
    //   259: ldc_w 507
    //   262: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: new 98	java/io/FileOutputStream
    //   268: dup
    //   269: aload_2
    //   270: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   273: astore_2
    //   274: invokestatic 510	java/lang/System:currentTimeMillis	()J
    //   277: lstore 7
    //   279: iload 5
    //   281: ifle +78 -> 359
    //   284: invokestatic 510	java/lang/System:currentTimeMillis	()J
    //   287: lstore 9
    //   289: lload 9
    //   291: lload 7
    //   293: lsub
    //   294: ldc2_w 511
    //   297: lcmp
    //   298: ifle +75 -> 373
    //   301: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   304: ifeq +55 -> 359
    //   307: ldc 10
    //   309: iconst_4
    //   310: new 60	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 514
    //   320: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: lload 9
    //   325: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   328: ldc_w 516
    //   331: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: lload 7
    //   336: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   339: ldc_w 518
    //   342: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: lload 9
    //   347: lload 7
    //   349: lsub
    //   350: invokevirtual 470	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   353: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: aload_2
    //   360: invokevirtual 519	java/io/FileOutputStream:close	()V
    //   363: aload_0
    //   364: aload_1
    //   365: invokestatic 521	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:d	(Landroid/content/Context;Ljava/lang/String;)V
    //   368: aload_3
    //   369: invokevirtual 150	java/io/InputStream:close	()V
    //   372: return
    //   373: aload_3
    //   374: aload 4
    //   376: iconst_0
    //   377: iload 5
    //   379: aload 4
    //   381: arraylength
    //   382: invokestatic 527	java/lang/Math:min	(II)I
    //   385: invokevirtual 145	java/io/InputStream:read	([BII)I
    //   388: istore 6
    //   390: iload 6
    //   392: iconst_m1
    //   393: if_icmpne +76 -> 469
    //   396: new 529	java/io/EOFException
    //   399: dup
    //   400: ldc_w 531
    //   403: invokespecial 532	java/io/EOFException:<init>	(Ljava/lang/String;)V
    //   406: athrow
    //   407: astore 4
    //   409: aload_2
    //   410: invokevirtual 519	java/io/FileOutputStream:close	()V
    //   413: aload_0
    //   414: aload_1
    //   415: invokestatic 521	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:d	(Landroid/content/Context;Ljava/lang/String;)V
    //   418: aload 4
    //   420: athrow
    //   421: astore_0
    //   422: aload_3
    //   423: invokevirtual 150	java/io/InputStream:close	()V
    //   426: aload_0
    //   427: athrow
    //   428: astore_0
    //   429: aload_0
    //   430: invokevirtual 455	java/io/IOException:printStackTrace	()V
    //   433: invokestatic 159	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   436: ifeq -64 -> 372
    //   439: ldc 10
    //   441: iconst_4
    //   442: new 60	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 534
    //   452: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload_0
    //   456: invokevirtual 535	java/io/IOException:toString	()Ljava/lang/String;
    //   459: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: return
    //   469: aload_2
    //   470: aload 4
    //   472: iconst_0
    //   473: iload 6
    //   475: invokevirtual 536	java/io/FileOutputStream:write	([BII)V
    //   478: iload 5
    //   480: iload 6
    //   482: isub
    //   483: istore 5
    //   485: goto -206 -> 279
    //   488: aconst_null
    //   489: astore_2
    //   490: goto -252 -> 238
    //   493: goto -255 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	496	0	paramContext	Context
    //   0	496	1	paramString	String
    //   74	416	2	localObject	Object
    //   12	411	3	localInputStream	java.io.InputStream
    //   243	137	4	arrayOfByte1	byte[]
    //   407	64	4	arrayOfByte2	byte[]
    //   248	236	5	i1	int
    //   388	95	6	i2	int
    //   277	71	7	l1	long
    //   287	59	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   274	279	407	finally
    //   284	289	407	finally
    //   301	359	407	finally
    //   373	390	407	finally
    //   396	407	407	finally
    //   469	478	407	finally
    //   265	274	421	finally
    //   359	368	421	finally
    //   409	421	421	finally
    //   0	117	428	java/io/IOException
    //   117	122	428	java/io/IOException
    //   122	230	428	java/io/IOException
    //   230	235	428	java/io/IOException
    //   238	245	428	java/io/IOException
    //   250	265	428	java/io/IOException
    //   368	372	428	java/io/IOException
    //   422	428	428	java/io/IOException
  }
  
  public static void d(Context paramContext, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneAppCtrlUploadFileLogic", 4, "uploadLogcat start zip");
    }
    paramContext = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + e + File.separator + "LOGCAT" + File.separator + paramString + "logcatwyx.txt");
    if (!paramContext.exists()) {
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + e + File.separator + "LOGCAT";
    String str = (String)localObject + File.separator + "upload.log" + ".zip";
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    a(paramContext, str, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\util\QZoneAppCtrlUploadFileLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */