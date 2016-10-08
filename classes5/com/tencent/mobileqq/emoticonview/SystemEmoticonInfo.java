package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class SystemEmoticonInfo
  extends EmoticonInfo
{
  public static final int[] a;
  public static final String k = "KEY_STATIC_DRAWABLE_ID";
  public int a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfInt = new int[] { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 17, 60, 61, 92, 93, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142 };
  }
  
  public static List a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfInt.length)
    {
      SystemEmoticonInfo localSystemEmoticonInfo = new SystemEmoticonInfo();
      localSystemEmoticonInfo.jdField_a_of_type_Int = jdField_a_of_type_ArrayOfInt[i];
      localSystemEmoticonInfo.c = 1;
      localArrayList.add(localSystemEmoticonInfo);
      i += 1;
    }
    return localArrayList;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return TextUtils.a(this.jdField_a_of_type_Int, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if (this.d == 1) {
      ReportController.b(null, "CliOper", "", "", "0X8005507", "0X8005507", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      int i = paramEditText.getSelectionStart();
      int j = paramEditText.getSelectionEnd();
      paramEditText.getEditableText().replace(i, j, TextUtils.b(this.jdField_a_of_type_Int));
      paramEditText.requestFocus();
      return;
      if (this.d == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8005508", "0X8005508", 0, 0, "", "", "", "");
      }
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return TextUtils.a(this.jdField_a_of_type_Int, true);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\SystemEmoticonInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */