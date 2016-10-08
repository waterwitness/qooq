package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;

public class ImageHashMap
{
  protected HashMap a;
  
  public ImageHashMap()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new HashMap();
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public Task a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return null;
    }
    return (Task)this.a.get(Integer.valueOf(paramImageView.hashCode()));
  }
  
  public Task a(ImageView paramImageView, Task paramTask)
  {
    if (paramImageView == null) {
      return null;
    }
    return (Task)this.a.put(Integer.valueOf(paramImageView.hashCode()), paramTask);
  }
  
  public Task a(Integer paramInteger)
  {
    return (Task)this.a.get(paramInteger);
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public Task b(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return null;
    }
    return (Task)this.a.remove(Integer.valueOf(paramImageView.hashCode()));
  }
  
  public Task b(Integer paramInteger)
  {
    return (Task)this.a.remove(paramInteger);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\AsyncImage\ImageHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */