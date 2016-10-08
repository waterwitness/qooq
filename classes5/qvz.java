import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class qvz
  extends BusinessCardObserver
{
  public qvz(BusinessCardListActivity paramBusinessCardListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, "onGetCardList " + paramBoolean);
    }
    if (paramBoolean)
    {
      ArrayList localArrayList = this.a.a.a();
      this.a.a(localArrayList, 0L);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt != 3))
    {
      paramString = this.a.a.a();
      if ((paramInt == 1) && (this.a.f == 0)) {
        this.a.a(paramString, 0L);
      }
    }
    else
    {
      return;
    }
    this.a.a(paramString, 500L);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramString = this.a.a.a();
      this.a.a(paramString, 500L);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\qvz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */