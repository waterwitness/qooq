package com.tencent.biz.qqstory.takevideo;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantItem;
import com.tencent.biz.qqstory.model.pendant.NewStoryPendantType;
import com.tencent.biz.qqstory.model.pendant.PendantManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.pendant.OnPendantItemClickListener;
import com.tencent.biz.qqstory.takevideo.pendant.PendantPageAdapter;
import com.tencent.biz.qqstory.takevideo.pendant.PendantPageTabAdapter;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.EmptySupportViewPager;
import com.tencent.biz.qqstory.view.PagerIndicator;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.widget.HorizontalListView;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.Subscriber;
import iwb;
import iwc;
import iwd;
import iwe;
import iwf;
import java.util.List;

public class NewStorySelectPendant
  extends NewStoryPart
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.qqstory.record.NewStorySelectPendant";
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private NewStoryPendantItem jdField_a_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem;
  private NewStorySelectPendant.GetPendantConfigFileReceiver jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant$GetPendantConfigFileReceiver;
  private NewStorySelectPendant.PendantDownloadReceiver jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant$PendantDownloadReceiver;
  private OnPendantItemClickListener jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantOnPendantItemClickListener;
  private PendantPageAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantPendantPageAdapter;
  private PendantPageTabAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantPendantPageTabAdapter;
  private EmptySupportViewPager jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager;
  private PagerIndicator jdField_a_of_type_ComTencentBizQqstoryViewPagerIndicator;
  private FSurfaceViewLayout jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private View jdField_b_of_type_AndroidViewView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private NewStoryPendantItem jdField_b_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem;
  private View c;
  
  public NewStorySelectPendant()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantOnPendantItemClickListener = new iwd(this, null);
  }
  
  private Animation a()
  {
    int i = UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, 203.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    return localAnimationSet;
  }
  
  private void a(boolean paramBoolean)
  {
    SLog.a("Q.qqstory.record.NewStorySelectPendant", "updatePendant : %s", Boolean.valueOf(paramBoolean));
    List localList = ((PendantManager)SuperManager.a(11)).a(paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantPendantPageTabAdapter.a(localList);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantPendantPageAdapter.a(localList);
  }
  
  private Animation b()
  {
    int i = UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, 203.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    return localAnimationSet;
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new iwb(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.a(13, this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager = ((EmptySupportViewPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131302897));
      this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager.a(new iwe(this, null));
      this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantPendantPageAdapter);
      this.c = this.jdField_b_of_type_AndroidViewView.findViewById(2131297951);
      this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager.a(this.c);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPagerIndicator = ((PagerIndicator)this.jdField_b_of_type_AndroidViewView.findViewById(2131302898));
      this.jdField_a_of_type_ComTencentBizQqstoryViewPagerIndicator.setViewPager(this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager);
      this.jdField_a_of_type_ComTencentBizQqstoryViewPagerIndicator.setViewPagerAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantPendantPageAdapter);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302896));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new iwf(this, null));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantPendantPageTabAdapter);
    }
  }
  
  public String a()
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem != null) {
      return this.jdField_b_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.a();
    }
    return null;
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.record.NewStorySelectPendant", "showPendant");
    b();
    a(true);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.j();
    this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  public boolean a()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(new iwc(this));
      this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      SLog.b("Q.qqstory.record.NewStorySelectPendant", "hidePendant true");
      return true;
    }
    return false;
  }
  
  public boolean a(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    return a();
  }
  
  public String b()
  {
    if (this.jdField_b_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem != null)
    {
      Object localObject = this.jdField_b_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.f;
      localObject = ((PendantManager)SuperManager.a(11)).a((String)localObject);
      if (localObject != null) {
        return ((NewStoryPendantType)localObject).c + ":" + this.jdField_b_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.b;
      }
      return ":" + this.jdField_b_of_type_ComTencentBizQqstoryModelPendantNewStoryPendantItem.b;
    }
    return "";
  }
  
  public void b(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.b(paramNewStoryTakeVideoActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout = ((FSurfaceViewLayout)paramNewStoryTakeVideoActivity.findViewById(2131301606));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramNewStoryTakeVideoActivity.findViewById(2131302874));
    this.jdField_a_of_type_AndroidViewView = paramNewStoryTakeVideoActivity.findViewById(2131302781);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantPendantPageAdapter = new PendantPageAdapter(paramNewStoryTakeVideoActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantPendantPageAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantOnPendantItemClickListener);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPendantPendantPageTabAdapter = new PendantPageTabAdapter(paramNewStoryTakeVideoActivity);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = a();
    this.jdField_b_of_type_AndroidViewAnimationAnimation = b();
    paramNewStoryTakeVideoActivity = Dispatchers.get();
    Object localObject = new NewStorySelectPendant.GetPendantConfigFileReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant$GetPendantConfigFileReceiver = ((NewStorySelectPendant.GetPendantConfigFileReceiver)localObject);
    paramNewStoryTakeVideoActivity.registerSubscriber((Subscriber)localObject);
    paramNewStoryTakeVideoActivity = Dispatchers.get();
    localObject = new NewStorySelectPendant.PendantDownloadReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant$PendantDownloadReceiver = ((NewStorySelectPendant.PendantDownloadReceiver)localObject);
    paramNewStoryTakeVideoActivity.registerSubscriber((Subscriber)localObject);
  }
  
  public void g(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.g(paramNewStoryTakeVideoActivity);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant$GetPendantConfigFileReceiver);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant$PendantDownloadReceiver);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y) {}
    for (paramView = "2";; paramView = "1")
    {
      StoryReportor.a("video_shoot", "clk_changeface", 0, 0, new String[] { paramView });
      if ((FlowCameraConstant.d == 2) && (CameraAbility.c())) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a(-1, false);
      }
      a();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStorySelectPendant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */