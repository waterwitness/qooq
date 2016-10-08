import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class mgq
  implements Runnable
{
  mgq(mgp parammgp, mgv parammgv)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_Mgp.a.app.getPreferences().edit();
    localEditor.putString("chatHistoryEventName", this.jdField_a_of_type_Mgv.a);
    localEditor.putBoolean("chatHistoryEventEntryFirstShow", true);
    localEditor.commit();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mgq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */