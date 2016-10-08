import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

class rwq
  extends BroadcastReceiver
{
  rwq(rwp paramrwp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equalsIgnoreCase("com.opensdk.downloadmanager.renameFilename")))
    {
      localBundle = paramIntent.getBundleExtra("extraBundle");
      if (localBundle != null) {
        break label46;
      }
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "INTENT_ACTION_RENAME_FILENAME extra is null!!!");
      }
    }
    return;
    label46:
    paramContext = localBundle.getString("peerUin");
    int i = localBundle.getInt("peerType");
    paramIntent = localBundle.getString("sourceStr");
    String str = localBundle.getString("filePath");
    long l = localBundle.getLong("dataLength");
    int j = localBundle.getInt("fileSourceId");
    Bundle localBundle = localBundle.getBundle("otherData");
    this.a.a.a(paramContext, i, str, l, j, paramIntent, localBundle);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\rwq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */