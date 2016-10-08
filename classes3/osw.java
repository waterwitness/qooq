import QCARD.CollectCouponRsp;
import QCARD.CouponMobileFolder;
import QCARD.GetListRsp;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.mobileqq.activity.qqcard.QQCardFooter;
import com.tencent.mobileqq.activity.qqcard.QQCardManager;
import com.tencent.mobileqq.app.QQCardObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class osw
  extends QQCardObserver
{
  public osw(QQCardFooter paramQQCardFooter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString, CollectCouponRsp paramCollectCouponRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardFooter", 2, "onCollectCouponRsp, " + paramBoolean + ", " + paramString);
    }
    if (!paramBoolean)
    {
      if (paramCollectCouponRsp != null) {
        this.a.a.a("qqcard.error.collectCoupon", paramCollectCouponRsp.ret_code);
      }
      this.a.b = null;
      QQToast.a(QQCardFooter.a(this.a), QQCardFooter.a(this.a).getString(2131366565), 0).a();
      QQCardFooter.a(this.a, paramString, 0);
      return;
    }
    QQCardFooter.a(this.a).sendEmptyMessageDelayed(5, 3000L);
  }
  
  public void d(boolean paramBoolean, GetListRsp paramGetListRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardFooter", 2, "onGetRecommendCoupon," + paramBoolean);
    }
    if ((paramBoolean) && (paramGetListRsp != null) && (paramGetListRsp.folder_list != null) && (paramGetListRsp.folder_list.size() > 0))
    {
      paramGetListRsp = (CouponMobileFolder)paramGetListRsp.folder_list.get(0);
      QQCardFooter.a(this.a, paramGetListRsp.coupon_list);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\osw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */