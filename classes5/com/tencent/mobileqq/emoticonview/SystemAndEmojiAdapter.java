package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class SystemAndEmojiAdapter
  extends BaseEmotionAdapter
  implements Handler.Callback
{
  public static final String b = "SystemAndEmojiAdapter";
  public static final String c = "EmotionPanelGuideConfig";
  public static final String d = "isShowGuie_";
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 30;
  public static final int k = 100;
  private SystemAndEmojiAdapter.ListViewTouchListener jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiAdapter$ListViewTouchListener;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  protected int l;
  protected int m;
  private int n;
  private int o;
  
  public SystemAndEmojiAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.l = ((int)(this.jdField_a_of_type_Float * 30.0F));
    this.m = ((this.f - (int)(18.0F * this.jdField_a_of_type_Float) * 2 - this.l * 7) / 6);
    this.n = 240;
    paramContext = paramQQAppInterface.getApplication().getSharedPreferences("EmotionPanelGuideConfig", 0);
    this.jdField_a_of_type_Boolean = paramContext.getBoolean("isShowGuie_" + paramQQAppInterface.a(), true);
    paramContext.edit().putBoolean("isShowGuie_" + paramQQAppInterface.a(), false).commit();
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.d("SystemAndEmojiAdapter", 1, "SystemAndEmojiAdapter need show guide animaion");
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiAdapter$ListViewTouchListener = new SystemAndEmojiAdapter.ListViewTouchListener(this);
    }
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (EmotionPanelConstans.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo) == this.e) {
      bool = true;
    }
    return bool;
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    SystemAndEmojiAdapter.SystemAndEmojiHolder localSystemAndEmojiHolder = (SystemAndEmojiAdapter.SystemAndEmojiHolder)paramViewHolder;
    if (getItemViewType(paramInt) == 0)
    {
      paramViewHolder = paramView;
      if (paramView == null)
      {
        paramViewHolder = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramView = new LinearLayout.LayoutParams(-2, -2);
        paramView.topMargin = ((int)(6.0F * this.jdField_a_of_type_Float));
        paramView.leftMargin = ((int)(18.0F * this.jdField_a_of_type_Float));
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setTextSize(8.0F);
        paramViewGroup.setTextColor(-4473925);
        paramViewHolder.addView(paramViewGroup, paramView);
        localSystemAndEmojiHolder.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup;
        paramViewHolder.setTag(localSystemAndEmojiHolder);
      }
      paramView = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(this.c * paramInt);
      if (!(paramView instanceof SystemAndEmojiEmoticonInfo)) {
        break label973;
      }
    }
    label973:
    for (paramView = (SystemAndEmojiEmoticonInfo)paramView;; paramView = null)
    {
      if (paramView != null) {}
      for (paramView = paramView.o;; paramView = "")
      {
        localSystemAndEmojiHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
        if ((a()) && (this.jdField_a_of_type_Boolean)) {
          c();
        }
        if (QLog.isColorLevel()) {
          QLog.d("SystemAndEmojiAdapter", 2, "getEmoticonView cost = " + (System.currentTimeMillis() - l1));
        }
        return paramViewHolder;
        int i1;
        if (paramView == null)
        {
          paramView = EmotionPanelViewPool.a().a(this.e);
          if (paramView == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SystemAndEmojiAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
            }
            paramView = new EmotionPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext);
            paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            paramView.setOrientation(0);
            i1 = 0;
            paramViewHolder = paramView;
            if (i1 < this.c)
            {
              paramViewHolder = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
              paramViewGroup = new LinearLayout.LayoutParams(this.l, this.l);
              if (i1 == 0) {}
              for (paramViewGroup.leftMargin = ((int)(18.0F * this.jdField_a_of_type_Float));; paramViewGroup.leftMargin = this.m)
              {
                paramViewHolder.setLayoutParams(paramViewGroup);
                paramViewHolder.setVisibility(8);
                paramViewHolder.setScaleType(ImageView.ScaleType.FIT_XY);
                paramViewHolder.setAdjustViewBounds(false);
                paramViewHolder.setFocusable(true);
                paramViewHolder.setFocusableInTouchMode(true);
                paramView.addView(paramViewHolder);
                i1 += 1;
                break;
              }
            }
          }
          else
          {
            paramViewHolder = paramView;
            if (QLog.isColorLevel())
            {
              QLog.d("SystemAndEmojiAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
              paramViewHolder = paramView;
            }
          }
          ((EmotionPanelLinearLayout)paramViewHolder).setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
          a(this.e, paramViewHolder);
          paramView = (ViewGroup)paramViewHolder;
          localSystemAndEmojiHolder.jdField_a_of_type_ArrayOfComTencentImageURLImageView = new URLImageView[this.c];
          i1 = 0;
          while (i1 < this.c)
          {
            localSystemAndEmojiHolder.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1] = ((URLImageView)paramView.getChildAt(i1));
            i1 += 1;
          }
          paramViewHolder.setTag(localSystemAndEmojiHolder);
        }
        for (;;)
        {
          i1 = (int)(12.0F * this.jdField_a_of_type_Float);
          if ((paramInt == 1) || (paramInt == 5)) {
            i1 = (int)(7.0F * this.jdField_a_of_type_Float);
          }
          paramViewHolder.setPadding(0, i1, 0, 0);
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("SystemAndEmojiAdapter", 2, "inflater view cost = " + (l2 - l1));
          }
          i1 = 0;
          while (i1 < this.c)
          {
            int i2 = this.c * paramInt + i1;
            if (i2 > this.jdField_a_of_type_JavaUtilList.size() - 1)
            {
              localSystemAndEmojiHolder.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setVisibility(8);
              i1 += 1;
            }
            else
            {
              URLImageView localURLImageView = localSystemAndEmojiHolder.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1];
              paramView = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(i2);
              if ((paramView instanceof SystemAndEmojiEmoticonInfo)) {}
              for (paramView = (SystemAndEmojiEmoticonInfo)paramView;; paramView = null)
              {
                if (paramView == null)
                {
                  localURLImageView.setVisibility(8);
                  break;
                }
                localSystemAndEmojiHolder.jdField_a_of_type_ArrayOfComTencentImageURLImageView[i1].setTag(paramView);
                if (paramView.j == -1)
                {
                  localURLImageView.setVisibility(8);
                  break;
                }
                localURLImageView.setVisibility(0);
                l2 = System.currentTimeMillis();
                paramViewGroup = paramView.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
                if (QLog.isColorLevel()) {
                  QLog.d("SystemAndEmojiAdapter", 2, "getdrawable cost = " + (System.currentTimeMillis() - l2));
                }
                localURLImageView.setImageDrawable(paramViewGroup);
                if (paramView.i == 1)
                {
                  paramViewGroup = EmotcationConstants.a[paramView.j];
                  paramView = paramViewGroup;
                  if (paramViewGroup != null)
                  {
                    paramView = paramViewGroup;
                    if (paramViewGroup.startsWith("/"))
                    {
                      paramView = paramViewGroup;
                      if (paramViewGroup.length() > 1) {
                        paramView = paramViewGroup.substring(1);
                      }
                    }
                  }
                  if (paramView == null) {
                    break;
                  }
                  localURLImageView.setContentDescription(paramView);
                  break;
                }
                if (paramView.i == 2)
                {
                  localURLImageView.setContentDescription(EmotcationConstants.a(paramView.j));
                  break;
                }
                localURLImageView.setContentDescription("未知");
                break;
              }
            }
          }
          break;
          paramViewHolder = paramView;
        }
      }
    }
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new SystemAndEmojiAdapter.SystemAndEmojiHolder();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiAdapter$ListViewTouchListener = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
    if (a() != null) {
      a().setTouchEventListener(null);
    }
  }
  
  public void a(EmotionPanelListView paramEmotionPanelListView)
  {
    super.a(paramEmotionPanelListView);
    if (paramEmotionPanelListView != null) {
      paramEmotionPanelListView.setTouchEventListener(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiAdapter$ListViewTouchListener);
    }
  }
  
  public void c()
  {
    if ((!this.b) && (this.jdField_a_of_type_Boolean))
    {
      this.b = true;
      Message localMessage = Message.obtain();
      localMessage.what = 100;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 40L);
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(paramInt * 7);
    if ((localObject instanceof SystemAndEmojiEmoticonInfo)) {}
    for (localObject = (SystemAndEmojiEmoticonInfo)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        if (((SystemAndEmojiEmoticonInfo)localObject).i == 3) {
          return 0;
        }
        return 1;
      }
      return -1;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 100) && (this.jdField_a_of_type_Boolean))
    {
      this.o += 1;
      int i1 = this.n / 20;
      if (this.o > 20) {
        i1 = -(this.n / 20);
      }
      if (a() != null) {
        a().f(i1, 0);
      }
      if (this.o >= 40)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiAdapter$ListViewTouchListener = null;
        this.jdField_a_of_type_Boolean = false;
        if (a() != null) {
          a().setTouchEventListener(null);
        }
      }
      if (this.o < 40)
      {
        paramMessage = Message.obtain();
        paramMessage.what = 100;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramMessage, 40L);
      }
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\SystemAndEmojiAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */