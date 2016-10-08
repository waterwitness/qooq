package tencent.im.qapp.qvideoproj.qvideo_recom;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qvideo_recom$QueryRecomQunVideoRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "ret", "err", "total", "qun_infos" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null }, QueryRecomQunVideoRsp.class);
  public final PBStringField err = PBField.initString("");
  public final PBRepeatMessageField qun_infos = PBField.initRepeatMessage(qvideo_recom.QunInfo.class);
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tencent\im\qapp\qvideoproj\qvideo_recom\qvideo_recom$QueryRecomQunVideoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */