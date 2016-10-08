package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontFreshReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckReq.TMd5Info;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckRsp;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontMd5CheckRsp.TMd5Ret;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontSsoReq;
import com.tencent.pb.vipfontupdate.VipFontUpdate.TFontSsoRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class SVIPHandler
  extends BusinessHandler
{
  public static final int a = 100;
  protected static final long a = 5000L;
  static final String jdField_a_of_type_JavaLangString = "SVIPHandler";
  public static final int b = 101;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  private static final int g = 0;
  private boolean jdField_a_of_type_Boolean;
  private int h;
  private int i;
  private int j;
  private int k;
  
  SVIPHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.h = -1;
    this.i = -1;
    this.j = -1;
    this.k = -1;
  }
  
  public static int a(long paramLong)
  {
    return (int)(0xFFFFFFFFFFFFFFFF & paramLong);
  }
  
  public static long a(int paramInt1, int paramInt2)
  {
    return paramInt2 << 32 | paramInt1;
  }
  
  public static int b(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (FontManager)this.b.getManager(41);
    if (QLog.isColorLevel()) {
      QLog.d("SVIPHandler", 2, "handleGetUserFont isSuccess = " + paramFromServiceMsg.isSuccess() + " data = " + StructLongMessageDownloadProcessor.a((byte[])paramObject));
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      paramObject = new VipFontUpdate.TFontSsoRsp();
    }
    for (;;)
    {
      try
      {
        ((VipFontUpdate.TFontSsoRsp)paramObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = (VipFontUpdate.TFontMd5CheckRsp)((VipFontUpdate.TFontSsoRsp)paramObject).st_md5_check_rsp.get();
        if ((paramFromServiceMsg.rpt_md5_ret.has()) && (paramFromServiceMsg.rpt_md5_ret.get().size() > 0))
        {
          paramFromServiceMsg = (VipFontUpdate.TFontMd5CheckRsp.TMd5Ret)paramFromServiceMsg.rpt_md5_ret.get().get(0);
          int m = paramFromServiceMsg.i32_check_ret.get();
          int n = paramFromServiceMsg.i32_check_font_id.get();
          if (QLog.isColorLevel()) {
            QLog.d("SVIPHandler", 2, "handleGetUserFont fontid = " + n + " md5ret = " + m);
          }
          if ((n == a()) && (m > 0)) {
            paramToServiceMsg.a(n);
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("SVIPHandler", 1, "handleGetUserFont error: " + paramFromServiceMsg.getMessage());
        continue;
      }
      paramToServiceMsg.h.set(true);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("SVIPHandler", 2, "handleGetUserFont response not success message = " + paramFromServiceMsg.getResultCode());
      }
    }
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 44	com/tencent/mobileqq/app/SVIPHandler:j	I
    //   6: iconst_m1
    //   7: if_icmpne +53 -> 60
    //   10: aload_0
    //   11: getfield 57	com/tencent/mobileqq/app/SVIPHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: bipush 50
    //   16: invokevirtual 63	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   19: checkcast 196	com/tencent/mobileqq/app/FriendsManager
    //   22: aload_0
    //   23: getfield 57	com/tencent/mobileqq/app/SVIPHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: invokevirtual 199	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   29: invokevirtual 202	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnonnull +9 -> 43
    //   37: iconst_0
    //   38: istore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_2
    //   42: ireturn
    //   43: aload_0
    //   44: aload_1
    //   45: getfield 207	com/tencent/mobileqq/data/ExtensionInfo:uVipFont	J
    //   48: l2i
    //   49: putfield 44	com/tencent/mobileqq/app/SVIPHandler:j	I
    //   52: aload_0
    //   53: aload_1
    //   54: getfield 210	com/tencent/mobileqq/data/ExtensionInfo:vipFontType	I
    //   57: putfield 46	com/tencent/mobileqq/app/SVIPHandler:k	I
    //   60: aload_0
    //   61: getfield 44	com/tencent/mobileqq/app/SVIPHandler:j	I
    //   64: istore_2
    //   65: goto -26 -> 39
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	SVIPHandler
    //   32	22	1	localExtensionInfo	ExtensionInfo
    //   68	4	1	localObject	Object
    //   38	27	2	m	int
    // Exception table:
    //   from	to	target	type
    //   2	33	68	finally
    //   43	60	68	finally
    //   60	65	68	finally
  }
  
  protected Class a()
  {
    return SVIPObserver.class;
  }
  
  public void a()
  {
    VipFontUpdate.TFontSsoReq localTFontSsoReq = new VipFontUpdate.TFontSsoReq();
    localTFontSsoReq.u32_cmd.set(1);
    Object localObject1 = new Random();
    localTFontSsoReq.u64_seq.set(((Random)localObject1).nextInt(1000));
    localTFontSsoReq.i32_implat.set(109);
    localTFontSsoReq.str_osver.set(String.valueOf(Build.VERSION.SDK_INT));
    localTFontSsoReq.str_mqqver.set("6.5.5.2880");
    localObject1 = new VipFontUpdate.TFontFreshReq();
    ((VipFontUpdate.TFontFreshReq)localObject1).i32_local_font_id.set(a());
    localTFontSsoReq.st_fresh_req.set((MessageMicro)localObject1);
    localObject1 = new VipFontUpdate.TFontMd5CheckReq();
    VipFontUpdate.TFontMd5CheckReq.TMd5Info localTMd5Info = new VipFontUpdate.TFontMd5CheckReq.TMd5Info();
    localTMd5Info.i32_font_id.set(a());
    Object localObject2 = ((FontManager)this.b.getManager(41)).a(a());
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = new File(((FontInfo)localObject2).a);
      if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile())) {
        break label343;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new FileInputStream((File)localObject3);
        localObject3 = MD5.toMD5Byte((InputStream)localObject2, ((File)localObject3).length());
        if (QLog.isColorLevel()) {
          QLog.d("SVIPHandler", 2, "fontFile MD5 = " + StructLongMessageDownloadProcessor.a((byte[])localObject3));
        }
        localTMd5Info.bytes_md5.set(ByteStringMicro.copyFrom((byte[])localObject3));
        ((FileInputStream)localObject2).close();
      }
      catch (Exception localException)
      {
        QLog.e("SVIPHandler", 1, "pbGetUserFont error" + localException.getMessage());
        continue;
      }
      ((VipFontUpdate.TFontMd5CheckReq)localObject1).rpt_md5_info.add(localTMd5Info);
      localTFontSsoReq.st_Md5_Check_req.set((MessageMicro)localObject1);
      localObject1 = new ToServiceMsg("mobileqq.service", this.b.a(), "Font.fresh");
      ((ToServiceMsg)localObject1).putWupBuffer(localTFontSsoReq.toByteArray());
      b((ToServiceMsg)localObject1);
      return;
      label343:
      if (QLog.isColorLevel()) {
        QLog.e("SVIPHandler", 2, "fontFile exists = " + ((File)localObject3).exists() + " ,isFile = " + ((File)localObject3).isFile());
      }
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (paramInt != this.h)
      {
        this.h = paramInt;
        this.b.a().getSharedPreferences(this.b.a(), 0).edit().putInt("svip_bubble_id", paramInt).commit();
      }
      this.a = false;
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SVIPHandler", 2, "setSelfFontInfo id = " + paramInt1 + " type = " + paramInt2);
      }
      if ((paramInt1 != this.j) || (paramInt2 != this.k))
      {
        FriendsManager localFriendsManager = (FriendsManager)this.b.getManager(50);
        ExtensionInfo localExtensionInfo2 = localFriendsManager.a(this.b.getAccount());
        ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
        if (localExtensionInfo2 == null)
        {
          localExtensionInfo1 = new ExtensionInfo();
          localExtensionInfo1.uin = this.b.getAccount();
        }
        localExtensionInfo1.uVipFont = paramInt1;
        localExtensionInfo1.vipFontType = paramInt2;
        localFriendsManager.a(localExtensionInfo1);
      }
      this.a = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 42	com/tencent/mobileqq/app/SVIPHandler:i	I
    //   7: if_icmpeq +101 -> 108
    //   10: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +29 -> 42
    //   16: ldc 13
    //   18: iconst_2
    //   19: new 73	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 424
    //   29: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_1
    //   33: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: iload_1
    //   44: putfield 42	com/tencent/mobileqq/app/SVIPHandler:i	I
    //   47: aload_0
    //   48: getfield 57	com/tencent/mobileqq/app/SVIPHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   51: invokevirtual 384	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   54: aload_0
    //   55: getfield 57	com/tencent/mobileqq/app/SVIPHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   58: invokevirtual 360	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   61: iconst_0
    //   62: invokevirtual 390	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   65: invokeinterface 396 1 0
    //   70: ldc_w 426
    //   73: iload_1
    //   74: invokeinterface 404 3 0
    //   79: invokeinterface 407 1 0
    //   84: pop
    //   85: iload_1
    //   86: ifle +22 -> 108
    //   89: iload_2
    //   90: ifeq +26 -> 116
    //   93: new 428	qfx
    //   96: dup
    //   97: aload_0
    //   98: iload_1
    //   99: invokespecial 431	qfx:<init>	(Lcom/tencent/mobileqq/app/SVIPHandler;I)V
    //   102: iconst_5
    //   103: aconst_null
    //   104: iconst_0
    //   105: invokestatic 436	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   108: aload_0
    //   109: iconst_0
    //   110: putfield 409	com/tencent/mobileqq/app/SVIPHandler:a	Z
    //   113: aload_0
    //   114: monitorexit
    //   115: return
    //   116: invokestatic 441	com/tencent/mobileqq/bubble/BubbleDiyFetcher:a	()Lcom/tencent/mobileqq/bubble/BubbleDiyFetcher;
    //   119: aload_0
    //   120: getfield 57	com/tencent/mobileqq/app/SVIPHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   123: iload_1
    //   124: aconst_null
    //   125: invokevirtual 444	com/tencent/mobileqq/bubble/BubbleDiyFetcher:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILcom/tencent/mobileqq/app/BusinessObserver;)V
    //   128: goto -20 -> 108
    //   131: astore_3
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_3
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	SVIPHandler
    //   0	136	1	paramInt	int
    //   0	136	2	paramBoolean	boolean
    //   131	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	42	131	finally
    //   42	85	131	finally
    //   93	108	131	finally
    //   108	113	131	finally
    //   116	128	131	finally
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (((AnonymousChatHelper.a(paramMessageRecord)) && (AnonymousChatHelper.b(paramMessageRecord))) || (paramMessageRecord.istroop == 1001)) {
      return;
    }
    if (!(paramMessageRecord instanceof MessageForPtt))
    {
      paramMessageRecord.vipBubbleID = a(e(), g());
      paramMessageRecord.vipBubbleDiyTextId = g();
      return;
    }
    paramMessageRecord.vipBubbleID = e();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("Font.fresh".equals(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void b()
  {
    ToServiceMsg localToServiceMsg = a("ChatAvatar.ReqResUpdate");
    localToServiceMsg.extraData.putInt("req_res_order_seqid", 0);
    a(localToServiceMsg);
  }
  
  public int e()
  {
    try
    {
      if (this.h == -1) {
        this.h = this.b.a().getSharedPreferences(this.b.a(), 0).getInt("svip_bubble_id", 0);
      }
      int m = this.h;
      return m;
    }
    finally {}
  }
  
  /* Error */
  public int f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 509	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   5: getstatic 515	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:MsgLengthByBubble	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   8: invokevirtual 518	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   11: ldc_w 520
    //   14: invokevirtual 523	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_1
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_1
    //   21: invokestatic 529	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   24: istore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_2
    //   28: ireturn
    //   29: astore_1
    //   30: iload_3
    //   31: istore_2
    //   32: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq -10 -> 25
    //   38: ldc 13
    //   40: iconst_2
    //   41: aload_1
    //   42: invokevirtual 530	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   45: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: iload_3
    //   49: istore_2
    //   50: goto -25 -> 25
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	SVIPHandler
    //   17	4	1	str	String
    //   29	13	1	localNumberFormatException	NumberFormatException
    //   53	4	1	localObject	Object
    //   24	26	2	m	int
    //   19	30	3	n	int
    // Exception table:
    //   from	to	target	type
    //   20	25	29	java/lang/NumberFormatException
    //   2	18	53	finally
    //   20	25	53	finally
    //   32	48	53	finally
  }
  
  public int g()
  {
    try
    {
      if (this.i == -1) {
        this.i = this.b.a().getSharedPreferences(this.b.a(), 0).getInt("svip_bubble_diy_text_id", 0);
      }
      int m = this.i;
      return m;
    }
    finally {}
  }
  
  public int h()
  {
    int m = VipUtils.a(this.b, null);
    if ((m & 0x4) != 0) {
      return 3;
    }
    if ((m & 0x2) != 0) {
      return 1;
    }
    if ((m & 0x1) != 0) {
      return 2;
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\SVIPHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */