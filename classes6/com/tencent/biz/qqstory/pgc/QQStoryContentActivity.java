package com.tencent.biz.qqstory.pgc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.base.preload.pgc.PGCPlayingListPreloader;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.pgc.view.BaseContentPagerView;
import com.tencent.biz.qqstory.pgc.view.ContentEmptyView;
import com.tencent.biz.qqstory.pgc.view.InfoCardDialog;
import com.tencent.biz.qqstory.pgc.view.PostContentView;
import com.tencent.biz.qqstory.share.StoryAccountShare;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AnimationUtils;
import com.tencent.biz.qqstory.view.StoryNewGuideDialog;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout.OnDraggingListener;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.biz.qqstory.view.widget.VerticalPagerView;
import com.tencent.biz.qqstory.view.widget.VerticalPagerView.OnPagerChangedListener;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.widget.immersive.SystemBarCompact;
import ikd;
import ike;
import ikf;
import java.util.ArrayList;
import java.util.HashSet;

public class QQStoryContentActivity
  extends QQStoryBaseActivity
  implements DialogInterface.OnDismissListener, ViewPager.OnPageChangeListener, View.OnClickListener, DragFrameLayout.OnDraggingListener, VerticalPagerView.OnPagerChangedListener
{
  public static final int a = 1;
  public static final String a = "user_type";
  public static final String b = "user_unionid";
  public static final String c = "story_id";
  public static final String d = "come_from";
  public static final int i = 1001;
  public long a;
  public ViewPager a;
  protected View a;
  public FrameLayout a;
  public ImageView a;
  public TextView a;
  protected QQStoryHandler a;
  protected QQStoryObserver a;
  public PGCPlayingListPreloader a;
  public QQStoryContentActivity.ContentPagerAdaper a;
  public UserInfo a;
  public ContentEmptyView a;
  public InfoCardDialog a;
  public StoryNewGuideDialog a;
  public DragFrameLayout a;
  public QQStoryLoadingView a;
  public ArrayList a;
  protected boolean a;
  public int b;
  public long b;
  public View b;
  protected boolean b;
  protected int c;
  public long c;
  protected View c;
  protected boolean c;
  protected int d;
  public long d;
  protected boolean d;
  protected int e;
  public String e;
  public boolean e;
  protected int f;
  protected String f;
  protected boolean f;
  public int g;
  public boolean g;
  public int h;
  
  public QQStoryContentActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new ikf(this);
  }
  
  public static void a(Activity paramActivity, String paramString, View paramView, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, QQStoryContentActivity.class);
    localIntent.putExtra("story_id", paramString);
    localIntent.putExtra("come_from", paramInt);
    localIntent.putExtra("showTitleBar", false);
    localIntent.putExtra("showAnimation", false);
    localIntent.putExtra("showInfoCard", false);
    AnimationUtils.a(paramActivity, localIntent, paramView, 1, paramString);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    a(paramContext, paramInt1, paramString, false, paramInt2);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, QQStoryContentActivity.class);
    localIntent.putExtra("user_type", paramInt1);
    localIntent.putExtra("user_unionid", paramString);
    localIntent.putExtra("come_from", paramInt2);
    localIntent.putExtra("showTitleBar", false);
    localIntent.putExtra("showInfoCard", paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, QQStoryContentActivity.class);
    localIntent.putExtra("story_id", paramString);
    localIntent.putExtra("come_from", paramInt);
    localIntent.putExtra("showTitleBar", false);
    localIntent.putExtra("showInfoCard", false);
    paramContext.startActivity(localIntent);
  }
  
  protected void a()
  {
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_b_of_type_Int, this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.jdField_b_of_type_Int, this.jdField_e_of_type_JavaLangString, 20, "");
      StoryReportor.a("play_page", "exp", this.g, 0, new String[] { this.jdField_e_of_type_JavaLangString, "", StoryReportor.a(this), "" });
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      if (this.jdField_f_of_type_JavaLangString != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.b(this.jdField_f_of_type_JavaLangString);
        StoryReportor.a("play_page", "exp", this.g, 0, new String[] { "", this.jdField_f_of_type_JavaLangString, StoryReportor.a(this), "" });
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog = new InfoCardDialog(this, this.app);
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo, false, paramInt);
    this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.setOnDismissListener(this);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    float f1 = 0.0F;
    float f2 = 1.0F - (paramInt3 - paramInt5) / DisplayUtil.a(this, 60.0F);
    if (f2 < 0.0F) {}
    for (;;)
    {
      ViewHelper.setAlpha(this.jdField_a_of_type_AndroidViewView, f1);
      return;
      f1 = f2;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 - paramInt3 > DisplayUtil.a(this, 60.0F))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > this.h)
      {
        paramView = ((BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(this.h)).a();
        StoryReportor.a("play_page", "leave", this.g, paramView.contentType, new String[] { paramView.getUnionId(), paramView.storyId, "", "" });
      }
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a();
    paramView = new AlphaAnimation(ViewHelper.getAlpha(this.jdField_a_of_type_AndroidViewView), 1.0F);
    paramView.setFillAfter(true);
    paramView.setDuration(200L);
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramView);
  }
  
  public void a(VerticalPagerView paramVerticalPagerView, View paramView, int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if ((paramInt == 1) && ((paramVerticalPagerView instanceof PostContentView)))
      {
        paramVerticalPagerView = (PostContentView)paramVerticalPagerView;
        paramView = paramVerticalPagerView.a();
        if ((paramView != null) && (paramVerticalPagerView.jdField_f_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(paramView.storyId, paramView.getUserType(), paramView.getUnionId(), 4);
        }
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean);
  }
  
  protected void b()
  {
    ViewHelper.setAlpha(this.jdField_a_of_type_AndroidViewView, 0.0F);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, 300, new ike(this));
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) || ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (((BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem())).b()))) {}
    for (int j = 1; ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) && (!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && (j != 0); j = 0) {
      return true;
    }
    return false;
  }
  
  public void c()
  {
    new StoryAccountShare(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo).a(this);
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) || ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (((BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem())).b()))) {}
    for (int j = 1; (this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem() == 0) && (!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && (j != 0); j = 0) {
      return true;
    }
    return false;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      TroopShareUtility.a(this.app, this, paramInt2, paramIntent);
      Story localStory = ((BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem())).a();
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(localStory.storyId, localStory.getUserType(), localStory.getUnionId(), 2);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentViewNoTitle(2130904434);
    super.getWindow().addFlags(1024);
    paramBundle = Build.MANUFACTURER + "_" + Build.MODEL;
    if ((Build.VERSION.SDK_INT > 10) && (!AbsBaseWebViewActivity.a.contains(paramBundle))) {
      getWindow().addFlags(16777216);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)super.findViewById(2131302727));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)super.findViewById(2131302733));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131302732));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)super.findViewById(2131302729));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302730));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131302728);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131302731);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryPgcQQStoryContentActivity$ContentPagerAdaper = new QQStoryContentActivity.ContentPagerAdaper(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout = ((DragFrameLayout)super.findViewById(2131302725));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setDraggableView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    paramBundle = super.getIntent();
    this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("showAnimation", false);
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("showInfoCard", false);
    if (this.jdField_b_of_type_ArrayOfInt != null)
    {
      this.jdField_c_of_type_Int = this.jdField_b_of_type_ArrayOfInt[0];
      this.jdField_d_of_type_Int = this.jdField_b_of_type_ArrayOfInt[1];
      this.jdField_e_of_type_Int = this.jdField_b_of_type_ArrayOfInt[2];
      this.jdField_f_of_type_Int = this.jdField_b_of_type_ArrayOfInt[3];
    }
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("user_type", 0);
    this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("user_unionid");
    this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("story_id");
    this.g = paramBundle.getIntExtra("come_from", 0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setOnDraggingListener(this);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131302726);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo = new UserInfo();
    this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.unionId = this.jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.nick = "";
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPgcPGCPlayingListPreloader = new PGCPlayingListPreloader();
    paramBundle = (PreloadDownloaderManager)SuperManager.a(6);
    if (!paramBundle.a())
    {
      paramBundle.c();
      this.jdField_f_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.app.a(98));
    this.app.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    TVKTroopVideoManager.a(this);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.b();
    }
    this.app.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    int j = 0;
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.get(j) != null) {
        ((BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(j)).d();
      }
      j += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    AnimatorProxy.wrap(this.jdField_a_of_type_AndroidViewView).reset();
    AnimatorProxy.wrap(this.jdField_a_of_type_AndroidSupportV4ViewViewPager).reset();
    AnimatorProxy.wrap(this.jdField_a_of_type_AndroidWidgetFrameLayout).reset();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPgcPGCPlayingListPreloader.a();
    if (this.jdField_f_of_type_Boolean) {
      ((PreloadDownloaderManager)SuperManager.a(6)).a(0L);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void doOnPause()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      ((BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem())).f();
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.b(0);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      ((BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getCurrentItem())).e();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.postDelayed(new ikd(this), 100L);
  }
  
  public void finish()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      b();
      return;
    }
    super.finish();
    super.overridePendingTransition(0, 2130968621);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_b_of_type_AndroidViewView) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
      a();
    }
    while (paramView != this.jdField_c_of_type_AndroidViewView) {
      return;
    }
    finish();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    int j = 0;
    if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (j == paramInt)
      {
        ((BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(j)).e();
        ((BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a(true);
      }
      for (;;)
      {
        j += 1;
        break;
        ((BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(j)).f();
        ((BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a(false);
      }
    }
    boolean bool;
    Story localStory;
    Object localObject;
    int k;
    String str2;
    String str3;
    if (((BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a() == 0)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      localStory = ((BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a();
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        ((QQStoryManager)this.app.getManager(180)).a(this.jdField_e_of_type_JavaLangString, localStory.storyId, paramInt);
      }
      localObject = (BaseContentPagerView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if ((localObject instanceof PostContentView))
      {
        localObject = (PostContentView)localObject;
        if ((!this.jdField_a_of_type_Boolean) && (((PostContentView)localObject).jdField_f_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(localStory.storyId, localStory.getUserType(), localStory.getUnionId(), 4);
        }
      }
      localObject = "left";
      if (paramInt < this.h) {
        localObject = "right";
      }
      j = this.g;
      k = localStory.contentType;
      str2 = localStory.getUnionId();
      str3 = localStory.storyId;
      if (!this.jdField_a_of_type_Boolean) {
        break label339;
      }
    }
    label339:
    for (String str1 = "1";; str1 = "2")
    {
      StoryReportor.a("play_page", (String)localObject, j, k, new String[] { str2, str3, str1, "" });
      this.h = paramInt;
      localObject = localStory.user;
      return;
      bool = false;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\QQStoryContentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */