package com.tencent.biz.qqstory.pgc.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity.VideoControlListener;
import com.tencent.biz.qqstory.view.widget.StrokeTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import ilx;
import ily;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ContentEmptyView
  extends RelativeLayout
  implements View.OnClickListener
{
  public static final String a = "ContentEmptyView";
  public DisplayMetrics a;
  protected View a;
  protected ImageView a;
  protected TextView a;
  public UserInfo a;
  InfoCardDialog a;
  protected StrokeTextView a;
  public URLImageView a;
  protected BaseActivity a;
  public QQAppInterface a;
  public UserInfo b;
  public URLImageView b;
  
  public ContentEmptyView(Context paramContext, long paramLong, String paramString)
  {
    super(paramContext);
    setFocusable(true);
    UserInfo localUserInfo = new UserInfo();
    localUserInfo.uid = paramLong;
    localUserInfo.type = 1;
    localUserInfo.unionId = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo = localUserInfo;
    if ((paramContext instanceof BaseActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramContext);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    }
    a();
  }
  
  public ContentEmptyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ContentEmptyView(Context paramContext, UserInfo paramUserInfo)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo = paramUserInfo;
    a();
  }
  
  public static Bitmap a(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setDoInput(true);
      paramString.connect();
      paramString = paramString.getInputStream();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramString.read(arrayOfByte);
        if (i == -1)
        {
          paramString.close();
          paramString = localByteArrayOutputStream.toByteArray();
          return BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      return null;
    }
    catch (IOException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ContentEmptyView", 2, paramString.getMessage());
      }
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ContentEmptyView", 2, paramString.getMessage());
      }
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.type == 1)
    {
      LayoutInflater.from(getContext()).inflate(2130904496, this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView = ((StrokeTextView)findViewById(2131302951));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.setStrokeColor(1342177280);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131300661));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131302950));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302952));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
    }
    LayoutInflater.from(getContext()).inflate(2130904467, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131297156);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302731));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302840));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ilx(this));
  }
  
  public void a(UserInfo paramUserInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo = paramUserInfo;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.remark)) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.remark);
    }
    for (;;)
    {
      if (HttpUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.authTypeIcon)) {}
      try
      {
        paramUserInfo = URLDrawable.URLDrawableOptions.obtain();
        int i = AIOUtils.a(16.0F, getResources());
        paramUserInfo.mRequestHeight = i;
        paramUserInfo.mRequestWidth = i;
        paramUserInfo = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.authTypeIcon, paramUserInfo);
        if (paramUserInfo.getStatus() == 2) {
          paramUserInfo.restartDownload();
        }
        paramUserInfo.setBounds(0, 0, i, i);
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.setCompoundDrawablePadding(8);
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.setCompoundDrawables(null, null, paramUserInfo, null);
      }
      catch (Exception paramUserInfo)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContentEmptyView", 2, QLog.getStackTraceString(paramUserInfo));
          }
        }
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog = new InfoCardDialog(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo, false, 3);
      }
      if (HttpUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.headUrl)) {
        ThreadManager.a(new ily(this), 8, null, true);
      }
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetStrokeTextView.setText(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo.nick);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300661: 
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog = new InfoCardDialog(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentBizQqstoryPgcViewInfoCardDialog.a(this.jdField_a_of_type_ComTencentBizQqstoryPgcModelUserInfo, false, 3);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof StoryPlayVideoActivity))
    {
      ((StoryPlayVideoActivity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).a.e(0);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramInt);
  }
  
  public void setNickname(UserInfo paramUserInfo)
  {
    this.jdField_b_of_type_ComTencentBizQqstoryPgcModelUserInfo = paramUserInfo;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramUserInfo.nick);
  }
  
  public void setOnCloseClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\view\ContentEmptyView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */