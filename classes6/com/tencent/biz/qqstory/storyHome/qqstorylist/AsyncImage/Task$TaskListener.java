package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;

public abstract interface Task$TaskListener
{
  public abstract void a(ImageView paramImageView, Drawable paramDrawable, Task paramTask);
  
  public abstract void a(ImageView paramImageView, URLDrawable paramURLDrawable);
  
  public abstract void a(Integer paramInteger, URLDrawable paramURLDrawable, Throwable paramThrowable);
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\AsyncImage\Task$TaskListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */