import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.DingdongPluginProxyBroadcastReceiver;
import mqq.app.AppRuntime;

public final class yba
  extends AsyncTask
{
  public yba(Intent paramIntent, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    return Boolean.valueOf(DingdongPluginHelper.a(BaseApplicationImpl.a().a().getApplication()));
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      paramBoolean = BaseApplicationImpl.a().a();
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentIntent);
      localIntent.putExtra("_inner_cmd_", this.jdField_a_of_type_Int);
      DingdongPluginProxyBroadcastReceiver.a(paramBoolean, localIntent);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\yba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */