package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.QQUIEventReceiver;
import isw;

public abstract class PageLoaderStep
  extends QQUIEventReceiver
  implements Step
{
  public static final int a = 0;
  public static final int b = 1;
  public static final String b = "Q.qqstory.home.Repository.PageLoaderStep";
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public INetPageLoader a;
  protected Step.ErrorCallBack a;
  public Step.FinishCallBack a;
  protected Step a;
  protected Object a;
  protected boolean a;
  public long b;
  public int g;
  public int h;
  
  public PageLoaderStep(Repository paramRepository, INetPageLoader paramINetPageLoader)
  {
    super(paramRepository);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.g = 0;
    this.h = 20;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkINetPageLoader = paramINetPageLoader;
  }
  
  public abstract int a(Dispatcher.Dispatchable paramDispatchable);
  
  public Step a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  protected void a(ErrorMessage paramErrorMessage)
  {
    Dispatchers.get().unRegisterSubscriber(this);
    this.g = 2;
    paramErrorMessage.extraMsg = a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack.a(paramErrorMessage);
    }
  }
  
  public void a(Repository paramRepository, Dispatcher.Dispatchable paramDispatchable)
  {
    if (!a(paramDispatchable)) {
      return;
    }
    paramRepository.a(new isw(this, paramDispatchable));
  }
  
  public void a(Step.ErrorCallBack paramErrorCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack = paramErrorCallBack;
  }
  
  public void a(Step.FinishCallBack paramFinishCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack = paramFinishCallBack;
  }
  
  public void a(Step paramStep)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep = paramStep;
  }
  
  public abstract void a(Dispatcher.Dispatchable paramDispatchable);
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected boolean a(Dispatcher.Dispatchable paramDispatchable)
  {
    return true;
  }
  
  public void b()
  {
    this.g = 1;
    this.b = System.currentTimeMillis();
    SLog.a("Q.qqstory.home.Repository.PageLoaderStep", "Start run %s step", this);
    Dispatchers.get().registerSubscriber(this);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkINetPageLoader.a(null, 0);
    a();
  }
  
  public boolean b()
  {
    return this.h > 0;
  }
  
  public void c()
  {
    if (this.g == 1)
    {
      SLog.e("Q.qqstory.home.Repository.PageLoaderStep", "被finished了！！！");
      a();
      Dispatchers.get().unRegisterSubscriber(this);
    }
    this.g = 2;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\PageLoaderStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */