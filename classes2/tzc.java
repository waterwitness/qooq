import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.vipav.VipFunCallObserver;

public class tzc
  extends VipFunCallObserver
{
  public tzc(QCallDetailActivity paramQCallDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramObject = (Bundle)paramObject;
      } while ((paramObject == null) || (TextUtils.isEmpty(QCallDetailActivity.a(this.a))) || (!QCallDetailActivity.a(this.a).equals(((Bundle)paramObject).getString("uin"))));
      if (this.a.app != null) {
        this.a.app.b(this);
      }
    } while (!paramBoolean);
    this.a.runOnUiThread(new tzd(this));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */