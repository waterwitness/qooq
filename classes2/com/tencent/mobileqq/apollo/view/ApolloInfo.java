package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.TextUtils;

public class ApolloInfo
{
  public int a;
  public ApolloActionData a;
  public String a;
  public int b;
  public String b;
  public int c;
  public int d;
  public int e;
  
  public ApolloInfo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return TextUtils.a(paramContext.getResources(), this.e);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo) {}
  
  public void a(ApolloActionData paramApolloActionData)
  {
    this.a = paramApolloActionData;
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return null;
  }
  
  public String toString()
  {
    if (this.a != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("[");
      localStringBuilder.append("id: ").append(this.a.actionId).append(", name: ").append(this.a.actionName).append(", peerUin: ").append(this.a.peerUin).append(", peopleNum: ").append(this.a.personNum).append(", feeType: ").append(this.a.feeType).append(", inputText: ").append(this.a.inputText).append(",actionText: ").append(this.b).append(",textType: ").append(this.d).append("]");
      return localStringBuilder.toString();
    }
    return "ApolloActionData is null";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\view\ApolloInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */