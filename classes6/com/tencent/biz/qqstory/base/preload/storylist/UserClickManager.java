package com.tencent.biz.qqstory.base.preload.storylist;

import android.util.Pair;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.List;

public class UserClickManager
{
  public static final String a = "Q.qqstory.download.preload.UserClickManager";
  protected PreloadVideoSource a;
  public UserClickManager.OnFirstVideoDownloadListener a;
  
  public UserClickManager(PreloadVideoSource paramPreloadVideoSource)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistPreloadVideoSource = paramPreloadVideoSource;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistUserClickManager$OnFirstVideoDownloadListener = null;
  }
  
  public void a(UserClickManager.OnFirstVideoDownloadListener paramOnFirstVideoDownloadListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistUserClickManager$OnFirstVideoDownloadListener = paramOnFirstVideoDownloadListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    SLog.b("Q.qqstory.download.preload.UserClickManager", "on click , category = " + paramString1 + " , uin = " + paramString2);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistPreloadVideoSource.a(paramString1, paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    UserClickManager.OnFirstVideoDownloadListener localOnFirstVideoDownloadListener = this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistUserClickManager$OnFirstVideoDownloadListener;
    if (localOnFirstVideoDownloadListener != null)
    {
      paramString = ((FirstVideoManager)SuperManager.a(12)).a(paramString).iterator();
      while (paramString.hasNext())
      {
        Pair localPair = (Pair)paramString.next();
        if (paramBoolean) {
          localOnFirstVideoDownloadListener.a((String)localPair.first, (String)localPair.second);
        } else {
          localOnFirstVideoDownloadListener.b((String)localPair.first, (String)localPair.second);
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistUserClickManager$OnFirstVideoDownloadListener = null;
  }
  
  public void b(String paramString1, String paramString2)
  {
    SLog.b("Q.qqstory.download.preload.UserClickManager", "on video list load , category = " + paramString1 + " , uin = " + paramString2);
    if (this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistUserClickManager$OnFirstVideoDownloadListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorylistUserClickManager$OnFirstVideoDownloadListener.c(paramString1, paramString2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\storylist\UserClickManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */