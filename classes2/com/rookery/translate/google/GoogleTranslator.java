package com.rookery.translate.google;

import android.content.Context;
import android.util.Pair;
import com.rookery.translate.Translator;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateWithTimeCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import gch;
import gci;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GoogleTranslator
  extends Translator
{
  private static GoogleTranslator jdField_a_of_type_ComRookeryTranslateGoogleGoogleTranslator;
  private static final String jdField_a_of_type_JavaLangString = "GoogleTranslator";
  
  private GoogleTranslator()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static GoogleTranslator a()
  {
    try
    {
      if (a == null) {
        a = new GoogleTranslator();
      }
      return a;
    }
    finally {}
  }
  
  public void a(Context paramContext, List paramList, Language paramLanguage, String paramString, Long paramLong, TranslateWithTimeCallback paramTranslateWithTimeCallback)
  {
    if (paramLanguage == null) {
      paramLanguage = Language.CHINESE_SIMPLIFIED.toString();
    }
    Object localObject;
    for (;;)
    {
      localObject = new ArrayList();
      ((List)localObject).add(new Pair("key", paramString));
      ((List)localObject).add(new Pair("target", paramLanguage));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((List)localObject).add(new Pair("q", (String)paramList.next()));
      }
      localObject = paramLanguage.toString();
      if (localObject != null)
      {
        paramLanguage = (Language)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        paramLanguage = Language.CHINESE_SIMPLIFIED.toString();
      }
    }
    gch.a(paramContext, null, (List)localObject, new gci(this, paramTranslateWithTimeCallback, paramLong));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\rookery\translate\google\GoogleTranslator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */