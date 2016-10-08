package com.tencent.mobileqq.activity.recent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import cooperation.qlink.QQProxyForQlink;
import java.util.ArrayList;
import java.util.List;
import oxs;

public class RecentOptPopBar
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 8;
  public static final String a = "CHARGE_REDTOUCH";
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131370424, 2131370429, 2131370426, 2131370432, 2131370433 };
  public static final String b = "KEY_CHARGE_REDTOUCH";
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130838405, 2130838400, 2130838406, 2130838380, 2130838403 };
  public static final String c = "KEY_PLUS_REDTOUCH";
  private static final int[] c = { 2131362049, 2131362053, 2131362052, 2131362056, 2131362057 };
  private static final String d = "RecentOptPopBar";
  private static final String e = "SP_CHARGE_REDTOUCH";
  public BaseActivity a;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RecentOptPopBar(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfInt.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = i;
      localMenuItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(jdField_a_of_type_ArrayOfInt[i]);
      localMenuItem.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(c[i]);
      localMenuItem.jdField_b_of_type_Int = jdField_b_of_type_ArrayOfInt[i];
      localArrayList.add(localMenuItem);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList, new oxs(this));
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, JumpActivity.class);
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=" + paramInt + "&entry=2"));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, -1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8005ED3", "0X8005ED3", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) {
      a();
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(paramView, paramInt1, paramInt2);
    if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch == null)
    {
      paramView = (LinearLayout)this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getContentView().findViewById(2131297013);
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 < paramView.getChildCount()) {
        try
        {
          Object localObject = paramView.getChildAt(paramInt1);
          if (((PopupMenuDialog.MenuItem)((View)localObject).getTag()).jdField_a_of_type_Int == 1)
          {
            localObject = (TextView)((View)localObject).findViewById(2131301929);
            this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject).a(21).a();
          }
          else if (((PopupMenuDialog.MenuItem)((View)localObject).getTag()).jdField_a_of_type_Int == 4)
          {
            localObject = ((View)localObject).findViewById(2131301928);
            this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (View)localObject).a(53).a();
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
      {
        paramView = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(35)).a("101210.101211");
        this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(paramView);
      }
      if (a("KEY_CHARGE_REDTOUCH"))
      {
        paramView = new BusinessInfoCheckUpdate.RedTypeInfo();
        paramView.red_type.set(0);
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(paramView);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(new BusinessInfoCheckUpdate.AppInfo());
      return;
      paramInt1 += 1;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("SP_CHARGE_REDTOUCH" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().a(), 0).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) && (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.isShowing());
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("SP_CHARGE_REDTOUCH" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().a(), 0).getBoolean(paramString, true);
  }
  
  public void b()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
    }
  }
  
  public void c()
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ScannerActivity.class);
    localIntent.putExtra("from", "Conversation");
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367975));
    localIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367975));
    localIntent.setFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004077", "0X8004077", 0, 0, "", "", "", "");
  }
  
  protected void d()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004075", "0X8004075", 0, 0, "", "", "", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.d()) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().g() != 3))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131363475, 1).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131492908));
      return;
    }
    g();
  }
  
  public void e()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddContactsActivity.class);
    localIntent.putExtra("EntranceId", 4);
    localIntent.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367975));
    localIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367975));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004839", "0X8004839", 0, 0, "", "", "", "");
    try
    {
      ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(35)).b(String.valueOf("101210.101211"));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void f()
  {
    QQProxyForQlink.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 8, null);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X80053AD", "0X80053AD", 0, 0, "", "", "", "");
  }
  
  protected void g()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1003);
    localIntent.putExtra("param_title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370425));
    localIntent.putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131369290));
    localIntent.putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370215));
    localIntent.putExtra("param_entrance", 10);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_exit_animation", 1);
    localIntent.putExtra("param_back_button_side", 0);
    localIntent.setFlags(603979776);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1400);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130968590, 2130968591);
  }
  
  public void h()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1003);
    localIntent.putExtra("param_title", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370424));
    localIntent.putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370179));
    localIntent.putExtra("param_done_button_highlight_wording", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131370180));
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("multi_chat", true);
    localIntent.putExtra("param_exit_animation", 0);
    localIntent.putExtra("param_back_button_side", 0);
    localIntent.setFlags(603979776);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1300);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(2130968592, 2130968593);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, "CliOper", "", "", "0X8004074", "0X8004074", 0, 0, "", "", "", "");
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog != null) {
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.a();
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentOptPopBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */