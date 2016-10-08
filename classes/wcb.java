import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;

public class wcb
  implements EmoticonCallback
{
  public wcb(QQCustomDialogWtihEmoticonInput paramQQCustomDialogWtihEmoticonInput)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    int i;
    int j;
    if ((paramEmoticonInfo instanceof SystemEmoticonInfo))
    {
      i = QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionStart();
      j = QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionEnd();
      if ((i < 0) || (j < 0) || (j < i)) {}
    }
    int k;
    int m;
    do
    {
      QQCustomDialogWtihEmoticonInput.a(this.a).getEditableText().replace(i, j, com.tencent.mobileqq.text.TextUtils.b(((SystemEmoticonInfo)paramEmoticonInfo).a));
      do
      {
        return;
      } while (!(paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo));
      paramEmoticonInfo = (SystemAndEmojiEmoticonInfo)paramEmoticonInfo;
      i = QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionStart();
      j = QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionEnd();
      k = paramEmoticonInfo.i;
      m = paramEmoticonInfo.j;
    } while ((i < 0) || (j < 0) || (j < i) || ((k == 2) && (m == -1)));
    if (k == 1) {}
    for (paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.b(m);; paramEmoticonInfo = com.tencent.mobileqq.text.TextUtils.a(m))
    {
      QQCustomDialogWtihEmoticonInput.a(this.a).getEditableText().replace(i, j, paramEmoticonInfo);
      QQCustomDialogWtihEmoticonInput.a(this.a).requestFocus();
      return;
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return true;
  }
  
  public void b()
  {
    if (QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = QQCustomDialogWtihEmoticonInput.a(this.a).getText();
        int i = QQCustomDialogWtihEmoticonInput.a(this.a).getSelectionStart();
        int j = android.text.TextUtils.getOffsetBefore(QQCustomDialogWtihEmoticonInput.a(this.a).getText(), i);
        if (i != j)
        {
          localEditable.delete(Math.min(i, j), Math.max(i, j));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void c() {}
  
  public void d() {}
  
  public void setting() {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */