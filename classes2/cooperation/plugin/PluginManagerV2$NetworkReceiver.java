package cooperation.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class PluginManagerV2$NetworkReceiver
  extends BroadcastReceiver
{
  private static final String jdField_a_of_type_JavaLangString = "android.net.conn.CONNECTIVITY_CHANGE";
  private Context jdField_a_of_type_AndroidContentContext;
  private boolean jdField_a_of_type_Boolean;
  
  public PluginManagerV2$NetworkReceiver(PluginManagerV2 paramPluginManagerV2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this, localIntentFilter);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
      PluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2).sendEmptyMessage(66304);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\plugin\PluginManagerV2$NetworkReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */