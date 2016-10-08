package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.adapter.TroopMessageSettingSingleAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticTroopAssist;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.ForwardImageProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mpe;
import mpf;
import mpg;
import mph;
import mpj;
import mpk;
import mpm;
import mpn;
import mpo;
import mpp;
import mpq;
import mpr;
import mps;
import mpt;
import mpu;
import mpy;
import mqq.os.MqqHandler;

public class TroopAssistantActivity
  extends IphoneTitleBarActivity
  implements OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, Observer
{
  public static final int a = 1;
  protected static final String a = "TroopAssistantActivity";
  public static final int b = 2;
  public static final String b = "normal";
  protected static final int c = 2;
  public static final String c = "batch_setting";
  public long a;
  protected View a;
  protected Button a;
  private AVObserver jdField_a_of_type_ComTencentAvGaudioAVObserver;
  public RecentAdapter a;
  public DragFrameLayout a;
  public TroopMessageSettingSingleAdapter a;
  protected FriendListObserver a;
  protected MessageObserver a;
  protected TroopObserver a;
  protected TransProcessorHandler a;
  public RoamSettingController a;
  public QQProgressNotifier a;
  protected PopupMenuDialog a;
  public XListView a;
  public List a;
  public MqqHandler a;
  boolean jdField_a_of_type_Boolean;
  protected View b;
  public Button b;
  XListView b;
  protected boolean b;
  protected View c;
  public boolean c;
  protected View d;
  public String d;
  public boolean d;
  protected boolean e;
  
  public TroopAssistantActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Boolean = true;
    this.e = true;
    this.jdField_a_of_type_ComTencentAvGaudioAVObserver = new mpr(this);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new mps(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new mpt(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new mpu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new mpy(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new mpj(this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Resources localResources = getResources();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(localResources.getString(2131369944, new Object[] { paramString2 }));
    localActionSheet.a(localResources.getString(2131364688), false);
    localActionSheet.a(localResources.getString(2131364689), false);
    localActionSheet.a(localResources.getString(2131364690), false);
    localActionSheet.a(localResources.getString(2131364691), false);
    int i = this.app.b(String.valueOf(paramString1));
    switch (i)
    {
    }
    for (;;)
    {
      localActionSheet.d(2131367262);
      localActionSheet.a(new mpn(this, i, paramString1, localActionSheet));
      localActionSheet.show();
      return;
      localActionSheet.e(0);
      continue;
      localActionSheet.e(1);
      continue;
      localActionSheet.e(2);
      continue;
      localActionSheet.e(3);
    }
  }
  
  private boolean a()
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      if (localView != null)
      {
        localView = localView.findViewById(2131298785);
        if ((localView != null) && (localView.getVisibility() == 0))
        {
          this.jdField_b_of_type_Boolean = false;
          return this.jdField_b_of_type_Boolean;
        }
      }
      i += 1;
    }
    this.jdField_b_of_type_Boolean = true;
    return this.jdField_b_of_type_Boolean;
  }
  
  private void g()
  {
    if (TroopAssistantManager.a().d(this.app))
    {
      i();
      ReportController.b(this.app, "dc00899", "Grp_msg", "", "helper-guide", "exp_guide", 0, 0, "", "", "", "");
      return;
    }
    h();
  }
  
  private void h()
  {
    this.jdField_d_of_type_JavaLangString = "normal";
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298606));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131305124);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView = View.inflate(this, 2130905050, null);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131305133);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_b_of_type_AndroidViewView);
    View localView = View.inflate(this, 2130903202, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.b(localView);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this, 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(4);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    j();
  }
  
  private void i()
  {
    this.jdField_d_of_type_JavaLangString = "batch_setting";
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298606));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131305124);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = ((DisplayMetrics)localObject).heightPixels;
    int j = AIOUtils.a(154.0F, getBaseContext().getResources());
    int k = getTitleBarHeight();
    int m = ImmersiveUtils.a(getBaseContext());
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131305125));
    this.jdField_b_of_type_ComTencentWidgetXListView.setMaxHeight(i - j - k - m);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131305129);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131305133);
    localObject = (TextView)this.jdField_c_of_type_AndroidViewView;
    ((TextView)localObject).setText(2131369394);
    ((TextView)localObject).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131305126));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131305127));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new mpe(this));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new mpo(this));
    this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingSingleAdapter = new TroopMessageSettingSingleAdapter(this, this.app, null);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingSingleAdapter);
    localObject = TroopAssistantManager.a();
    ((TroopAssistantManager)localObject).a(this.app, new mpp(this, (TroopAssistantManager)localObject));
    j();
  }
  
  private void j()
  {
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131305132);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new mpq(this));
  }
  
  private void k()
  {
    h();
    this.rightViewImg.setVisibility(0);
    e();
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { BuddyTransfileProcessor.class, C2CPicUploadProcessor.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class, ForwardImageProcessor.class });
    this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  private void m()
  {
    setTitle(2131369946);
    ImageView localImageView = this.rightViewImg;
    localImageView.setImageResource(2130838587);
    localImageView.setContentDescription(getString(2131370645));
    localImageView.setOnClickListener(new mpf(this));
    d();
    if ("batch_setting".equals(this.jdField_d_of_type_JavaLangString))
    {
      localImageView.setVisibility(8);
      return;
    }
    localImageView.setVisibility(0);
  }
  
  private void n()
  {
    this.jdField_d_of_type_Boolean = TroopAssistantManager.a().b();
    Object localObject;
    if (this.jdField_d_of_type_Boolean) {
      localObject = getString(2131370642);
    }
    for (int i = 2130839393;; i = 2130839394)
    {
      String str = getString(2131370643);
      ArrayList localArrayList = new ArrayList();
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = 0;
      localMenuItem.jdField_a_of_type_JavaLangString = ((String)localObject);
      localMenuItem.jdField_b_of_type_JavaLangString = localMenuItem.jdField_a_of_type_JavaLangString;
      localMenuItem.jdField_b_of_type_Int = i;
      localArrayList.add(localMenuItem);
      localObject = new PopupMenuDialog.MenuItem();
      ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_Int = 1;
      ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangString = str;
      ((PopupMenuDialog.MenuItem)localObject).jdField_b_of_type_JavaLangString = ((PopupMenuDialog.MenuItem)localObject).jdField_a_of_type_JavaLangString;
      ((PopupMenuDialog.MenuItem)localObject).jdField_b_of_type_Int = 2130839392;
      localArrayList.add(localObject);
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this, localArrayList, new mpg(this));
      localObject = super.getTitleBarView();
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown((View)localObject, ((View)localObject).getWidth() - getResources().getDimensionPixelSize(2131493351) - getResources().getDimensionPixelSize(2131493355), getResources().getDimensionPixelSize(2131493356));
      return;
      localObject = getString(2131370641);
    }
  }
  
  public List a()
  {
    List localList = TroopAssistantManager.a().b(this.app);
    int i;
    ArrayList localArrayList;
    int j;
    label31:
    Object localObject;
    if (localList == null)
    {
      i = 0;
      localArrayList = new ArrayList(i);
      j = 0;
      if (j >= i) {
        return localArrayList;
      }
      localObject = (TroopAssistantData)localList.get(j);
      if (localObject != null) {
        break label74;
      }
    }
    for (;;)
    {
      j += 1;
      break label31;
      i = localList.size();
      break;
      label74:
      localObject = new RecentTroopAssistantItem((TroopAssistantData)localObject);
      ((RecentTroopAssistantItem)localObject).a(this.app, BaseApplication.getContext());
      if (QLog.isDevelopLevel())
      {
        long l = System.currentTimeMillis();
        QLog.i("Q.recent.cost", 4, "[" + (l - 0L) + ", " + ((RecentTroopAssistantItem)localObject).a() + "," + localObject.getClass().getName() + "]");
        ((RecentTroopAssistantItem)localObject).a();
      }
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  protected void a()
  {
    for (;;)
    {
      try
      {
        localObject = ((RedTouchManager)this.app.getManager(35)).a("100300");
        if (localObject == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopAssistantFeedsJsHandler", 2, "updateTroopFeedsRedDotInfo, appInfo !=null, iNewFlag=" + ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() + " type=" + ((BusinessInfoCheckUpdate.AppInfo)localObject).type.get());
        }
        if ((localObject == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0)) {
          continue;
        }
        if (((BusinessInfoCheckUpdate.AppInfo)localObject).type.get() == -1) {
          continue;
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
      catch (Exception localException)
      {
        Object localObject;
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        continue;
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        continue;
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        continue;
        String str = "0";
        continue;
      }
      if (this.e)
      {
        if (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) {
          continue;
        }
        localObject = "2";
        ReportController.b(this.app, "P_CliOper", "Grp_dynamic", "", "helper", "exp", 0, 0, "", (String)localObject, "", "");
        if (QLog.isColorLevel()) {
          QLog.d("TroopAssistantFeedsJsHandler", 2, "updateTroopFeedsRedDotInfo, ReportController.reportClickEvent, hasRedDot=" + (String)localObject);
        }
        this.e = false;
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "updateTroopFeedsRedDotInfo, appInfo==null");
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    if (paramRecentBaseData.b() > 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    a(paramRecentBaseData.a(), paramRecentBaseData.a(), paramString);
  }
  
  public void a(View paramView, Object paramObject)
  {
    if (paramView == null) {}
    int i;
    do
    {
      return;
      i = paramView.getId();
      if (i == 2131305124)
      {
        this.jdField_c_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(4);
          f();
          this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
        }
        paramView = new Intent(this, TroopAssisSettingActivity.class);
        paramView.setFlags(67108864);
        startActivity(paramView);
        if (TroopAssistantManager.a().c()) {
          TroopAssistantManager.a().f(this.app);
        }
        ReportController.b(this.app, "P_CliOper", "Grp_msg", "", "help_nav", "Clk_set", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 2131305134);
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(4);
      f();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
      e();
    }
    TroopAssistantManager.a().f(this.app);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    a(paramRecentBaseData.a());
  }
  
  void a(String paramString)
  {
    TroopAssistantManager.a().b(paramString, this.app);
    e();
    RecentUtil.b(this.app, paramString, 1);
    this.app.a().c(paramString, 1);
    paramString = this.app.a(Conversation.class);
    if (paramString != null) {
      paramString.sendEmptyMessage(1014);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    TroopAssistantManager.a().a(this.app, paramString, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.put(paramString, Boolean.valueOf(true));
  }
  
  void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    if (paramInt == 1)
    {
      paramString1 = ((TroopManager)this.app.getManager(51)).a(paramString1);
      if ((paramString1 != null) && (paramString1.troopcode != null)) {
        localIntent.putExtra("troop_uin", paramString1.troopcode);
      }
    }
    for (;;)
    {
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString2);
      startActivity(localIntent);
      return;
      if (paramInt == 0)
      {
        paramString1 = ((FriendsManager)this.app.getManager(50)).c(paramString1 + "");
        if (paramString1 != null)
        {
          localIntent.putExtra("cSpecialFlag", paramString1.cSpecialFlag);
          if (paramString1.cSpecialFlag == 1)
          {
            localIntent.setClass(this, ChatActivity.class);
            localIntent.putExtra("chat_subType", 1);
          }
        }
      }
      else if (paramInt != 3000) {}
    }
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    paramString2 = getResources();
    if ((paramRecentBaseData.a() == 1) && (Utils.a(paramString2.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[1]), paramString1))) {
      a(paramRecentBaseData.a(), paramRecentBaseData.b());
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X800419E", "0X800419E", 0, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
  }
  
  public void b()
  {
    ((RedTouchManager)this.app.getManager(35)).b("100300");
    if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0) {}
    for (String str = "1";; str = "0")
    {
      ReportController.b(this.app, "P_CliOper", "Grp_dynamic", "", "helper", "Clk", 0, 0, "", str, "", "");
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "doRedDotClickReport, ReportController.reportClickEvent, hasRedDot=" + str);
      }
      return;
    }
  }
  
  public void c()
  {
    if (TroopAssistantManager.a().a(this.app) == true) {
      TroopAssistantManager.a().a(this.app.a().createEntityManager(), this.app);
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.a(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.app.a().addObserver(this);
    this.app.a().addObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.app);
    }
  }
  
  public void d()
  {
    if (this.leftView != null)
    {
      QQMessageFacade localQQMessageFacade = this.app.a();
      if (localQQMessageFacade != null) {
        ThreadManager.a(new mph(this, localQQMessageFacade), 8, null, true);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    super.setContentView(2130905048);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    g();
    m();
    c();
    l();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app == null) {
      return;
    }
    this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.app.a().deleteObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.app.a() != null) {
      this.app.a().deleteObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.getItem(0);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        localObject = this.app.a().a(((RecentBaseData)localObject).a(), ((RecentBaseData)localObject).a());
        if (localObject != null)
        {
          TroopAssistantManager.a().a(this.app, ((QQMessageFacade.Message)localObject).time);
          localObject = this.app.a(Conversation.class);
          if (localObject != null) {
            ((MqqHandler)localObject).sendEmptyMessage(1009);
          }
        }
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    e();
    a();
  }
  
  public void e()
  {
    ThreadManager.a(new mpk(this), 8, null, true);
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_c_of_type_AndroidViewView != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b()) {
        break label41;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    label41:
    while (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  protected boolean onBackEvent()
  {
    if (!this.jdField_a_of_type_Boolean) {
      StatisticTroopAssist.g(this, this.app.a());
    }
    for (;;)
    {
      return super.onBackEvent();
      a();
      if (this.jdField_b_of_type_Boolean) {
        StatisticTroopAssist.e(this, this.app.a());
      } else {
        StatisticTroopAssist.f(this, this.app.a());
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!paramObservable.isSendFromLocal()) {
        runOnUiThread(new mpm(this));
      }
      if ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == 63534)) {
        return;
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\TroopAssistantActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */