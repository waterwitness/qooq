package com.tencent.biz.now;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewParent;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgItemLive;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import hkg;
import hki;
import hkj;
import hkl;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class NowVideoView
  extends PAImageView
  implements Observer
{
  public static final int a = 3;
  public static EmptyDrawable a;
  public static final String a = "NowVideoView";
  public static final int d = 1001;
  public static final int e = 1002;
  public static final int f = 1003;
  public static int k;
  public long a;
  public Handler a;
  public RotateAnimation a;
  public ImageView a;
  public NowLiveManager a;
  public NowVideoView.ThirdDataSourceAdapter a;
  QQLiveDrawable.OnStateListener jdField_a_of_type_ComTencentImageQQLiveDrawable$OnStateListener = new hkj(this);
  QQLiveDrawable.QQLiveDrawableParams jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public MessageRecord a;
  Thread jdField_a_of_type_JavaLangThread = new hkl(this);
  public List a;
  public AtomicBoolean a;
  public boolean a;
  int b;
  public long b;
  public String b;
  int c;
  public String c;
  public String d;
  public String e;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  int l = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable = new EmptyDrawable(-2236446, 100, 100);
  }
  
  public NowVideoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new hki(this);
    this.jdField_a_of_type_ComTencentBizNowNowVideoView$ThirdDataSourceAdapter = new NowVideoView.ThirdDataSourceAdapter(this);
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
    NowVideoController.a().a(this);
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqlive://msgId=").append(paramString);
    return localStringBuilder.toString();
  }
  
  public Drawable a(String paramString)
  {
    Object localObject = jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localObject = URLDrawable.getDrawable(paramString, jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable, jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable);
      return (Drawable)localObject;
    }
    catch (Exception paramString) {}
    return jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
  }
  
  QQLiveDrawable.QQLiveDrawableParams a()
  {
    if (this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams == null) {
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams = new QQLiveDrawable.QQLiveDrawableParams();
    }
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams;
    if (this.jdField_b_of_type_Int == 0)
    {
      m = 400;
      localQQLiveDrawableParams.mPreviewWidth = m;
      localQQLiveDrawableParams = this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams;
      if (this.jdField_c_of_type_Int != 0) {
        break label151;
      }
    }
    label151:
    for (int m = 200;; m = this.jdField_c_of_type_Int)
    {
      localQQLiveDrawableParams.mPreviewHeight = m;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mPlayPause = false;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mListener = this.jdField_a_of_type_ComTencentImageQQLiveDrawable$OnStateListener;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mDataSourceType = 2;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mDataSourceAdapter = this.jdField_a_of_type_ComTencentBizNowNowVideoView$ThirdDataSourceAdapter;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mDataSource = this.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mCoverUrl = this.d;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mCoverLoadingDrawable = jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
      this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams.mPlayType = 1;
      return this.jdField_a_of_type_ComTencentImageQQLiveDrawable$QQLiveDrawableParams;
      m = this.jdField_b_of_type_Int;
      break;
    }
  }
  
  public QQLiveDrawable a()
  {
    if ((getDrawable() != null) && ((getDrawable() instanceof URLDrawable)))
    {
      URLDrawable localURLDrawable = (URLDrawable)getDrawable();
      if ((localURLDrawable.getStatus() == 1) && ((localURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
        return (QQLiveDrawable)localURLDrawable.getCurrDrawable();
      }
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      c();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NowVideoView", 2, "onVideoStateChange pre = " + paramInt1 + " cur = " + paramInt2);
    }
    if (paramInt2 == 5) {
      this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time, true);
    }
  }
  
  public void a(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public void a(QQAppInterface paramQQAppInterface, StructMsgItemLive paramStructMsgItemLive, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (paramMessageRecord.uniseq == this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Int = paramStructMsgItemLive.i;
    this.jdField_c_of_type_Int = paramStructMsgItemLive.j;
    if (this.jdField_b_of_type_Int == 0)
    {
      this.jdField_c_of_type_Int = 800;
      this.jdField_b_of_type_Int = 640;
    }
    this.jdField_b_of_type_JavaLangString = paramStructMsgItemLive.o;
    this.jdField_c_of_type_JavaLangString = paramStructMsgItemLive.s;
    this.d = paramStructMsgItemLive.p;
    if ((paramMessageRecord != null) && (paramMessageRecord.uniseq == 0L)) {
      this.e = UUID.randomUUID().toString();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      if (this.jdField_a_of_type_ComTencentBizNowNowLiveManager == null) {
        this.jdField_a_of_type_ComTencentBizNowNowLiveManager = ((NowLiveManager)paramQQAppInterface.getManager(170));
      }
      setImageDrawable(a(this.d));
      if (k == 0) {
        k = getResources().getDimensionPixelSize(2131492908);
      }
      this.jdField_a_of_type_ComTencentBizNowNowLiveManager.addObserver(this);
      this.jdField_a_of_type_JavaUtilList.clear();
      if (this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
        NowVideoController.a().a();
      }
      this.i = 0;
      this.j = 0;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      }
      this.h = 0;
      this.g = 0;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
      if (paramMessageRecord != null) {
        this.e = ("" + paramMessageRecord.uniseq);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.l < 3))
    {
      b();
      this.l += 1;
      return;
    }
    b();
  }
  
  public boolean a(int paramInt)
  {
    ViewParent localViewParent = getParent();
    if ((paramInt == 3) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839556);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    if ((localViewParent != null) && ((localViewParent instanceof NowVideoLayout)))
    {
      ((NowVideoLayout)localViewParent).a(paramInt);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    int m = 2;
    if (!NetworkUtil.h(getContext())) {
      QQToast.a(getContext(), 1, 2131369008, 0).b(k);
    }
    for (;;)
    {
      return;
      if (!this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time))
      {
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
        for (;;)
        {
          a(m);
          d();
          return;
          m = 3;
        }
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
      if ((((hkg)localObject1).jdField_a_of_type_Int == 2) || (((hkg)localObject1).jdField_a_of_type_Int == 1))
      {
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
        for (;;)
        {
          a(m);
          d();
          return;
          m = 3;
        }
      }
      this.jdField_a_of_type_JavaUtilList = new ArrayList(((hkg)localObject1).jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time, true);
        return;
      }
      localObject1 = a();
      if (localObject1 != null)
      {
        ((QQLiveDrawable)localObject1).resume();
        return;
      }
      Object localObject2 = a();
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = a(this.d);
      localObject2 = a(this.e);
      try
      {
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        setImageDrawable((Drawable)localObject1);
        localObject1 = a();
        if (localObject1 != null)
        {
          ((QQLiveDrawable)localObject1).resume();
          return;
        }
      }
      catch (Exception localException)
      {
        a();
      }
    }
  }
  
  public void c()
  {
    Object localObject1 = a();
    if (localObject1 != null) {
      ((QQLiveDrawable)localObject1).pause();
    }
    for (;;)
    {
      return;
      Object localObject2 = a();
      ((QQLiveDrawable.QQLiveDrawableParams)localObject2).mPlayPause = true;
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
      localObject2 = a(this.e);
      try
      {
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        if ((((URLDrawable)localObject1).getStatus() == 1) && (a() != null))
        {
          setImageDrawable((Drawable)localObject1);
          return;
        }
        setImageDrawable(a(this.d));
        if (this.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839556);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void d()
  {
    try
    {
      c();
      setImageDrawable(a(this.d));
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839556);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.h == 2)) {
      ThreadManager.a(this.jdField_a_of_type_JavaLangThread, 5, null, true);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentBizNowNowLiveManager != null)
    {
      this.jdField_a_of_type_ComTencentBizNowNowLiveManager.deleteObserver(this);
      localObject = this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
      if (localObject != null) {
        ((hkg)localObject).jdField_a_of_type_JavaUtilList.clear();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    Object localObject = a();
    if (localObject != null)
    {
      ((QQLiveDrawable)localObject).setOnStateListener(null);
      ((QQLiveDrawable)localObject).setParams(null);
      ((QQLiveDrawable)localObject).recyleAndKeepPostion();
    }
    localObject = a();
    if (localObject != null)
    {
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mListener = null;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDataSourceAdapter = null;
    }
    setImageDrawable(null);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
    this.h = 0;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int m = ((Integer)paramObject[0]).intValue();
    boolean bool = ((Boolean)paramObject[1]).booleanValue();
    paramObservable = (hkg)paramObject[2];
    if (paramObservable == null) {}
    label40:
    do
    {
      do
      {
        do
        {
          break label40;
          break label40;
          break label40;
          break label40;
          break label40;
          do
          {
            return;
          } while ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin.equals(paramObservable.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time != paramObservable.jdField_a_of_type_Long));
          if (!bool) {
            break label517;
          }
          if (m != 1001) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time));
        paramObservable = paramObservable.jdField_a_of_type_JavaUtilList;
        if ((paramObservable == null) || (paramObservable.size() <= 0)) {
          break;
        }
        this.jdField_a_of_type_JavaUtilList = new ArrayList(paramObservable);
      } while (this.jdField_a_of_type_ComTencentBizNowNowVideoView$ThirdDataSourceAdapter.a());
      a(1);
      b();
      return;
      d();
      return;
    } while (m != 1003);
    m = paramObservable.jdField_a_of_type_Int;
    paramObject = (Bundle)paramObject[3];
    if (paramObject != null) {}
    for (bool = ((Bundle)paramObject).getBoolean("needReqUrl");; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NowVideoView", 2, "updateStatus state = " + m);
      }
      if ((m == 1) || (m == 2))
      {
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
        for (m = 2;; m = 3)
        {
          a(m);
          d();
          return;
        }
      }
      if (m == 3)
      {
        if (this.i < 3)
        {
          long l1 = (new Random(System.currentTimeMillis()).nextInt(6) + 5) * 1000;
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, l1);
          this.i += 1;
        }
        while (this.jdField_a_of_type_AndroidWidgetImageView != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839556);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          return;
          d();
        }
        break label40;
      }
      if (m != 0) {
        break;
      }
      a(1);
      if ((!NowVideoController.a().a(getContext(), this)) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839556);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      if (!bool) {
        break;
      }
      if (this.j < 3)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList(paramObservable.jdField_a_of_type_JavaUtilList);
        if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
          this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time);
        }
        this.i += 1;
        return;
      }
      QQToast.a(getContext(), 1, "播放失败,请稍后再试!", 1).a();
      return;
      label517:
      if ((m != 1001) || (!this.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time))) {
        break;
      }
      d();
      QQToast.a(getContext(), "请求失败", 0).a();
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839553);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\now\NowVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */