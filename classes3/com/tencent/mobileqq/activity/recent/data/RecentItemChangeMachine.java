package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONException;
import org.json.JSONObject;

public class RecentItemChangeMachine
  extends RecentUserBaseData
{
  boolean c;
  
  public RecentItemChangeMachine(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = true;
    this.G = 2;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    if ((this.a.msg != null) && ((this.a.msg instanceof String)))
    {
      paramQQAppInterface = (String)this.a.msg;
      if (paramQQAppInterface == null) {}
    }
    try
    {
      this.c = new JSONObject(paramQQAppInterface).getBoolean("isRead");
      if (this.c)
      {
        i = 0;
        this.H = i;
        this.jdField_b_of_type_Long = this.a.showUpTime;
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          this.jdField_b_of_type_JavaLangString = paramContext.getResources().getString(2131365318);
        }
        this.jdField_b_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131365319);
        return;
      }
    }
    catch (JSONException paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
        continue;
        int i = 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\data\RecentItemChangeMachine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */