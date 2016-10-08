package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import rkq;

public class EmotionPanelLinearLayout
  extends LinearLayout
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public static final String a;
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  public View a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmoticonInfo jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
  private rkq jdField_a_of_type_Rkq;
  public boolean a;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = EmotionPanelLinearLayout.class.getSimpleName();
  }
  
  public EmotionPanelLinearLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public EmotionPanelLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private View a(float paramFloat1, float paramFloat2)
  {
    int i = super.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = super.getChildAt(i);
      float f1 = super.getScrollX() + paramFloat1 - localView.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localView.getTop();
      if ((f1 >= 0.0F) && (f1 <= localView.getWidth()) && (f2 >= 0.0F) && (f2 < localView.getHeight())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  private void a(View paramView)
  {
    Object localObject3 = paramView.getTag();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if ((localObject3 instanceof EmoticonInfo)) {
        localObject1 = (EmoticonInfo)localObject3;
      }
    }
    if (localObject1 != null)
    {
      super.sendAccessibilityEvent(1);
      super.playSoundEffect(0);
      if ((!"delete".equals(((EmoticonInfo)localObject1).jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null))
      {
        if ("setting".equals(((EmoticonInfo)localObject1).jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.setting();
        }
        do
        {
          do
          {
            return;
            if ("add".equals(((EmoticonInfo)localObject1).jdField_a_of_type_JavaLangString))
            {
              this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.d();
              ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579C", 0, 0, "", "", "", "");
              return;
            }
            if ("favEdit".equals(((EmoticonInfo)localObject1).jdField_a_of_type_JavaLangString))
            {
              paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, FavEmosmManageActivity.class);
              this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
              ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579E", 0, 0, "", "", "", "");
              return;
            }
            if ("funny_pic".equals(((EmoticonInfo)localObject1).jdField_a_of_type_JavaLangString))
            {
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
              ((Intent)localObject1).putExtra("finish_animation_up_down", true);
              ((Intent)localObject1).putExtra("hide_left_button", true);
              ((Intent)localObject1).putExtra("show_right_close_button", true);
              ((Intent)localObject1).putExtra("isFromCustom", true);
              VasWebviewUtil.openQQBrowserWithoutAD(getContext(), IndividuationUrlHelper.a("funnyPic"), -1L, (Intent)localObject1, false, -1);
              ((Activity)getContext()).overridePendingTransition(2130968585, 0);
              ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "0X8005C73", "0X8005C73", 0, 0, "", "", "", "");
              paramView = (RelativeLayout)paramView.findViewById(2131296485);
              if ((paramView != null) && ((paramView.getTag() instanceof RedTouch)))
              {
                paramView = (RedTouch)paramView.getTag();
                if (paramView != null) {
                  paramView.b();
                }
              }
              ((RedTouchManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(35)).b("100610.100612.100613");
              return;
            }
            if (!"push".equals(((EmoticonInfo)localObject1).jdField_a_of_type_JavaLangString)) {
              break;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback instanceof BaseChatPie)) {
              ((BaseChatPie)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback).k(9);
            }
            ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "CliOper", "", "", "ep_mall", "0X800579B", 0, 0, "", "", "", "");
            localObject1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0);
            localObject2 = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.a();
          } while (!((SharedPreferences)localObject1).getBoolean("magic_promotion_is_new_content_" + (String)localObject2, false));
          paramView = (ImageView)paramView.findViewById(2131296394);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "emoticonImg:" + paramView);
          }
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841690);
          localObject3 = URLDrawable.getDrawable(((SharedPreferences)localObject1).getString("magic_promotion_imgUrl", ""), (URLDrawable.URLDrawableOptions)localObject3);
          if ((paramView != null) && (localObject3 != null)) {
            paramView.setImageDrawable((Drawable)localObject3);
          }
          ((SharedPreferences)localObject1).edit().putBoolean("magic_promotion_is_new_content_" + (String)localObject2, false).commit();
          return;
          if (!(localObject1 instanceof PicEmoticonInfo)) {
            break label755;
          }
          paramView = ((PicEmoticonInfo)localObject1).a;
          localObject2 = ((EmoticonManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(13)).a(paramView.epId);
          if (localObject2 != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_a_of_type_JavaLangString, 2, "package is null");
        return;
        if ((((EmoticonPackage)localObject2).jobType == 0) && (((EmoticonPackage)localObject2).subType == 4))
        {
          PicEmoticonInfo.a((EmoticonPackage)localObject2, paramView, (Activity)this.jdField_a_of_type_AndroidContentContext);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a((EmoticonInfo)localObject1);
        return;
        label755:
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a((EmoticonInfo)localObject1);
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "performclick callback = null");
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "performclick info = null");
  }
  
  private boolean a(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      return false;
    }
    paramView.getDrawingRect(paramRect);
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    paramRect.offset(paramView.getLeft() - localViewGroup.getScrollX(), paramView.getTop() - localViewGroup.getScrollY());
    return true;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_b_of_type_Boolean))
    {
      ((WindowManager)getContext().getSystemService("window")).removeViewImmediate(this.jdField_b_of_type_AndroidWidgetFrameLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo);
      }
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    super.setOrientation(0);
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    super.setClickable(true);
    super.setLongClickable(true);
  }
  
  public void a(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramView == null) || (paramEmoticonInfo == null))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "showpoupemo view or info = null");
      return;
    }
    Drawable localDrawable = paramEmoticonInfo.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
    if (localDrawable == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "showpoupemo drawable = null");
      return;
    }
    paramView.getGlobalVisibleRect(jdField_a_of_type_AndroidGraphicsRect);
    int i = paramEmoticonInfo.c;
    if (this.jdField_b_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      this.jdField_a_of_type_AndroidWidgetImageView.setAdjustViewBounds(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    float f = getContext().getResources().getDisplayMetrics().density;
    int k = (int)(5.0F * f);
    paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    int j;
    if ((i == 1) || (i == 2) || (i == 7) || (i == 10))
    {
      j = (int)(64.0F * f);
      i = (int)(71.0F * f);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837552);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(k, k, k, k);
      paramView.width = ((int)(28.0F * f));
      paramView.height = ((int)(28.0F * f));
      paramView.bottomMargin = ((int)(6.0F * f));
      paramView.gravity = 17;
      label300:
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      paramView.gravity = 51;
      paramView.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (j - jdField_a_of_type_AndroidGraphicsRect.width()) / 2);
      paramView.topMargin = (jdField_a_of_type_AndroidGraphicsRect.top - i - (int)(15.0F * f));
      paramView.width = j;
      paramView.height = i;
      if (!this.jdField_b_of_type_Boolean) {
        break label700;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
    }
    for (;;)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo = paramEmoticonInfo;
      if ((paramView != null) && (paramView.c == 6) && ((paramView instanceof PicEmoticonInfo)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      }
      if ((paramEmoticonInfo.c == 6) && ((paramEmoticonInfo instanceof PicEmoticonInfo)) && ((localDrawable instanceof URLDrawable)))
      {
        localObject = (PicEmoticonInfo)paramEmoticonInfo;
        if (((PicEmoticonInfo)localObject).a())
        {
          String str = EmoticonUtils.k.replace("[epId]", ((PicEmoticonInfo)localObject).a.epId).replace("[eId]", ((PicEmoticonInfo)localObject).a.eId);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(getContext(), null);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(str);
          PicEmoticonInfo.a((URLDrawable)localDrawable);
        }
        if (2 == ((PicEmoticonInfo)localObject).a.jobType) {
          ReportController.b(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, ((PicEmoticonInfo)localObject).a.epId, "", "", "");
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a(paramView, paramEmoticonInfo, localDrawable);
      return;
      j = (int)(110.0F * f);
      i = (int)(110.0F * f);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837551);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(k, k, k, k);
      paramView.bottomMargin = 0;
      paramView.width = ((int)(100.0F * f));
      paramView.height = ((int)(100.0F * f));
      ReportController.b(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
      break label300;
      label700:
      paramView = (WindowManager)getContext().getSystemService("window");
      i = 24;
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        i = 67108888;
      }
      Object localObject = new WindowManager.LayoutParams(-1, -1, 2, i, -3);
      paramView.addView(this.jdField_b_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Rkq != null)) {
        removeCallbacks(this.jdField_a_of_type_Rkq);
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && (!this.jdField_a_of_type_Boolean)) {
        a(this.jdField_a_of_type_AndroidViewView);
      }
      a();
      this.jdField_a_of_type_AndroidViewView = null;
      continue;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (this.jdField_a_of_type_Rkq == null) {
          this.jdField_a_of_type_Rkq = new rkq(this);
        }
        this.jdField_a_of_type_Rkq.a();
        postDelayed(this.jdField_a_of_type_Rkq, ViewConfiguration.getLongPressTimeout());
        continue;
        super.setPressed(false);
        if (this.jdField_a_of_type_Rkq != null) {
          removeCallbacks(this.jdField_a_of_type_Rkq);
        }
        a();
        this.jdField_a_of_type_AndroidViewView = null;
        continue;
        if ((this.jdField_a_of_type_Boolean) && ((!a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) || (!jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
        {
          this.jdField_a_of_type_AndroidViewView = a(paramMotionEvent.getX(), paramMotionEvent.getY());
          if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getTag() != null))
          {
            paramMotionEvent = (EmoticonInfo)this.jdField_a_of_type_AndroidViewView.getTag();
            if ((paramMotionEvent != null) && (!"delete".equals(paramMotionEvent.jdField_a_of_type_JavaLangString)) && (!"add".equals(paramMotionEvent.jdField_a_of_type_JavaLangString)) && (!"setting".equals(paramMotionEvent.jdField_a_of_type_JavaLangString))) {
              a(this.jdField_a_of_type_AndroidViewView, (EmoticonInfo)this.jdField_a_of_type_AndroidViewView.getTag());
            }
          }
          else
          {
            a();
          }
        }
        else if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null) && ((!a(this.jdField_a_of_type_AndroidViewView, jdField_a_of_type_AndroidGraphicsRect)) || (!jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))))
        {
          this.jdField_a_of_type_AndroidViewView = null;
        }
      }
    }
  }
  
  public void setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmotionPanelLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */