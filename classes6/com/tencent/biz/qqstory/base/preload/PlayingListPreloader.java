package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.util.NetworkState;
import ihl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayingListPreloader
{
  public static final String a = "Q.qqstory.download.preload.PlayingListPreloader";
  public IVideoPreloader a;
  public PlayingListPreloader.OnVideoDownloadListener a;
  public ihl a;
  protected List a;
  protected boolean a;
  protected String b;
  
  public PlayingListPreloader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader = new VideoPreloader();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Ihl = new ihl(this, null);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(1);
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(this.jdField_a_of_type_Ihl);
  }
  
  public String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, null);
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    SLog.b("Q.qqstory.download.preload.PlayingListPreloader", "fetchCurrentVideo , vid = " + paramString1 + " ,url = " + paramString2);
    this.b = paramString1;
    paramString3 = b(paramString1, paramString3);
    if (this.jdField_a_of_type_Boolean)
    {
      SLog.b("Q.qqstory.download.preload.PlayingListPreloader", "download video at wifi , vid = " + paramString1);
      if (TextUtils.isEmpty(paramString3)) {
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(paramString1, paramString2, 0, true);
      }
      return paramString3;
    }
    SLog.b("Q.qqstory.download.preload.PlayingListPreloader", "download video at mobile net , vid = " + paramString1);
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString3)) {
      localArrayList.add(DownloadTask.a(paramString1, paramString2, 0));
    }
    int j = 0;
    int k = -1;
    if ((j < this.jdField_a_of_type_JavaUtilList.size()) && (k < 5))
    {
      paramString2 = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(j);
      int i;
      if (paramString2.mVid.equals(paramString1)) {
        i = 0;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        i = k;
        if (k >= 0)
        {
          localArrayList.add(DownloadTask.a(paramString2.mVid, paramString2.mVideoThumbnailUrl, 2));
          localArrayList.add(DownloadTask.a(paramString2.mVid, paramString2.getDownloadMaskUrl(), 1));
          localArrayList.add(DownloadTask.a(paramString2.mVid, paramString2.mVideoUrl, 0));
          i = k + 1;
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(localArrayList, 1, true);
    return paramString3;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a();
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener = null;
  }
  
  public void a(PlayingListPreloader.OnVideoDownloadListener paramOnVideoDownloadListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader$OnVideoDownloadListener = paramOnVideoDownloadListener;
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_Boolean = NetworkState.c();
      SLog.b("Q.qqstory.download.preload.PlayingListPreloader", "setPlayingList ,video size = " + paramList.size());
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(localStoryVideoItem.mVid, localStoryVideoItem.mVideoThumbnailUrl, 2, false);
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(localStoryVideoItem.mVid, localStoryVideoItem.getDownloadMaskUrl(), 1, false);
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(localStoryVideoItem.mVid, localStoryVideoItem.mVideoUrl, 0, false);
      }
    }
    int j = 0;
    int k = -1;
    label160:
    int i;
    if ((j < this.jdField_a_of_type_JavaUtilList.size()) && (k < 5))
    {
      paramList = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(j);
      if (!paramList.mVid.equals(this.b)) {
        break label223;
      }
      i = 0;
    }
    for (;;)
    {
      j += 1;
      k = i;
      break label160;
      break;
      label223:
      i = k;
      if (k >= 0)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(paramList.mVid, paramList.mVideoThumbnailUrl, 2, false);
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(paramList.mVid, paramList.getDownloadMaskUrl(), 1, false);
        this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadIVideoPreloader.a(paramList.mVid, paramList.mVideoUrl, 0, false);
        i = k + 1;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = PreloadUtils.a(paramString, 0);
    if (!paramString.exists()) {
      return false;
    }
    return paramString.delete();
  }
  
  protected String b(String paramString1, String paramString2)
  {
    paramString1 = PreloadUtils.a(paramString1, 0);
    if (PreloadUtils.a(paramString1)) {
      return paramString1.getAbsolutePath();
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new File(paramString2);
      if (PreloadUtils.a(paramString1)) {
        return paramString1.getAbsolutePath();
      }
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\PlayingListPreloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */