import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicListModel;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView.RefreshCallback;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class hmd
  implements AccountDetailXListView.RefreshCallback
{
  public hmd(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(ListView paramListView)
  {
    if (this.a.v)
    {
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "startLoadMore: uin=" + this.a.p);
      }
      AccountDetailDynamicListModel.b(this.a.a, Long.parseLong(this.a.p));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */