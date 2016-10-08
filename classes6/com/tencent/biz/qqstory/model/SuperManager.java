package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.base.preload.storylist.FirstVideoManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.pendant.PendantManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ijo;

public class SuperManager
  implements IManager
{
  public static final int a = 0;
  public static final String a;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 8;
  public static final int h = 9;
  public static final int i = 10;
  public static final int j = 11;
  public static final int k = 12;
  public static final int l = 13;
  public static final int m = 14;
  public final IManager[] a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = SuperManager.class.getSimpleName();
  }
  
  private SuperManager()
  {
    this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelIManager = new IManager[14];
  }
  
  public static IManager a(int paramInt)
  {
    return ijo.a.b(paramInt);
  }
  
  public static SuperManager a()
  {
    return ijo.a;
  }
  
  private void a(int paramInt, IManager paramIManager)
  {
    this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelIManager[paramInt] = paramIManager;
  }
  
  public void a() {}
  
  public IManager b(int paramInt)
  {
    IManager localIManager1 = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelIManager[paramInt];
    if (localIManager1 == null) {}
    for (;;)
    {
      IManager localIManager2;
      synchronized (this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelIManager)
      {
        localIManager2 = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelIManager[paramInt];
        if (localIManager2 == null) {
          break label200;
        }
        return localIManager2;
        a(paramInt, localIManager1);
        if (localIManager1 != null)
        {
          localIManager1.a();
          SLog.b(jdField_a_of_type_JavaLangString, "onInit manager : %s", localIManager1);
        }
        return localIManager1;
      }
      Object localObject2 = this;
      continue;
      localObject2 = new StoryConfigManager();
      continue;
      localObject2 = new PendantManager();
      continue;
      localObject2 = new LbsManager();
      continue;
      localObject2 = new DoodleEmojiManager();
      continue;
      localObject2 = new UserManager();
      continue;
      localObject2 = new PreloadDownloaderManager();
      continue;
      localObject2 = new VideoServerInfoManager();
      continue;
      localObject2 = new StoryVideoUploadManager();
      continue;
      localObject2 = new StoryManager();
      continue;
      localObject2 = new FirstVideoManager();
      continue;
      localObject2 = new ReportWatchVideoManager();
      continue;
      return (IManager)localObject2;
      label200:
      localObject2 = localIManager2;
      switch (paramInt)
      {
      }
      localObject2 = localIManager2;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    IManager[] arrayOfIManager = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelIManager;
    int n = 0;
    try
    {
      while (n < this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelIManager.length)
      {
        IManager localIManager = this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelIManager[n];
        SLog.b(jdField_a_of_type_JavaLangString, "destroy manager : %s", localIManager);
        if (localIManager != null) {
          localIManager.b();
        }
        this.jdField_a_of_type_ArrayOfComTencentBizQqstoryModelIManager[n] = null;
        n += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\model\SuperManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */