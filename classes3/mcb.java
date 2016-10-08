import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class mcb
  implements View.OnClickListener
{
  mcb(mby parammby, SharedPreferences paramSharedPreferences, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_JavaLangString, true).commit();
    this.jdField_a_of_type_Mby.a.a.sendEmptyMessageDelayed(1010, 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */