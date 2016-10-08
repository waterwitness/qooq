package com.tencent.av.widget;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class QQToastFixedForMx
  extends QQToast
{
  public QQToastFixedForMx(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static boolean a()
  {
    String str = Build.BOARD;
    return (str.contains("mx2")) || (str.contains("mx5"));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\widget\QQToastFixedForMx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */