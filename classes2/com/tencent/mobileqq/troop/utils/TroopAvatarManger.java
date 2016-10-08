package com.tencent.mobileqq.troop.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider.SosoSrvAddrType;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;
import java.util.Random;

public class TroopAvatarManger
{
  public static int a = 0;
  protected static Map a;
  protected static final String f = "htdata3.qq.com";
  protected static final String g = "htdata4.qq.com";
  protected static final String h = "http://14.17.18.20:80";
  protected static final String i = "http://112.90.139.96:80";
  protected TroopHandler a;
  protected final String a;
  protected final String b;
  protected final String c;
  protected final String d;
  protected final String e;
  public String j;
  
  public TroopAvatarManger(String paramString, Class paramClass, TroopHandler paramTroopHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "0x6ff0072";
    this.b = "5520";
    this.c = "3";
    this.d = "5";
    this.e = "ip/cgi-bin/httpconn?";
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = paramTroopHandler;
    this.j = paramString;
    if (jdField_a_of_type_JavaUtilMap == null) {
      jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    if ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      paramClass = UploadingFactory.a(paramClass);
      jdField_a_of_type_JavaUtilMap.put(paramString, paramClass);
    }
  }
  
  protected String a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Object localObject = SosoSrvAddrProvider.a();
    ((SosoSrvAddrProvider)localObject).c();
    paramAppInterface = null;
    if (localObject != null) {
      paramAppInterface = ((SosoSrvAddrProvider)localObject).a(SosoSrvAddrProvider.SosoSrvAddrType.URL_ENCODE_SRV);
    }
    if (paramAppInterface != null) {
      paramAppInterface = "ip/cgi-bin/httpconn?".replace("ip", paramAppInterface);
    }
    for (;;)
    {
      return paramAppInterface + "htcmd=" + "0x6ff0072" + "&ver=" + "5520" + "&ukey=" + paramString5 + "&range=" + paramString2 + "&uin=" + paramString4 + "&seq=23" + "&groupuin=" + paramString3 + "&filetype=" + "3" + "&imagetype=" + "5" + "&userdata=" + paramString1;
      try
      {
        paramAppInterface = InetAddress.getByName("htdata3.qq.com").getHostAddress();
        paramAppInterface = "ip/cgi-bin/httpconn?".replace("ip", "http://" + paramAppInterface + ":80");
        k = 1;
        if (k != 0) {}
      }
      catch (UnknownHostException paramAppInterface)
      {
        try
        {
          localObject = InetAddress.getByName("htdata4.qq.com").getHostAddress();
          localObject = paramAppInterface.replace("ip", "http://" + (String)localObject + ":80");
          paramAppInterface = (AppInterface)localObject;
          continue;
          paramAppInterface = paramAppInterface;
          paramAppInterface.printStackTrace();
          int k = 0;
          paramAppInterface = "ip/cgi-bin/httpconn?";
        }
        catch (UnknownHostException localUnknownHostException)
        {
          if (new Random(100L).nextInt() / 2 == 0) {}
          for (localObject = "http://14.17.18.20:80";; localObject = "http://112.90.139.96:80")
          {
            paramAppInterface = paramAppInterface.replace("ip", (CharSequence)localObject);
            localUnknownHostException.printStackTrace();
            break;
          }
        }
      }
    }
  }
  
  public ArrayList a()
  {
    return ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.j)).a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = null;
  }
  
  public void a(Class paramClass, AppInterface paramAppInterface, ArrayList paramArrayList, String paramString1, String paramString2, String paramString3, HashMap paramHashMap)
  {
    ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.j)).a(paramClass, paramArrayList, paramHashMap, a(paramAppInterface, "0", "0", paramString1, paramString3, paramString2));
  }
  
  public void a(String paramString)
  {
    ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.j)).a(paramString);
  }
  
  public void a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(paramString, paramInt, paramArrayList);
    }
  }
  
  public void a(Observer paramObserver)
  {
    ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.j)).addObserver(paramObserver);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.d(paramString);
    }
  }
  
  public void b(Observer paramObserver)
  {
    ((UploadingTask)jdField_a_of_type_JavaUtilMap.get(this.j)).a(paramObserver);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopAvatarManger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */