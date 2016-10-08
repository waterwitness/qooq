package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.voicechange.VoiceChangeData;
import com.tencent.mobileqq.voicechange.VoiceChangeData.IconData;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ChangeVoiceView
  extends RelativeLayout
{
  public static final int a = 0;
  public static String a;
  public static final int b = 1;
  static final String jdField_b_of_type_JavaLangString = "ChangeVoiceView";
  public static final int c = 2;
  private long jdField_a_of_type_Long;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
  private VolumeIndicateSquareView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  public VoiceChangeData a;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView c;
  public int d;
  public int e;
  public int f = 0;
  private int g;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "停止";
  }
  
  public ChangeVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    if (paramInt == 2)
    {
      setContentDescription(jdField_a_of_type_JavaLangString);
      label28:
      if (this.f == paramInt) {
        break label180;
      }
      this.f = paramInt;
      if (paramInt != 0) {
        break label204;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130837699);
      if (this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData.jdField_b_of_type_Int != 1) {
        break label182;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(2137417318);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(this.g, 0, this.g, 0);
      return;
      if (paramInt == 1)
      {
        setContentDescription(getContext().getString(2131362094) + " " + this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData.jdField_b_of_type_JavaLangString);
        break label28;
      }
      setContentDescription(this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData.jdField_b_of_type_JavaLangString);
      break label28;
      label180:
      break;
      label182:
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131427624));
      continue;
      label204:
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130837700);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        if ((AppSetting.j) && (getVisibility() == 0)) {
          AccessibilityUtil.a(this, getContext().getString(2131362094));
        }
      }
      else if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130837700);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(paramInt1);
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    while (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long >= 75L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt2 /= 1000;
      paramInt1 = paramInt2 / 60;
      paramInt2 %= 60;
      localStringBuilder.append(paramInt1).append(":");
      if (paramInt2 < 10) {
        localStringBuilder.append("0");
      }
      localStringBuilder.append(paramInt2);
      if (!localStringBuilder.equals(this.jdField_a_of_type_AndroidWidgetTextView.getText())) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt3);
      return;
    }
  }
  
  public void a(VoiceChangeData paramVoiceChangeData)
  {
    int i = 1;
    if (paramVoiceChangeData != null) {}
    for (boolean bool = true;; bool = false)
    {
      super.setEnabled(bool);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131301255));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297587));
      this.c = ((ImageView)super.findViewById(2131301254));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131301260));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView = ((CircleProgressView)super.findViewById(2131301256));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131301258));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)super.findViewById(2131301259));
      if (paramVoiceChangeData != null) {
        break;
      }
      this.c.setBackgroundDrawable(null);
      this.c.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(null);
      super.setContentDescription(null);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130837699);
      return;
    }
    this.g = DisplayUtil.a(getContext(), 4.0F);
    this.d = paramVoiceChangeData.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setStrokeWidth(4);
    this.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData = paramVoiceChangeData;
    this.c.setVisibility(0);
    label299:
    Object localObject1;
    label329:
    Object localObject3;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (paramVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_Int > 0)
    {
      this.c.setBackgroundResource(paramVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_Int);
      if (paramVoiceChangeData.f == 0) {
        break label766;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramVoiceChangeData.f != 1) {
        break label753;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841823);
      if (paramVoiceChangeData.j == 1) {
        break label814;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramVoiceChangeData.j != 4) {
        break label778;
      }
      localObject1 = VoiceChangeManager.a[0];
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label832;
      }
      localObject3 = new File(VoiceChangeManager.jdField_b_of_type_JavaLangString + ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1));
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
        break label804;
      }
      localObject1 = URLDrawable.getDrawable((File)localObject3, localURLDrawableOptions);
    }
    for (;;)
    {
      label401:
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      label409:
      localObject3 = paramVoiceChangeData.jdField_a_of_type_JavaLangString;
      localObject1 = localObject3;
      if (localObject3 != null)
      {
        localObject1 = localObject3;
        if (((String)localObject3).length() > 4) {
          localObject1 = ((String)localObject3).substring(0, 3) + "...";
        }
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      super.setContentDescription(paramVoiceChangeData.jdField_b_of_type_JavaLangString);
      if (paramVoiceChangeData.jdField_a_of_type_Int == this.e) {}
      for (;;)
      {
        this.f = (i + 1);
        a(i);
        return;
        localObject3 = super.getResources();
        try
        {
          localObject1 = paramVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_JavaLangString;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mFailedDrawable = ((Resources)localObject3).getDrawable(2130841883);
            localURLDrawableOptions.mLoadingDrawable = ((Resources)localObject3).getDrawable(2130841883);
            File localFile = new File(VoiceChangeManager.jdField_b_of_type_JavaLangString + ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1));
            if ((localFile.exists()) && (localFile.isFile())) {
              localObject1 = URLDrawable.getDrawable(localFile, localURLDrawableOptions);
            }
          }
          for (;;)
          {
            if ((localObject1 instanceof URLDrawable))
            {
              localObject3 = (URLDrawable)localObject1;
              if (((URLDrawable)localObject3).getStatus() == 2) {
                ((URLDrawable)localObject3).restartDownload();
              }
            }
            if (paramVoiceChangeData.jdField_b_of_type_Int != 1) {
              break label743;
            }
            ((Drawable)localObject1).setAlpha(127);
            paramVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
            this.c.setBackgroundDrawable((Drawable)localObject1);
            break;
            localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
            continue;
            QLog.d("ChangeVoiceView", 2, "init drawable url = null, name=" + paramVoiceChangeData.jdField_a_of_type_JavaLangString + ",type=" + paramVoiceChangeData.jdField_a_of_type_Int);
            localObject1 = ((Resources)localObject3).getDrawable(2130841883);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localObject2 = ((Resources)localObject3).getDrawable(2130841883);
            continue;
            label743:
            ((Drawable)localObject2).setAlpha(255);
          }
        }
        label753:
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841822);
        break label299;
        label766:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label299;
        label778:
        if (paramVoiceChangeData.j == 5)
        {
          localObject2 = VoiceChangeManager.a[1];
          break label329;
        }
        localObject2 = VoiceChangeManager.a[2];
        break label329;
        label804:
        localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        break label401;
        label814:
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label409;
        i = 0;
      }
      label832:
      Object localObject2 = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\audiopanel\ChangeVoiceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */