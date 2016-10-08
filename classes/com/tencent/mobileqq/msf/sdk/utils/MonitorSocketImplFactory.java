package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.util.HashSet;

public class MonitorSocketImplFactory
  implements SocketImplFactory
{
  private static HashSet mServerSocketSet = new HashSet();
  public static final String tag = "MSF.D.MonitorSocket";
  Context context;
  Class socketClass = null;
  SocketImpl socketImpl;
  
  public static void addServerSocket(String paramString)
  {
    mServerSocketSet.add(paramString);
  }
  
  public static boolean isNetworkTypeMobile(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean isServerSocket(String paramString)
  {
    return mServerSocketSet.contains(paramString);
  }
  
  public static void removeServerSocket(String paramString)
  {
    mServerSocketSet.remove(paramString);
  }
  
  public SocketImpl createSocketImpl()
  {
    return new b(this.socketClass, this.context);
  }
  
  public boolean getMsfSocketImpl(Context paramContext)
  {
    try
    {
      this.context = paramContext;
      paramContext = new Socket();
      Field localField = Socket.class.getDeclaredField("impl");
      localField.setAccessible(true);
      this.socketImpl = ((SocketImpl)localField.get(paramContext));
      this.socketClass = this.socketImpl.getClass();
      return true;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, "get SocketImpl failed " + paramContext.getMessage());
      }
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\utils\MonitorSocketImplFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */