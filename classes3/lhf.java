import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class lhf
  implements View.OnClickListener
{
  public lhf(EditInfoActivity paramEditInfoActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!this.a.c)
    {
      if (this.a.o == 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("type", this.a.k);
        localIntent.putExtra("subtype", this.a.l);
        localObject2 = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
        this.a.e();
        if ((this.a.u == null) || (this.a.u.length() == 0))
        {
          if ((localObject2 == null) || (((String)localObject2).length() == 0)) {
            EditInfoActivity.a(this.a);
          }
        }
        else {
          if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
            break label208;
          }
        }
        label208:
        while (!this.a.u.equals(localObject2))
        {
          paramView = (View)localObject2;
          if (this.a.n != 3) {
            break;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (((String)localObject2).length() >= 1) {}
          }
          else
          {
            localObject1 = "";
          }
          paramView = (View)localObject1;
          if (!this.a.a((String)localObject1)) {
            break;
          }
          QQToast.a(this.a, this.a.getString(2131367947), 0).b(this.a.getTitleBarHeight());
          return;
        }
        EditInfoActivity.b(this.a);
        return;
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = "";
        }
        localIntent.putExtra("result", (String)localObject1);
        this.a.a(localIntent);
        this.a.setResult(-1, localIntent);
        EditInfoActivity.c(this.a);
        return;
      }
      this.a.j();
      return;
    }
    paramView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (!NetworkUtil.e(this.a.app.getApplication().getApplicationContext()))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this.a);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(2, 2131369008, 1000);
      return;
    }
    if (((TextUtils.isEmpty(this.a.u)) && (TextUtils.isEmpty(paramView))) || ((!TextUtils.isEmpty(this.a.u)) && (this.a.u.equals(paramView))))
    {
      EditInfoActivity.d(this.a);
      return;
    }
    Object localObject1 = new TroopMemberCardInfo();
    ((TroopMemberCardInfo)localObject1).name = paramView;
    ((TroopMemberCardInfo)localObject1).memberuin = this.a.y;
    ((TroopMemberCardInfo)localObject1).troopuin = this.a.x;
    ((TroopMemberCardInfo)localObject1).email = "";
    ((TroopMemberCardInfo)localObject1).memo = "";
    ((TroopMemberCardInfo)localObject1).sex = -1;
    ((TroopMemberCardInfo)localObject1).tel = "";
    paramView = new ArrayList();
    paramView.add(localObject1);
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(Integer.valueOf(1));
    Object localObject2 = (TroopHandler)this.a.app.a(20);
    if ((localObject2 != null) && (!TextUtils.isEmpty(this.a.x)))
    {
      EditInfoActivity.a(this.a, true);
      ((TroopHandler)localObject2).a(this.a.x, paramView, (ArrayList)localObject1);
    }
    paramView = (TroopManager)this.a.app.getManager(51);
    int i;
    if (paramView != null)
    {
      paramView = paramView.a(this.a.x);
      if (paramView != null) {
        if ((!TextUtils.isEmpty(paramView.troopowneruin)) && (paramView.troopowneruin.equalsIgnoreCase(this.a.app.getAccount()))) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      ReportController.b(this.a.app, "P_CliOper", "Grp_manage", "", "modify_name", "complete", 0, 0, this.a.x, i + "", "" + this.a.n, "");
      return;
      if ((!TextUtils.isEmpty(paramView.Administrator)) && (paramView.Administrator.contains(this.a.app.getAccount()))) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lhf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */