package cooperation.qzone.patch;

import android.content.Intent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.plugin.PluginIntent;
import cooperation.qzone.plugin.PluginIntent.OnResultListner;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneUpdatePatchServlet
  extends MSFServlet
{
  private static final int jdField_a_of_type_Int = 60000;
  private static final String jdField_a_of_type_JavaLangString = "qz_patch";
  
  public QzoneUpdatePatchServlet()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent != null) && ((paramIntent instanceof PluginIntent)))
    {
      PluginIntent.OnResultListner localOnResultListner = ((PluginIntent)paramIntent).a();
      if (localOnResultListner != null) {
        localOnResultListner.a(paramIntent, paramFromServiceMsg);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = null;
    if ((paramIntent instanceof PluginIntent)) {
      localObject = ((PluginIntent)paramIntent).a;
    }
    QZonePatchRequest localQZonePatchRequest = new QZonePatchRequest(getAppRuntime().getLongAccountUin(), (ArrayList)localObject);
    localObject = localQZonePatchRequest.encode();
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localQZonePatchRequest.uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\patch\QzoneUpdatePatchServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */