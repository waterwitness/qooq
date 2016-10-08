import QCARD.CouponMobileFolder;
import QCARD.GetListRsp;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qqcard.QQCardActivity;
import com.tencent.mobileqq.activity.qqcard.QQCardFooter;
import com.tencent.mobileqq.activity.qqcard.QQCardManager;
import com.tencent.mobileqq.app.QQCardObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ost
  extends QQCardObserver
{
  public ost(QQCardActivity paramQQCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardActivity", 2, "onPushNewCard");
    }
    QQCardActivity.a(this.a, 4);
    QQCardActivity.a(this.a).b();
  }
  
  public void c(boolean paramBoolean, GetListRsp paramGetListRsp)
  {
    QQCardActivity.a(this.a, false);
    Object localObject;
    int i;
    if (QQCardActivity.a(this.a) == 3)
    {
      localObject = QQCardActivity.a(this.a);
      if (paramBoolean)
      {
        i = 0;
        ((PullRefreshHeader)localObject).a(i);
        QQCardActivity.a(this.a).sendEmptyMessageDelayed(3, 800L);
      }
    }
    else
    {
      if ((paramBoolean) && (paramGetListRsp != null) && (paramGetListRsp.folder_list != null) && (paramGetListRsp.folder_list.size() > 0)) {
        break label100;
      }
      QQCardActivity.a(this.a).sendEmptyMessage(4);
    }
    label100:
    do
    {
      return;
      i = 1;
      break;
      localObject = (CouponMobileFolder)paramGetListRsp.folder_list.get(0);
      if (QLog.isColorLevel()) {
        QLog.d("QQCard.QQCardActivity", 2, "onGetCouponList, unavailable_url=" + ((CouponMobileFolder)localObject).unavailable_url);
      }
      if (!TextUtils.isEmpty(((CouponMobileFolder)localObject).unavailable_url))
      {
        QQCardActivity.a(this.a).a("qqcard_expired_link", ((CouponMobileFolder)localObject).unavailable_url);
        QQCardActivity.a(this.a, ((CouponMobileFolder)localObject).unavailable_url);
      }
      QQCardActivity.a(this.a, paramGetListRsp.refresh_interval * 1000);
      if (paramGetListRsp.op_type == 1)
      {
        QQCardActivity.a(this.a, paramGetListRsp.sequence, paramGetListRsp.map_folderid_nextindex, (CouponMobileFolder)localObject);
        return;
      }
      if (paramGetListRsp.op_type == 2)
      {
        QQCardActivity.a(this.a);
        return;
      }
    } while (paramGetListRsp.op_type != 3);
    QQCardActivity.a(this.a, paramGetListRsp.sequence, (CouponMobileFolder)localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */