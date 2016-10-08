package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import iqy;
import iqz;
import ira;
import irb;
import java.net.URL;
import java.util.ArrayList;

public class ImageLoader
  implements Task.TaskListener
{
  public static final String a = "Q.qqstory:ImageLoader";
  protected static boolean a;
  protected Drawable a;
  protected Handler a;
  public ImageCache a;
  protected ImageHashMap a;
  protected ArrayList a;
  public ImageHashMap b;
  
  public ImageLoader()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(30);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageHashMap = new ImageHashMap();
    this.b = new ImageHashMap();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-3355444);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.b());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageCache = new ImageCache(4194304);
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 68	com/tencent/biz/qqstory/storyHome/qqstorylist/AsyncImage/ImageLoader:jdField_a_of_type_Boolean	Z
    //   5: ifne +72 -> 77
    //   8: invokestatic 74	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: astore_2
    //   12: ldc 76
    //   14: invokestatic 82	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   17: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifeq +60 -> 80
    //   23: new 90	java/io/File
    //   26: dup
    //   27: getstatic 95	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   30: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_1
    //   34: aload_2
    //   35: new 100	iqx
    //   38: dup
    //   39: aload_0
    //   40: aload_2
    //   41: invokespecial 103	iqx:<init>	(Lcom/tencent/biz/qqstory/storyHome/qqstorylist/AsyncImage/ImageLoader;Landroid/content/Context;)V
    //   44: invokestatic 109	com/tencent/image/URLDrawable:init	(Landroid/content/Context;Lcom/tencent/image/URLDrawableParams;)V
    //   47: new 90	java/io/File
    //   50: dup
    //   51: aload_1
    //   52: ldc 111
    //   54: invokespecial 114	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   57: astore_1
    //   58: new 116	com/tencent/mobileqq/transfile/DiskCache
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 119	com/tencent/mobileqq/transfile/DiskCache:<init>	(Ljava/io/File;)V
    //   66: putstatic 124	com/tencent/mobileqq/startup/step/InitUrlDrawable:a	Lcom/tencent/mobileqq/transfile/DiskCache;
    //   69: aload_1
    //   70: putstatic 129	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Ljava/io/File;
    //   73: iconst_1
    //   74: putstatic 68	com/tencent/biz/qqstory/storyHome/qqstorylist/AsyncImage/ImageLoader:jdField_a_of_type_Boolean	Z
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: aload_2
    //   81: invokevirtual 135	android/content/Context:getCacheDir	()Ljava/io/File;
    //   84: astore_1
    //   85: goto -51 -> 34
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	ImageLoader
    //   33	52	1	localFile	java.io.File
    //   88	4	1	localObject	Object
    //   11	70	2	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    // Exception table:
    //   from	to	target	type
    //   2	34	88	finally
    //   34	77	88	finally
    //   80	85	88	finally
  }
  
  public ImageLoader a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageHashMap.a();
    SLog.b("Q.qqstory:ImageLoader", "clear the imageloader queue");
  }
  
  public void a(ImageView paramImageView, Drawable paramDrawable, Task paramTask)
  {
    SLog.b("Q.qqstory:ImageLoader", "onLoadSuccessed:" + paramTask.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    this.b.b(paramImageView);
    if ((paramDrawable instanceof BitmapDrawable))
    {
      BitmapDrawable localBitmapDrawable = (BitmapDrawable)paramDrawable;
      if (localBitmapDrawable.getBitmap() != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageCache.a(paramTask.b, localBitmapDrawable.getBitmap());
      }
    }
    paramImageView.setImageDrawable(paramDrawable);
    paramImageView.setTag(paramTask.b);
    this.jdField_a_of_type_AndroidOsHandler.post(new iqz(this));
  }
  
  public void a(ImageView paramImageView, URLDrawable paramURLDrawable)
  {
    SLog.b("Q.qqstory:ImageLoader", "onLoadCanceled:" + paramURLDrawable.getURL().toString());
    this.jdField_a_of_type_AndroidOsHandler.post(new irb(this, paramImageView, paramURLDrawable.getURL().toString(), 0, 0, null));
  }
  
  public void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Transformation paramTransformation)
  {
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      if ((paramTransformation != null) && ((paramTransformation instanceof CircleTransformation)))
      {
        paramImageView.setImageResource(2130841377);
        paramImageView.setTag(null);
      }
      for (;;)
      {
        paramImageView.setTag(null);
        return;
        if ((paramTransformation != null) && ((paramTransformation instanceof RoundedTransformation)))
        {
          paramImageView.setImageResource(2130841392);
          paramImageView.setTag(null);
        }
        else
        {
          paramImageView.setImageResource(2130841574);
          paramImageView.setTag(null);
        }
      }
    }
    String str;
    Object localObject;
    if (paramString.startsWith("file://"))
    {
      str = paramString.replaceFirst("file://", "");
      localObject = str;
      if (str.endsWith("/120")) {
        localObject = str.substring(0, str.length() - 4);
      }
      localObject = (Bitmap)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageCache.get(localObject);
    }
    while (localObject != null)
    {
      paramImageView.setImageDrawable(new BitmapDrawable(paramImageView.getResources(), (Bitmap)localObject));
      paramImageView.setTag(paramString);
      return;
      if (paramString.startsWith("file:"))
      {
        str = paramString.replaceFirst("file:", "");
        localObject = str;
        if (str.endsWith("/120")) {
          localObject = str.substring(0, str.length() - 4);
        }
        localObject = (Bitmap)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageCache.get(localObject);
      }
      else
      {
        localObject = (Bitmap)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageCache.get(paramString);
      }
    }
    if ((paramTransformation != null) && ((paramTransformation instanceof CircleTransformation)))
    {
      paramImageView.setImageResource(2130841377);
      paramImageView.setTag(null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new iqy(this, paramImageView, paramString, paramInt1, paramInt2, paramTransformation));
      return;
      if ((paramTransformation != null) && ((paramTransformation instanceof RoundedTransformation)))
      {
        paramImageView.setImageResource(2130841392);
        paramImageView.setTag(null);
      }
    }
  }
  
  public void a(ImageView paramImageView, String paramString, Transformation paramTransformation)
  {
    a(paramImageView, paramString, 0, 0, paramTransformation);
  }
  
  public void a(Task paramTask)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageHashMap.a(paramTask.jdField_a_of_type_JavaLangInteger) != null)
    {
      SLog.b("Q.qqstory:ImageLoader", "it have the same task in waiting task list:" + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageHashMap.a(paramTask.jdField_a_of_type_JavaLangInteger).jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString() + ",key=" + paramTask.jdField_a_of_type_JavaLangInteger);
      a(paramTask);
    }
    Task localTask = this.b.a(paramTask.jdField_a_of_type_JavaLangInteger);
    if (localTask != null)
    {
      SLog.b("Q.qqstory:ImageLoader", "it have the same task in running task list:" + localTask.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString() + ",key=" + localTask.jdField_a_of_type_JavaLangInteger);
      localTask.b();
      this.b.b(localTask.jdField_a_of_type_JavaLangInteger);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramTask);
    SLog.b("Q.qqstory:ImageLoader", "add to waiting task list:" + paramTask.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString() + ",key=" + paramTask.jdField_a_of_type_JavaLangRefWeakReference.hashCode());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageHashMap.a(paramTask.a(), paramTask);
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (this.jdField_a_of_type_JavaUtilArrayList.size() < 5)) {
      b();
    }
  }
  
  public void a(Integer paramInteger, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    SLog.b("Q.qqstory:ImageLoader", "onLoadFialed:" + paramThrowable.getMessage() + ",url=" + paramURLDrawable.getURL().toString());
    this.b.b(paramInteger);
    this.jdField_a_of_type_AndroidOsHandler.post(new ira(this));
  }
  
  public void a(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    if (paramString.getStatus() == 1)
    {
      paramURLDrawableListener.onLoadSuccessed(paramString);
      return;
    }
    paramString.setURLDrawableListener(paramURLDrawableListener);
    paramString.startDownload();
  }
  
  public boolean a(Task paramTask)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((Task)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangRefWeakReference == paramTask.jdField_a_of_type_JavaLangRefWeakReference)
        {
          SLog.b("Q.qqstory:ImageLoader", "remove the task from queue:" + ((Task)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
          if (((Task)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
            ((Task)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b();
          }
          if (paramTask.a() != null)
          {
            paramTask.a().setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            paramTask.a().setTag(null);
          }
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageHashMap.b(((Task)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangInteger);
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public void b()
  {
    Task localTask;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localTask = (Task)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (((Task)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a() == null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageHashMap.b(((Task)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangInteger);
        SLog.b("Q.qqstory:ImageLoader", "Image view have been recyle !run task.taskQueue size is " + this.jdField_a_of_type_JavaUtilArrayList.size() + ",running task list size=" + this.b.a());
      }
    }
    else
    {
      return;
    }
    this.b.a(((Task)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a(), (Task)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageImageHashMap.b(((Task)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangInteger);
    this.jdField_a_of_type_JavaUtilArrayList.remove(0);
    localTask.a();
    SLog.b("Q.qqstory:ImageLoader", "run task.taskQueue size is " + this.jdField_a_of_type_JavaUtilArrayList.size() + ",running task list size=" + this.b.a());
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\AsyncImage\ImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */