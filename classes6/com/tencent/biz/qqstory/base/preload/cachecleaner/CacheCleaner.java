package com.tencent.biz.qqstory.base.preload.cachecleaner;

import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ihp;

public class CacheCleaner
{
  protected static final long a = 3600000L;
  protected static CacheCleaner a;
  protected static final String a = "cache_clean_latest_time";
  public static final String[] a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { QQStoryConstant.p, QQStoryConstant.s, QQStoryConstant.t };
  }
  
  public static CacheCleaner a()
  {
    if (jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerCacheCleaner == null) {
      jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerCacheCleaner = new CacheCleaner();
    }
    return jdField_a_of_type_ComTencentBizQqstoryBasePreloadCachecleanerCacheCleaner;
  }
  
  public void a()
  {
    if (!a()) {
      return;
    }
    a(FileUtils.a());
  }
  
  protected void a(boolean paramBoolean)
  {
    ThreadManager.a(new ihp(this, paramBoolean), 2, null, false);
  }
  
  protected boolean a()
  {
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    long l = System.currentTimeMillis();
    if (l - ((Long)localStoryConfigManager.b("cache_clean_latest_time", Long.valueOf(0L))).longValue() < 3600000L) {
      return false;
    }
    localStoryConfigManager.b("cache_clean_latest_time", Long.valueOf(l));
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\cachecleaner\CacheCleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */