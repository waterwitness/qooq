package cooperation.qzone;

import android.app.Dialog;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.text.SimpleDateFormat;
import java.util.Date;
import ykg;
import ykh;
import ykj;
import ykk;

public class LeakHelper
{
  public LeakHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("以下对象存在内存泄露：");
    localStringBuffer.append("\n");
    localStringBuffer.append(paramString);
    localStringBuffer.append("\n\n发现内存泄漏，请及时反馈。\n点击发送开始dump。\n文件路径:SD卡/tencent/MobileQQ/log\n时间：");
    localStringBuffer.append(new SimpleDateFormat("yyyy年MM月dd日    HH:mm:ss").format(new Date(System.currentTimeMillis())));
    return localStringBuffer.toString();
  }
  
  public static void a(String paramString)
  {
    Dialog localDialog = new Dialog(BaseApplicationImpl.a(), 2131558973);
    localDialog.getWindow().setType(2003);
    localDialog.setContentView(2130903236);
    TextView localTextView = (TextView)localDialog.findViewById(2131297840);
    if (localTextView != null) {
      localTextView.setText("Qzone内存泄露告警");
    }
    localTextView = (TextView)localDialog.findViewById(2131296852);
    paramString = a(paramString);
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
    paramString = (TextView)localDialog.findViewById(2131297843);
    if (paramString != null)
    {
      paramString.setText(2131367262);
      paramString.setOnClickListener(new ykg(localDialog));
    }
    paramString = (TextView)localDialog.findViewById(2131297844);
    if (paramString != null)
    {
      paramString.setText(2131370828);
      paramString.setOnClickListener(new ykh(localDialog));
    }
    localDialog.show();
  }
  
  private static void c(String paramString)
  {
    Dialog localDialog = new Dialog(BaseApplicationImpl.a(), 2131558973);
    localDialog.getWindow().setType(2003);
    localDialog.setContentView(2130903236);
    TextView localTextView = (TextView)localDialog.findViewById(2131297840);
    if (localTextView != null) {
      localTextView.setText("dump文件保存地址");
    }
    localTextView = (TextView)localDialog.findViewById(2131296852);
    if ((localTextView != null) && (paramString != null)) {
      localTextView.setText(paramString);
    }
    localTextView = (TextView)localDialog.findViewById(2131297843);
    if (localTextView != null)
    {
      localTextView.setText(2131367262);
      localTextView.setOnClickListener(new ykj(localDialog));
    }
    localTextView = (TextView)localDialog.findViewById(2131297844);
    if (localTextView != null)
    {
      localTextView.setText(2131370828);
      localTextView.setOnClickListener(new ykk(localDialog, paramString));
    }
    localDialog.show();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\LeakHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */