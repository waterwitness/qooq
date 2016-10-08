import android.app.Dialog;
import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QzoneProgressDialog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

class ylo
  implements Runnable
{
  ylo(yln paramyln, boolean paramBoolean1, boolean paramBoolean2, IPluginManager.PluginParams paramPluginParams)
  {
    paramBoolean1 = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Intent localIntent = null;
    Object localObject = localIntent;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = localIntent;
      if (!this.b)
      {
        localObject = new QzoneProgressDialog(this.jdField_a_of_type_Yln.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Yln.jdField_a_of_type_AndroidContentIntent);
        ((QzoneProgressDialog)localObject).a("  正在加载...");
        ((QzoneProgressDialog)localObject).setOnDismissListener(new ylp(this));
      }
    }
    localIntent = this.jdField_a_of_type_Yln.jdField_a_of_type_AndroidContentIntent;
    if (localObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("QZoneExtra.Plugin.isloading", bool);
      this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a = ((Dialog)localObject);
      IPluginManager.a(this.jdField_a_of_type_Yln.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ylo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */