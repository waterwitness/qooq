package com.tencent.biz.qqstory.takevideo;

import android.os.Build;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.UnHandleTouchEventViewPager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iux;
import iuy;
import iuz;
import iva;
import ivb;
import ivd;
import java.util.ArrayList;
import java.util.List;

public class NewStoryFilterViewPagerController
  extends NewStoryPart
{
  public static final int a = 0;
  protected static final String a = "Q.qqstory.record.FilterViewPagerController";
  public static final int b = 1;
  protected View a;
  public NewStoryFilterViewPagerController.POIFilterData a;
  public UnHandleTouchEventViewPager a;
  public ivb a;
  public boolean a;
  
  public NewStoryFilterViewPagerController()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a()
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.getCurrentItem();
    iva localiva = this.jdField_a_of_type_Ivb.a(i);
    if (localiva != null) {
      return localiva.jdField_a_of_type_AndroidViewView;
    }
    return null;
  }
  
  public NewStoryFilterViewPagerController.POIFilterData a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$POIFilterData;
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new NewStoryFilterViewPagerController.VideoEffectsFilterData("", 0, 0));
    if (paramInt == 0)
    {
      localArrayList.add(new NewStoryFilterViewPagerController.VideoEffectsFilterData("", 0, 2));
      if ((!"Meizu".equalsIgnoreCase(Build.MANUFACTURER)) || (!"MX4 Pro".equalsIgnoreCase(Build.MODEL))) {
        localArrayList.add(new NewStoryFilterViewPagerController.VideoEffectsFilterData("", 0, 3));
      }
      localArrayList.add(new NewStoryFilterViewPagerController.VideoEffectsFilterData("", 0, 1));
    }
    localArrayList.add(new NewStoryFilterViewPagerController.VideoEffectsFilterData("", 0, 5));
    localArrayList.add(new NewStoryFilterViewPagerController.VideoEffectsFilterData("", 0, 6));
    localArrayList.add(new NewStoryFilterViewPagerController.VideoEffectsFilterData("", 0, 7));
    localArrayList.add(new NewStoryFilterViewPagerController.TimeFilterData(8));
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$POIFilterData != null) {
      localArrayList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController$POIFilterData);
    }
    this.jdField_a_of_type_Ivb.a(localArrayList);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setCurrentItem(localArrayList.size() * 50, false);
  }
  
  public void b(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.b(paramNewStoryTakeVideoActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager = ((UnHandleTouchEventViewPager)a(2131302877));
    this.jdField_a_of_type_AndroidViewView = a(2131302936);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.a(20, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new iux(this));
    this.jdField_a_of_type_Ivb = new ivb(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity);
    this.jdField_a_of_type_Ivb.a(new iuy(this));
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setAdapter(this.jdField_a_of_type_Ivb);
    this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager.setOnPageChangeListener(new iuz(this, null));
    SLog.b("Q.qqstory.record.FilterViewPagerController", "init filter view pager : " + this.jdField_a_of_type_ComTencentBizQqstoryViewUnHandleTouchEventViewPager);
    SosoInterface.a(new ivd(this, "NewStoryTakeVideoActivity"));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStoryFilterViewPagerController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */