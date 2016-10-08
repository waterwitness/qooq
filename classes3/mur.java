import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class mur
  extends Handler
{
  public mur(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    if (this.a.isFinishing()) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivityget_troop_member", 2, "handleMessage,msg.what:" + paramMessage.what);
      }
      int i;
      label725:
      boolean bool1;
      switch (paramMessage.what)
      {
      case 3: 
      case 4: 
      case 10: 
      default: 
        return;
      case 1: 
      case 2: 
        for (;;)
        {
          TroopMemberListActivity.a(this.a, paramMessage);
          return;
          this.a.k();
        }
      case 13: 
        paramMessage = this.a;
        paramMessage.jdField_a_of_type_Double += TroopMemberListActivity.b;
        if ((this.a.jdField_a_of_type_Double > this.a.jdField_a_of_type_AndroidWidgetProgressBar.getProgress()) && (this.a.jdField_a_of_type_Double < 90.0D) && (TroopMemberListActivity.a(this.a) > 0))
        {
          this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)this.a.jdField_a_of_type_Double);
          this.a.d.setText(String.format("加载中...(%d/%d)", new Object[] { Integer.valueOf((int)(TroopMemberListActivity.a(this.a) * this.a.jdField_a_of_type_Double / 100.0D)), Integer.valueOf(TroopMemberListActivity.a(this.a)) }));
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(13), 800L);
          return;
        }
        break;
      case 12: 
        Object localObject;
        synchronized (this.a)
        {
          localObject = (List)paramMessage.obj;
          if (localObject == null) {
            return;
          }
        }
        if (this.a.e.getVisibility() == 0)
        {
          this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(13);
          double d = Math.min(0.9D + paramMessage.arg1 * 1.0D / TroopMemberListActivity.a(this.a), 1.0D);
          i = (int)(100.0D * d);
          if (i > this.a.jdField_a_of_type_AndroidWidgetProgressBar.getProgress())
          {
            this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(i);
            this.a.d.setText(String.format("加载中...(%d/%d)", new Object[] { Integer.valueOf((int)(d * TroopMemberListActivity.a(this.a))), Integer.valueOf(TroopMemberListActivity.a(this.a)) }));
          }
        }
        TroopMemberListActivity.a(this.a).addAll((Collection)localObject);
        TroopMemberListActivity.b(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListActivityget_troop_member", 2, "handleMessage, mJobCount left:" + TroopMemberListActivity.c(this.a) + "mATroopMemberList.size():" + TroopMemberListActivity.a(this.a).size());
        }
        if (TroopMemberListActivity.c(this.a) <= 0)
        {
          this.a.k();
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListActivityget_troop_member", 2, "handleMessage real totalTime:" + (System.currentTimeMillis() - TroopMemberListActivity.a(this.a)) + "start refreshUI");
          }
          if (this.a.app.a() != null) {
            this.a.app.a().f();
          }
          localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a(TroopMemberListActivity.a(this.a));
          if ((localObject == null) || (localObject.length != 3)) {
            break label725;
          }
        }
        for (paramMessage.obj = new Object[] { TroopMemberListActivity.a(this.a), localObject[0], localObject[1], localObject[2] };; paramMessage.obj = new Object[] { TroopMemberListActivity.a(this.a) })
        {
          TroopMemberListActivity.a(this.a, paramMessage);
          return;
        }
      case 5: 
        if (this.a.J == 6)
        {
          bool1 = ((Boolean)paramMessage.obj).booleanValue();
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
          if (!bool1) {
            break label905;
          }
        }
        for (i = 0;; i = 1)
        {
          paramMessage.a(i);
          this.a.i = false;
          TroopMemberListActivity.a(this.a, 800L);
          paramMessage = (TroopManager)this.a.app.getManager(51);
          this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramMessage.a(this.a.k);
          if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (0L == this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwOfficeMode) && (this.a.h)) {
            this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwOfficeMode, false);
          }
          this.a.k();
          return;
        }
      case 6: 
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
        }
        if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        QQToast.a(this.a, this.a.getString(2131367364), 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
        return;
      case 7: 
        if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        QQToast.a(this.a, this.a.getString(2131367367), 0).b(this.a.jdField_a_of_type_AndroidViewView.getHeight());
        return;
      case 8: 
        paramMessage = (Object[])paramMessage.obj;
        bool1 = ((Boolean)paramMessage[0]).booleanValue();
        paramMessage = (ArrayList)paramMessage[1];
        ChatSettingForTroop.a(this.a, this.a.k, bool1, paramMessage);
        return;
      case 9: 
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
          return;
        }
        break;
      case 11: 
        label905:
        paramMessage = (TroopInfo)paramMessage.obj;
        if (paramMessage.troopowneruin != null) {
          this.a.n = paramMessage.troopowneruin;
        }
        if (paramMessage.Administrator != null) {
          this.a.o = paramMessage.Administrator;
        }
        ??? = this.a;
        if (!this.a.app.a().equals(paramMessage.troopowneruin))
        {
          bool1 = bool2;
          if (this.a.o != null)
          {
            bool1 = bool2;
            if (!this.a.o.contains(this.a.app.a())) {}
          }
        }
        else
        {
          bool1 = true;
        }
        ???.jdField_a_of_type_Boolean = bool1;
        if ((this.a.n != null) && (this.a.n.equals(this.a.app.a()))) {}
        for (this.a.F = "0"; this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null; this.a.F = "1")
        {
          label1295:
          this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
          return;
          if ((this.a.o == null) || (!this.a.o.contains(this.a.app.a()))) {
            break label1295;
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */