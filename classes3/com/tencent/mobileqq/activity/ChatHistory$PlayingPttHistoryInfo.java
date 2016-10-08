package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import kwi;

public class ChatHistory$PlayingPttHistoryInfo
{
  public static final int a = 0;
  public static final int b = 1;
  public View a;
  public Object a;
  public String a;
  public boolean a;
  public int c;
  
  public ChatHistory$PlayingPttHistoryInfo(ChatHistory paramChatHistory)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  private void c()
  {
    Object localObject1 = null;
    if (this.c == 0) {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break label305;
      }
    }
    label297:
    label299:
    label305:
    for (localObject1 = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297664);; localObject1 = null)
    {
      if (localObject1 != null) {
        if ((this.jdField_a_of_type_AndroidViewView.getTag() == null) || (!(this.jdField_a_of_type_AndroidViewView.getTag() instanceof kwi))) {
          break label299;
        }
      }
      for (boolean bool = ((kwi)this.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_Boolean;; bool = false)
      {
        if (bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.setBounds(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.getMinimumWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.getMinimumHeight());
          ((Button)localObject1).setCompoundDrawables(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b, null, null, null);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.stop();
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.start();
        }
        for (;;)
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.setBounds(0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.getMinimumWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.getMinimumHeight());
          ((Button)localObject1).setCompoundDrawables(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a, null, null, null);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.stop();
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.start();
          return;
          if (this.c == 1)
          {
            ImageView localImageView;
            if (this.jdField_a_of_type_AndroidViewView != null)
            {
              localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297662);
              localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297661);
            }
            for (;;)
            {
              if ((localImageView == null) || (localObject1 == null)) {
                break label297;
              }
              Object localObject2 = localImageView.getTag();
              if (!(localObject2 instanceof PicEmoticonInfo)) {
                break;
              }
              localObject2 = (PicEmoticonInfo)localObject2;
              ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, localImageView);
              ChatHistory.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, (ImageView)localObject1, (PicEmoticonInfo)localObject2);
              return;
              localImageView = null;
            }
          }
        }
      }
    }
  }
  
  private void d()
  {
    Object localObject1 = null;
    if (this.c == 0) {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break label279;
      }
    }
    label271:
    label273:
    label279:
    for (localObject1 = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131297664);; localObject1 = null)
    {
      if ((localObject1 != null) && (((Button)localObject1).getTag().equals(this.jdField_a_of_type_JavaLangObject))) {
        if ((this.jdField_a_of_type_AndroidViewView.getTag() == null) || (!(this.jdField_a_of_type_AndroidViewView.getTag() instanceof kwi))) {
          break label273;
        }
      }
      for (boolean bool = ((kwi)this.jdField_a_of_type_AndroidViewView.getTag()).jdField_a_of_type_Boolean;; bool = false)
      {
        Object localObject2;
        if (bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.b.stop();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getDrawable(2130843048);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          ((Button)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
        }
        for (;;)
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a.stop();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getResources().getDrawable(2130843047);
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getMinimumWidth(), ((Drawable)localObject2).getMinimumHeight());
          break;
          if (this.c == 1)
          {
            if (this.jdField_a_of_type_AndroidViewView != null)
            {
              localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297662);
              localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297661);
            }
            for (;;)
            {
              if ((localObject2 == null) || (localObject1 == null)) {
                break label271;
              }
              Object localObject3 = ((ImageView)localObject2).getTag();
              if (!(localObject3 instanceof PicEmoticonInfo)) {
                break;
              }
              localObject3 = (PicEmoticonInfo)localObject3;
              ((PicEmoticonInfo)localObject3).a("fromAIO", true);
              ChatHistory.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, (ImageView)localObject2);
              ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, (ImageView)localObject1, (PicEmoticonInfo)localObject3);
              return;
              localObject2 = null;
            }
          }
        }
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "reset()");
    }
    this.c = -1;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(int paramInt, View paramView, Object paramObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "playPtt() type = " + paramInt + ", isFinish = " + this.jdField_a_of_type_Boolean);
    }
    if ((!this.jdField_a_of_type_Boolean) && (Utils.a(paramObject, this.jdField_a_of_type_JavaLangObject)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistory", 2, "playPtt() 点击正在播放，即要停止啦！");
      }
      b();
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    if (!ChatHistory.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory, paramString))
    {
      b();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.c = paramInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_JavaLangString = paramString;
    c();
  }
  
  public void a(View paramView, String paramString)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.c != 1) {
      c();
    }
  }
  
  public boolean a(int paramInt, Object paramObject)
  {
    return (!this.jdField_a_of_type_Boolean) && (paramInt == this.c) && (Utils.a(this.jdField_a_of_type_JavaLangObject, paramObject));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "stopPlayPtt()");
    }
    ChatHistory.c(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory);
    this.jdField_a_of_type_Boolean = true;
    d();
    a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[type = ").append(this.c).append(", curTag = ").append(this.jdField_a_of_type_JavaLangObject).append(", isFinish = ").append(this.jdField_a_of_type_Boolean).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\ChatHistory$PlayingPttHistoryInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */