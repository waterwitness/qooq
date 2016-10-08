package com.tencent.mobileqq.richmedia.dc;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ugj;
import ugy;

public class DCAIOPreviewProgressive
  extends DataCollector
  implements ReportEvent
{
  private ugj a;
  private boolean b;
  
  public DCAIOPreviewProgressive(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if ((this.a != null) && (!this.b))
    {
      ugy localugy = new ugy("Pic.AioPreview.Progressive", this.a.a("Pic.AioPreview.Progressive"));
      DataReport.a().a(localugy);
      this.b = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.a == null) && (!this.b))
    {
      ugj localugj = new ugj(null);
      ugj.a(localugj, paramBoolean);
      ugj.a(localugj, SystemClock.uptimeMillis());
      this.a = localugj;
    }
  }
  
  public void b()
  {
    if ((this.a != null) && (!this.b)) {
      ugj.b(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void c()
  {
    if ((this.a != null) && (!this.b)) {
      ugj.c(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void d()
  {
    if ((this.a != null) && (!this.b)) {
      ugj.b(this.a, true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richmedia\dc\DCAIOPreviewProgressive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */