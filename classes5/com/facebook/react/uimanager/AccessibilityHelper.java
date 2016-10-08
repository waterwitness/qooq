package com.facebook.react.uimanager;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.RadioButton;

class AccessibilityHelper
{
  private static final String BUTTON = "button";
  private static final View.AccessibilityDelegate BUTTON_DELEGATE = new View.AccessibilityDelegate()
  {
    public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
      paramAnonymousAccessibilityEvent.setClassName(Button.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
      paramAnonymousAccessibilityNodeInfo.setClassName(Button.class.getName());
    }
  };
  private static final String RADIOBUTTON_CHECKED = "radiobutton_checked";
  private static final View.AccessibilityDelegate RADIOBUTTON_CHECKED_DELEGATE = new View.AccessibilityDelegate()
  {
    public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
      paramAnonymousAccessibilityEvent.setClassName(RadioButton.class.getName());
      paramAnonymousAccessibilityEvent.setChecked(true);
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
      paramAnonymousAccessibilityNodeInfo.setClassName(RadioButton.class.getName());
      paramAnonymousAccessibilityNodeInfo.setCheckable(true);
      paramAnonymousAccessibilityNodeInfo.setChecked(true);
    }
  };
  private static final String RADIOBUTTON_UNCHECKED = "radiobutton_unchecked";
  private static final View.AccessibilityDelegate RADIOBUTTON_UNCHECKED_DELEGATE = new View.AccessibilityDelegate()
  {
    public void onInitializeAccessibilityEvent(View paramAnonymousView, AccessibilityEvent paramAnonymousAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAnonymousView, paramAnonymousAccessibilityEvent);
      paramAnonymousAccessibilityEvent.setClassName(RadioButton.class.getName());
      paramAnonymousAccessibilityEvent.setChecked(false);
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfo paramAnonymousAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfo);
      paramAnonymousAccessibilityNodeInfo.setClassName(RadioButton.class.getName());
      paramAnonymousAccessibilityNodeInfo.setCheckable(true);
      paramAnonymousAccessibilityNodeInfo.setChecked(false);
    }
  };
  
  public static void sendAccessibilityEvent(View paramView, int paramInt)
  {
    paramView.sendAccessibilityEvent(paramInt);
  }
  
  public static void updateAccessibilityComponentType(View paramView, String paramString)
  {
    if (paramString == null)
    {
      paramView.setAccessibilityDelegate(null);
      return;
    }
    if ("button".equals(paramString))
    {
      paramView.setAccessibilityDelegate(BUTTON_DELEGATE);
      return;
    }
    if ("radiobutton_checked".equals(paramString))
    {
      paramView.setAccessibilityDelegate(RADIOBUTTON_CHECKED_DELEGATE);
      return;
    }
    if ("radiobutton_unchecked".equals(paramString))
    {
      paramView.setAccessibilityDelegate(RADIOBUTTON_UNCHECKED_DELEGATE);
      return;
    }
    paramView.setAccessibilityDelegate(null);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\uimanager\AccessibilityHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */