package com.tencent.mobileqq.surfaceviewaction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import uxq;
import uxs;

public class SpriteSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private static final String jdField_a_of_type_JavaLangString = "SpriteSurfaceView";
  protected float a;
  protected int a;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  protected SpriteSurfaceView.ISpriteSurfaceViewCallBack a;
  private Object jdField_a_of_type_JavaLangObject;
  public List a;
  private uxs jdField_a_of_type_Uxs;
  public boolean a;
  protected int b;
  private Object jdField_b_of_type_JavaLangObject;
  private List jdField_b_of_type_JavaUtilList;
  private final int jdField_c_of_type_Int;
  private List jdField_c_of_type_JavaUtilList;
  private int d;
  
  public SpriteSurfaceView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_c_of_type_Int = 60;
    this.d = 16;
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_c_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-3);
    this.jdField_a_of_type_Float = 1.0F;
    if (QLog.isColorLevel()) {
      QLog.d("SpriteSurfaceView", 2, "surfaceview init");
    }
  }
  
  public SpriteSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = 60;
    this.d = 16;
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_c_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-3);
    this.jdField_a_of_type_Float = 1.0F;
    if (QLog.isColorLevel()) {
      QLog.d("SpriteSurfaceView", 2, "surfaceview init");
    }
  }
  
  public ReentrantLock a()
  {
    try
    {
      Object localObject = SurfaceView.class.getDeclaredField("mSurfaceLock");
      ((Field)localObject).setAccessible(true);
      localObject = (ReentrantLock)((Field)localObject).get(this);
      return (ReentrantLock)localObject;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SpriteSurfaceView", 2, localNoSuchFieldException.getMessage(), localNoSuchFieldException);
      }
      return null;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SpriteSurfaceView", 2, localIllegalArgumentException.getMessage(), localIllegalArgumentException);
      }
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SpriteSurfaceView", 2, localIllegalAccessException.getMessage(), localIllegalAccessException);
      }
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SpriteSurfaceView", 2, "stopDraw");
    }
    if (this.jdField_a_of_type_Uxs != null) {
      this.jdField_a_of_type_Uxs.a = true;
    }
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt, Sprite paramSprite)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      if (this.jdField_b_of_type_JavaUtilList.get(i) == paramSprite) {
        return;
      }
      i += 1;
    }
    this.jdField_b_of_type_JavaUtilList.add(paramInt, paramSprite);
  }
  
  public void a(Sprite paramSprite)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      if (this.jdField_b_of_type_JavaUtilList.get(i) == paramSprite) {
        return;
      }
      i += 1;
    }
    this.jdField_b_of_type_JavaUtilList.add(paramSprite);
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_JavaUtilList.add(paramRunnable);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_JavaUtilList.isEmpty();
  }
  
  public boolean a(Sprite paramSprite)
  {
    return this.jdField_b_of_type_JavaUtilList.contains(paramSprite);
  }
  
  public void b(Sprite paramSprite)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        if (this.jdField_b_of_type_JavaUtilList.get(i) == paramSprite) {
          this.jdField_b_of_type_JavaUtilList.remove(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView$ISpriteSurfaceViewCallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView$ISpriteSurfaceViewCallBack.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      if (((this.jdField_b_of_type_JavaUtilList.get(i) instanceof uxq)) && (((uxq)this.jdField_b_of_type_JavaUtilList.get(i)).a(paramMotionEvent))) {
        return true;
      }
      i += 1;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCallBack(SpriteSurfaceView.ISpriteSurfaceViewCallBack paramISpriteSurfaceViewCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionSpriteSurfaceView$ISpriteSurfaceViewCallBack = paramISpriteSurfaceViewCallBack;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_Uxs = new uxs(this, null);
    ThreadManager.a(this.jdField_a_of_type_Uxs, 10, null, true);
  }
  
  public void surfaceDestroyed(SurfaceHolder arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SpriteSurfaceView", 2, "surfaceDestroyed");
    }
    if (this.jdField_a_of_type_Uxs != null) {
      this.jdField_a_of_type_Uxs.a = true;
    }
    if (!TroopGiftUtil.a(this.jdField_a_of_type_JavaUtilList)) {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Collections.sort(this.jdField_a_of_type_JavaUtilList);
        float f1 = 0.0F;
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          float f2 = ((Float)this.jdField_a_of_type_JavaUtilList.get(i)).floatValue();
          i += 1;
          f1 += f2;
        }
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_gift_animation", "fps", 0, (int)(f1 / this.jdField_a_of_type_JavaUtilList.size()), String.valueOf(this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)), String.valueOf(this.jdField_a_of_type_JavaUtilList.get(0)), "", "");
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\surfaceviewaction\SpriteSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */