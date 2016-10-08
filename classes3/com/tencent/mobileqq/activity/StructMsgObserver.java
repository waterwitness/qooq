package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.Observable;
import java.util.Observer;
import mmh;
import mmi;

public class StructMsgObserver
  implements Observer
{
  public StructMsgObserver()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!WebAccelerator.a) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramObject instanceof MessageForStructing)) {
              break;
            }
            paramObject = (MessageForStructing)paramObject;
            paramObservable = ((MessageForStructing)paramObject).structingMsg;
          } while ((((MessageForStructing)paramObject).isSend()) || (!WebAccelerator.a(paramObservable)));
          paramObject = paramObservable.mMsgUrl;
          str1 = paramObservable.currentAccountUin;
          str2 = paramObservable.uin;
          ThreadManager.a(new mmh(this, (String)paramObject, paramObservable.uinType, str1, str2), 5, null, false);
          return;
        } while (!(paramObject instanceof MessageForText));
        paramObservable = (MessageForText)paramObject;
      } while ((paramObservable.isSend()) || (TextUtils.isEmpty(paramObservable.msg)));
      paramObject = WebAccelerator.c(paramObservable.msg);
    } while (TextUtils.isEmpty((CharSequence)paramObject));
    String str1 = paramObservable.frienduin;
    String str2 = paramObservable.selfuin;
    ThreadManager.a(new mmi(this, (String)paramObject, paramObservable.istroop, str2, str1), 5, null, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\StructMsgObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */