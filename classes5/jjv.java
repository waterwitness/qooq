import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import com.tencent.biz.widgets.XChooserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jjv
  implements Runnable
{
  public jjv(XChooserActivity paramXChooserActivity, ActivityInfo paramActivityInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.getPreferences(0).edit();
      localEditor.putString(this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.m, this.jdField_a_of_type_AndroidContentPmActivityInfo.applicationInfo.packageName + '/' + this.jdField_a_of_type_AndroidContentPmActivityInfo.name);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jjv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */