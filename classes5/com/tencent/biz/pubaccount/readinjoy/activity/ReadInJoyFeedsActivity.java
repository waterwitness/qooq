package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.KanDianViewController;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.SubscriptionViewController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyChannelRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.LeftRedDotRadioButton;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import cooperation.readinjoy.ReadInJoyHelper;
import hwp;
import hwq;
import hwr;
import hws;
import hwt;
import hwu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import mqq.os.MqqHandler;

public class ReadInJoyFeedsActivity
  extends ReadInJoyBaseActivity
  implements View.OnClickListener, View.OnTouchListener, Observer
{
  public static final int b = 0;
  public static final String b = "readinjoy_show_tab";
  public static final int c = 1;
  public static final String c = "tab_tab_index";
  public static final int d = 9991;
  public static final String d = "from_search";
  public static final int e = 9992;
  public static final String e = "from_javascript";
  public static final int f = 9993;
  public static final String f = "launch_from";
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 4;
  public static final int l = 5;
  private long jdField_a_of_type_Long;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected ReadInJoyObserver a;
  private hwu jdField_a_of_type_Hwu;
  protected Map a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean;
  private ViewGroup c;
  private int m;
  private int n;
  
  public ReadInJoyFeedsActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new hws(this);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject2 = (KandianMergeManager)this.app.getManager(161);
    int i1;
    Object localObject3;
    ArrayList localArrayList;
    if (((KandianMergeManager)localObject2).d())
    {
      localObject1 = getString(2131370642);
      i1 = 2130839393;
      localObject3 = getString(2131371318);
      localArrayList = new ArrayList();
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = 0;
      localMenuItem.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localMenuItem.jdField_b_of_type_JavaLangString = localMenuItem.jdField_a_of_type_JavaLangString;
      localMenuItem.jdField_b_of_type_Int = i1;
      localArrayList.add(localMenuItem);
      localObject1 = new PopupMenuDialog.MenuItem();
      ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_Int = 1;
      ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
      ((PopupMenuDialog.MenuItem)localObject1).jdField_b_of_type_JavaLangString = ((PopupMenuDialog.MenuItem)localObject1).jdField_a_of_type_JavaLangString;
      ((PopupMenuDialog.MenuItem)localObject1).jdField_b_of_type_Int = 2130839392;
      localArrayList.add(localObject1);
      if (paramBoolean)
      {
        localObject3 = new PopupMenuDialog.MenuItem();
        ((PopupMenuDialog.MenuItem)localObject3).jdField_a_of_type_Int = 2;
        if (!ReadInJoyHelper.e(getAppRuntime())) {
          break label278;
        }
      }
    }
    label278:
    for (Object localObject1 = "关推荐原因";; localObject1 = "开推荐原因")
    {
      ((PopupMenuDialog.MenuItem)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject1);
      ((PopupMenuDialog.MenuItem)localObject3).jdField_b_of_type_Int = 2130842844;
      ((PopupMenuDialog.MenuItem)localObject3).jdField_b_of_type_JavaLangString = ((PopupMenuDialog.MenuItem)localObject3).jdField_a_of_type_JavaLangString;
      localArrayList.add(localObject3);
      localObject1 = PopupMenuDialog.a(this, localArrayList, new hwr(this, (KandianMergeManager)localObject2));
      localObject2 = this.jdField_b_of_type_AndroidViewViewGroup;
      ((PopupMenuDialog)localObject1).showAsDropDown((View)localObject2, ((View)localObject2).getWidth() - getResources().getDimensionPixelSize(2131493351) - getResources().getDimensionPixelSize(2131493355), getResources().getDimensionPixelSize(2131493370));
      return;
      localObject1 = getString(2131362995);
      i1 = 2130839394;
      break;
    }
  }
  
  public static void b()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.a, ReadInJoyFeedsActivity.class);
    BaseApplicationImpl.a.startActivity(localIntent);
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299936));
    ViewStub localViewStub = (ViewStub)findViewById(2131299933);
    localViewStub.inflate();
    localViewStub.setVisibility(0);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131299962));
    int i1 = getIntent().getIntExtra("readinjoy_show_tab", -1);
    int i2 = getIntent().getIntExtra("tab_tab_index", 0);
    if (i1 >= 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(0);
      this.n = i2;
      c(i2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setOnClickListener(this);
      this.d.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838587);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("设置");
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRadioGroup.setVisibility(8);
      d();
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_c_of_type_AndroidViewViewGroup.removeAllViews();
    ReadInJoyBaseViewController localReadInJoyBaseViewController;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setSelected(true);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(false);
      d(0);
      ReadInJoyLogicEngine.a().i();
      localObject = (ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        localObject = new KanDianViewController(this);
        ((ReadInJoyBaseViewController)localObject).a(this.jdField_c_of_type_AndroidViewViewGroup);
        ((ReadInJoyBaseViewController)localObject).a();
        localReadInJoyBaseViewController = (ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1));
        if (localReadInJoyBaseViewController != null) {
          localReadInJoyBaseViewController.c();
        }
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        return;
        ((ReadInJoyBaseViewController)localObject).b();
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setSelected(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setSelected(true);
    e(0);
    ReadInJoyLogicEngine.a().h();
    Object localObject = (ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new SubscriptionViewController(this);
      ((ReadInJoyBaseViewController)localObject).a(this.jdField_c_of_type_AndroidViewViewGroup);
      ((ReadInJoyBaseViewController)localObject).a();
    }
    for (;;)
    {
      localReadInJoyBaseViewController = (ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(0));
      if (localReadInJoyBaseViewController != null) {
        localReadInJoyBaseViewController.c();
      }
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
      return;
      ((ReadInJoyBaseViewController)localObject).b();
    }
  }
  
  private void d()
  {
    KanDianViewController localKanDianViewController = new KanDianViewController(this);
    localKanDianViewController.a(this.jdField_c_of_type_AndroidViewViewGroup);
    localKanDianViewController.a();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.n), localKanDianViewController);
  }
  
  private void d(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a(false);
  }
  
  private void e(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(false);
  }
  
  public int a()
  {
    return this.n;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      ThreadManager.a(new hwp(this), 5, null, true);
    }
  }
  
  public void b(int paramInt)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    if ((2 == this.m) || (3 == this.m) || (4 == this.m) || (this.jdField_a_of_type_Boolean)) {
      localBoolean = Boolean.valueOf(false);
    }
    if (localBoolean.booleanValue()) {
      this.jdField_a_of_type_AndroidWidgetTextView.post(new hwq(this, paramInt));
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 9992) && (paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false)))
    {
      finish();
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    VideoVolumeControl.a().a(this);
    if (ReadInJoyChannelRecommendManager.a().a()) {
      ReadInJoyChannelRecommendManager.a().a(this.app);
    }
    for (;;)
    {
      if (getIntent().getIntExtra("tab_tab_index", 0) == 0) {
        PublicTracker.a(null, "KANDIAN_FEEDS_COST");
      }
      super.doOnCreate(paramBundle);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramBundle = getIntent();
      Bundle localBundle = paramBundle.getExtras();
      if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
        ((KandianMergeManager)this.app.getManager(161)).d();
      }
      this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("from_search", false);
      this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("from_javascript", false);
      this.m = paramBundle.getIntExtra("launch_from", 5);
      ReadInJoyLogicEngineEventDispatcher.a().a();
      if (Build.VERSION.SDK_INT >= 11) {
        getWindow().setFlags(16777216, 16777216);
      }
      if (Build.VERSION.SDK_INT >= 19) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new hwt(this), 1000L);
      }
      setContentView(2130903751);
      getWindow().setBackgroundDrawable(null);
      ((ReadInJoyLogicManager)this.app.getManager(162)).a();
      ReadInJoyLogicEngine.a().j();
      ReadInJoyLogicEngine.a().e();
      setTitle(PublicAccountConfigUtil.b(this.app, this.app.a()));
      c();
      this.jdField_b_of_type_AndroidViewViewGroup.setOnTouchListener(this);
      this.jdField_a_of_type_Hwu = new hwu((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.n)));
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, this.jdField_a_of_type_Hwu);
      if (this.app.a() != null) {
        this.app.a().addObserver(this);
      }
      if (ReadInJoyHelper.a(this.app)) {
        TroopBarAssistantManager.a().d(this.app);
      }
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      ReadInJoyHelper.a(this.app);
      return true;
      ReadInJoyChannelRecommendManager.a().a();
    }
  }
  
  protected void doOnDestroy()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.doOnDestroy();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    long l1 = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (l1 > 0L) {
      ReportController.b(null, "CliOper", "", "", "0X80066F7", "0X80066F7", 0, 0, Long.toString(l1 / 1000L), "", "", ReadInJoyUtils.c());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).d();
    }
    if (this.app.a() != null) {
      this.app.a().deleteObserver(this);
    }
    ((ReadInJoyLogicManager)this.app.getManager(162)).b();
    ReadInJoyLogicEngine.a().k();
    VideoVolumeControl.a().b(this);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).g();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).h();
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).e();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).f();
    }
  }
  
  public void finish()
  {
    super.finish();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(localInteger)).i();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297392: 
      if (ReadInJoyHelper.a(this.app))
      {
        a(false);
        ReportController.b(null, "CliOper", "", "", "0X800705A", "0X800705A", 0, 0, "", "", "", ReadInJoyUtils.c());
        return;
      }
      startActivityForResult(new Intent(this, ReadInJoyAccountDetailActivity.class), 9992);
      return;
    case 2131299938: 
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.a()) {
        ReportController.b(null, "CliOper", "", "", "0X80067D0", "0X80067D0", 0, 0, "", "", "", ReadInJoyUtils.c());
      }
      while (this.n == 0)
      {
        ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.n))).a(true);
        return;
        ReportController.b(null, "CliOper", "", "", "0X80067CF", "0X80067CF", 0, 0, "", "", "", ReadInJoyUtils.c());
      }
      this.n = 0;
      c(this.n);
      ((KandianMergeManager)this.app.getManager(161)).a(0);
      return;
    }
    PublicTracker.a(null, "KANDIAN_TO_SUBSCRIPT_COST");
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a()) {
      ReportController.b(null, "CliOper", "", "", "0X80067D2", "0X80067D2", 0, 0, "", "", "", ReadInJoyUtils.c());
    }
    while (this.n == 1)
    {
      ((ReadInJoyBaseViewController)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.n))).a(true);
      return;
      ReportController.b(null, "CliOper", "", "", "0X80067D1", "0X80067D1", 0, 0, "", "", "", ReadInJoyUtils.c());
    }
    this.n = 1;
    c(this.n);
    ((KandianMergeManager)this.app.getManager(161)).a(1);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && ((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      a();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\activity\ReadInJoyFeedsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */