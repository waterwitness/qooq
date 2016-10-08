package com.tencent.mobileqq.text;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AccountNotMatchException;
import uzg;

public class QQText$SmallEmojiSpan
  extends QQText.EmotcationSpan
{
  private EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  int e;
  public int f;
  public int g;
  
  public QQText$SmallEmojiSpan(QQText paramQQText, char[] paramArrayOfChar, int paramInt, boolean paramBoolean)
  {
    super(paramQQText, -1, paramInt, 2);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.e = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramQQText = EmosmUtils.a(paramArrayOfChar);
    if ((paramQQText != null) && (paramQQText.length == 2))
    {
      this.f = paramQQText[0];
      this.g = paramQQText[1];
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQText", 2, "mEpId:" + this.f + ",mEId:" + this.g);
    }
    try
    {
      paramQQText = (AppInterface)BaseApplicationImpl.a().getAppRuntime(QQText.c());
      if (paramQQText != null) {
        this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)paramQQText.getManager(13));
      }
      return;
    }
    catch (AccountNotMatchException paramQQText)
    {
      for (;;)
      {
        paramQQText.printStackTrace();
        paramQQText = null;
      }
    }
    catch (ClassCastException paramQQText)
    {
      for (;;)
      {
        paramQQText.printStackTrace();
        paramQQText = null;
      }
    }
  }
  
  private void a()
  {
    ThreadManager.a(new uzg(this), 5, null, true);
  }
  
  public int a()
  {
    return this.f;
  }
  
  public String a()
  {
    String str = "[小表情]";
    Emoticon localEmoticon = null;
    if (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager != null) {
      localEmoticon = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(Integer.toString(this.f), Integer.toString(this.g));
    }
    if (localEmoticon != null) {
      str = localEmoticon.character;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQText", 2, "descp:" + str);
    }
    return str;
  }
  
  protected Drawable b()
  {
    Object localObject = new SmallEmoticonInfo(QQText.c());
    Emoticon localEmoticon = new Emoticon();
    localEmoticon.eId = String.valueOf(this.g);
    localEmoticon.epId = String.valueOf(this.f);
    if (!this.jdField_a_of_type_Boolean)
    {
      localEmoticon.jobType = 3;
      ((SmallEmoticonInfo)localObject).a = localEmoticon;
      localObject = ((SmallEmoticonInfo)localObject).a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
    }
    for (;;)
    {
      if (localObject != null) {
        ((Drawable)localObject).setBounds(0, 0, this.e, this.e);
      }
      return (Drawable)localObject;
      localEmoticon.jobType = 3;
      ((SmallEmoticonInfo)localObject).a = localEmoticon;
      localObject = ((SmallEmoticonInfo)localObject).b(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
      a();
    }
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramFontMetricsInt.ascent = (-this.e);
      paramFontMetricsInt.descent = 0;
      paramFontMetricsInt.top = paramFontMetricsInt.ascent;
      paramFontMetricsInt.bottom = 0;
    }
    return this.e;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\text\QQText$SmallEmojiSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */