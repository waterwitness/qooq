package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Uin2QQItemStep
  implements Step
{
  public static final String a = "Q.qqstory.home.Repository.Uin2QQItemStep";
  protected long a;
  protected UserManager a;
  protected Repository a;
  protected Step.ErrorCallBack a;
  protected Step.FinishCallBack a;
  protected Step a;
  protected Uin2QQItemStep.QQUserUIItemComparator a;
  protected List a;
  protected boolean a;
  protected List b;
  protected List c;
  
  public Uin2QQItemStep(Repository paramRepository)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager = ((UserManager)SuperManager.a(2));
    this.c = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestUin2QQItemStep$QQUserUIItemComparator = new Uin2QQItemStep.QQUserUIItemComparator();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository = paramRepository;
  }
  
  private void c()
  {
    Collections.sort(this.c, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestUin2QQItemStep$QQUserUIItemComparator);
    this.b = new ArrayList(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.f.size());
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      QQUserUIItem localQQUserUIItem = (QQUserUIItem)localIterator.next();
      this.b.add(Long.valueOf(localQQUserUIItem.uid));
    }
  }
  
  public Step a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep;
  }
  
  public Object a()
  {
    return this.b;
  }
  
  public String a()
  {
    return "Uin2QQItemStep";
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.qqstory_step", "Q.qqstory.home.Repository.Uin2QQItemStep");
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
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilList = ((List)paramObject);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(List paramList)
  {
    SLog.b("Q.qqstory.home.Repository.Uin2QQItemStep", "uin to QQItem finish");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.e().clear();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.c.clear();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.e().addAll(paramList);
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    SLog.a("Q.qqstory.home.Repository.Uin2QQItemStep", "Start run %s step", getClass().getSimpleName());
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      SLog.e("Q.qqstory.home.Repository.Uin2QQItemStep", "request uinList = null!");
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$ErrorCallBack.a(new ErrorMessage(9999, "failed to get uinlist"));
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.f != null) {
          break;
        }
        SLog.e("Q.qqstory.home.Repository.Uin2QQItemStep", "request repository.fullUinList = null!");
      } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack == null);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(a());
      return;
      QQAppInterface localQQAppInterface = QQStoryContext.a().a();
      Set localSet = this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.a();
      int i = 0;
      if (i < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.f.size())
      {
        l1 = ((Long)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRepository.f.get(i)).longValue();
        QQUserUIItem localQQUserUIItem2 = StoryListUtils.a(localQQAppInterface, l1, localSet.contains(String.valueOf(l1)));
        QQUserUIItem localQQUserUIItem3 = this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.a(l1);
        if (localQQUserUIItem3 != null)
        {
          localQQUserUIItem1 = localQQUserUIItem3;
          if (localQQUserUIItem2 != null)
          {
            localQQUserUIItem3.copy(localQQUserUIItem2);
            localQQUserUIItem3.remark = localQQUserUIItem2.remark;
            localQQUserUIItem3.nickName = localQQUserUIItem2.nickName;
          }
        }
        for (QQUserUIItem localQQUserUIItem1 = localQQUserUIItem3;; localQQUserUIItem1 = localQQUserUIItem2)
        {
          if (localQQUserUIItem1 != null)
          {
            this.c.add(localQQUserUIItem1);
            this.jdField_a_of_type_ComTencentBizQqstoryModelUserManager.a(localQQUserUIItem1);
          }
          i += 1;
          break;
        }
      }
      c();
      a(this.b);
      SLog.d("Q.qqstory.home.Repository.Uin2QQItemStep", "return the data to next step,size=" + this.b.size());
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      SLog.a("Q.qqstory.home.Repository.Uin2QQItemStep", "finish %s step and cost time=%d", getClass().getSimpleName(), Long.valueOf(l1 - l2));
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack == null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestStep$FinishCallBack.a(a());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\Uin2QQItemStep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */