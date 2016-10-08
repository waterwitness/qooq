package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public final class StructMsgForHypertext$HyperTextView
  extends TextView
  implements View.OnClickListener
{
  boolean a;
  
  public StructMsgForHypertext$HyperTextView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = false;
    setOnClickListener(this);
  }
  
  public boolean a()
  {
    if ((this.a) || (a(this)))
    {
      this.a = false;
      return false;
    }
    return true;
  }
  
  public boolean a(Object paramObject)
  {
    try
    {
      Field localField = Class.forName("android.view.View").getDeclaredField("mHasPerformedLongPress");
      localField.setAccessible(true);
      boolean bool = ((Boolean)localField.get(paramObject)).booleanValue();
      return bool;
    }
    catch (NoSuchFieldException paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, ((NoSuchFieldException)paramObject).getMessage(), (Throwable)paramObject);
      }
      return false;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, ((Exception)paramObject).getMessage(), (Throwable)paramObject);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(2131296312);
    if ((localObject != null) && ((localObject instanceof StructMsgForHypertext)))
    {
      localObject = (StructMsgForHypertext)localObject;
      if (!((StructMsgForHypertext)localObject).mHyperClick) {
        break label36;
      }
      ((StructMsgForHypertext)localObject).mHyperClick = false;
    }
    label36:
    while (!"web".equals(((StructMsgForHypertext)localObject).mMsgAction)) {
      return;
    }
    paramView = paramView.getContext();
    Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
    localIntent.putExtra("url", ((StructMsgForHypertext)localObject).mMsgUrl);
    PublicAccountUtil.a(((StructMsgForHypertext)localObject).message, localIntent, ((StructMsgForHypertext)localObject).mMsgUrl);
    paramView.startActivity(localIntent);
    this.a = true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.a = false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\StructMsgForHypertext$HyperTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */