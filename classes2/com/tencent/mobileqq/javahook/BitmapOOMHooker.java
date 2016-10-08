package com.tencent.mobileqq.javahook;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.OOMHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import java.util.HashMap;
import mqq.os.MqqHandler;
import swr;

public class BitmapOOMHooker
{
  private static final int jdField_a_of_type_Int = 90001;
  private static OOMHandler jdField_a_of_type_ComTencentCommonAppOOMHandler;
  private static final int b = 90002;
  private static final int c = 90003;
  private static final int d = 90004;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = new OOMHandler(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
  }
  
  public static void a()
  {
    try
    {
      JavaHookBridge.findAndHookMethod(Bitmap.class, "createBitmap", new Object[] { DisplayMetrics.class, Integer.TYPE, Integer.TYPE, Bitmap.Config.class, Boolean.TYPE, new swr(90001) });
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      try
      {
        JavaHookBridge.findAndHookMethod(Bitmap.class, "createBitmap", new Object[] { DisplayMetrics.class, int[].class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Bitmap.Config.class, new swr(90002) });
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        try
        {
          for (;;)
          {
            JavaHookBridge.findAndHookMethod(BitmapFactory.class, "decodeResource", new Object[] { Resources.class, Integer.TYPE, BitmapFactory.Options.class, new swr(90003) });
            try
            {
              JavaHookBridge.findAndHookMethod(BitmapFactory.class, "decodeFile", new Object[] { String.class, BitmapFactory.Options.class, new swr(90004) });
              return;
            }
            catch (NoSuchMethodException localNoSuchMethodException4)
            {
              Utils.a(localNoSuchMethodException4);
            }
            localNoSuchMethodException1 = localNoSuchMethodException1;
            Utils.a(localNoSuchMethodException1);
            continue;
            localNoSuchMethodException2 = localNoSuchMethodException2;
            Utils.a(localNoSuchMethodException2);
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          for (;;)
          {
            Utils.a(localNoSuchMethodException3);
          }
        }
      }
    }
  }
  
  private static void b(boolean paramBoolean, int paramInt)
  {
    String str = null;
    Object localObject = (QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a();
    if (localObject != null) {
      str = ((QQAppInterface)localObject).a();
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", Integer.toString(paramInt));
    StatisticCollector.a(BaseApplicationImpl.a()).a(str, "BitmapOOMHooker", paramBoolean, 0L, 0L, (HashMap)localObject, "", true);
  }
  
  private static void c()
  {
    if (BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      BaseApplicationImpl.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.evictAll();
    }
    System.gc();
    Thread.yield();
    System.gc();
    if (ThreadManager.c().getLooper() != Looper.myLooper()) {}
    try
    {
      Thread.sleep(1000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\javahook\BitmapOOMHooker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */