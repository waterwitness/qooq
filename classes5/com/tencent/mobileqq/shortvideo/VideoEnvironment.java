package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.QQShortVideoData;
import com.tencent.mobileqq.earlydownload.xmldata.QQShortVideoDataX86;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import uql;
import uqm;

public class VideoEnvironment
{
  public static final int a = 0;
  public static Handler a;
  public static VideoEnvironment.ShortVideoConfig a;
  private static Object jdField_a_of_type_JavaLangObject;
  public static final String a;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  public static boolean a = false;
  private static int[] jdField_a_of_type_ArrayOfInt = new int[16];
  public static final int b = 1;
  private static Object b;
  public static final String b = "sv_config";
  public static boolean b = false;
  public static final int c = 2;
  public static final String c = "sv_whitelist";
  private static final boolean c = false;
  public static final int d = 4;
  private static final String jdField_d_of_type_JavaLangString;
  private static final boolean jdField_d_of_type_Boolean = false;
  public static final int e = -1;
  private static final String jdField_e_of_type_JavaLangString = "cachefile";
  private static final boolean jdField_e_of_type_Boolean = false;
  public static int f = 0;
  private static final String jdField_f_of_type_JavaLangString = "expfile";
  private static boolean jdField_f_of_type_Boolean = false;
  public static final int g = 2;
  private static final String g = "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1200#1500;640*480#450#750|c2x=1|discussion=1|group=1|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList=ZTE-T U880;Coolpad 5219;K-Touch S2|useDPCResolution=0|ratio=2;3|450#6500#3#3#35;750#6500#3#5#45;1200#6500#3#9#55;1500#6500#3#9#55,30|7|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1200#1500;640*480#450#750|c2x=1|discussion=1|group=1|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList=ZTE-T U880;Coolpad 5219;K-Touch S2|useDPCResolution=0|ratio=2;3|450#6500#3#3#35;750#6500#3#5#45;1200#6500#3#9#55;1500#6500#3#9#55,30|8|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1200#1500;640*480#450#750|c2x=1|discussion=1|group=1|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList=ZTE-T U880;Coolpad 5219;K-Touch S2|useDPCResolution=0|ratio=2;3|450#6500#3#3#35;750#6500#3#5#45;1200#6500#3#9#55;1500#6500#3#9#55,30|9|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1200#1500;640*480#450#750|c2x=0|discussion=1|group=1|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList=Nexus 5|blackList=ZTE-T U880;Coolpad 5219;K-Touch S2|useDPCResolution=0|ratio=2;3|450#6500#3#3#35;750#6500#3#5#45;1200#6500#3#9#55;1500#6500#3#9#55";
  public static final int h = 3;
  private static final String h = "sigbus_file";
  public static final int i = 4;
  private static final String i = "persist.sys.ui.hw";
  public static final int j = 5;
  public static final int k = 0;
  private static final int l = 22;
  private static final int m = 20;
  private static final int n = 256;
  private static final int o = 16;
  private static final int p = 0;
  private static final int q = 1;
  private static final int r = 6;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = VideoEnvironment.class.getSimpleName();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    d = "backup" + File.separatorChar;
    jdField_f_of_type_Int = -1;
    jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig = new VideoEnvironment.ShortVideoConfig();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_Boolean = true;
    jdField_b_of_type_JavaLangObject = new Object();
  }
  
  public static int a()
  {
    try
    {
      if (!jdField_f_of_type_Boolean)
      {
        getAVCodecLibMetadata(jdField_a_of_type_ArrayOfInt);
        jdField_f_of_type_Boolean = true;
      }
      i1 = jdField_a_of_type_ArrayOfInt[0];
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        int i1 = -1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "getAVCodecVersion: AVCodec_version=" + i1);
    }
    return i1;
  }
  
  private static int a(int paramInt)
  {
    if ((paramInt <= 0) && (paramInt >= 16)) {
      return 0;
    }
    try
    {
      if (!jdField_f_of_type_Boolean)
      {
        getAVCodecLibMetadata(jdField_a_of_type_ArrayOfInt);
        jdField_f_of_type_Boolean = true;
      }
      paramInt = jdField_a_of_type_ArrayOfInt[paramInt];
      return paramInt;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return 0;
  }
  
  public static int a(String paramString)
  {
    int i1 = -4;
    try
    {
      boolean bool = i();
      if (bool)
      {
        System.loadLibrary(paramString);
        return 0;
      }
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "loadTestEnvSolib:isTestEnvSurpportVideoSo=" + bool);
        return -4;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      i1 = -3;
    }
    return i1;
  }
  
  /* Error */
  public static int a(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: invokestatic 185	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6: invokestatic 191	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   9: astore 4
    //   11: new 94	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   18: aload 4
    //   20: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 116	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	Ljava/lang/String;
    //   26: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_3
    //   33: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +39 -> 75
    //   39: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: iconst_2
    //   43: new 94	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   50: ldc -63
    //   52: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_3
    //   56: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc -61
    //   61: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload 4
    //   66: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: getstatic 130	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   78: astore_2
    //   79: aload_2
    //   80: monitorenter
    //   81: aload_3
    //   82: invokestatic 198	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 5
    //   87: aload_2
    //   88: monitorexit
    //   89: aload 5
    //   91: ifnull +152 -> 243
    //   94: aload 5
    //   96: ldc -56
    //   98: invokevirtual 205	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   101: istore 6
    //   103: iload 6
    //   105: iconst_m1
    //   106: if_icmpeq +83 -> 189
    //   109: aload 5
    //   111: iload 6
    //   113: invokevirtual 209	java/lang/String:substring	(I)Ljava/lang/String;
    //   116: ldc -56
    //   118: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   121: ifeq +101 -> 222
    //   124: aload 5
    //   126: invokestatic 215	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/lang/String;)V
    //   129: iconst_1
    //   130: istore 6
    //   132: iload 6
    //   134: ifne +109 -> 243
    //   137: new 104	java/io/File
    //   140: dup
    //   141: new 94	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   148: aload 4
    //   150: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: invokestatic 218	com/tencent/video/decode/ShortVideoSoLoad:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   166: invokevirtual 223	java/io/File:exists	()Z
    //   169: ifne +59 -> 228
    //   172: bipush -2
    //   174: putstatic 226	com/tencent/video/decode/ShortVideoSoLoad:VIDEO_SO_LOAD_STATUS	I
    //   177: bipush -2
    //   179: istore 6
    //   181: iload 6
    //   183: ireturn
    //   184: astore_0
    //   185: aload_2
    //   186: monitorexit
    //   187: aload_0
    //   188: athrow
    //   189: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +30 -> 222
    //   195: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   198: iconst_2
    //   199: new 94	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   206: ldc -28
    //   208: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 5
    //   213: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: iconst_0
    //   223: istore 6
    //   225: goto -93 -> 132
    //   228: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +12 -> 243
    //   234: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   237: iconst_2
    //   238: ldc -26
    //   240: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: new 104	java/io/File
    //   246: dup
    //   247: new 94	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   254: aload_3
    //   255: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: invokestatic 218	com/tencent/video/decode/ShortVideoSoLoad:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   262: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   271: astore_2
    //   272: new 104	java/io/File
    //   275: dup
    //   276: new 94	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   283: aload 4
    //   285: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: aload_0
    //   289: invokestatic 218	com/tencent/video/decode/ShortVideoSoLoad:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   292: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   301: astore 4
    //   303: aload_2
    //   304: invokevirtual 223	java/io/File:exists	()Z
    //   307: ifne +110 -> 417
    //   310: aload 4
    //   312: invokevirtual 223	java/io/File:exists	()Z
    //   315: ifne +102 -> 417
    //   318: new 104	java/io/File
    //   321: dup
    //   322: new 94	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   329: aload_3
    //   330: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc 28
    //   335: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   344: astore 5
    //   346: getstatic 130	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   349: astore_3
    //   350: aload_3
    //   351: monitorenter
    //   352: aload 5
    //   354: invokevirtual 223	java/io/File:exists	()Z
    //   357: ifeq +197 -> 554
    //   360: aload 5
    //   362: aload_2
    //   363: invokestatic 233	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/io/File;Ljava/io/File;)Z
    //   366: istore 8
    //   368: aload_3
    //   369: monitorexit
    //   370: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +30 -> 403
    //   376: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   379: iconst_2
    //   380: new 94	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   387: ldc -21
    //   389: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: iload 8
    //   394: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   397: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: iload 8
    //   405: ifne +12 -> 417
    //   408: getstatic 226	com/tencent/video/decode/ShortVideoSoLoad:VIDEO_SO_LOAD_STATUS	I
    //   411: ireturn
    //   412: astore_0
    //   413: aload_3
    //   414: monitorexit
    //   415: aload_0
    //   416: athrow
    //   417: aload_2
    //   418: invokevirtual 223	java/io/File:exists	()Z
    //   421: ifeq +63 -> 484
    //   424: getstatic 130	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   427: astore_3
    //   428: aload_3
    //   429: monitorenter
    //   430: iload 9
    //   432: istore 8
    //   434: aload_2
    //   435: invokevirtual 223	java/io/File:exists	()Z
    //   438: ifeq +11 -> 449
    //   441: aload_2
    //   442: aload 4
    //   444: invokevirtual 239	java/io/File:renameTo	(Ljava/io/File;)Z
    //   447: istore 8
    //   449: aload_3
    //   450: monitorexit
    //   451: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   454: ifeq +30 -> 484
    //   457: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   460: iconst_2
    //   461: new 94	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   468: ldc -15
    //   470: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: iload 8
    //   475: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   478: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   484: getstatic 226	com/tencent/video/decode/ShortVideoSoLoad:VIDEO_SO_LOAD_STATUS	I
    //   487: istore 6
    //   489: getstatic 130	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   492: astore_2
    //   493: aload_2
    //   494: monitorenter
    //   495: aload_0
    //   496: aload_1
    //   497: invokestatic 243	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	(Ljava/lang/String;Landroid/content/Context;)I
    //   500: istore 7
    //   502: aload_2
    //   503: monitorexit
    //   504: iload 7
    //   506: istore 6
    //   508: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq -330 -> 181
    //   514: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   517: iconst_2
    //   518: new 94	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   525: ldc -11
    //   527: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: iload 7
    //   532: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   535: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: iload 7
    //   543: ireturn
    //   544: astore_0
    //   545: aload_3
    //   546: monitorexit
    //   547: aload_0
    //   548: athrow
    //   549: astore_0
    //   550: aload_2
    //   551: monitorexit
    //   552: aload_0
    //   553: athrow
    //   554: iconst_0
    //   555: istore 8
    //   557: goto -189 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	560	0	paramString	String
    //   0	560	1	paramContext	Context
    //   32	514	3	localObject2	Object
    //   9	434	4	localObject3	Object
    //   85	276	5	localObject4	Object
    //   101	406	6	i1	int
    //   500	42	7	i2	int
    //   366	190	8	bool1	boolean
    //   1	430	9	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   81	89	184	finally
    //   185	187	184	finally
    //   352	368	412	finally
    //   368	370	412	finally
    //   413	415	412	finally
    //   434	449	544	finally
    //   449	451	544	finally
    //   545	547	544	finally
    //   495	504	549	finally
    //   550	552	549	finally
  }
  
  public static int a(String paramString, Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i2 = a(paramString, paramContext);
      int i1 = i2;
      if (i2 == 0)
      {
        int i3 = a();
        i1 = i2;
        if (i3 < 20)
        {
          ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS = -5;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "loadAVCodecSoNotify:soversion=" + i3 + " dymAVCodecVersion=" + 20);
          }
          i1 = ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS;
        }
      }
      return i1;
    }
    return b(paramString, paramContext);
  }
  
  public static Context a()
  {
    return BaseApplicationImpl.getContext();
  }
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 104	java/io/File
    //   5: dup
    //   6: new 94	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   13: aload_0
    //   14: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc 31
    //   19: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 223	java/io/File:exists	()Z
    //   33: ifeq +134 -> 167
    //   36: aload_0
    //   37: invokevirtual 262	java/io/File:isFile	()Z
    //   40: ifeq +166 -> 206
    //   43: aload_0
    //   44: invokevirtual 266	java/io/File:length	()J
    //   47: l2i
    //   48: istore 4
    //   50: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +31 -> 84
    //   56: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   59: iconst_2
    //   60: new 94	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 268
    //   70: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: iload 4
    //   75: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: iload 4
    //   86: ifle +69 -> 155
    //   89: iload 4
    //   91: sipush 256
    //   94: if_icmpgt +61 -> 155
    //   97: new 270	java/io/FileInputStream
    //   100: dup
    //   101: aload_0
    //   102: invokespecial 273	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   105: astore_1
    //   106: aload_1
    //   107: astore_0
    //   108: iload 4
    //   110: newarray <illegal type>
    //   112: astore_3
    //   113: aload_1
    //   114: astore_0
    //   115: aload_1
    //   116: aload_3
    //   117: invokevirtual 277	java/io/FileInputStream:read	([B)I
    //   120: pop
    //   121: aload_1
    //   122: astore_0
    //   123: aload_1
    //   124: invokevirtual 280	java/io/FileInputStream:close	()V
    //   127: new 202	java/lang/String
    //   130: dup
    //   131: aload_3
    //   132: invokespecial 283	java/lang/String:<init>	([B)V
    //   135: astore_0
    //   136: aload_0
    //   137: invokevirtual 286	java/lang/String:trim	()Ljava/lang/String;
    //   140: pop
    //   141: iconst_0
    //   142: ifeq +11 -> 153
    //   145: new 288	java/lang/NullPointerException
    //   148: dup
    //   149: invokespecial 289	java/lang/NullPointerException:<init>	()V
    //   152: athrow
    //   153: aload_0
    //   154: areturn
    //   155: iconst_0
    //   156: ifeq +11 -> 167
    //   159: new 288	java/lang/NullPointerException
    //   162: dup
    //   163: invokespecial 289	java/lang/NullPointerException:<init>	()V
    //   166: athrow
    //   167: aconst_null
    //   168: areturn
    //   169: astore_2
    //   170: aconst_null
    //   171: astore_1
    //   172: aload_1
    //   173: astore_0
    //   174: aload_2
    //   175: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   178: aload_1
    //   179: ifnull -12 -> 167
    //   182: aload_1
    //   183: invokevirtual 280	java/io/FileInputStream:close	()V
    //   186: goto -19 -> 167
    //   189: astore_0
    //   190: goto -23 -> 167
    //   193: astore_0
    //   194: aload_2
    //   195: astore_1
    //   196: aload_1
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: invokevirtual 280	java/io/FileInputStream:close	()V
    //   204: aload_0
    //   205: athrow
    //   206: aload_0
    //   207: invokevirtual 293	java/io/File:delete	()Z
    //   210: pop
    //   211: goto -44 -> 167
    //   214: astore_1
    //   215: aload_0
    //   216: areturn
    //   217: astore_0
    //   218: goto -51 -> 167
    //   221: astore_1
    //   222: goto -18 -> 204
    //   225: astore_2
    //   226: aload_0
    //   227: astore_1
    //   228: aload_2
    //   229: astore_0
    //   230: goto -34 -> 196
    //   233: astore_2
    //   234: goto -62 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramString	String
    //   105	96	1	localObject1	Object
    //   214	1	1	localIOException1	IOException
    //   221	1	1	localIOException2	IOException
    //   227	1	1	str	String
    //   1	1	2	localObject2	Object
    //   169	26	2	localIOException3	IOException
    //   225	4	2	localObject3	Object
    //   233	1	2	localIOException4	IOException
    //   112	20	3	arrayOfByte	byte[]
    //   48	61	4	i1	int
    // Exception table:
    //   from	to	target	type
    //   43	84	169	java/io/IOException
    //   97	106	169	java/io/IOException
    //   127	141	169	java/io/IOException
    //   182	186	189	java/io/IOException
    //   43	84	193	finally
    //   97	106	193	finally
    //   127	141	193	finally
    //   145	153	214	java/io/IOException
    //   159	167	217	java/io/IOException
    //   200	204	221	java/io/IOException
    //   108	113	225	finally
    //   115	121	225	finally
    //   123	127	225	finally
    //   174	178	225	finally
    //   108	113	233	java/io/IOException
    //   115	121	233	java/io/IOException
    //   123	127	233	java/io/IOException
  }
  
  private static String a(String paramString1, String paramString2)
  {
    int i1 = paramString1.indexOf("=");
    if (i1 == -1) {
      return paramString2;
    }
    return paramString1.substring(i1 + 1);
  }
  
  public static void a()
  {
    if ((jdField_f_of_type_Int & 0x1) == 0) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        CodecParam.jdField_g_of_type_Int = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_b_of_type_Int;
        CodecParam.h = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.u;
        CodecParam.i = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.v;
        jdField_f_of_type_Int |= 0x1;
        return;
      }
    }
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoEnvironment", 2, "VideoEnvironment|progress=" + paramInt);
    }
    for (;;)
    {
      try
      {
        Object[] arrayOfObject = jdField_a_of_type_JavaUtilArrayList.toArray();
        if ((arrayOfObject == null) || (arrayOfObject.length <= 0)) {
          return;
        }
      }
      finally {}
      int i1 = 0;
      while (i1 < localObject.length)
      {
        VideoEnvironment.ShortVideoDownload localShortVideoDownload = (VideoEnvironment.ShortVideoDownload)localObject[i1];
        jdField_a_of_type_AndroidOsHandler.post(new uql(localShortVideoDownload, paramInt));
        i1 += 1;
      }
    }
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      CodecParam.D = paramInt * 1000;
    }
    for (CodecParam.D += 100000;; CodecParam.D += 350000)
    {
      CodecParam.E *= 4;
      return;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramAppInterface == null) && (QLog.isColorLevel())) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initConfig()[use default index]: app is null");
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = paramString;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "initConfig()[use user passed config]: config is null");
      }
      localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.NewShortVideoConfig.name(), null);
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initConfig(): DPConfig = " + (String)localObject1);
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1200#1500;640*480#450#750|c2x=1|discussion=1|group=1|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList=ZTE-T U880;Coolpad 5219;K-Touch S2|useDPCResolution=0|ratio=2;3|450#6500#3#3#35;750#6500#3#5#45;1200#6500#3#9#55;1500#6500#3#9#55,30|7|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1200#1500;640*480#450#750|c2x=1|discussion=1|group=1|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList=ZTE-T U880;Coolpad 5219;K-Touch S2|useDPCResolution=0|ratio=2;3|450#6500#3#3#35;750#6500#3#5#45;1200#6500#3#9#55;1500#6500#3#9#55,30|8|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1200#1500;640*480#450#750|c2x=1|discussion=1|group=1|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList=ZTE-T U880;Coolpad 5219;K-Touch S2|useDPCResolution=0|ratio=2;3|450#6500#3#3#35;750#6500#3#5#45;1200#6500#3#9#55;1500#6500#3#9#55,30|9|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1200#1500;640*480#450#750|c2x=0|discussion=1|group=1|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList=Nexus 5|blackList=ZTE-T U880;Coolpad 5219;K-Touch S2|useDPCResolution=0|ratio=2;3|450#6500#3#3#35;750#6500#3#5#45;1200#6500#3#9#55;1500#6500#3#9#55";
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "initConfig(): config=" + paramString);
    }
    localObject1 = new VideoEnvironment.ShortVideoConfig();
    for (;;)
    {
      try
      {
        paramString = paramString.split(",");
        if ((paramString == null) || (paramString.length == 0))
        {
          if (!QLog.isColorLevel()) {
            break label1646;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "initConfig(): configs is null or its length is 0");
          return;
        }
        boolean bool = paramBoolean;
        if (!paramBoolean) {
          bool = DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name());
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "initConfig(): isInDPCWhiteList=" + bool);
        }
        if (!bool) {
          break label373;
        }
        i1 = paramString.length - 1;
        paramString = paramString[i1].split("\\|");
        if ((paramString != null) && (paramString.length >= 13)) {
          break;
        }
        if (!QLog.isColorLevel()) {
          break label1646;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "initConfig(): configs is null or length less than 13");
        return;
      }
      catch (Exception paramAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "initConfig(): " + paramAppInterface.getMessage());
        }
      }
      label320:
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "initConfig(): time cost " + (l2 - l1) + "ms");
      }
      a((VideoEnvironment.ShortVideoConfig)localObject1);
      return;
      label373:
      if (paramAppInterface == null) {
        break label1647;
      }
      paramAppInterface = paramAppInterface.a();
      i1 = Integer.valueOf(paramAppInterface.substring(paramAppInterface.length() - 1)).intValue() % (paramString.length - 1);
    }
    paramAppInterface = paramString[3].split("\\*");
    label652:
    label716:
    Object localObject2;
    if ((paramAppInterface == null) || (paramAppInterface.length != 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "initConfig(): resolution is null or length is not 2");
      }
    }
    else
    {
      ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_a_of_type_Int = i1;
      ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_d_of_type_Int = Integer.valueOf(paramAppInterface[0]).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_e_of_type_Int = Integer.valueOf(paramAppInterface[1]).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_b_of_type_Int = Integer.valueOf(paramString[0]).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_c_of_type_Int = Integer.valueOf(paramString[1]).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).l = Integer.valueOf(paramString[2]).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_f_of_type_Int = Integer.valueOf(paramString[4]).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_g_of_type_Int = Integer.valueOf(paramString[5]).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).i = Integer.valueOf(paramString[6]).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).h = Integer.valueOf(paramString[7]).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).j = Integer.valueOf(paramString[8]).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).k = Integer.valueOf(paramString[9]).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).m = Integer.valueOf(paramString[10]).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).n = Integer.valueOf(paramString[11]).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).o = Integer.valueOf(paramString[12]).intValue();
      if (paramString.length < 17)
      {
        i1 = 1;
        paramAppInterface = null;
      }
      while (i1 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "initConfig(): (resolutions == null) || (resolutions.length == 0) || (indexs.length != 3)");
        }
        ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_a_of_type_ArrayOfInt = new int[] { ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_d_of_type_Int };
        ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_b_of_type_ArrayOfInt = new int[] { ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_e_of_type_Int };
        ((VideoEnvironment.ShortVideoConfig)localObject1).p = 0;
        ((VideoEnvironment.ShortVideoConfig)localObject1).q = 0;
        ((VideoEnvironment.ShortVideoConfig)localObject1).r = 0;
        if (paramString.length <= 25) {
          break label1174;
        }
        paramAppInterface = a(paramString[17], "").split(";");
        ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_e_of_type_ArrayOfInt = new int[paramAppInterface.length];
        i1 = 0;
        while (i1 < paramAppInterface.length)
        {
          localObject2 = paramAppInterface[i1];
          ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_e_of_type_ArrayOfInt[i1] = Integer.valueOf((String)localObject2).intValue();
          i1 += 1;
        }
        paramAppInterface = a(paramString[13], "");
        if (TextUtils.isEmpty(paramAppInterface))
        {
          i1 = 1;
          paramAppInterface = null;
        }
        else
        {
          paramAppInterface = paramAppInterface.split(";");
          if ((paramAppInterface == null) || (paramAppInterface.length == 0)) {
            break label1653;
          }
          ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_a_of_type_ArrayOfInt = new int[paramAppInterface.length];
          ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_b_of_type_ArrayOfInt = new int[paramAppInterface.length];
          ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_c_of_type_ArrayOfInt = new int[paramAppInterface.length];
          ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_d_of_type_ArrayOfInt = new int[paramAppInterface.length];
          i1 = 0;
          label869:
          if (i1 >= paramAppInterface.length) {
            break label1640;
          }
          localObject2 = paramAppInterface[i1].split("#");
          if ((localObject2 == null) || (localObject2.length < 3)) {
            break label1659;
          }
          String[] arrayOfString = localObject2[0].split("\\*");
          if ((arrayOfString == null) || (arrayOfString.length != 2))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "initConfig(): res is null or length is not 2");
            }
            ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_a_of_type_ArrayOfInt[i1] = ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_d_of_type_Int;
            ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_b_of_type_ArrayOfInt[i1] = ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_e_of_type_Int;
          }
          while ((localObject2[1] != null) && (localObject2[2] != null))
          {
            ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_c_of_type_ArrayOfInt[i1] = Integer.valueOf(localObject2[1]).intValue();
            ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_d_of_type_ArrayOfInt[i1] = Integer.valueOf(localObject2[2]).intValue();
            break;
            ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_a_of_type_ArrayOfInt[i1] = Integer.valueOf(arrayOfString[0]).intValue();
            ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_b_of_type_ArrayOfInt[i1] = Integer.valueOf(arrayOfString[1]).intValue();
          }
        }
      }
      ((VideoEnvironment.ShortVideoConfig)localObject1).p = Integer.valueOf(a(paramString[14], "0")).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).q = Integer.valueOf(a(paramString[15], "0")).intValue();
      ((VideoEnvironment.ShortVideoConfig)localObject1).r = Integer.valueOf(a(paramString[16], "0")).intValue();
      if (((VideoEnvironment.ShortVideoConfig)localObject1).p >= paramAppInterface.length) {
        break label1668;
      }
      i1 = ((VideoEnvironment.ShortVideoConfig)localObject1).p;
      label1125:
      ((VideoEnvironment.ShortVideoConfig)localObject1).p = i1;
      if (((VideoEnvironment.ShortVideoConfig)localObject1).q >= paramAppInterface.length) {
        break label1674;
      }
      i1 = ((VideoEnvironment.ShortVideoConfig)localObject1).q;
      label1146:
      ((VideoEnvironment.ShortVideoConfig)localObject1).q = i1;
      if (((VideoEnvironment.ShortVideoConfig)localObject1).r >= paramAppInterface.length) {
        break label1680;
      }
    }
    label1174:
    label1640:
    label1646:
    label1647:
    label1653:
    label1659:
    label1668:
    label1674:
    label1680:
    for (int i1 = ((VideoEnvironment.ShortVideoConfig)localObject1).r;; i1 = 0)
    {
      ((VideoEnvironment.ShortVideoConfig)localObject1).r = i1;
      break label716;
      break label320;
      paramAppInterface = a(paramString[18], "").split(";");
      ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_f_of_type_ArrayOfInt = new int[paramAppInterface.length];
      i1 = 0;
      while (i1 < paramAppInterface.length)
      {
        localObject2 = paramAppInterface[i1];
        ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_f_of_type_ArrayOfInt[i1] = Integer.valueOf((String)localObject2).intValue();
        i1 += 1;
      }
      localObject2 = a(paramString[19], "").split(";");
      ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_g_of_type_ArrayOfInt = new int[paramAppInterface.length];
      i1 = 0;
      while (i1 < localObject2.length)
      {
        paramAppInterface = localObject2[i1];
        ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_g_of_type_ArrayOfInt[i1] = Integer.valueOf(paramAppInterface).intValue();
        i1 += 1;
      }
      paramAppInterface = a(paramString[20], "").split(";");
      if ((paramAppInterface != null) && (paramAppInterface.length == 2))
      {
        ((VideoEnvironment.ShortVideoConfig)localObject1).s = Integer.valueOf(paramAppInterface[0]).intValue();
        ((VideoEnvironment.ShortVideoConfig)localObject1).t = Integer.valueOf(paramAppInterface[1]).intValue();
      }
      ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_b_of_type_Boolean = a(paramString[21], "").toLowerCase().contains(Build.MODEL.toLowerCase());
      ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_c_of_type_Boolean = CameraCompatibleList.d(CameraCompatibleList.i);
      if (!((VideoEnvironment.ShortVideoConfig)localObject1).jdField_c_of_type_Boolean) {
        ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_c_of_type_Boolean = a(a(paramString[22], ""));
      }
      ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_a_of_type_Boolean = a(paramString[23], "").equals("1");
      paramAppInterface = a(paramString[24], "").split(";");
      if ((paramAppInterface != null) && (paramAppInterface.length == 2))
      {
        ((VideoEnvironment.ShortVideoConfig)localObject1).u = Integer.valueOf(paramAppInterface[0]).intValue();
        ((VideoEnvironment.ShortVideoConfig)localObject1).v = Integer.valueOf(paramAppInterface[1]).intValue();
      }
      paramAppInterface = paramString[25].split(";");
      if ((paramAppInterface == null) || (paramAppInterface.length <= 0)) {
        break label320;
      }
      i1 = 0;
      while (i1 < paramAppInterface.length)
      {
        paramString = paramAppInterface[i1].split("#");
        if ((paramString != null) && (paramString.length == 5))
        {
          int i2 = Integer.valueOf(paramString[0]).intValue();
          localObject2 = new VideoEnvironment.SVFileSizeCtrlFactor();
          ((VideoEnvironment.SVFileSizeCtrlFactor)localObject2).jdField_a_of_type_Int = Integer.valueOf(paramString[1]).intValue();
          ((VideoEnvironment.SVFileSizeCtrlFactor)localObject2).jdField_c_of_type_Int = Integer.valueOf(paramString[2]).intValue();
          ((VideoEnvironment.SVFileSizeCtrlFactor)localObject2).jdField_d_of_type_Int = Integer.valueOf(paramString[3]).intValue();
          ((VideoEnvironment.SVFileSizeCtrlFactor)localObject2).jdField_b_of_type_Int = Integer.valueOf(paramString[4]).intValue();
          ((VideoEnvironment.ShortVideoConfig)localObject1).jdField_a_of_type_AndroidUtilSparseArray.put(i2, localObject2);
        }
        i1 += 1;
      }
      break label320;
      i1 = 0;
      break label652;
      return;
      i1 = 0;
      break;
      i1 = 1;
      break label652;
      i1 += 1;
      break label869;
      i1 = 0;
      break label1125;
      i1 = 0;
      break label1146;
    }
  }
  
  public static void a(VideoEnvironment.ShortVideoConfig paramShortVideoConfig)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig = paramShortVideoConfig;
      jdField_f_of_type_Int = 0;
      return;
    }
  }
  
  public static void a(VideoEnvironment.ShortVideoDownload paramShortVideoDownload)
  {
    if (paramShortVideoDownload != null) {}
    try
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramShortVideoDownload))
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "VideoEnvironment:RegisterNotify");
        }
        jdField_a_of_type_JavaUtilArrayList.add(paramShortVideoDownload);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: invokestatic 185	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: invokestatic 191	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   14: astore_1
    //   15: new 94	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   22: aload_1
    //   23: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: getstatic 116	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	Ljava/lang/String;
    //   29: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore 7
    //   37: new 104	java/io/File
    //   40: dup
    //   41: aload 7
    //   43: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: astore_1
    //   47: aload_1
    //   48: invokevirtual 223	java/io/File:exists	()Z
    //   51: ifne +8 -> 59
    //   54: aload_1
    //   55: invokevirtual 550	java/io/File:mkdirs	()Z
    //   58: pop
    //   59: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +31 -> 93
    //   65: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   68: iconst_2
    //   69: new 94	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 552
    //   79: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 7
    //   84: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 156	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: aload 4
    //   95: astore_2
    //   96: aload 5
    //   98: astore_1
    //   99: getstatic 130	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   102: astore 6
    //   104: aload 4
    //   106: astore_2
    //   107: aload 5
    //   109: astore_1
    //   110: aload 6
    //   112: monitorenter
    //   113: aload_3
    //   114: astore_1
    //   115: new 104	java/io/File
    //   118: dup
    //   119: new 94	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   126: aload 7
    //   128: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 31
    //   133: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore 4
    //   144: aload_3
    //   145: astore_1
    //   146: aload 4
    //   148: invokevirtual 223	java/io/File:exists	()Z
    //   151: ifeq +11 -> 162
    //   154: aload_3
    //   155: astore_1
    //   156: aload 4
    //   158: invokevirtual 293	java/io/File:delete	()Z
    //   161: pop
    //   162: aload_3
    //   163: astore_1
    //   164: new 554	java/io/FileOutputStream
    //   167: dup
    //   168: aload 4
    //   170: invokespecial 555	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   173: astore_2
    //   174: aload_2
    //   175: aload_0
    //   176: invokevirtual 559	java/lang/String:getBytes	()[B
    //   179: invokevirtual 562	java/io/FileOutputStream:write	([B)V
    //   182: aload_2
    //   183: invokevirtual 563	java/io/FileOutputStream:close	()V
    //   186: aload_3
    //   187: astore_1
    //   188: aload_0
    //   189: aload 7
    //   191: iconst_0
    //   192: invokestatic 568	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   195: aload_3
    //   196: astore_1
    //   197: new 104	java/io/File
    //   200: dup
    //   201: new 94	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   208: aload 7
    //   210: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc_w 570
    //   216: invokestatic 218	com/tencent/video/decode/ShortVideoSoLoad:getLibActualName	(Ljava/lang/String;)Ljava/lang/String;
    //   219: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   228: new 104	java/io/File
    //   231: dup
    //   232: new 94	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   239: aload 7
    //   241: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc 28
    //   246: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   255: invokestatic 233	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Ljava/io/File;Ljava/io/File;)Z
    //   258: pop
    //   259: aload_3
    //   260: astore_1
    //   261: invokestatic 572	com/tencent/mobileqq/shortvideo/VideoEnvironment:c	()V
    //   264: aload_3
    //   265: astore_1
    //   266: aload 4
    //   268: invokevirtual 223	java/io/File:exists	()Z
    //   271: ifeq +11 -> 282
    //   274: aload_3
    //   275: astore_1
    //   276: aload 4
    //   278: invokevirtual 293	java/io/File:delete	()Z
    //   281: pop
    //   282: aload_3
    //   283: astore_1
    //   284: aload 6
    //   286: monitorexit
    //   287: iconst_0
    //   288: ifeq +11 -> 299
    //   291: new 288	java/lang/NullPointerException
    //   294: dup
    //   295: invokespecial 289	java/lang/NullPointerException:<init>	()V
    //   298: athrow
    //   299: return
    //   300: astore_3
    //   301: aload_1
    //   302: astore_0
    //   303: aload_0
    //   304: astore_1
    //   305: aload 6
    //   307: monitorexit
    //   308: aload_0
    //   309: astore_2
    //   310: aload_0
    //   311: astore_1
    //   312: aload_3
    //   313: athrow
    //   314: astore_0
    //   315: aload_2
    //   316: astore_1
    //   317: aload_0
    //   318: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   321: aload_2
    //   322: ifnull -23 -> 299
    //   325: aload_2
    //   326: invokevirtual 563	java/io/FileOutputStream:close	()V
    //   329: return
    //   330: astore_0
    //   331: return
    //   332: astore_0
    //   333: aload_1
    //   334: ifnull +7 -> 341
    //   337: aload_1
    //   338: invokevirtual 563	java/io/FileOutputStream:close	()V
    //   341: aload_0
    //   342: athrow
    //   343: astore_0
    //   344: return
    //   345: astore_1
    //   346: goto -5 -> 341
    //   349: astore_3
    //   350: aload_2
    //   351: astore_0
    //   352: goto -49 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	paramString	String
    //   14	324	1	localObject1	Object
    //   345	1	1	localIOException	IOException
    //   95	256	2	localObject2	Object
    //   7	276	3	localObject3	Object
    //   300	13	3	localObject4	Object
    //   349	1	3	localObject5	Object
    //   1	276	4	localFile	File
    //   4	104	5	localObject6	Object
    //   102	204	6	localObject7	Object
    //   35	205	7	str	String
    // Exception table:
    //   from	to	target	type
    //   115	144	300	finally
    //   146	154	300	finally
    //   156	162	300	finally
    //   164	174	300	finally
    //   188	195	300	finally
    //   197	259	300	finally
    //   261	264	300	finally
    //   266	274	300	finally
    //   276	282	300	finally
    //   284	287	300	finally
    //   305	308	300	finally
    //   99	104	314	java/io/IOException
    //   110	113	314	java/io/IOException
    //   312	314	314	java/io/IOException
    //   325	329	330	java/io/IOException
    //   99	104	332	finally
    //   110	113	332	finally
    //   312	314	332	finally
    //   317	321	332	finally
    //   291	299	343	java/io/IOException
    //   337	341	345	java/io/IOException
    //   174	186	349	finally
  }
  
  public static void a(boolean paramBoolean, AppInterface paramAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoEnvironment", 2, "VideoEnvironment[success=" + paramBoolean + "][Video so download success...]");
    }
    if ((paramBoolean) && (c(paramAppInterface))) {
      a("AVCodec", a(), true);
    }
    for (;;)
    {
      try
      {
        jdField_a_of_type_Boolean = true;
        paramAppInterface = jdField_a_of_type_JavaUtilArrayList.toArray();
        if (paramBoolean) {
          jdField_a_of_type_JavaUtilArrayList.clear();
        }
        if ((paramAppInterface == null) || (paramAppInterface.length <= 0)) {
          return;
        }
      }
      finally {}
      int i1 = 0;
      while (i1 < paramAppInterface.length)
      {
        VideoEnvironment.ShortVideoDownload localShortVideoDownload = (VideoEnvironment.ShortVideoDownload)paramAppInterface[i1];
        jdField_a_of_type_AndroidOsHandler.post(new uqm(localShortVideoDownload, paramBoolean));
        i1 += 1;
      }
    }
  }
  
  public static boolean a()
  {
    if (c()) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = VcSystemInfo.g();
      bool2 = f();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isX86Platform: isBeautySupported=" + bool1 + " isSoSupportBeauty=" + bool2);
      }
    } while ((!bool1) || (!bool2));
    return true;
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((paramInt2 < 0) || (paramInt2 >= 32)) {
      bool = false;
    }
    while ((a(paramInt1) & 0xFFFFFFFF & 1 << paramInt2) != 0) {
      return bool;
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    return (VersionUtils.d()) && (c(paramAppInterface)) && (!h());
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    if (!paramFile1.exists()) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "copySoToFilesDir: filesource not exist");
      }
    }
    long l1;
    long l2;
    do
    {
      return false;
      File localFile = new File(paramFile2 + "_tmp");
      FileUtils.a(paramFile1, localFile);
      FileUtils.a(localFile, paramFile2);
      l1 = paramFile1.length();
      l2 = paramFile2.length();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "copySoToFilesDir: soSize=" + l1 + " deSize=" + l2);
      }
    } while (l1 != l2);
    return true;
  }
  
  private static boolean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String str = Build.MODEL.toLowerCase();
      paramString = paramString.split("\\;");
      if ((paramString != null) && (paramString.length > 0))
      {
        int i2 = paramString.length;
        int i1 = 0;
        while (i1 < i2)
        {
          if (paramString[i1].equalsIgnoreCase(str)) {
            return true;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public static int[] a(int paramInt)
  {
    localObject4 = jdField_a_of_type_JavaLangObject;
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        localObject1 = GloableValue.jdField_d_of_type_ArrayOfInt;
        localObject3 = localObject1;
        if (localObject1.length != GloableValue.jdField_d_of_type_ArrayOfInt.length) {
          localObject3 = GloableValue.jdField_d_of_type_ArrayOfInt;
        }
        return (int[])localObject3;
      }
      finally {}
      Object localObject3 = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_f_of_type_ArrayOfInt;
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = GloableValue.jdField_f_of_type_ArrayOfInt;
        continue;
        localObject3 = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_g_of_type_ArrayOfInt;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = GloableValue.jdField_e_of_type_ArrayOfInt;
          continue;
          localObject3 = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_e_of_type_ArrayOfInt;
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = GloableValue.jdField_d_of_type_ArrayOfInt;
          }
        }
      }
    }
  }
  
  public static int[] a(int paramInt, boolean paramBoolean)
  {
    Object localObject3 = null;
    int[] arrayOfInt2;
    Object localObject2;
    if (jdField_f_of_type_Int != -1)
    {
      arrayOfInt2 = new int[4];
      do
      {
        do
        {
          synchronized (jdField_a_of_type_JavaLangObject)
          {
            if ((jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_ArrayOfInt == null) || (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_b_of_type_ArrayOfInt == null) || (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_ArrayOfInt == null) || (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_d_of_type_ArrayOfInt == null)) {
              return null;
            }
            if (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_Boolean)
            {
              arrayOfInt2[0] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_d_of_type_Int;
              arrayOfInt2[1] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_e_of_type_Int;
              arrayOfInt2[2] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_ArrayOfInt[1];
              arrayOfInt2[3] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_d_of_type_ArrayOfInt[1];
              int[] arrayOfInt1 = arrayOfInt2;
              return arrayOfInt1;
            }
          }
          localObject2 = localObject3;
        } while (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_ArrayOfInt == null);
        localObject2 = localObject3;
      } while (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_b_of_type_ArrayOfInt == null);
      if (!jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_b_of_type_Boolean) {
        break label251;
      }
      if (paramBoolean) {
        break label251;
      }
    }
    for (;;)
    {
      arrayOfInt2[0] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_ArrayOfInt[paramInt];
      arrayOfInt2[1] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_b_of_type_ArrayOfInt[paramInt];
      arrayOfInt2[2] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_ArrayOfInt[paramInt];
      arrayOfInt2[3] = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_d_of_type_ArrayOfInt[paramInt];
      localObject2 = arrayOfInt2;
      break;
      paramInt = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.q;
      continue;
      paramInt = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.r;
      continue;
      paramInt = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.p;
      continue;
      paramInt = 0;
      continue;
      return null;
      label251:
      switch (paramInt)
      {
      }
      paramInt = 1;
    }
  }
  
  public static int b(String paramString, Context paramContext)
  {
    int i1 = -4;
    if (ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS == 0)
    {
      int i2 = ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS;
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "loadAVCodecSo[already loaded],staus=" + i2);
        i1 = i2;
      }
    }
    do
    {
      return i1;
      if (d()) {
        return a("AVCodec", paramContext);
      }
      ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS = -4;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "loadAVCodecSo versionOK=false,staus=" + -4);
    return -4;
  }
  
  public static void b()
  {
    CodecParam.D = 450000;
    CodecParam.E = 100000;
    CodecParam.F = 38;
    CodecParam.G = 3;
    CodecParam.H = 5;
  }
  
  public static void b(int paramInt)
  {
    if (jdField_f_of_type_Int != -1) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        VideoEnvironment.SVFileSizeCtrlFactor localSVFileSizeCtrlFactor = (VideoEnvironment.SVFileSizeCtrlFactor)jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (localSVFileSizeCtrlFactor != null)
        {
          CodecParam.F = localSVFileSizeCtrlFactor.jdField_b_of_type_Int;
          CodecParam.G = localSVFileSizeCtrlFactor.jdField_c_of_type_Int;
          CodecParam.H = localSVFileSizeCtrlFactor.jdField_d_of_type_Int;
          CodecParam.D = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_f_of_type_Int;
          CodecParam.E = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_g_of_type_Int;
          CodecParam.I = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.k;
          CodecParam.J = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.l;
          jdField_f_of_type_Int |= 0x2;
          return;
        }
        CodecParam.F = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.h;
        CodecParam.G = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.i;
        CodecParam.H = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.j;
      }
    }
  }
  
  public static void b(VideoEnvironment.ShortVideoDownload paramShortVideoDownload)
  {
    if (paramShortVideoDownload != null) {}
    try
    {
      if (jdField_a_of_type_JavaUtilArrayList.contains(paramShortVideoDownload))
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "VideoEnvironment:UnregisterNotify");
        }
        jdField_a_of_type_JavaUtilArrayList.remove(paramShortVideoDownload);
      }
      return;
    }
    finally {}
  }
  
  public static boolean b()
  {
    if (c()) {}
    while (!a(6, 0)) {
      return false;
    }
    return true;
  }
  
  public static boolean b(int paramInt)
  {
    return a(paramInt) > 0;
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    return (VersionUtils.d()) && (c(paramAppInterface));
  }
  
  private static int c(String paramString, Context paramContext)
  {
    int i1 = a(paramString);
    ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS = i1;
    return i1;
  }
  
  private static void c()
  {
    Object localObject1 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplicationImpl.getContext());
    Object localObject2 = (String)localObject1 + d;
    File localFile1 = new File((String)localObject2 + "trim_process_pie");
    File localFile2 = new File((String)localObject1 + "trim_process_pie");
    if (localFile1.exists()) {
      a(localFile1, localFile2);
    }
    localObject2 = new File((String)localObject2 + "trim_process_pic");
    localObject1 = new File((String)localObject1 + "trim_process_pic");
    if (((File)localObject2).exists()) {
      a((File)localObject2, (File)localObject1);
    }
  }
  
  public static void c(int paramInt)
  {
    if (jdField_f_of_type_Int != -1) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        VideoEnvironment.SVFileSizeCtrlFactor localSVFileSizeCtrlFactor = (VideoEnvironment.SVFileSizeCtrlFactor)jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (localSVFileSizeCtrlFactor != null)
        {
          CodecParam.jdField_d_of_type_Int = localSVFileSizeCtrlFactor.jdField_a_of_type_Int;
          jdField_f_of_type_Int |= 0x4;
          return;
        }
        if (jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_Int > 600) {
          jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_Int = 8;
        }
        CodecParam.jdField_d_of_type_Int = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_Int * 1000;
      }
    }
  }
  
  public static boolean c()
  {
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isX86Platform: Build.CPU_ABI=" + str1 + " Build.CPU_ABI2=" + str2);
    }
    if ((str1 != null) && (!"".equals(str1)) && ("x86".equalsIgnoreCase(str1))) {}
    do
    {
      return true;
      if (VcSystemInfo.f() != 7) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "isX86Platform: VcSystemInfo.getCpuArchitecture()=x86");
    return true;
    return false;
  }
  
  /* Error */
  public static boolean c(AppInterface arg0)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 7
    //   6: getstatic 699	com/tencent/mobileqq/shortvideo/ShortVideoUtils:jdField_b_of_type_Boolean	Z
    //   9: ifne +11 -> 20
    //   12: getstatic 699	com/tencent/mobileqq/shortvideo/ShortVideoUtils:jdField_b_of_type_Boolean	Z
    //   15: istore 5
    //   17: iload 5
    //   19: ireturn
    //   20: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +44 -> 67
    //   26: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   29: iconst_2
    //   30: new 94	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 701
    //   40: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: getstatic 706	android/os/Build$VERSION:SDK_INT	I
    //   46: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: ldc_w 708
    //   52: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: getstatic 506	android/os/Build:MODEL	Ljava/lang/String;
    //   58: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: iload 7
    //   69: istore 5
    //   71: getstatic 706	android/os/Build$VERSION:SDK_INT	I
    //   74: bipush 10
    //   76: if_icmplt -59 -> 17
    //   79: getstatic 118	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_f_of_type_Int	I
    //   82: iconst_m1
    //   83: if_icmpne +89 -> 172
    //   86: aload_0
    //   87: aconst_null
    //   88: iconst_0
    //   89: invokestatic 710	com/tencent/mobileqq/shortvideo/VideoEnvironment:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Z)V
    //   92: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +77 -> 172
    //   98: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   101: iconst_2
    //   102: ldc_w 712
    //   105: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: iconst_2
    //   112: new 94	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 714
    //   122: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: getstatic 123	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   128: getfield 450	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:m	I
    //   131: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   143: iconst_2
    //   144: new 94	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 716
    //   154: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: getstatic 123	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   160: getfield 452	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:n	I
    //   163: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: getstatic 126	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   175: astore_0
    //   176: aload_0
    //   177: monitorenter
    //   178: getstatic 123	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   181: getfield 454	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:o	I
    //   184: istore_2
    //   185: getstatic 123	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   188: getfield 450	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:m	I
    //   191: istore_3
    //   192: getstatic 123	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   195: getfield 452	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:n	I
    //   198: istore 4
    //   200: getstatic 123	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig	Lcom/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig;
    //   203: getfield 518	com/tencent/mobileqq/shortvideo/VideoEnvironment$ShortVideoConfig:jdField_c_of_type_Boolean	Z
    //   206: istore 8
    //   208: aload_0
    //   209: monitorexit
    //   210: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +96 -> 309
    //   216: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   219: iconst_2
    //   220: new 94	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 718
    //   230: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: iload_2
    //   234: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   246: iconst_2
    //   247: new 94	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 720
    //   257: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: iload_3
    //   261: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   273: iconst_2
    //   274: new 94	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 722
    //   284: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: iload 4
    //   289: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: ldc_w 724
    //   295: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: iload 8
    //   300: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   303: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: iload 8
    //   311: ifeq +67 -> 378
    //   314: iload 7
    //   316: istore 5
    //   318: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq -304 -> 17
    //   324: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   327: iconst_2
    //   328: new 94	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 726
    //   338: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: iload 8
    //   343: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   346: ldc_w 708
    //   349: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: getstatic 506	android/os/Build:MODEL	Ljava/lang/String;
    //   355: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: iconst_0
    //   365: ireturn
    //   366: astore_0
    //   367: aload_0
    //   368: invokevirtual 178	java/lang/Throwable:printStackTrace	()V
    //   371: iconst_0
    //   372: ireturn
    //   373: astore_1
    //   374: aload_0
    //   375: monitorexit
    //   376: aload_1
    //   377: athrow
    //   378: getstatic 683	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   381: astore_0
    //   382: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +30 -> 415
    //   388: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   391: iconst_2
    //   392: new 94	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 728
    //   402: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_0
    //   406: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: invokestatic 595	com/tencent/mobileqq/shortvideo/VideoEnvironment:c	()Z
    //   418: ifeq +49 -> 467
    //   421: getstatic 128	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_b_of_type_Boolean	Z
    //   424: istore 6
    //   426: iload 6
    //   428: istore 5
    //   430: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq -416 -> 17
    //   436: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   439: iconst_2
    //   440: new 94	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   447: ldc_w 730
    //   450: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: iload 6
    //   455: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   458: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: iload 6
    //   466: ireturn
    //   467: iload_2
    //   468: iconst_1
    //   469: if_icmpne +78 -> 547
    //   472: aload_0
    //   473: ifnull +118 -> 591
    //   476: ldc_w 467
    //   479: aload_0
    //   480: invokevirtual 213	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   483: ifne +108 -> 591
    //   486: ldc_w 732
    //   489: aload_0
    //   490: invokevirtual 635	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   493: ifeq +98 -> 591
    //   496: iload 6
    //   498: istore 5
    //   500: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +41 -> 544
    //   506: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   509: iconst_2
    //   510: new 94	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   517: ldc_w 734
    //   520: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload_0
    //   524: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc_w 736
    //   530: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: iload 5
    //   535: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   538: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: iload 5
    //   546: ireturn
    //   547: iload 6
    //   549: istore 5
    //   551: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq -54 -> 500
    //   557: getstatic 71	com/tencent/mobileqq/shortvideo/VideoEnvironment:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   560: iconst_2
    //   561: new 94	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   568: ldc_w 738
    //   571: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: iconst_1
    //   575: invokevirtual 173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   578: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   584: iload 6
    //   586: istore 5
    //   588: goto -88 -> 500
    //   591: iconst_0
    //   592: istore 5
    //   594: goto -94 -> 500
    // Local variable table:
    //   start	length	slot	name	signature
    //   373	4	1	localObject	Object
    //   184	286	2	i1	int
    //   191	70	3	i2	int
    //   198	90	4	i3	int
    //   15	578	5	bool1	boolean
    //   1	584	6	bool2	boolean
    //   4	311	7	bool3	boolean
    //   206	136	8	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   86	92	366	java/lang/Throwable
    //   178	210	373	finally
    //   374	376	373	finally
  }
  
  private static int d(String paramString, Context paramContext)
  {
    int i2 = -4;
    String str = ShortVideoSoLoad.getShortVideoSoPath(BaseApplicationImpl.getContext());
    File localFile = new File(str);
    int i1;
    if (!localFile.exists())
    {
      localFile.mkdirs();
      i1 = i2;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkOldSigbusExisted:destDirFile not exist.");
        i1 = i2;
      }
    }
    for (;;)
    {
      return i1;
      localFile = new File(str + "sigbus_file");
      if (localFile.exists())
      {
        localFile.delete();
        paramString = new File(str + ShortVideoSoLoad.getLibActualName(paramString));
        if (paramString.exists())
        {
          paramString.delete();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "checkOldSigbusExisted:sigFile exist. delete so");
          }
        }
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkOldSigbusExisted:sigFile exist.");
        return -4;
      }
      try
      {
        localFile.createNewFile();
        i2 = ShortVideoSoLoad.LoadExtractedShortVideoSo(paramString, paramContext);
        if (localFile.exists()) {
          localFile.delete();
        }
        i1 = i2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkOldSigbusExisted: soload code=" + i2);
        return i2;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
  }
  
  public static void d(int paramInt)
  {
    Object localObject1;
    if (jdField_f_of_type_Int != -1)
    {
      localObject1 = jdField_a_of_type_JavaLangObject;
      if (paramInt > 0) {}
      for (;;)
      {
        try
        {
          CodecParam.jdField_d_of_type_Int = paramInt * 1000;
          jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_Int = paramInt;
          jdField_f_of_type_Int |= 0x4;
          return;
        }
        finally {}
        jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_Int = 8;
        CodecParam.jdField_d_of_type_Int = jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_c_of_type_Int * 1000;
      }
    }
  }
  
  public static boolean d()
  {
    int i2 = 22;
    long l1 = System.currentTimeMillis();
    boolean bool = c();
    if (bool) {}
    for (XmlData localXmlData = EarlyDataFactory.a(QQShortVideoDataX86.class);; localXmlData = EarlyDataFactory.a(QQShortVideoData.class))
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getAVCodecVersionOK[parseBySP]: time cost " + (l2 - l1) + "ms" + "  x86Platform=" + bool);
      }
      if (localXmlData != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getAVCodecVersionOK:data=null");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getAVCodecVersionOK:data=" + localXmlData.toString());
    }
    int i3 = localXmlData.loadState;
    int i1;
    if (i3 == 1)
    {
      i1 = localXmlData.Version;
      if ((localXmlData instanceof QQShortVideoData))
      {
        i1 = ((QQShortVideoData)localXmlData).VideoVersion;
        i2 = 20;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getAVCodecVersionOK:version=" + i1 + " loadState=" + i3 + " baseVersion=" + i2);
      }
      if ((i1 != -1) && (i1 >= i2) && (localXmlData.loadState == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getAVCodecVersionOK:success");
        }
        return true;
        if ((localXmlData instanceof QQShortVideoDataX86))
        {
          i1 = ((QQShortVideoDataX86)localXmlData).VideoVersion;
          i2 = 20;
        }
        else if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "getAVCodecVersionOK: data is invalid.");
        }
      }
      else
      {
        return false;
        i1 = -1;
      }
    }
  }
  
  public static boolean d(AppInterface paramAppInterface)
  {
    return c(paramAppInterface);
  }
  
  public static boolean e()
  {
    int i1 = a();
    boolean bool = b(2);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "supportSubmitCallback: soVersion =" + i1 + ", result = " + bool);
    }
    return bool;
  }
  
  public static boolean f()
  {
    return a(1) > 0;
  }
  
  public static boolean g()
  {
    if (Build.VERSION.SDK_INT < 14) {
      return false;
    }
    try
    {
      Class localClass = VideoEnvironment.class.getClassLoader().loadClass("android.os.SystemProperties");
      if (localClass == null) {
        break label89;
      }
      Method localMethod = localClass.getMethod("getBoolean", new Class[] { String.class, Boolean.TYPE });
      if (localMethod == null) {
        break label89;
      }
      bool = ((Boolean)localMethod.invoke(localClass, new Object[] { "persist.sys.ui.hw", Boolean.valueOf(false) })).booleanValue();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool = false;
        continue;
        bool = false;
      }
    }
    return bool;
  }
  
  private static native void getAVCodecLibMetadata(int[] paramArrayOfInt);
  
  private static boolean h()
  {
    return CameraCompatibleList.a(CameraCompatibleList.n);
  }
  
  private static boolean i()
  {
    String str = Build.CPU_ABI;
    boolean bool1 = VersionUtils.d();
    boolean bool2 = VcSystemInfo.a("neon");
    return (bool1) && (str != null) && (!"".equals(str)) && ("armeabi-v7a".equalsIgnoreCase(str)) && (bool2);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\VideoEnvironment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */