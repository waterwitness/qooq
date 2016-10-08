package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.ColorRingPlayer;
import com.tencent.util.WeakReferenceHandler;
import wie;

public class SwiftBrowserMiscHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements Handler.Callback
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "SwiftBrowserMiscHandler";
  public static final int b = 3;
  public static final int c = 4;
  public static final int d = 5;
  public Handler a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  private ColorRingPlayer jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer;
  
  public SwiftBrowserMiscHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() instanceof QQBrowserActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer == null);
        this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.f();
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer == null);
      this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.g();
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer == null);
    this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.e();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i;
    boolean bool;
    switch (paramMessage.what)
    {
    case 1: 
    case 2: 
    default: 
      return false;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity != null)
      {
        i = paramMessage.arg1;
        if ((i & 0x1) != 0) {
          break label106;
        }
        bool = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.setBottomBarVisible(bool);
        if ((i & 0x2) != 0) {
          break label112;
        }
        i = 1;
        label88:
        if (i == 0) {
          break label118;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.rightViewImg.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      return true;
      label106:
      bool = false;
      break;
      label112:
      i = 0;
      break label88;
      label118:
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.rightViewImg.setVisibility(8);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity != null)
      {
        if (this.jdField_a_of_type_AndroidViewViewGroup == null)
        {
          RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131297376);
          this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).inflate(2130904534, null));
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
          localLayoutParams.addRule(12);
          localRelativeLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
          this.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(new wie(this));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer == null) {
          this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer = new ColorRingPlayer(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_AndroidViewViewGroup);
        }
        this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.h();
        paramMessage = (Bundle)paramMessage.obj;
        this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getString("callbackId"));
        continue;
        paramMessage = (Bundle)paramMessage.obj;
        if (this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.a(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getInt("status"), paramMessage.getString("callbackId"));
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer != null)
          {
            paramMessage = (Bundle)paramMessage.obj;
            this.jdField_a_of_type_ComTencentMobileqqVasColorRingPlayer.a(paramMessage.getString("callbackId"));
          }
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\component\SwiftBrowserMiscHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */