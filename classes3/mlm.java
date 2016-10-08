import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.tencent.mobileqq.activity.SnapScreenActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;

class mlm
  implements Runnable
{
  mlm(mll parammll, File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Mll.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Mll.jdField_a_of_type_Mlj.k = this.jdField_a_of_type_Mll.jdField_a_of_type_Mlj.f;
      this.jdField_a_of_type_Mll.jdField_a_of_type_Mlj.a.a(false);
      this.jdField_a_of_type_Mll.jdField_a_of_type_Mlj.invalidate();
      this.jdField_a_of_type_Mll.jdField_a_of_type_Mlj.scheduleDrawable(null, new mln(this), SystemClock.uptimeMillis() + 1000L);
      String str = this.jdField_a_of_type_Mll.jdField_a_of_type_Mlj.a.jdField_a_of_type_AndroidContentContext.getString(2131368161).replace("${path}", SnapScreenActivity.jdField_a_of_type_JavaLangString);
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_Mll.jdField_a_of_type_Mlj.a.jdField_a_of_type_AndroidContentContext).edit();
      localEditor.putString("LastScreenShotUri", Uri.fromFile(this.jdField_a_of_type_JavaIoFile).toString());
      localEditor.commit();
      this.jdField_a_of_type_Mll.jdField_a_of_type_Mlj.a.jdField_a_of_type_AndroidContentContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.jdField_a_of_type_JavaIoFile)));
      Toast.makeText(this.jdField_a_of_type_Mll.jdField_a_of_type_Mlj.a.jdField_a_of_type_AndroidContentContext, str, 1).show();
    }
    for (;;)
    {
      this.jdField_a_of_type_Mll.jdField_a_of_type_Mlj.a.a();
      return;
      Toast.makeText(this.jdField_a_of_type_Mll.jdField_a_of_type_Mlj.a.jdField_a_of_type_AndroidContentContext, 2131368162, 1).show();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mlm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */