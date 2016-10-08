import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class mqm
  extends TroopObserver
{
  public mqm(TroopGagActivity paramTroopGagActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean, List paramList)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Mqo.notifyDataSetChanged();
      if (this.a.jdField_a_of_type_Mqo.getCount() != 0) {
        break label181;
      }
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.a.getSharedPreferences("last_update_time" + this.a.app.a(), 0).edit().putLong("key_last_update_time" + this.a.b, System.currentTimeMillis()).commit();
      ThreadManager.a(new mqn(this, (TroopGagMgr)this.a.app.getManager(47)), 8, null, false);
      if (QLog.isColorLevel()) {
        QLog.d("TroopGagActivity", 2, "onUpdateTroopGetMemberList: isSuccess=" + paramBoolean);
      }
      return;
      label181:
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mqm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */