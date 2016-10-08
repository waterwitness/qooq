package cooperation.comic.emoticon;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;

public class VipComicEmoticonUploadRemoteCmd
  extends RemoteCommand
{
  public static final int a = -1;
  public static final String a = "VipComicEmoticonUploadRemoteCmd";
  public static final int b = 0;
  public static final String b = "qqcomicemoticonipccmd";
  public static final int c = 1;
  public static final String c = "Remotecall_uploadEmoticon";
  public static final String d = "localPath";
  public static final String e = "id";
  public static final String f = "picMd5";
  public static final String g = "comicId";
  public static final String h = "actionData";
  public static final String i = "result";
  public static final String j = "errCode";
  public static final String k = "errMsg";
  private boolean a;
  
  public VipComicEmoticonUploadRemoteCmd(String paramString, boolean paramBoolean)
  {
    super(paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramBoolean;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = PluginCommunicationHandler.getInstance();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.register(new VipComicEmoticonUploadRemoteCmd("qqcomicemoticonipccmd", false));
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    Object localObject = BaseApplicationImpl.a().a();
    if (!(localObject instanceof QQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicEmoticonUploadRemoteCmd", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
    }
    do
    {
      do
      {
        return null;
        localObject = (QQAppInterface)localObject;
      } while (!"Remotecall_uploadEmoticon".equals(paramBundle.getString("qqcomicemoticonipccmd")));
      localObject = (VipComicEmoticonUploadManager)((QQAppInterface)localObject).getManager(146);
    } while (localObject == null);
    ((VipComicEmoticonUploadManager)localObject).a(paramBundle, paramOnInvokeFinishLinstener);
    return null;
  }
  
  public boolean isSynchronized()
  {
    return this.a;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\comic\emoticon\VipComicEmoticonUploadRemoteCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */