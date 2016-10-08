import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class kym
  extends FriendListObserver
{
  public kym(ChatSettingActivity paramChatSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    ChatSettingActivity.d(this.a);
    ChatSettingActivity.c(this.a);
    if (paramBoolean2) {
      if (!ChatSettingActivity.a(this.a).endsWith(paramLong + "")) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        ChatSettingActivity.a(this.a, paramString, 1);
        return;
      }
    } while (!ChatSettingActivity.a(this.a).endsWith(paramLong + ""));
    if (paramBoolean1)
    {
      ChatSettingActivity.a(this.a, 2131368703, 1);
      return;
    }
    ChatSettingActivity.a(this.a, 2131368704, 1);
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (paramString.equals(ChatSettingActivity.a(this.a))) && (ChatSettingActivity.a(this.a) != null))
    {
      if ((ChatSettingActivity.a(this.a) == 1010) || (ChatSettingActivity.a(this.a) == 1001))
      {
        paramString = FaceDrawable.a(this.a.app, 200, ChatSettingActivity.a(this.a), true);
        ChatSettingActivity.a(this.a, new WeakReference(paramString));
        ChatSettingActivity.a(this.a).setImageDrawable(paramString);
      }
    }
    else {
      return;
    }
    if (ChatSettingActivity.a(this.a) == 1006)
    {
      paramString = FaceDrawable.b(this.a.app, ChatSettingActivity.a(this.a), (byte)3);
      ChatSettingActivity.a(this.a).setImageDrawable(paramString);
      return;
    }
    paramString = FaceDrawable.a(this.a.app, 1, ChatSettingActivity.a(this.a));
    ChatSettingActivity.a(this.a, new WeakReference(paramString));
    ChatSettingActivity.a(this.a).setImageDrawable(paramString);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      if ((ChatSettingActivity.a(this.a) == 0) && (ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).equals(paramString1)) && (paramString2 != null) && (!ChatSettingActivity.d(this.a).equals(paramString2)))
      {
        if ((ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
        {
          ChatSettingActivity.a(this.a, 2131370008, 2);
          ChatSettingActivity.a(this.a).dismiss();
        }
        ChatSettingActivity.b(this.a, paramString2);
        ChatSettingActivity.b(this.a, paramString2);
        ChatSettingActivity.c(this.a, paramString2);
      }
    }
    while (ChatSettingActivity.a(this.a) != 0) {
      return;
    }
    if ((ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).isShowing()) && (!this.a.isFinishing())) {
      ChatSettingActivity.a(this.a).dismiss();
    }
    ChatSettingActivity.b(this.a, ChatSettingActivity.d(this.a));
  }
  
  protected void a(boolean paramBoolean, ArrayList paramArrayList)
  {
    super.a(paramBoolean, paramArrayList);
    if ((ChatSettingActivity.a(this.a) == 0) && (paramBoolean) && (paramArrayList != null) && (paramArrayList.contains(ChatSettingActivity.a(this.a))))
    {
      if (QLog.isColorLevel()) {
        QLog.d(ChatSettingActivity.e(this.a), 2, "onUpdateHotFriendLevel");
      }
      paramArrayList = (FriendsManager)this.a.app.getManager(50);
      ExtensionInfo localExtensionInfo = paramArrayList.a(ChatSettingActivity.a(this.a), false);
      paramBoolean = paramArrayList.d();
      int i = paramArrayList.a(ChatSettingActivity.a(this.a), localExtensionInfo, 1, paramBoolean);
      int j = paramArrayList.b(ChatSettingActivity.a(this.a), localExtensionInfo, paramBoolean);
      int k = paramArrayList.c(ChatSettingActivity.a(this.a), localExtensionInfo, paramBoolean);
      int m = paramArrayList.a(ChatSettingActivity.a(this.a), localExtensionInfo, paramBoolean);
      ChatSettingActivity.a(this.a, j);
      ChatSettingActivity.b(this.a, i);
      ChatSettingActivity.c(this.a, k);
      ChatSettingActivity.d(this.a, m);
      ChatSettingActivity.a(this.a, paramArrayList, localExtensionInfo);
    }
  }
  
  protected void a(boolean paramBoolean, Map paramMap) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null) && (this.a.a != null) && (ChatSettingActivity.a(this.a) == 0) && (!TextUtils.isEmpty(ChatSettingActivity.a(this.a))))
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfString[i];
        if (ChatSettingActivity.a(this.a).equals(str)) {
          ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a)), this.a.a);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString, Map paramMap)
  {
    if ((this.a.a != null) && (!TextUtils.isEmpty(ChatSettingActivity.a(this.a))) && (paramMap != null) && (paramMap.containsKey(ChatSettingActivity.a(this.a)))) {
      ChatSettingActivity.a(this.a, (RichStatus)paramMap.get(ChatSettingActivity.a(this.a)), this.a.a);
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.b(this.a) != null) && (paramString.equals(ChatSettingActivity.b(this.a))))
    {
      paramString = FaceDrawable.b(this.a.app, paramString, (byte)3);
      ChatSettingActivity.a(this.a).setImageDrawable(paramString);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kym.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */