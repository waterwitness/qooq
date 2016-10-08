package com.tencent.biz.qqstory.base.preload.storylist;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategorySource
  implements ISource
{
  protected static final int a = 5;
  protected PreloadVideoSource a;
  public final String a;
  public List a;
  
  public CategorySource(PreloadVideoSource paramPreloadVideoSource, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistPreloadVideoSource = paramPreloadVideoSource;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public StorySource a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      StorySource localStorySource = (StorySource)localIterator.next();
      if (localStorySource.a().equals(paramString)) {
        return localStorySource;
      }
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((StorySource)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt, List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistPreloadVideoSource.a) && (!this.jdField_a_of_type_JavaLangString.equals(IPreloadVideoSource.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((StorySource)localIterator.next()).a(paramInt, paramList);
      }
    }
  }
  
  public void a(String paramString, List paramList, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    StorySource localStorySource;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localStorySource = (StorySource)((Iterator)localObject).next();
    } while (!localStorySource.a().equals(paramString));
    for (;;)
    {
      localObject = localStorySource;
      if (localStorySource == null)
      {
        localObject = new StorySource(this.jdField_a_of_type_JavaLangString, paramString);
        this.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      ((StorySource)localObject).a(paramList, paramBoolean);
      return;
      localStorySource = null;
    }
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      localObject = new StorySource(this.jdField_a_of_type_JavaLangString, (String)localObject);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
    }
  }
  
  public void b(int paramInt, List paramList)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistPreloadVideoSource.a) && (!this.jdField_a_of_type_JavaLangString.equals(IPreloadVideoSource.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_JavaLangString.equals(IPreloadVideoSource.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangString.equals(IPreloadVideoSource.b)) || (this.jdField_a_of_type_JavaLangString.equals(IPreloadVideoSource.c)))
      {
        int j = this.jdField_a_of_type_JavaUtilList.size();
        int i = 0;
        while ((i < 5) && (i < j))
        {
          ((StorySource)this.jdField_a_of_type_JavaUtilList.get(i)).b(paramInt, paramList);
          i += 1;
        }
      }
    }
  }
  
  public void b(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    a(paramList);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\CategorySource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */