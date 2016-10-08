package com.tencent.mobileqq.javahook;

import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import swz;
import sxa;
import sxb;

public class SpellCheckerSessionHooker
{
  public static Field a;
  
  public SpellCheckerSessionHooker()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a()
  {
    try
    {
      JavaHookBridge.findAndHookMethod(SpellCheckerSession.class, "close", new Object[] { new swz() });
      JavaHookBridge.findAndReplaceMethod(SpellCheckerSession.class, "handleOnGetSuggestionsMultiple", new Object[] { SuggestionsInfo[].class, new sxa() });
      JavaHookBridge.findAndReplaceMethod(SpellCheckerSession.class, "handleOnGetSentenceSuggestionsMultiple", new Object[] { SentenceSuggestionsInfo[].class, new sxb() });
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SpellCheckerSessionHooker", 2, "startHook error", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\javahook\SpellCheckerSessionHooker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */