package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicpendant.MusicPendantListener;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import mqq.util.WeakReference;
import wmp;
import wmq;
import wmr;
import wms;
import wmt;

public class MusicPendantView
  extends RelativeLayout
  implements Handler.Callback
{
  private static final int jdField_a_of_type_Int = 500;
  private static final String jdField_a_of_type_JavaLangString = MusicPendantView.class.getSimpleName();
  private static boolean jdField_a_of_type_Boolean = false;
  private static final int jdField_b_of_type_Int = 200;
  private static final int jdField_c_of_type_Int = 4000;
  private static final int d = 1000;
  private static final int e = 1001;
  private static final int f = 1002;
  private static final int g = 1003;
  private static final int h = 1004;
  private static final int i = 1005;
  private Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new wmr(this);
  private View jdField_a_of_type_AndroidViewView;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MusicPendantListener jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantListener = new wmp(this);
  private ArcImageView jdField_a_of_type_ComTencentMobileqqWidgetArcImageView;
  protected WeakReference a;
  private View jdField_b_of_type_AndroidViewView;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 1.0F, 1, 0.0F, 1, 0.0F);
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MusicPendantView(Context paramContext)
  {
    super(paramContext);
    c();
    MusicPendantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantListener);
  }
  
  public MusicPendantView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
    MusicPendantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantListener);
  }
  
  public MusicPendantView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
    MusicPendantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqMusicpendantMusicPendantListener);
  }
  
  private void a(int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 1)) {}
    try
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838697);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "updatePlayOrPauseState() exception", localException);
      return;
    }
    if (paramInt == 3)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838698);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void c()
  {
    LayoutInflater.from(getContext()).inflate(2130904220, this, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetArcImageView = ((ArcImageView)findViewById(2131301873));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301872));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301874));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new wmq(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131301870);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131301871);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301869));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.c = ((ImageView)findViewById(2131301868));
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
  }
  
  public BaseActivity a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
      return null;
    }
    return (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  public void a()
  {
    float f2 = 0.0F;
    for (;;)
    {
      try
      {
        String str2;
        if (MusicPendantManager.jdField_a_of_type_JavaLangString.equalsIgnoreCase(QQPlayerService.a()))
        {
          Object localObject = QQPlayerService.a();
          if (localObject == null) {
            break label319;
          }
          localObject = ((Bundle)localObject).getLong("BUNDLE_KEY_UIN") + "";
          str2 = MusicPendantManager.a().b();
          if ((TextUtils.isEmpty(str2)) || (!str2.equalsIgnoreCase((String)localObject))) {
            break label260;
          }
          int j = QQPlayerService.a();
          a(j);
          localObject = QQPlayerService.a();
          if (localObject != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(((SongInfo)localObject).b);
          }
          f1 = QQPlayerService.f();
          float f3 = QQPlayerService.d();
          if (f3 <= 0.0F) {
            break label305;
          }
          f1 /= f3;
          break label307;
          this.jdField_a_of_type_ComTencentMobileqqWidgetArcImageView.setProgress(f1);
          if ((j == 2) || (j == 1) || (j == 3))
          {
            if (this.jdField_a_of_type_AndroidOsHandler != null) {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1005);
            }
            postInvalidate();
          }
        }
        else
        {
          if (this.jdField_a_of_type_AndroidOsHandler == null) {
            break label318;
          }
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 200L);
          return;
        }
        if ((QQPlayerService.g() < QQPlayerService.c() - 1) || (this.jdField_a_of_type_AndroidOsHandler == null)) {
          continue;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
        continue;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "refreshPlayState() " + localException + " is not current user:" + str2);
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "refreshPlayState() exception", localException);
        return;
      }
      label260:
      continue;
      label305:
      label307:
      do
      {
        break;
        f1 = 0.0F;
      } while (f1 >= 0.0F);
      float f1 = f2;
      continue;
      label318:
      return;
      label319:
      String str1 = "";
    }
  }
  
  public void a(Card paramCard)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1002);
      localMessage.obj = paramCard;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
  }
  
  public void b()
  {
    try
    {
      Intent localIntent = MusicPendantManager.a().a(true);
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
        ((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).startActivityForResult(localIntent, 10000);
      }
      for (;;)
      {
        ReportController.b(MusicPendantManager.a().a(), "CliOper", "", "", "0X8005C9F", "0X8005C9F", 0, 0, "", "", "", "");
        return;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "openMusicPendantSettingPage() Activity is null!");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "openMusicPendantSettingPage() exception", localException);
    }
  }
  
  public void b(Card paramCard)
  {
    if (paramCard != null)
    {
      for (;;)
      {
        try
        {
          if (paramCard.mNowShowFlag == 1)
          {
            this.c.setVisibility(0);
            localObject = URLDrawableHelper.a(paramCard.mNowShowIconUrl);
            this.c.setBackgroundDrawable((Drawable)localObject);
            localObject = paramCard.mNowShowJumpUrl;
            this.c.setOnClickListener(new wms(this, (String)localObject, paramCard));
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            setVisibility(0);
            return;
          }
          this.c.setVisibility(8);
          Object localObject = MusicPendantManager.a();
          if ((!((MusicPendantManager)localObject).a()) && ((!paramCard.visibleMusicPendant) || (((MusicPendantManager)localObject).a() == null) || (((MusicPendantManager)localObject).a().length <= 0))) {
            break;
          }
          setVisibility(0);
          if ((paramCard.showRedPointMusicPendant) || ((BaseApplicationImpl.c) && (!jdField_a_of_type_Boolean)))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetArcImageView.a(true);
            ThreadManager.a(new wmt(this), 8, null, true);
            if (this.jdField_a_of_type_AndroidOsHandler == null) {
              return;
            }
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
            return;
          }
        }
        catch (Exception paramCard)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "updateViewLocal() exception", paramCard);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetArcImageView.a(false);
      }
      setVisibility(8);
      MusicPendantManager.a().d();
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
      }
    }
    else
    {
      setVisibility(8);
      QLog.e(jdField_a_of_type_JavaLangString, 1, "updateViewLocal() card is null!");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (paramMessage == null) {
      j = 200;
    }
    Object localObject1;
    for (;;)
    {
      if (paramMessage != null)
      {
        try
        {
          localObject1 = paramMessage.obj;
        }
        catch (Exception paramMessage)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "mPlayClickListener.onClick() exception", paramMessage);
          return true;
        }
        j = paramMessage.what;
        continue;
        a();
        return true;
        if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          postInvalidate();
          return true;
          paramMessage = (Message)localObject2;
          if (localObject1 != null)
          {
            paramMessage = (Message)localObject2;
            if ((localObject1 instanceof Card)) {
              paramMessage = (Card)localObject1;
            }
          }
          b(paramMessage);
          return true;
          if (paramMessage == null) {
            break label287;
          }
        }
      }
    }
    label287:
    for (int j = paramMessage.arg1;; j = -1)
    {
      a(j);
      a();
      return true;
      if ((localObject1 != null) && ((localObject1 instanceof SongInfo))) {}
      for (paramMessage = (SongInfo)localObject1;; paramMessage = null)
      {
        if ((paramMessage != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.b);
        }
        a();
        return true;
        if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        postInvalidate();
        return true;
      }
      for (;;)
      {
        switch (j)
        {
        }
        return true;
        localObject1 = null;
      }
    }
  }
  
  public void setActivity(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\MusicPendantView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */