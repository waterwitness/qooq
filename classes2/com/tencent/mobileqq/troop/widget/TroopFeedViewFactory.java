package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import java.util.HashMap;
import java.util.LinkedHashMap;
import vtq;
import vtr;
import vts;
import vtu;

public class TroopFeedViewFactory
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  long a;
  public Context a;
  public Drawable a;
  public SessionInfo a;
  public QQAppInterface a;
  public TroopFeedsDataManager a;
  protected TroopFeedsCenterLogic a;
  protected HashMap a;
  public Drawable b;
  public Drawable c;
  int d;
  
  public TroopFeedViewFactory(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, TroopFeedsDataManager paramTroopFeedsDataManager, TroopFeedsCenterLogic paramTroopFeedsCenterLogic)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Long = 0L;
    this.d = 1000;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = paramTroopFeedsDataManager;
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = paramTroopFeedsCenterLogic;
  }
  
  protected int a(int paramInt)
  {
    switch (paramInt)
    {
    }
    return 0;
  }
  
  public View a(TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2)) != null) {
      return null;
    }
    int i = a(paramTroopFeedItem.type);
    TroopFeedViewFactory.ViewProvider localViewProvider2 = (TroopFeedViewFactory.ViewProvider)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    TroopFeedViewFactory.ViewProvider localViewProvider1 = localViewProvider2;
    if (localViewProvider2 == null)
    {
      localViewProvider1 = a(i);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localViewProvider1);
    }
    if (localViewProvider1 != null) {
      return localViewProvider1.a(paramTroopFeedItem, paramInt, paramBoolean);
    }
    return null;
  }
  
  public View a(TroopAioTopADInfo paramTroopAioTopADInfo)
  {
    Object localObject = (TroopFeedViewFactory.ViewProvider)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2));
    if (localObject == null)
    {
      localObject = new vtq(this);
      ((vtq)localObject).a = paramTroopAioTopADInfo;
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), localObject);
    }
    for (paramTroopAioTopADInfo = (TroopAioTopADInfo)localObject;; paramTroopAioTopADInfo = (TroopAioTopADInfo)localObject)
    {
      if (paramTroopAioTopADInfo != null) {
        return paramTroopAioTopADInfo.a(null, 0, false);
      }
      return null;
    }
  }
  
  protected TroopFeedViewFactory.ViewProvider a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new vts(this);
    case 0: 
      return new vts(this);
    }
    return new vtu(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(2));
  }
  
  void a(TroopFeedItem paramTroopFeedItem, int paramInt)
  {
    if (paramTroopFeedItem == null) {
      return;
    }
    int i = paramTroopFeedItem.type;
    if (paramInt == 0) {}
    for (String str = "0";; str = "1") {
      switch (i)
      {
      default: 
        return;
      case 0: 
      case 131: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
        return;
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_bulletin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_know", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_music", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_photo", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_vote", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
    return;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_other", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, paramTroopFeedItem.ex_1, "");
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof vtr))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic.c(true);
      break label18;
    }
    label18:
    while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < this.d) {
      return;
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int i;
    if ((localTroopInfo != null) && (str != null)) {
      if (str.equals(localTroopInfo.troopowneruin)) {
        i = 0;
      }
    }
    for (;;)
    {
      localIntent.putExtra("url", String.format("http://web.qun.qq.com/qqweb/m/qun/notification/index.html?gc=%s&role=%d&_bid=2223&_wv=1031", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, Integer.valueOf(i) }));
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      paramView = paramView.getTag();
      if (!(paramView instanceof TroopFeedViewFactory.ViewHolder)) {
        break;
      }
      paramView = ((TroopFeedViewFactory.ViewHolder)paramView).a;
      if ((paramView == null) || (!paramView.isStoryType())) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_story_pgc", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
      return;
      if ((localTroopInfo.Administrator != null) && (localTroopInfo.Administrator.contains(str))) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\widget\TroopFeedViewFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */