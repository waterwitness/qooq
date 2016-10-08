import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class omz
  extends VasExtensionObserver
{
  public omz(AvatarPendantActivity paramAvatarPendantActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    Object localObject2 = (Bundle)paramObject;
    long l = ((Bundle)localObject2).getLong("pendantId");
    ((Bundle)localObject2).getInt("seriesId");
    String str = ((Bundle)localObject2).getString("uin");
    paramObject = this.a.jdField_a_of_type_AndroidWidgetButton.getCompoundDrawables()[0];
    if ((paramObject instanceof Animatable))
    {
      ((Animatable)paramObject).stop();
      this.a.jdField_a_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    if ((l == -1L) || (str == null)) {}
    do
    {
      return;
      if (!paramBoolean) {
        break label556;
      }
      localObject2 = (FriendsManager)this.a.app.getManager(50);
      localObject1 = ((FriendsManager)localObject2).a(str);
      paramObject = localObject1;
      if (localObject1 == null)
      {
        paramObject = new ExtensionInfo();
        ((ExtensionInfo)paramObject).uin = str;
      }
      ((ExtensionInfo)paramObject).pendantId = l;
      ((ExtensionInfo)paramObject).timestamp = System.currentTimeMillis();
      ((FriendsManager)localObject2).a((ExtensionInfo)paramObject);
      i = this.a.jdField_a_of_type_AndroidWidgetButton.getPaddingBottom();
      j = this.a.jdField_a_of_type_AndroidWidgetButton.getPaddingTop();
      int k = this.a.jdField_a_of_type_AndroidWidgetButton.getPaddingRight();
      int m = this.a.jdField_a_of_type_AndroidWidgetButton.getPaddingLeft();
      if (l != 0L) {
        break;
      }
      this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.a.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.a.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.c = -1;
      }
      this.a.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
      this.a.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130841836);
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(2131368794);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005FD4", "0X8005FD4", 0, 0, "", "", "", "");
      this.a.jdField_a_of_type_AndroidWidgetButton.setPadding(m, j, k, i);
    } while (this.a.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter == null);
    paramObject = ((AvatarPendantManager)this.a.app.getManager(45)).a();
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)paramObject);
    return;
    this.a.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1711276033);
    this.a.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130841837);
    this.a.jdField_a_of_type_AndroidWidgetButton.setText(2131368797);
    this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.a.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    Object localObject1 = this.a.app;
    if (this.a.d) {}
    for (paramObject = "1";; paramObject = "0")
    {
      ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8005FD6", "0X8005FD6", 0, 0, (String)paramObject, "", "", "");
      if (!this.a.d) {
        break;
      }
      this.a.d = false;
      break;
    }
    label556:
    this.a.jdField_a_of_type_AndroidWidgetButton.setText(2131368794);
    int j = ((Bundle)localObject2).getInt("result");
    int i = -1;
    str = "LTMCLUB";
    localObject1 = "QQ会员";
    paramBoolean = NetworkUtil.e(this.a);
    if (paramBoolean)
    {
      paramObject = "4";
      switch (j)
      {
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        localObject2 = this.a;
        DialogUtil.a(this.a, 230).setTitle(((Context)localObject2).getString(2131367535)).setMessage(((Context)localObject2).getString(i)).setPositiveButton(((Context)localObject2).getString(2131371029), new onb(this, str, (String)localObject1)).setNegativeButton(((Context)localObject2).getString(2131367262), new ona(this)).show();
      }
      if (l == 0L) {
        break label990;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005FD7", "0X8005FD7", 0, 0, (String)paramObject, "", "", "");
      return;
      paramObject = "3";
      break;
      QQToast.a(this.a, 1, 2131371065, 0).b(this.a.getTitleBarHeight());
      continue;
      paramObject = "0";
      i = 2131371066;
      continue;
      paramObject = "1";
      i = 2131371067;
      str = "CJCLUBT";
      localObject1 = this.a.getString(2131371097);
      continue;
      paramObject = "2";
      Object localObject3 = ((Bundle)localObject2).getString("tips");
      localObject2 = ((Bundle)localObject2).getString("url");
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        QQToast.a(this.a, 1, 2131371068, 0).b(this.a.getTitleBarHeight());
      }
      else if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        QQToast.a(this.a, 1, (CharSequence)localObject3, 0).b(this.a.getTitleBarHeight());
      }
      else
      {
        localObject3 = new Intent(this.a, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", (String)localObject2);
        ((Intent)localObject3).putExtra("hide_more_button", true);
        ((Intent)localObject3).putExtra("webStyle", "noBottomBar");
        this.a.startActivity((Intent)localObject3);
      }
    }
    label990:
    localObject1 = this.a.app;
    if (paramBoolean) {}
    for (paramObject = "2";; paramObject = "1")
    {
      ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8006896", "0X8006896", 0, 0, (String)paramObject, "", "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\omz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */