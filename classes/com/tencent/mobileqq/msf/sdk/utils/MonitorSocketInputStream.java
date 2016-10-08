package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.core.net.c.f;
import com.tencent.mobileqq.msf.core.net.g;
import com.tencent.mobileqq.msf.sdk.l;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class MonitorSocketInputStream
  extends InputStream
{
  private Context context;
  private InputStream mInputStream;
  private b monitorSocketImpl;
  
  public MonitorSocketInputStream(InputStream paramInputStream, b paramb, Context paramContext)
  {
    this.mInputStream = paramInputStream;
    this.monitorSocketImpl = paramb;
    this.context = paramContext;
  }
  
  public void close()
    throws IOException
  {
    this.mInputStream.close();
  }
  
  public int hashCode()
  {
    return this.mInputStream.hashCode();
  }
  
  public int read()
    throws IOException
  {
    return this.mInputStream.read();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 2;
    paramInt2 = this.mInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
    if (MonitorSocketImplFactory.isServerSocket(toString())) {
      return paramInt2;
    }
    try
    {
      paramInt1 = NetConnInfoCenterImpl.getSystemNetworkType();
      if (paramInt1 != 0) {
        break label1129;
      }
      paramArrayOfByte = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramArrayOfByte == null) {
        break label1129;
      }
      paramInt1 = paramArrayOfByte.getType();
      if (paramInt1 == 1) {
        paramInt1 = i;
      } else if (MonitorSocketImplFactory.isNetworkTypeMobile(paramInt1) == true) {
        paramInt1 = 1;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          a locala;
          QLog.d("MSF.D.MonitorSocket", 1, "analyze netflow failed.", paramArrayOfByte);
          break;
          if ((this.monitorSocketImpl.g != null) && (!this.monitorSocketImpl.g.equals(b.h)))
          {
            paramArrayOfByte = (a)this.monitorSocketImpl.i.get(Integer.valueOf(this.monitorSocketImpl.c.hashCode()));
            if (paramArrayOfByte == null) {
              locala = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 1, paramInt2, paramInt1);
            }
            for (locala.h = this.monitorSocketImpl.g;; locala.h = this.monitorSocketImpl.g)
            {
              locala.i = MonitorSocketStat.STATUS;
              paramArrayOfByte = locala;
              if (this.monitorSocketImpl.g.equals("qzone_video_player")) {
                break;
              }
              paramArrayOfByte = locala;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|" + locala.h + "|" + MonitorSocketStat.STATUS);
              paramArrayOfByte = locala;
              break;
              locala = paramArrayOfByte.a(paramInt2);
            }
          }
          if (g.n.contains(toString()))
          {
            paramArrayOfByte = null;
          }
          else if (f.f.contains(toString()))
          {
            locala = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 1, paramInt2, paramInt1);
            locala.h = "QualityTest";
            locala.i = MonitorSocketStat.STATUS;
            paramArrayOfByte = locala;
            if (QLog.isColorLevel())
            {
              QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|" + "QualityTest.PushList" + "|" + MonitorSocketStat.STATUS);
              paramArrayOfByte = locala;
            }
          }
          else
          {
            if (BaseApplication.exclusiveStreamList.contains(toString()))
            {
              if (QLog.isColorLevel())
              {
                QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|BigData" + "|" + MonitorSocketStat.STATUS);
                paramArrayOfByte = null;
              }
            }
            else
            {
              locala = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 1, paramInt2, paramInt1);
              locala.i = MonitorSocketStat.STATUS;
              i = this.monitorSocketImpl.d.indexOf("tencent.");
              if (i > -1)
              {
                i += 8;
                locala.h = this.monitorSocketImpl.d.substring(i, this.monitorSocketImpl.d.indexOf(".", i));
              }
              for (;;)
              {
                paramArrayOfByte = locala;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.d + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|" + locala.h + "|" + MonitorSocketStat.STATUS);
                paramArrayOfByte = locala;
                break;
                if (this.monitorSocketImpl.d.indexOf("_") > 0) {
                  locala.h = this.monitorSocketImpl.d.substring(0, this.monitorSocketImpl.d.indexOf("_"));
                } else {
                  locala.h = "unknown";
                }
              }
            }
            paramArrayOfByte = null;
          }
        }
      } while (paramInt2 != -1);
      return paramInt2;
    }
    if ((this.monitorSocketImpl.g != null) && (this.monitorSocketImpl.g.equals(b.h)))
    {
      locala = (a)this.monitorSocketImpl.i.get(Integer.valueOf(this.monitorSocketImpl.c.hashCode()));
      if (locala == null)
      {
        locala = new a(this.monitorSocketImpl.a, null, this.monitorSocketImpl.b, 1, paramInt2, paramInt1);
        locala.i = MonitorSocketStat.STATUS;
        locala.h = b.h;
        this.monitorSocketImpl.i.put(Integer.valueOf(this.monitorSocketImpl.c.hashCode()), locala);
      }
      for (;;)
      {
        paramArrayOfByte = locala;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.d + this.monitorSocketImpl.c + "|read|" + paramInt2 + "|" + paramInt1 + "|" + locala.h + "|" + MonitorSocketStat.STATUS);
          paramArrayOfByte = locala;
        }
        if ((paramArrayOfByte == null) || (paramArrayOfByte.h.equals(b.h))) {
          break;
        }
        MonitorSocketStat.dataFlow.add(paramArrayOfByte);
        this.monitorSocketImpl.i.clear();
        break;
        this.monitorSocketImpl.i.put(Integer.valueOf(this.monitorSocketImpl.c.hashCode()), locala.a(paramInt2));
      }
    }
    label1129:
    return paramInt2;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\msf\sdk\utils\MonitorSocketInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */