package com.tencent.mobileqq.equipmentlock;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class EquipLockCircleView
  extends View
{
  public EquipLockCircleView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Paint localPaint = new Paint();
    localPaint.setColor(getResources().getColor(2131428262));
    paramCanvas.drawCircle(AIOUtils.a(3.0F, getResources()), getHeight() / 2, AIOUtils.a(2.0F, getResources()), localPaint);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\equipmentlock\EquipLockCircleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */