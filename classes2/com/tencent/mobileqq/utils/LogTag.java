package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class LogTag
{
  public static final String a = "StartRecordTime";
  private static ThreadLocal a = new ThreadLocal();
  public static final String b = "ThemeDownloadTrace";
  public static final String c = "SelectPhotoTrace";
  public static final String d = "AIOSign";
  public static final String e = "VoiceTipMsg";
  public static final String f = "AIOQzoneFeed";
  public static final String g = "AIOAudioPanel";
  public static final String h = "PEAK";
  public static final String i = "PEAK_ACTIVITY";
  public static final String j;
  public static final String k;
  public static final String l;
  public static final String m = "PEAK_CAMERA";
  public static final String n = "peak_pgjpeg";
  public static final String o = "PreUploadVideo";
  public static final String p = "prepare";
  public static final String q = "checking";
  public static final String r = "start";
  public static final String s = "segment";
  public static final String t = "svrcomp_s";
  public static final String u = "svrcomp_r";
  public static final String v = "clicomp";
  public static final String w = "replace";
  public static final String x = "rollback";
  public static final String y = "message";
  public static final String z = "report";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    j = PhotoListActivity.class.getSimpleName();
    k = AlbumListActivity.class.getSimpleName();
    l = PhotoPreviewActivity.class.getSimpleName();
  }
  
  public static void a()
  {
    if (QLog.isColorLevel())
    {
      LinkedList localLinkedList2 = (LinkedList)a.get();
      LinkedList localLinkedList1 = localLinkedList2;
      if (localLinkedList2 == null)
      {
        localLinkedList1 = new LinkedList();
        a.set(localLinkedList1);
      }
      localLinkedList1.addFirst(Long.valueOf(SystemClock.uptimeMillis()));
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo) {}
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = (LinkedList)a.get();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedList();
        a.set(localObject1);
        ((LinkedList)localObject1).addFirst(Long.valueOf(SystemClock.uptimeMillis()));
      }
      localObject2 = new StringBuilder();
      int i1 = 1;
      while (i1 < ((LinkedList)localObject1).size())
      {
        ((StringBuilder)localObject2).append("    ");
        i1 += 1;
      }
      if (((LinkedList)a.get()).size() != 0) {}
    }
    else
    {
      return;
    }
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(":cost ");
    ((StringBuilder)localObject2).append(SystemClock.uptimeMillis() - ((Long)((LinkedList)a.get()).removeFirst()).longValue());
    ((StringBuilder)localObject2).append("ms");
    QLog.i(paramString1, 2, ((StringBuilder)localObject2).toString());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("PreUploadVideo");
      localStringBuilder.append("[").append(paramString1).append("] ");
      if (paramString2 != null) {
        localStringBuilder.append("status:").append(paramString2).append(" ");
      }
      localStringBuilder.append("content:").append(paramString3);
      QLog.i("PreUploadVideo", 2, localStringBuilder.toString());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\LogTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */