import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class pft
  implements View.OnClickListener
{
  public pft(PhoneContactSelectActivity paramPhoneContactSelectActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(this.a))
    {
      QQToast.a(this.a, this.a.getString(2131367256), 0).b(this.a.b.getHeight());
      return;
    }
    PstnManager localPstnManager = (PstnManager)this.a.app.getManager(142);
    Object localObject;
    if ((this.a.O == 0) && (this.a.a.getBooleanExtra("sendToVideo", false)) && (localPstnManager.e() == 1) && (PstnUtils.a(this.a.app, 2)) && (!localPstnManager.b()))
    {
      paramView = this.a.i.iterator();
      do
      {
        if (!paramView.hasNext()) {
          break;
        }
        localObject = (ResultRecord)paramView.next();
      } while ((((ResultRecord)localObject).jdField_a_of_type_Int != 0) || (!ChatActivityUtils.a(this.a.app, 0, ((ResultRecord)localObject).jdField_a_of_type_JavaLangString)));
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.a.g != null))
      {
        paramView = this.a.g.iterator();
        while (paramView.hasNext())
        {
          localObject = (String)paramView.next();
          if (ChatActivityUtils.a(this.a.app, 0, (String)localObject)) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if ((i != 0) || (NetworkUtil.b(this.a) == 2))
        {
          paramView = this.a.app.getApplication().getResources().getString(2131372512);
          localObject = this.a.app.getApplication().getResources().getString(2131372513);
          String str2 = localPstnManager.a("pstn_multi_trans_wording");
          String str1 = localPstnManager.a("pstn_multi_trans_check_wording");
          if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str1)) {
              break label371;
            }
          }
          for (;;)
          {
            DialogUtil.a(this.a, 230, "确认呼叫方式", paramView, (String)localObject, "取消", "呼叫", null, new pfu(this, localPstnManager), new pfv(this)).show();
            return;
            paramView = str2;
            break;
            label371:
            localObject = str1;
          }
        }
        if (PhoneContactSelectActivity.a(this.a)) {
          break;
        }
        this.a.h();
        return;
        if (PhoneContactSelectActivity.a(this.a)) {
          break;
        }
        if (this.a.P == 1005)
        {
          DialogUtil.a(this.a, 230, this.a.getResources().getString(2131364026), this.a.getResources().getString(2131364027), this.a.getResources().getString(2131364028), this.a.getResources().getString(2131364029), new pfw(this), new pfx(this)).show();
          return;
        }
        this.a.h();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */