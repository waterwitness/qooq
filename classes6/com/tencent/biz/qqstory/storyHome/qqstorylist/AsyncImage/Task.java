package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import ird;
import ire;
import irf;
import irg;
import irh;
import iri;
import irj;
import irk;
import irl;
import irm;
import java.lang.ref.WeakReference;
import java.net.URL;
import mqq.os.MqqHandler;

public class Task
  implements URLDrawable.URLDrawableListener
{
  public static final int a = 1;
  public static final String a = "Q.qqstory.home.Task";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 0;
  public static final int f = 5;
  public static final int g = 6;
  public Drawable a;
  protected Handler a;
  protected ImageCache a;
  public Task.TaskListener a;
  public Transformation a;
  public URLDrawable a;
  public Integer a;
  public WeakReference a;
  protected String b;
  public int h;
  public int i;
  protected int j;
  public int k;
  
  public Task(ImageView paramImageView, URLDrawable paramURLDrawable, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.j = 5;
    this.k = 0;
    SLog.b("Q.qqstory.home.Task", "create the task:" + paramURLDrawable.getURL().toString());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramImageView);
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramImageView.hashCode());
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    this.h = paramInt1;
    this.i = paramInt2;
    this.b = paramString;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(String paramString)
  {
    SLog.b("Q.qqstory.home.Task", "startLoadImageFromLocale:" + paramString);
    if (!StoryListUtils.b(paramString))
    {
      SLog.b("Q.qqstory.home.Task", "It dont have this file:" + paramString);
      ThreadManager.c().post(new iri(this));
    }
    Object localObject2 = (Bitmap)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageCache.get(paramString);
    Object localObject1;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      localObject3 = paramString;
      if (!((Bitmap)localObject2).isRecycled()) {}
    }
    else
    {
      localObject2 = paramString;
      if (paramString.endsWith("/120")) {
        localObject2 = paramString.substring(0, paramString.length() - 4);
      }
      paramString = StoryListUtils.a((String)localObject2, this.h, this.i);
      if (paramString == null)
      {
        SLog.e("Q.qqstory.home.Task", "bitmap is null! reqHeight:" + this.i + ",reqWidth:" + this.h + " ,path=" + (String)localObject2);
        ThreadManager.c().post(new irj(this));
        return;
      }
      localObject1 = paramString;
      localObject3 = localObject2;
      if (paramString.isRecycled())
      {
        SLog.e("Q.qqstory.home.Task", "bitmap have been recycled! path=" + (String)localObject2);
        ThreadManager.c().post(new irk(this));
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation != null) {}
    for (paramString = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation.a((Bitmap)localObject1);; paramString = (String)localObject1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageCache.a((String)localObject3, paramString);
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)
      {
        ThreadManager.c().post(new irl(this, (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject3, this.h, this.i, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation));
        return;
      }
      if (paramString.isRecycled())
      {
        ThreadManager.c().post(new irm(this, (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject3, this.h, this.i, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation));
        return;
      }
      paramString = new BitmapDrawable(((ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources(), paramString);
      ThreadManager.c().post(new ire(this, (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (String)localObject3, this.h, this.i, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation, paramString));
      return;
    }
  }
  
  public int a()
  {
    return this.k;
  }
  
  public ImageView a()
  {
    return (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public Transformation a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation;
  }
  
  public void a()
  {
    SLog.b("Q.qqstory.home.Task", "start task. state=" + this.k + ",url=" + this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString() + ",key=" + this.jdField_a_of_type_JavaLangRefWeakReference.hashCode());
    if (this.k == 1) {
      onLoadCanceled(this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
    this.k = 2;
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString().startsWith("file://"))
    {
      a(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString().replaceFirst("file://", ""));
      return;
    }
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString().startsWith("file:"))
    {
      a(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString().replaceFirst("file:", ""));
      return;
    }
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
    {
      SLog.b("Q.qqstory.home.Task", "task have diskCache. url=" + this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString() + ",key=" + this.jdField_a_of_type_JavaLangRefWeakReference.hashCode());
      this.k = 3;
      onLoadSuccessed(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    SLog.b("Q.qqstory.home.Task", "task need to dowmload and start download. url=" + this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString() + ",key=" + this.jdField_a_of_type_JavaLangRefWeakReference.hashCode());
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload(true);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(ImageCache paramImageCache)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageCache = paramImageCache;
  }
  
  public void a(Task.TaskListener paramTaskListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener = paramTaskListener;
  }
  
  public void a(Transformation paramTransformation)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation = paramTransformation;
  }
  
  public void b()
  {
    SLog.b("Q.qqstory.home.Task", "task cancel.state=" + this.k + ",Url=" + this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString() + ",key=" + this.jdField_a_of_type_JavaLangRefWeakReference.hashCode());
    this.k = 1;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    SLog.b("Q.qqstory.home.Task", "onLoadCanceled:" + paramURLDrawable.getURL().toString() + ",key=" + this.jdField_a_of_type_JavaLangRefWeakReference.hashCode());
    this.k = 5;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener != null)
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a(this.jdField_a_of_type_JavaLangInteger, paramURLDrawable, new Throwable("task have been cancel"));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a((ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    SLog.b("Q.qqstory.home.Task", "onLoadFialed:" + paramURLDrawable.getURL().toString() + ",key=" + this.jdField_a_of_type_JavaLangRefWeakReference.hashCode());
    if (this.k == 1) {
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a(this.jdField_a_of_type_JavaLangInteger, paramURLDrawable, paramThrowable);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a((ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramURLDrawable);
      return;
      if (this.j > 0)
      {
        SLog.b("Q.qqstory.home.Task", "onLoadFialed and retry url=" + paramURLDrawable.getURL().toString() + ",key=" + this.jdField_a_of_type_JavaLangRefWeakReference.hashCode());
        this.j -= 1;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new irh(this), 100L);
        this.k = 6;
        return;
      }
      this.k = 5;
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener == null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a(this.jdField_a_of_type_JavaLangInteger, paramURLDrawable, paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    SLog.b("Q.qqstory.home.Task", "onLoadSuccessed:state=" + this.k + ", url=" + paramURLDrawable.getURL().toString() + ",key=" + this.jdField_a_of_type_JavaLangRefWeakReference.hashCode());
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      ThreadManager.c().post(new ird(this, paramURLDrawable));
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTransformation == null)
      {
        ThreadManager.c().post(new irf(this, paramURLDrawable));
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener == null);
    if (this.k == 1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageTask$TaskListener.a((ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramURLDrawable);
      return;
    }
    this.k = 4;
    new irg(this, paramURLDrawable).a(new URLDrawable[] { paramURLDrawable });
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\AsyncImage\Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */