import com.tencent.biz.pubaccount.AccountDetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity.AccountDetailAdapter;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hld
  extends PublicAccountObserver
{
  public hld(AccountDetailActivity paramAccountDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  void a()
  {
    if (this.a.m) {
      this.a.A();
    }
    this.a.m = true;
  }
  
  public void a(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    super.a(paramInt, paramPublicAccountInfo);
    a();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    super.a(paramBoolean, paramInt);
    this.a.v = true;
    if (paramInt == 0)
    {
      AccountDetailDynamicInfo localAccountDetailDynamicInfo = AccountDetailDynamicDataManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.a.p);
      if (localAccountDetailDynamicInfo != null)
      {
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter.a(localAccountDetailDynamicInfo.b(), localAccountDetailDynamicInfo.a);
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter.a(localAccountDetailDynamicInfo.b());
      }
    }
    if (paramBoolean) {
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter.b() == 0)
      {
        paramBoolean = bool1;
        if (paramBoolean) {
          this.a.t();
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.b(paramBoolean);
        bool1 = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.d("com.tencent.biz.pubaccount.AccountDetailActivity", 2, "onDynamicListGet: --hasMoreData=" + paramBoolean);
          bool1 = paramBoolean;
        }
        label160:
        if (paramInt != 1) {
          break label218;
        }
      }
    }
    for (this.a.P = AccountDetailActivity.N;; this.a.P = AccountDetailActivity.O) {
      label218:
      do
      {
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter.notifyDataSetChanged();
        return;
        paramBoolean = true;
        break;
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity$AccountDetailAdapter.notifyDataSetChanged();
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a();
        bool1 = bool2;
        break label160;
      } while ((paramInt != 4) && ((paramInt != 0) || (bool1)));
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */