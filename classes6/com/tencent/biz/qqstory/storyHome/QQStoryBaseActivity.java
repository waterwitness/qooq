package com.tencent.biz.qqstory.storyHome;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import com.tribe.async.dispatch.Subscriber.SubscriberWrapper;
import iqh;
import iqi;
import iqj;
import iqk;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QQStoryBaseActivity
  extends IphoneTitleBarActivity
  implements IEventReceiver
{
  protected final String E;
  protected int U;
  protected int V;
  Animation.AnimationListener a;
  public QQStoryBaseActivity.ProgressView a;
  protected Map a;
  public Dialog b;
  protected Bitmap b;
  protected Handler b;
  protected int[] b;
  public ImageView c;
  protected final boolean h;
  protected boolean i;
  protected boolean j;
  
  public QQStoryBaseActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.E = ("Q.qqstory." + getClass().getSimpleName());
    this.h = false;
    this.i = true;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new iqj(this);
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    QQStoryManager localQQStoryManager;
    SoftReference localSoftReference;
    do
    {
      do
      {
        int k;
        int m;
        int n;
        int i1;
        do
        {
          return;
          k = paramIntent.getIntExtra("positionX", 0);
          m = paramIntent.getIntExtra("positionY", 0);
          n = paramIntent.getIntExtra("viewWidth", -1);
          i1 = paramIntent.getIntExtra("viewHeight", -1);
          this.i = paramIntent.getBooleanExtra("need_image_animation", true);
          paramIntent = paramIntent.getStringExtra("viewImageKey");
        } while ((n < 0) || (i1 < 0));
        this.jdField_b_of_type_ArrayOfInt = new int[4];
        this.jdField_b_of_type_ArrayOfInt[0] = k;
        this.jdField_b_of_type_ArrayOfInt[1] = m;
        this.jdField_b_of_type_ArrayOfInt[2] = n;
        this.jdField_b_of_type_ArrayOfInt[3] = i1;
      } while (TextUtils.isEmpty(paramIntent));
      localQQStoryManager = (QQStoryManager)((QQAppInterface)BaseApplicationImpl.a().a()).getManager(180);
      localSoftReference = (SoftReference)localQQStoryManager.a.get(paramIntent);
    } while ((localSoftReference == null) || (localSoftReference.get() == null));
    this.jdField_b_of_type_AndroidGraphicsBitmap = ((Bitmap)localSoftReference.get());
    localQQStoryManager.a.remove(paramIntent);
  }
  
  public View a(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  public View a(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public ViewGroup.LayoutParams a(View paramView)
  {
    return paramView.getLayoutParams();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    a(paramCharSequence, true, 0L);
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramCharSequence, paramBoolean, 0L);
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong)
  {
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(new iqh(this, this, paramBoolean, paramCharSequence), paramLong);
  }
  
  public void a(Map paramMap)
  {
    paramMap.put(new Subscriber.SubscriberWrapper(Looper.getMainLooper(), new iqk(this, this)), "root_group");
  }
  
  public void b(int paramInt)
  {
    a(getString(paramInt), true, 0L);
  }
  
  protected void b(String paramString) {}
  
  protected void c(String paramString) {}
  
  public boolean d()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    a(getIntent());
    return super.doOnCreate(paramBundle);
  }
  
  public void e()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.post(new iqi(this));
  }
  
  public void f()
  {
    SLog.b(this.E, "onOutOfMemory");
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "QQStoryBaseActivity doEnterAnimation mAnimationPlayedTimes=" + this.V);
    }
    int k = this.U;
    this.U = (k + 1);
    if (k > 0) {}
    do
    {
      Object localObject1;
      View localView;
      do
      {
        do
        {
          return;
        } while ((this.jdField_b_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_ArrayOfInt.length < 4) || (this.V > 0));
        this.V += 1;
        k = this.jdField_b_of_type_ArrayOfInt[0];
        int m = this.jdField_b_of_type_ArrayOfInt[1];
        int n = this.jdField_b_of_type_ArrayOfInt[2];
        int i1 = this.jdField_b_of_type_ArrayOfInt[3];
        localObject1 = (ViewGroup)findViewById(16908290);
        localView = ((ViewGroup)localObject1).getChildAt(0);
        if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (this.i))
        {
          this.c = new ImageView(this);
          this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject2 = new FrameLayout.LayoutParams(-1, -1);
          ((ViewGroup)localObject1).addView(this.c, (ViewGroup.LayoutParams)localObject2);
          this.c.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
        }
        int i2 = localView.getMeasuredWidth();
        int i3 = localView.getMeasuredHeight();
        float f1 = n * 1.0F / i2;
        float f2 = i1 * 1.0F / i3;
        localObject1 = new AnimationSet(true);
        ((AnimationSet)localObject1).setInterpolator(new AccelerateInterpolator());
        ((AnimationSet)localObject1).setRepeatMode(1);
        ((AnimationSet)localObject1).setRepeatCount(1);
        ((AnimationSet)localObject1).setDuration(300L);
        Object localObject2 = new ScaleAnimation(f1, 1.0F, f2, 1.0F, 0.5F, 0.5F);
        ((Animation)localObject2).setInterpolator(new DecelerateInterpolator());
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(k, 0.0F, m, 0.0F);
        localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
        ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
        ((AnimationSet)localObject1).addAnimation(localTranslateAnimation);
        if ((this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.c == null) || (!this.i)) {
          break;
        }
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
        localAlphaAnimation.setRepeatCount(1);
        localAlphaAnimation.setFillAfter(true);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation((Animation)localObject2);
        localAnimationSet.addAnimation(localTranslateAnimation);
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.setRepeatCount(1);
        localAnimationSet.setRepeatMode(1);
        localAnimationSet.setDuration(300L);
        this.c.startAnimation(localAnimationSet);
        localView.startAnimation((Animation)localObject1);
        localAnimationSet.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.pgc", 2, "QQStoryBaseActivity doEnterAnimation animationSet start with origin view");
      return;
      localView.startAnimation((Animation)localObject1);
      ((AnimationSet)localObject1).setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.pgc", 2, "QQStoryBaseActivity doEnterAnimation animationSet start without origin view");
  }
  
  public boolean isValidate()
  {
    return (this.j) && (!isFinishing());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    QQStoryContext.a();
    Object localObject1 = new HashMap();
    a((Map)localObject1);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.putAll((Map)localObject1);
    b("register subscriber size : " + this.jdField_a_of_type_JavaUtilMap.size());
    localObject1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      Dispatchers.get().registerSubscriber((String)localObject2, localSubscriber);
    }
    super.onCreate(paramBundle);
    c("onCreate");
    this.j = true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c("onDestroy");
    this.j = false;
    b("unregister subscriber size : " + this.jdField_a_of_type_JavaUtilMap.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localIterator.next()).getKey();
      Dispatchers.get().unRegisterSubscriber(localSubscriber);
    }
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    c("onPause");
  }
  
  public void onResume()
  {
    super.onResume();
    c("onResume");
  }
  
  public void onStart()
  {
    super.onStart();
    c("onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    c("onStop");
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(null);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\QQStoryBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */