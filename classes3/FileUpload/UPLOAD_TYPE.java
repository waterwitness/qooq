package FileUpload;

import java.io.Serializable;

public final class UPLOAD_TYPE
  implements Serializable
{
  public static final UPLOAD_TYPE BOX_TYPE;
  public static final UPLOAD_TYPE DYNAMIC_FACE_TYPE;
  public static final UPLOAD_TYPE GET_VIDEO_TYPE;
  public static final UPLOAD_TYPE GROUP_APP_GROUP_HEAD_TYPE;
  public static final UPLOAD_TYPE GROUP_APP_PERSON_HEAD_TYPE;
  public static final UPLOAD_TYPE GROUP_SOUND_TYPE;
  public static final UPLOAD_TYPE LIVEPHOTO_PIC_TYPE;
  public static final UPLOAD_TYPE LIVEPHOTO_VIDEO_TYPE;
  public static final UPLOAD_TYPE MOBILE_LOG_TYPE;
  public static final UPLOAD_TYPE PHOTOWALL_TYPE;
  public static final UPLOAD_TYPE PHOTO_DESK_TYPE;
  public static final UPLOAD_TYPE PICSHOW_TYPE;
  public static final UPLOAD_TYPE PICSHOW_TYPE_V2;
  public static final UPLOAD_TYPE PIC_GET_TYPE;
  public static final UPLOAD_TYPE PIC_QZONE_TYPE;
  public static final UPLOAD_TYPE PIC_SWEET_TYPE;
  public static final UPLOAD_TYPE PIC_WESHOW_TYPE;
  public static final UPLOAD_TYPE PIC_ZEBRA_HEAD_TYPE;
  public static final UPLOAD_TYPE QIANDAO_UPS_TYPE;
  public static final UPLOAD_TYPE QQLIFE_VIDEO_MATTER;
  public static final UPLOAD_TYPE QQNOTE_FUJIAN_TYPE;
  public static final UPLOAD_TYPE QQNOTE_PIC_TYPE;
  public static final UPLOAD_TYPE QQNOTE_SOUND_TYPE;
  public static final UPLOAD_TYPE QQNOTE_VIDEO_TYPE;
  public static final UPLOAD_TYPE QQ_QUN_PIC_TYPE;
  public static final UPLOAD_TYPE QQ_QUN_PIC_V2_TYPE;
  public static final UPLOAD_TYPE QQ_RADIO_HEAD_TYPE;
  public static final UPLOAD_TYPE QZONE_HEAD_TYPE;
  public static final UPLOAD_TYPE QZONE_LIVE_VIDEO_CMT_TYPE;
  public static final UPLOAD_TYPE QZONE_UPS_TYPE;
  public static final UPLOAD_TYPE SMART_VIDEO_TYPE;
  public static final UPLOAD_TYPE SOUND_QZONE_TYPE;
  public static final UPLOAD_TYPE SOUND_SWEET_TYPE;
  public static final UPLOAD_TYPE TIEBAN_TYPE;
  public static final UPLOAD_TYPE UPP_TYPE;
  public static final UPLOAD_TYPE UPP_TYPE_V2;
  public static final UPLOAD_TYPE VIDEO_QZONE_TYPE;
  public static final UPLOAD_TYPE WEIYUN_TYPE;
  public static final int _BOX_TYPE = 23;
  public static final int _DYNAMIC_FACE_TYPE = 20;
  public static final int _GET_VIDEO_TYPE = 35;
  public static final int _GROUP_APP_GROUP_HEAD_TYPE = 26;
  public static final int _GROUP_APP_PERSON_HEAD_TYPE = 25;
  public static final int _GROUP_SOUND_TYPE = 28;
  public static final int _LIVEPHOTO_PIC_TYPE = 33;
  public static final int _LIVEPHOTO_VIDEO_TYPE = 34;
  public static final int _MOBILE_LOG_TYPE = 36;
  public static final int _PHOTOWALL_TYPE = 17;
  public static final int _PHOTO_DESK_TYPE = 5;
  public static final int _PICSHOW_TYPE = 9;
  public static final int _PICSHOW_TYPE_V2 = 19;
  public static final int _PIC_GET_TYPE = 31;
  public static final int _PIC_QZONE_TYPE = 0;
  public static final int _PIC_SWEET_TYPE = 6;
  public static final int _PIC_WESHOW_TYPE = 27;
  public static final int _PIC_ZEBRA_HEAD_TYPE = 29;
  public static final int _QIANDAO_UPS_TYPE = 21;
  public static final int _QQLIFE_VIDEO_MATTER = 18;
  public static final int _QQNOTE_FUJIAN_TYPE = 16;
  public static final int _QQNOTE_PIC_TYPE = 11;
  public static final int _QQNOTE_SOUND_TYPE = 10;
  public static final int _QQNOTE_VIDEO_TYPE = 15;
  public static final int _QQ_QUN_PIC_TYPE = 12;
  public static final int _QQ_QUN_PIC_V2_TYPE = 22;
  public static final int _QQ_RADIO_HEAD_TYPE = 30;
  public static final int _QZONE_HEAD_TYPE = 3;
  public static final int _QZONE_LIVE_VIDEO_CMT_TYPE = 37;
  public static final int _QZONE_UPS_TYPE = 13;
  public static final int _SMART_VIDEO_TYPE = 14;
  public static final int _SOUND_QZONE_TYPE = 2;
  public static final int _SOUND_SWEET_TYPE = 7;
  public static final int _TIEBAN_TYPE = 8;
  public static final int _UPP_TYPE = 4;
  public static final int _UPP_TYPE_V2 = 24;
  public static final int _VIDEO_QZONE_TYPE = 1;
  public static final int _WEIYUN_TYPE = 32;
  private static UPLOAD_TYPE[] a;
  private int b;
  private String c = new String();
  
  static
  {
    if (!UPLOAD_TYPE.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      a = new UPLOAD_TYPE[38];
      PIC_QZONE_TYPE = new UPLOAD_TYPE(0, 0, "PIC_QZONE_TYPE");
      VIDEO_QZONE_TYPE = new UPLOAD_TYPE(1, 1, "VIDEO_QZONE_TYPE");
      SOUND_QZONE_TYPE = new UPLOAD_TYPE(2, 2, "SOUND_QZONE_TYPE");
      QZONE_HEAD_TYPE = new UPLOAD_TYPE(3, 3, "QZONE_HEAD_TYPE");
      UPP_TYPE = new UPLOAD_TYPE(4, 4, "UPP_TYPE");
      PHOTO_DESK_TYPE = new UPLOAD_TYPE(5, 5, "PHOTO_DESK_TYPE");
      PIC_SWEET_TYPE = new UPLOAD_TYPE(6, 6, "PIC_SWEET_TYPE");
      SOUND_SWEET_TYPE = new UPLOAD_TYPE(7, 7, "SOUND_SWEET_TYPE");
      TIEBAN_TYPE = new UPLOAD_TYPE(8, 8, "TIEBAN_TYPE");
      PICSHOW_TYPE = new UPLOAD_TYPE(9, 9, "PICSHOW_TYPE");
      QQNOTE_SOUND_TYPE = new UPLOAD_TYPE(10, 10, "QQNOTE_SOUND_TYPE");
      QQNOTE_PIC_TYPE = new UPLOAD_TYPE(11, 11, "QQNOTE_PIC_TYPE");
      QQ_QUN_PIC_TYPE = new UPLOAD_TYPE(12, 12, "QQ_QUN_PIC_TYPE");
      QZONE_UPS_TYPE = new UPLOAD_TYPE(13, 13, "QZONE_UPS_TYPE");
      SMART_VIDEO_TYPE = new UPLOAD_TYPE(14, 14, "SMART_VIDEO_TYPE");
      QQNOTE_VIDEO_TYPE = new UPLOAD_TYPE(15, 15, "QQNOTE_VIDEO_TYPE");
      QQNOTE_FUJIAN_TYPE = new UPLOAD_TYPE(16, 16, "QQNOTE_FUJIAN_TYPE");
      PHOTOWALL_TYPE = new UPLOAD_TYPE(17, 17, "PHOTOWALL_TYPE");
      QQLIFE_VIDEO_MATTER = new UPLOAD_TYPE(18, 18, "QQLIFE_VIDEO_MATTER");
      PICSHOW_TYPE_V2 = new UPLOAD_TYPE(19, 19, "PICSHOW_TYPE_V2");
      DYNAMIC_FACE_TYPE = new UPLOAD_TYPE(20, 20, "DYNAMIC_FACE_TYPE");
      QIANDAO_UPS_TYPE = new UPLOAD_TYPE(21, 21, "QIANDAO_UPS_TYPE");
      QQ_QUN_PIC_V2_TYPE = new UPLOAD_TYPE(22, 22, "QQ_QUN_PIC_V2_TYPE");
      BOX_TYPE = new UPLOAD_TYPE(23, 23, "BOX_TYPE");
      UPP_TYPE_V2 = new UPLOAD_TYPE(24, 24, "UPP_TYPE_V2");
      GROUP_APP_PERSON_HEAD_TYPE = new UPLOAD_TYPE(25, 25, "GROUP_APP_PERSON_HEAD_TYPE");
      GROUP_APP_GROUP_HEAD_TYPE = new UPLOAD_TYPE(26, 26, "GROUP_APP_GROUP_HEAD_TYPE");
      PIC_WESHOW_TYPE = new UPLOAD_TYPE(27, 27, "PIC_WESHOW_TYPE");
      GROUP_SOUND_TYPE = new UPLOAD_TYPE(28, 28, "GROUP_SOUND_TYPE");
      PIC_ZEBRA_HEAD_TYPE = new UPLOAD_TYPE(29, 29, "PIC_ZEBRA_HEAD_TYPE");
      QQ_RADIO_HEAD_TYPE = new UPLOAD_TYPE(30, 30, "QQ_RADIO_HEAD_TYPE");
      PIC_GET_TYPE = new UPLOAD_TYPE(31, 31, "PIC_GET_TYPE");
      WEIYUN_TYPE = new UPLOAD_TYPE(32, 32, "WEIYUN_TYPE");
      LIVEPHOTO_PIC_TYPE = new UPLOAD_TYPE(33, 33, "LIVEPHOTO_PIC_TYPE");
      LIVEPHOTO_VIDEO_TYPE = new UPLOAD_TYPE(34, 34, "LIVEPHOTO_VIDEO_TYPE");
      GET_VIDEO_TYPE = new UPLOAD_TYPE(35, 35, "GET_VIDEO_TYPE");
      MOBILE_LOG_TYPE = new UPLOAD_TYPE(36, 36, "MOBILE_LOG_TYPE");
      QZONE_LIVE_VIDEO_CMT_TYPE = new UPLOAD_TYPE(37, 37, "QZONE_LIVE_VIDEO_CMT_TYPE");
      return;
    }
  }
  
  private UPLOAD_TYPE(int paramInt1, int paramInt2, String paramString)
  {
    this.c = paramString;
    this.b = paramInt2;
    a[paramInt1] = this;
  }
  
  public static UPLOAD_TYPE convert(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!d) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static UPLOAD_TYPE convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    if (!d) {
      throw new AssertionError();
    }
    return null;
  }
  
  public final String toString()
  {
    return this.c;
  }
  
  public final int value()
  {
    return this.b;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\FileUpload\UPLOAD_TYPE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */