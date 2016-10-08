package com.tencent.biz.qqstory.storyHome.qqstorylist;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.support.ImageDownloader.FILE;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MyStorys
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  protected String a;
  protected ArrayList a;
  protected HashMap a;
  protected boolean a;
  protected int f;
  public int g;
  
  public MyStorys()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public float a()
  {
    switch (b())
    {
    default: 
      return 0.0F;
    }
    return StoryListUtils.a(((StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(0)).mCreateTime);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public StoryVideoItem a(String paramString)
  {
    return (StoryVideoItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(Context paramContext)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return "快和朋友们分享你的精彩生活吧！";
    }
    this.f = 3;
    if (this.jdField_a_of_type_Boolean) {
      return StoryListUtils.a(((StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(0)).mCreateTime);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StoryListUtils.a(((StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(0)).mCreateTime));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
      if (StoryListUtils.a(localStoryVideoItem.mUploadStatus) == 1)
      {
        this.f = 1;
        return "日迹上传中...";
      }
      if (StoryListUtils.a(localStoryVideoItem.mUploadStatus) != 2) {
        break label189;
      }
      i += 1;
    }
    label189:
    for (;;)
    {
      break;
      if (i > 0)
      {
        this.f = 2;
        return paramContext.getResources().getString(2131366431, new Object[] { Integer.valueOf(i) });
      }
      return localStringBuilder.toString();
    }
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(0, paramStoryVideoItem);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).mVid.equals(paramString))
        {
          this.jdField_a_of_type_JavaUtilArrayList.set(i, paramStoryVideoItem);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.next();
      this.jdField_a_of_type_JavaUtilArrayList.add(localStoryVideoItem);
      this.jdField_a_of_type_JavaUtilHashMap.put(localStoryVideoItem.mVid, localStoryVideoItem);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return 0;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
      if (StoryListUtils.a(localStoryVideoItem.mUploadStatus) == 1) {
        return 1;
      }
      if (StoryListUtils.a(localStoryVideoItem.mUploadStatus) == 2) {
        return 2;
      }
    }
    return 3;
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      if (StoryListUtils.b(((StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(0)).mVideoLocalThumbnailPath)) {
        return ImageDownloader.FILE.a(((StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(0)).mVideoLocalThumbnailPath);
      }
      if (((StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(0)).mVideoThumbnailUrl == null) {
        return "";
      }
      return ((StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(0)).mVideoThumbnailUrl;
    }
    return "";
  }
  
  public void b(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramStoryVideoItem.mVid, paramStoryVideoItem);
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).mVid.equals(paramStoryVideoItem.mVid))
        {
          this.jdField_a_of_type_JavaUtilArrayList.set(i, paramStoryVideoItem);
          return;
        }
        i += 1;
      }
    }
  }
  
  public void c(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramStoryVideoItem.mVid);
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).mVid.equals(paramStoryVideoItem.mVid))
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\MyStorys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */