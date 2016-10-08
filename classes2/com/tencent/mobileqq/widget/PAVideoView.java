package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdDataSourceAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.ErrorInfo;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgVideoController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.qphone.base.util.QLog;
import wmw;
import wmx;
import wmy;

public class PAVideoView
  extends BubbleImageView
  implements QQLiveDrawable.OnStateListener
{
  public static EmptyDrawable a;
  public static final float b = 1.777F;
  public static final float c = 0.83F;
  public static final int e = 5000;
  public static int f = 0;
  private static final String f = "PAVideoView";
  public static int g;
  public long a;
  public Handler a;
  public View a;
  public RotateAnimation a;
  public ImageView a;
  public ReadinjoyVideoReportData a;
  public StructMsgItemVideo a;
  public String a;
  protected wmy a;
  private long jdField_b_of_type_Long = -1L;
  private Shader jdField_b_of_type_AndroidGraphicsShader;
  public Handler b;
  public String b;
  public String c = "";
  public int d;
  public String d;
  public boolean d;
  public String e;
  private boolean e;
  public int h = jdField_f_of_type_Int;
  public int i;
  public int j;
  public int k;
  public int l;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    QQLiveImage.setDebugEnable(false);
    g = 1;
    jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable = new EmptyDrawable(-2236446, 100, 100);
  }
  
  public PAVideoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_d_of_type_Int = ((int)(Math.random() * 1000.0D));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqlive://msgId=").append(paramLong);
    return localStringBuilder.toString();
  }
  
  public int a()
  {
    return VideoReporter.a(this.l, this.jdField_e_of_type_JavaLangString);
  }
  
  public Shader a()
  {
    return this.jdField_b_of_type_AndroidGraphicsShader;
  }
  
  public Drawable a(String paramString)
  {
    EmptyDrawable localEmptyDrawable = jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
    if (!TextUtils.isEmpty(paramString)) {}
    do
    {
      try
      {
        paramString = URLDrawable.getDrawable(paramString, jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable, jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable);
        return paramString;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PAVideoView" + this.jdField_d_of_type_Int, 2, "getCoverDrawable():  getDrawable Exception, mCoverUrl=" + this.jdField_a_of_type_JavaLangString, paramString);
        }
        return jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
      }
      paramString = localEmptyDrawable;
    } while (!QLog.isColorLevel());
    QLog.e("PAVideoView" + this.jdField_d_of_type_Int, 2, "getCoverDrawable():  mCoverUrl=" + this.jdField_a_of_type_JavaLangString);
    return localEmptyDrawable;
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
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    setImageDrawable(a(this.jdField_a_of_type_JavaLangString));
    if (QLog.isColorLevel()) {
      QLog.d("PAVideoView" + this.jdField_d_of_type_Int, 2, "showCover():  mVid=" + this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void a(View paramView, ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public void a(StructMsgItemVideo paramStructMsgItemVideo)
  {
    this.i = paramStructMsgItemVideo.k;
    this.j = paramStructMsgItemVideo.l;
    this.jdField_a_of_type_JavaLangString = paramStructMsgItemVideo.s;
    this.jdField_b_of_type_JavaLangString = paramStructMsgItemVideo.cY;
    this.jdField_a_of_type_Long = paramStructMsgItemVideo.a.message.uniseq;
    this.k = paramStructMsgItemVideo.a.uinType;
    this.l = paramStructMsgItemVideo.n;
    this.jdField_d_of_type_JavaLangString = paramStructMsgItemVideo.dd;
    if ((paramStructMsgItemVideo.a instanceof AbsShareMsg)) {
      this.jdField_e_of_type_JavaLangString = ((AbsShareMsg)paramStructMsgItemVideo.a).mSourceName;
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo = paramStructMsgItemVideo;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    Object localObject = a();
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAVideoView" + this.jdField_d_of_type_Int, 2, "pausePlay(): 1. cur video pause, mVid=" + this.jdField_b_of_type_JavaLangString);
      }
      ((QQLiveDrawable)localObject).pause();
      return;
    }
    localObject = new QQLiveDrawable.QQLiveDrawableParams();
    int m;
    if (this.i == 0)
    {
      m = 400;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPreviewWidth = m;
      if (this.j != 0) {
        break label286;
      }
      m = 200;
      label126:
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPreviewHeight = m;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPlayPause = true;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mListener = this;
      if (this.l != 2) {
        break label294;
      }
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDataSourceType = 2;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDataSourceAdapter = new ThirdDataSourceAdapter();
    }
    for (;;)
    {
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDataSource = this.jdField_b_of_type_JavaLangString;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mCoverUrl = this.jdField_a_of_type_JavaLangString;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mCoverLoadingDrawable = jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mExtraInfo = localObject;
      localObject = URLDrawable.getDrawable(a(this.jdField_a_of_type_Long), localURLDrawableOptions);
      if (((URLDrawable)localObject).getStatus() != 1) {
        break label302;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PAVideoView" + this.jdField_d_of_type_Int, 2, "pausePlay(): 2. cache video Pause , mVid=" + this.jdField_b_of_type_JavaLangString);
      }
      setImageDrawable((Drawable)localObject);
      return;
      m = this.i;
      break;
      label286:
      m = this.j;
      break label126;
      label294:
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDataSourceType = 0;
    }
    label302:
    if (QLog.isColorLevel()) {
      QLog.d("PAVideoView" + this.jdField_d_of_type_Int, 2, "pausePlay(): 3. set cover, mVid=" + this.jdField_b_of_type_JavaLangString);
    }
    setImageDrawable(a(this.jdField_a_of_type_JavaLangString));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = new ReadinjoyVideoReportData();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_f_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Int = this.l;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    PublicAccountUtil.a(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 0, 0);
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      if (this.jdField_a_of_type_Wmy == null) {
        this.jdField_a_of_type_Wmy = new wmy(this, this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_Wmy);
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_Wmy, 5000L);
    }
    boolean bool1 = NetworkUtils.isWifiConnected(getContext());
    boolean bool2 = NetworkUtils.isMobileConnected(getContext());
    if (bool1) {
      VideoReporter.a("0X80065E0", this.k, a(), this.jdField_b_of_type_JavaLangString, "");
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.b)
      {
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a.message.frienduin, "0X800682E", "0X800682E", 0, 0, this.jdField_b_of_type_JavaLangString, "" + this.l, "" + this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a.msgId, "");
        this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.b = true;
      }
      localObject1 = a();
      if (localObject1 == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PAVideoView" + this.jdField_d_of_type_Int, 2, "startPlay(): 1 cur video resume, mVid=" + this.jdField_b_of_type_JavaLangString);
      }
      ((QQLiveDrawable)localObject1).resume();
      return;
      if (bool2) {
        VideoReporter.a("0X80065E1", this.k, a(), this.jdField_b_of_type_JavaLangString, "");
      }
    }
    Object localObject1 = new QQLiveDrawable.QQLiveDrawableParams();
    int m;
    if (this.i == 0)
    {
      m = 400;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject1).mPreviewWidth = m;
      if (this.j != 0) {
        break label666;
      }
      m = 200;
      label403:
      ((QQLiveDrawable.QQLiveDrawableParams)localObject1).mPreviewHeight = m;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject1).mPlayPause = false;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject1).mListener = this;
      if (this.l != 2) {
        break label674;
      }
      ((QQLiveDrawable.QQLiveDrawableParams)localObject1).mDataSourceType = 2;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject1).mDataSourceAdapter = new ThirdDataSourceAdapter();
    }
    for (;;)
    {
      ((QQLiveDrawable.QQLiveDrawableParams)localObject1).mDataSource = this.jdField_b_of_type_JavaLangString;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject1).mCoverUrl = this.jdField_a_of_type_JavaLangString;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject1).mCoverLoadingDrawable = jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
      Object localObject2 = StructMsgVideoController.a();
      if ((((StructMsgVideoController)localObject2).jdField_a_of_type_Long == this.jdField_a_of_type_Long) && (((StructMsgVideoController)localObject2).c != -1))
      {
        ((QQLiveDrawable.QQLiveDrawableParams)localObject1).mStartPosi = ((StructMsgVideoController)localObject2).c;
        if (QLog.isColorLevel()) {
          QLog.w("PAVideoView" + this.jdField_d_of_type_Int, 2, "startPlay(): need continue play! mVid=" + this.jdField_b_of_type_JavaLangString);
        }
        ((StructMsgVideoController)localObject2).c = -1;
        ((StructMsgVideoController)localObject2).jdField_a_of_type_Long = -1L;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localObject1;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = a(this.jdField_a_of_type_JavaLangString);
      localObject1 = URLDrawable.getDrawable(a(this.jdField_a_of_type_Long), (URLDrawable.URLDrawableOptions)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("PAVideoView" + this.jdField_d_of_type_Int, 2, "startPlay(): 2 new or reuse cache, mVid=" + this.jdField_b_of_type_JavaLangString);
      }
      setImageDrawable((Drawable)localObject1);
      return;
      m = this.i;
      break;
      label666:
      m = this.j;
      break label403;
      label674:
      ((QQLiveDrawable.QQLiveDrawableParams)localObject1).mDataSourceType = 0;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (QLog.isDevelopLevel()) {
      QLog.d("PAVideoView" + this.jdField_d_of_type_Int, 4, "=> onAttachedToWindow(): ");
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isDevelopLevel()) {
      QLog.d("PAVideoView" + this.jdField_d_of_type_Int, 4, "<= onDetachedFromWindow(): ");
    }
    QQLiveDrawable localQQLiveDrawable = a();
    if (localQQLiveDrawable != null) {
      localQQLiveDrawable.recyleAndKeepPostion();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_b_of_type_Long != -1L)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_b_of_type_Long;
      VideoReporter.a("0X80069BF", this.k, a(), this.jdField_b_of_type_JavaLangString, "" + (l1 - l2));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight();
    float f1 = 1.777F;
    if (this.h == g) {
      f1 = 0.83F;
    }
    int i1;
    int n;
    if (this.jdField_d_of_type_Boolean) {
      if (this.h == jdField_f_of_type_Int)
      {
        paramInt2 = BaseChatItemLayout.h - BaseChatItemLayout.n;
        paramInt1 = (int)(paramInt2 / f1 + 0.5F);
        i1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        n = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        m = paramInt2;
        paramInt2 = paramInt1;
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("PAVideoView" + this.jdField_d_of_type_Int, 4, "onMeasure(): width=" + m + ", height=" + paramInt2);
      }
      super.onMeasure(i1, n);
      return;
      paramInt1 = BaseChatItemLayout.h - BaseChatItemLayout.n;
      paramInt2 = (int)(f1 * paramInt1 + 0.5F);
      break;
      paramInt2 = (int)(m / f1 + 0.5F);
      n = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      i1 = paramInt1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_b_of_type_AndroidGraphicsShader == null)
    {
      paramInt1 = AIOUtils.a(55.0F, getResources());
      if (!this.jdField_d_of_type_Boolean) {
        break label138;
      }
      if (this.h != jdField_f_of_type_Int) {
        break label114;
      }
      paramInt1 = AIOUtils.a(55.0F, getResources());
    }
    for (;;)
    {
      float f1 = paramInt2 - paramInt1;
      float f2 = paramInt2;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      this.jdField_b_of_type_AndroidGraphicsShader = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { 0, -1728053248 }, new float[] { 0.0F, 1.0F }, localTileMode);
      return;
      label114:
      if (this.h == g)
      {
        paramInt1 = AIOUtils.a(75.0F, getResources());
        continue;
        label138:
        paramInt1 = (int)(paramInt2 * 0.6F);
      }
    }
  }
  
  public void onStateChange(int paramInt, Object paramObject)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PAVideoView" + this.jdField_d_of_type_Int, 2, "onStateChange(): onStateChange ==> " + QQLiveImage.getStateStr(paramInt) + ", mVid = " + this.jdField_b_of_type_JavaLangString);
      }
      if (paramInt == 3)
      {
        if (this.jdField_a_of_type_AndroidViewAnimationRotateAnimation == null)
        {
          this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
          this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(500L);
          this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
          this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(1);
          this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setStartTime(-1L);
          paramObject = new LinearInterpolator();
          this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator((Interpolator)paramObject);
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new wmw(this, (ImageView)localObject), 1000L);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.c == 0L) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.c = SystemClock.uptimeMillis();
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.e == 0L) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.e = SystemClock.uptimeMillis();
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long > 0L)
          {
            paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
            ((ReadinjoyVideoReportData)paramObject).jdField_b_of_type_Long += SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = 0L;
          }
          paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          ((ReadinjoyVideoReportData)paramObject).jdField_b_of_type_Int += 1;
        }
      }
      do
      {
        do
        {
          return;
          if (paramInt != 2) {
            break;
          }
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          ((ImageView)localObject).clearAnimation();
          ((ImageView)localObject).setVisibility(8);
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData == null);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.e > 0L)
        {
          paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          ((ReadinjoyVideoReportData)paramObject).jdField_f_of_type_Long += SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.e;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.e = 0L;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long != 0L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      return;
      if (paramInt == 5)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        if (!(paramObject instanceof QQLiveDrawable.ErrorInfo)) {
          break label1052;
        }
      }
    }
    label1052:
    for (paramObject = (QQLiveDrawable.ErrorInfo)paramObject;; paramObject = null)
    {
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setImageResource(2130839553);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(true);
      this.jdField_a_of_type_AndroidOsHandler.post(new wmx(this, (ImageView)localObject));
      if (paramObject == null) {
        break;
      }
      PublicAccountUtil.a(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 1, ((QQLiveDrawable.ErrorInfo)paramObject).what);
      if (((QQLiveDrawable.ErrorInfo)paramObject).what == 10001) {}
      for (localObject = "1";; localObject = "2")
      {
        VideoReporter.a("0X80065E3", this.k, a(), this.jdField_b_of_type_JavaLangString, (String)localObject);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_JavaLangString = ("model : " + ((QQLiveDrawable.ErrorInfo)paramObject).model + " what : " + ((QQLiveDrawable.ErrorInfo)paramObject).what);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long > 0L)
        {
          paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          ((ReadinjoyVideoReportData)paramObject).jdField_b_of_type_Long += SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = 0L;
        }
        ReadInJoyUtils.a(getContext(), ReadInJoyUtils.a(), false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = null;
        return;
      }
      if (paramInt == 4)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        ((ImageView)localObject).setVisibility(0);
        ((ImageView)localObject).clearAnimation();
        ((ImageView)localObject).setImageResource(2130839556);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long <= 0L)) {
          break;
        }
        paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
        ((ReadinjoyVideoReportData)paramObject).jdField_b_of_type_Long += SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = 0L;
        return;
      }
      if (paramInt == 1)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d = (SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.c);
        paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
        ((ReadinjoyVideoReportData)paramObject).jdField_f_of_type_Long += this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d;
        paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
        ((ReadinjoyVideoReportData)paramObject).jdField_b_of_type_Int += 1;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long != 0L) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        return;
      }
      if ((paramInt != 0) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long > 0L)
      {
        paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
        ((ReadinjoyVideoReportData)paramObject).jdField_b_of_type_Long += SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long = 0L;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d == 0L)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.d = (SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.c);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Float = ((float)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_b_of_type_Long / this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.j * 1000.0F);
      ReadInJoyUtils.a(getContext(), ReadInJoyUtils.a(), true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = null;
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("PAVideoView" + this.jdField_d_of_type_Int, 2, "onStateChange(): onStateChange = " + QQLiveImage.getStateStr(paramInt) + ", stateIv == null" + ",mVid=" + this.jdField_b_of_type_JavaLangString);
      return;
    }
  }
  
  public void requestLayout()
  {
    if (!this.jdField_e_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.jdField_e_of_type_Boolean = true;
    super.setImageDrawable(null);
    super.setImageDrawable(paramDrawable);
    this.jdField_e_of_type_Boolean = false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\PAVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */