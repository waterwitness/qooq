package com.tencent.mobileqq.search;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SearchUtil
{
  public SearchUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(TextView paramTextView)
  {
    float f = paramTextView.getResources().getDimensionPixelSize(2131493523) / paramTextView.getResources().getDisplayMetrics().densityDpi * FontSettingManager.a.densityDpi;
    if (f > 0.0F) {
      paramTextView.setMaxWidth((int)f);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\search\SearchUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */