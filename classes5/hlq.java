import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class hlq
  implements AbsListView.OnScrollListener
{
  public hlq(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView instanceof AccountDetailXListView)) {
      ((AccountDetailXListView)paramAbsListView).a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.p)
    {
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.s() == 0)
      {
        paramInt1 = -this.a.d();
        this.a.e(paramInt1);
        this.a.g(paramInt1);
      }
    }
    else {
      return;
    }
    paramInt1 = (int)(this.a.G * AccountDetailActivity.jdField_a_of_type_Double);
    this.a.e(paramInt1);
    this.a.g(paramInt1);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hlq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */