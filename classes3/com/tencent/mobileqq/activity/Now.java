package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverActivity;
import com.tencent.biz.qqstory.storyHome.StoryRecordButtonAnimationView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.IMyStroyPresenter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.QQStoryPreTakeVideo;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;
import com.tencent.biz.qqstory.view.widget.FullScreenEmptyView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.List;
import lyi;
import lyj;
import lyk;
import lyl;
import lym;
import lyn;
import lyo;
import lyp;

public class Now
  extends Frame
  implements View.OnClickListener, View.OnLongClickListener, ViewStub.OnInflateListener, IMyStoryListView, IEventReceiver
{
  public static final int a = 1001;
  private static final String jdField_a_of_type_JavaLangString = "NowTab";
  public static final int b = 3000;
  public static final int c = 20001;
  protected long a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected StoryConfigManager a;
  public StoryRecordButtonAnimationView a;
  private IMyStroyPresenter jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter;
  private MystoryListView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView;
  private NeoVideoRecordButton jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton;
  private FullScreenEmptyView jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView;
  public AppInterface a;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private lyp jdField_a_of_type_Lyp;
  protected boolean a;
  protected long b;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  boolean jdField_b_of_type_Boolean;
  public boolean c;
  public boolean d;
  protected boolean e;
  
  public Now()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Boolean = false;
    this.e = true;
  }
  
  private boolean d()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_a_of_type_Long;
    if ((l2 > 0L) && (l2 < 2000L)) {
      return true;
    }
    this.jdField_a_of_type_Long = l1;
    return false;
  }
  
  private void k()
  {
    if (!NetworkUtil.h(a()))
    {
      SLog.d("NowTab", "updateTabIfNecessary,network is unable!");
      QQToast.a(BaseApplication.getContext(), 1, "当前网络不可用，请检查你的网络设置", 0).a();
    }
    do
    {
      int i;
      do
      {
        return;
        i = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("story_list_request_data_from_net_running_state", Integer.valueOf(1))).intValue();
        SLog.a("NowTab", "updateTabIfNecessary,updateStepState=%s", Integer.valueOf(i));
      } while (i == 0);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter == null)
      {
        SLog.d("NowTab", "updateTabIfNecessary,myStoryListPresenter = null!");
        return;
      }
      if ((i == 2) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter.b()))
      {
        SLog.b("NowTab", "updateTabIfNecessary,have red point or pre time have failed,run auto request");
        q();
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.b(false);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter.a();
        return;
      }
    } while (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter.c());
    SLog.b("NowTab", "updateTabIfNecessary,update over time,run auto request");
    q();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.b(false);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter.a();
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)a(2131297137));
    IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131296706));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(a().getColor(2131428295));
    IphoneTitleBarActivity.setLayerType((ViewGroup)a(2131297082));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131297139));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367563);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131302815));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, DisplayUtil.b(a(), 5.0F), 0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841482);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)a(2131302814));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton = ((NeoVideoRecordButton)a(2131302802));
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setOnLongClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView = ((StoryRecordButtonAnimationView)a(2131298352));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = ((MystoryListView)a(2131302801));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setmIsNow(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setDivider(null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setBackgroundDrawable(a().getDrawable(2130837958));
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView = new FullScreenEmptyView(a());
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView.setRetryClickListener(new lyk(this));
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setEmptyView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView);
  }
  
  private void o()
  {
    Looper.myQueue().addIdleHandler(new lyl(this));
    ((StoryConfigManager)SuperManager.a(10)).c();
  }
  
  private void p()
  {
    new Handler().postDelayed(new lym(this), 5000L);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    SLog.b("NowTab", "Now tab run onCreateView!");
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.inflate(2130904461, null));
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a();
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
    case 1001: 
    case 3000: 
      do
      {
        do
        {
          return;
        } while ((paramIntent == null) || (!paramIntent.hasExtra("forbidList")));
        paramIntent = paramIntent.getStringArrayListExtra("forbidList");
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter.a(paramIntent);
        return;
      } while ((paramIntent == null) || (!paramIntent.hasExtra(PublishParam.jdField_a_of_type_JavaLangString)));
      paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      ((StoryVideoUploadManager)SuperManager.a(3)).a(paramIntent.jdField_b_of_type_JavaLangString, paramIntent.c, paramIntent.d, paramIntent.e, paramIntent.f, paramIntent.g, paramIntent.jdField_a_of_type_Int, paramIntent.jdField_b_of_type_Int, paramIntent.jdField_a_of_type_Long);
      i();
      return;
    case 20001: 
      a(false, false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(MyStorys paramMyStorys, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setData(paramMyStorys, paramArrayList1, paramArrayList2, paramArrayList3, paramArrayList4, paramBoolean1, paramBoolean2);
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setOneSegmentData(paramString, paramObject);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramString1, paramString2);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView.setVisibility(0);
    if (!this.c) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView.a(paramList);
    }
    this.c = true;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView.setOnClickListener(new lyo(this));
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    SLog.a("NowTab", "Now tab run onResume! tabChange=", Boolean.valueOf(paramBoolean));
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.e();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.b();
    }
    k();
    if (!((QQStoryManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(180)).a("9999_HD", new lyi(this))) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(0);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    if ((!paramBoolean2) || (b()))
    {
      Intent localIntent = new Intent(super.a(), NewStoryTakeVideoActivity.class);
      localIntent.putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.NewShortVideoConfig.name(), null));
      localIntent.putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
      localIntent.putExtra("flow_camera_video_mode", true);
      localIntent.putExtra("auto_start", paramBoolean1);
      StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
      paramBoolean1 = ((Boolean)localStoryConfigManager.b("publish_picture", Boolean.valueOf(false))).booleanValue();
      boolean bool2 = ((Boolean)localStoryConfigManager.b("first_time_pic", Boolean.valueOf(false))).booleanValue();
      if ((paramBoolean1) && (!bool2))
      {
        paramBoolean1 = true;
        localIntent.putExtra("has_take_photo_ability", paramBoolean1);
        paramBoolean1 = bool1;
        if (!this.d)
        {
          if (!PtvFilterSoLoad.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext())) {
            break label245;
          }
          paramBoolean1 = bool1;
        }
        label183:
        localIntent.putExtra("flow_camera_use_filter_function", paramBoolean1);
        super.a(localIntent, 3000);
        if (!paramBoolean2) {
          break label250;
        }
        super.a().overridePendingTransition(2130968746, 2130968621);
      }
      for (;;)
      {
        new Handler().postDelayed(new lyn(this), 1000L);
        return;
        paramBoolean1 = false;
        break;
        label245:
        paramBoolean1 = false;
        break label183;
        label250:
        super.a().overridePendingTransition(0, 0);
      }
    }
    a(new Intent(super.a(), QQStoryPreTakeVideo.class), 20001);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter.a(NetConnInfoCenter.getServerTimeMillis());
    }
    r();
    if (this.e)
    {
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = this.jdField_b_of_type_Long;
      this.e = false;
      StoryReportor.b("home_page", "enter_time", 0, 0, new String[] { String.valueOf(l1 - l2) });
    }
    if (!paramBoolean3) {
      q();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramBoolean1, paramBoolean2);
  }
  
  public void b() {}
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramBoolean);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setLoadMoreCompleted(paramBoolean1, paramBoolean2);
  }
  
  public boolean b()
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (ShortVideoUtils.a());
    return false;
  }
  
  public void c()
  {
    SLog.b("NowTab", "fillData");
    o();
  }
  
  public void c(boolean paramBoolean) {}
  
  protected void d()
  {
    super.d();
    SLog.b("NowTab", "Now tab run onCreate!");
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager = ((StoryConfigManager)SuperManager.a(10));
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = a().getAppInterface();
    m();
    n();
    o();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.c();
    this.jdField_a_of_type_Lyp = new lyp(this);
    Dispatchers.get().registerSubscriber("", this.jdField_a_of_type_Lyp);
    SLog.b("NowTab", "onCreate");
    this.jdField_a_of_type_Boolean = true;
    p();
    ((PreloadDownloaderManager)SuperManager.a(6)).c();
  }
  
  public void e()
  {
    SLog.b("NowTab", "Now tab run onPause!");
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.f();
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView.getVisibility() != 8)) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView.setVisibility(8);
    }
  }
  
  protected void f()
  {
    super.f();
    SLog.b("NowTab", "Now tab run onDestroy!");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Lyp != null)
    {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Lyp);
      this.jdField_a_of_type_Lyp = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.h();
    }
    ((StoryConfigManager)SuperManager.a(10)).b("story_list_request_data_from_net_running_state", Integer.valueOf(1));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter.c();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    ((PreloadDownloaderManager)SuperManager.a(6)).a(10000L);
  }
  
  public void g_(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.setVisibility(8);
  }
  
  protected void i()
  {
    View localView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.findViewById(2131302905);
    if (localView == null) {
      return;
    }
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(100L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setAnimationListener(new lyj(this, localView));
    localView.startAnimation(localScaleAnimation);
  }
  
  public boolean isValidate()
  {
    return (this.jdField_a_of_type_Boolean) && (!a().isFinishing());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131302802: 
      do
      {
        return;
      } while (d());
      a(false, true);
      return;
    }
    StoryReportor.a("hall", "clk_entry", 0, 0, new String[0]);
    paramView = new Intent(a(), QQStoryDiscoverActivity.class);
    paramView.putExtra("key_from", 2);
    a().startActivityForResult(paramView, -1);
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    SLog.b("NowTab", "onInflate");
    c();
    if (!this.jdField_b_of_type_Boolean) {
      a(true);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return false;
      a(true, true);
    }
  }
  
  public void w()
  {
    SLog.b("NowTab", "Now tab run onStop!");
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.g();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\Now.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */