package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.TextUtils;

public class EmoticonInfo
  extends EmotionPanelData
{
  public static final String c = "delete";
  public static final String d = "setting";
  public static final String e = "add";
  public static final int f = 1;
  public static final String f = "push";
  public static final int g = 2;
  public static final String g = "show_fav_menu";
  public static final String h = "donothing";
  public static final String i = "favEdit";
  public static final String j = "funny_pic";
  EmoticonCallback a;
  public String a;
  public String b;
  public int c;
  public int d;
  public int e;
  
  public EmoticonInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = -1;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return TextUtils.a(paramContext.getResources(), this.e);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo) {}
  
  public void a(EmoticonCallback paramEmoticonCallback)
  {
    this.a = paramEmoticonCallback;
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return a(paramContext, paramFloat);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmoticonInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */