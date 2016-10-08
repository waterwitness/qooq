import android.os.Bundle;
import com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class hiu
  implements BusinessObserver
{
  public hiu(LebaSearchMoreInfoActivity paramLebaSearchMoreInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (Bundle)paramObject;
    switch (paramInt)
    {
    default: 
      return;
    case 17: 
      paramBoolean = ((Bundle)paramObject).getBoolean("result");
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramBoolean)
      {
        paramObject = this.a.getString(2131365012);
        localStringBuilder.append((String)paramObject);
        localStringBuilder.append(this.a.getString(2131365009));
        localStringBuilder.append(this.a.g);
        if (!paramBoolean) {
          break label233;
        }
        paramInt = 2;
        label104:
        QQToast.a(this.a, paramInt, localStringBuilder.toString(), 1).b(this.a.getTitleBarHeight());
        paramObject = this.a;
        if (!paramBoolean) {
          break label238;
        }
      }
      break;
    }
    label233:
    label238:
    for (paramInt = -1;; paramInt = 0)
    {
      ((LebaSearchMoreInfoActivity)paramObject).setResult(paramInt);
      return;
      this.a.a = ((Bundle)paramObject).getBoolean("isOpen");
      this.a.g = ((Bundle)paramObject).getString("name");
      if (this.a.g != null) {
        this.a.f = this.a.getString(2131365006, new Object[] { this.a.g });
      }
      LebaSearchMoreInfoActivity.a(this.a);
      return;
      paramObject = this.a.getString(2131365013);
      break;
      paramInt = 1;
      break label104;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hiu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */