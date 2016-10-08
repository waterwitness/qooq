import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class khg
  extends FriendListObserver
{
  public khg(AccountManageActivity paramAccountManageActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  void a(String paramString, int paramInt)
  {
    this.a.runOnUiThread(new khh(this, paramString, paramInt));
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    Object localObject2 = (SubAccountManager)this.a.app.getManager(60);
    Object localObject1 = "";
    int i = ((SubAccountManager)localObject2).a();
    if (i == 0)
    {
      label44:
      AccountManageActivity.a(this.a).setRightText((CharSequence)localObject1);
      if (AppSetting.j) {
        AccountManageActivity.a(this.a).setContentDescription("关联QQ号" + (String)localObject1);
      }
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        break label435;
      }
      i = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      label112:
      if (j >= this.a.jdField_a_of_type_JavaUtilList.size()) {
        break label439;
      }
      if ((i > j) && (this.a.jdField_a_of_type_JavaUtilList.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(j)).getUin())))
      {
        localObject1 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131296829);
        localObject2 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131296830);
        ((TextView)localObject1).setText(ContactUtils.i(this.a.app, paramString));
        ((TextView)localObject2).setText(this.a.app.b(paramString));
        a(paramString, j);
      }
    }
    else if (i == 1)
    {
      SubAccountInfo localSubAccountInfo = ((SubAccountManager)localObject2).a("sub.uin.default");
      if (localSubAccountInfo == null) {
        break label441;
      }
      localObject2 = ContactUtils.c(this.a.app, localSubAccountInfo.subuin, false);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        if (!TextUtils.isEmpty(localSubAccountInfo.subname))
        {
          localObject1 = localObject2;
          if (((String)localObject2).equals(localSubAccountInfo.subname)) {}
        }
        else
        {
          localSubAccountInfo.subname = ((String)localObject2);
          AccountManageActivity.a(this.a).setRightText((CharSequence)localObject2);
          localObject1 = localObject2;
          if (AppSetting.j) {
            AccountManageActivity.a(this.a).setContentDescription("关联QQ号" + (String)localObject2);
          }
        }
      }
    }
    label435:
    label439:
    label441:
    for (localObject1 = localObject2;; localObject1 = "")
    {
      break label44;
      localObject1 = i + "个";
      break label44;
      j += 1;
      break label112;
      i = 0;
      break label112;
      break;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    for (;;)
    {
      return;
      int i;
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        i = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      }
      while (j < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        if ((i > j) && (this.a.jdField_a_of_type_JavaUtilList.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(j)).getUin())))
        {
          a(paramString, j);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\khg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */