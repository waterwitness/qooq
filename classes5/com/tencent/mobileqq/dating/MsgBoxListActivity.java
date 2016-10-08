package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.ChatPushCarrierHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import rfs;
import rfw;
import rga;
import rgb;
import rgc;

public class MsgBoxListActivity
  extends BaseMsgBoxActivity
  implements View.OnClickListener, ActionSheet.OnButtonClickListener
{
  public static final String e = "sp_key_dating_config_time";
  Handler jdField_a_of_type_AndroidOsHandler;
  public LinearLayout a;
  RecentBaseData jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver;
  public CarrierHelper.EntranceConfig a;
  private CarrierHelper jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper;
  public ChatPushCarrierHelper a;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public View c;
  public View d;
  public boolean d;
  private View jdField_e_of_type_AndroidViewView;
  boolean jdField_e_of_type_Boolean;
  private View jdField_f_of_type_AndroidViewView;
  String jdField_f_of_type_JavaLangString;
  
  public MsgBoxListActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new rfs(this);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_e_of_type_Boolean = false;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramContext, MsgBoxListActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  private void b()
  {
    Object localObject;
    if ((this.jdField_c_of_type_Int == 1010) || (this.jdField_c_of_type_Int == 1001))
    {
      localObject = this.app;
      if (this.jdField_c_of_type_Int != 1010) {
        break label232;
      }
    }
    label232:
    for (int i = 2;; i = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper = new CarrierHelper((QQAppInterface)localObject, null, i);
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(this);
      this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(this);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
      if (this.jdField_e_of_type_AndroidViewView == null)
      {
        this.jdField_e_of_type_AndroidViewView = new View(this);
        localObject = new AbsListView.LayoutParams(-1, DisplayUtil.a(this, 20.0F));
        this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_e_of_type_AndroidViewView.setBackgroundColor(0);
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_f_of_type_AndroidViewView == null)
      {
        this.jdField_f_of_type_AndroidViewView = new View(this);
        localObject = new AbsListView.LayoutParams(-1, 1);
        this.jdField_f_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130843282);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
      ThreadManager.a(new rfw(this), 10, null, false);
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a())
    {
      if (this.jdField_e_of_type_AndroidViewView.getVisibility() != 0)
      {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_e_of_type_AndroidViewView);
      }
      if (this.jdField_f_of_type_AndroidViewView.getVisibility() != 0)
      {
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_f_of_type_AndroidViewView);
      }
    }
    do
    {
      return;
      if (this.jdField_e_of_type_AndroidViewView.getVisibility() != 8)
      {
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_e_of_type_AndroidViewView);
      }
    } while (this.jdField_f_of_type_AndroidViewView.getVisibility() == 8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFpsreportFPSSwipListView.a(this.jdField_f_of_type_AndroidViewView);
  }
  
  private void d()
  {
    if ((this.jdField_c_of_type_Int != 1010) && (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig != null) && (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.iconUrl)) && (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.wording)) && (!StringUtil.b(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl)))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.iconUrl, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.wording);
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.jdField_f_of_type_JavaLangString);
      this.app.a().d(false);
    }
  }
  
  protected List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    long l1 = System.currentTimeMillis();
    Iterator localIterator = paramList.iterator();
    long l2;
    while (localIterator.hasNext())
    {
      paramList = (MessageRecord)localIterator.next();
      String str = paramList.senderuin;
      l2 = System.currentTimeMillis();
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(str))
      {
        paramList = (RecentBaseData)this.jdField_a_of_type_JavaUtilMap.get(str);
        paramList.a(this.app, BaseApplication.getContext());
        localArrayList.add(paramList);
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.msg_box", 4, "item update time cost = " + (System.currentTimeMillis() - l2));
        }
      }
      else
      {
        if (paramList.senderuin.equals(this.d)) {}
        for (paramList = new RecentSayHelloBoxItem(paramList);; paramList = new RecentMsgBoxItem(paramList))
        {
          this.jdField_a_of_type_JavaUtilMap.put(str, paramList);
          break;
        }
      }
    }
    if (QLog.isDevelopLevel())
    {
      l2 = System.currentTimeMillis();
      QLog.d("Q.msg_box", 4, "makeRecetBaseData |start cost time:" + (l2 - l1));
    }
    return localArrayList;
  }
  
  public void a()
  {
    QQMessageFacade localQQMessageFacade = this.app.a();
    int i;
    if (localQQMessageFacade != null)
    {
      i = localQQMessageFacade.e();
      if (i <= 0) {
        break label117;
      }
      if (i > 99) {
        this.leftView.setText(getString(2131367566) + "(" + "99+" + ")");
      }
    }
    else
    {
      return;
    }
    this.leftView.setText(getString(2131367566) + "(" + i + ")");
    return;
    label117:
    setLeftViewName(getIntent().putExtra("leftViewText", getString(2131367566)));
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    if (Utils.a(paramString1, getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[6])))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData = paramRecentBaseData;
      this.jdField_f_of_type_JavaLangString = paramString2;
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getString(2131364479, new Object[] { getString(2131372199) }));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(2131372200, 3);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131367262);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  protected void b(List paramList)
  {
    Object localObject3 = null;
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    ConversationFacade localConversationFacade = this.app.a();
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    MessageRecord localMessageRecord;
    Object localObject4;
    int k;
    int j;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        if ((TextUtils.isEmpty(localMessageRecord.senderuin)) || (localMessageRecord.msgtype == 61525))
        {
          localIterator.remove();
        }
        else
        {
          if ((localMessageRecord.senderuin.equals(AppConstants.aO)) || (localMessageRecord.senderuin.equals(AppConstants.aP)))
          {
            this.jdField_c_of_type_Boolean = true;
            this.d = localMessageRecord.senderuin;
            localObject5 = localMessageRecord;
          }
          if (localMessageRecord.istroop == 7100) {
            localObject6 = localMessageRecord;
          }
          localObject4 = localObject1;
          if (localMessageRecord.istroop == 1001)
          {
            localObject4 = localObject1;
            if (!localMessageRecord.senderuin.equals(AppConstants.aO))
            {
              localObject4 = localObject1;
              if (!localMessageRecord.senderuin.equals(AppConstants.aP))
              {
                if (localConversationFacade == null) {
                  break label598;
                }
                k = localConversationFacade.e(localMessageRecord.senderuin, 1001);
                if (k != 0) {
                  break label589;
                }
                j = localConversationFacade.d(localMessageRecord.senderuin, 1001);
                if (j > 0) {
                  break label583;
                }
                i = localConversationFacade.a(localMessageRecord);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (k > 0)
      {
        localObject4 = localObject3;
        if (localObject3 == null) {
          localObject4 = new ArrayList();
        }
        ((List)localObject4).add(localMessageRecord);
        localIterator.remove();
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
      }
      for (;;)
      {
        localObject4 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break;
        if (j <= 0)
        {
          localObject4 = localObject1;
          if (i <= 0) {}
        }
        else
        {
          if (j > 0)
          {
            localObject4 = localObject2;
            if (localObject2 == null) {
              localObject4 = new ArrayList();
            }
            ((List)localObject4).add(localMessageRecord);
            localIterator.remove();
            localObject2 = localObject1;
            localObject1 = localObject3;
            localObject3 = localObject4;
            continue;
          }
          localObject4 = localObject1;
          if (i > 0)
          {
            localObject4 = localObject1;
            if (localObject1 == null) {
              localObject4 = new ArrayList();
            }
            ((List)localObject4).add(localMessageRecord);
            localIterator.remove();
          }
        }
        localObject1 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject4;
      }
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        paramList.addAll(0, (Collection)localObject1);
      }
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        paramList.addAll(0, (Collection)localObject2);
      }
      if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
        paramList.addAll(0, (Collection)localObject3);
      }
      if ((this.jdField_c_of_type_Boolean) && (localObject5 != null))
      {
        paramList.remove(localObject5);
        paramList.add(0, localObject5);
        if (localObject6 == null) {
          break;
        }
        paramList.remove(localObject6);
        paramList.add(1, localObject6);
        return;
      }
      if (localObject6 == null) {
        break;
      }
      paramList.remove(localObject6);
      paramList.add(0, localObject6);
      return;
      label583:
      i = 0;
      continue;
      label589:
      i = 0;
      j = 0;
      continue;
      label598:
      k = 0;
      i = 0;
      j = 0;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper = new ChatPushCarrierHelper(this);
    if (this.jdField_c_of_type_Int == 1010)
    {
      setTitle(2131371738);
      this.b.setVisibility(8);
    }
    for (;;)
    {
      this.b.setOnClickListener(this);
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver, true);
      b();
      return true;
      if (this.jdField_c_of_type_Int == 1001)
      {
        setTitle(2131368291);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130840844));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131367310));
        this.b.setVisibility(0);
      }
      else if (this.jdField_c_of_type_Int == 1009)
      {
        setTitle(2131368299);
        this.b.setVisibility(8);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
      ThreadManager.a(new rga(this), 5, null, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearpeopleNearbyRecommenderChatPushCarrierHelper.a();
    }
    NearbyProcessMonitor.c(1);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(1, Boolean.valueOf(false));
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper.a(1, Boolean.valueOf(true));
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_e_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidOsHandler == null)
      {
        rgc localrgc = new rgc(this.app.getAccount());
        this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(ThreadManager.a(), localrgc);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 2000L);
    }
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.a);
    localIntent.setFlags(67108864);
    startActivity(localIntent);
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    label71:
    label342:
    label358:
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig == null)
      {
        if (QLog.isColorLevel()) {
          NearbyUtils.a("ENTER_NEARBY", new Object[] { Long.valueOf(System.currentTimeMillis()) });
        }
        if (this.jdField_c_of_type_Int == 1010)
        {
          NearbyProcessMonitor.b(1);
          if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
            break label342;
          }
        }
      }
      for (paramView = "";; paramView = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString())
      {
        if (this.jdField_c_of_type_Int != 1010) {
          break label358;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005101", "0X8005101", 0, 0, "", "", paramView, "");
        return;
        if (this.jdField_c_of_type_Int != 1001) {
          break;
        }
        if (!NearbySPUtil.f(this.app.getAccount()))
        {
          paramView = new Intent(this, NearbyActivity.class);
          paramView.putExtra("FROM_WHERE", 1003);
          paramView.putExtra("ENTER_TIME", System.currentTimeMillis());
          NearbyFakeActivity.a(this, paramView);
          break;
        }
        paramView = new Intent(this, NearbyGuideActivity.class);
        paramView.putExtra("FROM_WHERE", 1003);
        paramView.putExtra("ENTER_TIME", System.currentTimeMillis());
        startActivity(paramView);
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl != null) && (this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl.startsWith("mqqapi")))
        {
          paramView = new Intent(this, JumpActivity.class);
          paramView.setAction("android.intent.action.VIEW");
          paramView.setData(Uri.parse(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl));
          startActivity(paramView);
          NearbyProcessMonitor.b(1);
          break label71;
        }
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper$EntranceConfig.jumpUrl);
        startActivity(paramView);
        break label71;
      }
    } while (this.jdField_c_of_type_Int != 1001);
    ReportController.b(this.app, "CliOper", "", "", "0X8005100", "0X8005100", 0, 0, "", "", paramView, "");
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    runOnUiThread(new rgb(this));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\MsgBoxListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */