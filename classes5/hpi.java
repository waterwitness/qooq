import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.List;

public class hpi
  extends SwiftBrowserShareMenuHandler
{
  hpi(PublicAccountBrowser paramPublicAccountBrowser)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qq")) && ((this.jdField_a_of_type_Long & 0x8) == 0L))
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364561);
      ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838114;
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).v = 2;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:QZone")) && ((this.jdField_a_of_type_Long & 0x10) == 0L))
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364567);
      ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838115;
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).v = 3;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if (((this.jdField_a_of_type_Long & 0x8000000) != 0L) && (ReadInJoyHelper.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      localObject = "readinjoy_" + this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount() + "_" + 1;
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser.getSharedPreferences((String)localObject, 4);
      if ((localObject != null) && (((SharedPreferences)localObject).getBoolean("share_to_news", false)))
      {
        localObject = new PublicAccountBrowser.ActionSheetItem();
        ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364579);
        ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838113;
        ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
        ((PublicAccountBrowser.ActionSheetItem)localObject).v = 13;
        ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
        localArrayList.add(localObject);
      }
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:appMessage")) && ((this.jdField_a_of_type_Long & 0x4000) == 0L))
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364577);
      ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838116;
      ((PublicAccountBrowser.ActionSheetItem)localObject).v = 9;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:timeline")) && ((this.jdField_a_of_type_Long & 0x8000) == 0L))
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364578);
      ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130838112;
      ((PublicAccountBrowser.ActionSheetItem)localObject).v = 10;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithQQBrowser")) && ((this.jdField_a_of_type_Long & 0x200) == 0L))
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364566);
      ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130839507;
      ((PublicAccountBrowser.ActionSheetItem)localObject).v = 5;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:openWithSafari")) && ((this.jdField_a_of_type_Long & 0x100) == 0L))
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364565);
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130839505;
      ((PublicAccountBrowser.ActionSheetItem)localObject).v = 4;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getPackageManager();
    PublicAccountBrowser.ActionSheetItem localActionSheetItem;
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiDian")) && ((this.jdField_a_of_type_Long & 0x10) == 0L) && (new Intent().setPackage("com.tencent.qidian").setData(Uri.parse("qdapi://")).resolveActivity((PackageManager)localObject) != null))
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364580);
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.u = 2130840442;
      localActionSheetItem.v = 19;
      localActionSheetItem.b = "";
      localArrayList.add(localActionSheetItem);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:share:qiYeQQ")) && ((this.jdField_a_of_type_Long & 0x20) == 0L) && (new Intent().setPackage("com.tencent.eim").setData(Uri.parse("eimapi://")).resolveActivity((PackageManager)localObject) != null))
    {
      localObject = new PublicAccountBrowser.ActionSheetItem();
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364581);
      ((PublicAccountBrowser.ActionSheetItem)localObject).jdField_a_of_type_Boolean = true;
      ((PublicAccountBrowser.ActionSheetItem)localObject).u = 2130840443;
      ((PublicAccountBrowser.ActionSheetItem)localObject).v = 20;
      ((PublicAccountBrowser.ActionSheetItem)localObject).b = "";
      localArrayList.add(localObject);
    }
    localObject = new ArrayList();
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:favorite")) && ((this.jdField_a_of_type_Long & 0x2000) == 0L))
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364576);
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.u = 2130840304;
      localActionSheetItem.v = 6;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:setFont")) && (this.jdField_a_of_type_Boolean))
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364562);
      localActionSheetItem.u = 2130839506;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.v = 7;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:copyUrl")) && ((this.jdField_a_of_type_Long & 0x20) == 0L))
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364563);
      localActionSheetItem.u = 2130838111;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.v = 1;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if ((!TextUtils.isEmpty(this.l)) && ((this.jdField_a_of_type_Long & 0x40) == 0L))
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364570);
      localActionSheetItem.u = 2130839504;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.v = 8;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    if (!PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_JavaUtilArrayList, "menuItem:exposeArticle"))
    {
      localActionSheetItem = new PublicAccountBrowser.ActionSheetItem();
      localActionSheetItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131364564);
      localActionSheetItem.u = 2130839494;
      localActionSheetItem.jdField_a_of_type_Boolean = true;
      localActionSheetItem.v = 11;
      localActionSheetItem.b = "";
      ((ArrayList)localObject).add(localActionSheetItem);
    }
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof PublicAccountBrowser.ActionSheetItemViewHolder)) {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountBrowser", 2, "Item clicked but tag not found");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      int i = ((PublicAccountBrowser.ActionSheetItemViewHolder)localObject).a.v;
      if (i == 7)
      {
        super.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser.a(i);
        return;
      }
      if (i == 8)
      {
        PublicAccountBrowser.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser, this.l);
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser.a(i);
        return;
      }
      super.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      if ((i == 2) || (i == 3)) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null) {
          ReportController.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a(), "0X8004B5D", "0X8004B5D", 0, 0, "", "", "", "");
        }
      }
      while (this.i != 1008)
      {
        a(i);
        return;
        if ((i == 6) && (this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface != null)) {
          ReportController.b(null, "CliOper", "", this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser.jdField_a_of_type_ComTencentMobileqqAppBrowserAppInterface.a(), "0X8004B5E", "0X8004B5E", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */