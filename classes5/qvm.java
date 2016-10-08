import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class qvm
  extends BusinessCardObserver
{
  public qvm(BusinessCardEditActivity paramBusinessCardEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.a.c();
    if (paramBoolean)
    {
      this.a.b("名片更新成功，正在拉取新数据");
      return;
    }
    QQToast.a(this.a.getActivity(), 2, "修改失败，请重试。", 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.c();
    if ((paramBoolean) && (paramString.equals(this.a.k)))
    {
      if ((this.a.jdField_a_of_type_Boolean) && (this.a.t == 2) && (this.a.u == 1))
      {
        this.a.u = 0;
        this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(false);
      }
      if ((!this.a.jdField_a_of_type_Boolean) || (!this.a.b) || (this.a.isFinishing())) {
        break label114;
      }
      this.a.finish();
    }
    label114:
    do
    {
      return;
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(paramString);
    } while (paramString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = paramString;
    BusinessCardEditActivity.a(this.a, false, true, true);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    this.a.c();
    if (paramBoolean)
    {
      QQToast.a(this.a.getActivity(), 2, "删除成功", 0).b(this.a.getTitleBarHeight());
      this.a.finish();
      return;
    }
    QQToast.a(this.a.getActivity(), 1, "删除失败", 0).b(this.a.getTitleBarHeight());
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.c();
    if (paramBoolean)
    {
      this.a.b("名片创建成功，正在拉取数据");
      if (TextUtils.isEmpty(this.a.k)) {
        this.a.k = paramString;
      }
      if (this.a.t == 4) {
        this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(false);
      }
      return;
    }
    paramString = this.a.getResources().getString(2131371271);
    if (paramInt == 66) {
      paramString = this.a.getResources().getString(2131371272);
    }
    QQToast.a(this.a.getActivity(), 2, paramString, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */