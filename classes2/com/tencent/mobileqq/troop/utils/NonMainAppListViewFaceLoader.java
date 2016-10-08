package com.tencent.mobileqq.troop.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import voh;
import voi;

public class NonMainAppListViewFaceLoader
  implements AbsListView.OnScrollListener
{
  protected static final long a = 350L;
  protected static final String a = "NonMainAppListViewFaceLoader";
  protected static final String b = "com.tencent.qqhead.getheadreq";
  protected static final int c = 60;
  protected static final String c = "com.tencent.qqhead.getheadresp";
  protected static final int d = 1000;
  protected static final String d = "com.tencent.qqhead.permission.getheadresp";
  protected static final int e = 1001;
  protected static final int f = 1002;
  protected float a;
  public int a;
  private BroadcastReceiver a;
  protected Context a;
  protected Bitmap a;
  protected Handler a;
  protected HandlerThread a;
  public LruCache a;
  protected NonMainAppListViewFaceLoader.DecodeHandler a;
  protected AbsListView.OnScrollListener a;
  public ListView a;
  public ArrayList a;
  public int b;
  public LruCache b;
  protected int g;
  protected int h;
  
  public NonMainAppListViewFaceLoader(Context paramContext, ListView paramListView, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(60);
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(120);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new voh(this);
    this.jdField_a_of_type_AndroidOsHandler = new voi(this, Looper.getMainLooper());
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentWidgetListView.setOnScrollListener(this);
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("NonMainAppListViewFaceLoader");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader$DecodeHandler = new NonMainAppListViewFaceLoader.DecodeHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    paramContext = new IntentFilter();
    paramContext.addAction("com.tencent.qqhead.getheadresp");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramContext, "com.tencent.qqhead.permission.getheadresp", null);
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
  }
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    int j = this.g;
    int i = this.h;
    float f2 = this.jdField_a_of_type_Float;
    int k = paramBitmap.getWidth();
    float f1 = f2;
    if (k > 0)
    {
      f1 = f2;
      if (k < j * f2) {
        f1 = k / j;
      }
    }
    j = (int)(j * f1);
    i = (int)(f1 * i);
    return ImageUtil.a(paramBitmap, j, j, i);
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    for (;;)
    {
      try
      {
        localObject = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
        if (localObject != null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, hit cache:" + paramString);
          return (Bitmap)localObject;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, not in cache:" + paramString);
        }
        if (this.jdField_a_of_type_Int == 0)
        {
          if (TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString))) {
            continue;
          }
          localObject = Message.obtain();
          ((Message)localObject).obj = paramString;
          ((Message)localObject).what = 1001;
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader$DecodeHandler.sendMessage((Message)localObject);
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NonMainAppListViewFaceLoader", 2, "getFaceBitmap, exception:" + paramString.toString());
        continue;
      }
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)))
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 350L);
      }
    }
    return (Bitmap)localObject;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppListViewFaceLoader", 2, "sendQQHeadRequest, reqSize:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " cacheSize:" + this.jdField_a_of_type_AndroidSupportV4UtilLruCache.size() + " " + this.jdField_b_of_type_AndroidSupportV4UtilLruCache.size());
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      return;
    }
    Intent localIntent = new Intent("com.tencent.qqhead.getheadreq");
    localIntent.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
    localIntent.putExtra("faceType", this.jdField_b_of_type_Int);
    localIntent.putStringArrayListExtra("uinList", this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent, "com.tencent.qqhead.permission.getheadresp");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("NonMainAppListViewFaceLoader", 2, "onScrollStateChanged, curState:" + this.jdField_a_of_type_Int);
      }
      if (paramInt == 0)
      {
        a(true);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 350L);
      }
      while (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null)
      {
        this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt);
        return;
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppListViewFaceLoader", 2, "refreshListFace, add2Request:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
        if ((localObject instanceof FacePreloadBaseAdapter.ViewHolder))
        {
          localObject = (FacePreloadBaseAdapter.ViewHolder)localObject;
          if ((localObject != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject).b != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject).b.length() > 0)) {
            ((FacePreloadBaseAdapter.ViewHolder)localObject).d.setImageBitmap(a(((FacePreloadBaseAdapter.ViewHolder)localObject).b, paramBoolean));
          }
        }
        i += 1;
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppListViewFaceLoader", 2, "destroy");
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_AndroidOsHandlerThread.quit();
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader$DecodeHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_ComTencentWidgetListView = null;
          this.jdField_b_of_type_AndroidSupportV4UtilLruCache.evictAll();
          this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
          return;
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.e("NonMainAppListViewFaceLoader", 2, "destroy:" + localException1.toString());
          }
        }
      }
      catch (Exception localException2)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("NonMainAppListViewFaceLoader", 2, "destroy:" + localException2.toString());
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\NonMainAppListViewFaceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */