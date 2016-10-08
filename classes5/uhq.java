import android.os.Bundle;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.widget.QQToast;

public class uhq
  extends SignatureObserver
{
  public uhq(EditActivity paramEditActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      i = ((Integer)paramObject).intValue();
      QQToast.a(this.a, "get rank finish rank:" + i, 0).a();
      return;
    }
    int i = ((Integer)paramObject).intValue();
    QQToast.a(this.a, "get rank finish ret:" + i, 0).a();
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if ((this.a.isResume()) && (paramBoolean) && (paramObject != null) && ((paramObject instanceof Bundle)))
    {
      paramObject = (Bundle)paramObject;
      int i = ((Bundle)paramObject).getInt("unReadNum");
      long l = ((Bundle)paramObject).getLong("lastUin");
      if ((i == 0) || (0L != l)) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uhq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */