package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import mqq.os.MqqHandler;
import vbv;

public class ShortVideoUploadABTest
{
  public static long a = 0L;
  public static ShortVideoUploadABTest.ABTestInfo a;
  public static Object a;
  private static final String a = "ShortVideoUploadABTest";
  public static HashMap a;
  public static boolean a = false;
  public static long b = 0L;
  public static ShortVideoUploadABTest.ABTestInfo b;
  private static final boolean b = true;
  public static long c;
  public static long d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_Boolean = true;
  }
  
  public static ShortVideoUploadABTest.ABTestInfo a(long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ShortVideoUploadABTest.ABTestInfo localABTestInfo2 = (ShortVideoUploadABTest.ABTestInfo)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      ShortVideoUploadABTest.ABTestInfo localABTestInfo1 = localABTestInfo2;
      if (localABTestInfo2 == null) {
        localABTestInfo1 = new ShortVideoUploadABTest.ABTestInfo();
      }
      jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localABTestInfo1);
      return localABTestInfo1;
    }
  }
  
  public static String a(ShortVideoUploadABTest.ABTestInfo paramABTestInfo)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("(Andr)老方案\n");
    String str;
    if (paramABTestInfo.jdField_e_of_type_Int == 0)
    {
      str = "成功";
      localStringBuilder2 = localStringBuilder2.append(str);
      if (paramABTestInfo.jdField_e_of_type_Int != 0) {
        break label315;
      }
      str = "";
      label41:
      localStringBuilder2.append(str).append("\n");
      localStringBuilder1.append("等待:").append(paramABTestInfo.jdField_b_of_type_Long).append("ms\n");
      localStringBuilder1.append("时长:").append(paramABTestInfo.jdField_f_of_type_Int).append("s\n");
      localStringBuilder1.append("Size:").append(paramABTestInfo.jdField_a_of_type_Long / 1024L).append("KB").append("\n");
      localStringBuilder1.append("AIO跳转:").append("400ms\n");
      localStringBuilder1.append("合成:").append(paramABTestInfo.jdField_e_of_type_Long).append("ms\n");
      localStringBuilder1.append("缩略图:").append(paramABTestInfo.i).append("ms\n");
      localStringBuilder1.append("Processor:").append(paramABTestInfo.h + "ms\n");
      localStringBuilder1.append("落地:").append(paramABTestInfo.jdField_d_of_type_JavaLangString).append("ms\n");
      localStringBuilder1.append("MD5:").append(paramABTestInfo.jdField_b_of_type_JavaLangString).append("\n");
      int i = NetworkCenter.a().a();
      if (i == -1) {
        break label344;
      }
      localStringBuilder1.append("Net:").append(com.tencent.mobileqq.app.AppConstants.b[i]).append("\n");
    }
    for (;;)
    {
      localStringBuilder1.append("StepInfo:").append(paramABTestInfo.jdField_c_of_type_JavaLangString).append("\n");
      localStringBuilder1.append("版本:").append("6.5.5.2880.2016-09-13.r229354.BaiDu");
      return localStringBuilder1.toString();
      str = "失败(";
      break;
      label315:
      str = String.valueOf(paramABTestInfo.jdField_e_of_type_Int) + ")";
      break label41;
      label344:
      localStringBuilder1.append("Net:").append("None").append("\n");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      if ((jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadABTest$ABTestInfo != null) && (b != null))
      {
        jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadABTest$ABTestInfo.jdField_a_of_type_Float = ((float)jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadABTest$ABTestInfo.jdField_b_of_type_Long);
        b.jdField_a_of_type_Float = ((float)b.jdField_b_of_type_Long);
        QLog.d("ShortVideoUploadABTest", 2, "VideoABTest :  performABTest : New :" + jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadABTest$ABTestInfo.jdField_a_of_type_Float + " Old:" + b.jdField_a_of_type_Float);
        localStringBuilder1 = new StringBuilder("(Andr)新老对比结果:\n");
        localStringBuilder2 = localStringBuilder1.append("新方案:").append("用户等待:");
        if (jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadABTest$ABTestInfo.jdField_b_of_type_Long >= 0L) {
          break label290;
        }
      }
      label290:
      for (Object localObject1 = "0";; localObject1 = String.valueOf(jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadABTest$ABTestInfo.jdField_b_of_type_Long))
      {
        localStringBuilder2.append((String)localObject1).append("ms,时长:").append(jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadABTest$ABTestInfo.jdField_f_of_type_Int).append("s").append("\n");
        localStringBuilder1.append("老方案:").append("用户等待:").append(b.jdField_b_of_type_Long).append("ms,时长:").append(b.jdField_f_of_type_Int).append("s").append("\n");
        localStringBuilder1.append("----------\n结论:");
        if (jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadABTest$ABTestInfo.jdField_a_of_type_Float > b.jdField_a_of_type_Float) {
          break;
        }
        localStringBuilder1.append("新方案更优");
        localObject1 = new SessionInfo();
        ((SessionInfo)localObject1).jdField_a_of_type_Int = jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadABTest$ABTestInfo.jdField_c_of_type_Int;
        ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadABTest$ABTestInfo.jdField_a_of_type_JavaLangString;
        ThreadManager.c().postDelayed(new vbv(paramQQAppInterface, (SessionInfo)localObject1, localStringBuilder1), 200L);
        jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadABTest$ABTestInfo = null;
        b = null;
        return;
      }
      localStringBuilder1.append("老方案更优");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String arg2, long paramLong, int paramInt2)
  {
    if (!b(paramInt1, ???)) {
      return;
    }
    for (;;)
    {
      ShortVideoUploadABTest.ABTestInfo localABTestInfo;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localABTestInfo = a(paramLong);
        if (localABTestInfo.jdField_d_of_type_Long == 0L)
        {
          QLog.d("ShortVideoUploadABTest", 2, "VideoABTest :  uinSeq" + paramLong + " FinishAt " + SystemClock.uptimeMillis());
          localABTestInfo.jdField_d_of_type_Long = SystemClock.uptimeMillis();
          if (paramInt2 != 3) {
            break label178;
          }
          localABTestInfo.jdField_d_of_type_Int = 1;
          if ((localABTestInfo.jdField_c_of_type_Long != 0L) && (localABTestInfo.m != 0L)) {
            a(paramQQAppInterface, localABTestInfo);
          }
        }
        else
        {
          return;
        }
      }
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : uinSeq" + paramLong + " Wait for : Merge_" + localABTestInfo.m + " Click_" + localABTestInfo.jdField_c_of_type_Long);
      continue;
      label178:
      localABTestInfo.jdField_d_of_type_Int = 0;
      if (localABTestInfo.jdField_c_of_type_Long != 0L) {
        a(paramQQAppInterface, localABTestInfo);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ShortVideoUploadABTest.ABTestInfo localABTestInfo = a(paramLong1);
      if (localABTestInfo.jdField_c_of_type_Long == 0L)
      {
        QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : uinSeq" + paramLong1 + " Show at " + SystemClock.uptimeMillis());
        localABTestInfo.jdField_c_of_type_Long = paramLong2;
        localABTestInfo.j = ((int)paramLong3);
        if ((localABTestInfo.jdField_d_of_type_Long != 0L) && (localABTestInfo.m != 0L)) {
          a(paramQQAppInterface, localABTestInfo);
        }
      }
      else
      {
        return;
      }
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : uinSeq" + paramLong1 + " Wait for : Merge_" + localABTestInfo.m + " Fini_" + localABTestInfo.jdField_d_of_type_Long);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      ShortVideoUploadABTest.ABTestInfo localABTestInfo = a(paramLong1);
      if (localABTestInfo.m == 0L)
      {
        QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : uinSeq" + paramLong1 + " updateCompressInfo : mergeCost: " + paramLong2 + " path:" + paramString);
        localABTestInfo.m = (paramLong2 / 1000L);
        localABTestInfo.jdField_f_of_type_JavaLangString = paramString;
        if ((localABTestInfo.jdField_d_of_type_Long != 0L) && (localABTestInfo.jdField_c_of_type_Long != 0L)) {
          a(paramQQAppInterface, localABTestInfo);
        }
      }
      else
      {
        return;
      }
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : uinSeq" + paramLong1 + " Wait for : Fini_" + localABTestInfo.jdField_d_of_type_Long + " Click_" + localABTestInfo.jdField_c_of_type_Long);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    if ((!b(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)) || (paramString == null)) {
      return;
    }
    ChatActivityFacade.b(paramQQAppInterface, paramContext, paramSessionInfo, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ShortVideoUploadABTest.ABTestInfo paramABTestInfo)
  {
    if (!b(paramABTestInfo.jdField_c_of_type_Int, paramABTestInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    String str1 = paramABTestInfo.jdField_f_of_type_JavaLangString;
    if ((str1 != null) && (str1.length() > 0)) {
      paramABTestInfo.o = new File(str1).length();
    }
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 10)
        {
          localObject = new MediaMetadataRetriever();
          ((MediaMetadataRetriever)localObject).setDataSource(str1);
          paramABTestInfo.q = Long.valueOf(((MediaMetadataRetriever)localObject).extractMetadata(9)).longValue();
        }
        paramABTestInfo.jdField_b_of_type_Long = (paramABTestInfo.jdField_d_of_type_Long - paramABTestInfo.jdField_c_of_type_Long - 400L);
        paramABTestInfo.jdField_a_of_type_Float = ((float)paramABTestInfo.jdField_b_of_type_Long / paramABTestInfo.jdField_f_of_type_Int);
        if (paramABTestInfo.jdField_d_of_type_Int != 1) {
          break label210;
        }
        str1 = b(paramABTestInfo);
        jdField_a_of_type_ComTencentMobileqqTransfileShortVideoUploadABTest$ABTestInfo = paramABTestInfo;
        Object localObject = new SessionInfo();
        ((SessionInfo)localObject).jdField_a_of_type_Int = paramABTestInfo.jdField_c_of_type_Int;
        ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramABTestInfo.jdField_a_of_type_JavaLangString;
        a(paramQQAppInterface);
        a(paramQQAppInterface, BaseApplication.getContext().getBaseContext(), (SessionInfo)localObject, str1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : dumpABTestInfo : dstPath : " + localException);
      continue;
      label210:
      String str2 = a(paramABTestInfo);
      b = paramABTestInfo;
    }
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    boolean bool1 = true;
    boolean bool3 = true;
    boolean bool2 = jdField_a_of_type_Boolean;
    if (b(paramInt, paramString)) {
      if (jdField_a_of_type_Boolean) {
        break label62;
      }
    }
    label62:
    for (bool1 = bool3;; bool1 = false)
    {
      jdField_a_of_type_Boolean = bool1;
      QLog.d("ShortVideoUploadABTest", 2, "VideoABTest : sEnablePreUpload" + jdField_a_of_type_Boolean);
      bool1 = bool2;
      return bool1;
    }
  }
  
  public static String b(ShortVideoUploadABTest.ABTestInfo paramABTestInfo)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("(Andr)新方案\n结果:");
    String str;
    if (paramABTestInfo.jdField_e_of_type_Int == 0)
    {
      str = "成功";
      localStringBuilder2 = localStringBuilder2.append(str);
      if (paramABTestInfo.jdField_e_of_type_Int != 0) {
        break label448;
      }
      str = "";
      label42:
      localStringBuilder2.append(str).append("\n");
      localStringBuilder2 = localStringBuilder1.append("等待:");
      if (paramABTestInfo.jdField_b_of_type_Long >= 0L) {
        break label459;
      }
      str = "0";
      label72:
      localStringBuilder2.append(str).append("ms");
      if (paramABTestInfo.jdField_b_of_type_Long >= 0L) {
        break label470;
      }
      localStringBuilder1.append("(").append(paramABTestInfo.jdField_b_of_type_Long).append(")\n");
      label114:
      localStringBuilder1.append("Rollback:").append(paramABTestInfo.g).append("\n");
      localStringBuilder1.append("录制时长:").append(paramABTestInfo.j).append("ms\n");
      localStringBuilder1.append("合成指令:").append(paramABTestInfo.k).append("ms\n");
      localStringBuilder1.append("合成:").append("mqq_").append(paramABTestInfo.m).append("ms,  svr_").append(paramABTestInfo.n).append("ms\n");
      localStringBuilder1.append("时长:").append("mqq_").append(paramABTestInfo.q).append("ms,  svr_").append(paramABTestInfo.r).append("s\n");
      localStringBuilder1.append("Size:").append("mqq_").append(paramABTestInfo.o / 1024L).append("KB,  svr_").append(paramABTestInfo.p / 1024L).append("KB\n");
      localStringBuilder1.append("落地:").append(paramABTestInfo.jdField_d_of_type_JavaLangString).append("ms\n");
      localStringBuilder1.append("upload:").append(paramABTestInfo.h + "ms\n");
      int i = NetworkCenter.a().a();
      if (i == -1) {
        break label480;
      }
      localStringBuilder1.append("Net:").append(com.tencent.mobileqq.app.AppConstants.b[i]).append("\n");
    }
    for (;;)
    {
      localStringBuilder1.append("分片耗时:").append(paramABTestInfo.jdField_e_of_type_JavaLangString).append("\n");
      localStringBuilder1.append("uniSeq:").append(paramABTestInfo.l).append("\n");
      localStringBuilder1.append("版本:").append("6.5.5.2880.2016-09-13.r229354.BaiDu");
      return localStringBuilder1.toString();
      str = "失败-";
      break;
      label448:
      str = String.valueOf(paramABTestInfo.jdField_e_of_type_Int);
      break label42;
      label459:
      str = String.valueOf(paramABTestInfo.jdField_b_of_type_Long);
      break label72;
      label470:
      localStringBuilder1.append("\n");
      break label114;
      label480:
      localStringBuilder1.append("Net:").append("None").append("\n");
    }
  }
  
  public static boolean b(int paramInt, String paramString)
  {
    if (!a()) {}
    do
    {
      return false;
      if ((paramInt == 0) && ("51640996".equalsIgnoreCase(paramString))) {
        return true;
      }
    } while ((paramInt != 1) || (!"498450958".equalsIgnoreCase(paramString)));
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\ShortVideoUploadABTest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */