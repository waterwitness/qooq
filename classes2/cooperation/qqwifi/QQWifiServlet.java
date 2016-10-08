package cooperation.qqwifi;

import android.content.Intent;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import qqwifi.WiFiAccountReq;

public class QQWifiServlet
  extends MSFServlet
{
  public static final int a = 1;
  private static long a = 0L;
  public static String a;
  public static String b;
  public static String c;
  public static final String d = "QQWifiSvc.getAccount";
  public static final String e = "getAccount";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "QQWifiServlet";
    b = "MQQ.WiFiAccountServer.WiFiAccountObj";
    c = "cmd_id";
    jdField_a_of_type_Long = 4294967295L;
  }
  
  public static long a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      int i = 0;
      l1 = 0L;
      for (;;)
      {
        l2 = l1;
        if (i >= paramString.length()) {
          break;
        }
        l1 = l1 + paramString.charAt(i) & jdField_a_of_type_Long;
        l1 = l1 + (l1 << 10) & jdField_a_of_type_Long;
        l1 = (l1 ^ l1 >> 6) & jdField_a_of_type_Long;
        i += 1;
      }
    }
    long l2 = 0L;
    long l1 = l2 + (l2 << 3) & jdField_a_of_type_Long;
    l1 = (l1 ^ l1 >> 11) & jdField_a_of_type_Long;
    l2 = l1 + (l1 << 15) & jdField_a_of_type_Long;
    l1 = l2;
    if (l2 == 0L) {
      l1 = 1L;
    }
    return l1;
  }
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    paramPacket.addRequestPacket("req", new WiFiAccountReq(paramIntent.getLongExtra("uin", 0L), paramIntent.getLongExtra("seqno", 0L), paramIntent.getLongExtra("crc", 0L), paramIntent.getByteExtra("barsetting", (byte)0)));
    paramPacket.setServantName(b);
    paramPacket.setFuncName("getAccount");
    paramPacket.setSSOCommand("QQWifiSvc.getAccount");
    paramPacket.setNoResponse();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    byte b1 = 1;
    try
    {
      Long localLong1 = Long.valueOf(paramQQAppInterface.a());
      Long localLong2 = Long.valueOf(Math.abs(new Random(System.currentTimeMillis() + localLong1.longValue()).nextLong()));
      long l = a(HexUtil.bytes2HexStr(MessageDigest.getInstance("MD5").digest((localLong1 + "" + localLong2).getBytes("utf-8"))));
      NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a().getApplicationContext(), QQWifiServlet.class);
      localNewIntent.putExtra(c, 1);
      localNewIntent.putExtra("uin", localLong1);
      localNewIntent.putExtra("seqno", localLong2);
      localNewIntent.putExtra("crc", Long.valueOf(l));
      if (paramBoolean) {}
      for (;;)
      {
        localNewIntent.putExtra("barsetting", b1);
        paramQQAppInterface.startServlet(localNewIntent);
        return;
        b1 = 2;
      }
      return;
    }
    catch (NoSuchAlgorithmException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return;
    }
    catch (UnsupportedEncodingException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg) {}
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    switch (paramIntent.getIntExtra(c, 0))
    {
    default: 
      return;
    }
    a(paramIntent, paramPacket);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqwifi\QQWifiServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */