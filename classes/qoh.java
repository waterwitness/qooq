import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.DingdongPluginBizHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.DingdongPluginHelper;

public class qoh
  extends AsyncTask
{
  public qoh(DingdongPluginBizHandler paramDingdongPluginBizHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    return Boolean.valueOf(DingdongPluginHelper.a(this.a.b.getApplication()));
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (!paramBoolean.booleanValue()) {
      DingdongPluginBizHandler.a(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qoh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */