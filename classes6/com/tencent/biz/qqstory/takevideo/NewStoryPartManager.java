package com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NewStoryPartManager
  implements NewStoryActivityInteractor
{
  protected static final String a = "Q.qqstory.record.NewStoryPartManager";
  NewStoryCameraGlFilterListener jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraGlFilterListener;
  public NewStoryCoverMgr a;
  public NewStoryDoodle a;
  NewStoryFilterViewPagerController jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController;
  public NewStoryImagePlayerModule a;
  NewStoryLabelList jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryLabelList;
  NewStoryPoiList jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiList;
  NewStoryPoiSearchViewPart jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart;
  NewStoryRMViewSTInterface jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryRMViewSTInterface;
  NewStorySelectPendant jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant;
  public NewStoryViewController a;
  TakeVideoButtonSubPart jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonSubPart;
  protected List a;
  
  public NewStoryPartManager()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryLabelList = new NewStoryLabelList();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiList = new NewStoryPoiList();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart = new NewStoryPoiSearchViewPart();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle = new NewStoryDoodle();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController = new NewStoryViewController();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController = new NewStoryFilterViewPagerController();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryRMViewSTInterface = new NewStoryRMViewSTInterface();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule = new NewStoryImagePlayerModule();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraGlFilterListener = new NewStoryCameraGlFilterListener();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant = new NewStorySelectPendant();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCoverMgr = new NewStoryCoverMgr();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonSubPart = new TakeVideoButtonSubPart();
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryLabelList);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiList);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryRMViewSTInterface);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraGlFilterListener);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCoverMgr);
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonSubPart);
    SLog.b("Q.qqstory.record.NewStoryPartManager", "create %d parts", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
  }
  
  public void a(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((NewStoryPart)localIterator.next()).a(paramNewStoryTakeVideoActivity);
    }
  }
  
  public void a(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((NewStoryPart)localIterator.next()).a(paramNewStoryTakeVideoActivity, paramBoolean);
    }
  }
  
  public boolean a(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant.a(paramNewStoryTakeVideoActivity))
    {
      SLog.b("Q.qqstory.record.NewStoryPartManager", "Pendant panel consume back pressed");
      return true;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiList.a(paramNewStoryTakeVideoActivity))
    {
      SLog.b("Q.qqstory.record.NewStoryPartManager", "Poi list consume back pressed");
      return true;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.a(paramNewStoryTakeVideoActivity))
    {
      SLog.b("Q.qqstory.record.NewStoryPartManager", "Poi search consume back pressed");
      return true;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryLabelList.a(paramNewStoryTakeVideoActivity))
    {
      SLog.b("Q.qqstory.record.NewStoryPartManager", "label list consume back pressed");
      return true;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a(paramNewStoryTakeVideoActivity))
    {
      SLog.b("Q.qqstory.record.NewStoryPartManager", "doodle panel consume back pressed");
      return true;
    }
    return false;
  }
  
  public void b(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((NewStoryPart)localIterator.next()).b(paramNewStoryTakeVideoActivity);
    }
  }
  
  public void c(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((NewStoryPart)localIterator.next()).c(paramNewStoryTakeVideoActivity);
    }
  }
  
  public void d(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((NewStoryPart)localIterator.next()).d(paramNewStoryTakeVideoActivity);
    }
  }
  
  public void e(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((NewStoryPart)localIterator.next()).e(paramNewStoryTakeVideoActivity);
    }
  }
  
  public void f(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((NewStoryPart)localIterator.next()).f(paramNewStoryTakeVideoActivity);
    }
  }
  
  public void g(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((NewStoryPart)localIterator.next()).g(paramNewStoryTakeVideoActivity);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStoryPartManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */