package com.tencent.av.guild;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.av.app.SessionInfo.HeroDetail;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import giq;
import gir;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.TicketManager;

public class GameHeroesProtocol
{
  static final String a = "GameHeroesProtocol";
  static final String b = "http://league.gamecenter.qq.com/cgi-bin/gc_league_asyn_fcgi";
  public VideoAppInterface a;
  public giq a;
  public Map a;
  public String c;
  public String d;
  public String e;
  
  GameHeroesProtocol(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_Giq = null;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.c = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount();
    this.d = "6.5.5";
    this.e = ((TicketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getManager(2)).getSkey(this.c);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        str = ImageResUtil.a() + MD5.toMD5(paramString) + paramString.substring(paramString.lastIndexOf("."));
        if (!FileUtil.a(str))
        {
          File localFile = new File(str);
          boolean bool = HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString, localFile);
          if (QLog.isColorLevel()) {
            QLog.d("GameHeroesProtocol", 2, "[GameHeroesProtocol] download hero url=" + paramString + ", path=" + str + ", ret=" + bool);
          }
          bool = FileUtil.a(str);
          paramString = (String)localObject;
          if (!bool) {}
        }
      }
      catch (Exception paramString)
      {
        String str;
        return null;
      }
      try
      {
        paramString = BitmapFactory.decodeFile(str);
        return paramString;
      }
      catch (OutOfMemoryError paramString) {}
      if (QLog.isColorLevel()) {
        QLog.d("GameHeroesProtocol", 2, "[GameHeroesProtocol] download hero exited file=" + str);
      }
    }
    return null;
  }
  
  void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == -1L) || (paramLong2 == -1L)) {}
    Object localObject;
    do
    {
      return;
      localObject = "" + paramLong1 + paramLong2;
      localObject = (gir)this.jdField_a_of_type_JavaUtilMap.get(localObject);
    } while (localObject == null);
    ((gir)localObject).a();
  }
  
  void a(giq paramgiq)
  {
    this.jdField_a_of_type_Giq = paramgiq;
  }
  
  void a(String paramString, long paramLong, SessionInfo.HeroDetail paramHeroDetail)
  {
    if (paramHeroDetail == null) {
      return;
    }
    if (paramString != null) {}
    for (;;)
    {
      String str;
      try
      {
        l = Long.parseLong(paramString);
        if ((l == -1L) || (paramLong == -1L))
        {
          paramHeroDetail.a -= 1;
          if (this.jdField_a_of_type_Giq == null) {
            break;
          }
          this.jdField_a_of_type_Giq.a();
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l = -1L;
        continue;
        str = "" + l + paramLong;
      }
      if ((gir)this.jdField_a_of_type_JavaUtilMap.get(str) != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GameHeroesProtocol", 2, "[GameHeroesProtocol] ====== pull info ====== uin(" + paramString + "), groupId(" + paramLong + ")");
      }
      paramString = new gir(this, l, paramLong, paramHeroDetail);
      this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      paramString.start();
      return;
      long l = -1L;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\guild\GameHeroesProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */