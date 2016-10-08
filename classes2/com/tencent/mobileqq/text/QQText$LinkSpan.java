package com.tencent.mobileqq.text;

import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QQText$LinkSpan
  extends ClickableSpan
{
  public String a;
  
  public QQText$LinkSpan(QQText paramQQText, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof String)) {
      QQText.a((String)localObject);
    }
    localObject = this.jdField_a_of_type_JavaLangString;
    boolean bool2 = Patterns.c.matcher((CharSequence)localObject).find();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = Patterns.b.matcher((CharSequence)localObject).find();
    }
    if (bool1) {
      if (BubbleContextMenu.a) {
        if (QLog.isColorLevel()) {
          QLog.e("LinkSpan", 2, "LinkSpan.onCLick is invoked by LongClick misstake");
        }
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTextQQText.a(paramView, (String)localObject);
      QQText.a("0", null);
      return;
      Matcher localMatcher = QQText.b.matcher((CharSequence)localObject);
      if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == ((String)localObject).length()))
      {
        QQText.a(paramView.getContext(), (String)localObject, true);
        QQText.a("1", null);
        return;
      }
    } while (!QQText.d.matcher((CharSequence)localObject).find());
    QQText.a(paramView.getContext(), (String)localObject, false);
    QQText.a("2", null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\text\QQText$LinkSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */