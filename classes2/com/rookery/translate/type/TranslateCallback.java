package com.rookery.translate.type;

import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder.Holder;

public abstract interface TranslateCallback
{
  public abstract void a(long paramLong, String paramString1, Language paramLanguage, String paramString2, TextTranslationItemBuilder.Holder paramHolder);
  
  public abstract void a(long paramLong, String paramString, TranslateError paramTranslateError, TextTranslationItemBuilder.Holder paramHolder);
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\rookery\translate\type\TranslateCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */