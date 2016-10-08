package com.tencent.biz.qqstory.base.preload.pgc;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.base.preload.PreloadUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryCoverInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ihr;
import ihs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PGCPlayingListPreloader
  extends PlayingListPreloader
{
  protected static final String c = "Q.qqstory.download.preload.PGCPlayingListPreloader";
  protected static final String d = "playing_list";
  
  public PGCPlayingListPreloader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    SLog.b("Q.qqstory.download.preload.PGCPlayingListPreloader", "fetchCurrentVideo , vid = " + paramString1 + " ,url = " + paramString2);
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      SLog.e("Q.qqstory.download.preload.PGCPlayingListPreloader", "pgc download vid and url is empty");
      return null;
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = PreloadUtils.b(paramString2);
    }
    paramString1 = b(str, paramString3);
    if (!TextUtils.isEmpty(paramString1))
    {
      SLog.b("Q.qqstory.download.preload.PGCPlayingListPreloader", "video download before , vid = " + str);
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1 = new StoryVideoItem();
      paramString1.mVid = str;
      paramString2 = new ArrayList();
      paramString2.add(paramString1);
      paramString1 = new HashMap();
      paramString1.put("playing_list", paramString2);
      PGCUrlChecker.a(paramString1, new ihs(this));
      return null;
    }
    return b(this, str, paramString2, null);
  }
  
  public void b(List paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Story localStory = (Story)paramList.next();
      if ((localStory.coverInfo != null) && (localStory.coverInfo.type == 2))
      {
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.mVid = localStory.coverInfo.vid;
        localStoryVideoItem.mVideoUrl = localStory.coverInfo.coverUrl;
        localArrayList.add(localStoryVideoItem);
      }
    }
    paramList = new HashMap();
    paramList.put("playing_list", localArrayList);
    PGCUrlChecker.a(paramList, new ihr(this));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\preload\pgc\PGCPlayingListPreloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */