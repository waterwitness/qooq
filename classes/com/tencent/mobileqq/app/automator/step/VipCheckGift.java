package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.servlet.VipGifServlet;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import mqq.app.NewIntent;

public class VipCheckGift
  extends AsyncStep
{
  public VipCheckGift()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    Object localObject = (VipGiftManager)this.a.b.getManager(75);
    VipGiftDownloadInfo localVipGiftDownloadInfo = ((VipGiftManager)localObject).a();
    if (localVipGiftDownloadInfo != null)
    {
      if ((localVipGiftDownloadInfo.d != 0L) || (localVipGiftDownloadInfo.a == 0L)) {
        break label54;
      }
      ((VipGiftManager)localObject).a(localVipGiftDownloadInfo.a);
    }
    for (;;)
    {
      return 7;
      label54:
      if (localVipGiftDownloadInfo.d == 2L)
      {
        localObject = new NewIntent(this.a.b.getApplication(), VipGifServlet.class);
        ((NewIntent)localObject).setAction("gif_ui_show");
        ((NewIntent)localObject).putExtra("gif_ui_show_bid", 0);
        ((NewIntent)localObject).putExtra("gif_ui_show_seq", localVipGiftDownloadInfo.a);
        this.a.b.startServlet((NewIntent)localObject);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\VipCheckGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */