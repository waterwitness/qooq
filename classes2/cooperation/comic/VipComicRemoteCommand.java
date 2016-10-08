package cooperation.comic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import mqq.os.MqqHandler;

public class VipComicRemoteCommand
  extends RemoteCommand
{
  public static final int a = 1;
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  public static final String a = "cacomicetinfo";
  public static final int b = 2;
  public static final String b = "Remotecall_getPublicAccountState";
  public static final int c = 3;
  public static final String c = "Remotecall_showPublicAccountDetail";
  public static final String d = "Remotecall_getUserStatus";
  public static final String e = "Remotecall_initQbPlugin";
  public static final String f = "Remotecall_showComicBar";
  public static final String g = "userStatus";
  public static final String h = "uin";
  public static final String i = "state";
  private static final String j = "VipComicRemoteCommand";
  boolean jdField_a_of_type_Boolean;
  
  public VipComicRemoteCommand(String paramString, boolean paramBoolean)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static Bundle a(Bundle paramBundle)
  {
    try
    {
      Bundle localBundle = jdField_a_of_type_AndroidOsBundle;
      jdField_a_of_type_AndroidOsBundle = paramBundle;
      return localBundle;
    }
    finally
    {
      paramBundle = finally;
      throw paramBundle;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = PluginCommunicationHandler.getInstance();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.register(new VipComicRemoteCommand("cacomicetinfo", true));
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    PublicAccountUtil.a(localIntent, paramQQAppInterface, BaseApplication.getContext(), paramString, -1);
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.b(paramString) != null;
    }
    return false;
  }
  
  private Bundle b(Bundle paramBundle)
  {
    Object localObject1 = BaseApplicationImpl.a().a();
    if (!(localObject1 instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicRemoteCommand", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    localObject1 = (QQAppInterface)localObject1;
    Object localObject2 = paramBundle.getString("cacomicetinfo");
    if ("Remotecall_getPublicAccountState".equals(localObject2))
    {
      paramBundle = paramBundle.getString("uin");
      if (!TextUtils.isEmpty(paramBundle))
      {
        boolean bool = a((QQAppInterface)localObject1, paramBundle);
        paramBundle = new Bundle();
        paramBundle.putBoolean("state", bool);
        return paramBundle;
      }
    }
    else
    {
      if (!"Remotecall_showPublicAccountDetail".equals(localObject2)) {
        break label122;
      }
      paramBundle = paramBundle.getString("uin");
      if (!TextUtils.isEmpty(paramBundle)) {
        a((QQAppInterface)localObject1, paramBundle);
      }
    }
    for (;;)
    {
      return null;
      label122:
      if ("Remotecall_getUserStatus".equals(localObject2))
      {
        paramBundle = new Bundle();
        if (VipUtils.a((QQAppInterface)localObject1)) {
          paramBundle.putInt("userStatus", 3);
        }
        for (;;)
        {
          return paramBundle;
          if (VipUtils.b((QQAppInterface)localObject1)) {
            paramBundle.putInt("userStatus", 2);
          } else {
            paramBundle.putInt("userStatus", 1);
          }
        }
      }
      if ("Remotecall_initQbPlugin".equals(localObject2))
      {
        try
        {
          QWalletHelper.a();
          if (QLog.isColorLevel()) {
            QLog.i("VipComicRemoteCommand", 2, "preloadQWallet()");
          }
          paramBundle = new Bundle();
          paramBundle.putBoolean("success", true);
          return paramBundle;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
      else if ("Remotecall_showComicBar".equals(localObject2))
      {
        localObject1 = ((QQAppInterface)localObject1).a(Conversation.class);
        if (localObject1 != null)
        {
          localObject2 = ((MqqHandler)localObject1).obtainMessage(1134039);
          ((Message)localObject2).obj = paramBundle;
          ((MqqHandler)localObject1).sendMessage((Message)localObject2);
          a(paramBundle);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("VipComicRemoteCommand", 2, "onRemoteInvoke unknow invokeCmd");
      }
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    paramBundle = b(paramBundle);
    if (paramOnInvokeFinishLinstener != null) {
      paramOnInvokeFinishLinstener.onInvokeFinish(paramBundle);
    }
    return paramBundle;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\VipComicRemoteCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */