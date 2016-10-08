package com.tencent.mobileqq.theme.diy;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class ThemeDiyStyleLogic$DarkBrightnessTask
  extends AsyncTask
{
  public QQAppInterface app;
  Bundle bundle;
  Context ctx;
  ThemeDIYData data;
  ThemeDiyStyleLogic.StyleCallBack dealPicCallBack;
  String orgSrc;
  String saveSrc;
  
  public ThemeDiyStyleLogic$DarkBrightnessTask(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ThemeDIYData paramThemeDIYData, Bundle paramBundle, ThemeDiyStyleLogic.StyleCallBack paramStyleCallBack)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.ctx = paramContext;
    this.app = paramQQAppInterface;
    this.orgSrc = paramString1;
    this.data = paramThemeDIYData;
    this.bundle = paramBundle;
    this.saveSrc = paramString2;
    this.dealPicCallBack = paramStyleCallBack;
    if ((paramThemeDIYData != null) && (paramThemeDIYData.bgDiyPicRes != null)) {
      paramThemeDIYData.bgDiyPicRes.state = 4;
    }
  }
  
  protected Integer doInBackground(Object... paramVarArgs)
  {
    if (this.data == null) {
      return Integer.valueOf(0);
    }
    if ((this.data.bgDiyPicRes == null) || (!(this.ctx instanceof Activity)))
    {
      this.saveSrc = this.orgSrc;
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.doInBackground, params = null, orgSrc = " + this.orgSrc);
      }
      return Integer.valueOf(1);
    }
    paramVarArgs = new BitmapFactory.Options();
    paramVarArgs.inPreferredConfig = Bitmap.Config.RGB_565;
    paramVarArgs = BitmapManager.a(this.orgSrc, paramVarArgs);
    if (paramVarArgs == null) {
      return Integer.valueOf(0);
    }
    int i1 = this.data.dealInt;
    int i = paramVarArgs.getWidth();
    int j = paramVarArgs.getHeight();
    if (QLog.isColorLevel()) {
      QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.doInBackground, orgSrc = " + this.orgSrc);
    }
    Object localObject = (Activity)this.ctx;
    int k;
    int m;
    float f;
    if ((this.data.bgDiyPicRes.index != 0) && (localObject != null))
    {
      Rect localRect = new Rect();
      ((Activity)localObject).getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      k = localRect.width() * 3 / 4;
      m = localRect.height() * 3 / 4;
      if (1.0F * m / k >= 1.0F * j / i)
      {
        k = k * j / m;
        if (k <= paramVarArgs.getWidth()) {
          break label706;
        }
        k = paramVarArgs.getWidth();
        i = j;
        j = k;
        f = 1.0F * j / localRect.width();
        k = i;
        i = j;
        j = k;
        label315:
        if (this.data.position == 0) {
          break label689;
        }
        j -= (int)(DisplayUtils.a(this.ctx, 113.0F) * f);
        k = (int)(f * DisplayUtils.a(this.ctx, 51.0F));
      }
    }
    for (;;)
    {
      int n;
      try
      {
        localObject = Bitmap.createBitmap(i, j, paramVarArgs.getConfig());
        f = 0.01F * i1;
        m = 0;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        int i5;
        int i2;
        int i3;
        int i4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask OOM " + paramVarArgs.getMessage());
        return Integer.valueOf(0);
        m += 1;
        break label723;
        ImageUtil.a((Bitmap)localObject, new File(this.saveSrc));
        return Integer.valueOf(1);
      }
      catch (IOException paramVarArgs)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask ioError " + paramVarArgs.getMessage());
        continue;
      }
      catch (Exception paramVarArgs)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask Error  " + paramVarArgs.getMessage());
        continue;
      }
      if (n < j)
      {
        i5 = paramVarArgs.getPixel(m, n + k);
        if (i1 > 0)
        {
          i2 = Color.alpha(i5);
          i3 = Color.red(i5);
          i4 = Color.green(i5);
          i5 = Color.blue(i5);
          ((Bitmap)localObject).setPixel(m, n, Color.argb(i2, i3 + (int)((255 - i3) * f), i4 + (int)((255 - i4) * f), i5 + (int)((255 - i5) * f)));
          n += 1;
          continue;
          k = i * m / k;
          if (k <= paramVarArgs.getHeight()) {
            break label695;
          }
          k = paramVarArgs.getWidth();
          j = i;
          i = k;
          break;
        }
        ((Bitmap)localObject).setPixel(m, n, i5);
        continue;
      }
      label689:
      k = 0;
      continue;
      label695:
      j = i;
      i = k;
      break;
      label706:
      i = j;
      j = k;
      break;
      f = 0.75F;
      break label315;
      label723:
      if (m < i) {
        n = 0;
      }
    }
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    if (paramInteger.intValue() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.onPostExecute, result is ok");
      }
      ThemeBackground.setThemeBackgroundPic(this.ctx, this.data.dealSpkey, this.app.a(), this.saveSrc);
      this.dealPicCallBack.callback(14, 4, this.bundle, this.data.bgDiyPicRes);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.onPostExecute, result is error");
    }
    this.dealPicCallBack.callback(14, 8, this.bundle, this.data.bgDiyPicRes);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDiyStyleLogic$DarkBrightnessTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */