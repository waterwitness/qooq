package com.tencent.biz.qqstory.storyHome;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.base.preload.storylist.FirstVideoManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.IMyStroyPresenter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.biz.qqstory.takevideo.QQStoryPreTakeVideo;
import com.tencent.biz.qqstory.takevideo.TakeVideoButtonMainPart;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.view.widget.FullScreenEmptyView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import iql;
import iqm;
import iqn;
import iqo;
import iqp;
import iqq;
import iqr;
import iqs;
import iqt;
import iqu;
import iqv;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QQStoryMainActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, View.OnLongClickListener, IMyStoryListView
{
  public static final int a = 20000;
  public static final String a = "Q.qqstory.home.QQStoryMainActivity";
  public static final int b = 20001;
  public static final String b = "action";
  public static final int c = 1;
  protected static final int d = 2;
  public static final int e = 1001;
  protected long a;
  protected View a;
  protected QQStoryContext a;
  protected QQStoryMainActivity.ScreenActionBroadcastReceiver a;
  public StoryRecordButtonAnimationView a;
  public IMyStroyPresenter a;
  public MystoryListView a;
  public TakeVideoButtonMainPart a;
  public FullScreenEmptyView a;
  public AppInterface a;
  protected boolean a;
  public boolean b;
  public boolean c;
  
  public QQStoryMainActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonMainPart = new TakeVideoButtonMainPart(this);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, long paramLong, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, QQStoryMainActivity.class);
    localIntent.putExtra("action", 2);
    localIntent.putExtra("usertype", paramInt1);
    localIntent.putExtra("unionid", paramString);
    localIntent.putExtra("userid", paramLong);
    localIntent.putExtra("storysharefrom", paramInt2);
    localIntent.putExtra("showinfocard", paramBoolean);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    paramContext.startActivity(localIntent);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a();
  }
  
  public void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("usertype", 0);
    String str = paramIntent.getStringExtra("unionid");
    long l = paramIntent.getLongExtra("userid", 0L);
    boolean bool = paramIntent.getBooleanExtra("showinfocard", true);
    int j = paramIntent.getIntExtra("storysharefrom", 0);
    if (i == 1)
    {
      StoryPlayVideoActivity.a(this, l, str, bool);
      return;
    }
    QQStoryContentActivity.a(this, i, str, bool, j);
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
    findViewById(2131302802).setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView.setVisibility(0);
    if (!this.b) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView.a(paramList);
    }
    this.b = true;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView.setOnClickListener(new iqm(this));
  }
  
  protected void a(Map paramMap)
  {
    super.a(paramMap);
    paramMap.put(new iqv(this), "");
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = true;
    long l = SystemClock.uptimeMillis();
    if ((!paramBoolean2) || (a()))
    {
      SLog.b("Q.qqstory.home.QQStoryMainActivity", "launchNewVideoTakeActivity start");
      Intent localIntent = new Intent(this, NewStoryTakeVideoActivity.class);
      localIntent.putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.NewShortVideoConfig.name(), null));
      localIntent.putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
      localIntent.putExtra("flow_camera_video_mode", true);
      localIntent.putExtra("auto_start", paramBoolean1);
      localIntent.putExtra("start_time", l);
      StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
      paramBoolean1 = ((Boolean)localStoryConfigManager.b("publish_picture", Boolean.valueOf(false))).booleanValue();
      boolean bool2 = ((Boolean)localStoryConfigManager.b("first_time_pic", Boolean.valueOf(false))).booleanValue();
      if ((paramBoolean1) && (!bool2))
      {
        paramBoolean1 = true;
        localIntent.putExtra("has_take_photo_ability", paramBoolean1);
        paramBoolean1 = bool1;
        if (!this.c)
        {
          if (!PtvFilterSoLoad.a(this.app, BaseApplicationImpl.getContext())) {
            break label262;
          }
          paramBoolean1 = bool1;
        }
        label195:
        localIntent.putExtra("flow_camera_use_filter_function", paramBoolean1);
        super.startActivityForResult(localIntent, 20000);
        if (!paramBoolean2) {
          break label267;
        }
        super.overridePendingTransition(2130968746, 2130968621);
      }
      for (;;)
      {
        new Handler().postDelayed(new iqr(this), 1000L);
        SLog.b("Q.qqstory.home.QQStoryMainActivity", "launchNewVideoTakeActivity end");
        return;
        paramBoolean1 = false;
        break;
        label262:
        paramBoolean1 = false;
        break label195;
        label267:
        super.overridePendingTransition(0, 0);
      }
    }
    startActivityForResult(new Intent(this, QQStoryPreTakeVideo.class), 20001);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter.a(NetConnInfoCenter.getServerTimeMillis());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Boolean = false;
      StoryReportor.b("home_page", "enter_time", 0, 0, new String[] { String.valueOf(l1 - l2) });
    }
    if (!paramBoolean3) {
      startTitleProgress();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(this.app);
    } while (ShortVideoUtils.a());
    return false;
  }
  
  public void b()
  {
    stopTitleProgress();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramBoolean);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setLoadMoreCompleted(paramBoolean1, paramBoolean2);
  }
  
  protected void c()
  {
    View localView = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.findViewById(2131302905);
    if (localView == null) {
      return;
    }
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(100L);
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setAnimationListener(new iqs(this, localView));
    localView.startAnimation(localScaleAnimation);
  }
  
  public void c(boolean paramBoolean) {}
  
  protected void d()
  {
    if (FileUtils.a())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      localQQCustomDialog.setMessage("存储空间不足，请清理缓存后重试");
      localQQCustomDialog.setNegativeButton("取消", new iqt(this));
      localQQCustomDialog.setPositiveButton("清理缓存", new iqu(this));
      localQQCustomDialog.setCancelable(false);
      localQQCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      localQQCustomDialog.show();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mUseOptimizMode = true;
    int i = super.getIntent().getIntExtra("action", 0);
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = getAppInterface();
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    super.setContentView(2130904458);
    super.setClickableTitle("日迹", new iql(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonMainPart.a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView = ((StoryRecordButtonAnimationView)findViewById(2131298352));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = ((MystoryListView)super.findViewById(2131302801));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setmIsNow(false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setDivider(null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setBackgroundDrawable(getResources().getDrawable(2130837958));
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView = new FullScreenEmptyView(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView.setRetryClickListener(new iqn(this));
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.getParent()).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setEmptyView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter = new StoryListPresenter(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.setListEventListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter.a();
    Looper.myQueue().addIdleHandler(new iqo(this));
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130841482);
    this.rightViewImg.getLayoutParams().width = -2;
    this.rightViewImg.setPadding(0, 0, DisplayUtil.b(this, 5.0F), 0);
    this.rightViewImg.setOnClickListener(new iqp(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131302802);
    paramBundle = (StoryConfigManager)SuperManager.a(10);
    boolean bool1 = ((Boolean)paramBundle.b("first_time_pic", Boolean.valueOf(false))).booleanValue();
    boolean bool2 = ((Boolean)paramBundle.b("easter_animation_is_ready", Boolean.valueOf(false))).booleanValue();
    if ((bool1) && (bool2))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((NowProxy)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(181)).a(this);
      ((VideoServerInfoManager)SuperManager.a(4)).c();
      ((StoryConfigManager)SuperManager.a(10)).c();
      if (i != 1) {
        break label568;
      }
      a(false, true);
    }
    for (;;)
    {
      ((TroopRedTouchManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(69)).a();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.c();
      ((PreloadDownloaderManager)SuperManager.a(6)).c();
      ((PreloadDownloaderManager)SuperManager.a(6)).b(this, 1);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      paramBundle.addAction("android.intent.action.SCREEN_ON");
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity$ScreenActionBroadcastReceiver = new QQStoryMainActivity.ScreenActionBroadcastReceiver(this);
      registerReceiver(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity$ScreenActionBroadcastReceiver, paramBundle);
      d();
      return true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      break;
      label568:
      if (i == 2) {
        a(super.getIntent());
      }
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    if (paramIntent.getIntExtra("action", 0) == 2) {
      a(paramIntent);
    }
    super.doOnNewIntent(paramIntent);
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.d();
    }
  }
  
  public void finish()
  {
    setResult(-1);
    super.finish();
  }
  
  public void g_(boolean paramBoolean) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a(paramInt1, paramInt2, paramIntent);
      }
      return;
      if ((paramIntent != null) && (paramIntent.hasExtra(PublishParam.jdField_a_of_type_JavaLangString)))
      {
        PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
        ((StoryVideoUploadManager)SuperManager.a(3)).a(localPublishParam.jdField_b_of_type_JavaLangString, localPublishParam.c, localPublishParam.d, localPublishParam.e, localPublishParam.f, localPublishParam.g, localPublishParam.jdField_a_of_type_Int, localPublishParam.jdField_b_of_type_Int, localPublishParam.jdField_a_of_type_Long);
        c();
        continue;
        a(false, false);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a(false, true);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ((NowProxy)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(181)).a();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistPresenterIMyStroyPresenter.c();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.h();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonMainPart.e();
    ((StoryManager)SuperManager.a(5)).c();
    ((FirstVideoManager)SuperManager.a(12)).c();
    ((UserManager)SuperManager.a(2)).c();
    unregisterReceiver(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainActivity$ScreenActionBroadcastReceiver);
    ((PreloadDownloaderManager)SuperManager.a(6)).e();
    ((PreloadDownloaderManager)SuperManager.a(6)).a(10000L);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
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
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonMainPart.c();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.f();
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView.getVisibility() != 8)) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryRecordButtonAnimationView.setVisibility(8);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {}
    for (boolean bool = ((QQStoryManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(180)).a("9999_HD", new iqq(this));; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_AndroidViewView != null)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.e();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.b();
      }
      return;
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonMainPart.d();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.g();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonMainPart.a(paramBoolean);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\QQStoryMainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */