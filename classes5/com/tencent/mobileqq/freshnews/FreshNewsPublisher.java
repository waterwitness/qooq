package com.tencent.mobileqq.freshnews;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyTransFileController;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import sqw;
import sqx;
import sqy;

public class FreshNewsPublisher
{
  private static final String jdField_a_of_type_JavaLangString = "FreshNewsPublisher";
  private FreshNewsInfo jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo;
  private FreshNewsManager jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager;
  private FreshNewsObserver jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver;
  private NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler;
  
  public FreshNewsPublisher(NearbyAppInterface paramNearbyAppInterface, FreshNewsManager paramFreshNewsManager, FreshNewsInfo paramFreshNewsInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new sqx(this);
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver = new sqy(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsManager = paramFreshNewsManager;
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo = paramFreshNewsInfo;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    paramNearbyAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  private void b()
  {
    ThreadManager.a().post(new sqw(this));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsObserver);
    ((FreshNewsHandler)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(1)).a(this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFreshnewsFreshNewsInfo.uploadingPhotoIndex.set(0);
    b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\FreshNewsPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */