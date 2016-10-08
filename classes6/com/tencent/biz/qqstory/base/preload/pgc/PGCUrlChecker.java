package com.tencent.biz.qqstory.base.preload.pgc;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.preload.PreloadUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iht;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PGCUrlChecker
{
  public static final int a = 10;
  protected QQStoryHandler a;
  private QQStoryObserver a;
  protected PGCUrlChecker.CheckResultListener a;
  protected AppInterface a;
  protected Map a;
  protected int b;
  public Map b;
  
  private PGCUrlChecker(Map paramMap, PGCUrlChecker.CheckResultListener paramCheckResultListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Int = 20;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new iht(this);
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPgcPGCUrlChecker$CheckResultListener = paramCheckResultListener;
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = QQStoryContext.a().a();
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(98));
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.b(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
  }
  
  public static void a(Map paramMap, PGCUrlChecker.CheckResultListener paramCheckResultListener)
  {
    new PGCUrlChecker(paramMap, paramCheckResultListener).b();
  }
  
  private void b()
  {
    c();
    d();
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (List)((Map.Entry)localIterator.next()).getValue();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject).next();
          if ((TextUtils.isEmpty(localStoryVideoItem.mVid)) && (!TextUtils.isEmpty(localStoryVideoItem.mVideoUrl))) {
            localStoryVideoItem.mVid = PreloadUtils.b(localStoryVideoItem.mVideoUrl);
          }
        }
      }
    }
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (List)((Map.Entry)localIterator.next()).getValue();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject).next();
          if (TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)) {
            this.jdField_b_of_type_JavaUtilMap.put(localStoryVideoItem.mVid, localStoryVideoItem);
          }
        }
      }
    }
    e();
  }
  
  private void e()
  {
    if ((this.jdField_b_of_type_JavaUtilMap.size() == 0) || (this.jdField_b_of_type_Int < 0))
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPgcPGCUrlChecker$CheckResultListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPgcPGCUrlChecker$CheckResultListener.a(this.jdField_a_of_type_JavaUtilMap);
      }
      a();
      return;
    }
    this.jdField_b_of_type_Int -= 1;
    int i = Math.min(this.jdField_b_of_type_JavaUtilMap.size(), 10);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localArrayList.add(((Map.Entry)localIterator.next()).getKey());
    } while (localArrayList.size() < i);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(localArrayList);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\pgc\PGCUrlChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */