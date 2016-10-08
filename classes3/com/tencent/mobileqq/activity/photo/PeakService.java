package com.tencent.mobileqq.activity.photo;

import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack;
import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack.Stub;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import java.util.Arrays;
import mqq.os.MqqHandler;
import orc;

public class PeakService
  extends IntentService
{
  public static final int a = 1;
  public static final String a = "CompressCallback";
  public static final String b = "PicOperator";
  public static final String c = "CompressInfo";
  public static final String d = "CompressConfig";
  public static final String e = "ServiceAction";
  public static final String f = "PresendPath";
  public static final String g = "PresendCancelType";
  public static final String h = "PresendPrepareCallback";
  private static final String i = "PeakService";
  
  public PeakService()
  {
    super("PeakService");
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (QLog.isColorLevel())
    {
      int j = URLDrawable.getPoolSize();
      QLog.i("URLDrawableOptions", 2, "URLDrawableOptions peak hit is size " + j);
    }
  }
  
  public void a(CompressInfo paramCompressInfo, ICompressionCallBack paramICompressionCallBack)
  {
    CompressOperator.a(paramCompressInfo);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "CompressPic, current pid=" + Process.myPid());
    }
    if (paramICompressionCallBack != null)
    {
      if (!paramCompressInfo.a) {
        break label64;
      }
      paramICompressionCallBack.a(paramCompressInfo);
    }
    for (;;)
    {
      paramICompressionCallBack.c(paramCompressInfo);
      return;
      label64:
      paramICompressionCallBack.b(paramCompressInfo);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PeakService", 2, "onHandleIntent: intent is null");
      }
      return;
    }
    int j = paramIntent.getIntExtra("ServiceAction", -1);
    if (QLog.isColorLevel()) {
      QLog.d("PeakService", 2, "onHandleIntent, action = " + j);
    }
    switch (j)
    {
    default: 
      paramIntent = ThreadManager.a();
      if (paramIntent != null)
      {
        paramIntent.removeCallbacks(FileUtils.a);
        paramIntent.postDelayed(FileUtils.a, 1000L);
      }
      ThreadManager.a(new orc(this), 1, null, true);
    }
    for (;;)
    {
      URLDrawableHelper.a();
      return;
      Parcelable localParcelable = paramIntent.getParcelableExtra("CompressInfo");
      BinderWarpper localBinderWarpper = (BinderWarpper)paramIntent.getParcelableExtra("CompressCallback");
      paramIntent = paramIntent.getIntArrayExtra("CompressConfig");
      if ((paramIntent != null) && (paramIntent.length >= 9))
      {
        com.tencent.mobileqq.pic.compress.PicType.j = paramIntent[0];
        com.tencent.mobileqq.pic.compress.PicType.k = paramIntent[1];
        com.tencent.mobileqq.pic.compress.PicType.l = paramIntent[2];
        com.tencent.mobileqq.pic.compress.PicType.m = paramIntent[3];
        com.tencent.mobileqq.pic.compress.PicType.n = paramIntent[4];
        com.tencent.mobileqq.pic.compress.PicType.o = paramIntent[5];
        com.tencent.mobileqq.pic.compress.PicType.e = paramIntent[6];
        com.tencent.mobileqq.pic.compress.PicType.f = paramIntent[7];
        com.tencent.mobileqq.pic.compress.PicType.g = paramIntent[8];
        if (QLog.isColorLevel()) {
          QLog.d("PeakService", 2, "onHandleIntent, compressConfig = " + Arrays.toString(paramIntent));
        }
      }
      if (((localParcelable instanceof CompressInfo)) && (localBinderWarpper != null))
      {
        paramIntent = ICompressionCallBack.Stub.a(localBinderWarpper.a);
        a((CompressInfo)localParcelable, paramIntent);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\PeakService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */